package excepciones;
/**
 * Esta clase es una excepción que se usará cuando el email del usuario no sea el correcto
 * @author juaan
 *
 */
public class UsuarioNoValidoException extends Exception {
	/**
	 * Constructor de esta clase
	 * @param msg
	 */
	public UsuarioNoValidoException(String msg) {
		super(msg);
	}
}
