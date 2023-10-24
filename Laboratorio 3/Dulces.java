/**
 * Representa un Dulce, que es una subclase de Producto. 
 * Cada Dulce tiene atributos adicionales como gramos y sabor.
 */
public class Dulces extends Producto{

    private String sabor;
    private int gramos;

    /**
     * Constructor para crear una nueva instancia de un Dulce.
     * 
     * @param id Identificador único del producto.
     * @param nombre Nombre del producto.
     * @param precio Precio del producto.
     * @param cantidadDisponible Cantidad disponible en inventario.
     * @param cantidadVendida Cantidad vendida del producto.
     * @param estado Estado actual del producto (Disponible, no disponible).
     * @param tipo Tipo del producto (en este caso, "Dulces").
     * @param gramos Peso del dulce en gramos.
     * @param sabor Sabor del dulce.
     */

    public Dulces(int id, String nombre, double precio, int cantidadDisponible, int cantidadVendida, String estado, String tipo, int gramos, String sabor) {
        super(id, nombre, precio, cantidadDisponible, cantidadVendida, estado, tipo);
        this.sabor = sabor;
        this.gramos = gramos;
    }
/**
     * Obtiene el peso del dulce en gramos.
     * @return Peso en gramos.
     */    

    public int getGramos(){
        return gramos;
    }

    /**
     * Establece un nuevo peso en gramos para el dulce.
     * @param gramos Nuevo peso en gramos.
     */

    public void setGramos(int gramos){
        this.gramos = gramos;
    }

    /**
     * Obtiene el sabor del dulce.
     * @return Sabor del dulce.
     */

    public String getSabor(){
        return sabor;
    }

    /**
     * Establece un nuevo sabor para el dulce.
     * @param sabor Nuevo sabor.
     */

    public void setSabor(String sabor){
        this.sabor = sabor;
    }

    /**
     * Representación en cadena de caracteres de un Dulce.
     * @return Detalles del dulce en formato de cadena.
     */

    @Override
    public String toString() {
        return "Dulces{" + 
        "id=" + id + 
        ", nombre=" + nombre + 
        ", precio=" + precio + 
        ", cantidadDisponible=" + cantidadDisponible + 
        ", cantidadVendida=" + cantidadVendida + 
        ", estado=" + estado + 
        ", tipo=" + tipo + 
        ", gramos=" + gramos + 
        ", sabor=" + sabor +"}";
    }
    
    
}
