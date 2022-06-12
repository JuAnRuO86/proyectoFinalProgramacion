package interfacesgraficas;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import clases.Usuario;
import componentes.visuales.BotonColor;
import excepciones.ContraseñaErroneaException;
import excepciones.NombreValidoException;
import excepciones.UsuarioNoValidoException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.SQLException;

import javax.swing.ImageIcon;
/**
 * Clase que hereda de JPanel, y que contendrá las funcionalidades para logear con un usuario ya registrado en el programa.
 * @author juaan
 *
 */
public class PantallaLogin extends JPanel {
	/** la ventana principal **/
	private	Ventana ventana;
	/** el campo donde se escribirá el email del usuario **/
	private JTextField campoEmail;
	/** el campo donde se escribirá la contraseña del usuario **/	
	private JPasswordField campoContraseña;
	
	/**
	 * Constructor de PantallaLogin que contendrá distintos campos, botones y etiquetas
	 * @param v la ventana principal
	 */
	public PantallaLogin(Ventana v) {		
		this.ventana=v;
		setLayout(null);
		
		JButton botonLogin = new BotonColor("Login");
		botonLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonLogin.setForeground(Color.WHITE);
		botonLogin.setBackground(Color.DARK_GRAY);
		
		botonLogin.setToolTipText("Pincha aquí para iniciar sesión");
		botonLogin.setBounds(207, 286, 160, 44);
		this.add(botonLogin);
		
		JButton botonRegistro = new BotonColor("Registrarse");
		botonRegistro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonRegistro.setForeground(Color.WHITE);
		botonRegistro.setBackground(Color.DARK_GRAY);
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("registro");
			}
		});
		botonRegistro.setBounds(513, 285, 143, 46);
		add(botonRegistro);
		
		JLabel etiquetaTitulo = new JLabel("Iniciar Sesión");
		etiquetaTitulo.setBackground(Color.ORANGE);
		etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaTitulo.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 28));
		etiquetaTitulo.setBounds(10, 10, 830, 57);
		add(etiquetaTitulo);
		
		final JLabel etiquetaEmail = new JLabel("Email");
		etiquetaEmail.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 18));
		etiquetaEmail.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaEmail.setBounds(244, 104, 110, 33);
		add(etiquetaEmail);
		
		final JLabel etiquetaPass = new JLabel("Contraseña");
		etiquetaPass.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 18));
		etiquetaPass.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaPass.setBounds(230, 163, 143, 31);
		add(etiquetaPass);
		
		campoEmail = new JTextField();
		campoEmail.setBounds(463, 100, 205, 37);
		add(campoEmail);
		campoEmail.setColumns(10);
		
		campoContraseña = new JPasswordField();
		campoContraseña.setBounds(463, 158, 205, 37);
		add(campoContraseña);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PantallaLogin.class.getResource("/imag/CopasCreacionEquipo.jpg")));
		lblNewLabel.setBounds(0, 0, 850, 400);
		add(lblNewLabel);

		if(ventana.email!="" && ventana.pass!="") {
			etiquetaEmail.setVisible(false);
			etiquetaPass.setVisible(false);
			campoEmail.setVisible(false);
			campoContraseña.setVisible(false);
		}
		
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(ventana.email!="" && ventana.pass!="") {
					try {
						ventana.usuarioLogado=new Usuario(ventana.email,ventana.pass);
						JOptionPane.showMessageDialog(ventana, "Bienvenid@ "+ventana.usuarioLogado.getNombre(),"Inicio de sesión con éxito",JOptionPane.INFORMATION_MESSAGE);
						ventana.irAPantalla("creacionEquipo");
					} catch (SQLException | ContraseñaErroneaException | UsuarioNoValidoException | NombreValidoException e1) {
						e1.printStackTrace();
					}
				}else {
					String email=campoEmail.getText();
					String contraseña=new String(campoContraseña.getPassword());
					try {
						ventana.usuarioLogado=new Usuario(email,contraseña);
						JOptionPane.showMessageDialog(ventana, "Bienvenid@ "+ventana.usuarioLogado.getNombre(),"Inicio de sesión con éxito",JOptionPane.INFORMATION_MESSAGE);
						ventana.irAPantalla("creacionEquipo");
					} catch (SQLException | ContraseñaErroneaException | UsuarioNoValidoException | NombreValidoException e1) {
	
						JOptionPane.showMessageDialog(ventana,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
				}
			}
			
		});
		
	}
	
	
}
