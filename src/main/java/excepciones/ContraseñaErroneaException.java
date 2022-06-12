package excepciones;
/**
 * Esta clase es una excepción que se usará cuando la contraseña sea incorrecta
 * @author juaan
 *
 */
public class ContraseñaErroneaException extends Exception {
	/**
	 * Constructor de esta clase
	 * @param msg
	 */
	public ContraseñaErroneaException(String msg) {
		super(msg);
	}
}
