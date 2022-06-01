package interfacesgraficas;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class PantallaMenu extends JPanel{

	private	Ventana ventana;
	private JTextField TituloMenu;
	
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
		
		JButton etiquetaJugar = new JButton("Jugar Partido");
		
		etiquetaJugar.setBounds(23, 24, 140, 40);
		etiquetaJugar.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(etiquetaJugar);
		etiquetaJugar.setAlignmentY(1.0f);
		
		JLabel fondoJugarPartido = new JLabel("New label");
		fondoJugarPartido.setIcon(new ImageIcon(PantallaMenu.class.getResource("/imag/menuJugar.png")));
		fondoJugarPartido.setBounds(0, 0, 440, 95);
		panel.add(fondoJugarPartido);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 184, 440, 113);
		add(panel_1);
		
		JButton etiquetaAlineacion = new JButton("Alineaci\u00F3n");
		etiquetaAlineacion.setBounds(144, 37, 140, 40);
		panel_1.add(etiquetaAlineacion);
		
		JLabel fondoAlineacion = new JLabel("New label");
		fondoAlineacion.setIcon(new ImageIcon(PantallaMenu.class.getResource("/imag/menuAlineacion.png")));
		fondoAlineacion.setBounds(0, 0, 440, 113);
		panel_1.add(fondoAlineacion);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(0, 295, 440, 105);
		add(panel_1_1);
		
		JButton etiquetaCerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		etiquetaCerrarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("login");
			}
		});
		etiquetaCerrarSesion.setBounds(10, 74, 100, 21);
		panel_1_1.add(etiquetaCerrarSesion);
		
		JButton etiquetaMercado = new JButton("Mercado");
		etiquetaMercado.setBounds(271, 33, 140, 40);
		panel_1_1.add(etiquetaMercado);
		
		JLabel fondoMercado = new JLabel("New label");
		fondoMercado.setIcon(new ImageIcon(PantallaMenu.class.getResource("/imag/menuMercado.png")));
		fondoMercado.setBounds(0, 0, 440, 105);
		panel_1_1.add(fondoMercado);
		
		TituloMenu = new JTextField();
		TituloMenu.setFont(new Font("Verdana", Font.ITALIC, 58));
		TituloMenu.setBackground(new Color(0, 0, 0));
		TituloMenu.setForeground(new Color(255, 255, 255));
		TituloMenu.setHorizontalAlignment(SwingConstants.CENTER);
		TituloMenu.setText("M E N \u00DA");
		TituloMenu.setBounds(0, 0, 600, 89);
		add(TituloMenu);
		TituloMenu.setColumns(10);
		
		
		etiquetaJugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					ventana.irAPantalla("jugar");
			}
		});
		
	}
}
