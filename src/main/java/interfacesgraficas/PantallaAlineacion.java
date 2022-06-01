package interfacesgraficas;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

public class PantallaAlineacion extends JPanel{

	private Ventana ventana;
	
	public PantallaAlineacion(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JButton btnNewButton = new JButton("Atr\u00E1s");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("menu");
			}
		});
		btnNewButton.setBounds(10, 369, 57, 21);
		add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Portero");
		lblNewLabel_1.setBounds(21, 194, 45, 13);
		add(lblNewLabel_1);
		
		JList list = new JList();
		list.setBounds(76, 88, 57, 167);
		add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(197, 88, 57, 167);
		add(list_1);
		
		JList list_2 = new JList();
		list_2.setBounds(308, 88, 57, 167);
		add(list_2);
		
		JLabel etiquetaFondo = new JLabel("New label");
		etiquetaFondo.setIcon(new ImageIcon(PantallaAlineacion.class.getResource("/imag/Alineacion.png")));
		etiquetaFondo.setBounds(-39, 32, 600, 400);
		add(etiquetaFondo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(158, 144, 29, 21);
		add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Formacion del entrenador: 2-1-1");
		lblNewLabel_2.setBounds(396, 78, 45, 13);
		add(lblNewLabel_2);
		
	}
}
