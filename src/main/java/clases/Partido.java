package clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import utils.ConexionBD;

public class Partido {

	protected Equipo equipoLocal;
	protected Equipo equipoVisitante;
	protected byte golesLocal;
	protected byte golesVisitante;
	protected Equipo ganador;
	
	public Partido() {
	}
	public Partido(Equipo equipoLocal, Equipo equipoVisitante) throws SQLException {
		super();
		
		this.setGolesLocal((byte)generadorGolesLocal(equipoLocal,equipoVisitante));
		this.setGolesVisitante((byte)generadorGolesVisitante(equipoLocal,equipoVisitante));
		//this.setGanador(generarGanador(golesLocal,golesVisitante));
//		ganador.añadirPuntosGanador(ganador);
		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate(
				"insert into partido (equipoLocal,golesLocal,equipoVisitante,golesVisitante) values('" + equipoLocal.getNombre() + "'," + golesLocal +",'"+ equipoVisitante.getNombre() +"'," + golesVisitante+ ")") > 0) {
			
			this.setEquipoLocal(equipoLocal);
			this.setEquipoVisitante(equipoVisitante);
			
			
		}else {
			
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido insertar el equipo");
		}
		ConexionBD.desconectar();
		
	}
	public Equipo getEquipoLocal() {
		return equipoLocal;
	}
	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}
	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}
	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}
	public byte getGolesLocal() {
		return golesLocal;
	}
	public void setGolesLocal(byte golesLocal) {
		this.golesLocal = golesLocal;
	}
	public byte getGolesVisitante() {
		return golesVisitante;
	}
	public void setGolesVisitante(byte golesVisitante) {
		this.golesVisitante = golesVisitante;
	}
	public Equipo getGanador() {
		return ganador;
	}
	public void setGanador(Equipo ganador) {
		this.ganador = ganador;
	}
	
//La idea es dependiendo de la valoracion de cada equipo tendra mas oportunidad de meter goles que el otro, se pondrá varias secciones
//que seran determinadas por los 90 min(0 a 15min se tirara el random por si alguno marca, el que tenga mas valoración tendrá mas posibilidades,
//y si alguno marca se usara random para poner x minuto en el que ha metido 
//en el intervalo de esa seccion que es en este caso en los primeros 15min de partido
//si los dos marcan, el segundo equipo metera en el minuto > que el primero pero < que el min de la seccion 15)
//Lo último es modificable, habrá 3 secciones en cada tiempo(0-15,15-30,30-45) y habria descanso y luego igual hasta el min 90,
//En el descanso se parará el juego mostrando el marcador y el usuario tendra que reanudar para empezar la segunda parte.
	public byte generadorGolesLocal(Equipo elocal,Equipo evisitante) {
		Random r=new Random();
		byte gol1=0;
		for(byte i=1;i<=90;i++){
		//El equipo local tirará el primer random de si marca gol, el equipo con mas valoracion tendra mas oportunidad en el random de marcar
			if(elocal.getValoracion()>evisitante.getValoracion()) {
				if(r.nextInt(45)+1<=2) {
					gol1++;
				}
			}else {
				if(r.nextInt(45)+1==1) {
					gol1++;
				}
			}
		}
		
		return gol1;
	}
	public byte generadorGolesVisitante(Equipo elocal,Equipo evisitante) {
		Random r=new Random();
		byte gol2=0;
		for(byte i=1;i<=90;i++){
			if(elocal.getValoracion()>evisitante.getValoracion()) {
				if(r.nextInt(45)+1==1) {
					gol2++;
				}
			}else {
				if(r.nextInt(45)+1<=2) {
					gol2++;
				}
			}
		}
		
		return gol2;
	}
	
//	public Equipo generarGanador() {
//		if(golesLocal>golesVisitante) {
//			return equipoLocal;
//		}else if(golesLocal<golesVisitante){
//			return equipoVisitante;
//		}else {
//			return null;
//		}
//	}
	
//	public void generarPartido(ArrayList<Equipo> todos) throws SQLException{
//		
//		
//		for(byte i=1;i<=4;i++) {
//			for(byte j=0;j<2;j++) {
//				if(j==0) {
//					equipoLocal=todos.get(j);
//				}else {
//					equipoVisitante=todos.get(j);
//					todos.remove(j);
//					todos.remove(j-1);
//				}
//			}
//			setGolesLocal(generadorGolesLocal(equipoLocal,equipoVisitante));
//			setGolesVisitante(generadorGolesVisitante(equipoLocal,equipoVisitante));
//			ganador=generarGanador(golesLocal,golesVisitante);
//			ganador.añadirPuntos(ganador);
//			
//			Statement smt = ConexionBD.conectar();
//			if (smt.executeUpdate(
//					"insert into partido (equipoLocal,golesLocal,equipoVisitante,golesVisitante,ganador) values('" + equipoLocal.getNombre() 
//					+ "'," + golesLocal +",'"+ equipoVisitante.getNombre() +"'," + golesVisitante+",'"+ganador.getNombre()+"')") > 0) {				
//			}else {
//				ConexionBD.desconectar();
//				throw new SQLException("No se ha podido iniciar el partido por altercado del público");
//			}
//			ConexionBD.desconectar();
//		}
//		
//	}
	
	
	
	
	
	@Override
	public String toString() {
		return equipoLocal.getNombre() + " " +golesLocal+" - "+ equipoVisitante.getNombre() + " " + golesVisitante + ", ganador= " + ganador.getNombre();
	}

	
	

	
	
	
	
	
	
	
}

