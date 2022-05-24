package clases;

import java.util.Random;

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
	
	
	//La idea es dependiendo de la valoracion de cada equipo tendra mas
	//oportunidad de meter goles que el otro, se pondra varias secciones
	//que seran determinadas por los 90 min(0 a 15min se tirara el random
	//por si alguno marca, el que tenga mas valoracion tendra mas posibilidades,
	//y si alguno marca se usara random para poner x minuto en el que ha metido
	//en el intervalo de esa seccion que es en este caso en los primeros 15min de partido
	//si los dos marcan, el segundo equipo metera en el minuto > que el primero pero < que el min de la seccion 15)
	//Lo ultimo es modificable, habra 3 secciones en cada tiempo(0-15,15-30,30-45) y habria descanso y luego igual hasta el min 90,
	//En el descanso se parara el juego mostrando el marcador y el usuario tendra que reanudar para empezar la segunda parte.
	public String jugarPartido(Equipo elocal,Equipo evisitante) {
		Random r=new Random();
		
		
		return "";
	}
	
	
	
	
	
	
	
}
