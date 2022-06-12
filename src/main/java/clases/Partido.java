package clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import utils.ConexionBD;
/**
 * Clase que por las instancias que tiene determinar�n un partido de futbol en el que jugar�n dos equipos y uno ser� el ganador
 * @author juaan
 *
 */
public class Partido {
	/** el equipo local que jugar� en su estadio **/
	protected Equipo equipoLocal;
	/** el equipo visitante que jugar� en el estadio del rival **/
	protected Equipo equipoVisitante;
	/** los goles que ser�n marcados por el equipo local**/
	protected byte golesLocal;
	/** los goles que ser�n marcados por el equipo visitante **/
	protected byte golesVisitante;
	/** el equipo saldr� victorioso entre el equipo local y el equipos visitante **/
	protected Equipo ganador;
	/** la fase en la que el partido ser� jugado **/
	protected Fase fase;
	/**
	 * Constructor vac�o para llamarlo en las subclases
	 */
	public Partido() {
		super();
	}
	/**
	 * Constructor de partido que se le pasar� por argumentos el equipo local, el equipo visitante, el ganador entre ellos y la fase en la que se juega el partido
	 * @param equipoLocal el equipo local del partido
	 * @param equipoVisitante el equipo visitante del partido
	 * @param ganador el equipo ganador del partido
	 * @param fase la fase en la que se juega el partido
	 * @throws SQLException
	 */
	public Partido(Equipo equipoLocal, Equipo equipoVisitante,Equipo ganador, Fase fase) throws SQLException {
		super();
		
		this.setGolesLocal((byte)generadorGolesLocal(equipoLocal,equipoVisitante));
		this.setGolesVisitante((byte)generadorGolesVisitante(equipoLocal,equipoVisitante));
		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate(
				"insert into partido (equipoLocal,golesLocal,equipoVisitante,golesVisitante,ganador,nombreFase) values('" + equipoLocal.getNombre() + "'," + golesLocal +",'"+ equipoVisitante.getNombre() +"'," + golesVisitante+",'"+ganador.getNombre()+"','"+ fase.getNombre() +"')") > 0) {
			
			this.setEquipoLocal(equipoLocal);
			this.setEquipoVisitante(equipoVisitante);
			this.setGanador(ganador);
			this.fase=fase;
			
		}else {
			
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido insertar el partido");
		}
		ConexionBD.desconectar();
		
	}
	/**
	 * Getter de equipo local
	 * @return el equipo local del partido
	 */
	public Equipo getEquipoLocal() {
		return equipoLocal;
	}
	/**
	 * Setter de equipo local
	 * @param equipoLocal el equipo local del partido
	 */
	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}
	/**
	 * Getter de equipo visitante
	 * @return el equipo visitante del partido
	 */
	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}
	/**
	 * Setter de equipo visitante
	 * @param equipoVisitante el equipo visitante del partido
	 */
	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}
	/**
	 * Getter de goles local
	 * @return los goles del equipo local
	 */
	public byte getGolesLocal() {
		return golesLocal;
	}
	/**
	 * Setter de goles local
	 * @param golesLocal los goles del quipo local
	 */
	public void setGolesLocal(byte golesLocal) {
		this.golesLocal = golesLocal;
	}
	/**
	 * Getter de goles visitante
	 * @return los goles del equipo visitante
	 */
	public byte getGolesVisitante() {
		return golesVisitante;
	}
	/**
	 * Setter goles visitante
	 * @param golesVisitante los goles del equipo visitante
	 */
	public void setGolesVisitante(byte golesVisitante) {
		this.golesVisitante = golesVisitante;
	}
	/**
	 * Getter de ganador
	 * @return el equipo ganador
	 */
	public Equipo getGanador() {
		return ganador;
	}
	/**
	 * Setter de ganador
	 * @param ganador el equipo ganador
	 */
	public void setGanador(Equipo ganador) {
		this.ganador = ganador;
	}
	/**
	 * Getter de fase
	 * @return la fase en la que se jugar� el partido
	 */
	public Fase getFase() {
		return fase;
	}
	/**
	 * Setter de fase
	 * @param fase la fase en la que se jugar� el partido
	 */
	public void setFase(Fase fase) {
		this.fase=fase;
	}
	

	/**
	 * Funci�n que generar� los goles del equipo local, se le pasar� por argumentos el equipo local y el equipo vistante, este algoritmo funcionar� de la siguiente forma: El equipo con mas valoracion tendra mas oportunidad en el random de marcar, habr� 90 oportunidades simulando los 90 minutos de un partido real
	 * @param elocal equipo local del partido
	 * @param evisitante equipo visitante del partido
	 * @return
	 */
	public byte generadorGolesLocal(Equipo elocal,Equipo evisitante) {
		Random r=new Random();
		byte gol1=0;
		for(byte i=1;i<=90;i++){
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
	/**
	 * Funci�n que generar� los goles del equipo visitante, se le pasar� por argumentos el equipo local y el equipo vistante, este algoritmo funcionar� de la siguiente forma: El equipo con mas valoracion tendra mas oportunidad en el random de marcar, habr� 90 oportunidades simulando los 90 minutos de un partido real
	 * @param elocal equipo local del partido
	 * @param evisitante equipo visitante del partido
	 * @return
	 */
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
		
	/**
	 * toString de la clase partido, muestra formateada toda la informaci�n del mismo
	 * @return String con toda la informaci�n del partido
	 */
	@Override
	public String toString() {
		return "<"+fase.nombre+"> "+equipoLocal.getNombre() + " (" +golesLocal+") - "+ equipoVisitante.getNombre() + " (" + golesVisitante + ")		 ganador= " + ganador.getNombre();
	}

	
	

	
	
	
	
	
	
	
}

