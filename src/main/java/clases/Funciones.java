package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
			//Aqui no deberia entrar nunca porque la consulta siempre va a ser correcta
			ex.printStackTrace();
		}
		
		ConexionBD.desconectar();
		
		
		return ret;
	}

	public static ArrayList<Partido> jugarFase(ArrayList<Equipo> equipos,String fase) throws SQLException{
		Partido ret=new Partido();
		ArrayList<Partido> partidos=new ArrayList<Partido>();
		switch(fase) {
		case "cuartos":
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
						"insert into partido (equipoLocal,golesLocal,equipoVisitante,golesVisitante,ganador) values('" + ret.equipoLocal.getNombre() 
						+ "'," + ret.golesLocal +",'"+ ret.equipoVisitante.getNombre() +"'," + ret.golesVisitante+",'"+ret.ganador.getNombre()+"')") > 0) {				
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
						p.equipoLocal.nombre=cursor.getString("equipoLocal");
						p.golesLocal=cursor.getByte("golesLocal");
						p.equipoVisitante.nombre=cursor.getString("equipoVisitante");
						p.golesVisitante=cursor.getByte("golesVisitante");
						p.ganador.nombre=cursor.getString("ganador");
						partidos.add(p);
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
						"insert into partido (equipoLocal,golesLocal,equipoVisitante,golesVisitante,ganador) values('" + ret.equipoLocal.getNombre() 
						+ "'," + ret.golesLocal +",'"+ ret.equipoVisitante.getNombre() +"'," + ret.golesVisitante+",'"+ret.ganador.getNombre()+"')") > 0) {				
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
						p.equipoLocal.nombre=cursor.getString("equipoLocal");
						p.golesLocal=cursor.getByte("golesLocal");
						p.equipoVisitante.nombre=cursor.getString("equipoVisitante");
						p.golesVisitante=cursor.getByte("golesVisitante");
						p.ganador.nombre=cursor.getString("ganador");
						partidos.add(p);
					}
						cursor.close();
				} catch (SQLException ex) {
					//Aqui no deberia entrar nunca porque la consulta siempre va a ser correcta
					ex.printStackTrace();
				}
				
				ConexionBD.desconectar();
			
			}
			break;
		case "final":
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
						"insert into partido (equipoLocal,golesLocal,equipoVisitante,golesVisitante,ganador) values('" + ret.equipoLocal.getNombre() 
						+ "'," + ret.golesLocal +",'"+ ret.equipoVisitante.getNombre() +"'," + ret.golesVisitante+",'"+ret.ganador.getNombre()+"')") > 0) {				
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
						p.equipoLocal.nombre=cursor.getString("equipoLocal");
						p.golesLocal=cursor.getByte("golesLocal");
						p.equipoVisitante.nombre=cursor.getString("equipoVisitante");
						p.golesVisitante=cursor.getByte("golesVisitante");
						p.ganador.nombre=cursor.getString("ganador");
						partidos.add(p);
					}
						cursor.close();
				} catch (SQLException ex) {
					//Aqui no deberia entrar nunca porque la consulta siempre va a ser correcta
					ex.printStackTrace();
				}
				
				ConexionBD.desconectar();
			
			}
			break;
		
		
		
		}
		
		
		
		
		return partidos;
		
	}

	public static ArrayList<Equipo> getEquiposGanadores(String fase) throws SQLException{
				
		String gan="";
		ArrayList<Equipo> equipos = new ArrayList<Equipo>();
		switch(fase) {
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
	
	
	
}
