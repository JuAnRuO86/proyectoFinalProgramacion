package clases;

/**
 * Clase de las que heredan las subclases
 * @author juaan
 */
public abstract class ElementoConNombre {
	
	/** Se usará para determinar nombres de los elementos **/
	protected String nombre;
	
	/**
	 * Constructor vacío para llamarlo en las subclases
	 */
	public ElementoConNombre() {
		
	}
	/**
	 * Constructor con la variable interna nombre
	 * @param nombre del elemento
	 */
	public ElementoConNombre(String nombre) {
		super();
		this.setNombre(nombre);
	}

	/**
	 * Getter de nombre
	 * @return el nombre del elemento
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter de nombre
	 * @param nombre del elemento
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
