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

import componentes.visuales.BotonAzul;
import componentes.visuales.BotonRojo;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class PantallaLogin extends JPanel {
	
	private	Ventana ventana;
	
	private JTextField textoUsuario;
	private JPasswordField textoPass;
	
	
	public PantallaLogin(Ventana v) {
		
		
		this.ventana=v;
		setLayout(null);
		
		JButton botonLogin = new BotonRojo("Login");
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			
		});
		botonLogin.setToolTipText("Pincha aqu\u00ED para iniciar sesi\u00F3n");
		botonLogin.setBounds(84, 216, 160, 44);
		this.add(botonLogin);
		
		JButton botonRegistro = new BotonAzul("Registrarse");
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("registro");
			}
		});
		botonRegistro.setBounds(254, 199, 143, 46);
		add(botonRegistro);
		
		JLabel etiquetaTitulo = new JLabel("Iniciar Sesi\u00F3n");
		etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaTitulo.setFont(new Font("Miriam Libre", Font.ITALIC, 27));
		etiquetaTitulo.setBounds(10, 11, 480, 44);
		add(etiquetaTitulo);
		
		JLabel EtiquetaUsuario = new JLabel("Usuario");
		EtiquetaUsuario.setBounds(84, 80, 46, 14);
		add(EtiquetaUsuario);
		
		JLabel EtiquetaPass = new JLabel("Contrase\u00F1a");
		EtiquetaPass.setBounds(84, 119, 85, 14);
		add(EtiquetaPass);
		
		textoUsuario = new JTextField();
		textoUsuario.setBounds(179, 77, 175, 20);
		add(textoUsuario);
		textoUsuario.setColumns(10);
		
		textoPass = new JPasswordField();
		textoPass.setBounds(179, 116, 175, 20);
		add(textoPass);
		
		
		
		
	}
}
