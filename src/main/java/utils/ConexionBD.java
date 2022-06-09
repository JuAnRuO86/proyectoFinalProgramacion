package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase que hace la conexi�n y desconexi�n con la base de datos.
 * @author juaan
 *
 */
public abstract class ConexionBD {
	private final static String cadenaConexion="jdbc:mysql://127.0.0.1:3306/modocarrerafutsala";
	private final static String usuarioBD="root";
	private final static String passwordBD="1234567890"; //static se comparte el valor y siempre sera el mismo y no se repetira
	private static Connection conexion; //singleton
	
	/**
	 * Funci�n que conecta con la base de datos.
	 * @return nos devolver� consultas
	 */
	public static Statement conectar() { //Nos devolver� consultas Importar de java.sql
		try {
			if(conexion==null) {
				conexion=DriverManager.getConnection(cadenaConexion,usuarioBD,passwordBD);
			}
			return conexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Funci�n que desconecta de la base de datos.
	 */
	public static void desconectar() {
		if(conexion!=null) {
			try {
				conexion.close();
				conexion=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
