package principal;

import java.util.Random;

import clases.JugadorDeCampo;
import enums.Posicion;

public class Principal {

	public static void main(String[] args) {
		
		JugadorDeCampo juan=new JugadorDeCampo("Juan","Ruiz Ocaña","Español",(int)2000,Posicion.CENTROCAMPISTA);

		System.out.println(juan.getValoracion());
		System.out.println(juan);
		
		Random r=new Random();
		
		System.out.println(r.nextInt(5+1-3)+3);
		
	}

}
