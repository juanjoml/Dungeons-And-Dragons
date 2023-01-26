package elementos;

/* Tesoro: clase que representa el tesoro ganado al matar al monstruo.
	   Atributos:
	   		monedas: numero de monedas de oro a ganar por el monstruo.
   		
   Las monedas del tesoro son un numero aleatorio entre 5 y 10. */

public class Tesoro {
	
	private int monedas;
	
	public Tesoro (int monedas)
	{
		this.monedas=monedas;
	}
	//-----------------------------------------------------------------
	// getMonedas
	//-----------------------------------------------------------------
	public int getMonedas() {
		return monedas;
	}
	//-----------------------------------------------------------------
	// crearTesoro:
	// Genero un numero aleatorio de monedas entre 5 y 10, creo la 
	// instancia tesoro con ellas y lo devuelvo.
	//-----------------------------------------------------------------
	public static Tesoro crearTesoro()
	{
		int monedas = (int) (( Math.random()* ((10-5) + 1 )) + 5);
		Tesoro tesoro = new Tesoro (monedas);
		return tesoro;
	}
	//-----------------------------------------------------------------
	// toString
	//-----------------------------------------------------------------
	@Override
	public String toString() {
		return "Tesoro [monedas=" + monedas + "]";
	}
}