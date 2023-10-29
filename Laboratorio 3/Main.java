/**
 * Esta clase Main contiene el punto de entrada principal al programa y ofrece un menú interactivo 
 * para gestionar los productos de una tienda.
 * Ricardo Arturo Godinez Sanchez
 * #23247
 * Laboratorio 3
 * 10/23/2021
 * Programación Orientada a Objetos 2023
 */
import java.util.Scanner;
import java.util.List;

public class Main {
    /**
     * Método principal de la aplicación. Proporciona un menú interactivo para realizar diversas operaciones 
     * relacionadas con la tienda y los productos.
     * 
     * @param args Argumentos de línea de comando. No se utilizan en este contexto.
     */
    public static void main(String[] args) {
        // Instancia de la tienda
        Tienda tienda = new Tienda();
        Scanner scanner = new Scanner(System.in);
        List<Producto> productos;

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Cargar productos desde archivo CSV");
            System.out.println("2. Buscar producto por ID");
            System.out.println("3. Listar productos por categoría");
            System.out.println("4. Mostrar ventas actuales");
            System.out.println("5. Calcular comisión");
            System.out.println("6. Informe");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    productos = Archivo.cargarProductos("productos.csv");
                    if (productos != null && !productos.isEmpty()) {
                        tienda.setInventario(productos);
                        System.out.println("Productos cargados exitosamente!");
                        for (Producto prod : productos) {
                            System.out.println(prod);
                        }

                    } else {
                        System.out.println("Error al cargar productos o archivo vacío.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el ID del producto a buscar: ");
                    int id = scanner.nextInt();
                    Producto producto = tienda.buscarProductoPorId(id);
                    if (producto != null) {
                        System.out.println(producto);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese la categoría a listar (Bebida, Snack, Dulces): ");
                    String categoria = scanner.nextLine();
                    List<Producto> productosCategoria = tienda.listarProductosPorCategoria(categoria);
                    if (!productosCategoria.isEmpty()) {
                        for (Producto prod : productosCategoria) {
                            System.out.println(prod);
                        }
                    } else {
                        System.out.println("No hay productos en esta categoría.");
                    }
                    break;
                case 4:
                    System.out.println("Ventas actuales: $" + tienda.obtenerVentasActuales());
                    break;
                case 5:
                    System.out.println("Comisión: $" + tienda.calcularComision());
                    break;
                case 6:
                    System.out.println("Listado de categorias con el total de productos: ");
                    tienda.listarTotalPorCategoria("Bebida");
                    tienda.listarTotalPorCategoria("Snack");
                    tienda.listarTotalPorCategoria("Dulces");
                
                    System.out.println("\nListado de productos por categoria:");
                    System.out.println("Categoria Bebidas:");
                    tienda.listarProductosPorCategoria("Bebida");
                
                    System.out.println("\nCategoria Snacks:");
                    tienda.listarProductosPorCategoria("Snack");
                
                    System.out.println("\nCategoria Dulces:");
                    tienda.listarProductosPorCategoria("Dulces");
                
                    System.out.println("\nTotal de ventas:");
                    System.out.println("Ventas totales: $" + tienda.obtenerVentasActuales());
                    System.out.println("Porcentaje por categoria Bebida: $" + tienda.calcularComisionPorCategoria("Bebida"));
                    System.out.println("Porcentaje por categoria Snack: $" + tienda.calcularComisionPorCategoria("Snack"));
                    System.out.println("Porcentaje por categoria Dulces: $" + tienda.calcularComisionPorCategoria("Dulces"));
                    break;
                case 7:
                    System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
                    scanner.close();
                    return;
                
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
