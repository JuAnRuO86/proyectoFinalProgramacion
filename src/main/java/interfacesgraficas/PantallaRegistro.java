package interfacesgraficas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import clases.Usuario;
import componentes.visuales.BotonColor;
import excepciones.NombreValidoException;
import excepciones.apellidoNoValidoException;
import excepciones.emailNoValidoException;
import excepciones.passNoValidoException;

import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
/**
 * Clase que hereda de JPanel, y que contendrá las funcionalidades para registrarse con un usuario en el programa.
 * @author juaan
 *
 */
public class PantallaRegistro extends JPanel {
	/** la ventana principal **/
	private Ventana ventana;
	/** el campo donde se escribirá el email del usuario **/
	private JTextField campoEmail;
	/** el campo donde se escribirá la contraseña del usuario **/	
	private JPasswordField campoPass;
	/** el campo donde se escribirá el nombre del usuario **/	
	private JTextField campoNombre;
	/** el campo donde se escribirá el primer apellidos del usuario **/	
	private JTextField campoApellido1;
	/** el campo donde se escribirá el segundo apellido del usuario **/	
	private JTextField campoApellido2;
	
	/**
	 * Constructor de PantallaRegistro que contendrá distintos campos, botones y etiquetas
	 * @param v la ventana principal
	 */	
	public PantallaRegistro(Ventana v) {
		setLayout(null);
		
		JLabel tituloRegistro = new JLabel("Registro ");
		tituloRegistro.setBounds(365, 0, 159, 46);
		tituloRegistro.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 36));
		add(tituloRegistro);
		
		JLabel etiquetaNombre = new JLabel("Nombre");
		etiquetaNombre.setFont(new Font("Tahoma", Font.PLAIN, 22));
		etiquetaNombre.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaNombre.setBounds(189, 56, 169, 31);
		add(etiquetaNombre);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(429, 56, 174, 31);
		campoNombre.setColumns(10);
		add(campoNombre);
		
		JLabel etiquetaPrimerApellido = new JLabel("Primer Apellido:");
		etiquetaPrimerApellido.setFont(new Font("Tahoma", Font.PLAIN, 22));
		etiquetaPrimerApellido.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaPrimerApellido.setBounds(189, 97, 169, 31);
		add(etiquetaPrimerApellido);
		
		campoApellido1 = new JTextField();
		campoApellido1.setBounds(429, 97, 174, 31);
		campoApellido1.setColumns(10);
		add(campoApellido1);
		
		JLabel etiquetaSegundoApellido = new JLabel("Segundo Apellido:");
		etiquetaSegundoApellido.setFont(new Font("Tahoma", Font.PLAIN, 22));
		etiquetaSegundoApellido.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaSegundoApellido.setBounds(178, 138, 194, 31);
		add(etiquetaSegundoApellido);
		
		campoApellido2 = new JTextField();
		campoApellido2.setBounds(429, 138, 174, 31);
		campoApellido2.setColumns(10);
		add(campoApellido2);
		
		JLabel etiquetaEmail = new JLabel("Email:");
		etiquetaEmail.setFont(new Font("Tahoma", Font.PLAIN, 22));
		etiquetaEmail.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaEmail.setBounds(203, 179, 149, 31);
		add(etiquetaEmail);
		
		campoEmail = new JTextField();
		campoEmail.setBounds(429, 179, 174, 31);
		add(campoEmail);
		campoEmail.setColumns(10);
		
		JLabel etiquetaPass = new JLabel("Contrase\u00F1a: ");
		etiquetaPass.setFont(new Font("Tahoma", Font.PLAIN, 22));
		etiquetaPass.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaPass.setBounds(203, 215, 147, 31);
		etiquetaPass.setBackground(new Color(200,0,0));
		add(etiquetaPass);
		
		campoPass = new JPasswordField();
		campoPass.setBounds(429, 220, 174, 31);
		add(campoPass);
		
		JButton botonRegistrarse = new BotonColor("Registrarse");
		botonRegistrarse.setBackground(Color.DARK_GRAY);
		botonRegistrarse.setFont(new Font("MV Boli", Font.BOLD, 18));
		botonRegistrarse.setForeground(Color.WHITE);
		botonRegistrarse.setBounds(273, 277, 251, 75);
		
		botonRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(botonRegistrarse);
		
		JButton botonAtras = new JButton("Atr\u00E1s");
		botonAtras.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonAtras.setBounds(10, 346, 108, 31);
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("login");
			}
		});
		add(botonAtras);
		
		JLabel etiquetaFondo = new JLabel("New label");
		etiquetaFondo.setIcon(new ImageIcon(PantallaRegistro.class.getResource("/imag/CopasCreacionEquipo.jpg")));
		etiquetaFondo.setBounds(0, 0, 850, 400);
		add(etiquetaFondo);
		ventana=v;
		
		
		botonRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombreUsuario = campoNombre.getText();
				String email = campoEmail.getText();
				String pass = new String(campoPass.getPassword());
				String apellido1 = campoApellido1.getText();
				String apellido2 = campoApellido2.getText();
				try {
					new Usuario(nombreUsuario, apellido1, apellido2, email, pass);
					JOptionPane.showMessageDialog(ventana,"Registro Completo","Registro",JOptionPane.PLAIN_MESSAGE );
					ventana.irAPantalla("login");
				} catch (SQLException | NombreValidoException e1) {
					JOptionPane.showMessageDialog(ventana,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (apellidoNoValidoException e1) {
					JOptionPane.showMessageDialog(ventana,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (passNoValidoException e1) {
					JOptionPane.showMessageDialog(ventana,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (emailNoValidoException e1) {
					JOptionPane.showMessageDialog(ventana,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
	}
}
