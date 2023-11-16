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

    public String getFechaVuelo() {
        return fechaVuelo;
    }

    public boolean isTipoVuelo() {
        return tipoVuelo;
    }

    public int getCantBoletos() {
        return cantBoletos;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public String getUser() {
        return user;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public int getCuotas() {
        return cuotas;
    }

    public String getClaseVuelo() {
        return claseVuelo;
    }

    public String getNumAsiento() {
        return numAsiento;
    }

    public int getCantMaletas() {
        return cantMaletas;
    }

    public void setFechaVuelo(String fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public void setTipoVuelo(boolean tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    public void setCantBoletos(int cantBoletos) {
        this.cantBoletos = cantBoletos;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public void setClaseVuelo(String claseVuelo) {
        this.claseVuelo = claseVuelo;
    }

    public void setNumAsiento(String numAsiento) {
        this.numAsiento = numAsiento;
    }

    public void setCantMaletas(int cantMaletas) {
        this.cantMaletas = cantMaletas;
    }

    @Override
    public String toString() {
        return "Reserva{" + "fechaVuelo=" + fechaVuelo + ", tipoVuelo=" + tipoVuelo + ", cantBoletos=" + cantBoletos + ", aerolinea=" + aerolinea + ", user=" + user + ", numeroTarjeta=" + numeroTarjeta + ", cuotas=" + cuotas + ", claseVuelo=" + claseVuelo + ", numAsiento=" + numAsiento + ", cantMaletas=" + cantMaletas + '}';
    }
}
