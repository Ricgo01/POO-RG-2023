import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que representa una tienda de dispositivos electrónicos.
 * Permite cargar, mostrar y gestionar diferentes dispositivos.
 */
public class Tienda {

    /** El dispositivo seleccionado por el usuario para realizar acciones. */
    private Dispositivo seleccionarDispositivo;

    /** Objeto Scanner para obtener la entrada del usuario. */
    Scanner sc = new Scanner(System.in);

    /** Lista de dispositivos electrónicos disponibles en la tienda. */
    private List<Dispositivo> electronicos;

    /**
     * Constructor que inicializa una lista vacía de dispositivos electrónicos.
     */
    public Tienda() {
        this.electronicos = new ArrayList<>();
    }

    /**
     * Carga una lista de dispositivos desde un archivo especificado por su ruta.
     *
     * @param rutaArchivo La ruta del archivo donde se encuentran los dispositivos a cargar.
     */
    public void cargarDispositivos(String rutaArchivo) {
        this.electronicos = Archivo.cargarDispositivos(rutaArchivo);
    }

    /**
     * Obtiene la lista de dispositivos electrónicos de la tienda.
     *
     * @return Lista de dispositivos electrónicos.
     */
    public List<Dispositivo> getElectronicos() {
        return electronicos;
    }

    /**
     * Muestra en consola todos los dispositivos disponibles en la tienda.
     */
    public void mostrarDispositivos() {
        for (Dispositivo dispositivo : electronicos) {
            System.out.println(dispositivo.toString());
        }
    }

    /**
     * Encuentra y retorna el dispositivo PC con el precio más alto.
     *
     * @return Dispositivo PC con el precio más alto, o null si no se encuentra.
     */
    public Dispositivo PcMasCara() {
        Dispositivo maxPC = null;
        for (Dispositivo dispositivo : electronicos) {
            if (dispositivo.getTipo().equals("PC")) {
                if (maxPC == null || dispositivo.getPrecio() > maxPC.getPrecio()) {
                    maxPC = dispositivo;
                }
            }
        }
        return maxPC;
    }

    /**
     * Encuentra y retorna el dispositivo Teléfono con el precio más alto.
     *
     * @return Dispositivo Teléfono con el precio más alto, o null si no se encuentra.
     */
    public Dispositivo TelefonoMasCaro() {
        Dispositivo maxTelefono = null;
        for (Dispositivo dispositivo : electronicos) {
            if (dispositivo.getTipo().equals("Telefono")) {
                if (maxTelefono == null || dispositivo.getPrecio() > maxTelefono.getPrecio()) {
                    maxTelefono = dispositivo;
                }
            }
        }
        return maxTelefono;
    }

    /**
     * Establece el dispositivo seleccionado según la marca y modelo proporcionados.
     * Si el dispositivo no se encuentra, muestra un mensaje en consola.
     *
     * @param marca Marca del dispositivo a seleccionar.
     * @param modelo Modelo del dispositivo a seleccionar.
     */
    public void setSeleccionarDispositivo(String marca, int modelo) {
        boolean dispositivoEncontrado = false;

        for (Dispositivo dispositivo : electronicos) {
            if (dispositivo.getMarca().equals(marca) && dispositivo.getModelo() == modelo) {
                this.seleccionarDispositivo = dispositivo;
                dispositivoEncontrado = true;
                break;
            }
        }

        if (!dispositivoEncontrado) {
            System.out.println("No se encontró el dispositivo");
        }
    }

    /**
     * Obtiene el dispositivo actualmente seleccionado.
     *
     * @return Dispositivo seleccionado.
     */
    public Dispositivo getSeleccionarDispositivo() {
        return seleccionarDispositivo;
    }

    /**
     * Enciende el dispositivo seleccionado.
     */
    public void encenderDispositivo() {
        seleccionarDispositivo.encender();
    }
}