package excepciones;
/**
 * Esta clase es una excepci�n que se usar� cuando el apellido est� vac�o o contenga n�meros
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
