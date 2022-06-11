package clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import enums.Posicion;
import utils.ConexionBD;
/**
 * Clase que por las instancias del mismo determinará a un jugador de campo
 * @author juaan
 *
 */
public class JugadorDeCampo extends Jugador {
	/** atributo 1 que es el ritmo del jugador de campo **/
	private byte ritmo;
	/** atributo 2 que es el tiro del jugador de campo **/
	private byte tiro;
	/** atributo 3 que es la defensa del jugador de campo **/
	private byte defensa;
	/** atributo 4 que es el fisico del jugador de campo **/
	private byte fisico;
	/**
	 * Constructor que generará jugador de campo con valoracion, precio y posicion aleatoria, se le determinará el nombre, apellidos y nacionalidad pasándoselas por argumentos
	 * @param nombre el nombre del jugador de campo
	 * @param apellidos los apellidos del jugador de campo
	 * @param nacionalidad la nacionalidad del jugador de campo
	 * @throws SQLException
	 */
	public JugadorDeCampo(String nombre, String apellidos, String nacionalidad) throws SQLException {
		super();
		this.setPosicion(posicionAleatoriaJugador());
		this.setRitmo(ritmo);
		this.setTiro(tiro);
		this.setDefensa(defensa);
		this.setFisico(fisico);
		this.setValoracion(valoracionObtenida(ritmo,tiro,defensa,fisico));
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
	 * Constructor que generará jugador de campo con valoracion y precio aleatoria, se le determinará el nombre, apellidos, nacionalidad y posicion pasándoselas por argumentos
	 * @param nombre el nomrbe del jugador de campo
	 * @param apellidos	apellidos del jugador de campo
	 * @param nacionalidad nacionalidad del jugador de campo
	 * @param posicion posicion del jugador de campo
	 * @throws SQLException
	 */
	public JugadorDeCampo(String nombre, String apellidos, String nacionalidad,Posicion posicion) throws SQLException {
		super();
		
		this.setPosicion(posicion);
		this.setRitmo(ritmo);
		this.setTiro(tiro);
		this.setDefensa(defensa);
		this.setFisico(fisico);
		this.setValoracion(valoracionObtenida(ritmo,tiro,defensa,fisico));
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
	 * Getter de ritrmo
	 * @return el atributo 1 que es el ritmo del jugador de campo
	 */
	public byte getRitmo() {
		return ritmo;
	}
	/**
	 * Setter de ritmo, tendrá unos límites basados en la posición que tenga el jugador de campo
	 * @param ritmo el ritmo del jugador de campo
	 */
	public void setRitmo(byte ritmo) {
		switch (posicion){
		case DELANTERO:
			this.ritmo = ponerEstadistica((byte)65,(byte)94);
			break;
		case CENTROCAMPISTA:
			this.ritmo = ponerEstadistica((byte)60,(byte)94);
			break;
		case DEFENSA:
			this.ritmo = ponerEstadistica((byte)30,(byte)84);
			break;
		default:
			break;
		}
	}
	/**
	 * Getter de tiro
	 * @return el atributo 2 que es el tiro del jugador de campo
	 */
	public byte getTiro() {
		return tiro;
	}
	/**
	 * Setter de tiro, tendrá unos límites basados en la posición que tenga el jugador de campo
	 * @param tiro el tiro del jugador de campo
	 */
	public void setTiro(byte tiro) {
		switch (posicion){
		case DELANTERO:
			this.tiro = ponerEstadistica((byte)70,(byte)94);
			break;
		case CENTROCAMPISTA:
			this.tiro = ponerEstadistica((byte)55,(byte)90);
			break;
		case DEFENSA:
			this.tiro = ponerEstadistica((byte)30,(byte)70);
			break;
		default:
			break;
		}
	}
	/**
	 * Getter de defensa
	 * @return el atributo 3 que es defensa del jugador de campo
	 */
	public byte getDefensa() {
		return defensa;
	}
	/**
	 * Setter de defensa, tendrá unos límites basados en la posición que tenga el jugador de campo
	 * @param defensa la defensa del jugador de campo
	 */
	public void setDefensa(byte defensa) {
		switch (posicion){
		case DELANTERO:
			this.defensa = ponerEstadistica((byte)20,(byte)55);
			break;
		case CENTROCAMPISTA:
			this.defensa = ponerEstadistica((byte)40,(byte)88);
			break;
		case DEFENSA:
			this.defensa = ponerEstadistica((byte)70,(byte)94);
			break;
		default:
			break;
		}
	}
	/**
	 * Getter de fisico
	 * @return el atributo 3 que es fisico del jugador de campo
	 */
	public byte getFisico() {
		return fisico;
	}
	/**
	 * Setter de fisico, tendrá unos límites basados en la posición que tenga el jugador de campo
	 * @param fisico el fisico del jugador de campo
	 */
	public void setFisico(byte fisico) {
		switch (posicion){
		case DELANTERO:
			this.fisico = ponerEstadistica((byte)60,(byte)85);
			break;
		case CENTROCAMPISTA:
			this.fisico = ponerEstadistica((byte)50,(byte)85);
			break;
		case DEFENSA:
			this.fisico = ponerEstadistica((byte)70,(byte)94);
			break;
		default:
			break;
		}
	}
	/**
	 * Función que generará una posicion aleatoria
	 * @return una posicion para el jugador de campo
	 */
	public Posicion posicionAleatoriaJugador() {
		Random r=new Random();
		Posicion pos = null;
		byte eleccion=(byte)(r.nextInt(3));
		switch(eleccion) {
		case 0:
			pos=Posicion.DEFENSA;
			break;
		case 1:
			pos=Posicion.CENTROCAMPISTA;
			break;
		case 2:
			pos=Posicion.DELANTERO;
			break;
		}
		
		return pos;
	}
	/**
	 * Función que generará la valoración total de la persona dependiendo del ritmo, tiro, defensa y fisico del jugador de campo
	 */
	public byte valoracionObtenida(byte ritmo,byte tiro,byte defensa,byte fisico) {
		return (byte)((ritmo+tiro+defensa+fisico)/3.4f);
	}

	/**
	 * toString de la clase jugador de campo, muestra formateada toda la información del mismo
	 * @return String con toda la información del jugador de campo
	 */
	@Override
	public String toString() {
		return "<"+this.posicion+"> "+getNombre()+" "+getApellidos()+" ("+super.getNacionalidad()+") *"+super.getValoracion()+"* "+"(Precio -> "+super.getPrecio()+"€)"+"\n[ritmo=" + ritmo + " tiro=" + tiro + "]\n[defensa=" + defensa + " fisico=" + fisico
				+ "]\n\n";
	}

	
	

}
