package principal;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import clases.Entrenador;
import clases.Equipo;
import clases.Fase;
import clases.Jugador;
import clases.JugadorDeCampo;
import clases.Partido;
import clases.Persona;
import clases.Portero;
import clases.Torneo;
import enums.Posicion;
import interfacesgraficas.Ventana;
import utils.ConexionBD;
import clases.Funciones;
/**
 * Clase principal, donde se desarrollará el juego hasta que acabe
 * 
 * @author juaan
 *
 */
public class Principal {
	/**
	 * Función principal. Se le pasa por argumentos el email y la contraseña de un usuario ya registrado, solo tendrá que interactuar con el boton de logearte para empezar, si no se le pasa por argumentos, entonces, primero tendrás que registrar un nuevo usuario y luego iniciar sesión con el mismo. Una vez logeado tendrás que crear un equipo con las indicaciones que se de y accederas posteriormente al menu el cual tendrá tres pantallas a elegir y poder desplazarte libremente entre ellas, la primera pantalla es la de jugar el torneo que una vez entres en esa pantalla e inicies el torneo habrá finalizado el programa, la segunda pantalla sería la alineacion del equipo del usuario donde lo podrás ver con más exactitud los jugadores y sus valoraciones etc, y por tercero y ultima pantalla sería al del mercado donde podrás comprar nuevos jugadores que aparezcan para tu equipo	* 
	 * @param args utilizados.
	 */
	public static void main(String[] args) {
	
		if(args.length>0) {
			String nombre="";
			for(byte i=0;i<args.length;i++) {
				if(i==0) {
					nombre=args[i];
				}else {
					Ventana ventana=new Ventana(nombre,args[i]);	
				}
			}
		}else {
			Ventana ventana=new Ventana("","");	

		}
		
		
		
		
		
	}
}