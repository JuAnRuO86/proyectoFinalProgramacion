package interfacesgraficas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import clases.Equipo;
import clases.Funciones;
import clases.Partido;
import clases.Torneo;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.ImageIcon;

public class PantallaJugarPartido extends JPanel{

	private Ventana ventana;
	private Torneo torneo;
	
	public PantallaJugarPartido(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JButton botonEmpezar = new JButton("Empezar Torneo");
		botonEmpezar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			try {
				torneo.jugarTorneo();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		botonEmpezar.setBounds(231, 304, 132, 21);
		add(botonEmpezar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(25, 21, 549, 236);
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JButton etiquetaAtras = new JButton("Atr\u00E1s");
		etiquetaAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("menu");
			}
		});
		etiquetaAtras.setBounds(10, 369, 57, 21);
		add(etiquetaAtras);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PantallaJugarPartido.class.getResource("/imag/FondoJugarTorneo.png")));
		lblNewLabel.setBounds(0, 0, 600, 400);
		add(lblNewLabel);
		
		
		
	}
}
