public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//CREAR UNA LISTA DE EQUIPOS
		int edad = (int) Math.floor(Math.random()*15)+4;
		int numeroEquipos = (int) Math.floor(Math.random()*13)+4;
		Equipo[] listaEquipos = crearEquipos(numeroEquipos, edad);

		//CREAMOS LA LIGA
		Liga liga = new Liga(listaEquipos);

		//IMPORTANTE, AHORA MISMO SOLO CREA LA IDA
		//SE ARREGLA EN CALENDARIO
		//TAMBIÉN SE CREAN GOLES ALEATORIOS EN PARTIDO, Y DEBE SER EN EL MAIN
		//emparejamiento(listaEquipos);


		/*
		//Imprimimos los equipos
		System.out.println("Numero de equipos: "+numeroEquipos);
		for (Equipo e: listaEquipos) {
			System.out.println(e.getNombre());
		}*/

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

	private static Arbitro crearArbitro() {
		//Listado de Nombres, Apellidos, Posiciones para generador random
		String[] nombres = {"Antonio", "Pepito", "Alejandra", "Ismael", "Hugo", "Oliver","Kalesi",
				"Ingrid","Astrid","Indira","Jenny","Jessi","Vane","Joel","Bruno",
				"Sasha","Billie","Masha","Pingu"};
		String[] apellidos = {"Messi", "Vinicius", "Cristiano", "Ronaldo", "PiquÃ©","Bale (lesionado)",
				"Amunike","N'kono","ButragueÃ±o","Sanchis","Neymar","Batistuta","Maradona",
				"PelÃ©","Beckenbauer"};
		
		Arbitro arbitro = new Arbitro();

		//Nombre
		int numero = (int) Math.floor(Math.random()*nombres.length);
		String nombre = nombres[numero];
		arbitro.setNombre(nombre);

		//Apellidos
		numero = (int) Math.floor(Math.random()*apellidos.length);
		String apellido1 = apellidos[numero];
		numero = (int) Math.floor(Math.random()*apellidos.length);
		String apellido2 = apellidos[numero];
		arbitro.setApellidos(apellido1+" "+apellido2);		

		//Edad
		int edad = (int) Math.floor(Math.random()*47)+18;
		arbitro.setEdad(edad);
		//Licencia
		int licencia = (int) Math.floor(Math.random()*100000);
		arbitro.setLicencia(licencia);

		return arbitro;
	}
	
	private static void emparejamiento(Equipo[] listaEquipos){

		Equipo[] emparejamiento1;
		Equipo[] emparejamiento2;

		System.out.println(listaEquipos.length);

		if(listaEquipos.length%2==0){
			emparejamiento1 = new Equipo[listaEquipos.length];
			emparejamiento2 = new Equipo[listaEquipos.length];
		}else{
			emparejamiento1 = new Equipo[listaEquipos.length+1];
			emparejamiento2 = new Equipo[listaEquipos.length+1];
		}

		//PRIMERA JORNADA
		System.out.println("JORNADA 1");
		for (int i=0; i< emparejamiento1.length; i++){

			try{
				emparejamiento1[i] = listaEquipos[i];
			}catch (Exception e){

			}
			try{
				System.out.println(emparejamiento1[i].getNombre());
			}catch (Exception e){
				System.out.println("Null");
			}
		}
		System.out.println();

		//SIGUIENTES JORNADAS
		for (int j=0; j<(emparejamiento1.length-2); j++){

			//JORNADAS PARES
			System.out.println("JORNADA "+(j+2));
			if(j%2==0){
				for (int i=0; i< emparejamiento1.length; i++){

					if(i%2==0){
						emparejamiento2[i] = emparejamiento1[i];
						//System.out.println("Soy impar");
					}else if (i%2!=0 && i!=(emparejamiento1.length-1)){
						emparejamiento2[i+2] = emparejamiento1[i];
						//System.out.println("Soy par");
					}else{
						emparejamiento2[1] = emparejamiento1[i];
						//System.out.println("Soy el ultimo");
					}
				}
				for(int i=0; i< emparejamiento1.length; i++){
					try{
						System.out.println(emparejamiento2[i].getNombre());
					}catch (Exception e){
						System.out.println("Null");
					}
				}

			//JORNADAS IMPARES
			}else{
				for (int i=0; i< emparejamiento1.length; i++){
					if(i==0){
						emparejamiento1[1] = emparejamiento2[i];
						//System.out.println("Soy el primero");
					}else if(i==1){
						emparejamiento1[emparejamiento1.length-1] = emparejamiento2[i];
						//System.out.println("Soy el segundo");
					}else if(i==(emparejamiento1.length-1)){
						emparejamiento1[i-1] = emparejamiento2[i];
						//System.out.println("Soy el ultimo");
					}else if(i%2==0){
						emparejamiento1[i-2] = emparejamiento2[i];
						//System.out.println("Soy impar");
					}else{
						emparejamiento1[i] = emparejamiento2[i];
						//System.out.println("Soy par");
					}
				}
				for(int i=0; i< emparejamiento1.length; i++){
					try{
						System.out.println(emparejamiento1[i].getNombre());
					}catch (Exception e){
						System.out.println("Null");
					}
				}
			}
			System.out.println();
		}

	}
}
