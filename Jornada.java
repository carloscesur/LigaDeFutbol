public class Jornada {

     private Partido[] partidos;
     private Equipo[] equiposEmparejados;

     public Jornada(Equipo[] equipos){

          this.equiposEmparejados = equipos;
          this.partidos = generarPartidos(equiposEmparejados);
     }

     private Partido[] generarPartidos(Equipo[] equiposEmparejados){

          Partido[] partidos = new Partido[equiposEmparejados.length/2];

          int indeceArrayPartido =0 ;

          for (int i=0; i<equiposEmparejados.length; i=i+2){



               if(equiposEmparejados[i]!=null && equiposEmparejados[i+1]!=null){
                    Partido partido = new Partido();
                    partido.setEquipoLocal(equiposEmparejados[i]);
                    partido.setEquipoVisitante(equiposEmparejados[i+1]);

                    partido.golesLocal();
                    partido.golesVisitane();


                    //ME QUEDA PASAR LOS PARTIDOS AL ARRAY DE PARTIDOS CORRECTAMENTE
                    partidos[indeceArrayPartido]=partido;

                    indeceArrayPartido = indeceArrayPartido+1;
               }
          }

          return partidos;
     }

     //Setters
     public void setPartidos(Partido[] partidos) {
          this.partidos = partidos;
     }
     public void setEquiposEmparejados(Equipo[] equiposEmparejados) {
          this.equiposEmparejados = equiposEmparejados;
     }

     //Getters
     public Partido[] getPartidos() {
          return partidos;
     }
     public Equipo[] getEquiposEmparejados() {
          return equiposEmparejados;
     }
}
