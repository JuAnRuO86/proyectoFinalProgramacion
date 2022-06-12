package clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Random;

import excepciones.NombreValidoException;
import utils.ConexionBD;

/**
 * Clase que por las instancias que tiene determinan a un entrenador
 * @author juaan
 *
 */
public class Entrenador extends Persona{
	/** nivel tactico que tiene el entrenador **/
	private byte nivelTactico;
	/** formacion que usará el entrenador **/
	private byte[] formacion;
	/**
	 * Constructor que generará un entrenador con un nivel tactico, un precio y una formacion aleatoria, se le determinará el nombre, los apellidos y la nacionalidad por argumentos
	 * @param nombre el nombre del entrenador
	 * @param apellidos los apellidos del entrenador
	 * @param nacionalidad la nacionalidad del entrenador
	 * @throws SQLException
	 * @throws NombreValidoException 
	 */
	public Entrenador(String nombre, String apellidos, String nacionalidad) throws SQLException, NombreValidoException {
		super();
		this.setFormacion(creadorFormacion());
		this.setNivelTactico(ponerNivelTactico());
		this.setPrecio(precioPersona(nivelTactico));

		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate(
				"insert into persona (nombre,apellidos,nacionalidad,valoracion,precio,posicion) values('" + nombre + "','" + apellidos + "','" + nacionalidad + "'," + nivelTactico +"," +precio+",'ENTRENADOR')") > 0) {
			
			this.setNombre(nombre);
			this.setApellidos(apellidos);
			this.setNacionalidad(nacionalidad);
			
		}else {
			
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido insertar el entrenador");
		}
		ConexionBD.desconectar();
	}
	/**
	 * Getter de nivel tactico
	 * @return el nivel tactico del entrenador
	 */
	public byte getNivelTactico() {
		return nivelTactico;
	}
	/**
	 * Setter de nivel tactico
	 * @param nivelTactico el nivel tactico del entrenador
	 */
	public void setNivelTactico(byte nivelTactico) {
		this.nivelTactico = nivelTactico;
	}
	/**
	 * Getter de formacion
	 * @return la formacion del entrenador
	 */
	public byte[] getFormacion() {
		return formacion;
	}
	/**
	 * Setter de formacion
	 * @param formacion la formacion del entrenador
	 */
	public void setFormacion(byte[] formacion)  {
		this.formacion=formacion;
	}
	/**
	 * Función que genera el nivel tactico del entrenador entre 1 y 5
	 * @return el nivel tactico del entrenador
	 */
	public byte ponerNivelTactico() {
		Random r=new Random();
		return (byte)(r.nextInt(5)+1);
	}
	/**
	 * Función que generará la formacion del entrenador de manera aleatoria, será un array de tamaño 3(defensas,centrocampistas,delanteros) y el total entre los 3 no puede superar 4 ya que sera el número de jugadores como máximo en el campo
	 * @return la formacion del entrenador
	 */
	public byte[] creadorFormacion() {
		Random r=new Random();
		byte[] form=new byte[3];
		byte cont=0;
		for(byte i=0;i<form.length;i++) {
			form[i]=(byte)r.nextInt(4);
			cont+=form[i];
			if(cont>=4 && i==form.length-1) {
				form[i]=(byte)(4-(form[i-1]+form[i-2]));
				break;
			}else if(cont<4 && i==form.length-1) {
				form[i]=(byte)(4-(form[i-1]+form[i-2]));
			}else if(cont>=4) {
				form[i]=(byte)(4-form[i-1]);
			}
		}
		return form;
	}
	/**
	 * Función que genera el precio del entrenador dependiendo del nivel tactico del mismo
	 */
	public int precioPersona(byte nivelTactico)  {
		return nivelTactico*100000;	
	}
	
	/**
	 * toString de la clase entrenador, muestra formateada toda la información del mismo
	 * @return String con toda la información del entrenador
	 */
	@Override
	public String toString() {
		return "<ENTRENADOR> "+getNombre()+" "+getApellidos()+" ("+super.getNacionalidad()+") *"+this.getNivelTactico()+"* "+"(Precio -> "+super.getPrecio()+"€)"+" Formacion=" + Arrays.toString(formacion) + "]";
	}
	
	
	
}
