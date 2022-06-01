package clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import utils.ConexionBD;

public class Torneo extends ElementoConNombre{

	private Fase[] fases;

	public Torneo(String nombre) throws SQLException {
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
	
	
	public static void jugarTorneo() throws SQLException {
		Random r=new Random();
		Entrenador[] entrenadores=new Entrenador[8];
		for(byte i=0;i<8;i++) {
			entrenadores[i]=new Entrenador(Persona.generarNombresAleatorios(),Persona.apellidosAleatorios(),Persona.generarNacionalidades());
		}
		ArrayList<Equipo> equipos=new ArrayList<Equipo>();
		for(byte i=0;i<8;i++) {			
			ArrayList<String> nombres=new ArrayList<String>();
			if(i==0) {
				equipos.add(new Equipo(Equipo.generarNombresEquiposAleatorio(),r.nextInt(1000000-50000)+50000,entrenadores[i]));	
				nombres.add(equipos.get(0).nombre);
			}else {
				equipos.add(new Equipo(Equipo.generarNombresEquiposAleatorio(nombres),r.nextInt(1000000-50000)+50000,entrenadores[i]));
				nombres.add(equipos.get(i).nombre);
			}
		}
		
		Fase cuartosDeFinal=new Fase("cuartos");
		Fase semifinales=new Fase("semifinales");
		Fase finales=new Fase("final");
		Partido[] cuartos=Funciones.jugarFase(equipos,cuartosDeFinal);
		Partido[] semis=Funciones.jugarFase(Funciones.getEquiposGanadores(cuartosDeFinal),semifinales);
		Partido[] granFinal=Funciones.jugarFase(Funciones.getEquiposGanadores(semifinales),finales);

		
		
		
		
		
		
		
	}
	
	
	
	
	
}
