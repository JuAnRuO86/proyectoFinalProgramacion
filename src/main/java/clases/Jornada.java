package clases;

public class Jornada extends ElementoConNombre{

	private Partido[] partidos;

	public Jornada(String nombre, Partido[] partidos) {
		super(nombre);
		this.setPartidos(partidos);
	}

	public Partido[] getPartidos() {
		return partidos;
	}

	public void setPartidos(Partido[] partidos) {
		this.partidos = partidos;
	}
	
}
