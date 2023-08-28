
public class Habitacion {
    private double precio;
    private int aforo;
    private int ID;
    private boolean disponibilidad;
    private Huesped huesped;

    public Habitacion(double precio, int aforo, int ID) {
        this.precio = precio;
        this.aforo = aforo;
        this.ID = ID;
        this.disponibilidad = true;
        this.huesped = null;
    }

    public double getPrecio() {
        return precio;
    }

    public int getAforo() {
        return aforo;
    }

    public int getID() {
        return ID;
    }

    public boolean isDisponible() {
        return disponibilidad;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void asignarHuesped(Huesped huesped) {
        this.huesped = huesped;
        this.disponibilidad = false;
    }
}

