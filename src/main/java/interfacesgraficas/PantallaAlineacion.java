package interfacesgraficas;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JList;

public class PantallaAlineacion extends JPanel{

	private Ventana ventana;
	
	public PantallaAlineacion(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JButton btnNewButton = new JButton("Atr\u00E1s");
		btnNewButton.setBounds(10, 369, 57, 21);
		add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(31, 194, 45, 13);
		add(lblNewLabel_1);
		
		JList list = new JList();
		list.setBounds(137, 116, 57, 167);
		add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(273, 116, 57, 167);
		add(list_1);
		
		JList list_2 = new JList();
		list_2.setBounds(407, 116, 57, 167);
		add(list_2);
		
		JLabel etiquetaFondo = new JLabel("New label");
		etiquetaFondo.setIcon(new ImageIcon(PantallaAlineacion.class.getResource("/imag/Alineacion.png")));
		etiquetaFondo.setBounds(0, 0, 600, 400);
		add(etiquetaFondo);
		
	}
}
