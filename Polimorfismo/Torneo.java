import java.util.ArrayList;
import java.util.Comparator;
/**
 * Representa un torneo que gestiona jugadores y sus estadísticas.
 * Permite agregar jugadores, mostrarlos, filtrarlos y guardar/cargar datos desde un archivo.
 */
public class Torneo {
     /** Lista de jugadores que participan en el torneo. */
    private ArrayList<Jugador> jugadores;
    /** Archivo para gestionar la persistencia de datos de los jugadores. */
    private Archivo jugadorCSV;
    /** Archivo genérico para cargar datos. */
    private Archivo archivo;
    /**
     * Constructor por defecto para inicializar un torneo.
     */
    public Torneo(){
        jugadores = new ArrayList<Jugador>();
        jugadorCSV = new Archivo("jugadores.csv");

    }
    /**
     * Agrega un jugador al torneo basado en los parámetros proporcionados.
     *
     * @param nombre Nombre del jugador.
     * @param pais País de origen del jugador.
     * @param errores Número de errores cometidos por el jugador.
     * @param aces Número de aces realizados por el jugador.
     * @param totalServicios Número total de servicios realizados por el jugador.
     * @param ataquesEfectivos Número de ataques efectivos (solo para Pasador).
     * @param bloqueosEfectivos Número de bloqueos efectivos (solo para Pasador y Auxiliar).
     * @param bloqueosFallidos Número de bloqueos fallidos (solo para Auxiliar).
     * @param tipoJugador Tipo de jugador (1: Pasador, 2: Auxiliar, 3: Libero).
     */
    public void agregarJugador(String nombre, String pais, int errores, int aces, int totalServicios, int ataquesEfectivos, int bloqueosEfectivos, int bloqueosFallidos, int tipoJugador){
        switch (tipoJugador){
            case 1:
                Pasador pas = new Pasador(nombre, pais, errores, aces, totalServicios, ataquesEfectivos, bloqueosEfectivos);
                jugadores.add(pas);
                break;
            case 2:
                Auxiliar aux = new Auxiliar(nombre, pais, errores, aces, totalServicios, ataquesEfectivos, bloqueosEfectivos, bloqueosFallidos);
                jugadores.add(aux);
                break;
            case 3:
                Libero lib = new Libero(nombre, pais, errores, aces, totalServicios, bloqueosEfectivos);
                jugadores.add(lib);
                break;
        }
    }
    /**
     * Muestra la lista de jugadores que participan en el torneo.
     */
    public void mostrarJugadores(){
        System.out.println("Lista de Jugadores:");
        System.out.println("-------------------");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador);
            System.out.println("-------------------");
        }
    }
    /**
     * Muestra los tres mejores liberos basados en su efectividad.
     */
    public void mostrarTresMejoresLiberos() {
        jugadores.stream()
            .filter(jugador -> jugador instanceof Libero)
            .sorted(Comparator.comparing((Jugador jugador) -> ((Libero) jugador).efectividadLibero()).reversed())
            .limit(3)
            .forEach(jugador -> System.out.println(jugador));
    }
    /**
     * Muestra la cantidad de pasadores con una efectividad mayor al 80%.
     */
    public void mostrarPasadoresMayorOchentaPorciento() {
        long cantidad = jugadores.stream()
            .filter(jugador -> jugador instanceof Pasador)
            .filter(jugador -> ((Pasador) jugador).efectividadPasador() > 80)
            .count();

        System.out.println("Cantidad de pasadores con más de un 80% de efectividad: " + cantidad);
    }
    /**
     * Guarda la lista de jugadores en un archivo CSV.
     *
     * @throws Exception Si ocurre un error al escribir en el archivo.
     */
    public void guardarEnArchivo() throws Exception{
        jugadorCSV.escribirArchivo(jugadores);
    }
    /**
     * Carga jugadores desde un archivo CSV y los agrega a la lista de jugadores.
     *
     * @throws Exception Si ocurre un error al leer el archivo.
     */
    public void cargarArchivo() throws Exception {
        // Crear una instancia de Archivo
        archivo = new Archivo("nombreDelArchivo.csv"); // Asegúrate de proporcionar el nombre correcto del archivo

        // Leer el archivo
        ArrayList<String> lineas = archivo.leerArchivo();

        // Parsear cada línea y crear objetos de jugadores
        for (String linea : lineas) {
            String[] datos = linea.split(",");
            String nombre = datos[0];
            String pais = datos[1];
            int errores = Integer.parseInt(datos[2]);
            int aces = Integer.parseInt(datos[3]);
            int totalServicios = Integer.parseInt(datos[4]);

            switch (datos[5]) {
                case "1": // Pasador
                    int pases = Integer.parseInt(datos[6]);
                    int fintasEfectivas = Integer.parseInt(datos[7]);
                    jugadores.add(new Pasador(nombre, pais, errores, aces, totalServicios, pases, fintasEfectivas));
                    break;
                case "2": // Auxiliar
                    int ataquesEfectivos = Integer.parseInt(datos[6]);
                    int bloqueosEfectivos = Integer.parseInt(datos[7]);
                    int bloqueosFallidos = Integer.parseInt(datos[8]);
                    jugadores.add(new Auxiliar(nombre, pais, errores, aces, totalServicios, ataquesEfectivos, bloqueosEfectivos, bloqueosFallidos));
                    break;
                case "3": // Libero
                    int recibosEfectivos = Integer.parseInt(datos[6]);
                    jugadores.add(new Libero(nombre, pais, errores, aces, totalServicios, recibosEfectivos));
                    break;
            }
        }
    }
}
