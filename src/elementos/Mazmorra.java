package elementos;

/* Mazmorra: esta compuesta por 1 o N habitaciones
	   Atributos:
	   		habitaciones: ArrayList que contiene todas las habitaciones   */

import java.util.ArrayList;

import elementos.Habitacion;

public class Mazmorra {
	
	private static ArrayList<Habitacion> habitaciones = new ArrayList<>();
	private int indiceHabitacion;
	
	//-----------------------------------------------------------------
	// En el constructor, inicializo un objeto tipo Mazmorra creando en 
	// cada iteracion 1 monstruo  y tesoro generado aleatoriamente, 
	// que meto en cada habitacion de su ArrayList habitaciones
	//-----------------------------------------------------------------
	public Mazmorra (int numHabitaciones) 
	{									  
		for (int i=0; i<numHabitaciones; i++) 
		{									  
			Monstruo monstruo = Monstruo.crearMonstruo();
			Tesoro tesoro = Tesoro.crearTesoro();
			habitaciones.add(new Habitacion (monstruo, tesoro));
		}
		indiceHabitacion=0;
	}		
	//-----------------------------------------------------------------
	// getSiguienteHabitacion
	//-----------------------------------------------------------------
	public Habitacion getSiguienteHabitacion()
	{
		Habitacion habitacion = habitaciones.get(indiceHabitacion);
		indiceHabitacion++;
		return habitacion;
	}	
	//-----------------------------------------------------------------
	// getNumHabitaciones
	//-----------------------------------------------------------------
	public int getNumHabitaciones()
	{
		return habitaciones.size();
	}	
	//-----------------------------------------------------------------
	// getHabitaciones
	//-----------------------------------------------------------------
	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}	
}