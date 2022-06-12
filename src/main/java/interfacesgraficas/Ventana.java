package interfacesgraficas;

import java.awt.Cursor;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Equipo;
import clases.Fase;
import clases.Jugador;
import clases.Persona;
import clases.Usuario;
import enums.Posicion;
/**
 * Clase que hereda de JFrame, y que contendrá a las pantallas (Herederas de JPanel) del programa.
 * @author juaan
 *
 */
public class Ventana extends JFrame{

	/** determina la pantalla en la que el usuario estará **/
	private JPanel pantallaActual;
	/** determina el usuario ya registrado que se logea **/
	protected Usuario usuarioLogado;
	/** determina al equipo creado por el usuario **/
	protected Equipo equipoUsuario;
	/** determina a los jugadores comprados en el mercado que pasarán a ser los suplentes del equipo del usuario **/
	protected ArrayList<Jugador> suplentes;
	/** determina el clip de audio que sonará al iniciar el programa **/
	protected Clip clip;
	String email;
	String pass;
	/**
	 * Constructor de Ventana, que inicializa su tamaño, título e icono, y otras propiedades. Se le pasa por argumentos el email y la contraseña de un usuario existente o String vacios para registrarse y logear manualmente
	 */
	public Ventana(String email,String passUsuario) {
		this.email=email;
		this.pass=passUsuario;
		try {
			AudioInputStream reproductor = AudioSystem.getAudioInputStream(new File("./musica/himnoMadrid.wav"));
			this.clip = AudioSystem.getClip();
			clip.open(reproductor);
			clip.start();
		}catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
			e.printStackTrace();
		}
		this.setSize(850,430);
		this.setLocationRelativeTo(null);
		this.setTitle("Uefa Champions League");
		this.setIconImage(new ImageIcon("./IconoPrincipal.png").getImage());
		this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false); 
		this.pantallaActual=new PantallaLogin(this);
		this.setContentPane(this.pantallaActual);	
		this.setVisible(true); 
	}
	
	/**
	 * Función que se encarga de cambiar entre las distintas pantallas
	 * @param nombrePantalla el nombre de la pantalla que se abrirá
	 */
	public void irAPantalla(String nombrePantalla) {
		this.pantallaActual.setVisible(false);
		this.pantallaActual=null;
		switch(nombrePantalla) {
		case "login":
			this.pantallaActual=new PantallaLogin(this);
			break;
		case "registro":
			this.pantallaActual=new PantallaRegistro(this);
			break;
		case "menu":
			this.pantallaActual=new PantallaMenu(this);
			break;
		case "jugar":
			this.pantallaActual=new PantallaJugarTorneo(this,clip);
			break;
		case "mercado":
			this.pantallaActual=new PantallaMercado(this);
			break;
		case "creacionEquipo":
			this.pantallaActual=new PantallaCreacionEquipo(this);
			break;
		case "alineacion":
			this.pantallaActual=new PantallaAlineacion(this);
			break;
		}
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual); 
	}
	
		
}
