public class Partido {

    //ATRIBUTOS
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int golesLocal;
    private int golesVisitante;

    //METODOS
    public int golesLocal(){
        this.golesLocal = (int) Math.floor(Math.random()*10);
        return golesLocal;
    }
    public int golesVisitane(){
        this.golesVisitante = (int) Math.floor(Math.random()*10);
        return golesVisitante;
    }

    //Setters
    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }
    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }
    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }
    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    //Getters
    public Equipo getEquipoLocal() {
        return equipoLocal;
    }
    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }
    public int getGolesLocal() {
        return golesLocal;
    }
    public int getGolesVisitante() {
        return golesVisitante;
    }
}
