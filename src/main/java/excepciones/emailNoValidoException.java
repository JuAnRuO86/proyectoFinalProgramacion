package excepciones;
/**
 * Esta clase es una excepci�n que se usar� cuando el email est� vac�o
 * @author juaan
 *
 */
public class emailNoValidoException extends Exception {
	/**
	 * Constructor de esta clase
	 * @param msg
	 */
	public emailNoValidoException(String msg) {
		super(msg);
	}
}
