/**
 * Representa un portero en el torneo de handball. 
 * Extiende la clase {@link Jugador}.
 */

public class Portero extends Jugador {
    private int paradasEfectivas;
    private int golesRecibidos;

    public Portero(){
        super();
        this.paradasEfectivas = 0;
        this.golesRecibidos = 0;
    }

    public Portero(String nombre, String pais, int faltas, int golesDirectos, int totalLanzamientos, int paradasEfectivas, int golesRecibidos){
        super(nombre, pais, faltas, golesDirectos, totalLanzamientos);
        this.paradasEfectivas = paradasEfectivas;
        this.golesRecibidos = golesRecibidos;
    }

    public int getParadasEfectivas(){
        return this.paradasEfectivas;
    }

    public int getGolesRecibidos(){
        return this.golesRecibidos;
    }

    public void setParadasEfectivas(int paradasEfectivas){
        this.paradasEfectivas = paradasEfectivas;
    }

    public void setGolesRecibidos(int golesRecibidos){
        this.golesRecibidos = golesRecibidos;
    }

    @Override
    public String toString(){
        return super.toString() + " Paradas efectivas: " + this.paradasEfectivas + " Goles recibidos: " + this.golesRecibidos;
    }

    /**
     * Calcula la efectividad del portero, combinando la efectividad como jugador y como portero.
     * @return La efectividad total del portero como un porcentaje.
     */

    public float efectividad(){
        if(paradasEfectivas + golesRecibidos == 0) return super.efectividad();
        float efectividadPorteo = (paradasEfectivas - golesRecibidos)*(100/paradasEfectivas + golesRecibidos);
        return super.efectividad() + efectividadPorteo;
    }
}
