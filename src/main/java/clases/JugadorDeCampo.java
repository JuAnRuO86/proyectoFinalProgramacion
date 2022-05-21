package clases;

import java.util.Random;

import enums.Posicion;

public class JugadorDeCampo extends Jugador {

	private byte ritmo;
	private byte tiro;
	private byte defensa;
	private byte fisico;
	
	public JugadorDeCampo(String nombre, String apellidos, String nacionalidad, Posicion posicion) {
		
		super(nombre, apellidos, nacionalidad, posicion);
		this.setRitmo();
		this.setTiro();
		this.setDefensa();
		this.setFisico();
		this.setPosicion(posicion);
		super.setValoracion(valoracionObtenida(ritmo,tiro,defensa,fisico));
		super.setPrecio(precioJugador(super.getValoracion()));
	}

	public byte getRitmo() {
		return ritmo;
	}

	public void setRitmo() {
		switch (posicion){
		case DELANTERO:
			this.ritmo = ponerEstadistica((byte)65,(byte)99);
			break;
		case CENTROCAMPISTA:
			this.ritmo = ponerEstadistica((byte)60,(byte)99);
			break;
		case DEFENSA:
			this.ritmo = ponerEstadistica((byte)30,(byte)90);
			break;
		}
	}

	public byte getTiro() {
		return tiro;
	}

	public void setTiro() {
		switch (posicion){
		case DELANTERO:
			this.tiro = ponerEstadistica((byte)70,(byte)99);
			break;
		case CENTROCAMPISTA:
			this.tiro = ponerEstadistica((byte)55,(byte)95);
			break;
		case DEFENSA:
			this.tiro = ponerEstadistica((byte)30,(byte)70);
			break;
		}
	}

	public byte getDefensa() {
		return defensa;
	}

	public void setDefensa() {
		switch (posicion){
		case DELANTERO:
			this.defensa = ponerEstadistica((byte)20,(byte)60);
			break;
		case CENTROCAMPISTA:
			this.defensa = ponerEstadistica((byte)40,(byte)90);
			break;
		case DEFENSA:
			this.defensa = ponerEstadistica((byte)70,(byte)99);
			break;
		}
	}

	public byte getFisico() {
		return fisico;
	}

	public void setFisico() {
		switch (posicion){
		case DELANTERO:
			this.fisico = ponerEstadistica((byte)60,(byte)85);
			break;
		case CENTROCAMPISTA:
			this.fisico = ponerEstadistica((byte)50,(byte)85);
			break;
		case DEFENSA:
			this.fisico = ponerEstadistica((byte)70,(byte)99);
			break;
		}
	}
	
	public byte ponerEstadistica(byte min,byte max) {
		Random r=new Random();
		return (byte)(r.nextInt(max+1-min)+min);
	}
	
	public byte valoracionObtenida(byte ritmo,byte tiro,byte defensa,byte fisico) {
		return (byte)((short)(ritmo+tiro+defensa+fisico)/3.4f);
	}

	
	@Override
	public String toString() {
		return this.getNombre()+" "+this.getApellidos()+" *"+valoracionObtenida(ritmo, tiro, defensa, fisico)+"* "+"(Precio -> "+super.getPrecio()+"€)"+"\n[ritmo=" + ritmo + " tiro=" + tiro + "]\n[defensa=" + defensa + " fisico=" + fisico
				+ "]";
	}

	
	

}
