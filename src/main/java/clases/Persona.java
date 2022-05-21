package clases;

public class Persona extends ElementoConNombre{

	private String apellidos;
	private String nacionalidad;
	private byte valoracion;
	private int precio;
	public Persona(String nombre, String apellidos, String nacionalidad, int precio) {
		super(nombre);
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.setNacionalidad(nacionalidad);
		this.setPrecio(precio);
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
	
	
	
	
}
