package juego;

/* Juego: clase principal del juego. Pone en marcha la aplicacion, crea la mazmorra y posee los metodos necesarios para ejecutar 
 	las funciones principales del juego.
 	
	1) Al comenzar el juego se muestra un menu, en el que se pide al jugador que configure su heroe de la siguiente forma: 
	 
		   a. Solicita el nombre y la raza del heroe.
			 
		   b. Despues, dice al jugador que tiene 10 puntos a repartir entre fuerza, defensa y resistencia. Se debe comprobar que no 
		      se asignan mas de 10 puntos, hasta que el jugador introduzca un valor correcto.
			
		   c. Se generan los parametros del jugador: i. puntosVida = resistencia * 10 
	
	2) Despues de configurar el jugador, el juego pregunta cuantas habitaciones tiene la mazmorra, creandose el numero de habitaciones 
	   que diga el jugador en el ArrayList. Debe ser un numero entero mayor, al menos de 5, y como maximo, 10.
	
	3) Cada habitacion creada tendra un monstruo y una cantidad de monedas como tesoro. 
	
	4) Se recuerda al jugador el numero de mazmorras que hay y que, como medida excepcional, solo puede curarse una vez durante el juego.
	   Cuando el jugador pulse para continuar (con un Thread.Sleep(5000) para que espere 5 segundos), empieza la partida.
	
	5) Una vez comience el juego, se recorre el ArrayList de las habitaciones una a una y se muestran al jugador los datos del monstruo, 
	   indicando las acciones Atacar y Curarse (metodos definidos en la clase Combate).
	
	   Si el jugador mata al monstruo, se muestra la cantidad de oro ganada, y se suma en una variable. Se vuelve a repetir el paso 5 
	   hasta que se recorran todas las habitaciones y mueran todos los monstruos o bien muera el jugador. 
	
	6) Si ya no quedan mas monstruos o muere el jugador se muestra el final de la partida. En todos los casos se debe indicar el numero 
	   de monstruos muertos, el numero de habitaciones limpiadas y la cantidad de monedas ganadas. */
	
import java.util.Scanner;			
import elementos.*;	

public class Juego {		
		
	private static Heroe heroe;
	private static int tesoro = 0;
	private static Mazmorra mazmorra;
	
