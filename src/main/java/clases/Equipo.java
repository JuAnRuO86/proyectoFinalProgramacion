package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

import enums.Posicion;
import excepciones.NombreValidoException;
import excepciones.PresupuestoInvalidoException;
import utils.ConexionBD;
/**
 * Clase que por las instancias que tiene determina a un equipo de f�tbol
 * @author juaan
 *
 */
public class Equipo extends ElementoConNombre {
	/** el presupuesto que tendr� el equipo **/
	protected int presupuesto;
	/** la valoracion que tendra el equipo **/
	protected short valoracion;
	/** los jugadores que formaran el equipo **/
	private  ArrayList<Jugador> jugadores;
	/** el entrenador que tendra el equipo **/
	private Entrenador entrenador;
	
	/**
	 * Constructor que generar� el equipo con los jugadores generados aleatoriamente y la valoracion generada a partir de ellos, se le determinar� el nombre, presupuesto y entrenador pasandolos por argumentos
	 * @param nombre el nombre del equipo
	 * @param presupuesto el presupuesto del equipo
	 * @param entrenador el entrenador que tendr� el equipo
	 * @throws SQLException
	 * @throws NombreValidoException
	 * @throws PresupuestoInvalidoException
	 */
	public Equipo(String nombre,int presupuesto,Entrenador entrenador) throws SQLException, NombreValidoException, PresupuestoInvalidoException {
		super();
		
		if(!presupuestoValido(presupuesto)) {
			throw new PresupuestoInvalidoException("El presupuesto no puede ser 0");
		}

		this.setNombre(nombre);
		this.setEntrenador(entrenador);
		this.setJugadores(generarEquipo(entrenador));
		this.setValoracion(valoracionObtenida(jugadores,entrenador));
		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate(
				"insert into equipo (nombre,presupuesto,valoracion,entrenador) values('" + nombre + "'," + presupuesto +","+ valoracion +",'" + entrenador.getNombre()+" "+entrenador.getApellidos() +"')") > 0) {
			
			this.setPresupuesto(presupuesto);
			
		}else {
			
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido insertar el equipo");
		}
		ConexionBD.desconectar();
	}
	/**
	 * Constructor que generar� un equipo que servir� para traer de la base de datos los ganadores de cada partido, solo necesitaremos sus nombres y sus valoraciones para que continuen el torneo
	 * @param nombre el nombre del equipo
	 * @param valoracion la valoracion del equipo
	 * @throws NombreValidoException
	 */
	public Equipo(String nombre,short valoracion) throws NombreValidoException  {
		super();
		this.setNombre(nombre);		
		this.setValoracion(valoracion);		
	}
	/**
	 * Funci�n que determina la validez del presupuesto
	 * @param presupuesto el presupuesto del equipo
	 * @return el presupuesto del equipo si es v�lido
	 */
	private static boolean presupuestoValido(int presupuesto) {
		return !(presupuesto==0);
	}
	/**
	 * Getter de presupuesto
	 * @return el presupuesto del equipo
	 */
	public int getPresupuesto() {
		return presupuesto;
	}
	/**
	 * Setter de presupuesto, no podr� ser 0
	 * @param presupuesto el presupuesto del equipo
	 * @throws PresupuestoInvalidoException
	 */
	public void setPresupuesto(int presupuesto) throws PresupuestoInvalidoException {
		if(!presupuestoValido(presupuesto)) {
			throw new PresupuestoInvalidoException("El presupuesto no puede ser 0");
		}
		this.presupuesto = presupuesto;
	}
	/**
	 * Getter de valoracion
	 * @return la valoracion del equipo
	 */
	public short getValoracion() {
		return valoracion;
	}
	/**
	 * Setter de valoracion
	 * @param valoracion la valoracion del equipo
	 */
	public void setValoracion(short valoracion) {
		this.valoracion = valoracion;
	}
	/**
	 * Getter de jugadores
	 * @return los jugadores del equipo
	 */
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}
	/**
	 * Setter de jugadores
	 * @param jugadores los jugadores del equipo
	 */
	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	/**
	 * Getter de entranador
	 * @return el entrenador del equipo
	 */
	public Entrenador getEntrenador() {
		return entrenador;
	}
	/**
	 * Setter del entrenador
	 * @param entrenador el entrenador del equipo
	 */
	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}	

	/**
	 * Funci�n que generar� la valoracion del equipo mediante la valoracion de los jugadores y el nivel tactico del entrenador
	 * @param jugadores jugadores del equipo
	 * @param entrenador entrenador del equipo
	 * @return la valoracion del equipo
	 */
	public short valoracionObtenida(ArrayList<Jugador> jugadores,Entrenador entrenador) {
		short valTotal=0;
		for(byte i=0;i<jugadores.size();i++) {
			valTotal+=jugadores.get(i).getValoracion();
		}
		
		return (short)(valTotal+entrenador.getNivelTactico());
	}
	/**
	 * Funci�n que recibir� por argumentos el entrenador y mediante su formaci�n generar� los jugadores con nombres,apellidos,nacionalidades y estadisticas aleatorias 
	 * @param entrenador el entrenador del equipo
	 * @return el equipo con todos los jugadores generados a partir de la formacion del entrenador
	 * @throws SQLException
	 * @throws NombreValidoException
	 */
	public static ArrayList<Jugador> generarEquipo(Entrenador entrenador) throws SQLException, NombreValidoException{
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
	/**
	 * Funci�n que generar� un nombre de equipo aleatorio entre los disponibles
	 * @return nombre del equipo
	 */
	public static String generarNombresEquiposAleatorio() {
		ArrayList<String> nombresEquipo = new ArrayList<String>(Arrays.asList("Robin Hood","Carabobo","Semen Padang","Huachipato ","Abuelos F.C.","Lim�n F.C.","Independiente Bigote","Sacachispas","Rico Pollo","Parrillas One","Tafea FC","Cuervos del Fin del Mundo","Correcaminos ","Venta de Ba�os","Toto African SC","PS Barito Putera","Nadroga","Minabo de Kiev","Vodka Juniors","Real Suciedad","Aston Birra","Yayo Vallecano","Roberto","Pasto de Grama","Real Furcia","Uni�n de casados","Los leones engripados","Balones pinchados","Kasko da lama","West Jamon","El Combo Alpinito","Los patadas al tobillo","Viejos pellejos","Jugadores de barrio","Ganadores natos","�rbitro penalty","No sabemos ganar","Real Alcoh�licos","Nottingham Miedo","Coca Juniors","Uni�n Penosa"));
		Random r = new Random();
		String nombre;
		
		nombre=nombresEquipo.get(r.nextInt(nombresEquipo.size()));
		return nombre;
	}
	/**
	 * Funci�n que generar� un nombre ded equipo aleatorio entre los disponibles, se le pasar� por argumentos los nombres que revisar� entre los disponibles para no volver a elegirlos y no repetir nombres
	 * @param nombres conjunto de nombres que no podr�n ser elegidos
	 * @return nombre de equipo
	 */
	public static String generarNombresEquiposAleatorio(ArrayList<String> nombres) {
		ArrayList<String> nombresEquipo = new ArrayList<String>(Arrays.asList("Robin Hood","Carabobo","Semen Padang","Huachipato ","Abuelos F.C.","Lim�n F.C.","Independiente Bigote","Sacachispas","Rico Pollo","Parrillas One","Tafea FC","Cuervos del Fin del Mundo","Correcaminos ","Venta de Ba�os","Toto African SC","PS Barito Putera","Nadroga","Minabo de Kiev","Vodka Juniors","Real Suciedad","Aston Birra","Yayo Vallecano","Roberto","Pasto de Grama","Real Furcia","Uni�n de casados","Los leones engripados","Balones pinchados","Kasko da lama","West Jamon","El Combo Alpinito","Los patadas al tobillo","Viejos pellejos","Jugadores de barrio","Ganadores natos","�rbitro penalty","No sabemos ganar","Real Alcoh�licos","Nottingham Miedo","Coca Juniors","Uni�n Penosa"));
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
	
	/**
	 * toString de la clase equipo, muestra formateada toda la informaci�n del mismo
	 * @return String con toda la informaci�n del equipo
	 */
	@Override
	public String toString() {
		return " "+getNombre()+" [presupuesto=" + presupuesto + ", valoracion=" + this.getValoracion()+ "]\n |         |\n |         |\n |JUGADORES|   "+entrenador+"\n |         |\n |         |\n \\/        \\/\n" + jugadores;
	}
	

	
}
