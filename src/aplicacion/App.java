package aplicacion;

/* Esta aplicacion es un juego inspirado en el conocido juego de rol Dungeons & Dragons.
  
   Estos son los elementos del juego:
  
   App: clase principal de la aplicacion (solo contiene el metodo main) */

import juego.Juego;

public class App {

	public static void main(String[] args) {
		
		 try
		  	{
		  		Juego.iniciarJuego();
		 	}
		  	catch(Exception e)
		 	{
		  		e.printStackTrace();
		  	}
	}	
}	