package clases;

public class Liga extends ElementoConNombre{

	private Jornada[] jornadas;
	private Equipo[] equipos;
	public Liga(String nombre, Jornada[] jornadas, Equipo[] equipos) {
		super(nombre);
		this.setJornadas(jornadas);
		this.setEquipos(equipos);
	}
	public Jornada[] getJornadas() {
		return jornadas;
	}
	public void setJornadas(Jornada[] jornadas) {
		this.jornadas = jornadas;
	}
	public Equipo[] getEquipos() {
		return equipos;
	}
	public void setEquipos(Equipo[] equipos) {
		this.equipos = equipos;
	}
	
}
