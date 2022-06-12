package excepciones;
/**
 * Esta clase es una excepción que se usará cuando el presupuesto sea 0
 * @author juaan
 *
 */
public class PresupuestoInvalidoException extends Exception {
	/**
	 * Constructor de esta clase
	 * @param msg
	 */
	public PresupuestoInvalidoException(String msg) {
		super(msg);
	}
}
