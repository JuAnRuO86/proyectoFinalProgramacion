package clases;

import java.sql.SQLException;
import java.sql.Statement;

import enums.Posicion;
import utils.ConexionBD;
/**
 * Clase que por las instancias del mismo determinar� a un portero
 * @author juaan
 *
 */
public class Portero extends Jugador{
	/** atributo 1 que es la estirada del portero **/
	private byte estirada;
	/** atributo 2 que es la parada del portero **/
	private byte parada;
	/** atributo 3 que son los reflejos del portero **/
	private byte reflejos;
	/** atributo 4 que es el posicionamiento del portero **/
	private byte posicionamiento;
	/**
 	 * Constructor que generar� un portero con valoracion y precio aleatoria, se le determinar� el nombre, apellidos y nacionalidad pas�ndoselas por argumentos, la posicion ser� portero
	 * @param nombre el nombre del portero
	 * @param apellidos los apellidos del portero
	 * @param nacionalidad la nacionalidad del portero
	 * @throws SQLException
	 */
	public Portero(String nombre, String apellidos, String nacionalidad) throws SQLException {
		super();
		this.setPosicion(Posicion.PORTERO);
		this.setEstirada(estirada);
		this.setParada(parada);
		this.setReflejos(reflejos);
		this.setPosicionamiento(posicionamiento);
		this.setValoracion(valoracionObtenida(estirada,parada,reflejos,posicionamiento));
		this.setPrecio(precioPersona(valoracion));

		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate(
				"insert into persona (nombre,apellidos,nacionalidad,valoracion,precio,posicion) values('" + nombre + "','" + apellidos + "','" + nacionalidad + "'," + valoracion +"," +precio+",'"+posicion+"')") > 0) {
			
			this.setNombre(nombre);
			this.setApellidos(apellidos);
			this.setNacionalidad(nacionalidad);
			
		}else {
			
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido insertar el jugador");
		}
		ConexionBD.desconectar();
	}
	/**
	 * Getter de estirada
	 * @return el atributo 1 que es la estirada del portero
	 */
	public byte getEstirada() {
		return estirada;
	}
	/**
	 * Setter de estirada, tendr� entre un m�nimo de 50 y un m�ximo de 99
	 * @param estirada la estirada del portero
	 */
	public void setEstirada(byte estirada) {
		this.estirada = ponerEstadistica((byte)50,(byte)95);
	}
	/**
	 * Getter de parada
	 * @return la parada del portero
	 */
	public byte getParada() {
		return parada;
	}
	/**
	 * Setter de parada, tendr� entre un m�nimo de 50 y un m�ximo de 99
	 * @param parada la parada del portero
	 */
	public void setParada(byte parada) {
		this.parada = ponerEstadistica((byte)50,(byte)95);
	}
	/**
	 * Getter de reflejos
	 * @return los reflejos del portero
	 */
	public byte getReflejos() {
		return reflejos;
	}
	/**
	 * Setter de reflejos, tendr� entre un m�nimo de 50 y un m�ximo de 99
	 * @param reflejos los reflejos del portero
	 */
	public void setReflejos(byte reflejos) {
		this.reflejos = ponerEstadistica((byte)50,(byte)95);
	}
	/**
	 * Getter de posicionamiento
	 * @return el posicionamiento el portero
	 */
	public byte getPosicionamiento() {
		return posicionamiento;
	}
	/**
	 * Setter de posicionamiento, tendr� entre un m�nimo de 50 y un m�ximo de 99
	 * @param posicionamiento el posicionamiento el portero 
	 */
	public void setPosicionamiento(byte posicionamiento) {
		this.posicionamiento = ponerEstadistica((byte)50,(byte)95);
	}
	/**
	 * Funci�n que generar� la valoraci�n total de la persona dependiendo de la estirada, la parada, los reflejos y el posicionamiento del portero
	 */
	public byte valoracionObtenida(byte estirada,byte parada,byte reflejos,byte posicionamiento) {
		return (byte)((estirada+parada+reflejos+posicionamiento)/3.4f);
	}
	
	/**
	 * toString de la clase portero, muestra formateada toda la informaci�n del mismo
	 * @return String con toda la informaci�n del portero
	 */
	@Override
	public String toString() {
		return "<"+this.posicion+"> "+this.getNombre()+" "+this.getApellidos()+" ("+super.getNacionalidad()+") *"+super.getValoracion()+"* "+"(Precio -> "+super.getPrecio()+"�)"+"\n[estirada=" + estirada + " parada=" + parada + "]\n[reflejos=" + reflejos + " posicionamiento=" + posicionamiento
				+ "]";
	}
}
