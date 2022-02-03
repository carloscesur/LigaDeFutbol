

public class Calendario {
    //Atributos
    Liga liga;
    Jornada[] jornadas;

    //Metodos
    public Calendario ( Liga liga){
        this.liga=liga;
        //Quiero sacar la lista de equipos de la liga para poder empezar a crear el calendario
        Equipo[] listaEquipos = liga.getEquipos();
    }

}