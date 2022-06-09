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
import clases.Usuario;
import hilos.MusicaFondo;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.ImageIcon;

public class PantallaJugarPartido extends JPanel{

	private Ventana ventana;
	private Torneo torneo;
	protected Clip clip;

	public PantallaJugarPartido(Ventana v,final Clip cl) {
		try {
			cl.stop();
			AudioInputStream reproductor = AudioSystem.getAudioInputStream(new File("./musica/UEFA Champions League Official Theme Song.wav"));
			this.clip = AudioSystem.getClip();
			this.clip.open(reproductor);
			this.clip.start();
			
			}catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
				
			}
		this.ventana=v;
		setLayout(null);
		
		JButton botonEmpezar = new JButton("Empezar Torneo");
		
		botonEmpezar.setBounds(316, 310, 219, 40);
		add(botonEmpezar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(150, 28, 550, 236);
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		final JList listaPartidos = new JList();
		panel_1.add(listaPartidos, BorderLayout.CENTER);
		
		

		JButton etiquetaAtras = new JButton("Atr\u00E1s");
		etiquetaAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clip.stop();
				cl.start();
				ventana.irAPantalla("menu");
			}
		});
		etiquetaAtras.setBounds(10, 358, 68, 21);
		add(etiquetaAtras);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PantallaJugarPartido.class.getResource("/imag/FondoJugarTorneo.png")));
		lblNewLabel.setBounds(0, 0, 850, 400);
		add(lblNewLabel);
		
		botonEmpezar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					final ArrayList<Partido> todosPartidos=torneo.jugarTorneo(ventana.equipoUsuario);
					listaPartidos.setModel(new AbstractListModel() {
	
						public int getSize() {
							return todosPartidos.size();
						}
						public Object getElementAt(int index) {
							return todosPartidos.get(index);
						}
					});
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}
}
