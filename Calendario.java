public class Calendario {

    //ATRIBUTOS
    private Jornada[] jornadas;

    //CONSTRUCTOR
    public Calendario(Equipo[] listaEquipos) {

        //Creamos las Jornadas
        if(listaEquipos.length%2==0){
            //this.jornadas = new Jornada[(listaEquipos.length-1)*2];
            this.jornadas = new Jornada[(listaEquipos.length-1)];
        }else{
            //this.jornadas = new Jornada[(listaEquipos.length)*2];
            this.jornadas = new Jornada[(listaEquipos.length)];
        }
        this.jornadas = emparejamiento(listaEquipos);

    }

    //METODOS

    //Empareja los equipos
    private static Jornada[] emparejamiento(Equipo[] listaEquipos){

        //El array de jornadas y
        //Las listas de equipos que nos servirán exclusivamente para volcar los emparejamientos.
        Jornada[] jornadas;
        Equipo[] emparejamiento1;
        Equipo[] emparejamiento2;

        //Condicionamos las dimensiones de los arreglos dependiendo de si la lista de equipos es par o impar.
        if(listaEquipos.length%2==0){
            //jornadas = new Jornada[(listaEquipos.length-1)*2];
            jornadas = new Jornada[(listaEquipos.length-1)];
            emparejamiento1 = new Equipo[listaEquipos.length];
            emparejamiento2 = new Equipo[listaEquipos.length];
        }else{
            //jornadas = new Jornada[(listaEquipos.length)*2];
            jornadas = new Jornada[(listaEquipos.length)];
            emparejamiento1 = new Equipo[listaEquipos.length+1];
            emparejamiento2 = new Equipo[listaEquipos.length+1];
        }


        //PRIMERA JORNADA
        for (int i=0; i< emparejamiento1.length; i++){

            try{
                emparejamiento1[i] = listaEquipos[i];
            }catch (Exception e){

            }
        }

        //Metemos la primera Jornada en el primer indice del Array
        Jornada jornada1 = new Jornada(emparejamiento1);
        jornadas[0] = jornada1;

        //SIGUIENTES JORNADAS
        for (int j=0; j<(emparejamiento1.length-2); j++){

            //JORNADAS PARES
            if(j%2==0) {
                for (int i = 0; i < emparejamiento1.length; i++) {

                    if (i % 2 == 0) {
                        emparejamiento2[i] = emparejamiento1[i];
                        //System.out.println("Soy impar");
                    } else if (i % 2 != 0 && i != (emparejamiento1.length - 1)) {
                        emparejamiento2[i + 2] = emparejamiento1[i];
                        //System.out.println("Soy par");
                    } else {
                        emparejamiento2[1] = emparejamiento1[i];
                        //System.out.println("Soy el ultimo");
                    }
                }
                Jornada jornadaPar = new Jornada(emparejamiento2);
                jornadas[j + 1] = jornadaPar;

            //JORNADAS IMPARES
            }else {
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
                Jornada jornadaImpar = new Jornada(emparejamiento1);
                jornadas[j+1] = jornadaImpar;
            }
        }
        return jornadas;
    }

    //Setters
    public void setJornadas(Jornada[] jornadas) {
        this.jornadas = jornadas;
    }

    //Getters
    public Jornada[] getJornadas() {
        return jornadas;
    }

}