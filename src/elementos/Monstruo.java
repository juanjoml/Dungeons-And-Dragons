package elementos;

/* Monstruo: representa a los monstruos con los que debe luchar el jugador.
	   Atributos:
		   ataque: puntos de ataque
		   defensa: puntos de defensa
		   resistencia: puntos de resistencia
		   puntosVida: puntos de vida  

   El monstruo se configura de la siguiente forma:  
	   i. ataque = aleatorio (1, 2, 3) 
	   ii. defensa = aleatorio (1, 2) 
	   iii. resistencia = aleatorio (1, 2) 
	   iv. puntosVida = resistencia * 5; */

public class Monstruo {

	protected int ataque; 
	protected int defensa; 
	protected int resistencia; 
	protected int puntosVida;  
	
	public Monstruo (int ataque, int defensa, int resistencia)
	{
		this.ataque =ataque; 			
		this.defensa=defensa; 		    
		this.resistencia=resistencia;  
		puntosVida=resistencia*5; 	   
	}							 	 
	//-----------------------------------------------------------------
	// crearMonstruo:
	// Asigno aleatoriamente sus puntos de ataque, defensa y resistencia,
	// lo instancio, y lo devuelvo.
	//-----------------------------------------------------------------
	public static Monstruo crearMonstruo()
	{
		int ataque = (int) (( Math.random()* ((3-1) + 1 )) + 1 ); // ataque = aleatorio (1, 2, 3) 
		int defensa = (int) (( Math.random()* ((2-1) + 1 )) + 1 ); //defensa = aleatorio (1, 2)  
		int resistencia = (int) (( Math.random()* ((2-1) + 1 )) + 1 ); // resistencia = aleatorio (1, 2) 
		
		Monstruo monstruo = new Monstruo (ataque, defensa, resistencia); 
		return monstruo; 
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
	// estaMuerto
	//-----------------------------------------------------------------
	public boolean estaMuerto() {
		
		return puntosVida==0? true : false;
	}
	//-----------------------------------------------------------------
	// toString
	//-----------------------------------------------------------------
	@Override
	public String toString() {
		return "Monstruo [ataque=" + ataque + ", defensa=" + defensa + ", resistencia=" + resistencia + ", puntosVida="
				+ puntosVida + "]";
	}	
}