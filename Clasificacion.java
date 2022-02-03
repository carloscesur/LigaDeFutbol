public class Clasificacion {

    //Pts - Puntos, V - Victorias, E - Empates, D - Derrotas, GF - Goles a favor, GC - Goles en contra.
    private Liga liga;
    private EquipoClasificacion[] clasificacionEquipos;

    public Clasificacion(Liga liga){
        //Sacamos los equipos de la liga
        this.liga=liga;
        Equipo[] lista = this.liga.getEquipos();
        this.clasificacionEquipos =  new EquipoClasificacion[lista.length];

        //Metemos los equipos en la lista de la Clasificacion
        for (int i=0; i<clasificacionEquipos.length;i++){
            clasificacionEquipos[i]=new EquipoClasificacion();
            clasificacionEquipos[i].setEquipo(lista[i]);
        }

        //Generamos la clasificacion

        Calendario miCalendario = this.liga.getCalendario();
        // Saco las jornadas
        // Jornada[] misJornadas = calendario.getJornadas;
        //for (Jornada j: misJornadas){
        //      Partidos[] misPartidos = j.getPartidos();
         //      for (Partido p: misPartidos){
        //             if (p.getGolesHome>p.getGolesAway){
        //


    }

}
