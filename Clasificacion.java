public class Clasificacion {
	
	//Se necesita
	//Los equipos de la Liga
	//La jornada
	//Se compara y se ordenan
	
	private EquipoClasificacion[] tabla;

	public Clasificacion(Equipo[] equipos, Calendario calendario) {
		
		//Numeros de equipos que tenemos
		int numeroEquipos=equipos.length;
		
		//Iniciamos la tabla
		this.tabla = new EquipoClasificacion[numeroEquipos];
		
		//LLenamos la tabla
		for (int i=0;i<numeroEquipos;i++) {
			this.tabla[i] = new EquipoClasificacion();
			this.tabla[i].setEquipo(equipos[i]);
		}
		
		//creamos Jornada
		Jornada [] jornadas = calendario.getJornadas();
		
		//Lenamos Jornada
		for (Jornada jor: jornadas) {
			if (jor.isTerminada()) { ///////////////////////////////////////Crear metodo en jornada para si esta terminada (isTerminada)////////////////////////////////////

				//Creamos Partido
				Partido [] partidos = jor.getPartidos();
				
				//Llenamos Partido
				for (Partido par: partidos) {
					
					//Diferenciamos los equipos en Local y Visitante
					
					//Nos traemos el Equipo Local
					Equipo local = par.getEquipoLocal();
					
					//Nos traemos el Equipo Visitante
					Equipo visitante = par.getEquipoVisitante();
					
					//Se recorre la tabla y s ebuscan los equipos
					
					//Equipo Local
					int contador=0;
					EquipoClasificacion localClas = tabla[contador];
					while (localClas.getEquipo()!=local) {
						contador++;
						localClas=tabla[contador];
					}
					
					//Equipo Visitante
					contador = 0;
					EquipoClasificacion visitClas =  tabla[contador];
					while (visitClas.getEquipo()!=visitante) {
						contador++;
						visitClas=tabla[contador];
					}
					
					//Vemos el resultado del partido

					int golesLocal = par.getGolesLocal();
					int golesVisitante = par.getGolesVisitante();

					//Se actualiza la tabla con los datos del partido
					
					//Para el equipo Local
					localClas.addGolesFavor(golesLocal);			///estos metodos debieran ir en EquipoClasificacion (revisarlo)
					localClas.addGolesContra(golesVisitante);		///estos metodos debieran ir en EquipoClasificacion (revisarlo)
					
					//Para el equipo Visitante
					visitClas.addGolesFavor(golesVisitante);		///estos metodos debieran ir en EquipoClasificacion (revisarlo)
					visitClas.addGolesContra(golesLocal);			///estos metodos debieran ir en EquipoClasificacion (revisarlo)

					//Vemos el resultado del Partido
					
					//Gana el Local
					if (golesLocal>golesVisitante) {
						localClas.addPartidoGanado();				///estos metodos debieran ir en EquipoClasificacion (revisarlo)
						visitClas.addPartidoPerdido();				///estos metodos debieran ir en EquipoClasificacion (revisarlo)
					}
					
					//Gana el Visitante
					else if (golesVisitante>golesLocal) {
						visitClas.addPartidoGanado();				///estos metodos debieran ir en EquipoClasificacion (revisarlo)
						localClas.addPartidoPerdido();				///estos metodos debieran ir en EquipoClasificacion (revisarlo)
					}
					
					//Hay un Empate
					else {
						visitClas.addPartidoEmpatado();				///estos metodos debieran ir en EquipoClasificacion (revisarlo)
						localClas.addPartidoEmpatado();				///estos metodos debieran ir en EquipoClasificacion (revisarlo)
					}
				}
			}
		}
		
		//Ordenamos los equipos con el metodo ordenar()
		ordenar();



	}
	
	//Metodo para ordenar la clasificacion
	private void ordenar() {
		
		// Se ordena mediante bubble sort
		
		//Tamaño
		int n = tabla.length; 
		
		//Variable temporal
		EquipoClasificacion temp = null;
		
		//rellenamos temporal
		for(int i=0; i < n; i++){  
			for(int j=1; j < (n-i); j++){ 
				
				//Aqui llamamos a vaDebajo(bubble sort)
				if(vaDebajo(tabla[j-1],tabla[j])){  
					
					//intercambio de valores de dos variables usando el temporal
					temp = tabla[j-1];  
					tabla[j-1] = tabla[j];  
					tabla[j] = temp;  
				}  

			}  
		}
	}

	//Metodo vaDebajo (bubble sort)
	private boolean vaDebajo(EquipoClasificacion equipo1, EquipoClasificacion equipo2) {
		
		//La primera ordenacion es por puntos
		if (equipo1.getPuntos()<equipo2.getPuntos()) {
			return true;
		}
		else if (equipo1.getPuntos()>equipo2.getPuntos()) {
			return false;
		}
		
		//Si hay Igualdad de puntos se mira la diferencia de goles
		else {
			if (equipo1.getDifGoles()<equipo2.getDifGoles()) {						///estos metodos debieran ir en EquipoClasificacion (revisarlo)
				return true;
			}else if (equipo1.getDifGoles()>equipo2.getDifGoles()){					///estos metodos debieran ir en EquipoClasificacion (revisarlo)
				return false;
			}
			
			//Si hay igualdad de puntos y de diferencia de goles se mirna los partidos jugados
			else {
				if (equipo1.getGanados()<equipo2.getGanados()) {
					return true;
				}else {
					return false;
				}
			}
		}
	}
	
	//Metodo "getTabla"															///Creo que falta tabla en Equipoclasificacion
	public EquipoClasificacion[] getTabla() {
		return tabla;
	}

	//Metodo para crear la tabla
	public void setTabla(EquipoClasificacion[] tabla) {
		this.tabla = tabla;
	}
	
	//Imprimimos la tabla mediante toString
	public String toString() {
		
		//Usamos el /t para tabular la tabla y que quede alineada
		String cadena = "Equipo\t\t\t\t\t\t" + "J\t" + "G\t"+
				"E\t" + "P\t" +"gf\t" + "gc\t"+
				"dg\t"+"Ptos\n";
		for (EquipoClasificacion eqClas:this.tabla) {
			cadena+=eqClas;
		}

		return cadena;

	}
}






    //CÃ“DIGO DE RAFA

    //private int numeroClasificacion;
    //private String nombreClasificacion;
    //private EquipoClasificacion[] clasificacionEquipos;
    //private Liga liga;

    //public Clasificacion(Liga liga){

        //Sacamos los equipos de la liga
        //this.liga=liga;
        //Equipo[] lista = this.liga.getEquipos();
        //this.clasificacionEquipos =  new EquipoClasificacion[lista.length];

        //Metemos los equipos en la lista de la Clasificacion
        //for (int i=0; i<clasificacionEquipos.length;i++){
            //clasificacionEquipos[i]=new EquipoClasificacion();
            //clasificacionEquipos[i].setEquipo(lista[i]);
        //}

        //Generamos la clasificacion
        //Calendario miCalendario = this.liga.getCalendario();
        //// Saco las jornadas
        //// Jornada[] misJornadas = calendario.getJornadas;
        ////for (Jornada j: misJornadas){
        ////      Partidos[] misPartidos = j.getPartidos();
        ////      for (Partido p: misPartidos){
        ////             if (p.getGolesHome>p.getGolesAway){
        ////
    //}


