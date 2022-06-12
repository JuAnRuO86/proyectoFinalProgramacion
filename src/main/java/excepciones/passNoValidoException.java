package excepciones;
/**
 * Esta clase es una excepción que se usará cuando la contraseña esté vacía
 * @author juaan
 *
 */
public class passNoValidoException extends Exception {
	/**
	 * Constructor de esta clase
	 * @param msg
	 */
	public passNoValidoException(String msg) {
		super(msg);
	}
}
