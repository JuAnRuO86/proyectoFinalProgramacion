package principal;

import java.util.Random;

import clases.JugadorDeCampo;
import clases.Portero;
import enums.Posicion;

public class Principal {

	public static void main(String[] args) {
		
		 
			JugadorDeCampo juan = new JugadorDeCampo("Juan","Ruiz Ocaña","Español",Posicion.CENTROCAMPISTA);
			System.out.println(juan.getValoracion());
			System.out.println(juan.getPrecio());
			System.out.println(juan);
			
			Portero roberto=new Portero("Roberto","Carlos","Brasileiro");
			System.out.println(roberto.getValoracion());
			System.out.println(roberto.getPrecio());
			System.out.println(roberto);
		

		
	}

}
