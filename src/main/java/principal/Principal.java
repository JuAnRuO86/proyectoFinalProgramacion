package principal;

import java.util.ArrayList;
import java.util.Random;

import clases.Entrenador;
import clases.Equipo;
import clases.Jugador;
import clases.JugadorDeCampo;
import clases.Persona;
import clases.Portero;
import enums.Posicion;

public class Principal {

	public static void main(String[] args) {
		
		 
			JugadorDeCampo j1 = new JugadorDeCampo(Persona.generarNombresAleatorios(),Persona.apellidosAleatorios(),Persona.generarNacionalidades(),Posicion.DELANTERO);
//			System.out.println(j1.getValoracion());
//			System.out.println(j1.getPrecio());
//			System.out.println(j1);
			JugadorDeCampo j2 = new JugadorDeCampo(Persona.generarNombresAleatorios(),Persona.apellidosAleatorios(),Persona.generarNacionalidades(),Posicion.CENTROCAMPISTA);
			JugadorDeCampo j3 = new JugadorDeCampo(Persona.generarNombresAleatorios(),Persona.apellidosAleatorios(),Persona.generarNacionalidades(),Posicion.DEFENSA);
			JugadorDeCampo j4 = new JugadorDeCampo(Persona.generarNombresAleatorios(),Persona.apellidosAleatorios(),Persona.generarNacionalidades(),Posicion.DEFENSA);

			Portero pt=new Portero(Persona.generarNombresAleatorios(),Persona.apellidosAleatorios(),Persona.generarNacionalidades());
//			System.out.println(pt.getValoracion());
//			System.out.println(pt.getPrecio());
//			System.out.println(pt);
		

			Entrenador ancelotti=new Entrenador(Persona.generarNombresAleatorios(),Persona.apellidosAleatorios(),Persona.generarNacionalidades());
			//System.out.println(ancelotti);
						
			ArrayList<Jugador> jugadores= new ArrayList<Jugador>();
			jugadores.add(j1);
			jugadores.add(j2);
			jugadores.add(j3);
			jugadores.add(j4);
			jugadores.add(pt);

			Equipo realMadrid=new Equipo("Real Madrid",5000000f,jugadores,ancelotti);
			System.out.println(realMadrid);
			
			
			
			
		
	}

}
