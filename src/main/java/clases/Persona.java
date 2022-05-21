package clases;

import java.util.Random;


public class Persona extends ElementoConNombre{

	private String apellidos;
	private String nacionalidad;
	private byte valoracion;
	private int precio;
	public Persona(String nombre, String apellidos, String nacionalidad) {
		super(nombre);
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.setNacionalidad(nacionalidad);
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public byte getValoracion() {
		return valoracion;
	}
	public void setValoracion(byte valoracion) {
		if(valoracion>99) {
			this.valoracion=99;
		}else {
			this.valoracion = valoracion;
		}
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public byte valoracionObtenida(byte e1,byte e2,byte e3,byte e4) {	
		return (byte)((short)(e1+e2+e3+e4)/4);
	}
	
	public int precioJugador(byte valoracion)  {
		Random r=new Random();
		if(valoracion==99) {
			return r.nextInt(2000000-1800000)+1800000;
		//Rango de precio valoracion>90 (100k)
		}else if(valoracion>90 && valoracion<99) {
			int max=1000000+(100000*(valoracion-90));
			int min=max-100000;
			return r.nextInt(max-min)+min;
		//Rango de precio valoracion>80 (50k)
		}else if(valoracion>80 && valoracion<=90) {
			int max=500000+(50000*(valoracion-80));
			int min=max-50000;
			return r.nextInt(max-min)+min;
		//Rango de precio valoracion>70 (25k)
		}else if(valoracion>70 && valoracion<=80) {
			int max=250000+(25000*(valoracion-70));
			int min=max-25000;
			return r.nextInt(max-min)+min;
		//Rango de precio valoracion>60 (15k)
		}else if(valoracion>60 && valoracion<=70) {
			int max=100000+(15000*(valoracion-60));
			int min=max-15000;
			return r.nextInt(max-min)+min;
		}else {
			return 0;
		}
	}
	
	
	
}
