/**
 * La clase PC representa una computadora personal en el contexto de dispositivos electrónicos.
 * Esta clase hereda de la clase Dispositivo y proporciona funcionalidades para controlar
 * y obtener información sobre la PC.
 */

public class PC extends Dispositivo {

    private int tamanioMemoria;
    private String tipoMemoria;
    private int velocidadCPU;
    private int velocidadGPU;

    boolean on = false;
    int volumen = 0;
    int brillo = 0;
    boolean play = false;
    int video = 0;

    /**
     * Constructor de la clase PC.
     * 
     * @param precio             Precio del dispositivo.
     * @param marca              Marca del dispositivo.
     * @param modelo             Modelo del dispositivo.
     * @param visaCuotas         Número de cuotas para pago con Visa.
     * @param ram                Cantidad de memoria RAM.
     * @param tipo               Tipo de dispositivo.
     * @param tamanioMemoria     Tamaño de la memoria de almacenamiento.
     * @param tipoMemoria        Tipo de memoria de almacenamiento (Ejemplo: SSD, HDD).
     * @param velocidadCPU       Velocidad del CPU.
     * @param velocidadGPU       Velocidad del GPU.
     */

    public PC (int precio, String marca, int modelo, int visaCuotas, int ram, String tipo, int tamanioMemoria, String tipoMemoria, int velocidadCPU, int velocidadGPU) {
        super(precio, marca, modelo, visaCuotas, ram, tipo);
        this.tamanioMemoria = tamanioMemoria;
        this.tipoMemoria = tipoMemoria;
        this.velocidadCPU = velocidadCPU;
        this.velocidadGPU = velocidadGPU;
    }

    // Métodos getters y setters para las propiedades de la clase.

    /**
     * Retorna el tamaño de la memoria de almacenamiento.
     * 
     * @return Tamaño de la memoria.
     */

    public int getTamanioMemoria() {
        return tamanioMemoria;
    }

    
    /**
     * Retorna el tipo de memoria de almacenamiento.
     * 
     * @return Tipo de memoria (Ejemplo: SSD, HDD).
     */

    public String getTipoMemoria() {
        return tipoMemoria;
    }

    /**
     * Retorna la velocidad del CPU.
     * 
     * @return Velocidad del CPU.
     */

    public int getVelocidadCPU() {
        return velocidadCPU;
    }

    /**
     * Retorna la velocidad del GPU.
     * 
     * @return Velocidad del GPU.
     */

    public int getVelocidadGPU() {
        return velocidadGPU;
    }

    /**
     * Establece el tamaño de la memoria de almacenamiento.
     * 
     * @param tamanioMemoria Tamaño de la memoria.
     */

    public void setTamanioMemoria(int tamanioMemoria) {
        this.tamanioMemoria = tamanioMemoria;
    }

    /**
     * Establece el tipo de memoria de almacenamiento.
     * 
     * @param tipoMemoria Tipo de memoria (Ejemplo: SSD, HDD).
     */

    public void setTipoMemoria(String tipoMemoria) {
        this.tipoMemoria = tipoMemoria;
    }

    public void setVelocidadCPU(int velocidadCPU) {
        this.velocidadCPU = velocidadCPU;
    }

    /**
     * Establece la velocidad del GPU.
     * 
     * @param velocidadGPU Velocidad del GPU.
     */

    public void setVelocidadGPU(int velocidadGPU) {
        this.velocidadGPU = velocidadGPU;
    }

    /**
     * Retorna la información de la PC.
     * 
     * @return Información de la PC.
     */

    @Override
    public String toString(){
        return "PC: "
        + "[Precio: " + precio
        + "Marca: " + marca
        + "Modelo: " + modelo
        + "VisaCuotas: " + visaCuotas
        + "RAM: " + ram
        + "TamanioMemoria: " + tamanioMemoria
        + "TipoMemoria: " + tipoMemoria
        + "VelocidadCPU: " + velocidadCPU
        + "VelocidadGPU: " + velocidadGPU
        + "]";
    }

    /**
     * Apaga la PC.
     * 
     * @return Verdadero si la PC se apagó con éxito, falso si ya estaba apagada.
     */

    public boolean encender(){
        if (!on){
            on = true;
            System.out.println("La PC se ha encendido");
        } else {
            System.out.println("La PC ya estaba encendida");
        }
        return on;
    }

    /**
     * Apaga la PC.
     * 
     * @return Verdadero si la PC se apagó con éxito, falso si ya estaba apagada.
     */

    public boolean apagar(){
        if (on){
            on = false;
            System.out.println("La PC se ha apagado");
        } else {
            System.out.println("La PC ya estaba apagada");
        }
        return on;
    }

    /**
     * Baja el volumen de la PC.
     * 
     * @return Volumen actual de la PC.
     */

    public int volumenDown(){
        if (on){
            if (volumen < 0){
                volumen = volumen - 10;
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
     * Sube el volumen de la PC.
     * 
     * @return Volumen actual de la PC.
     */

    public int volumenUp(){
        if (on){
            if (volumen > 100){
                volumen = volumen + 10;
                System.out.println("El volumen se ha subido a " + volumen);
            } else {
                System.out.println("El volumen ya estaba en 100");
            }
        }
        return volumen;
    }

    /**
     * Baja el brillo de la PC.
     * 
     * @return Brillo actual de la PC.
     */

    public int brilloDown(){
        if (on){
            if (brillo < 0){
                brillo = brillo - 5;
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
     * Sube el brillo de la PC.
     * 
     * @return Brillo actual de la PC.
     */

    public int brilloUp(){
        if (on){
            if (brillo > 100){
                brillo = brillo + 5;
                System.out.println("El brillo se ha subido a " + brillo);
            } else {
                System.out.println("El brillo ya estaba en 100");
            }
        }
        return brillo;
    }

    /**
     * Muestra la información de la PC.
     */

    public void mostrarInfo(){
        System.out.println("PC: "
        + "[Precio: " + precio
        + ",Marca: " + marca
        + ",Modelo: " + modelo
        + ",VisaCuotas: " + visaCuotas
        + ",RAM: " + ram
        + ",TamanioMemoria: " + tamanioMemoria
        + ",TipoMemoria: " + tipoMemoria
        + ",VelocidadCPU: " + velocidadCPU
        + ",VelocidadGPU: " + velocidadGPU
        + "]");
    }

    /**
     * Muestra el estado de la PC.
     */

    public void mostrarEstado(){
        System.out.println("Estado de la PC: "
        + "[Encendida: " + on
        + ",Volumen: " + volumen
        + ",Brillo: " + brillo
        + ",Video: " + video
        + ",Estado del video: " + play
        + "]");
    }

    /**
     * Reproduce un video en la PC.
     * 
     * @return Verdadero si el video se reprodujo con éxito, falso si ya estaba reproduciéndose.
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
     * Pausa un video en la PC.
     * 
     * @return Verdadero si el video se pausó con éxito, falso si ya estaba pausado.
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
     * Detiene un video en la PC.
     * 
     * @return Verdadero si el video se detuvo con éxito, falso si ya estaba detenido.
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
     * Cambia al siguiente video en la PC.
     * 
     * @return Verdadero si el video se cambió con éxito, falso si ya estaba reproduciéndose.
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
}
