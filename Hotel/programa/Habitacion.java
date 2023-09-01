/*
    * Clase Habitacion
    * Clase que representa una habitación del hotel.
 * Ricardo Artuto Godinez Sanchez
 * 27/08/2023
 */
public class Habitacion {
    private double precio;
    private int aforo;
    private int ID;
    private boolean disponibilidad;

    public Habitacion(double precio, int aforo, int ID) {
        this.precio = precio;
        this.aforo = aforo;
        this.ID = ID;
        this.disponibilidad = true;
    }

    // Getters

    public double getPrecio() {
        return precio;
    }

    public int getAforo() {
        return aforo;
    }

    public int getID() {
        return ID;
    }

    public boolean estaDisponible() {
        return disponibilidad;
    }

    public void reservar() {
        disponibilidad = false;
    }
    
    public void liberar() {
        disponibilidad = true;
    }
}

