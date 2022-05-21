package clases;

import java.util.Random;

import enums.Posicion;

public class Jugador extends Persona{

	protected Posicion posicion;

	public Jugador(String nombre, String apellidos, String nacionalidad,Posicion posicion) {
		
		super(nombre, apellidos, nacionalidad);
		this.setPosicion(posicion);
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	public byte ponerEstadistica(byte min,byte max) {
		Random r=new Random();
		return (byte)(r.nextInt(max+1-min)+min);
	}
	
}
