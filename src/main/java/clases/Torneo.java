package clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import utils.ConexionBD;

public class Torneo extends ElementoConNombre{

	private Fase[] fases;

	public Torneo() throws SQLException {
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
	public Torneo(String nombre, Fase[] fases) {
		super(nombre);
		this.setFases(fases);

	}
	public Fase[] getFases() {
		return fases;
	}
	public void setFases(Fase[] fases) {
		this.fases = fases;
	}
	
	
	public static ArrayList<Partido> jugarTorneo(Equipo equipoUsuario) throws SQLException {
		Torneo UCL=new Torneo();
		ArrayList<Equipo> equipos=Funciones.generarEquipos(equipoUsuario);
		ArrayList<Partido> partidos=Funciones.getPartidos(equipos);
		return partidos;
	}
	
	
	
	
	
}
