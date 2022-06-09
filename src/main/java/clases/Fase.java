package clases;

import java.sql.SQLException;
import java.sql.Statement;

import utils.ConexionBD;

public class Fase extends ElementoConNombre{

	private Partido[] partidos;

	public Fase() {
		super();
	}
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
	public Fase(String nombre, Partido[] partidos) {
		super(nombre);
		this.setPartidos(partidos);
	}
	
	public Partido[] getPartidos() {
		return partidos;
	}

	public void setPartidos(Partido[] partidos) {
		this.partidos = partidos;
	}
	
	
}
