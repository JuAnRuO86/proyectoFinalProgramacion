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

public class Ventana extends JFrame{
	/**
	 * la clave va a ser un nombre que le ponemos a la pantalla y el valor la pantalla con ese nombre
	 */
	//private HashMap<String, JPanel> pantallas;
	private JPanel pantallaActual;
	protected Usuario usuarioLogado;
	protected Persona personaComprada;
	protected Equipo equipoUsuario;
	protected Fase fase;
//	protected TreeMap<Posicion,Jugador> suplentes;
	protected Clip clip;

	
	public Ventana() {
		
		try {
			AudioInputStream reproductor = AudioSystem.getAudioInputStream(new File("./musica/himnoMadrid.wav"));
			this.clip = AudioSystem.getClip();
			clip.open(reproductor);
			clip.start();
			}catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
				
			}
		this.setSize(850,430);
		this.setLocationRelativeTo(null);//Poner justo dps de determinar el tamaño, posiciona la ventana céntrica
		
		
		//PANTALLA COMPLETA LAS DOS LINEAS SIGUIENTES
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Pone de primeras en pantalla completa pero al minimizar conserva el tamaño predeterminado
		//this.setUndecorated(true); //Como si fuera el f11 sin bordes la ventana
		
		this.setTitle("Uefa Champions League");
		this.setIconImage(new ImageIcon("./IconoPrincipal.png").getImage()); //ImageIcon recibe una ruta
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//this.setAlwaysOnTop(true); //Para que no puedas poner nada por encima de la ventana, ninguna otra ventana o lo que seas
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Cerrará el programa cuando cerremos la ventana
//		this.setEnabled(false); //No se puede pinchar ni hacer nada
		this.setResizable(false); // No podrás cambiar el tamaño mas de lo determinado
		
		this.pantallaActual=new PantallaLogin(this);
		this.setContentPane(this.pantallaActual);	//Siempre antes del setVisible, nos pone una nueva ventana de login
		this.setVisible(true); //Tiene que ir al final para que se apliquen todos los cambios y se vea
	}
	
	
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
			this.pantallaActual=new PantallaJugarPartido(this,clip);
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
