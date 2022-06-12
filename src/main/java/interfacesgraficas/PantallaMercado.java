package interfacesgraficas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import clases.Funciones;
import clases.Jugador;
import clases.Persona;
import clases.Usuario;
import excepciones.PresupuestoInvalidoException;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
/**
 * Clase que hereda de JPanel, y que contendrá las funcionalidades para ver e interactuar con el mercado de jugadores
 * @author juaan
 *
 */
public class PantallaMercado extends JPanel{
	/** la ventana principal **/
	private Ventana ventana;
	/**
	 * Constructor de PantallaMercado que contendrá una lista con los jugadores a comprar, botones y etiqueta
	 * @param v la ventana principal
	 */
	public PantallaMercado(Ventana v) {
		
		this.ventana=v;
		setLayout(null);

		
		JButton botonAtras = new JButton("Atr\u00E1s");
		
		botonAtras.setBounds(740, 361, 86, 29);
		add(botonAtras);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 712, 400);
		add(scrollPane);
		
		final JLabel etiquetaPresupuestoActual = new JLabel(ventana.equipoUsuario.getPresupuesto()+" €");
		etiquetaPresupuestoActual.setFont(new Font("Tahoma", Font.PLAIN, 24));
		etiquetaPresupuestoActual.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(etiquetaPresupuestoActual);
		
		
		final JList listaMercado = new JList();	
		final ArrayList<Persona> mercado=Funciones.generarMercado();
		
		listaMercado.setModel(new AbstractListModel() {

			public int getSize() {
				return mercado.size();
			}
			public Object getElementAt(int index) {
				return mercado.get(index);
			}
		});
		scrollPane.setViewportView(listaMercado);

		
		JButton botonComprar = new JButton("Comprar");
		botonComprar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Jugador seleccionado=(Jugador)listaMercado.getSelectedValue();
				if(seleccionado!=null) {
					if(ventana.equipoUsuario.getPresupuesto()>=seleccionado.getPrecio()) {
						ventana.suplentes.add(seleccionado);
						try {
							ventana.equipoUsuario.setPresupuesto(ventana.equipoUsuario.getPresupuesto()-seleccionado.getPrecio());
						} catch (PresupuestoInvalidoException e1) {
							e1.printStackTrace();
						}
						etiquetaPresupuestoActual.setText(String.valueOf(""+(ventana.equipoUsuario.getPresupuesto())));
						mercado.remove(seleccionado);
						listaMercado.repaint();					
					}else {
						JOptionPane.showMessageDialog(ventana, "No se puede realizar la compra de "+seleccionado.getNombre(),"Compra Fallida",JOptionPane.INFORMATION_MESSAGE);
						
					}
				} 
			}
		});
		scrollPane.setRowHeaderView(botonComprar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PantallaMercado.class.getResource("/imag/mercadoBanner.jpg")));
		lblNewLabel.setBounds(712, 0, 138, 400);
		add(lblNewLabel);
		
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("menu");
			}
		});
		
		

	
	
	
	
	
	
	
	
	}
}
