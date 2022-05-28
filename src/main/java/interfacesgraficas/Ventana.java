package interfacesgraficas;

import java.awt.Cursor;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Usuario;

public class Ventana extends JFrame{
	/**
	 * la clave va a ser un nombre que le ponemos a la pantalla y el valor la pantalla con ese nombre
	 */
	//private HashMap<String, JPanel> pantallas;
	private JPanel pantallaActual;
	protected Usuario usuarioLogado;
	
	public Ventana() {
		this.setSize(600,400);
		this.setLocationRelativeTo(null);//Poner justo dps de determinar el tamaño, posiciona la ventana céntrica
		
		
		//PANTALLA COMPLETA LAS DOS LINEAS SIGUIENTES
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Pone de primeras en pantalla completa pero al minimizar conserva el tamaño predeterminado
		//this.setUndecorated(true); //Como si fuera el f11 sin bordes la ventana
		
		this.setTitle("Ejemplo interfaces Tema 11");
		this.setIconImage(new ImageIcon("./iconos/iconoPrincipal.png").getImage()); //ImageIcon recibe una ruta
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
			this.pantallaActual=new PantallaJugarPartido(this);
			break;
		}
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual); 
	}
	
		
}
