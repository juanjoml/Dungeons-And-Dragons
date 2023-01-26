package elementos;

/* Heroe: esta clase representa al personaje del jugador. 
	   Atributos:
		   nombre: nombre del jugador
		   ataque: puntos de ataque
		   defensa: puntos de defensa
		   resistencia: puntos de resistencia (enum)
		   puntosVida: puntos de vida
		   raza: puede ser Enano, Elfo u Hombre.
		   pocion: variable entera (vale 1 por defecto). El jugador solo puede curarse una vez durante el juego. */

public class Heroe {
	
	private String nombre;
	private int ataque; 
	private int defensa; 
	private int resistencia; 
	private int puntosVida;  
	private TipoRaza raza; 
	private int pocion; 
	
	//-----------------------------------------------------------------
	// En el constructor: 
	// Inicializo la pocion a 1.
	// Si no tiene ningun punto de resistencia, tendra al menos 10 puntos de vida para poder jugar.
	//-----------------------------------------------------------------
	public Heroe (String nombre, int ataque, int defensa, int resistencia, TipoRaza raza)
	{
		this.nombre =nombre; 
		this.ataque=ataque; 
		this.defensa=defensa; 
		this.resistencia=resistencia; 
		this.raza=raza; 
		
		pocion=1; 
		
		puntosVida=(resistencia==0)? 10 : resistencia*10 ; 
	}								
	//-----------------------------------------------------------------
	// getNombre
	//-----------------------------------------------------------------
	public String getNombre() {
		return nombre;
	}
	//-----------------------------------------------------------------
	// getAtaque
	//-----------------------------------------------------------------
	public int getAtaque() {
		return ataque;
	}
	//-----------------------------------------------------------------
	// getDefensa
	//-----------------------------------------------------------------
	public int getDefensa() {
		return defensa;
	}
	//-----------------------------------------------------------------
	// getResistencia
	//-----------------------------------------------------------------
	public int getResistencia() {
		return resistencia;
	}
	//-----------------------------------------------------------------
	// getPuntosVida
	//-----------------------------------------------------------------
	public int getPuntosVida() {
		return puntosVida;
	}
	//-----------------------------------------------------------------
	// getRaza
	//-----------------------------------------------------------------
	public TipoRaza getRaza() {
		return raza;
	}	
	//-----------------------------------------------------------------
	// getPocion
	//-----------------------------------------------------------------
	public int getPocion() {
		return pocion;
	}	
	//-----------------------------------------------------------------
	// curarse:
	// Solo puede curarse una vez durante el juego.
	// Si no tiene puntos de resistencia, tendra al menos 10 puntos de vida, 
	// si tiene, se restablecen sus puntos de vida al 100%
	//-----------------------------------------------------------------
	public void curarse() 	// Curarse (
	{						
		puntosVida=(resistencia==0)? 10 : resistencia*10 ; // 
		pocion=0;
	}	
	//-----------------------------------------------------------------
	// recibirAtaque
	//-----------------------------------------------------------------
	public void recibirAtaque (int puntosAtaque)
	{
		puntosVida -=puntosAtaque;
		if(puntosVida<0)
		{
			puntosVida=0;
		}
	}
	//-----------------------------------------------------------------
	// toString
	//-----------------------------------------------------------------
	@Override
	public String toString() {
		return "Heroe [nombre=" + nombre + ", ataque=" + ataque + ", defensa=" + defensa + ", resistencia="
				+ resistencia + ", puntosVida=" + puntosVida + ", raza=" + raza + "]";
	}
}