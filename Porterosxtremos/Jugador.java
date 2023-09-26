/**
 * Representa un jugador en el torneo de handball.
 */
public class Jugador{
    protected String nombre;
    protected String pais;
    protected int faltas;
    protected int golesDirectos;
    protected int totalLanzamientos;

    public Jugador(){
        this.nombre = "";
        this.pais = "";
        this.faltas = 0;
        this.golesDirectos = 0;
        this.totalLanzamientos = 0;
    }
    /**
     * Constructor con parámetros.
     * @param nombre Nombre del jugador.
     * @param pais País del jugador.
     * @param faltas Número de faltas cometidas por el jugador.
     * @param golesDirectos Número de goles directos anotados por el jugador.
     * @param totalLanzamientos Número total de lanzamientos realizados por el jugador.
     */
    public Jugador(String nombre, String pais, int faltas, int golesDirectos, int totalLanzamientos){
        this.nombre = nombre;
        this.pais = pais;
        this.faltas = faltas;
        this.golesDirectos = golesDirectos;
        this.totalLanzamientos = totalLanzamientos;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getPais(){
        return this.pais;
    }

    public int getFaltas(){
        return this.faltas;
    }

    public int getGolesDirectos(){
        return this.golesDirectos;
    }

    public int getTotalLanzamientos(){
        return this.totalLanzamientos;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setPais(String pais){
        this.pais = pais;
    }

    public void setFaltas(int faltas){
        this.faltas = faltas;
    }

    public void setGolesDirectos(int golesDirectos){
        this.golesDirectos = golesDirectos;
    }

    public void setTotalLanzamientos(int totalLanzamientos){
        this.totalLanzamientos = totalLanzamientos;
    }

    @Override
    public String toString(){
        return "Nombre: " + this.nombre + "\n" +
               "Pais: " + this.pais + "\n" +
               "Faltas: " + this.faltas + "\n" +
               "Goles directos: " + this.golesDirectos + "\n" +
               "Total lanzamientos: " + this.totalLanzamientos + "\n";
    }
    /**
     * Calcula la efectividad del jugador.
     * @return La efectividad del jugador como un porcentaje.
     */
    public float efectividad(){
        if(totalLanzamientos == 0) return 0;
        float efectividad = golesDirectos * (100/totalLanzamientos);
        return efectividad;
    }
}