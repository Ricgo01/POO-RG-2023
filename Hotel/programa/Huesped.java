/*
    * Clase Huesped
    * Clase que representa un huésped del hotel.
 * Ricardo Artuto Godinez Sanchez
 * 27/08/2023
 */

public class Huesped {
    private String nombre;
    private String correo;
    private int cantidadH;
    private double presupuesto;
    private int frecuencia;

    public Huesped(String nombre, String correo, int cantidadH, double presupuesto, int frecuencia) {
        this.nombre = nombre;
        this.correo = correo;
        this.cantidadH = cantidadH;
        this.presupuesto = presupuesto;
        this.frecuencia = frecuencia;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public int getCantidadH() {
        return cantidadH;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public boolean puedeReservar(Habitacion habitacion) {
        return presupuesto >= habitacion.getPrecio() && cantidadH <= habitacion.getAforo();
    }

    public boolean esFrecuente() {
        return frecuencia >= 10;
    }

    public boolean esVIP() {
        return frecuencia >= 5;
    }
}