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

public class PantallaRegistro extends JPanel {
	private Ventana ventana;
	private JTextField campoEmail;
	private JPasswordField campoPass;
	private JTextField campoNombre;
	private JTextField campoApellido1;
	private JTextField campoApellido2;
		
	public PantallaRegistro(Ventana v) {
		setLayout(null);
		
		JLabel tituloRegistro = new JLabel("Registro ");
		tituloRegistro.setBounds(21, 0, 154, 42);
		tituloRegistro.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 36));
		add(tituloRegistro);
		
		JLabel etiquetaNombre = new JLabel("Nombre");
		etiquetaNombre.setBounds(206, 24, 36, 13);
		add(etiquetaNombre);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(252, 21, 147, 19);
		campoNombre.setColumns(10);
		add(campoNombre);
		
		JLabel etiquetaPrimerApellido = new JLabel("Primer Apellido:");
		etiquetaPrimerApellido.setBounds(168, 52, 74, 13);
		add(etiquetaPrimerApellido);
		
		campoApellido1 = new JTextField();
		campoApellido1.setBounds(252, 50, 147, 19);
		campoApellido1.setColumns(10);
		add(campoApellido1);
		
		JLabel etiquetaSegundoApellido = new JLabel("Segundo Apellido:");
		etiquetaSegundoApellido.setBounds(159, 85, 83, 13);
		add(etiquetaSegundoApellido);
		
		campoApellido2 = new JTextField();
		campoApellido2.setBounds(252, 79, 147, 19);
		campoApellido2.setColumns(10);
		add(campoApellido2);
		
		JLabel etiquetaEmail = new JLabel("Email:");
		etiquetaEmail.setBounds(213, 114, 29, 13);
		add(etiquetaEmail);
		
		campoEmail = new JTextField();
		campoEmail.setBounds(252, 108, 147, 19);
		add(campoEmail);
		campoEmail.setColumns(10);
		
		JLabel etiquetaPass = new JLabel("Contrase\u00F1a: ");
		etiquetaPass.setBounds(183, 143, 59, 13);
		etiquetaPass.setBackground(new Color(200,0,0));
		add(etiquetaPass);
		
		campoPass = new JPasswordField();
		campoPass.setBounds(252, 137, 147, 19);
		add(campoPass);
		
		JRadioButton generoH = new JRadioButton("Hombre");
		generoH.setBounds(256, 170, 61, 21);
		add(generoH);
		
		JRadioButton generoM = new JRadioButton("Mujer");
		generoM.setBounds(348, 170, 51, 21);
		add(generoM);
		
		JButton botonRegistrarse = new JButton("Registrarse");
		botonRegistrarse.setBounds(295, 228, 85, 21);
		
		botonRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(206, 197, 235, 21);
		add(comboBox);
		add(botonRegistrarse);
		
		JButton botonAtras = new JButton("Atras");
		botonAtras.setBounds(422, 257, 57, 21);
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("login");
			}
		});
		add(botonAtras);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PantallaRegistro.class.getResource("/imag/campito44.png")));
		lblNewLabel.setBounds(0, 0, 500, 300);
		add(lblNewLabel);
		ventana=v;
		
		
		botonRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombreUsuario = campoNombre.getText();
				String email = campoEmail.getText();
				String pass = new String(campoPass.getPassword());
				String apellido1 = campoApellido1.getText();
				String apellido2 = campoApellido2.getText();
				JOptionPane.showMessageDialog(ventana,"Registro Completo","Registro",JOptionPane.PLAIN_MESSAGE );
				ventana.irAPantalla("login");
			
				try {
					new Usuario(nombreUsuario, apellido1, apellido2, email, pass);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

}
