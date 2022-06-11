package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import utils.ConexionBD;

public class Funciones {

	public static ArrayList<Equipo> getEquipos(){
		ArrayList<Equipo> ret=new ArrayList<Equipo>();

		Statement smt=ConexionBD.conectar();

		try {
			ResultSet cursor=smt.executeQuery("select * from equipo");
			while(cursor.next()) {
				Equipo e=new Equipo();
				e.nombre=cursor.getString("nombre");
				e.presupuesto=cursor.getInt("presupuesto");
				e.valoracion=cursor.getShort("valoracion");
				ret.add(e);
			}
				
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		ConexionBD.desconectar();
		
		
		return ret;
	}
	public static ArrayList<Equipo> generarEquipos(Equipo equipoUsuario) throws SQLException{
		Random r=new Random();
		Entrenador[] entrenadores=new Entrenador[7];
		for(byte i=0;i<7;i++) {
			entrenadores[i]=new Entrenador(Persona.generarNombresAleatorios(),Persona.apellidosAleatorios(),Persona.generarNacionalidades());
		}
		ArrayList<Equipo> equipos=new ArrayList<Equipo>();
		ArrayList<String> nombres=new ArrayList<String>();
		for(byte i=0;i<7;i++) {			
			if(i==0) {
				equipos.add(new Equipo(Equipo.generarNombresEquiposAleatorio(),r.nextInt(1000000-50000)+50000,entrenadores[i]));	
				nombres.add(equipos.get(0).nombre);
			}else {
				equipos.add(new Equipo(Equipo.generarNombresEquiposAleatorio(nombres),r.nextInt(1000000-50000)+50000,entrenadores[i]));
				nombres.add(equipos.get(i).nombre);
			}
		}
		equipos.add(equipoUsuario);
		return equipos;
	}
		
	public static ArrayList<Partido> getPartidos(ArrayList<Equipo> equipos) throws SQLException{
		ArrayList<Partido> ret=new ArrayList<Partido>();

		Fase cuartosDeFinal=new Fase("cuartos");
		Fase semifinales=new Fase("semifinales");
		Fase finales=new Fase("final");
		Partido[] cuartos=Funciones.jugarFase(equipos,cuartosDeFinal);
		Partido[] semis=Funciones.jugarFase(Funciones.getEquiposGanadores(cuartosDeFinal),semifinales);
		Partido[] granFinal=Funciones.jugarFase(Funciones.getEquiposGanadores(semifinales),finales);
		for(byte i=0;i<cuartos.length;i++) {
			System.out.println(cuartos[i]);
			ret.add(cuartos[i]);
		}
		for(byte i=0;i<semis.length;i++) {
			System.out.println(semis[i]);
			ret.add(semis[i]);
		}
		for(byte i=0;i<granFinal.length;i++) {
			System.out.println(granFinal[i]);
			ret.add(granFinal[i]);
		}

		return ret;
	}

	public static Partido[] jugarFase(ArrayList<Equipo> equipos,Fase fase) throws SQLException{
		Partido ret=new Partido();
		Partido[] partidos=new Partido[0];
		switch(fase.nombre) {
		case "cuartos":
			partidos=new Partido[4];
			ret.fase=fase;
			for(byte i=1;i<=4;i++) {
				for(byte j=0;j<2;j++) {
					if(j==0) {
						ret.equipoLocal=equipos.get(j);
					}else {
						ret.equipoVisitante=equipos.get(j);
						equipos.remove(j);
						equipos.remove(j-1);
					}
				}
				ret.setGolesLocal(ret.generadorGolesLocal(ret.equipoLocal,ret.equipoVisitante));
				ret.setGolesVisitante(ret.generadorGolesVisitante(ret.equipoLocal,ret.equipoVisitante));
				if(ret.getGolesLocal()>ret.getGolesVisitante()) {
					ret.ganador=ret.equipoLocal;
				}else if(ret.getGolesLocal()<ret.getGolesVisitante()){
					ret.ganador=ret.equipoVisitante;
				}else {
					if(ret.equipoLocal.valoracion>ret.equipoVisitante.valoracion) {
						ret.ganador=ret.equipoLocal;
					}else {
						ret.ganador=ret.equipoVisitante;
					}
				}			
				Statement smt = ConexionBD.conectar();
				if (smt.executeUpdate(
						"insert into partido (equipoLocal,golesLocal,equipoVisitante,golesVisitante,ganador,nombreFase) values('" + ret.equipoLocal.getNombre() 
						+ "'," + ret.golesLocal +",'"+ ret.equipoVisitante.getNombre() +"'," + ret.golesVisitante+",'"+ret.ganador.getNombre()+"','"+fase.nombre+"')") > 0) {				
				}else {
					ConexionBD.desconectar();
					throw new SQLException("No se ha podido iniciar el partido por altercado del público");
				}
				ConexionBD.desconectar();			
				Statement smt2= ConexionBD.conectar();
				try {
					ResultSet cursor=smt2.executeQuery("select * from partido where nºpartido="+i);
					while(cursor.next()) {
						Partido p=new Partido();
						p.equipoLocal=ret.equipoLocal;
						p.equipoVisitante=ret.equipoVisitante;
						p.ganador=ret.ganador;
						p.fase=ret.fase;
						p.equipoLocal.nombre=cursor.getString("equipoLocal");
						p.golesLocal=cursor.getByte("golesLocal");
						p.equipoVisitante.nombre=cursor.getString("equipoVisitante");
						p.golesVisitante=cursor.getByte("golesVisitante");
						p.ganador.nombre=cursor.getString("ganador");	
						p.fase.nombre=cursor.getString("nombreFase");
						partidos[i-1]=p;
					}
						cursor.close();
				} catch (SQLException ex) {
					//Aqui no deberia entrar nunca porque la consulta siempre va a ser correcta
					ex.printStackTrace();
				}
				
				ConexionBD.desconectar();
			
			}

		break;
		case "semifinales":
			partidos=new Partido[2];
			ret.fase=fase;
			for(byte i=5;i<=6;i++) {
				for(byte j=0;j<2;j++) {
					if(j==0) {
						ret.equipoLocal=equipos.get(j);
					}else {
						ret.equipoVisitante=equipos.get(j);
						equipos.remove(j);
						equipos.remove(j-1);
					}
				}
				ret.setGolesLocal(ret.generadorGolesLocal(ret.equipoLocal,ret.equipoVisitante));
				ret.setGolesVisitante(ret.generadorGolesVisitante(ret.equipoLocal,ret.equipoVisitante));
				if(ret.getGolesLocal()>ret.getGolesVisitante()) {
					ret.ganador=ret.equipoLocal;
				}else if(ret.getGolesLocal()<ret.getGolesVisitante()){
					ret.ganador=ret.equipoVisitante;
				}else {
					if(ret.equipoLocal.valoracion>ret.equipoVisitante.valoracion) {
						ret.ganador=ret.equipoLocal;
					}else {
						ret.ganador=ret.equipoVisitante;
					}
				}			
				Statement smt = ConexionBD.conectar();
				if (smt.executeUpdate(
						"insert into partido (equipoLocal,golesLocal,equipoVisitante,golesVisitante,ganador,nombreFase) values('" + ret.equipoLocal.getNombre() 
						+ "'," + ret.golesLocal +",'"+ ret.equipoVisitante.getNombre() +"'," + ret.golesVisitante+",'"+ret.ganador.getNombre()+"','"+fase.nombre+"')") > 0) {				
				}else {
					ConexionBD.desconectar();
					throw new SQLException("No se ha podido iniciar el partido por altercado del público");
				}
				ConexionBD.desconectar();			
				Statement smt2= ConexionBD.conectar();
				try {
					ResultSet cursor=smt2.executeQuery("select * from partido where nºpartido="+i);
					while(cursor.next()) {
						Partido p=new Partido();
						p.equipoLocal=ret.equipoLocal;
						p.equipoVisitante=ret.equipoVisitante;
						p.ganador=ret.ganador;
						p.fase=ret.fase;
						p.equipoLocal.nombre=cursor.getString("equipoLocal");
						p.golesLocal=cursor.getByte("golesLocal");
						p.equipoVisitante.nombre=cursor.getString("equipoVisitante");
						p.golesVisitante=cursor.getByte("golesVisitante");
						p.ganador.nombre=cursor.getString("ganador");
						p.fase.nombre=cursor.getString("nombreFase");
						partidos[i-5]=p;
					}
						cursor.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				
				ConexionBD.desconectar();
			
			}
			break;
		case "final":
			partidos=new Partido[1];
			ret.fase=fase;
			for(byte i=7;i==7;i++) {
				for(byte j=0;j<2;j++) {
					if(j==0) {
						ret.equipoLocal=equipos.get(j);
					}else {
						ret.equipoVisitante=equipos.get(j);
						equipos.remove(j);
						equipos.remove(j-1);
					}
				}
				ret.setGolesLocal(ret.generadorGolesLocal(ret.equipoLocal,ret.equipoVisitante));
				ret.setGolesVisitante(ret.generadorGolesVisitante(ret.equipoLocal,ret.equipoVisitante));
				if(ret.getGolesLocal()>ret.getGolesVisitante()) {
					ret.ganador=ret.equipoLocal;
				}else if(ret.getGolesLocal()<ret.getGolesVisitante()){
					ret.ganador=ret.equipoVisitante;
				}else {
					if(ret.equipoLocal.valoracion>ret.equipoVisitante.valoracion) {
						ret.ganador=ret.equipoLocal;
					}else {
						ret.ganador=ret.equipoVisitante;
					}
				}			
				Statement smt = ConexionBD.conectar();
				if (smt.executeUpdate(
						"insert into partido (equipoLocal,golesLocal,equipoVisitante,golesVisitante,ganador,nombreFase) values('" + ret.equipoLocal.getNombre() 
						+ "'," + ret.golesLocal +",'"+ ret.equipoVisitante.getNombre() +"'," + ret.golesVisitante+",'"+ret.ganador.getNombre()+"','"+fase.nombre+"')") > 0) {				
				}else {
					ConexionBD.desconectar();
					throw new SQLException("No se ha podido iniciar el partido por altercado del público");
				}
				ConexionBD.desconectar();			
				Statement smt2= ConexionBD.conectar();
				try {
					ResultSet cursor=smt2.executeQuery("select * from partido where nºpartido="+i);
					while(cursor.next()) {
						Partido p=new Partido();
						p.equipoLocal=ret.equipoLocal;
						p.equipoVisitante=ret.equipoVisitante;
						p.ganador=ret.ganador;
						p.fase=ret.fase;
						p.equipoLocal.nombre=cursor.getString("equipoLocal");
						p.golesLocal=cursor.getByte("golesLocal");
						p.equipoVisitante.nombre=cursor.getString("equipoVisitante");
						p.golesVisitante=cursor.getByte("golesVisitante");
						p.ganador.nombre=cursor.getString("ganador");
						p.fase.nombre=cursor.getString("nombreFase");
						partidos[0]=p;
					}
						cursor.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				
				ConexionBD.desconectar();
			
			}
			break;
		
		
		
		}
		
		
		
		
		return partidos;
		
	}

	public static ArrayList<Equipo> getEquiposGanadores(Fase fase) throws SQLException{
				
		String gan="";
		ArrayList<Equipo> equipos = new ArrayList<Equipo>();
		switch(fase.nombre) {
		case "cuartos":
			for(byte i=1;i<=4;i++) {
				
				Statement smt = ConexionBD.conectar();
				
				ResultSet cursor=smt.executeQuery("select * from partido where nºpartido="+i);
				if(cursor.next()) {
					gan=cursor.getString("ganador");
					cursor.close();
					ResultSet cursor2 = smt.executeQuery("select * from equipo where nombre='"+gan+"'");
					while(cursor2.next()) {
						equipos.add(new Equipo(cursor2.getString("nombre"),cursor2.getShort("valoracion")));
					}
					cursor2.close();
				}else {
					ConexionBD.desconectar();			
				}
				ConexionBD.desconectar();			
			}
			break;
		case "semifinales":
			for(byte i=5;i<=6;i++) {
				
				Statement smt = ConexionBD.conectar();
				
				ResultSet cursor=smt.executeQuery("select ganador from partido where nºpartido="+i);
				if(cursor.next()) {
					gan=cursor.getString("ganador");
					cursor.close();
					ResultSet cursor2 = smt.executeQuery("select * from equipo where nombre='"+gan+"'");
					while(cursor2.next()) {
						equipos.add(new Equipo(cursor2.getString("nombre"),cursor2.getShort("valoracion")));
					}
					cursor2.close();
				}else {
					ConexionBD.desconectar();			
				}				
				ConexionBD.desconectar();			

			}
			break;
		case "final":
			for(byte i=7;i==7;i++) {
				
				Statement smt = ConexionBD.conectar();
				
				ResultSet cursor=smt.executeQuery("select ganador from partido where nºpartido="+i);
				if(cursor.next()) {
					gan=cursor.getString("ganador");
					cursor.close();
					ResultSet cursor2 = smt.executeQuery("select * from equipo where nombre='"+gan+"'");
					while(cursor2.next()) {
						equipos.add(new Equipo(cursor2.getString("nombre"),cursor2.getShort("valoracion")));
					}
					cursor2.close();
				}else {
					ConexionBD.desconectar();			
				}				
				ConexionBD.desconectar();			
			}
			break;
		}
		
		return equipos;
		
	}
	
	
	public static ArrayList<Persona> generarMercado(){
		ArrayList<Persona> mer=new ArrayList<Persona>();

		for(byte i=0;i<10;i++) {
			try {
				mer.add(new JugadorDeCampo(Persona.generarNombresAleatorios(),Persona.apellidosAleatorios(),Persona.generarNacionalidades()));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			if(i>=7) {
//				try {
//					mer.add(new Entrenador(Persona.generarNombresAleatorios(),Persona.apellidosAleatorios(),Persona.generarNacionalidades()));
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
		}
		
		
		
		
		
		return mer;
	}
	
	
	
	
	
	
	
	
	
}
