package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

import enums.Posicion;
import utils.ConexionBD;

public class Equipo extends ElementoConNombre {

	protected int presupuesto;
	protected short valoracion;
	private  ArrayList<Jugador> jugadores;
	private Entrenador entrenador;
	
	public Equipo() {
		super();
	}
	
	public Equipo(String nombre,int presupuesto,Entrenador entrenador) throws SQLException {
		super();
		
		this.setEntrenador(entrenador);
		this.setJugadores(generarEquipo(entrenador));
		this.setValoracion(valoracionObtenida(jugadores,entrenador));
		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate(
				"insert into equipo (nombre,presupuesto,valoracion,entrenador) values('" + nombre + "'," + presupuesto +","+ valoracion +",'" + entrenador.getNombre()+" "+entrenador.getApellidos() +"')") > 0) {
			
			this.setNombre(nombre);
			this.setPresupuesto(presupuesto);
			
		}else {
			
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido insertar el equipo");
		}
		ConexionBD.desconectar();
	}
	public Equipo(String nombre,short valoracion)  {
		super();
		this.setValoracion(valoracion);		
		this.setNombre(nombre);			
	}
	public Equipo(String nombre)  {
		super();
		this.setNombre(nombre);			
	}
//	public Equipo(String nombre, float presupuesto,ArrayList<Jugador> jugadores,Entrenador entrenador) {
//		
//		super(nombre);
//		this.setPresupuesto(presupuesto);
//		this.setJugadores(jugadores);
//		this.setEntrenador(entrenador);
//		this.setValoracion(valoracionObtenida(jugadores,entrenador));
//	}
	
	public int getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}
	public short getValoracion() {
		return valoracion;
	}
	public void setValoracion(short valoracion) {
		this.valoracion = valoracion;
	}
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	public Entrenador getEntrenador() {
		return entrenador;
	}
	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}	


	public short valoracionObtenida(ArrayList<Jugador> jugadores,Entrenador entrenador) {
		short valTotal=0;
		for(byte i=0;i<jugadores.size();i++) {
			valTotal+=jugadores.get(i).getValoracion();
		}
		
		return (short)(valTotal+entrenador.getNivelTactico());
	}
	
	public static ArrayList<Jugador> generarEquipo(Entrenador entrenador) throws SQLException{
		ArrayList<Jugador> equipo=new ArrayList<Jugador>();
		byte[] formacion=entrenador.getFormacion();
		
		for(byte i=0;i<entrenador.getFormacion().length;i++) {
			for(byte j=0;j<formacion[i];j++) {
				switch(i) {
				case 0:
					equipo.add(new JugadorDeCampo(Persona.generarNombresAleatorios(),Persona.apellidosAleatorios(),Persona.generarNacionalidades(),Posicion.DEFENSA));
					break;
				case 1:
					equipo.add(new JugadorDeCampo(Persona.generarNombresAleatorios(),Persona.apellidosAleatorios(),Persona.generarNacionalidades(),Posicion.CENTROCAMPISTA));
					break;
				case 2:
					equipo.add(new JugadorDeCampo(Persona.generarNombresAleatorios(),Persona.apellidosAleatorios(),Persona.generarNacionalidades(),Posicion.DELANTERO));
					break;
				}
			}
		}
		equipo.add(new Portero(Persona.generarNombresAleatorios(),Persona.apellidosAleatorios(),Persona.generarNacionalidades()));
		return equipo;
	}

	public static String generarNombresEquiposAleatorio() {
		ArrayList<String> nombresEquipo = new ArrayList<String>(Arrays.asList("Robin Hood","Carabobo","Semen Padang","Huachipato ","Abuelos F.C.","Limón F.C.","Independiente Bigote","Sacachispas","Rico Pollo","Parrillas One","Tafea FC","Cuervos del Fin del Mundo","Correcaminos ","Venta de Baños","Toto African SC","PS Barito Putera","Nadroga","Minabo de Kiev","Vodka Juniors","Real Suciedad","Aston Birra","Yayo Vallecano","Roberto","Pasto de Grama","Real Furcia","Unión de casados","Los leones engripados","Balones pinchados","Kasko da lama","West Jamon","El Combo Alpinito","Los patadas al tobillo","Viejos pellejos","Jugadores de barrio","Ganadores natos","Árbitro penalty","No sabemos ganar","Real Alcohólicos","Nottingham Miedo","Coca Juniors","Unión Penosa"));
		Random r = new Random();
		String nombre;
		
		nombre=nombresEquipo.get(r.nextInt(nombresEquipo.size()));
		return nombre;
	}
	public static String generarNombresEquiposAleatorio(ArrayList<String> nombres) {
		ArrayList<String> nombresEquipo = new ArrayList<String>(Arrays.asList("Robin Hood","Carabobo","Semen Padang","Huachipato ","Abuelos F.C.","Limón F.C.","Independiente Bigote","Sacachispas","Rico Pollo","Parrillas One","Tafea FC","Cuervos del Fin del Mundo","Correcaminos ","Venta de Baños","Toto African SC","PS Barito Putera","Nadroga","Minabo de Kiev","Vodka Juniors","Real Suciedad","Aston Birra","Yayo Vallecano","Roberto","Pasto de Grama","Real Furcia","Unión de casados","Los leones engripados","Balones pinchados","Kasko da lama","West Jamon","El Combo Alpinito","Los patadas al tobillo","Viejos pellejos","Jugadores de barrio","Ganadores natos","Árbitro penalty","No sabemos ganar","Real Alcohólicos","Nottingham Miedo","Coca Juniors","Unión Penosa"));
		Random r = new Random();
		String equipo;
		
		for(byte i=0;i<nombres.size();i++) {
			for(byte j=0;j<nombresEquipo.size();j++) {
				if((nombres.get(i)).equals(nombresEquipo.get(j))) {
					nombresEquipo.remove(j);
				}
			}
		}
		equipo=nombresEquipo.get(r.nextInt(nombresEquipo.size()));
		return equipo;
	}
	
		
	@Override
	public String toString() {
		return " "+getNombre()+" [presupuesto=" + presupuesto + ", valoracion=" + this.getValoracion()+ "]\n |         |\n |         |\n |JUGADORES|   "+entrenador+"\n |         |\n |         |\n \\/        \\/\n" + jugadores;
	}
	

	
}
