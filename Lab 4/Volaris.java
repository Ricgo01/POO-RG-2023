import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Volaris implements IReserva {

    private ArrayList<Usuario> usuarios;
    private ArrayList<Reserva> reservas;
    private Archivo archivo;
    private Usuario usuarioActual;

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

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void logout() {
        usuarioActual = null;
    }

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

    @Override
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

    @Override
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

    public void guardarUsuario() throws Exception {
        archivo.guardarUsuarios(usuarios);
    }
    
   
    public void leerUsuario()  throws FileNotFoundException, IOException {
        usuarios = archivo.cargarUsuarios();
    }

    public void guardarReservacion() throws Exception {
        archivo.guardarReservas(reservas);
    }
    
   
    public void leerReservacion() throws FileNotFoundException, IOException {
        reservas = archivo.cargarReservas();
    }

    public void reservacion(String fechaVuelo, boolean tipoVuelo, int cantidadBoletos, String aerolinea, String user) {
        if (usuarioActual == null) {
            throw new IllegalStateException("No user is currently logged in.");
        }
        Reserva nuevaReserva = new Reserva(fechaVuelo, tipoVuelo, cantidadBoletos, aerolinea, usuarioActual.getUser(), "", 0, "", "", 0);
        reservas.add(nuevaReserva);
    }


} 