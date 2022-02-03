import java.lang.Math;
public class Partido {
    

    
    public Partido(Jugador[] listaEquipos, int teams, int round){

        teams = listaEquipos.length;
        round = listaEquipos.length-1;

        public static void main(int teams, int round) {
            if (((teams%2 != 0) && (round != teams - 1))||(teams <= 0))
                throw new IllegalArgumentException();
            int[] cycle = new int[teams];
            int n = teams /2;
            for (int i = 0; i < n; i++) {				
                cycle[i] = i + 1;
                cycle[teams - i - 1] = cycle[i] + n;
            }			
                    
            for(int d = 1; d <= round; d++) {
                System.out.println(String.format("Round %d", d));
                for (int i = 0; i < n; i++) {					
                    System.out.println(String.format("team %d - team %d",cycle[i],cycle[teams - i - 1]));					 
                }	
                int temp = cycle[1];
                for (int i = 1; i < teams - 1; i++) {
                    int pr = cycle[i+1];
                    cycle[i+1] = temp;
                    temp = pr;
                }
                cycle[1] = temp;		
            }
        }
        }

}
