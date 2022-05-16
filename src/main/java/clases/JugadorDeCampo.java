package clases;

import enums.Posicion;

public class JugadorDeCampo extends Jugador{

	private byte ritmo;
	private byte tiro;
	private byte defensa;
	private byte fisico;
	
	public JugadorDeCampo(String nombre, String apellidos, String nacionalidad, byte valoracion, int precio, byte ritmo,
			byte tiro, byte defensa, byte fisico, Posicion posicion) {
		
		super(nombre, apellidos, nacionalidad, valoracion, precio, posicion);
		this.setRitmo(ritmo);
		this.setTiro(tiro);
		this.setDefensa(defensa);
		this.setFisico(fisico);
		this.setPosicion(posicion);
	}

	public byte getRitmo() {
		return ritmo;
	}

	public void setRitmo(byte ritmo) {
		this.ritmo = ritmo;
	}

	public byte getTiro() {
		return tiro;
	}

	public void setTiro(byte tiro) {
		this.tiro = tiro;
	}

	public byte getDefensa() {
		return defensa;
	}

	public void setDefensa(byte defensa) {
		this.defensa = defensa;
	}

	public byte getFisico() {
		return fisico;
	}

	public void setFisico(byte fisico) {
		this.fisico = fisico;
	}

	
	

}
