/*
 * Clase Main
 * Clase principal del programa, donde se ejecuta el programa.
 * Ricardo Artuto Godinez Sanchez
 * 27/08/2023
 */
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        System.out.print("Nombre del huésped: ");
        String nombre = scanner.nextLine();
        System.out.print("Correo del huésped: ");
        String correo = scanner.nextLine();
        System.out.print("Cantidad de huéspedes: ");
        int cantidadH = scanner.nextInt();
        System.out.print("Presupuesto del huésped: ");
        double presupuesto = scanner.nextDouble();
        System.out.print("Frecuencia del huésped: ");
        int frecuencia = scanner.nextInt();

        Huesped huesped = new Huesped(nombre, correo, cantidadH, presupuesto, frecuencia);

        System.out.println("Tipo de habitación deseada (Estándar, Deluxe o Suite): ");
        String tipoHabitacion = scanner.next();

        Habitacion habitacion = hotel.reservarHabitacion(huesped, tipoHabitacion);

        if (habitacion != null) {
            System.out.println("¡Habitación reservada con éxito!");
        } else {
            System.out.println("Lo sentimos, no se pudo realizar la reserva.");
        }
    }
}

