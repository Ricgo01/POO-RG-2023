/*
 * POO 2 Semestre
 * Facultad de Ingenieria
 * Departamento de Ciencias de la Computacion
 * Fecha inicio: 11/09/2023
 * Fecha final: 12/09/2023
 *
 * @author Ricardo Godinez 
 * 23247
 * 
 * Clase Profesor
 * 
 * Esta clase se encarga de crear un objeto de tipo Profesor
 *  
 * */

public class Profesor {
    private String nombre;
    private int carne;
    private String correo;
    private int telefono;

    public Profesor() {
        this.nombre = "";
        this.carne = 0;
        this.correo = "";
        this.telefono = 0;
    }

    public Profesor(String nombre, int carne, String correo, int telefono) {
        this.nombre = nombre;
        this.carne = carne;
        this.correo = correo;
        this.telefono = telefono;
    }

    // Getters
    public String getNombre() {
        return this.nombre;
    }

    public int getCarne() {
        return this.carne;
    }

    public String getCorreo() {
        return this.correo;
    }

    public int getTelefono() {
        return this.telefono;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCarne(int carne) {
        this.carne = carne;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    // toString
    @Override
    public String toString() {
        return "Profesor{" +
                "nombre='" + nombre + '\'' +
                ", carne=" + carne +
                ", correo='" + correo + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
