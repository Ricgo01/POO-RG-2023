import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase que implementa la interfaz IReserva para manejar el proceso de reservación
 * de vuelos para la aerolínea Volaris. Gestiona usuarios y reservas a través de la
 * clase Archivo.
 */

public class Volaris implements IReserva {

    private ArrayList<Usuario> usuarios;
    private ArrayList<Reserva> reservas;
    private Archivo archivo;
    private Usuario usuarioActual;

     /**
     * Constructor de la clase Volaris. Inicializa las listas de usuarios y reservas
     * cargándolas desde el archivo correspondiente o creando listas vacías si hay un error.
     */

    public Volaris() {
        archivo = new Archivo();
        try {
            usuarios = archivo.cargarUsuarios();
            reservas = archivo.cargarReservas();
        } catch (IOException e) {
            usuarios = new ArrayList<>();
            reservas = new ArrayList<>();
        }
    }

    /**
     * Obtiene el usuario que ha iniciado sesión actualmente.
     *
     * @return El usuario actual.
     */

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    /**
     * Cierra la sesión del usuario actual.
     */

    public void logout() {
        usuarioActual = null;
    }

    /**
     * Permite a un usuario iniciar sesión si sus credenciales son correctas.
     *
     * @param username El nombre de usuario.
     * @param password La contraseña del usuario.
     * @return El objeto Usuario si el inicio de sesión es exitoso; de lo contrario, null.
     */

    public Usuario login(String username, String password) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUser().equals(username) && usuario.getPassword().equals(password)) {
                usuarioActual = usuario;
                return usuario;
            }
        }
        usuarioActual = null;
        return null;
    }

/**
     * Cambia la contraseña del usuario actual.
     *
     * @param nuevaPassword La nueva contraseña para el usuario.
     * @throws IllegalStateException Si no hay un usuario que haya iniciado sesión.
     */

    public void cambiarPassword(String nuevaPassword) {
        if (usuarioActual != null) {
            usuarioActual.setPassword(nuevaPassword);
            try {
                archivo.guardarUsuarios(usuarios); 
            } catch (FileNotFoundException e) {
            }
        } else {
            throw new IllegalStateException("No hay un usuario que haya iniciado sesión.");
        }
    }

    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param username El nombre de usuario deseado.
     * @param password La contraseña para el usuario.
     * @param tipo     El tipo de usuario.
     * @throws IllegalArgumentException Si el usuario ya existe.
     */
    
    public void registroUsuario(String username, String password, String tipo) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUser().equals(username)) {
                throw new IllegalArgumentException("El usuario ya existe.");
            }
        }
        Usuario nuevoUsuario = new Usuario(username, password, tipo);
        usuarios.add(nuevoUsuario);
        try {
            archivo.guardarUsuarios(usuarios);
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo guardar el usuario.");
        }
    }

    /**
     * Cambia el tipo de usuario del usuario actual.
     *
     * @param nuevoTipo El nuevo tipo de usuario.
     * @throws IllegalStateException Si no hay un usuario que haya iniciado sesión.
     */

    
    public void cambiarTipoUsuario(String nuevoTipo) {
    if (usuarioActual == null) {
        throw new IllegalStateException("No user is currently logged in.");
    }
    usuarioActual.setTipo(nuevoTipo);
    try {
        archivo.guardarUsuarios(usuarios);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Confirma una reservación de vuelo para el usuario actual.
     *
     * @param numeroTarjeta El número de tarjeta de crédito.
     * @param cuotas        La cantidad de cuotas para el pago.
     * @param claseVuelo    La clase de vuelo (turista, ejecutivo o primera clase).
     * @param numAsiento    El número de asiento.
     * @param cantMaletas   La cantidad de maletas.
     * @throws IllegalStateException Si no hay un usuario que haya iniciado sesión.
     * @throws IllegalArgumentException Si no hay una reservación para el usuario actual.
     */

    public void confirmacion(String numeroTarjeta, int cuotas, String claseVuelo, String numAsiento, int cantMaletas) {
        if (usuarioActual == null) {
            throw new IllegalStateException("No user is currently logged in.");
        }
        for (Reserva reserva : reservas) {
            if (reserva.getUser().equals(usuarioActual.getUser())) {
                reserva.setNumeroTarjeta(numeroTarjeta);
                reserva.setCuotas(cuotas);
                reserva.setClaseVuelo(claseVuelo);
                reserva.setNumAsiento(numAsiento);
                reserva.setCantMaletas(cantMaletas);
                return;
            }
        }
        throw new IllegalArgumentException("No se encontró una reserva para el usuario actual.");
    }

    /**
     * Obtiene el itinerario de vuelos para el usuario actual.
     *
     * @return El itinerario de vuelos.
     * @throws IllegalStateException Si no hay un usuario que haya iniciado sesión.
     */

    public String itinerario() {
        if (usuarioActual == null) {
            throw new IllegalStateException("No user is currently logged in.");
        }
        
        StringBuilder itinerario = new StringBuilder();
        for (Reserva reserva : reservas) {
            if (reserva.getUser().equals(usuarioActual.getUser())) {
                itinerario.append(reserva.toString()).append("\n");
            }
        }
        
        if (itinerario.length() == 0) {
            return "No hay vuelos reservados para el usuario: " + usuarioActual.getUser();
        }
        
        return itinerario.toString();
    }

    /**
     * Guarda la información de los usuarios en el archivo correspondiente.
     *
     * @throws Exception Si ocurre un error al guardar la información de los usuarios.
     */

    public void guardarUsuario() throws Exception {
        archivo.guardarUsuarios(usuarios);
    }

    /**
     * Lee la información de los usuarios desde el archivo correspondiente.
     *
     * @throws FileNotFoundException Si el archivo de usuarios no se encuentra.
     * @throws IOException           Si ocurre un error de entrada/salida al leer el archivo.
     */
    
   
    public void leerUsuario()  throws FileNotFoundException, IOException {
        usuarios = archivo.cargarUsuarios();
    }

    /**
     * Guarda la información de las reservas en el archivo correspondiente.
     *
     * @throws Exception Si ocurre un error al guardar la información de las reservas.
     */

    public void guardarReservacion() throws Exception {
        archivo.guardarReservas(reservas);
    }

    /**
     * Lee la información de las reservas desde el archivo correspondiente.
     *
     * @throws FileNotFoundException Si el archivo de reservas no se encuentra.
     * @throws IOException           Si ocurre un error de entrada/salida al leer el archivo.
     */
    
   
    public void leerReservacion() throws FileNotFoundException, IOException {
        reservas = archivo.cargarReservas();
    }

    /**
     * Obtiene la lista de usuarios.
     *
     * @return La lista de usuarios.
     */

    public void reservacion(String fechaVuelo, boolean tipoVuelo, int cantidadBoletos, String aerolinea, String user) {
        if (usuarioActual == null) {
            throw new IllegalStateException("No user is currently logged in.");
        }
        Reserva nuevaReserva = new Reserva(fechaVuelo, tipoVuelo, cantidadBoletos, aerolinea, usuarioActual.getUser(), "", 0, "", "", 0);
        reservas.add(nuevaReserva);
    }


} 