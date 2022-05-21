package clases;

import java.util.Arrays;
import java.util.Random;


public class Entrenador extends Persona{

	private byte nivelTactico;
	private byte[] formacion;
	public Entrenador(String nombre, String apellidos, String nacionalidad) {
		super(nombre, apellidos, nacionalidad);
		this.setNivelTactico(ponerNivelTactico());
		this.setFormacion(creadorFormacion());
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
		return (byte)r.nextInt(5);
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
	@Override
	public String toString() {
		return "Entrenador [nivelTactico=" + nivelTactico + ", formacion=" + Arrays.toString(formacion) + "]";
	}
	
	
	
}