	static Scanner scan = new Scanner (System.in);	
	//-----------------------------------------------------------------
	// iniciarJuego 
	//-----------------------------------------------------------------
	public static void iniciarJuego() throws InterruptedException
	{
		System.out.println("\n Dungeons & Dragons");	// Llamamos a las funciones crearHeroe y crearMazmorra.
		crearHeroe();
		crearMazmorra();
	}	
	//-----------------------------------------------------------------
	// crearHeroe:
	// Meto los atributos del heroe (me aseguro de que sea uno de los enumerados),
	// meto los puntos (me aseguro de que sean en el intervalo permitido entre 0 y 10 y que se vayan 
	// descontando, y permito meter mas puntos en otra iteracion si no se han agotado)
	// e instancio el heroe.
	//-----------------------------------------------------------------
	public static void crearHeroe()
	{
		System.out.println("\n Creacion del heroe: ");
		System.out.println();		
		System.out.println("Introduce el nombre: ");
		String nombre = scan.nextLine();
		System.out.println("Introduce la raza (ENANO, ELFO, HOMBRE)");
		String tipo = scan.nextLine();
		while (!tipo.equals("ENANO") && !tipo.equals("ELFO") && !tipo.equals("HOMBRE"))
		{
			System.out.println("Esa opcion no existe. Introduce:ENANO, ELFO, HOMBRE");
			tipo = scan.nextLine();
		}
		TipoRaza raza = TipoRaza.valueOf(tipo);
		System.out.println("Tienes 10 puntos a repartir entre fuerza, defensa y resistencia");
		
		int cantidadPuntos=10;
		int opcion=0, ataque=0, defensa=0, resistencia=0;
	
		do{
			System.out.println("Introduce puntos de fuerza: ");
			ataque =scan.nextInt();
			while (ataque<0 || ataque>10)
			{
				System.out.println("Cantidad incorrecta");
				System.out.println();
				System.out.println("Introduce puntos de fuerza: ");
				ataque =scan.nextInt();
			}
			cantidadPuntos-=ataque;
			
			if (cantidadPuntos==0)
			{
				System.out.println("Ha agotado sus reparto de puntos. ");break;
			}
			else
			{
				System.out.println("Introduce puntos de defensa: ");
				defensa =scan.nextInt();
				while (defensa>cantidadPuntos) 
				{
					System.out.println("Cantidad incorrecta");
					System.out.println();
					System.out.println("Introduce puntos de defensa: ");
					defensa =scan.nextInt();
				}
				cantidadPuntos-=defensa;
			}			
			if (cantidadPuntos==0)
			{
				System.out.println("Ha agotado sus reparto de puntos. ");break;
			}
			else
			{
				System.out.println("Introduce puntos de resistencia: ");
				resistencia =scan.nextInt();
				while (resistencia>cantidadPuntos)
				{
					System.out.println("Cantidad incorrecta");
					System.out.println();
					System.out.println("Introduce puntos de resistencia: ");
					resistencia =scan.nextInt();
				}
				cantidadPuntos-=resistencia;
			}
			if (cantidadPuntos==0)
			{
				System.out.println("Ha agotado sus reparto de puntos. ");break;
			}
			else
			{
				System.out.println("Desea meter mas puntos? 1=Si");
				opcion =scan.nextInt();
			}
			
		} while (cantidadPuntos>0 && opcion==1);
		
		heroe = new Heroe (nombre, ataque, defensa, resistencia, raza);
		System.out.println("");
		System.out.println("Heroe creado");
	}	
	//-----------------------------------------------------------------
	// crearMazmorra:
	// Meto el numero de habitaciones (me aseguro que esta entre el intervalo
	// adecuado, 5-10), e instancio la mazmorra.
	//-----------------------------------------------------------------
	public static void crearMazmorra() throws InterruptedException
	{
		System.out.println("\n Creacion de la mazmorra: ");
		System.out.println();	
		System.out.println("cuantas habitaciones compondran la mazmorra ? (Min 5, Max 10)");
		int habitaciones = scan.nextInt();
		while (habitaciones<5 || habitaciones>10)
		{
			System.out.println("Cantidad incorrecta, introduzca de nuevo la cantidad: ");
			habitaciones = scan.nextInt();
		}
	
		mazmorra = new Mazmorra (habitaciones);
		
		System.out.println("Mazmorra creada");
		jugar();
	} 	
	//-----------------------------------------------------------------
	// jugar:
	// Aviso del inicio de la partida, el numero de habitaciones donde lucha y el uso de la pocion e inicio una cuenta atras de 5 segundos.
	// Recorro cada habitacion, muestro el menu de combate en cada una y asigno el monstruo de ella.
	// Mientras uno de los 2 tenga puntos de vida sigue el combate. Si el monstruo pierde todos, es eliminado y el heroe acumula las monedas.
	// Si el heroe pierde todos los puntos de vida, usa la pocion (1 vez) y los recobra, y si no, pierde la partida.
	// Si supera todas las habitaciones ganando todos los combates (puntosVida>0), gana la partida y se muestran los resultados.
	//-----------------------------------------------------------------
	public static void jugar() throws InterruptedException 
	{
		System.out.println("\n Comienza la partida: ");
		System.out.println();	
		System.out.println("\n Vas a luchar contra monstruos en "+ mazmorra.getNumHabitaciones()+ " habitaciones");
		System.out.println("\n Acabados tus puntos de vida, solo te puedes curar una vez con la pocion ");
		System.out.println("");
		
		int segundos=5;
		
		while (segundos>0)
		{
			System.out.println(segundos);
			segundos--;
			Thread.sleep(1000);
		}	
		for (int i=0; i<mazmorra.getNumHabitaciones(); i++)
		{
			Habitacion habitacion = mazmorra.getSiguienteHabitacion(); // Tambien valdria: Habitacion habitacion = mazmorra.getHabitaciones().get(i);
			mostrarMenuCombate(i, habitacion);
			Monstruo monstruo = habitacion.getMonstruo();
			
			while (monstruo.getPuntosVida()>0 && heroe.getPuntosVida()>0)
			{
				Combate.ataque(heroe, monstruo);
				System.out.println("Combate terminado: ");
				System.out.println("\t Heroe: " + heroe.getPuntosVida());
				System.out.println("\t Monstruo: " + monstruo.getPuntosVida());
				System.out.println("");

				Thread.sleep(3000);
				
				if(monstruo.getPuntosVida()<=0)
				{
					// Si matamos al monstruo, sumamos su tesoro
					tesoro +=habitacion.getTesoro().getMonedas();
					System.out.println("Monstruo eliminado");
					System.out.println("Tesoro ganado: " + habitacion.getTesoro().getMonedas()+" monedas");
				}
				if(heroe.getPuntosVida() <=0)
				{
					if(heroe.getPocion()>0)
					{
						heroe.curarse();
						System.out.println("\n Has usado la pocion para recuperarte");
					}
					else
					{
						System.out.println("\n Lo siento, has muerto");
					}
				}
			}
			
			if (heroe.getPuntosVida()>0)
			{
				System.out.println("\n Enhorabuena, has superado la habitacion "+ (i+1) + "!");
			}
			else
			{
				break;
			}
		}
		
		if (heroe.getPuntosVida()>0)
		{
			System.out.println("\n Enhorabuena, has ganado la partida! ");
		}		
		mostrarResultados();
	}		
	//-----------------------------------------------------------------
	// mostrarMenuCombate:
	// Muestra el menu de combate en cada habitacion, el heroe y el monstruo.
	//-----------------------------------------------------------------
	public static void mostrarMenuCombate(int i, Habitacion habitacion)
	{
		System.out.println("\nCombate!");
		System.out.println();
		System.out.println("Habitacion "+(i+1));
		System.out.println("Heroe: "+heroe.toString());
		System.out.println("Monstruo: "+ habitacion.toString());
	}	
	//-----------------------------------------------------------------
	// mostrarResultados:
	// Muestra los datos del heroe, y la cantidad de habitaciones terminadas, monstruos muertos y monedas.
	//-----------------------------------------------------------------
	public static void mostrarResultados()
	{
		int habitacionesTerminadas=0;
		
		for (int i=0; i<mazmorra.getNumHabitaciones(); i++)
		{
			Habitacion habitacion = mazmorra.getHabitaciones().get(i);
			
			if (habitacion.getMonstruo().estaMuerto())
			{
				habitacionesTerminadas++;
			}
			else
			{
				break;
			}
		}
		System.out.println();
		System.out.println("Estado del heroe: "+heroe.toString());
		System.out.println("Habitaciones terminadas y monstruos muertos: " + habitacionesTerminadas);
		System.out.println("Monedas totales: "+tesoro);	
	}
}