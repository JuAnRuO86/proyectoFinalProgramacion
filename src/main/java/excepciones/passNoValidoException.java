package excepciones;
/**
 * Esta clase es una excepci�n que se usar� cuando la contrase�a est� vac�a
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
