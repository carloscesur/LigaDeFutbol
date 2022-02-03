public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Crear una Lista de Equipo
		int edad = (int) Math.floor(Math.random()*15)+4;
		int numeroEquipos = (int) Math.floor(Math.random()*13)+4;
		Equipo[] listaEquipos = crearEquipos(numeroEquipos, edad);
		
		//Imprimimos los equipos
		System.out.println("Numero de equipos: "+numeroEquipos);
		for (Equipo e: listaEquipos) {
			System.out.println(e.getNombre());
		}
		
		//Menu de opciones disponibles
		int opcion=1;
		while (opcion != 4) {			

			imprimirMenu ();

			opcion= leerEntrada();
			switch(opcion) {
			case 1:
				//Quitar este comentario cuando se implemente el codigo en clasificacion
				//clasificacion();
				break;
			case 2:
				//Quitar este comentario cuando se implemente el codigo en calendario
				//calendario();
				break;
			case 3:
				//Quitar este comentario cuando se implemente el codigo en nuevoResultado
				//nuevoResultado();
				break;
			case 4:
				System.out.println("Hasta la proxima.");;
				break;				
			default:
				System.out.println("Opcion incorrecta, introduzca opcion valida.");			
			}				
		}		
	}
	
	public static void imprimirMenu() {
		System.out.println("***************************************");
		System.out.println("*********** Menú Principal ************");
		System.out.println("1.- Ver la clasificación actual *******");
		System.out.println("2.- Ver el calendario *****************");
		System.out.println("3.- Introducir nuevos resultados ******");
		System.out.println("4.- Salir de la aplicacion ************");
		System.out.println("***************************************");
		System.out.println("Introduzca una opción: ");			
	}
	
	public static int leerEntrada() {
		Scanner sc = new Scanner(System.in);
		int numero = sc.nextInt();
		return numero;
	}

	private static Jugador[] crearJugadores(int numeroJugadores, int edad, Equipo equipo) {
		//Listado de Nombres, Apellidos, Posiciones para generador random
		String[] nombres = {"Antonio", "Pepito", "Alejandra", "Ismael", "Hugo", "Oliver","Kalesi",
				"Ingrid","Astrid","Indira","Jenny","Jessi","Vane","Joel","Bruno",
				"Sasha","Billie","Masha","Pingu"};
		String[] apellidos = {"Messi", "Vinicius", "Cristiano", "Ronaldo", "Piqué","Bale (lesionado)",
				"Amunike","N'kono","Butragueño","Sanchís","Neymar","Batistuta","Maradona",
				"Pelé","Beckenbauer"};
		String[] posiciones = {"Portero/a","Defensa","Centrocampista","Delantero/a"};
		
		//Estructura de Array de Jugadores
		Jugador[] jugadores = new Jugador[numeroJugadores];
		
		for (int i=0; i<numeroJugadores; i++) {
			//Crear un Jugador
			Jugador jug = new Jugador();
			//Nombre
			int numero = (int) Math.floor(Math.random()*nombres.length);
			String nombre = nombres[numero];
			jug.setNombre(nombre);

			//Apellidos
			numero = (int) Math.floor(Math.random()*apellidos.length);
			String apellido1 = apellidos[numero];
			numero = (int) Math.floor(Math.random()*apellidos.length);
			String apellido2 = apellidos[numero];
			jug.setApellidos(apellido1+" "+apellido2);

			//Posición
			numero = (int) Math.floor(Math.random()*posiciones.length);
			String posicion = posiciones[numero];
			jug.setPosicion(posicion);

			//Edad
			jug.setEdad(edad);

			//Dorsal
			jug.setDorsal(i+1);
			
			//Equipo
			jug.setEquipo(equipo);

			jugadores[i]=jug;

		}
		
		return jugadores;
	}

	private static Equipo[] crearEquipos(int numeroEquipos,int edad) {
		
		String [] nombreBarrios = {"El Candado", "Huelin", "Tiro Pichón", "Rincón de la Victoria", "La Rosaleda", "Torremolinos",
				"Velez Málaga","Cerrado de Calderon", "El Puerto de la Torre", "Bresca", "Mezquitilla", "Teatinos", "Motril",
				"Centro","Santa Paula", "El Palo", "Los Corazones", "Las Delicias", "Recogidas","Nueva Málaga", "Casas Blancas",
				"La Palmilla","Los Asperones","Campanillas","La Corta"};
		String [] mascotas = {"Los Pollos", "Los Araclanes", "Los Limones", "Los Delfines", "Los Chanquetes", "Los Gatitos",
								"Los Boquerones", "Los Toros", "Los Perritos", "Los Halcones", "Los Ornitorrincos", "Los Caracoles",
								"Los Palomos Cojos", "Los Heterosaurios", "Las Tortugas Ninjas", "Los Pintarrojas"};

		Equipo [] listaEquipos= new Equipo[numeroEquipos];
		
		for (int i=0; i<numeroEquipos; i++) {
			//Creamos Equipo
			Equipo equipo = new Equipo();


			
			//Elegimos random un nombre y una mascota de las listas respectivas.
			int numero = (int) Math.floor(Math.random()*nombreBarrios.length);
			String barrio= nombreBarrios[numero];
			numero = (int) Math.floor(Math.random()*mascotas.length);
			String mascota= mascotas[numero];

			//Definimos el club en base al nombre del barrio
			equipo.setClub(barrio+" F.C.");
			
			//Las pegamos con un "de" en medio
			String nombre;
			if (barrio.startsWith("El ")) {
				barrio=barrio.substring(3);
				nombre = mascota + " del "+ barrio;
			}else {
				nombre = mascota + " de "+ barrio;
			}
			
			equipo.setNombre(nombre);
			//Continuamos con entrenador
			Entrenador entrenador = crearEntrenador(equipo);
			equipo.setEntrenador(entrenador);
			
			//Meter los jugadores
			int numeroJugadores=(int) Math.floor(Math.random()*7)+15;
			Jugador[] jugadores = crearJugadores(numeroJugadores,edad,equipo);
			equipo.setJugadores(jugadores);
			
			//Meter el equipo en el array de equipos
			
			listaEquipos[i]=equipo;
		
		}
		return listaEquipos;
		
	}

	private static Entrenador crearEntrenador(Equipo equipo) {
		//Listado de Nombres, Apellidos, Posiciones para generador random
		String[] nombres = {"Antonio", "Pepito", "Alejandra", "Ismael", "Hugo", "Oliver","Kalesi",
				"Ingrid","Astrid","Indira","Jenny","Jessi","Vane","Joel","Bruno",
				"Sasha","Billie","Masha","Pingu"};
		String[] apellidos = {"Messi", "Vinicius", "Cristiano", "Ronaldo", "Piqué","Bale (lesionado)",
				"Amunike","N'kono","Butragueño","Sanchís","Neymar","Batistuta","Maradona",
				"Pelé","Beckenbauer"};
		Entrenador entrenador = new Entrenador();
		
		//Nombre
		int numero = (int) Math.floor(Math.random()*nombres.length);
		String nombre = nombres[numero];
		entrenador.setNombre(nombre);

		//Apellidos
		numero = (int) Math.floor(Math.random()*apellidos.length);
		String apellido1 = apellidos[numero];
		numero = (int) Math.floor(Math.random()*apellidos.length);
		String apellido2 = apellidos[numero];
		entrenador.setApellidos(apellido1+" "+apellido2);
		
		//Equipo
		entrenador.setEquipo(equipo);
		
		//Edad
		int edad = (int) Math.floor(Math.random()*47)+18;
		entrenador.setEdad(edad);
		//Licencia
		int licencia = (int) Math.floor(Math.random()*100000);
		entrenador.setNumeroLicencia(licencia);
		
		return entrenador;
	}

	//private static  Clasificacion[] crearClasificacion(){

		//Equipo [] listaEquipos= new Equipo[numeroEquipos];

		//for (int i=0; i<numeroEquipos; i++) {
			//Creamos Equipo
			//Equipo equipo = new Equipo();
	}
	
	private static void clasificacion(int opcion) {
		//Metodo para mostrar la clasificacion
	}
	
	private static void calendario(int opcion) {
		//Metodo para mostrar el calendario
	}
	
	private static void nuevoResultado(int opcion) {
		//Metodo para introducir nuevos resultados
	}
}
