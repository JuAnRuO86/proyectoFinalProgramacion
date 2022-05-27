package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import excepciones.contraseñaErroneaException;
import excepciones.usuarioNoValidoException;
import utils.ConexionBD;

public class Usuario extends ElementoConNombre{

	private String email;
	private String pass;
	private String apellido1;
	private String apellido2;
	
	//Para registro
	public Usuario(String nombre, String apellido1, String apellido2, String email, String pass) throws SQLException {
		super(nombre);
		
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
	
	//Para el login
	public Usuario(String email, String pass, String nombre) throws SQLException, contraseñaErroneaException, usuarioNoValidoException {
		super(nombre);
		Statement smt = ConexionBD.conectar();
		ResultSet cursor=smt.executeQuery("select * from usuario where email='"+ email+"'");
		
		if(cursor.next()) {
			this.pass = cursor.getString("pass");
			if(!(this.pass.toLowerCase().equals(pass))) {
				ConexionBD.desconectar();
				throw new contraseñaErroneaException("La contraseña no es correcta");
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
			throw new usuarioNoValidoException("El nombre no es correcto");
		}
	ConexionBD.desconectar();
		
	}


	public String getApellido1() {
		return apellido1;
	}


	public void setApellido1(String apellido1) throws SQLException {
		
		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate("update usuario set apellido1='" + apellido1 + "' where email='" + this.email + "'") > 0) {
			this.apellido1 = apellido1;
		} else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido cambiar el primer apellido");
		}
		ConexionBD.desconectar();
	}


	public String getApellido2() {
		return apellido2;
	}


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


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) throws SQLException {
		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate("update usuario set pass='" + pass + "' where email='" + this.email + "'") > 0) {
			this.pass = pass;
		} else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido cambiar el password");
		}
		ConexionBD.desconectar();
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) throws SQLException {
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


