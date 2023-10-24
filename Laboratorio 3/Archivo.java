import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase Archivo que proporciona métodos relacionados con la lectura de archivos.
 * Principalmente se encarga de cargar productos desde un archivo CSV.
 */

public class Archivo {

    /**
     * Carga una lista de productos desde un archivo CSV especificado.
     * El archivo debe tener un formato específico donde cada línea representa un producto y
     * los datos del producto están separados por comas.
     * 
     * @param rutaArchivo La ruta del archivo CSV a leer.
     * @return Una lista de productos cargados desde el archivo.
     */

    public static ArrayList<Producto> cargarProductos(String rutaArchivo) {
        ArrayList<Producto> productos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            br.readLine(); // Leer la primera línea (encabezados) y descartarla

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");

                int id = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                int cantidadDisponible = Integer.parseInt(partes[2]);
                int cantidadVendida = Integer.parseInt(partes[3]);
                String estado = partes[4];
                double precio = Double.parseDouble(partes[5]);
                String tipo = partes[7];

                switch (tipo) {
                    case "Bebida":
                        double mililitros = Double.parseDouble(partes[6]);
                        String saborBebida = partes[8];
                        productos.add(new Bebida(id, nombre, precio, cantidadDisponible, cantidadVendida, estado, mililitros, tipo, saborBebida));
                        break;
                    case "Snack":
                        int gramosSnack = Integer.parseInt(partes[8]);
                        String saborSnack = partes[9];
                        String tamano = partes[10];
                        productos.add(new Snack(id, nombre, precio, cantidadDisponible, cantidadVendida, estado, gramosSnack, saborSnack, tamano, tipo));
                        break;
                    case "Dulces":
                        int gramosDulces = Integer.parseInt(partes[8]);
                        String saborDulces = partes[9];
                        productos.add(new Dulces(id, nombre, precio, cantidadDisponible, cantidadVendida, estado, tipo, gramosDulces, saborDulces));
                        break;
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return productos;
    }
}


