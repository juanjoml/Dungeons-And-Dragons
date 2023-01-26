package juego;

/* Combate: esta clase lleva a cabo el combate entre el heroe y el monstruo.
	
			Atacar: se invoca a la funcion estatica ataque. Esta funcion realiza los siguientes calculos:
			
				i. calcularAtaque: calcula los puntos de dado que el heroe inflige al monstruo y los que el monstruo inflige al heroe. 
				   Los puntos de dado se restan de los puntos de vida.Se muestra un mensaje por pantalla, volviendo a mostrar la 
				   opcion de atacar, y asi hasta que el heroe o el monstruo muera. 
				
					ataqueHeroe = (heroe.ataque - monstruo.defensa) * d6();  
					ataqueMonstruo = (monstruo.ataque - heroe.defensa) * d6(); 
				
				ii. d6: simula el lanzamiento de un dado de 6 caras (aleatorio de 1 a 6, de tipo entero). 
		
			Curarse: la curacion restablece sus puntos de vida al 100 %. solo puede curarse una vez durante el juego. */

import elementos.Heroe;
import elementos.Monstruo;

public class Combate {	
	//-----------------------------------------------------------------
	// ataque:
	// Asigno los puntos de ataque de heroe y monstruo, restando a los de heroe
	// los de defensa del monstruo y viceversa, y multiplicandolos por un numero
	// aleatorio entre 1-6 (a modo de dado), y aplico a heroe y monstruo el metodo 
	// recibirAtaque con los puntos de ataque generados, para restarles puntos de vida.
	//-----------------------------------------------------------------
	public static void ataque (Heroe heroe, Monstruo monstruo)
	{
		int ataqueHeroe = (heroe.getAtaque()-monstruo.getDefensa()*d6());
		int ataqueMonstruo = (monstruo.getAtaque()-heroe.getDefensa()*d6());
		
		if(ataqueHeroe <=0)
		{
			ataqueHeroe = 5;
		}
		
		if(ataqueMonstruo <=0)
		{
			ataqueMonstruo = 3;
		}
		
		heroe.recibirAtaque(ataqueMonstruo);
		
		monstruo.recibirAtaque(ataqueHeroe);
	}		
	//-----------------------------------------------------------------
	// d6:
	// Devuelvo un valor aleatorio entre 1 y 6, a modo de dado.
	//-----------------------------------------------------------------
	private static int d6 ()
	{
		int dado = (int)(( Math.random()* ((6-1) + 1 )) + 1 ); 
		return dado;
	}
}