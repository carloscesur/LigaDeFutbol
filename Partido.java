public class Partido {

    //ATRIBUTOS
    private int numeroPartido;
    private String equipoLocal;
    private String equipoVisitante;
    private String equipoDescansando;
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
    public void setNumeroPartido(int numeroPartido) {
        this.numeroPartido = numeroPartido;
    }
    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }
    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }
    public void setEquipoDescansando(String equipoDescansando) {
        this.equipoDescansando = equipoDescansando;
    }
    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }
    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    //Getters
    public int getNumeroPartido() {
        return numeroPartido;
    }
    public String getEquipoLocal() {
        return equipoLocal;
    }
    public String getEquipoVisitante() {
        return equipoVisitante;
    }
    public String getEquipoDescansando() {
        return equipoDescansando;
    }
    public int getGolesLocal() {
        return golesLocal;
    }
    public int getGolesVisitante() {
        return golesVisitante;
    }
}
