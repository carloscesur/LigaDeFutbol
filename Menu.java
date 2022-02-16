import java.util.Scanner;

public class Menu {

	private Liga liga;

	public Menu (Liga liga){

		this.liga = liga;
	}

	public void mostrarMenu(){

		//Menu de opciones disponibles
		int opcion=1;
		while (opcion != 6) {			

			imprimirMenu ();

			opcion = leerEntrada();
			switch(opcion) {
			case 1:
				//Quitar este comentario cuando se implemente el codigo en clasificacion
				//clasificacion();
				break;
			case 2:
				calendario(liga);
				break;
			case 3:
				//Quitar este comentario cuando se implemente el codigo en nuevoResultado
				//nuevoResultado();
				break;
			case 4:
				mostrarListaEquipos(liga);
				break;
			case 5:
				mostrarListaArbitros(liga);
				break;
			case 6:
				System.out.println("\nHasta la proxima.");
				break;				
			default:
				System.out.println("\nOpcion incorrecta, introduzca opcion valida.");			
			}				
		}
	}
	
	public static void imprimirMenu() {
		System.out.println("\n***************************************");
		System.out.println("*********** Menu Principal ************");
		System.out.println("* 1.- Ver la clasificacion actual     *");
		System.out.println("* 2.- Ver el calendario               *");
		System.out.println("* 3.- Introducir nuevos resultados    *");
		System.out.println("* 4.- Mostrar la lista de equipos     *");
		System.out.println("* 5.- Mostrar la lista de arbitros    *");
		System.out.println("* 6.- Salir de la aplicacion          *");
		System.out.println("***************************************");
		System.out.print("Introduzca una opcion: ");
	}
	
	public static int leerEntrada() {
		Scanner sc = new Scanner(System.in);
		int numero = sc.nextInt();
		return numero;
	}
	
	private static void clasificacion(int opcion) {
		//Metodo para mostrar la clasificacion
	}

	private static void calendario(Liga liga) {

		//Nos traemos el array de jornadas
		Jornada[] jornadas = liga.getCalendario().getJornadas();

		for (int i=0; i<jornadas.length; i++){

			System.out.println("JORNADA "+(i+1));

			Jornada jornada = jornadas[i];
			Equipo[] equipos = jornada.getEquiposEmparejados();

			for (int j=0; j< equipos.length; j=j+2){

				if(j%2==0){
					Equipo equipoLocal = equipos[j];
					Equipo equipoVisitante = equipos[j+1];

					//Intenta imprimir el emparejamiento y sino imprime el equipo que descansa
					try{
						System.out.println(equipoLocal.getNombre()+" VS "+equipoVisitante.getNombre());
					}catch (Exception e){
						System.out.println(equipoLocal.getNombre()+" DESCANSAN.");
					}
				}
			}
			System.out.println();
		}
	}

	private static void nuevoResultado(int opcion) {
		//Metodo para introducir nuevos resultados
	}
	
	//Con este metodo obtendria los datos de equipo a traves de Liga
	private static void mostrarListaEquipos(Liga liga) {
		//Nos traemos el array de equipos
		Equipo[] equipos = liga.getEquipos();
		
		System.out.println();

		for (int i=0; i< equipos.length; i++){
			
			Equipo equipo = equipos[i];

			System.out.println("Equipo "+(i+1)+": "+equipo.getNombre());
		}
	}
	
	//Con este metodo se obtienen los datos de arbitro a traves de Liga
	private static void mostrarListaArbitros(Liga liga) {
		//Nos traemos el array de arbitros
		Arbitro[] arbitros = liga.getArbitros();
		
		System.out.println();

		for (int i=0; i< arbitros.length; i++){
			
			Arbitro arbitro = arbitros[i];
			System.out.println("Arbitro "+(i+1)+": "+arbitro.getNombre()+" "+arbitro.getApellidos());
		}
	}
}
