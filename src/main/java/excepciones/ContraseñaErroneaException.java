package excepciones;
/**
 * Esta clase es una excepci�n que se usar� cuando la contrase�a sea incorrecta
 * @author juaan
 *
 */
public class Contrase�aErroneaException extends Exception {
	/**
	 * Constructor de esta clase
	 * @param msg
	 */
	public Contrase�aErroneaException(String msg) {
		super(msg);
	}
}
