package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import excepciones.ContraseñaErroneaException;
import excepciones.NombreValidoException;
import excepciones.UsuarioNoValidoException;
import excepciones.apellidoNoValidoException;
import excepciones.emailNoValidoException;
import excepciones.passNoValidoException;
import utils.ConexionBD;
/**
 *  Clase que representa al usuario que accede al programa
 * @author juaan
 *
 */
public class Usuario extends ElementoConNombre{

	/** email del usuario **/
	private String email;
	/** contraseña del usuario **/
	private String pass;
	/** primer apellido del usuario **/
	private String apellido1;
	/** segundo apellido del usuario **/
	private String apellido2;
	
	/**
	 * Constructor con todas las variables internas, este constructor se basará en registrar a un nuevo usuario
	 * @param nombre el nombre del usuario
	 * @param apellido1 primer apellido del usuario
	 * @param apellido2 segundo apellido del usuario
	 * @param email email del usuario
	 * @param pass contraseña del usuario
	 * @throws SQLException
	 * @throws NombreValidoException 
	 * @throws apellidoNoValidoException 
	 * @throws passNoValidoException 
	 * @throws excepciones.emailNoValidoException 
	 */
	public Usuario(String nombre, String apellido1, String apellido2, String email, String pass) throws SQLException, NombreValidoException, apellidoNoValidoException, passNoValidoException, excepciones.emailNoValidoException {
		super(nombre);
		if(apellidoNoValido(apellido1)) {
			throw new apellidoNoValidoException("El primer apellido no puede estar vacío ni contener letras");
		}
		if(apellidoNoValido(apellido2)) {
			throw new apellidoNoValidoException("El segundo apellido no puede estar vacío ni contener letras");
		}
		if(passNoValido(apellido1)) {
			throw new passNoValidoException("La contraseña no puede estar vacía");
		}
		if(emailNoValido(apellido1)) {
			throw new emailNoValidoException("El email no puede estar vacío");
		}
		this.setNombre(nombre);
		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate(
				"insert into usuario values('" + nombre + "','" + apellido1 + "','" + apellido2 + "','" + email +"','" +pass+"')") > 0) {
			this.apellido1=apellido1;
			this.apellido2=apellido2;
			this.email=email;
			this.pass=pass;
			
		} else {
			
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido insertar");
		}
		ConexionBD.desconectar();
	}
	

	/**
	 * Constructor con las variables email y pass únicamente, este constructor se basará en acceder al programa(logear) con un usuario existente
	 * @param email email del usuario
	 * @param pass contraseña del usuario
	 * @throws SQLException
	 * @throws ContraseñaErroneaException
	 * @throws UsuarioNoValidoException
	 * @throws NombreValidoException 
	 */
	public Usuario(String email, String pass) throws SQLException, ContraseñaErroneaException, UsuarioNoValidoException, NombreValidoException {
		super();
		
		Statement smt = ConexionBD.conectar();
		ResultSet cursor=smt.executeQuery("select * from usuario where email='"+ email+"'");
		
		if(cursor.next()) {
			this.pass = cursor.getString("pass");
			if(!(this.pass.toLowerCase().equals(pass))) {
				ConexionBD.desconectar();
				throw new ContraseñaErroneaException("La contraseña no es correcta");
			}
			this.pass=pass;
			ResultSet cursor2 = smt.executeQuery("select nombre,apellido1,apellido2,email,pass from usuario where email='"+email+"'");
			while(cursor2.next()) {
				this.email=cursor2.getString("email");
				this.pass=cursor2.getString("pass");
				nombre=cursor2.getString("nombre");
				this.apellido1=cursor2.getString("apellido1");
				this.apellido2=cursor2.getString("apellido2");
			}
		} else {
			
			ConexionBD.desconectar();
			throw new UsuarioNoValidoException("El email no es correcto");
		}
	ConexionBD.desconectar();
		
	}

	/**
	 * protección para que el apellido no esté vacío ni contenga números
	 * @param apellido apellido del usuario
	 * @return true si el apellido está vacío o contiene números y false si el apellido no está vacío y no contiene números
	 */
	protected static boolean apellidoNoValido(String apellido) {
		if(apellido.contains("1")||apellido.contains("2")||apellido.contains("3")||apellido.contains("4")||apellido.contains("5")||apellido.contains("6")||apellido.contains("7")||apellido.contains("8")||apellido.contains("9")||apellido.contains("0")||apellido.isBlank()) {
			return true;
		}else {
			return false;
		}
	}
	
	
	/**
	 * Getter de apellido1
	 * @return el primer apellido del usuario
	 */
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * Setter de apellido1, se lanzará una excepción si a la hora de cambiar el primer apellido de un usuario existente no encuentra a dicho usuario mediante su clave primaria o si el primer apellido contiene números o esta vacío
	 * @param apellido1 Primer apellido del usuario
	 * @throws SQLException
	 * @throws apellidoNoValidoException 
	 */
	public void setApellido1(String apellido1) throws SQLException, apellidoNoValidoException {
		if(apellidoNoValido(apellido1)) {
			throw new apellidoNoValidoException("El apellido no puede estar vacío ni contener letras");
		}
		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate("update usuario set apellido1='" + apellido1 + "' where email='" + this.email + "'") > 0) {
			this.apellido1 = apellido1;
		} else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido cambiar el primer apellido");
		}
		ConexionBD.desconectar();
	}

	/**
	 * Getter de apellido2
	 * @return el segundo apellido del usuario
	 */
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * Setter de apellido2, se lanzará una excepción si a la hora de cambiar el segundo apellido de un usuario existente no encuentra a dicho usuario mediante su clave primaria
	 * @param apellido2 Segundo apellido del usuario
	 * @throws SQLException
	 */
	public void setApellido2(String apellido2) throws SQLException {
		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate("update usuario set apellido2='" + apellido2 + "' where email='" + this.email + "'") > 0) {
			this.apellido2=apellido2;
		} else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido cambiar el segundo apellido");
		}
		ConexionBD.desconectar();
	}

	/**
	 * protección para que la contraseña no esté vacía
	 * @param pass contraseña del usuario
	 * @return true si el pass está vacío y false si el pass no está vacío
	 */
	protected static boolean passNoValido(String pass) {
		return pass.isBlank();
	}
	
	/**
	 * Getter de pass
	 * @return la contraseña del usuario
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * Setter de pass, se lanzará una excepción si a la hora de cambiar la contraseña de un usuario existente no encuentra a dicho usuario mediante su clave primaria
	 * @param pass la contraseña del usuario
	 * @throws SQLException
	 * @throws passNoValidoException 
	 */
	public void setPass(String pass) throws SQLException, passNoValidoException {
		if(passNoValido(apellido1)) {
			throw new passNoValidoException("La contraseña no puede estar vacía");
		}
		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate("update usuario set pass='" + pass + "' where email='" + this.email + "'") > 0) {
			this.pass = pass;
		} else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido cambiar el password");
		}
		ConexionBD.desconectar();
	}

	/**
	 * protección para que el email no esté vacío
	 * @param email email del usuario
	 * @return true si el email está vacío y false si el email no está vacío
	 */
	protected static boolean emailNoValido(String email) {
		return email.isBlank();
	}
	
	/**
	 * Getter de email
	 * @return el email del usuario
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter de email, se lanzará una excepción si a la hora de cambiar el email de un usuario existente no encuentra a dicho usuario mediante su clave primaria
	 * @param email el email del usuario
	 * @throws SQLException
	 * @throws emailNoValidoException 
	 */
	public void setEmail(String email) throws SQLException, emailNoValidoException {
		if(emailNoValido(apellido1)) {
			throw new emailNoValidoException("El email no puede estar vacío");
		}
		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate("update usuarios set email='" + email + "' where email='" + this.email + "'") > 0) {
			this.email = email;
		} else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido cambiar el email");
		}
		ConexionBD.desconectar();
	}
	
	
	
	}


