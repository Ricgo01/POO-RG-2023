/**
 * Interfaz Controlador que define las acciones básicas que deben ser implementadas
 * por los dispositivos electrónicos controlables.
 */
public interface Controlador {

    /**
     * Enciende el dispositivo.
     * 
     * @return Verdadero si el dispositivo se enciende correctamente, falso en caso contrario.
     */
    boolean encender();

    /**
     * Apaga el dispositivo.
     * 
     * @return Verdadero si el dispositivo se apaga correctamente, falso en caso contrario.
     */
    boolean apagar();

    /**
     * Aumenta el volumen del dispositivo.
     * 
     * @return El nuevo nivel de volumen después del aumento.
     */
    int volumenUp();

    /**
     * Reduce el volumen del dispositivo.
     * 
     * @return El nuevo nivel de volumen después de la reducción.
     */
    int volumenDown();

    /**
     * Aumenta el brillo del dispositivo.
     * 
     * @return El nuevo nivel de brillo después del aumento.
     */
    int brilloUp();

    /**
     * Reduce el brillo del dispositivo.
     * 
     * @return El nuevo nivel de brillo después de la reducción.
     */
    int brilloDown();

    /**
     * Muestra la información detallada del dispositivo.
     */
    void mostrarInfo();

    /**
     * Muestra el estado actual del dispositivo, incluyendo si está encendido o apagado y otros detalles relevantes.
     */
    void mostrarEstado();

    /**
     * Inicia la reproducción de un video o pista en el dispositivo.
     * 
     * @return Verdadero si el video o pista comienza a reproducirse, falso en caso contrario.
     */
    boolean play();

    /**
     * Pausa la reproducción de un video o pista en el dispositivo.
     * 
     * @return Verdadero si el video o pista se pausa correctamente, falso en caso contrario.
     */
    boolean pause();

    /**
     * Detiene la reproducción de un video o pista en el dispositivo.
     * 
     * @return Verdadero si el video o pista se detiene correctamente, falso en caso contrario.
     */
    boolean stop();

    /**
     * Avanza a la siguiente pista o video en el dispositivo.
     * 
     * @return Verdadero si avanza al siguiente video o pista, falso en caso contrario.
     */
    boolean siguiente();
}