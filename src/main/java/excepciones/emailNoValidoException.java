package excepciones;
/**
 * Esta clase es una excepción que se usará cuando el email esté vacío
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
