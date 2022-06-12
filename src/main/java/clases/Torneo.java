package clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import excepciones.NombreValidoException;
import excepciones.PresupuestoInvalidoException;
import utils.ConexionBD;

/**
 * Clase cuya instancias representan un torneo, compuesto de varios equipos donde habrá solo un ganador
 * @author juaan
 *
 */
public class Torneo extends ElementoConNombre{

	/** Las fases de las que estará compuesta el torneo, son 3.**/
	private Fase[] fases;

	/**
	 * Constructor de torneo el cual creará automáticamente el torneo y lo insertará en la base de datos
	 * @throws SQLException
	 * @throws NombreValidoException 
	 */
	public Torneo() throws SQLException, NombreValidoException {
		super();
		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate(
				"insert into torneo (nombre) values('Uefa Champions League')") > 0) {
			
			this.setNombre(nombre);
			
		}else {
			
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido insertar el torneo");
		}
		ConexionBD.desconectar();
		
	}
	/**
	 * Getter de fases 
	 * @return las fases del torneo
	 */
	public Fase[] getFases() {
		return fases;
	}
	/**
	 * Setter de fases
	 * @param fases del torneo
	 */
	public void setFases(Fase[] fases) {
		this.fases = fases;
	}
	
	/**
	 * Función que ejecuta el torneo por completo llamando a otras funciones para complementarla
	 * @param equipoUsuario es el equipo que representará al usuario y creado por el mismo
	 * @return los partidos que se han jugado en el torneo
	 * @throws SQLException
	 * @throws NombreValidoException 
	 * @throws PresupuestoInvalidoException 
	 */
	public static ArrayList<Partido> jugarTorneo(Equipo equipoUsuario) throws SQLException, NombreValidoException, PresupuestoInvalidoException {
		Torneo UCL=new Torneo();
		ArrayList<Equipo> equipos=Funciones.generarEquipos(equipoUsuario);
		ArrayList<Partido> partidos=Funciones.getPartidos(equipos);
		return partidos;
	}
	
	
	
	
	
}
