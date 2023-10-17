/**
 * Representa un jugador Pasador en un juego.
 * Esta clase hereda de la clase Jugador y añade atributos y métodos específicos para un jugador Pasador.
 */
public class Pasador extends Jugador {

    /** Número de pases realizados por el Pasador. */
    private int pases;

    /** Número de fintas efectivas realizadas por el Pasador. */
    private int fintasEfectivas;

    /**
     * Constructor por defecto para inicializar un Pasador con valores predeterminados.
     */
    public Pasador() {
        super("", "", 0, 0, 0);
        this.pases = 0;
        this.fintasEfectivas = 0;
    }

    /**
     * Constructor para inicializar un Pasador con valores específicos.
     *
     * @param nombre Nombre del Pasador.
     * @param pais País de origen del Pasador.
     * @param errores Número de errores cometidos por el Pasador.
     * @param aces Número de aces realizados por el Pasador.
     * @param totalServicios Número total de servicios realizados por el Pasador.
     * @param pases Número de pases realizados por el Pasador.
     * @param fintasEfectivas Número de fintas efectivas realizadas por el Pasador.
     */
    public Pasador(String nombre, String pais, int errores, int aces, int totalServicios, int pases, int fintasEfectivas) {
        super(nombre, pais, errores, aces, totalServicios);
        this.pases = pases;
        this.fintasEfectivas = fintasEfectivas;
    }

    /** @return Número de pases realizados por el Pasador. */
    public int getPases() {
        return pases;
    }

    /** @return Número de fintas efectivas realizadas por el Pasador. */
    public int getFintasEfectivas() {
        return fintasEfectivas;
    }

    /**
     * Establece el número de pases realizados por el Pasador.
     *
     * @param pases Nuevo número de pases.
     */
    public void setPases(int pases) {
        this.pases = pases;
    }

    /**
     * Establece el número de fintas efectivas realizadas por el Pasador.
     *
     * @param fintasEfectivas Nuevo número de fintas efectivas.
     */
    public void setFintasEfectivas(int fintasEfectivas) {
        this.fintasEfectivas = fintasEfectivas;
    }

    /** 
     * @return Representación en cadena de caracteres del Pasador.
     */
    @Override
    public String toString() {
        return "Pasador{" +
               "Nombre: " + nombre +
               ", País: " + pais +
               ", Errores: " + errores +
               ", Aces: " + aces +
               ", Total Servicios: " + totalServicios +
               ", Pases: " + pases +
               ", Fintas Efectivas: " + fintasEfectivas +
               '}';
    }

    /**
     * Calcula y devuelve la efectividad del Pasador basada en sus pases, fintas y errores.
     *
     * @return Efectividad del Pasador.
     */
    public float efectividadPasador(){
        float efectividadPasador = ((pases + fintasEfectivas - errores) * 100/(pases + fintasEfectivas + errores) + super.calcularEfectividad());
        return efectividadPasador;
    }
}