
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
}