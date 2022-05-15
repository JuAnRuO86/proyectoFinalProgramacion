package clases;

public class Persona extends ElementoConNombre{

	private String apellidos;
	private String nacionalidad;
	private byte valoracion;
	private int precio;
	public Persona(String nombre, String apellidos, String nacionalidad, byte valoracion, int precio) {
		super(nombre);
		this.setNombre(nombre);
		this.setApellidos(apellidos);
		this.setNacionalidad(nacionalidad);
		this.setValoracion(valoracion);
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
		this.valoracion = valoracion;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
	
	
	
}
