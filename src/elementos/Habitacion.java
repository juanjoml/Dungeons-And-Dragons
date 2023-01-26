package elementos;

/* Habitacion: cada habitacion del juego tiene un monstruo y un tesoro
	   Atributos:
		   monstruo: monstruo contra el que debe luchar el heroe
		   tesoro: tesoro que gana el heroe al matar al monstruo */

public class Habitacion {

	private Monstruo monstruo; 
	private Tesoro tesoro; 
	
	public Habitacion (Monstruo monstruo, Tesoro tesoro)
	{
		this.monstruo=monstruo;
		this.tesoro=tesoro;
	}
	//-----------------------------------------------------------------
	// getMonstruo
	//-----------------------------------------------------------------
	public Monstruo getMonstruo() {
		return monstruo;
	}
	//-----------------------------------------------------------------
	// getTesoro
	//-----------------------------------------------------------------
	public Tesoro getTesoro() {
		return tesoro;
	}
	//-----------------------------------------------------------------
	// toString
	//-----------------------------------------------------------------
	@Override
	public String toString() {
		String habitacion="";
		habitacion="Habitacion [monstruo=" + monstruo + ", tesoro=" + tesoro + "]";
		 return habitacion;
	}
}