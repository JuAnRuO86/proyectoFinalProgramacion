package clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Random;

import utils.ConexionBD;


public class Entrenador extends Persona{

	private byte nivelTactico;
	private byte[] formacion;
	
	public Entrenador(String nombre, String apellidos, String nacionalidad) throws SQLException {
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

	public byte getNivelTactico() {
		return nivelTactico;
	}
	public void setNivelTactico(byte nivelTactico) {
		this.nivelTactico = nivelTactico;
	}
	public byte[] getFormacion() {
		return formacion;
	}
	public void setFormacion(byte[] formacion)  {
		this.formacion=formacion;
	}
	
	public byte ponerNivelTactico() {
		Random r=new Random();
		return (byte)(r.nextInt(5)+1);
	}
	
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
	
	public int precioPersona(byte nivelTactico)  {
		return nivelTactico*100000;	
	}
	
	
	@Override
	public String toString() {
		return "<ENTRENADOR> "+getNombre()+" "+getApellidos()+" ("+super.getNacionalidad()+") *"+this.getNivelTactico()+"* "+"(Precio -> "+super.getPrecio()+"�)"+" Formacion=" + Arrays.toString(formacion) + "]";
	}
	
	
	
}
