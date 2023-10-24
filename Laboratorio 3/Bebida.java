/**
 * Representa una Bebida, una subclase de Producto. 
 * Cada Bebida tiene atributos adicionales como mililitros y sabor.
 */
public class Bebida extends Producto {

    private double mililitros;
    private String sabor;

    /**
     * Constructor para crear una nueva instancia de una Bebida.
     * 
     * @param id Identificador único del producto.
     * @param nombre Nombre del producto.
     * @param precio Precio del producto.
     * @param cantidadDisponible Cantidad disponible en inventario.
     * @param cantidadVendida Cantidad vendida del producto.
     * @param estado Estado actual del producto (Disponible, no disponible).
     * @param mililitros Volumen de la bebida en mililitros.
     * @param tipo Tipo del producto (en este caso, "Bebida").
     * @param sabor Sabor de la bebida.
     */

    public Bebida(int id, String nombre, double precio, int cantidadDisponible, int cantidadVendida, String estado, double mililitros, String tipo, String sabor) {
        super(id, nombre, precio, cantidadDisponible, cantidadVendida, estado, tipo);
        this.mililitros = mililitros;
        this.sabor = sabor;

    }

    /**
     * Obtiene el volumen de la bebida en mililitros.
     * @return Volumen en mililitros.
     */

    public double getMililitros() {
        return mililitros;
    }

    /**
     * Establece un nuevo volumen en mililitros para la bebida.
     * @param mililitros Nuevo volumen en mililitros.
     */

    public void setMililitros(double mililitros) {
        this.mililitros = mililitros;
    }

    /**
     * Obtiene el sabor de la bebida.
     * @return Sabor de la bebida.
     */

    public String getSabor() {
        return sabor;
    }

    /**
     * Establece un nuevo sabor para la bebida.
     * @param sabor Nuevo sabor.
     */

    public void setSabor(String sabor){
        this.sabor = sabor;
    }

    /**
     * Representación en cadena de caracteres de una Bebida.
     * @return Detalles de la bebida en formato de cadena.
     */
    
    @Override
    public String toString() {
        return "Bebida{" + 
        "id=" + id + 
        ", nombre=" + nombre + 
        ", precio=" + precio + 
        ", cantidadDisponible=" + cantidadDisponible + 
        ", cantidadVendida=" + cantidadVendida + 
        ", estado=" + estado + 
        ", mililitros=" + mililitros + 
        ", sabor=" + sabor + "}";
    }

    
}
