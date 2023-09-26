/**
 * Representa un extremo en el torneo de handball. 
 * Extiende la clase {@link Jugador}.
 */
public class Extremo extends Jugador{

    private int pasesEfectivos;
    private int asistenciasEfectivas;

    public Extremo(){
        super();
        this.pasesEfectivos=0;
        this.asistenciasEfectivas=0;
    }

    public Extremo(String nombre, String pais, int faltas, int golesDirectos, int totalLanzamientos, int pasesEfectivos, int asistenciasEfectivas){
        super(nombre, pais, faltas, golesDirectos, totalLanzamientos);
        this.pasesEfectivos=pasesEfectivos;
        this.asistenciasEfectivas=asistenciasEfectivas;
    }

    public int getPasesEfectivos(){
        return this.pasesEfectivos;
    }

    public int getAsistenciasEfectivas(){
        return this.asistenciasEfectivas;
    }

    public void setPasesEfectivos(int pasesEfectivos){
        this.pasesEfectivos=pasesEfectivos;
    }

    public void setAsistenciasEfectivas(int asistenciasEfectivas){
        this.asistenciasEfectivas=asistenciasEfectivas;
    }

    @Override
    public String toString(){
        return super.toString() + " Pases efectivos: " + this.pasesEfectivos + " Asistencias efectivas: " + this.asistenciasEfectivas;
    }

    /**
     * Calcula la efectividad del extremo, combinando la efectividad como jugador y como extremo.
     * @return La efectividad total del extremo como un porcentaje.
     */

    public float efectividad(){
        if(pasesEfectivos + asistenciasEfectivas + faltas == 0) return super.efectividad();
        float efectividadExtremo = (pasesEfectivos + asistenciasEfectivas) * (100/pasesEfectivos + asistenciasEfectivas + faltas);
        return super.efectividad() + efectividadExtremo;
    }
    
}
