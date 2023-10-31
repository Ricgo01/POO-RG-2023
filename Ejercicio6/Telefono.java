/**
 * La clase Telefono representa un telefono personal en el contexto de dispositivos electrónicos.
 * Esta clase hereda de la clase Dispositivo y proporciona funcionalidades para controlar
 * y obtener información sobre el Telefono.
 */

public class Telefono extends Dispositivo {

    private String procesador;
    private int almacenamientoInterno;
    private boolean extendible;
    private boolean incluyeCargador;
    private boolean CincoG;

    boolean on = false;
    int volumen = 0;
    int brillo = 0;
    boolean play = false;
    int video = 0;

    /**
     * Constructor de la clase Telefono.
     * 
     * @param precio             Precio del dispositivo.
     * @param marca              Marca del dispositivo.
     * @param modelo             Modelo del dispositivo.
     * @param visaCuotas         Número de cuotas para pago con Visa.
     * @param ram                Cantidad de memoria RAM.
     * @param tipo               Tipo de dispositivo.
     * @param procesador         Procesador del telefono.
     * @param almacenamientoInterno  Almacenamiento interno del telefono.
     * @param extendible         Si el telefono tiene almacenamiento extendible.
     * @param incluyeCargador    Si el telefono incluye cargador.
     * @param CincoG             Si el telefono tiene 5G.
     */

    public Telefono(int precio, String marca, int modelo, int visaCuotas, int ram, String tipo, String procesador, int almacenamientoInterno, boolean extendible, boolean incluyeCargador, boolean CincoG) {
        super(precio, marca, modelo, visaCuotas, ram, tipo);
        this.procesador = procesador;
        this.almacenamientoInterno = almacenamientoInterno;
        this.extendible = extendible;
        this.incluyeCargador = incluyeCargador;
        this.CincoG = CincoG;
    }

    /**
     * Retorna el procesador del telefono.
     * @return
     */

    public String getProcesador() {
        return procesador;
    }

    /**
     * Retorna el almacenamiento interno del telefono.
     * @return
     */

    public int getAlmacenamientoInterno() {
        return almacenamientoInterno;
    }

    /**
     * Retorna si el telefono tiene almacenamiento extendible.
     * @return
     */

    public boolean isExtendible() {
        return extendible;
    }

    /**
     * Retorna si el telefono incluye cargador.
     * @return
     */

    public boolean isIncluyeCargador() {
        return incluyeCargador;
    }

    /**
     * Retorna si el telefono tiene 5G.
     * @return
     */

    public boolean isCincoG() {
        return CincoG;
    }

    /**
     * Establece el procesador del telefono.
     * @param procesador
     */

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    /**
     * Establece el almacenamiento interno del telefono.
     * @param almacenamientoInterno
     */

    public void setAlmacenamientoInterno(int almacenamientoInterno) {
        this.almacenamientoInterno = almacenamientoInterno;
    }

    /**
     * Establece si el telefono tiene almacenamiento extendible.
     * @param extendible
     */

    public void setExtendible(boolean extendible) {
        this.extendible = extendible;
    }

    /**
     * Establece si el telefono incluye cargador.
     * @param incluyeCargador
     */

    public void setIncluyeCargador(boolean incluyeCargador) {
        this.incluyeCargador = incluyeCargador;
    }

    /**
     * Establece si el telefono tiene 5G.
     * @param CincoG
     */

    public void setCincoG(boolean CincoG) {
        this.CincoG = CincoG;
    }

    /**
     * Retorna una cadena de caracteres con la información del telefono.
     * @return
     */

    @Override
    public String toString() {
        return "Telefono: "
                + "[Procesador: " + procesador
                + "AlmacenamientoInterno: " + almacenamientoInterno
                + "Extendible: " + extendible
                + "IncluyeCargador: " + incluyeCargador
                + "CincoG: " + CincoG
                + "]";
    }

    /**
     * Enciende el telefono.
     * @return true si el telefono se encendio, false si el telefono ya estaba encendido.
     */

    public boolean encender() {
        if (!on) {
            on = true;
            System.out.println("El telefono se ha encendido");
            return true;
        } else {
            System.out.println("El telefono ya esta encendido");
            return false;
        }
    }

