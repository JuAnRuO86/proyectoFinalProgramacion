package clases;

import java.util.Random;

import enums.Posicion;
/**
 * Clase que indicará ser jugador y la posición del mismo
 * @author juaan
 *
 */
public class Jugador extends Persona{
	/** la posicion del jugador **/
	protected Posicion posicion;
	/**
	 * Constructor vacío para llamarlo en las subclases  
	 */
	public Jugador() {
		super();
	}
	/**
	 * Getter de la posicion
	 * @return la posicion del jugador
	 */
	public Posicion getPosicion() {
		return posicion;
	}
	/**
	 * Setter de la posicion del jugador
	 * @param posicion la posicion del jugador
	 */
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	/**
	 * Función que generará un número aleatorio entre un mínimo y un máximo dado por argumentos
	 * @param min el número minimo
	 * @param max el número máximo o límite
	 * @return un número aleatorio que será la estadística
	 */
	public byte ponerEstadistica(byte min,byte max) {
		Random r=new Random();
		return (byte)(r.nextInt(max+1-min)+min);
	}

}
