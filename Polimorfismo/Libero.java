/**
 * Representa un jugador Libero en un juego.
 * Esta clase hereda de la clase Jugador y añade atributos y métodos específicos para un jugador Libero.
 */
public class Libero extends Jugador{

    /** Número de recibos efectivos realizados por el Libero. */
    private int recibosEfectivos;

    /**
     * Constructor por defecto para inicializar un Libero con valores predeterminados.
     */
    public Libero(){
        super("", "", 0, 0, 0);
        this.recibosEfectivos = 0;
    }

    /**
     * Constructor para inicializar un Libero con valores específicos.
     *
     * @param nombre Nombre del Libero.
     * @param pais País de origen del Libero.
     * @param errores Número de errores cometidos por el Libero.
     * @param aces Número de aces realizados por el Libero.
     * @param totalServicios Número total de servicios realizados por el Libero.
     * @param recibosEfectivos Número de recibos efectivos realizados por el Libero.
     */
    public Libero(String nombre, String pais, int errores, int aces, int totalServicios, int recibosEfectivos) {
        super(nombre, pais, errores, aces, totalServicios);
        this.recibosEfectivos = recibosEfectivos;
    }

    /** @return Número de recibos efectivos realizados por el Libero. */
    public int getRecibosEfectivos() {
        return recibosEfectivos;
    }

    /**
     * Establece el número de recibos efectivos realizados por el Libero.
     *
     * @param recibosEfectivos Nuevo número de recibos efectivos.
     */
    public void setRecibosEfectivos(int recibosEfectivos) {
        this.recibosEfectivos = recibosEfectivos;
    }

    /** 
     * @return Representación en cadena de caracteres del Libero.
     */
    @Override
    public String toString() {
        return "Libero{" +
               "Nombre: " + nombre + 
               ", País: " + pais + 
               ", Errores: " + errores + 
               ", Aces: " + aces + 
               ", Total Servicios: " + totalServicios + 
               ", Recibos Efectivos: " + recibosEfectivos + 
               '}';
    }

    /**
     * Calcula y devuelve la efectividad del Libero basada en sus recibos y errores.
     *
     * @return Efectividad del Libero.
     */
    public float efectividadLibero(){
        if (recibosEfectivos + errores == 0) {
            return super.calcularEfectividad();
        }
        float efectividadLibero = ((recibosEfectivos - errores) * 100/(recibosEfectivos + errores) + super.calcularEfectividad());
        return efectividadLibero;
    } 
}
