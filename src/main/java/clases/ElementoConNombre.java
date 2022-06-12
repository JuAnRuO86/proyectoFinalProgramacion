package clases;

import excepciones.NombreValidoException;
import excepciones.NombreValidoException;

/**
 * Clase de las que heredan las subclases
 * @author juaan
 */
public abstract class ElementoConNombre {
	
	/** Se usar� para determinar nombres de los elementos **/
	protected String nombre;
	
	/**
	 * Constructor vac�o para llamarlo en las subclases
	 * @throws NombreValidoException 
	 */
	public ElementoConNombre() throws NombreValidoException {
	}
	/**
	 * Constructor con la variable interna nombre
	 * @param nombre del elemento
	 * @throws NombreValidoException 
	 */
	public ElementoConNombre(String nombre) throws NombreValidoException {
		super();
		if(nombreNoValido(nombre)) {
			throw new NombreValidoException("El nombre no puede estar vac�o ni contener n�meros");
		}
		this.setNombre(nombre);
	}
	/**
	 * protecci�n para que el nombre no est� vac�o ni contenga n�meros
	 * @param nombre nombre del elemento
	 * @return true si el nombre est� vac�o y false si el nombre no est� vac�o
	 */
	protected static boolean nombreNoValido(String nombre) {
		if(nombre.contains("1")||nombre.contains("2")||nombre.contains("3")||nombre.contains("4")||nombre.contains("5")||nombre.contains("6")||nombre.contains("7")||nombre.contains("8")||nombre.contains("9")||nombre.contains("0")||nombre.isBlank()) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Getter de nombre
	 * @return el nombre del elemento
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter de nombre, no podr� estar vac�o
	 * @param nombre del elemento
	 * @throws NombreValidoException 
	 */
	public void setNombre(String nombre) throws NombreValidoException {
		if(nombreNoValido(nombre)) {
			throw new NombreValidoException("El nombre no puede estar vac�o");
		}
		this.nombre = nombre;
	}
	
}
