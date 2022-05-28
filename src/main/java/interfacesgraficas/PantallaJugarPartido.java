package interfacesgraficas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaJugarPartido extends JPanel{

	private Ventana ventana;
	private JTextField txtVs;
	private JTextField txtClasificacin;
	
	public PantallaJugarPartido(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(363, 0, 87, 300);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 26, 87, 274);
		panel.add(scrollPane);
		
		txtClasificacin = new JTextField();
		txtClasificacin.setText("CLASIFICACI\u00D3N");
		txtClasificacin.setBounds(0, 0, 87, 26);
		panel.add(txtClasificacin);
		txtClasificacin.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Jornada 1");
		lblNewLabel.setBounds(162, 187, 63, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(81, 215, 45, 13);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(242, 215, 45, 13);
		add(lblNewLabel_2);
		
		txtVs = new JTextField();
		txtVs.setHorizontalAlignment(SwingConstants.CENTER);
		txtVs.setText("vs");
		txtVs.setBounds(55, 202, 259, 40);
		add(txtVs);
		txtVs.setColumns(10);
		
		JButton btnNewButton = new JButton("Empezar Partido");
		btnNewButton.setBounds(119, 252, 132, 21);
		add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(27, 10, 301, 170);
		add(panel_1);
		
		JButton etiquetaAtras = new JButton("Atr\u00E1s");
		etiquetaAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("menu");
			}
		});
		etiquetaAtras.setBounds(10, 269, 57, 21);
		add(etiquetaAtras);
		
		
		
	}
}
