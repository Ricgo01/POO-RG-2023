import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 * Clase que gestiona la lectura y escritura de jugadores en un archivo.
 */
public class Archivo {
    
    private File archivo;
/**
     * Constructor que inicializa el archivo con el nombre proporcionado.
     *
     * @param nombreArchivo Nombre del archivo a gestionar.
     */
    public Archivo(String nombreArchivo){
        archivo = new File(nombreArchivo);
    }
    /**
     * Escribe la lista de jugadores en el archivo.
     *
     * @param jugadores Lista de jugadores a escribir en el archivo.
     * @throws Exception Si ocurre un error al escribir en el archivo.
     */
    public void escribirArchivo (ArrayList<Jugador> jugadores) throws Exception {
        PrintWriter pw = new PrintWriter(archivo, "UTF-8");

        String linea = "Nombre,Pais,Errores,Aces,Total Servicios,Ataques Efectivos,Bloqueos Efectivos,Bloqueos Fallidos,Recibos Efectivos,Pases,Fintas Efectivas";
        pw.print(linea);

        for (Jugador jug:jugadores){
            linea = jug.getNombre() + "," + jug.getPais() + "," + jug.getErrores() + "," + jug.getAces() + "," + jug.getTotalServicios();
            if (jug instanceof Pasador){
                linea = linea + "1" + "," + ((Pasador)jug).getPases() + "," + ((Pasador)jug).getFintasEfectivas() + ",";
            } 
            else if (jug instanceof Auxiliar){
                linea = linea + "2" + "," + ((Auxiliar) jug).getAtaquesEfectivos() + "," + ((Auxiliar) jug).getBloqueosEfectivos() + "," + ((Auxiliar) jug).getBloqueosFallidos();
            } 
            else if (jug instanceof Libero){
                linea = linea + "3" + "," +((Libero) jug).getRecibosEfectivos();
            }
            pw.println(linea);
        }
        pw.close();
    }
    /**
     * Lee el archivo y devuelve una lista de líneas.
     *
     * @return Una lista de strings, donde cada string es una línea del archivo.
     * @throws FileNotFoundException Si el archivo no se encuentra.
     */
    public ArrayList<String> leerArchivo() throws FileNotFoundException {
        ArrayList<String> lineas = new ArrayList<>();
        java.util.Scanner scanner = new java.util.Scanner(archivo);
        scanner.nextLine(); // Saltar la primera línea (encabezados)
        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();
            lineas.add(linea);
        }
        scanner.close();
        return lineas;
    }

}
