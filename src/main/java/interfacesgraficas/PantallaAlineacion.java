package interfacesgraficas;

import javax.swing.JPanel;

import enums.Posicion;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import clases.Equipo;
import clases.Funciones;
import clases.Jugador;
import clases.JugadorDeCampo;
import clases.Persona;
import clases.Usuario;
import java.awt.Color;

public class PantallaAlineacion extends JPanel{

	private Ventana ventana;
	
	public PantallaAlineacion(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JButton btnNewButton = new JButton("Atr\u00E1s");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("menu");
			}
		});
		
		JLabel etiquetaSuplentes = new JLabel("Suplentes");
		etiquetaSuplentes.setFont(new Font("Tahoma", Font.BOLD, 12));
		etiquetaSuplentes.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaSuplentes.setBackground(Color.WHITE);
		etiquetaSuplentes.setBounds(717, 171, 96, 24);
		add(etiquetaSuplentes);
		
		JLabel etiquetaDelanteros = new JLabel("Delanteros");
		etiquetaDelanteros.setFont(new Font("Tahoma", Font.BOLD, 12));
		etiquetaDelanteros.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaDelanteros.setBackground(Color.WHITE);
		etiquetaDelanteros.setBounds(574, 43, 96, 22);
		add(etiquetaDelanteros);
		
		JLabel etiquetaCentrocampistas = new JLabel("Centrocampistas");
		etiquetaCentrocampistas.setFont(new Font("Tahoma", Font.BOLD, 12));
		etiquetaCentrocampistas.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaCentrocampistas.setBackground(Color.WHITE);
		etiquetaCentrocampistas.setBounds(366, 43, 117, 22);
		add(etiquetaCentrocampistas);
		
		JLabel etiquetaDefensas = new JLabel("Defensas");
		etiquetaDefensas.setFont(new Font("Tahoma", Font.BOLD, 12));
		etiquetaDefensas.setBackground(Color.WHITE);
		etiquetaDefensas.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaDefensas.setBounds(177, 42, 96, 24);
		add(etiquetaDefensas);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(553, 66, 143, 276);
		add(scrollPane_3);
		
		final byte[] formacion=ventana.equipoUsuario.getEntrenador().getFormacion();
		final TreeMap<Posicion,Jugador> defensas=new TreeMap<Posicion,Jugador>();
		final TreeMap<Posicion,Jugador> centrocampistas=new TreeMap<Posicion,Jugador>();
		final TreeMap<Posicion,Jugador> delanteros=new TreeMap<Posicion,Jugador>();
		String form="";
		for(byte i=0;i<formacion.length;i++) {
			if(i==formacion.length-1) {
				form+=formacion[i];
			}else {
				form+=formacion[i]+"-";
			}
		}
		for(byte i=0;i<4;i++) {
			switch(ventana.equipoUsuario.getJugadores().get(i).getPosicion()) {
			case DEFENSA:
				defensas.put(ventana.equipoUsuario.getJugadores().get(i).getPosicion(),ventana.equipoUsuario.getJugadores().get(i));
				break;
			case CENTROCAMPISTA:
				centrocampistas.put(ventana.equipoUsuario.getJugadores().get(i).getPosicion(),ventana.equipoUsuario.getJugadores().get(i));
				break;
			case DELANTERO:
				delanteros.put(ventana.equipoUsuario.getJugadores().get(i).getPosicion(),ventana.equipoUsuario.getJugadores().get(i));
				break;
			}
		}
		
		final JList listaDelanteros = new JList();
		scrollPane_3.setViewportView(listaDelanteros);
		listaDelanteros.setModel(new AbstractListModel() {

			public int getSize() {
				return delanteros.size();
			}
			public Object getElementAt(int index) {
				return delanteros.get(index);
			}
		});
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(352, 66, 143, 276);
		add(scrollPane_2);
		
		final JList listaCentrocampistas = new JList();
		scrollPane_2.setViewportView(listaCentrocampistas);
		listaCentrocampistas.setModel(new AbstractListModel() {

			public int getSize() {
				return centrocampistas.size();
			}
			public Object getElementAt(int index) {
				return centrocampistas.get(index);
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(153, 66, 143, 276);
		add(scrollPane_1);
		final JList listaDefensas = new JList();
		scrollPane_1.setViewportView(listaDefensas);
		listaDefensas.setModel(new AbstractListModel() {

			public int getSize() {
				return defensas.size();
			}
			public Object getElementAt(int index) {
				return defensas.get(index);
			}
		});
		
		JButton botonQuitar = new JButton("Quitar");
		
		botonQuitar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonQuitar.setBounds(426, 367, 150, 24);
		add(botonQuitar);
		
		JButton botonAñadir = new JButton("A\u00F1adir");
	
		botonAñadir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonAñadir.setBounds(238, 367, 150, 24);
		add(botonAñadir);
		
		JLabel lblNewLabel_2 = new JLabel("Formacion del entrenador: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(222, 10, 296, 24);
		add(lblNewLabel_2);
		btnNewButton.setBounds(10, 369, 77, 21);
		add(btnNewButton);
		
		final JLabel etiquetaPortero = new JLabel(ventana.equipoUsuario.getJugadores().get(4).getNombre()+" "+ventana.equipoUsuario.getJugadores().get(0).getValoracion());
		etiquetaPortero.setBounds(10, 171, 93, 49);
		add(etiquetaPortero);
	
		
		
		
		JLabel lblNewLabel = new JLabel(""+form);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(519, 10, 143, 27);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(723, 195, 117, 195);
		add(scrollPane);
		
		final JList listaSuplentes = new JList();
		if(ventana.equipoUsuario.getSuplente()!=null) {
			listaSuplentes.setModel(new AbstractListModel() {

				public int getSize() {
					return ventana.equipoUsuario.getSuplente().size();
				}
				public Object getElementAt(int index) {
					return ventana.equipoUsuario.getSuplente().get(index);
				}
			});
		}
		scrollPane.setViewportView(listaSuplentes);
		
		JLabel etiquetaFondo = new JLabel("New label");
		etiquetaFondo.setIcon(new ImageIcon(PantallaAlineacion.class.getResource("/imag/Alineacion.png")));
		etiquetaFondo.setBounds(0, 0, 850, 400);
		add(etiquetaFondo);
	
		
		botonAñadir.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				Jugador suplente= ventana.suplentes.get(0);
				suplente =(Jugador) listaSuplentes.getSelectedValue();
				if(suplente!=null) {
					switch(suplente.getPosicion()) {
						case DEFENSA:
							defensas.add(suplente);
							break;
						case CENTROCAMPISTA:
							centrocampistas.add(suplente);
							break;
						case DELANTERO:
							delanteros.add(suplente);
							break;
						case PORTERO:
							etiquetaPortero.setText(String.valueOf(suplente.getNombre()+" "+suplente.getValoracion()));
						}					
					ventana.suplentes.remove(suplente);
				}
				listaSuplentes.repaint();
				listaDefensas.repaint();
				listaCentrocampistas.repaint();
				listaDelanteros.repaint();			
			}
		});
		
		botonQuitar.addMouseListener(new MouseAdapter() {
		Jugador titularDefensa=(Jugador) listaDefensas.getSelectedValue();
		Jugador titularCentrocampista=(Jugador) listaCentrocampistas.getSelectedValue();
		Jugador titularDelantero=(Jugador) listaDelanteros.getSelectedValue();
		
			@Override
			public void mouseClicked(MouseEvent e) {		
				if(titularDefensa!=null) {
					defensas.remove(titularDefensa);
					ventana.suplentes.add(titularDefensa);
				}
				if(titularCentrocampista!=null) {
					centrocampistas.remove(titularCentrocampista);
					ventana.suplentes.add(titularCentrocampista);
				}
				if(titularDelantero!=null) {
					delanteros.remove(titularDelantero);
					ventana.suplentes.add(titularDelantero);
				}
				listaDefensas.repaint();
				listaCentrocampistas.repaint();
				listaDelanteros.repaint();
				listaSuplentes.repaint();				
			}
		});
		
	}
}
