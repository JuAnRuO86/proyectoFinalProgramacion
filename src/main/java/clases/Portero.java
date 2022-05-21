package clases;

import enums.Posicion;

public class Portero extends Jugador{

	private byte estirada;
	private byte parada;
	private byte reflejos;
	private byte posicionamiento;
	
	public Portero(String nombre, String apellidos, String nacionalidad) {
		super(nombre, apellidos, nacionalidad, Posicion.PORTERO);
		this.setEstirada(estirada);
		this.setParada(parada);
		this.setReflejos(reflejos);
		this.setPosicionamiento(posicionamiento);
		super.setValoracion(valoracionObtenida(estirada,parada,reflejos,posicionamiento));
		super.setPrecio(precioJugador(super.getValoracion()));
	}

	public byte getEstirada() {
		return estirada;
	}

	public void setEstirada(byte estirada) {
		this.estirada = ponerEstadistica((byte)50,(byte)99);
	}

	public byte getParada() {
		return parada;
	}

	public void setParada(byte parada) {
		this.parada = ponerEstadistica((byte)50,(byte)99);
	}

	public byte getReflejos() {
		return reflejos;
	}

	public void setReflejos(byte reflejos) {
		this.reflejos = ponerEstadistica((byte)50,(byte)99);
	}

	public byte getPosicionamiento() {
		return posicionamiento;
	}

	public void setPosicionamiento(byte posicionamiento) {
		this.posicionamiento = ponerEstadistica((byte)50,(byte)99);
	}
	
	
	public byte valoracionObtenida(byte estirada,byte parada,byte reflejos,byte posicionamiento) {
		return (byte)((estirada+parada+reflejos+posicionamiento)/3.4f);
	}
	
	@Override
	public String toString() {
		return this.getNombre()+" "+this.getApellidos()+" *"+super.getValoracion()+"* "+"(Precio -> "+super.getPrecio()+"€)"+"\n[estirada=" + estirada + " parada=" + parada + "]\n[reflejos=" + reflejos + " posicionamiento=" + posicionamiento
				+ "]";
	}
}
