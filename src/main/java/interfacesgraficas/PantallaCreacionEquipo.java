package interfacesgraficas;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PantallaCreacionEquipo extends JPanel{
	private	Ventana ventana;
	private JTextField campoNombre;

	public PantallaCreacionEquipo(Ventana v) {
		setLayout(null);
		
		JButton botonCrearEquipo = new JButton("Crear Equipo");
		botonCrearEquipo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombreEquipo = campoNombre.getText();
				
			}
		});
		botonCrearEquipo.setForeground(Color.BLACK);
		botonCrearEquipo.setFont(new Font("MV Boli", Font.BOLD, 18));
		botonCrearEquipo.setBounds(203, 317, 193, 57);
		add(botonCrearEquipo);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(344, 95, 127, 26);
		add(campoNombre);
		campoNombre.setColumns(10);
		
		JLabel etiquetaNombre = new JLabel("Nombre");
		etiquetaNombre.setFont(new Font("Verdana", Font.BOLD, 14));
		etiquetaNombre.setBounds(131, 95, 73, 20);
		add(etiquetaNombre);
		
		JLabel etiquetaPresupuesto = new JLabel("PRESUPUESTO");
		etiquetaPresupuesto.setVerticalAlignment(SwingConstants.TOP);
		etiquetaPresupuesto.setFont(new Font("Palatino Linotype", Font.ITALIC, 38));
		etiquetaPresupuesto.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaPresupuesto.setBounds(93, 198, 410, 38);
		add(etiquetaPresupuesto);
		
		JPanel panel = new JPanel();
		panel.setBounds(131, 246, 329, 45);
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JRadioButton presupuesto100k = new JRadioButton("100k");
		GridBagConstraints gbc_presupuesto100k = new GridBagConstraints();
		gbc_presupuesto100k.insets = new Insets(0, 0, 0, 5);
		gbc_presupuesto100k.gridx = 2;
		gbc_presupuesto100k.gridy = 0;
		panel.add(presupuesto100k, gbc_presupuesto100k);
		presupuesto100k.setFont(new Font("Candara", Font.ITALIC, 18));
		
		JRadioButton presupuesto250k = new JRadioButton("250k");
		GridBagConstraints gbc_presupuesto250k = new GridBagConstraints();
		gbc_presupuesto250k.insets = new Insets(0, 0, 0, 5);
		gbc_presupuesto250k.gridx = 4;
		gbc_presupuesto250k.gridy = 0;
		panel.add(presupuesto250k, gbc_presupuesto250k);
		presupuesto250k.setFont(new Font("Candara", Font.ITALIC, 18));
		
		JRadioButton presupuesto500k = new JRadioButton("500k");
		GridBagConstraints gbc_presupuesto500k = new GridBagConstraints();
		gbc_presupuesto500k.insets = new Insets(0, 0, 0, 5);
		gbc_presupuesto500k.gridx = 6;
		gbc_presupuesto500k.gridy = 0;
		panel.add(presupuesto500k, gbc_presupuesto500k);
		presupuesto500k.setFont(new Font("Candara", Font.ITALIC, 18));
		
		ButtonGroup grupoPresupuesto=new ButtonGroup();
		grupoPresupuesto.add(presupuesto100k);
		grupoPresupuesto.add(presupuesto250k);
		grupoPresupuesto.add(presupuesto500k);

	
	
	
	
	}
}
