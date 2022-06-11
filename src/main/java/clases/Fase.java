package clases;

import java.sql.SQLException;
import java.sql.Statement;

import utils.ConexionBD;

/**
 * Clase cuyas instancias representan una fase del torneo
 * @author juaan
 *
 */
public class Fase extends ElementoConNombre{

	/** Los partidos que contendrá cada fase**/
	private Partido[] partidos;

	/**
	 * Constructor vacío para llamarlo en las subclases 
	 */
	public Fase() {
		super();
	}
	/**
	 * Constructor de fase que creará la fase con el nombre que se le pase por argumentos
	 * @param nombre
	 * @throws SQLException
	 */
	public Fase(String nombre) throws SQLException {
		super();
		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate(
				"insert into fase (nombre,nombreTorneo) values('" + nombre +"','Uefa Champions League')") > 0) {
			
			this.setNombre(nombre);
			
		}else {
			
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido insertar la fase");
		}
		ConexionBD.desconectar();
	}
	
	/**
	 * Getter de partidos
	 * @return los partidos de la fase
	 */
	public Partido[] getPartidos() {
		return partidos;
	}
	/**
	 * Setter de partidos
	 * @param partidos que contiene la fase
	 */
	public void setPartidos(Partido[] partidos) {
		this.partidos = partidos;
	}
	
	
}
