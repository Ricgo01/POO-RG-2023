/**
 * Representa un Snack, una subclase de Producto. 
 * Cada Snack tiene atributos adicionales como gramos, sabor y tamaño.
 */
public class Snack extends Producto {

    private int gramos;
    private String sabor;
    private String tamano;
    /**
     * Constructor para crear una nueva instancia de un Snack.
     * 
     * @param id Identificador único del producto.
     * @param nombre Nombre del producto.
     * @param precio Precio del producto.
     * @param cantidadDisponible Cantidad disponible en inventario.
     * @param cantidadVendida Cantidad vendida del producto.
     * @param estado Estado actual del producto (Disponible, no disponible).
     * @param gramos Cantidad en gramos del snack.
     * @param sabor Sabor del snack.
     * @param tamano Tamaño del snack.
     * @param tipo Tipo del producto (en este caso, "Snack").
     */

    public Snack(int id, String nombre, double precio, int cantidadDisponible, int cantidadVendida, String estado, int gramos, String sabor, String tamano, String tipo) {
        super(id, nombre, precio, cantidadDisponible, cantidadVendida, estado,tipo);
        this.gramos = gramos;
        this.sabor = sabor;
        this.tamano = tamano;
    }

    
    /**
     * Obtiene la cantidad en gramos del snack.
     * @return Cantidad en gramos.
     */

    public int getGramos() {
        return gramos;
    }

    /**
     * Establece una nueva cantidad en gramos para el snack.
     * @param gramos Nueva cantidad en gramos.
     */

    public void setGramos(int gramos) {
        this.gramos = gramos;
    }

    /**
     * Obtiene el sabor del snack.
     * @return Sabor del snack.
     */

    public String getSabor() {
        return sabor;
    }

    /**
     * Establece un nuevo sabor para el snack.
     * @param sabor Nuevo sabor.
     */

    public void setSabor(String sabor){
        this.sabor = sabor;
    }

    /**
     * Obtiene el tamaño del snack.
     * @return Tamaño del snack.
     */

    public String getTamano(){
        return tamano;
    }

    /**
     * Establece un nuevo tamaño para el snack.
     * @param tamano Nuevo tamaño.
     */

    public void setTamano(String tamano){
        this.tamano = tamano;
    }

    /**
     * Representación en cadena de caracteres de un Snack.
     * @return Detalles del snack en formato de cadena.
     */

    @Override
    public String toString() {
        return "Snack{" + 
        "id=" + id + 
        ", nombre=" + nombre + 
        ", precio=" + precio + 
        ", cantidadDisponible=" + cantidadDisponible + 
        ", cantidadVendida=" + cantidadVendida + 
        ", estado=" + estado +
        ", tipo=" + tipo + 
        ", gramos=" + gramos + 
        ", sabor=" + sabor + 
        ", tamano=" + tamano + "}";
    }
    
}
