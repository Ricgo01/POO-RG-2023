import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Esta interfaz define las operaciones relacionadas con la gestión de reservas y usuarios.
 * Incluye métodos para el inicio de sesión, registro, cambios en la cuenta de usuario,
 * realización y confirmación de reservaciones, así como la persistencia y recuperación
 * de datos de reservaciones y usuarios.
 */

public interface IReserva {


    /**
     * Método para iniciar sesión de un usuario.
     *
     * @param username El nombre de usuario.
     * @param password La contraseña del usuario.
     * @return Usuario Retorna un objeto Usuario si las credenciales son correctas.
     */
    Usuario login(String username, String password);

    /**
     * Método para registrar un nuevo usuario.
     *
     * @param username El nombre de usuario deseado.
     * @param password La contraseña para el usuario.
     * @param tipo     El tipo de usuario.
     */

    void registroUsuario(String username, String password, String tipo);

    /**
     * Método para cambiar la contraseña de un usuario.
     *
     * @param nuevaPassword La nueva contraseña para el usuario.
     */
    void cambiarPassword(String nuevaPassword);

    /**
     * Método para cambiar el tipo de un usuario.
     *
     * @param tipo El nuevo tipo de usuario.
     */

    void cambiarTipoUsuario(String tipo);

    /**
     * Método para crear una reservación de vuelo.
     *
     * @param fechaVuelo      La fecha del vuelo.
     * @param tipoVuelo       El tipo de vuelo (ida y vuelta o solo ida).
     * @param cantidadBoletos La cantidad de boletos a reservar.
     * @param aerolinea       La aerolínea con la que se desea volar.
     * @param user            El usuario que realiza la reserva.
     */

    void reservacion(String fechaVuelo, boolean tipoVuelo, int cantidadBoletos, String aerolinea, String user);

     /**
     * Método para confirmar una reservación de vuelo.
     *
     * @param numeroTarjeta El número de la tarjeta de crédito/débito para el pago.
     * @param cuotas        El número de cuotas para el pago.
     * @param claseVuelo    La clase de vuelo deseada.
     * @param numAsiento    El número de asiento deseado.
     * @param cantMaletas   La cantidad de maletas a registrar.
     */
    
    void confirmacion(String numeroTarjeta, int cuotas, String claseVuelo, String numAsiento, int cantMaletas);

/**
     * Método para obtener el itinerario de la reservación.
     *
     * @return String Retorna una cadena con los detalles del itinerario de la reservación.
     */

    String itinerario();

/**
     * Método para guardar la información de la reservación.
     *
     * @throws Exception Si ocurre un error al guardar la reservación.
     */

    void guardarReservacion() throws Exception;

/**
     * Método para leer la información de una reservación.
     *
     * @throws FileNotFoundException Si el archivo de reservación no se encuentra.
     * @throws IOException           Si ocurre un error de entrada/salida al leer el archivo.
     */

    void leerReservacion() throws FileNotFoundException, IOException;
    
    /**
     * Método para guardar la información de un usuario.
     *
     * @throws Exception Si ocurre un error al guardar la información del usuario.
     */

    void guardarUsuario() throws Exception;

    /**
     * Método para leer la información de un usuario.
     *
     * @throws FileNotFoundException Si el archivo de usuario no se encuentra.
     * @throws IOException           Si ocurre un error de entrada/salida al leer el archivo.
     */

    void leerUsuario()  throws FileNotFoundException, IOException;

}