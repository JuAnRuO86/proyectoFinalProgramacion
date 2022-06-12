package interfacesgraficas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import clases.Entrenador;
import clases.Equipo;
import clases.Jugador;
import clases.Persona;
import enums.Posicion;
import excepciones.NombreValidoException;
import excepciones.PresupuestoInvalidoException;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;
/**
 * Clase que hereda de JPanel, y que contendrá las funcionalidades para crear el equipo del usuario en el programa.
 * @author juaan
 *
 */
public class PantallaCreacionEquipo extends JPanel {
	/** el campo donde se escribirá el nombre del equipo del usuario **/	
	private JTextField campoNombre;
	/** la ventana principal **/
	private Ventana ventana;
	
	/**
	 * Constructor de PantallaCreacionEquipo que contendrá distintos campos, botones y etiquetas
	 * @param v
	 */	
	public PantallaCreacionEquipo(Ventana v) {
		
		this.ventana=v;
		setLayout(null);
		
		final JRadioButton boton5M = new JRadioButton("5M");
		boton5M.setFont(new Font("Sitka Subheading", Font.ITALIC, 20));
		boton5M.setHorizontalAlignment(SwingConstants.CENTER);
		boton5M.setBounds(682, 304, 103, 36);
		add(boton5M);
		
		final JRadioButton boton3M = new JRadioButton("3M");
		boton3M.setHorizontalAlignment(SwingConstants.CENTER);
		boton3M.setFont(new Font("Sitka Subheading", Font.ITALIC, 20));
		boton3M.setBounds(555, 304, 103, 36);
		add(boton3M);
		
		final JRadioButton boton1M = new JRadioButton("1M");
		boton1M.setHorizontalAlignment(SwingConstants.CENTER);
		boton1M.setFont(new Font("Sitka Subheading", Font.ITALIC, 20));
		boton1M.setBounds(430, 304, 103, 36);
		add(boton1M);
		
		ButtonGroup grupoPresupuesto=new ButtonGroup();
		grupoPresupuesto.add(boton1M);
		grupoPresupuesto.add(boton3M);
		grupoPresupuesto.add(boton5M);
		
		JButton botonCrearEquipo = new JButton("CREAR EQUIPO");
		
		botonCrearEquipo.setFont(new Font("Sitka Display", Font.BOLD, 25));
		botonCrearEquipo.setBounds(264, 164, 286, 74);
		add(botonCrearEquipo);
		
		JLabel etiquetaPresupuesto = new JLabel("PRESUPUESTO");
		etiquetaPresupuesto.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaPresupuesto.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 25));
		etiquetaPresupuesto.setBounds(97, 286, 260, 54);
		add(etiquetaPresupuesto);
		
		JLabel etiquetaNombre = new JLabel("NOMBRE");
		etiquetaNombre.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 25));
		etiquetaNombre.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaNombre.setBounds(157, 78, 155, 33);
		add(etiquetaNombre);
		
		campoNombre = new JTextField();
		campoNombre.setFont(new Font("Tahoma", Font.PLAIN, 25));
		campoNombre.setBounds(414, 67, 306, 44);
		add(campoNombre);
		campoNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PantallaCreacionEquipo.class.getResource("/imag/InazumaEleven.jpg")));
		lblNewLabel.setBounds(0, 0, 850, 400);
		add(lblNewLabel);
		
		
		
		
		botonCrearEquipo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombreEquipo=campoNombre.getText();
				int presupuesto=0;
				if(boton1M.isSelected()) {
					presupuesto=1000000;
				}else if(boton3M.isSelected()) {
					presupuesto=3000000;
				}else if(boton5M.isSelected()) {
					presupuesto=5000000;
				}
				ventana.suplentes=new ArrayList<Jugador>();
				try {
					ventana.equipoUsuario=new Equipo(nombreEquipo,presupuesto,new Entrenador(Persona.generarNombresAleatorios(),Persona.apellidosAleatorios(),Persona.generarNacionalidades()));
					ventana.irAPantalla("menu");
				} catch (SQLException | PresupuestoInvalidoException e1) {
					JOptionPane.showMessageDialog(ventana,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (NombreValidoException e1) {
					JOptionPane.showMessageDialog(ventana,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				
			}
		});
	}
}
