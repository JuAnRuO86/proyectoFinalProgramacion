package clases;

import enums.Posicion;

public class Jugador extends Persona{

	protected Posicion posicion;

	public Jugador(String nombre, String apellidos, String nacionalidad, int precio,Posicion posicion) {
		
		super(nombre, apellidos, nacionalidad, precio);
		this.setPosicion(posicion);
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
}
