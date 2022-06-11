package clases;

import java.util.Random;

import enums.Posicion;
/**
 * Clase que indicar� ser jugador y la posici�n del mismo
 * @author juaan
 *
 */
public class Jugador extends Persona{
	/** la posicion del jugador **/
	protected Posicion posicion;
	/**
	 * Constructor vac�o para llamarlo en las subclases  
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
	 * Funci�n que generar� un n�mero aleatorio entre un m�nimo y un m�ximo dado por argumentos
	 * @param min el n�mero minimo
	 * @param max el n�mero m�ximo o l�mite
	 * @return un n�mero aleatorio que ser� la estad�stica
	 */
	public byte ponerEstadistica(byte min,byte max) {
		Random r=new Random();
		return (byte)(r.nextInt(max+1-min)+min);
	}

}
