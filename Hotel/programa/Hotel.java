import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hotel {
    private ArrayList<Habitacion> habitaciones;
    ArrayList<Huesped> listaEspera;

    public Hotel() {
        habitaciones = new ArrayList<>();
        listaEspera = new ArrayList<>();
        // Agregar habitaciones al hotel
        habitaciones.add(new Habitacion(100, 1, 1)); // Estándar
        habitaciones.add(new Habitacion(100, 1, 2)); // Estándar
        habitaciones.add(new Habitacion(200, 2, 3)); // Deluxe
        habitaciones.add(new Habitacion(200, 2, 4)); // Deluxe
        habitaciones.add(new Habitacion(300, 3, 5)); // Suite
    }

    public void recibirHuesped() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del huésped:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el correo del huésped:");
        String correo = scanner.nextLine();
        System.out.println("Ingrese la cantidad de huéspedes:");
        int cantidadH = scanner.nextInt();
        System.out.println("Ingrese el presupuesto del huésped:");
        double presupuesto = scanner.nextDouble();
        System.out.println("Ingrese la frecuencia de visita del huésped:");
        int frecuencia = scanner.nextInt();

        Huesped huesped = new Huesped(nombre, correo, cantidadH, presupuesto, frecuencia);
        listaEspera.add(huesped);
        System.out.println("Huésped registrado en lista de espera.");
    }

    public void asignarClienteAHabitacion(Huesped huesped) {
        for (Habitacion habitacion : habitaciones) {
            if (huesped.getFrecuencia() >= 10 && habitacion.getAforo() >= huesped.getCantidadH() && habitacion.isDisponible()) {
                habitacion.asignarHuesped(huesped);
                System.out.println("Huésped asignado a una Suite.");
                return;
            }
        }

        for (Habitacion habitacion : habitaciones) {
            if (huesped.getFrecuencia() >= 5 && habitacion.getAforo() >= huesped.getCantidadH() && habitacion.isDisponible()) {
                habitacion.asignarHuesped(huesped);
                System.out.println("Huésped asignado a una Deluxe.");
                return;
            }
        }

        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getAforo() >= huesped.getCantidadH() && habitacion.isDisponible()) {
                habitacion.asignarHuesped(huesped);
                System.out.println("Huésped asignado a una Estándar.");
                return;
            }
        }

        listaEspera.add(huesped);
        System.out.println("No hay habitaciones disponibles para este huésped. Agregado a la lista de espera.");
    }

    public void mostrarListaEspera() {
        System.out.println("Lista de espera:");
        for (Huesped huesped : listaEspera) {
            System.out.println("Nombre: " + huesped.getNombre() + ", Correo: " + huesped.getCorreo());
        }
    }
}
