/**
 * Representa un torneo de handball, manteniendo listas de jugadores extremos y porteros.
 */
import java.util.ArrayList;

public class Torneo {
    private ArrayList<Extremo> jugadoresExtremos;
    private ArrayList<Portero> jugadoresPorteros;

    public Torneo(){
        this.jugadoresExtremos = new ArrayList<Extremo>();
        this.jugadoresPorteros = new ArrayList<Portero>();
    }

    public void agregarPortero(String nombre, String pais, int faltas, int golesDirectos, int totalLanzamientos, int paradasEfectivas, int golesRecibidos){
        Portero Por = new Portero(nombre, pais, faltas, golesDirectos, totalLanzamientos, paradasEfectivas, golesRecibidos);
        jugadoresPorteros.add(Por);
    }

    public void agregarExtremo(String nombre, String pais, int faltas, int golesDirectos, int totalLanzamientos, int pasesEfectivos, int asistenciasEfectivas){
        Extremo Ex = new Extremo(nombre, pais, faltas, golesDirectos, totalLanzamientos, pasesEfectivos, asistenciasEfectivas);
        jugadoresExtremos.add(Ex);
    }

    public void mostrarJugadores(){
        System.out.println("Lista de los porteros: ");
        for (Portero Por : jugadoresPorteros){
            System.out.println(Por.toString());
            System.out.println("Efectividad: " + Por.efectividad());
            
        }
        System.out.println("Lista de los extremos: ");
        for (Extremo Ex : jugadoresExtremos){
            System.out.println(Ex.toString());
        }
    }
    /**
     * Muestra los tres porteros con mayor efectividad en el torneo.
     */
    public void top3PorterosSegunEfectividad(){
        if(jugadoresPorteros.size() < 3) {
            System.out.println("No hay suficientes porteros para mostrar el top 3.");
            return;
        }
        jugadoresPorteros.sort((portero1, portero2) -> Float.compare(portero2.efectividad(), portero1.efectividad()));
        
        System.out.println("Top 3 Porteros según efectividad:");
        for(int i = 0; i < 3; i++) {
            Portero portero = jugadoresPorteros.get(i);
            System.out.println((i + 1) + ". " + portero.getNombre() + " - Efectividad: " + portero.efectividad());
        } 
    }
    /**
     * Muestra los extremos con más del 85% de efectividad en el torneo.
     */
    public void extemosSobre85(){
        System.out.println("Extremos con más del 85% de efectividad:");
        for(Extremo extremo : jugadoresExtremos) {
        if(extremo.efectividad() > 85) {
            System.out.println(extremo.getNombre() + " - Efectividad: " + extremo.efectividad());
        }
    }
    }

}