    /**
     * Apaga el telefono.
     * @return true si el telefono se apago, false si el telefono ya estaba apagado.
     */

    public boolean apagar() {
        if (on) {
            on = false;
            System.out.println("El telefono se ha apagado");
            return true;
        } else {
            System.out.println("El telefono ya esta apagado");
            return false;
        }
    }

    /**
     * Sube el volumen del telefono.
     * @return el volumen del telefono.
     */

    public int volumenDown(){
        if (on){
            if (volumen < 0){
                volumen = volumen - 2;
                System.out.println("El volumen se ha bajado a " + volumen);
            } else {
                System.out.println("El volumen ya estaba en 0");
            }
        } else {
            System.out.println("La PC esta apagada");
        }
        return volumen;
    }

    /**
     * Sube el volumen del telefono.
     * @return el volumen del telefono.
     */

    public int volumenUp(){
        if (on){
            if (volumen > 100){
                volumen = volumen + 2;
                System.out.println("El volumen se ha subido a " + volumen);
            } else {
                System.out.println("El volumen ya estaba en 100");
            }
        }
        return volumen;
    }

    /**
     * Baja el brillo del telefono.
     * @return el brillo del telefono.
     */

    public int brilloDown(){
        if (on){
            if (brillo < 0){
                brillo = brillo - 3;
                System.out.println("El brillo se ha bajado a " + brillo);
            } else {
                System.out.println("El brillo ya estaba en 0");
            }
        } else {
            System.out.println("La PC esta apagada");
        }
        return brillo;
    }

    /**
     * Sube el brillo del telefono.
     * @return el brillo del telefono.
     */

    public int brilloUp(){
        if (on){
            if (brillo > 100){
                brillo = brillo + 3;
                System.out.println("El brillo se ha subido a " + brillo);
            } else {
                System.out.println("El brillo ya estaba en 100");
            }
        }
        return brillo;
    }

    /**
     * Inicia la reproduccion del video.
     * @return true si el video se inicio, false si el video ya estaba en reproduccion.
     */

    public boolean play(){
        if (on){
            if (!play){
                play = true;
                System.out.println("El video se ha iniciado");
            } else {
                System.out.println("El video ya estaba en reproduccion");
            }
        } else {
            System.out.println("La PC esta apagada");
        }
        return play;
    }

    /**
     * Pausa la reproduccion del video.
     * @return true si el video se pauso, false si el video ya estaba pausado.
     */

    public boolean pause(){
        if (on){
            if (play){
                play = false;
                System.out.println("El video se ha pausado");
            } else {
                System.out.println("El video ya estaba pausado");
            }
        } else {
            System.out.println("La PC esta apagada");
        }
        return play;
    }

    /**
     * Detiene la reproduccion del video.
     * @return true si el video se detuvo, false si el video ya estaba detenido.
     */

    public boolean stop(){
        if (on){
            if (play){
                play = false;
                System.out.println("El video se ha detenido");
            } else {
                System.out.println("El video ya estaba detenido");
            }
        } else {
            System.out.println("La PC esta apagada");
        }
        return play;
    }

    /**
     * Cambia el video al siguiente.
     * @return true si el video se cambio, false si el video ya estaba en el ultimo video.
     */

    public boolean siguiente(){
        if (on){
            if (play){
                video = video + 1;
                System.out.println("El video se ha cambiado al siguiente");
            } else {
                System.out.println("El video no esta en reproduccion");
            }
        } else {
            System.out.println("La PC esta apagada");
        }
        return play;
    }

    /**
     * Muestra la informacion del telefono.
     */

    public void mostrarInfo() {
        System.out.println("Telefono: "
                + "[Procesador: " + procesador
                + ",AlmacenamientoInterno: " + almacenamientoInterno
                + ",Extendible: " + extendible
                + ",IncluyeCargador: " + incluyeCargador
                + ",CincoG: " + CincoG
                + "]");
    }

    /**
     * Muestra el estado del telefono.
     */

    public void mostrarEstado() {
        System.out.println(" Estado del Telefono: "
                + "[Encendida: " + on
                + ",Volumen: " + volumen
                + ",Brillo: " + brillo
                + ",Video: " + video
                + ",Estado del video: " + play
                + "]");
    }

    
}
