/**
 * Representa un Producto genérico en el sistema.
 * Esta clase actúa como clase base para otros tipos específicos de productos.
 */
public class Producto {
    protected int id;
    protected String nombre;
    protected double precio;
    protected int cantidadDisponible;
    protected int cantidadVendida;
    protected String estado;
    protected String tipo;

    /**
     * Constructor para crear una nueva instancia de un Producto.
     * 
     * @param id Identificador único del producto.
     * @param nombre Nombre del producto.
     * @param precio Precio del producto.
     * @param cantidadDisponible Cantidad disponible en inventario.
     * @param cantidadVendida Cantidad vendida del producto.
     * @param estado Estado actual del producto (Disponible, no disponible).
     * @param tipo Tipo del producto (p.ej., "Bebida", "Snack", "Dulces").
     */

    public Producto(int id , String nombre , double precio , int cantidadDisponible , int cantidadVendida , String estado, String tipo){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
        this.cantidadVendida = cantidadVendida;
        this.estado = estado;
        this.tipo = tipo;
    }

    //getters and setters

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNombre(){
        return nombre; 
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public double getPrecio(){
        return precio;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public int getCantidadDisponible(){
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible){
        this.cantidadDisponible = cantidadDisponible;
    }

    public int getCantidadVendida(){
        return cantidadVendida;
    }

    public void setCantidadVendida(int cantidadVendida){
        this.cantidadVendida = cantidadVendida;
    }

    public String getEstado(){
        return estado;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    /**
     * Calcula las ganancias totales del producto multiplicando el precio por la cantidad vendida.
     * 
     * @return Total de ganancias del producto.
     */

    public double calcularGanancias(){
        double ganancias = 0;
        ganancias = precio * cantidadVendida;
        return ganancias;
    }

    /**
     * Representación en cadena de caracteres de un Producto.
     * @return Detalles del producto en formato de cadena.
     */

    @Override
    public String toString(){
        return "Producto [id=" + id + 
        ", nombre=" + nombre + 
        ", precio=" + precio + 
        ", cantidadDisponible=" + cantidadDisponible + 
        ", cantidadVendida=" + cantidadVendida + 
        ", estado=" + estado + 
        ", tipo=" + tipo +"]";
    }
}