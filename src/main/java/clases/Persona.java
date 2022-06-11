package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import utils.ConexionBD;

/**
 * Clase que seg�n sus instancias determinan a una persona
 * @author juaan
 *
 */
public class Persona extends ElementoConNombre{
	/** los apellidos de la persona **/
	private String apellidos;
	/** la nacionalidad de la persona **/
	private String nacionalidad;
	/** la valoracion seg�n las caracter�sticas de dicha persona**/
	protected byte valoracion;
	/** el precio que tendr� dicha persona **/
	protected int precio;
	/**
	 * Constructor vac�o para llamarlo en las subclases 
	 */
	public Persona() {
		super();
	}
	/**
	 * Getter de apellidos
	 * @return los apellidos de la persona
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * Setter de apellidos
	 * @param apellidos los apellidos de la persona
	 */
	public void setApellidos(String apellidos){
		this.apellidos=apellidos;
	}
	/**
	 * Getter de nacionalidad
	 * @return la nacionalidad de la persona
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}
	/**
	 * Setter de nacionalidad
	 * @param nacionalidad la nacionalidad de la persona
	 */
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	/**
	 * Getter de valoracion
	 * @return la valoracion de la persona
	 */
	public byte getValoracion() {
		return valoracion;
	}
	/**
	 * Setter de valoracion, ser� como m�ximo hasta 99
	 * @param valoracion la valoracion de la persona
	 */
	public void setValoracion(byte valoracion) {
		if(valoracion>99) {
			this.valoracion=99;
		}else {
			this.valoracion = valoracion;
		}
	}
	/**
	 * Getter de precio
	 * @return el precio de la persona
	 */
	public int getPrecio() {
		return precio;
	}
	/**
	 * Setter de precio
	 * @param precio el precio de la persona
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	/**
	 * Funci�n que generar� la valoraci�n total de la persona dependiendo de cuatro atributos de dicha persona
	 * @param e1 atributo 1
	 * @param e2 atributo 2
	 * @param e3 atributo 3
	 * @param e4 atributo 4
	 * @return la valoracion total obtenida
	 */
	public byte valoracionObtenida(byte e1,byte e2,byte e3,byte e4) {	
		return (byte)((short)(e1+e2+e3+e4)/4);
	}
	/**
	 * Funci�n que generar� el precio de la persona dependiendo de la valoracion
	 * @param valoracion la valoracion de dicha persona
	 * @return el precio de la persona
	 */
	public int precioPersona(byte valoracion)  {
		Random r=new Random();
		if(valoracion==99) {
			return r.nextInt(2000000-1800000)+1800000;
		//Rango de precio valoracion>90 (100k)
		}else if(valoracion>90 && valoracion<99) {
			int max=1000000+(100000*(valoracion-90));
			int min=max-100000;
			return r.nextInt(max-min)+min;
		//Rango de precio valoracion>80 (50k)
		}else if(valoracion>80 && valoracion<=90) {
			int max=500000+(50000*(valoracion-80));
			int min=max-50000;
			return r.nextInt(max-min)+min;
		//Rango de precio valoracion>70 (25k)
		}else if(valoracion>70 && valoracion<=80) {
			int max=250000+(25000*(valoracion-70));
			int min=max-25000;
			return r.nextInt(max-min)+min;
		//Rango de precio valoracion>60 (15k)
		}else if(valoracion>60 && valoracion<=70) {
			int max=100000+(15000*(valoracion-60));
			int min=max-15000;
			return r.nextInt(max-min)+min;
		}else {
			return 0;
		}
	}
	
	/**
	 * Funci�n que generar� los apellidos de la persona aleatoriamente entre los disponibles 
	 * @return los apellidos de la persona
	 */
	public static String apellidosAleatorios() {
		String[] apellidosPosible = {"Garc�a","Rodr�guez","Gonz�lez","Fern�ndez","L�pez","Mart�nez","S�nchez","P�rez","G�mez","Mart�n","Smith","Jones","Taylor","Brown","Williams","Wilson","Johnson","Davies","Robinson","Wright","Thompson","Evans","Walker","White","Roberts","Green","Hall","Thomas","Clark","Jackson","Wood","Harris","Edwards","Turner","Martin","Cooper","Hill","Ward","Hughes","Moore","King","Lee","Da Silva","Dos Santos","Pereira","Alves","Ferreira","Rodrigues","Silva","De Oliveira","De Souza","Gomes","Barbosa","Vieira","Fernandes","Dias","Ronaldo","Nunes","Martin","Bernard","Robert","Richard","Durand","Dubois","Moreau","Alarc�n"};		
		Random aleatorio = new Random();
		byte pos=(byte) (aleatorio.nextInt(apellidosPosible.length));
		String apellido1 = apellidosPosible[pos];		
		pos=(byte) (aleatorio.nextInt(apellidosPosible.length));
		String apellido2 = apellidosPosible[pos];
		
		if (apellido2.equals(apellido1)) {
			return apellidosAleatorios();
		}else {
			return apellido1+" "+apellido2;
		}		
	}
	
	/**
	 * Funci�n que generar� aleatoriamente entre los nombres disponibles el nombre de la persona
	 * @return el nombre de la persona
	 */
	public static String generarNombresAleatorios() {
		String[] nombresHombre={"Hugo","Mateo","Martin","Lucas","Leo","Daniel","Alejandro","Manuel","Pablo","Alvaro","Antonio","Juan","Francisco","Dario","Cristian","Manolo","Paulo","Carlos","Pedro","Jorge","Luis","Andr�s","Roberto","Adriano","Fabio","Leonardo","Enzo","Alexis","Alfred","Alex","Gabriel","Aitor","�ngel","Rafa","Alberto","Kiko","Enrique","Baltasar","Eloy","Alfonso","H�ctor","Dami�n","Cosmo","Ezio","Aquiles","Calix","Esteban","Sergio","Michael","Ares","Arsenio","Ethan","Sebasti�n","Bart","Cristiano","Christopher","Dimitri","Eduardo","David","Jose","Ferland","Eustaquio","Fernando","Ad�n","Alonso","Alfredo",};
		Random r = new Random();
		String nombre;
		nombre=nombresHombre[r.nextInt(nombresHombre.length)];
		return nombre;
	}
	/**
	 * Funci�n que generar� la nacionalidad aleatoriamente de la persona entre las disponibles
	 * @return la nacionalidad de la persona
	 */
	public static String generarNacionalidades() {
		String[] nacionalidades= {"Espa�a","Francia","Italia","Alemania","Portugal","Polonia","B�lgica","Austria","Brasil","Argentina","Colombia","Venezuela","Reino Unido","Egipto","Bulgaria","Camer�n","Chile","Corea Del Sur","Croacia","Dinamarca","Escocia","Estados Unidos","Irlanda","M�xico","Pa�ses Bajos","Ucrania"};
		Random r = new Random();
		String nacionalidad;
		nacionalidad=nacionalidades[r.nextInt(nacionalidades.length)];
		return nacionalidad;
	}
	
	
	
	
	
	
	
}
