package clases;

import enums.Posicion;

public class Jugador extends Persona{

	private Posicion posicion;

	public Jugador(String nombre, String apellidos, String nacionalidad, byte valoracion, int precio,Posicion posicion) {
		
		super(nombre, apellidos, nacionalidad, valoracion, precio);
		this.setPosicion(posicion);
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
}
