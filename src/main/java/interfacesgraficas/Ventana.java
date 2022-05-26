package interfacesgraficas;

import java.awt.Cursor;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame{
	/**
	 * la clave va a ser un nombre que le ponemos a la pantalla y el valor la pantalla con ese nombre
	 */
	private HashMap<String, JPanel> pantallas;
	
	public Ventana() {
		this.pantallas= new HashMap<String,JPanel>();
		this.pantallas.put("login", new PantallaLogin(this));
		this.pantallas.put("registro", new PantallaRegistro(this));
		
		this.setSize(750,500);
		this.setIconImage(new ImageIcon("./iconos/liluzi.jpg").getImage());
		this.setTitle("Ejemplo interfaces");
		this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		this.setAlwaysOnTop(true);//superpone siempre la ventana
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//importante para que se salga al cerrar la ventana
		
		//this.setEnabled(false); te bloquea la ventana no se puede cerrar
		this.setLocationRelativeTo(null);//centra la ventana
		
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);estas dos lineas es para ponerlo en pantalla
		//this.setUndecorated(true); completa
		this.setResizable(false);// No podrás cambiar el tamaño mas de lo determinado
		this.setContentPane(this.pantallas.get("login"));
		this.setVisible(true);
		
		String s ="";
		s.isBlank();
		
	}
	public void irAPantalla(String nombrePantalla) {
		Iterator it = this.pantallas.values().iterator();
		
		while(it.hasNext()) {
			JPanel actual = (JPanel) it.next();
			actual.setVisible(false);
		}
		this.pantallas.get(nombrePantalla).setVisible(true);
		this.setContentPane(this.pantallas.get(nombrePantalla));
	}
	
		
}
