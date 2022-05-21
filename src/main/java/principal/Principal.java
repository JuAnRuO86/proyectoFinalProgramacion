package principal;

import java.util.Random;

import clases.JugadorDeCampo;
import enums.Posicion;

public class Principal {

	public static void main(String[] args) {
		
		 
			JugadorDeCampo juan = new JugadorDeCampo("Juan","Ruiz Ocaña","Español",Posicion.CENTROCAMPISTA);
			System.out.println(juan.getValoracion());
			System.out.println(juan.getPrecio());
			System.out.println(juan);
		

		
		

		
	}

}
