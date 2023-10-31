/**
 * Representa un dispositivo genérico en el contexto de dispositivos electrónicos.
 * <p>
 * Esta clase proporciona funcionalidades básicas para interactuar con un dispositivo,
 * incluyendo la capacidad de encender, apagar, ajustar el volumen y el brillo, y controlar la reproducción de un video.
 * </p>
 */
public class Dispositivo implements Controlador {

    /** Precio del dispositivo. */
    protected int precio;

    /** Marca del dispositivo. */
    protected String marca;

    /** Modelo del dispositivo. */
    protected int modelo;

    /** Número de cuotas disponibles para pago con Visa. */
    protected int visaCuotas;

    /** Cantidad de memoria RAM en GB. */
    protected int ram;

    /** Tipo de dispositivo. */
    protected String tipo;

    /**
     * Constructor de la clase Dispositivo.
     * 
     * @param precio      Precio del dispositivo.
     * @param marca       Marca del dispositivo.
     * @param modelo      Modelo del dispositivo.
     * @param visaCuotas  Número de cuotas disponibles para pago con Visa.
     * @param ram         Cantidad de memoria RAM en GB.
     * @param tipo        Tipo de dispositivo.
     */
    public Dispositivo(int precio, String marca, int modelo, int visaCuotas, int ram, String tipo) {
        this.precio = precio;
        this.marca = marca;
        this.modelo = modelo;
        this.visaCuotas = visaCuotas;
        this.ram = ram;
        this.tipo = tipo;
    }

    /** @return Precio del dispositivo. */
    public int getPrecio() {
        return precio;
    }

    /** @return Marca del dispositivo. */
    public String getMarca() {
        return marca;
    }

    /** @return Modelo del dispositivo. */
    public int getModelo() {
        return modelo;
    }

    /** @return Número de cuotas disponibles para pago con Visa. */
    public int getVisaCuotas() {
        return visaCuotas;
    }

    /** @return Cantidad de memoria RAM en GB. */
    public int getRam() {
        return ram;
    }

    /** @param precio Nuevo precio del dispositivo. */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /** @param marca Nueva marca del dispositivo. */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /** @param modelo Nuevo modelo del dispositivo. */
    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    /** @param visaCuotas Nuevo número de cuotas disponibles para pago con Visa. */
    public void setVisaCuotas(int visaCuotas) {
        this.visaCuotas = visaCuotas;
    }

    /** @param ram Nueva cantidad de memoria RAM en GB. */
    public void setRam(int ram) {
        this.ram = ram;
    }

    /** @return Tipo de dispositivo. */
    public String getTipo() {
        return tipo;
    }

    /** @param tipo Nuevo tipo de dispositivo. */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Representación textual del dispositivo.
     * 
     * @return Una cadena que representa los atributos y características del dispositivo.
     */
    @Override
    public String toString(){
        return "Dispotivo: "
        + "[Precio: " + precio
        + "Marca: " + marca
        + "Modelo: " + modelo
        + "Visa Cuotas: " + visaCuotas
        + "Ram: " + ram 
        + "Tipo: " + tipo + "]";
    }

     /**
     * Enciende el dispositivo.
     * 
     * @return Verdadero si el dispositivo se enciende, falso en caso contrario.
     */

    public boolean encender() {
        return true;
    }

    /**
     * Apaga el dispositivo.
     * 
     * @return Verdadero si el dispositivo se apaga, falso en caso contrario.
     */

    public boolean apagar() {
        return false;
    }

    /**
     * Ajusta el volumen del dispositivo.
     * 
     * @param volumen El nuevo volumen del dispositivo.
     * @return El volumen del dispositivo.
     */

    public int volumenDown(){
        return 0;
    }

    /**
     * Ajusta el volumen del dispositivo. 
     * @return El volumen del dispositivo.
     */

    public int volumenUp(){
        return 0;
    }

    /**
     * Ajusta el brillo del dispositivo.
     * 
     * @param brillo El nuevo brillo del dispositivo.
     * @return El brillo del dispositivo.
     */

    public int brilloDown(){
        return 0;
    }

    /**
     * Ajusta el brillo del dispositivo.
     * 
     * @return El brillo del dispositivo.
     */

    public int brilloUp(){
        return 0;
    }

    /**
     * Reproduce un video en el dispositivo.
     * 
     * @return Verdadero si el video se reproduce, falso en caso contrario.
     */

    public boolean play(){
        return true;
    }

    /**
     * Pausa la reproducción del video en el dispositivo.
     * 
     * @return Verdadero si el video se pausa, falso en caso contrario.
     */

    public boolean pause(){
        return false;
    }

    /**
     * Detiene la reproducción del video en el dispositivo.
     * 
     * @return Verdadero si el video se detiene, falso en caso contrario.
     */

    public boolean stop(){
        return false;
    }

    /**
     * Reproduce el siguiente video en el dispositivo.
     * 
     * @return Verdadero si el video se reproduce, falso en caso contrario.
     */

    public boolean siguiente(){
        return true;
    }

    /**
     * Muestra la información del dispositivo.
     */

    public void mostrarInfo() {

    }

    /**
     * Muestra el estado del dispositivo.
     */

    public void mostrarEstado() {

    }

}
