package excepciones;
/**
 * Esta clase es una excepción que se usará cuando el nombre sea una cadena vacía
 * @author juaan
 *
 */
public class NombreValidoException extends Exception {
	/**
	 * Constructor de esta clase
	 * @param msg
	 */
	public NombreValidoException(String msg) {
		super(msg);
	}
}
