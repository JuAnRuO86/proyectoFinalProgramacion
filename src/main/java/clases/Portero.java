package clases;

import enums.Posicion;

public class Portero extends Jugador{

	private byte estirada;
	private byte parada;
	private byte reflejos;
	private byte posicionamiento;
	
	public Portero(String nombre, String apellidos, String nacionalidad, byte valoracion, int precio, byte estirada, byte parada, byte reflejos, byte posicionamiento) {
		super(nombre, apellidos, nacionalidad, valoracion, precio, Posicion.PORTERO);
		this.setEstirada(estirada);
		this.setParada(parada);
		this.setReflejos(reflejos);
		this.setPosicionamiento(posicionamiento);
	}

	public byte getEstirada() {
		return estirada;
	}

	public void setEstirada(byte estirada) {
		this.estirada = estirada;
	}

	public byte getParada() {
		return parada;
	}

	public void setParada(byte parada) {
		this.parada = parada;
	}

	public byte getReflejos() {
		return reflejos;
	}

	public void setReflejos(byte reflejos) {
		this.reflejos = reflejos;
	}

	public byte getPosicionamiento() {
		return posicionamiento;
	}

	public void setPosicionamiento(byte posicionamiento) {
		this.posicionamiento = posicionamiento;
	}
	
	
	
}
