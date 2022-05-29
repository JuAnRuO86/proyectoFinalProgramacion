package principal;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import clases.Entrenador;
import clases.Equipo;
import clases.Jugador;
import clases.JugadorDeCampo;
import clases.Partido;
import clases.Persona;
import clases.Portero;
import enums.Posicion;
import interfacesgraficas.Ventana;
import utils.ConexionBD;
import clases.Funciones;

public class Principal {

	public static void main(String[] args) {
		
		 
//			JugadorDeCampo j1 = new JugadorDeCampo(Persona.generarNombresAleatorios(),Persona.apellidosAleatorios(),Persona.generarNacionalidades(),Posicion.DELANTERO);
//			System.out.println(j1.getValoracion());
//			System.out.println(j1.getPrecio());
//			System.out.println(j1);
//			JugadorDeCampo j2 = new JugadorDeCampo(Persona.generarNombresAleatorios(),Persona.apellidosAleatorios(),Persona.generarNacionalidades(),Posicion.CENTROCAMPISTA);
//			JugadorDeCampo j3 = new JugadorDeCampo(Persona.generarNombresAleatorios(),Persona.apellidosAleatorios(),Persona.generarNacionalidades(),Posicion.DEFENSA);
//			JugadorDeCampo j4 = new JugadorDeCampo(Persona.generarNombresAleatorios(),Persona.apellidosAleatorios(),Persona.generarNacionalidades(),Posicion.DEFENSA);

//			Portero pt=new Portero(Persona.generarNombresAleatorios(),Persona.apellidosAleatorios(),Persona.generarNacionalidades());
//			System.out.println(pt.getValoracion());
//			System.out.println(pt.getPrecio());
//			System.out.println(pt);
		

//			Entrenador klopp=new Entrenador(Persona.generarNombresAleatorios(),Persona.apellidosAleatorios(),Persona.generarNacionalidades());
			//System.out.println(ancelotti);
						
//			ArrayList<Jugador> jugadores= new ArrayList<Jugador>();
//			jugadores.add(j1);
//			jugadores.add(j2);
//			jugadores.add(j3);
//			jugadores.add(j4);
//			jugadores.add(pt);

//			Equipo realMadrid=new Equipo("Real Madrid",500000f,Equipo.generarEquipo(ancelotti),ancelotti);
//			System.out.println(realMadrid);
//			Equipo liverpool=new Equipo("Liverpool",750000f,Equipo.generarEquipo(klopp),klopp);
			
//			Partido finalUCL=new Partido(realMadrid,liverpool);
//			System.out.println(finalUCL);
			
		
		try {
//			JugadorDeCampo j1 = new JugadorDeCampo(Persona.generarNombresAleatorios(),Persona.apellidosAleatorios(),Persona.generarNacionalidades());
//			Portero pt1 = new Portero(Persona.generarNombresAleatorios(),Persona.apellidosAleatorios(),Persona.generarNacionalidades());
			Entrenador ancelotti=new Entrenador(Persona.generarNombresAleatorios(),Persona.apellidosAleatorios(),Persona.generarNacionalidades());
			Equipo realMadrid=new Equipo("Real Madrid", 500000,ancelotti);
			Equipo liverpool=new Equipo("Liverpool", 500000,ancelotti);
			Equipo villareal=new Equipo("Villareal", 500000,ancelotti);
			Equipo manchesterCity=new Equipo("Manchester City", 500000,ancelotti);
			Equipo chelsea=new Equipo("Chelsea", 500000,ancelotti);
			Equipo paris=new Equipo("Paris Saint-Germain", 500000,ancelotti);
			Equipo benfica=new Equipo("Benfica", 500000,ancelotti);
			Equipo malaga=new Equipo("Malaga FC", 500000,ancelotti);
//			System.out.println(j1);
//			System.out.println(pt1);
//			System.out.println(ancelotti);
//			System.out.println(realMadrid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
//			Ventana ventana=new Ventana();


		
	ArrayList<Equipo> todosEquipos=Funciones.getEquipos();
	
	for(byte i=0;i<todosEquipos.size();i++) {
		System.out.println(todosEquipos.get(i));
	}
	
		try {
			//Al ser la fase de cuartos serian 4 partidos y 8 equipos
			Funciones.jugarFase(todosEquipos,"cuartos");
			Funciones.jugarFase(Funciones.getEquiposGanadores("cuartos"),"semifinales");
			Funciones.jugarFase(Funciones.getEquiposGanadores("semifinales"), "final");
			System.out.println("El ganador del torneo es: "+Funciones.getEquiposGanadores("final"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	
	}











}
