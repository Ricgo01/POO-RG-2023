/**
 * Representa una Tienda que contiene un inventario de productos.
 * Proporciona métodos para cargar el inventario desde un archivo, buscar productos,
 * listar productos por categoría, calcular ventas y comisiones, entre otros.
 */
import java.util.ArrayList;
import java.util.List;

public class Tienda {
    /** Lista de productos que conforman el inventario de la tienda. */
    private List<Producto> inventario;

    /**
     * Constructor para crear una nueva instancia de Tienda.
     * Inicializa el inventario como una lista vacía.
     */

    public Tienda() {
        this.inventario = new ArrayList<>();
    }

    /**
     * Carga el inventario de la tienda desde un archivo CSV especificado.
     * 
     * @param rutaArchivo Ruta del archivo CSV de donde se cargarán los productos.
     */

    public void cargarInventario(String rutaArchivo) {
        this.inventario = Archivo.cargarProductos(rutaArchivo);
    }

    /**
     * Busca un producto en el inventario por su ID.
     * 
     * @param id Identificador del producto a buscar.
     * @return Producto encontrado o null si no se encuentra.
     */

    public Producto buscarProductoPorId(int id) {
        for (Producto producto : inventario) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    /**
     * Lista todos los productos del inventario que pertenecen a una categoría específica.
     * 
     * @param categoria Categoría de los productos a listar (p.ej., "Bebida", "Snack", "Dulces").
     * @return Lista de productos de la categoría especificada.
     */

    public List<Producto> listarProductosPorCategoria(String categoria) {
        List<Producto> productosCategoria = new ArrayList<>();

        for (Producto producto : inventario) {
            if (producto.getTipo().equalsIgnoreCase(categoria)) {
                productosCategoria.add(producto);
            }
        }

        return productosCategoria;
    }

     /**
     * Calcula el total de ventas actuales basado en el precio y cantidad vendida de cada producto.
     * 
     * @return Total de ventas de la tienda.
     */

    public double obtenerVentasActuales() {
        double ventas = 0;

        for (Producto producto : inventario) {
            ventas += producto.calcularGanancias();
        }

        return ventas;
    }

     /**
     * Establece el inventario de la tienda.
     * 
     * @param productos Lista de productos que conformarán el nuevo inventario.
     */
    public void setInventario(List<Producto> productos) {
        this.inventario = productos;
    }

    /**
     * Calcula la comisión basada en las ventas actuales.
     * Se asume una comisión del 10% sobre las ventas.
     * 
     * @return Valor de la comisión.
     */

    public double calcularComision() {
        return obtenerVentasActuales() * 0.10;
    }

    /**
     * Imprime en consola el total de productos en el inventario de una categoría específica.
     * 
     * @param categoria Categoría de los productos a contar (p.ej., "Bebida", "Snack", "Dulces").
     */

    public void listarTotalPorCategoria(String categoria) {
        int total = 0;
        for (Producto producto : inventario) {
            if (producto.getTipo().equalsIgnoreCase(categoria)) {
                total++;
            }
        }
        System.out.println(categoria + " – " + total);
    }

     /**
     * Calcula la comisión basada en las ventas de una categoría específica.
     * 
     * @param categoria Categoría de los productos a considerar para la comisión (p.ej., "Bebida", "Snack", "Dulces").
     * @return Valor de la comisión para la categoría especificada.
     */

    public double calcularComisionPorCategoria(String categoria) {
        double ventasCategoria = 0;
        for (Producto producto : inventario) {
            if (producto.getTipo().equalsIgnoreCase(categoria)) {
                ventasCategoria += producto.calcularGanancias();
            }
        }
        return ventasCategoria * 0.10; // Asumiendo una comisión del 10% por categoría
    }

    

    
}



