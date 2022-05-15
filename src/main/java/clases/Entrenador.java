package clases;

import excepciones.limiteJugadoresException;

public class Entrenador {

	private byte nivelTactico;
	private byte[] formacion;
	public Entrenador(byte nivelTactico, byte[] formacion) throws limiteJugadoresException {
		super();
		this.setNivelTactico(nivelTactico);
		this.setFormacion(formacion);
	}
	public byte getNivelTactico() {
		return nivelTactico;
	}
	public void setNivelTactico(byte nivelTactico) {
		this.nivelTactico = nivelTactico;
	}
	public byte[] getFormacion() {
		return formacion;
	}
	public void setFormacion(byte[] formacion) throws limiteJugadoresException {
		if(formacion.length!=4) {
			throw new limiteJugadoresException("Nº Jugadores en el campo incorrecto");
		}else {
			this.formacion = formacion;	
		}
	}
	
}
