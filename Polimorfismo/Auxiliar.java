/**
 * Representa un jugador auxiliar en un juego.
 * Esta clase hereda de la clase Jugador y añade atributos y métodos específicos para un jugador auxiliar.
 */
public class Auxiliar extends Jugador {

    /** Número de ataques efectivos realizados por el auxiliar. */
    private int ataquesEfectivos;

    /** Número de bloqueos efectivos realizados por el auxiliar. */
    private int bloqueosEfectivos;

    /** Número de bloqueos fallidos realizados por el auxiliar. */
    private int bloqueosFallidos;

    /**
     * Constructor por defecto para inicializar un auxiliar con valores predeterminados.
     */
    public Auxiliar(){
        super("", "", 0, 0, 0);
        this.ataquesEfectivos = 0;
    }

    /**
     * Constructor para inicializar un auxiliar con valores específicos.
     *
     * @param nombre Nombre del auxiliar.
     * @param pais País de origen del auxiliar.
     * @param errores Número de errores cometidos por el auxiliar.
     * @param aces Número de aces realizados por el auxiliar.
     * @param totalServicios Número total de servicios realizados por el auxiliar.
     * @param ataquesEfectivos Número de ataques efectivos realizados por el auxiliar.
     * @param bloqueosEfectivos Número de bloqueos efectivos realizados por el auxiliar.
     * @param bloqueosFallidos Número de bloqueos fallidos realizados por el auxiliar.
     */
    public Auxiliar(String nombre, String pais, int errores, int aces, int totalServicios, int ataquesEfectivos, int bloqueosEfectivos, int bloqueosFallidos) {
        super(nombre, pais, errores, aces, totalServicios);
        this.ataquesEfectivos = ataquesEfectivos;
        this.bloqueosEfectivos = bloqueosEfectivos;
        this.bloqueosFallidos = bloqueosFallidos;
    }

    /** @return Número de ataques efectivos realizados por el auxiliar. */
    public int getAtaquesEfectivos() {
        return ataquesEfectivos;
    }

    /** @return Número de bloqueos efectivos realizados por el auxiliar. */
    public int getBloqueosEfectivos() {
        return bloqueosEfectivos;
    }

    /** @return Número de bloqueos fallidos realizados por el auxiliar. */
    public int getBloqueosFallidos() {
        return bloqueosFallidos;
    }

    /**
     * Establece el número de ataques efectivos realizados por el auxiliar.
     *
     * @param ataquesEfectivos Nuevo número de ataques efectivos.
     */
    public void setAtaquesEfectivos(int ataquesEfectivos) {
        this.ataquesEfectivos = ataquesEfectivos;
    }

    /**
     * Establece el número de bloqueos efectivos realizados por el auxiliar.
     *
     * @param bloqueosEfectivos Nuevo número de bloqueos efectivos.
     */
    public void setBloqueosEfectivos(int bloqueosEfectivos) {
        this.bloqueosEfectivos = bloqueosEfectivos;
    }

    /**
     * Establece el número de bloqueos fallidos realizados por el auxiliar.
     *
     * @param bloqueosFallidos Nuevo número de bloqueos fallidos.
     */
    public void setBloqueosFallidos(int bloqueosFallidos) {
        this.bloqueosFallidos = bloqueosFallidos;
    }

    /** 
     * @return Representación en cadena de caracteres del auxiliar.
     */
    @Override
    public String toString() {
        return "Auxiliar{" + "ataquesEfectivos=" + ataquesEfectivos + ", bloqueosEfectivos=" + bloqueosEfectivos + ", bloqueosFallidos=" + bloqueosFallidos + '}';
    }

    /**
     * Calcula y devuelve la efectividad del auxiliar basada en sus ataques, bloqueos y errores.
     *
     * @return Efectividad del auxiliar.
     */
    public float efectividadAuxiliar() {
        float efectividadAuxiliar = ((ataquesEfectivos + bloqueosEfectivos - bloqueosFallidos - errores) * 100/(ataquesEfectivos + bloqueosEfectivos + bloqueosFallidos + errores) + super.calcularEfectividad());
        return efectividadAuxiliar;
    }
}