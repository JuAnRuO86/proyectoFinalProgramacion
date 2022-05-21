package clases;

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
	
}
