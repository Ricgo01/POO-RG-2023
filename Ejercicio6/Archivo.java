import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase Archivo para la gestión de archivos relacionados con dispositivos.
 * Esta clase proporciona métodos para cargar dispositivos desde un archivo.
 */
public class Archivo {
    
    /**
     * Carga dispositivos desde un archivo especificado por su ruta.
     * 
     * <p>El archivo debe contener una lista de dispositivos en formato CSV.
     * La primera línea del archivo se considera una cabecera y se omite.
     * Las siguientes líneas deben contener información sobre los dispositivos, 
     * separada por comas.</p>
     * 
     * <p>El método interpreta y crea objetos de tipo PC o Teléfono según la 
     * información del archivo y los agrega a una lista.</p>
     *
     * @param rutaArchivo La ruta del archivo que contiene la lista de dispositivos.
     * @return Una lista de dispositivos cargados desde el archivo.
     */
    public static ArrayList<Dispositivo> cargarDispositivos(String rutaArchivo) {
        ArrayList<Dispositivo> dispositivos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            br.readLine();  // Leer y omitir la primera línea (cabecera)

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                String marca = datos[0];
                int modelo = Integer.parseInt(datos[1]);
                int precio = Integer.parseInt(datos[2]);
                int visaCuotas = Integer.parseInt(datos[3]);
                int ram = Integer.parseInt(datos[4]);
                String tipo = datos[5];

                switch (tipo) {
                    case "PC":
                        int tamanioMemoria = Integer.parseInt(datos[6]);
                        String tipoMemoria = datos[7];
                        int velocidadCPU = Integer.parseInt(datos[8]);
                        int velocidadGPU = Integer.parseInt(datos[9]);
                        dispositivos.add(new PC(precio, marca, modelo, visaCuotas, ram, tipo, tamanioMemoria, tipoMemoria, velocidadCPU, velocidadGPU));
                        break;

                    case "Telefono":
                        String procesador = datos[10];
                        int almacenamientoInterno = Integer.parseInt(datos[11]);
                        boolean extendible = Boolean.parseBoolean(datos[12]);
                        boolean incluyeCargador = Boolean.parseBoolean(datos[13]);
                        boolean CincoG = Boolean.parseBoolean(datos[14]);
                        dispositivos.add(new Telefono(precio, marca, modelo, visaCuotas, ram, tipo, procesador, almacenamientoInterno, extendible, incluyeCargador, CincoG));
                        break;
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return dispositivos;
    }
}
