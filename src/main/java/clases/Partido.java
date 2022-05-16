package clases;

public class Partido {

	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private byte golesLocal;
	private byte golesVisitante;
	public Partido(Equipo equipoLocal, Equipo equipoVisitante, byte golesLocal, byte golesVisitante) {
		super();
		this.setEquipoLocal(equipoLocal);
		this.setEquipoVisitante(equipoVisitante);
		this.setGolesLocal(golesLocal);
		this.setGolesVisitante(golesVisitante);
	}
	public Equipo getEquipoLocal() {
		return equipoLocal;
	}
	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}
	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}
	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}
	public byte getGolesLocal() {
		return golesLocal;
	}
	public void setGolesLocal(byte golesLocal) {
		this.golesLocal = golesLocal;
	}
	public byte getGolesVisitante() {
		return golesVisitante;
	}
	public void setGolesVisitante(byte golesVisitante) {
		this.golesVisitante = golesVisitante;
	}
	
}
