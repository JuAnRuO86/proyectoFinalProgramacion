package clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import enums.Posicion;
import utils.ConexionBD;

public class JugadorDeCampo extends Jugador {

	private byte ritmo;
	private byte tiro;
	private byte defensa;
	private byte fisico;
	
	public JugadorDeCampo(String nombre, String apellidos, String nacionalidad) throws SQLException {
		super();
		
		//Esto puede ser motivo de error
		this.setPosicion(posicionAleatoriaJugador());
		this.setRitmo(ritmo);
		this.setTiro(tiro);
		this.setDefensa(defensa);
		this.setFisico(fisico);
		this.setValoracion(valoracionObtenida(ritmo,tiro,defensa,fisico));
		this.setPrecio(precioPersona(valoracion));

		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate(
				"insert into persona (nombre,apellidos,nacionalidad,valoracion,precio,posicion) values('" + nombre + "','" + apellidos + "','" + nacionalidad + "'," + valoracion +"," +precio+",'"+posicion+"')") > 0) {
			
			this.setNombre(nombre);
			this.setApellidos(apellidos);
			this.setNacionalidad(nacionalidad);
			
		}else {
			
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido insertar el jugador");
		}
		ConexionBD.desconectar();
	}
	public JugadorDeCampo(String nombre, String apellidos, String nacionalidad,Posicion posicion) throws SQLException {
		super();
		
		this.setPosicion(posicion);
		this.setRitmo(ritmo);
		this.setTiro(tiro);
		this.setDefensa(defensa);
		this.setFisico(fisico);
		this.setValoracion(valoracionObtenida(ritmo,tiro,defensa,fisico));
		this.setPrecio(precioPersona(valoracion));

		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate(
				"insert into persona (nombre,apellidos,nacionalidad,valoracion,precio,posicion) values('" + nombre + "','" + apellidos + "','" + nacionalidad + "'," + valoracion +"," +precio+",'"+posicion+"')") > 0) {
			
			this.setNombre(nombre);
			this.setApellidos(apellidos);
			this.setNacionalidad(nacionalidad);
			
		}else {
			
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido insertar el jugador");
		}
		ConexionBD.desconectar();
	}
//	public JugadorDeCampo(String nombre, String apellidos, String nacionalidad, Posicion posicion) {
//		
//		super(nombre, apellidos, nacionalidad, posicion);
//		
//		super.setValoracion(valoracionObtenida(ritmo,tiro,defensa,fisico));
//		super.setPrecio(precioPersona(super.getValoracion()));
//	}

	public byte getRitmo() {
		return ritmo;
	}

	public void setRitmo(byte ritmo) {
				
		switch (posicion){
		case DELANTERO:
			this.ritmo = ponerEstadistica((byte)65,(byte)94);
			break;
		case CENTROCAMPISTA:
			this.ritmo = ponerEstadistica((byte)60,(byte)94);
			break;
		case DEFENSA:
			this.ritmo = ponerEstadistica((byte)30,(byte)84);
			break;
		default:
			break;
		}
	}

	public byte getTiro() {
		return tiro;
	}

	public void setTiro(byte tiro) {
		switch (posicion){
		case DELANTERO:
			this.tiro = ponerEstadistica((byte)70,(byte)94);
			break;
		case CENTROCAMPISTA:
			this.tiro = ponerEstadistica((byte)55,(byte)90);
			break;
		case DEFENSA:
			this.tiro = ponerEstadistica((byte)30,(byte)70);
			break;
		default:
			break;
		}
	}

	public byte getDefensa() {
		return defensa;
	}

	public void setDefensa(byte defensa) {
		switch (posicion){
		case DELANTERO:
			this.defensa = ponerEstadistica((byte)20,(byte)55);
			break;
		case CENTROCAMPISTA:
			this.defensa = ponerEstadistica((byte)40,(byte)88);
			break;
		case DEFENSA:
			this.defensa = ponerEstadistica((byte)70,(byte)94);
			break;
		default:
			break;
		}
	}

	public byte getFisico() {
		return fisico;
	}

	public void setFisico(byte fisico) {
		switch (posicion){
		case DELANTERO:
			this.fisico = ponerEstadistica((byte)60,(byte)85);
			break;
		case CENTROCAMPISTA:
			this.fisico = ponerEstadistica((byte)50,(byte)85);
			break;
		case DEFENSA:
			this.fisico = ponerEstadistica((byte)70,(byte)94);
			break;
		default:
			break;
		}
	}
	
	//Hay que hacer esta funcion e implementarla en el constructor
	public Posicion posicionAleatoriaJugador() {
		Random r=new Random();
		Posicion pos = null;
		byte eleccion=(byte)(r.nextInt(3));
		switch(eleccion) {
		case 0:
			pos=Posicion.DEFENSA;
			break;
		case 1:
			pos=Posicion.CENTROCAMPISTA;
			break;
		case 2:
			pos=Posicion.DELANTERO;
			break;
		}
		
		return pos;
	}
	
	public byte valoracionObtenida(byte ritmo,byte tiro,byte defensa,byte fisico) {
		return (byte)((ritmo+tiro+defensa+fisico)/3.4f);
	}

	
	@Override
	public String toString() {
		return "<"+this.posicion+"> "+getNombre()+" "+getApellidos()+" ("+super.getNacionalidad()+") *"+super.getValoracion()+"* "+"(Precio -> "+super.getPrecio()+"€)"+"\n[ritmo=" + ritmo + " tiro=" + tiro + "]\n[defensa=" + defensa + " fisico=" + fisico
				+ "]\n\n";
	}

	
	

}
