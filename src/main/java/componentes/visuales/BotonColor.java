package componentes.visuales;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;
/**
 * Clase que determina la apariencia del boton 
 * @author juaan
 *
 */
public class BotonColor extends JButton {
	/**
	 * Constructor que define la apariencia tanto cuando el ratón pasa por encima del botón como cuando sale del espacio que ocupa el botón
	 * @param s
	 */
	public BotonColor(String s) {
		super(s);
		estilosDefault();
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				setForeground(new Color(200, 200, 200));
				setBackground(new Color(25, 25, 50));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				estilosDefault();
			}
		});
	}
	/**
	 * Función que determina la apariencia por defecto del botón
	 */
	private void estilosDefault() {
		this.setForeground(Color.WHITE);
		this.setBackground(Color.DARK_GRAY);
	}

	
}
