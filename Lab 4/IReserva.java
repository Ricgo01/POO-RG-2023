import java.io.FileNotFoundException;
import java.io.IOException;

public interface IReserva {

    Usuario login(String username, String password);

    void registroUsuario(String username, String password, String tipo);

    void cambiarPassword(String nuevaPassword);

    void cambiarTipoUsuario(String tipo);

    void reservacion(String fechaVuelo, boolean tipoVuelo, int cantidadBoletos, String aerolinea, String user);

    void confirmacion(String numeroTarjeta, int cuotas, String claseVuelo, String numAsiento, int cantMaletas);

    String itinerario();

    void guardarReservacion() throws Exception;

    void leerReservacion() throws FileNotFoundException, IOException;

    void guardarUsuario() throws Exception;

    void leerUsuario()  throws FileNotFoundException, IOException;

}