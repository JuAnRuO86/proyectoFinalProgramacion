package excepciones;
/**
 * Esta clase es una excepción que se usará cuando el apellido esté vacío o contenga números
 * @author juaan
 *
 */
public class apellidoNoValidoException extends Exception {
	/**
	 * Constructor de esta clase
	 * @param msg
	 */
	public apellidoNoValidoException(String msg) {
		super(msg);
	}
}
