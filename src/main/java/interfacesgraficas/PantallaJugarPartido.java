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

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JList;

public class PantallaJugarPartido extends JPanel{

	private Ventana ventana;
	private JTextField txtVs;
	
	public PantallaJugarPartido(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(194, 282, 45, 13);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(350, 282, 45, 13);
		add(lblNewLabel_2);
		
		txtVs = new JTextField();
		txtVs.setHorizontalAlignment(SwingConstants.CENTER);
		txtVs.setText("vs");
		txtVs.setBounds(175, 269, 259, 40);
		add(txtVs);
		txtVs.setColumns(10);
		
		JButton botonEmpezar = new JButton("Empezar Torneo");
		botonEmpezar.setBounds(236, 339, 132, 21);
		add(botonEmpezar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(26, 23, 549, 236);
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		JList list = new JList();
		final ArrayList<Equipo> todosEquipos=Funciones.getEquipos();
			final ArrayList<Partido> cuartosTorneo = new ArrayList<Partido>();
			final ArrayList<Partido> semifinalesTorneo;
			final ArrayList<Partido> finalTorneo;
			try {
//				cuartosTorneo = Funciones.jugarFase(todosEquipos,"cuartos");
				semifinalesTorneo = Funciones.jugarFase(Funciones.getEquiposGanadores("cuartos"),"semifinales");
				finalTorneo = Funciones.jugarFase(Funciones.getEquiposGanadores("semifinales"),"final");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
			list.setModel(new AbstractListModel() {

				public int getSize() {
					return cuartosTorneo.size();
				}
				public Object getElementAt(int index) {
					return cuartosTorneo.get(index);
				}
			});
			scrollPane.setViewportView(list);

		JButton etiquetaAtras = new JButton("Atr\u00E1s");
		etiquetaAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("menu");
			}
		});
		etiquetaAtras.setBounds(10, 369, 57, 21);
		add(etiquetaAtras);
		
		
		
	}
}
