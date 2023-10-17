/**
 * Representa un jugador genérico en un juego.
 * Esta clase proporciona atributos básicos y métodos que son comunes a todos los jugadores.
 */
public class Jugador {

    /** Nombre del jugador. */
    protected String nombre;

    /** País de origen del jugador. */
    protected String pais;

    /** Número de errores cometidos por el jugador. */
    protected int errores;

    /** Número de aces realizados por el jugador. */
    protected int aces;

    /** Número total de servicios realizados por el jugador. */
    protected int totalServicios;

    /**
     * Constructor para inicializar un jugador.
     *
     * @param nombre Nombre del jugador.
     * @param pais País de origen del jugador.
     * @param errores Número de errores cometidos por el jugador.
     * @param aces Número de aces realizados por el jugador.
     * @param totalServicios Número total de servicios realizados por el jugador.
     */
    public Jugador(String nombre, String pais, int errores, int aces, int totalServicios) {
        this.nombre = nombre;
        this.pais = pais;
        this.errores = errores;
        this.aces = aces;
        this.totalServicios = totalServicios;
    }

    /** @return Nombre del jugador. */
    public String getNombre() {
        return nombre;
    }

    /** @return País de origen del jugador. */
    public String getPais() {
        return pais;
    }

    /** @return Número de errores cometidos por el jugador. */
    public int getErrores() {
        return errores;
    }

    /** @return Número de aces realizados por el jugador. */
    public int getAces() {
        return aces;
    }

    /** @return Número total de servicios realizados por el jugador. */
    public int getTotalServicios() {
        return totalServicios;
    }

    /**
     * Establece el nombre del jugador.
     *
     * @param nombre Nuevo nombre del jugador.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el país de origen del jugador.
     *
     * @param pais Nuevo país de origen.
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Establece el número de errores cometidos por el jugador.
     *
     * @param errores Nuevo número de errores.
     */
    public void setErrores(int errores) {
        this.errores = errores;
    }

    /**
     * Establece el número de aces realizados por el jugador.
     *
     * @param aces Nuevo número de aces.
     */
    public void setAces(int aces) {
        this.aces = aces;
    }

    /**
     * Establece el número total de servicios realizados por el jugador.
     *
     * @param totalServicios Nuevo número total de servicios.
     */
    public void setTotalServicios(int totalServicios) {
        this.totalServicios = totalServicios;
    }

    /** 
     * @return Representación en cadena de caracteres del jugador.
     */
    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", pais=" + pais + ", errores=" + errores + ", aces=" + aces + ", totalServicios=" + totalServicios + '}';
    }

    /**
     * Calcula y devuelve la efectividad del jugador basada en sus aces y total de servicios.
     *
     * @return Efectividad del jugador.
     */
    public float calcularEfectividad() {
        if (totalServicios == 0) {
            return 0;
        }
        float efectividad = (float) aces * 100 / totalServicios;
        return efectividad;
    }
}