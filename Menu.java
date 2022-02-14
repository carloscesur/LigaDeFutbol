import java.util.Scanner;

public class Menu {

	public void mostrarMenu(){

		//Menu de opciones disponibles
		int opcion=1;
		while (opcion != 4) {			

			imprimirMenu ();

			opcion = leerEntrada();
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
				System.out.println("Hasta la proxima.");
				break;				
			default:
				System.out.println("Opcion incorrecta, introduzca opcion valida.");			
			}				
		}
	}
	
	public static void imprimirMenu() {
		System.out.println("***************************************");
		System.out.println("*********** Menú Principal ************");
		System.out.println("* 1.- Ver la clasificación actual     *");
		System.out.println("* 2.- Ver el calendario               *");
		System.out.println("* 3.- Introducir nuevos resultados    *");
		System.out.println("* 4.- Salir de la aplicacion          *");
		System.out.println("***************************************");
		System.out.println("Introduzca una opción: ");			
	}
	
	public static int leerEntrada() {
		Scanner sc = new Scanner(System.in);
		int numero = sc.nextInt();
		return numero;
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
