package excepciones;
/**
 * Esta clase es una excepci�n que se usar� cuando el nombre sea una cadena vac�a
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
