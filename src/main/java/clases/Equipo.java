package clases;

import java.util.ArrayList;

public class Equipo extends ElementoConNombre{

	private float presupuesto;
	private short valoracion;
	private ArrayList<Jugador> jugadores;
	private Entrenador entrenador;
	
	public Equipo(String nombre, float presupuesto, ArrayList<Jugador> jugadores,Entrenador entrenador) {
		
		super(nombre);
		this.setPresupuesto(presupuesto);
		this.setValoracion(valoracionObtenida(jugadores,entrenador));
		this.setJugadores(jugadores);
		this.setEntrenador(entrenador);
	}
	
	public float getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(float presupuesto) {
		this.presupuesto = presupuesto;
	}
	public short getValoracion() {
		return valoracion;
	}
	public void setValoracion(short valoracion) {
		this.valoracion = valoracion;
	}
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	public Entrenador getEntrenador() {
		return entrenador;
	}
	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}
	public short valoracionObtenida(ArrayList<Jugador> jugadores,Entrenador entrenador) {
		short valTotal=0;
		for(byte i=0;i<jugadores.size();i++) {
			valTotal+=jugadores.get(i).getValoracion();
		}
		
		return (short)(valTotal+entrenador.getNivelTactico());
	}
	@Override
	public String toString() {
		return " "+getNombre()+" [presupuesto=" + presupuesto + ", valoracion=" + this.getValoracion()+ "]\n |         |\n |         |\n |JUGADORES|   "+entrenador+"\n |         |\n |         |\n \\/        \\/\n" + jugadores;
	}
	
	
	
	
}
