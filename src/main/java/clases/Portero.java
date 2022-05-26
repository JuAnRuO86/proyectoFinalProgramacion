package clases;

import java.sql.SQLException;
import java.sql.Statement;

import enums.Posicion;
import utils.ConexionBD;

public class Portero extends Jugador{

	private byte estirada;
	private byte parada;
	private byte reflejos;
	private byte posicionamiento;
	
	public Portero(String nombre, String apellidos, String nacionalidad) throws SQLException {
		super();
		
		//Esto puede ser motivo de error
		this.setPosicion(Posicion.PORTERO);
		this.setEstirada(estirada);
		this.setParada(parada);
		this.setReflejos(reflejos);
		this.setPosicionamiento(posicionamiento);
		this.setValoracion(valoracionObtenida(estirada,parada,reflejos,posicionamiento));
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
	
//	public Portero(String nombre, String apellidos, String nacionalidad) {
//		super(nombre, apellidos, nacionalidad, Posicion.PORTERO);
//		this.setEstirada(estirada);
//		this.setParada(parada);
//		this.setReflejos(reflejos);
//		this.setPosicionamiento(posicionamiento);
//		super.setValoracion(valoracionObtenida(estirada,parada,reflejos,posicionamiento));
//		super.setPrecio(precioPersona(super.getValoracion()));
//	}

	public byte getEstirada() {
		return estirada;
	}

	public void setEstirada(byte estirada) {
		this.estirada = ponerEstadistica((byte)50,(byte)99);
	}

	public byte getParada() {
		return parada;
	}

	public void setParada(byte parada) {
		this.parada = ponerEstadistica((byte)50,(byte)99);
	}

	public byte getReflejos() {
		return reflejos;
	}

	public void setReflejos(byte reflejos) {
		this.reflejos = ponerEstadistica((byte)50,(byte)99);
	}

	public byte getPosicionamiento() {
		return posicionamiento;
	}

	public void setPosicionamiento(byte posicionamiento) {
		this.posicionamiento = ponerEstadistica((byte)50,(byte)99);
	}
	
	
	public byte valoracionObtenida(byte estirada,byte parada,byte reflejos,byte posicionamiento) {
		return (byte)((estirada+parada+reflejos+posicionamiento)/3.4f);
	}
	
	@Override
	public String toString() {
		return "<"+this.posicion+"> "+this.getNombre()+" "+this.getApellidos()+" ("+super.getNacionalidad()+") *"+super.getValoracion()+"* "+"(Precio -> "+super.getPrecio()+"€)"+"\n[estirada=" + estirada + " parada=" + parada + "]\n[reflejos=" + reflejos + " posicionamiento=" + posicionamiento
				+ "]";
	}
}
