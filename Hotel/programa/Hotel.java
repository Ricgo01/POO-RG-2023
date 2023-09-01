
/*
    * Hotel.java
    * Clase que contiene las habitaciones del hotel y permite reservarlas.
 * Ricardo Artuto Godinez Sanchez
 * 27/08/2023
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Hotel {
    private List<Habitacion> habitaciones;

    public Hotel() {
        habitaciones = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            habitaciones.add(new Habitacion(100, 1, i)); // Estándar
            habitaciones.add(new Habitacion(200, 2, i + 5)); // Deluxe
            habitaciones.add(new Habitacion(300, 3, i + 10)); // Suite
        }
    }

    public Habitacion reservarHabitacion(Huesped huesped, String tipoHabitacion) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.estaDisponible() && huesped.puedeReservar(habitacion)) {
                if (tipoHabitacion.equals("Estándar") || (tipoHabitacion.equals("Deluxe") && huesped.esFrecuente()) || (tipoHabitacion.equals("Suite") && huesped.esVIP())) {
                    habitacion.reservar();
                    return habitacion;
                }
            }
        }
        return null;
    }

}
