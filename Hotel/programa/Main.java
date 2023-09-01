/*
 * Clase Main
 * Clase principal del programa, donde se ejecuta el programa.
 * Ricardo Artuto Godinez Sanchez
 * 27/08/2023
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        System.out.println("¡Bienvenido al Hotel!");

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Reservar una habitación");
            System.out.println("2. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese su nombre: ");
                    String nombre = scanner.next();
                    System.out.print("Ingrese su correo: ");
                    String correo = scanner.next();
                    System.out.print("Ingrese la cantidad de personas: ");
                    int cantidadH = scanner.nextInt();
                    System.out.print("Ingrese su presupuesto: ");
                    double presupuesto = scanner.nextDouble();
                    System.out.print("Ingrese su frecuencia (número de visitas previas): ");
                    int frecuencia = scanner.nextInt();

                    Huesped huesped = new Huesped(nombre, correo, cantidadH, presupuesto, frecuencia);

                    System.out.println("\nTipos de habitaciones:");
                    System.out.println("1. Estándar");
                    System.out.println("2. Deluxe");
                    System.out.println("3. Suite");
                    System.out.print("Seleccione el tipo de habitación que desea (1/2/3): ");
                    int tipoHabitacion = scanner.nextInt();

                    String tipoHabitacionStr = "";
                    switch (tipoHabitacion) {
                        case 1:
                            tipoHabitacionStr = "Estándar";
                            break;
                        case 2:
                            tipoHabitacionStr = "Deluxe";
                            break;
                        case 3:
                            tipoHabitacionStr = "Suite";
                            break;
                        default:
                            System.out.println("Opción no válida. Saliendo.");
                            System.exit(0);
                    }

                    Habitacion habitacionReservada = hotel.reservarHabitacion(huesped, tipoHabitacionStr);

                    if (habitacionReservada != null) {
                        System.out.println("Habitación reservada con éxito.");
                        System.out.println("Detalles de la habitación:");
                        System.out.println("ID: " + habitacionReservada.getID());
                        System.out.println("Precio: " + habitacionReservada.getPrecio());
                    } else {
                        System.out.println("Lo sentimos, no hay habitaciones disponibles que cumplan con sus requisitos.");
                    }

                    break;
                case 2:
                    System.out.println("¡Gracias por utilizar nuestro servicio!");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
}

