package interfacesgraficas;

import javax.swing.JPanel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.SwingConstants;

import clases.Persona;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Clase que hereda de JPanel, y que contendrá las funcionalidades de un menu donde puedes acceder a tres nuevas pantallas.
 * @author juaan
 *
 */
public class PantallaMenu extends JPanel{
	/** la ventana principal **/
	private	Ventana ventana;

	/**
	 * Constructor de PantallaMenu que contendrá distintos campos, etiquetas y botones con los cuales accederás a nuevas pantallas
	 * @param v la ventana principal
	 */
	public PantallaMenu(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JLabel FotoKB = new JLabel("New label");
		FotoKB.setIcon(new ImageIcon(PantallaMenu.class.getResource("/imag/KBMenu1.png")));
		FotoKB.setBounds(445, 91, 155, 309);
		add(FotoKB);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 91, 440, 95);
		add(panel);
		panel.setLayout(null);
		
		JButton botonJugar = new JButton("Jugar Torneo");
		
		botonJugar.setBounds(23, 24, 140, 40);
		botonJugar.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(botonJugar);
		botonJugar.setAlignmentY(1.0f);
		
		JLabel fondoJugarPartido = new JLabel("New label");
		fondoJugarPartido.setIcon(new ImageIcon(PantallaMenu.class.getResource("/imag/menuJugar.png")));
		fondoJugarPartido.setBounds(0, 0, 440, 95);
		panel.add(fondoJugarPartido);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 184, 440, 113);
		add(panel_1);
		
		JButton botonAlineacion = new JButton("Alineaci\u00F3n");
		botonAlineacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			ventana.irAPantalla("alineacion");
			}
		});
		botonAlineacion.setBounds(144, 37, 140, 40);
		panel_1.add(botonAlineacion);
		
		JLabel fondoAlineacion = new JLabel("New label");
		fondoAlineacion.setForeground(Color.WHITE);
		fondoAlineacion.setBackground(Color.BLACK);
		fondoAlineacion.setIcon(new ImageIcon(PantallaMenu.class.getResource("/imag/menuAlineacion.png")));
		fondoAlineacion.setBounds(0, 0, 440, 113);
		panel_1.add(fondoAlineacion);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(0, 295, 440, 105);
		add(panel_1_1);
		
		JButton botonCerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		botonCerrarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("login");
			}
		});
		botonCerrarSesion.setBounds(10, 74, 125, 21);
		panel_1_1.add(botonCerrarSesion);
		
		JButton etiquetaMercado = new JButton("Mercado");
		etiquetaMercado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("mercado");
			}
		});
		etiquetaMercado.setBounds(271, 33, 140, 40);
		panel_1_1.add(etiquetaMercado);
		
		JLabel fondoMercado = new JLabel("New label");
		fondoMercado.setIcon(new ImageIcon(PantallaMenu.class.getResource("/imag/menuMercado.png")));
		fondoMercado.setBounds(0, 0, 440, 105);
		panel_1_1.add(fondoMercado);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PantallaMenu.class.getResource("/imag/UFL.jpg")));
		lblNewLabel.setBounds(599, 0, 251, 400);
		add(lblNewLabel);
		
		JLabel etiquetaMenu = new JLabel("M  E  N  U");
		etiquetaMenu.setBackground(Color.WHITE);
		etiquetaMenu.setForeground(Color.BLACK);
		etiquetaMenu.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaMenu.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 59));
		etiquetaMenu.setBounds(0, 0, 599, 89);
		add(etiquetaMenu);
		
		
		botonJugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("jugar");
			}
		});
		
	}
}
