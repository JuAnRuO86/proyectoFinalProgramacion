package clases;

public abstract class ElementoConNombre {

	protected String nombre;

	public ElementoConNombre(String nombre) {
		super();
		this.setNombre(nombre);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
