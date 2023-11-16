/**
 * Clase que representa una reserva de vuelo para un usuario.
 * Contiene detalles como la fecha del vuelo, tipo de vuelo, cantidad de boletos, aerolínea,
 * información del usuario, detalles de pago y preferencias de asiento y equipaje.
 */

public class Reserva {
    private String fechaVuelo;
    private boolean tipoVuelo;
    private int cantBoletos;
    private String aerolinea;
    private String user;
    private String numeroTarjeta;
    private int cuotas;
    private String claseVuelo;
    private String numAsiento;
    private int cantMaletas;
/**
     * Constructor que inicializa una nueva reserva con todos los detalles requeridos.
     *
     * @param fechaVuelo     La fecha del vuelo.
     * @param tipoVuelo      El tipo de vuelo (true para ida y vuelta, false para solo ida).
     * @param cantBoletos    La cantidad de boletos.
     * @param aerolinea      La aerolínea con la que se vuela.
     * @param user           El nombre de usuario que realiza la reserva.
     * @param numeroTarjeta  El número de tarjeta para el pago.
     * @param cuotas         El número de cuotas para el pago.
     * @param claseVuelo     La clase del vuelo (económica, negocios, primera clase, etc.).
     * @param numAsiento     El número de asiento deseado.
     * @param cantMaletas    La cantidad de maletas.
     */
    public Reserva (String fechaVuelo, boolean tipoVuelo, int cantBoletos, String aerolinea, String user, String numeroTarjeta, int cuotas, String claseVuelo, String numAsiento, int cantMaletas) {
        this.fechaVuelo = fechaVuelo;
        this.tipoVuelo = tipoVuelo;
        this.cantBoletos = cantBoletos;
        this.aerolinea = aerolinea;
        this.user = user;
        this.numeroTarjeta = numeroTarjeta;
        this.cuotas = cuotas;
        this.claseVuelo = claseVuelo;
        this.numAsiento = numAsiento;
        this.cantMaletas = cantMaletas;
    }

    /**
     * Obtiene la fecha del vuelo reservado.
     *
     * @return La fecha del vuelo.
     */

    public String getFechaVuelo() {
        return fechaVuelo;
    }

    /**
     * Obtiene el tipo de vuelo reservado.
     *
     * @return El tipo de vuelo.
     */

    public boolean isTipoVuelo() {
        return tipoVuelo;
    }

    /**
     * Obtiene la cantidad de boletos reservados.
     *
     * @return La cantidad de boletos.
     */

    public int getCantBoletos() {
        return cantBoletos;
    }

    /**
     * Obtiene la aerolínea con la que se vuela.
     *
     * @return La aerolínea.
     */

    public String getAerolinea() {
        return aerolinea;
    }

    /**
     * Obtiene el nombre de usuario que realiza la reserva.
     *
     * @return El nombre de usuario.
     */

    public String getUser() {
        return user;
    }

    /**
     * Obtiene el número de tarjeta para el pago.
     *
     * @return El número de tarjeta.
     */

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * Obtiene el número de cuotas para el pago.
     *
     * @return El número de cuotas.
     */

    public int getCuotas() {
        return cuotas;
    }

    /**
     * Obtiene la clase del vuelo.
     *
     * @return La clase del vuelo.
     */

    public String getClaseVuelo() {
        return claseVuelo;
    }

    /**
     * Obtiene el número de asiento deseado.
     *
     * @return El número de asiento.
     */

    public String getNumAsiento() {
        return numAsiento;
    }

    /**
     * Obtiene la cantidad de maletas.
     *
     * @return La cantidad de maletas.
     */

    public int getCantMaletas() {
        return cantMaletas;
    }

    /**
     * Establece una nueva fecha de vuelo.
     *
     * @param fechaVuelo La nueva fecha de vuelo.
     */

    public void setFechaVuelo(String fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    /**
     * Establece un nuevo tipo de vuelo.
     *
     * @param tipoVuelo El nuevo tipo de vuelo.
     */

    public void setTipoVuelo(boolean tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    /**
     * Establece una nueva cantidad de boletos.
     *
     * @param cantBoletos La nueva cantidad de boletos.
     */

    public void setCantBoletos(int cantBoletos) {
        this.cantBoletos = cantBoletos;
    }

    /**
     * Establece una nueva aerolínea.
     *
     * @param aerolinea La nueva aerolínea.
     */

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    /**
     * Establece un nuevo nombre de usuario.
     *
     * @param user El nuevo nombre de usuario.
     */

    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Establece un nuevo número de tarjeta.
     *
     * @param numeroTarjeta El nuevo número de tarjeta.
     */

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * Establece un nuevo número de cuotas.
     *
     * @param cuotas El nuevo número de cuotas.
     */

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    /**
     * Establece una nueva clase de vuelo.
     *
     * @param claseVuelo La nueva clase de vuelo.
     */

    public void setClaseVuelo(String claseVuelo) {
        this.claseVuelo = claseVuelo;
    }

    /**
     * Establece un nuevo número de asiento.
     *
     * @param numAsiento El nuevo número de asiento.
     */

    public void setNumAsiento(String numAsiento) {
        this.numAsiento = numAsiento;
    }

    /**
     * Establece una nueva cantidad de maletas.
     *
     * @param cantMaletas La nueva cantidad de maletas.
     */

    public void setCantMaletas(int cantMaletas) {
        this.cantMaletas = cantMaletas;
    }


    /**
     * Devuelve una representación en cadena de la reserva con todos sus detalles.
     *
     * @return Una cadena de texto que representa los detalles de la reserva.
     */
    @Override
    public String toString() {
        return "Reserva{" + "fechaVuelo=" + fechaVuelo + ", tipoVuelo=" + tipoVuelo + ", cantBoletos=" + cantBoletos + ", aerolinea=" + aerolinea + ", user=" + user + ", numeroTarjeta=" + numeroTarjeta + ", cuotas=" + cuotas + ", claseVuelo=" + claseVuelo + ", numAsiento=" + numAsiento + ", cantMaletas=" + cantMaletas + '}';
    }
}
