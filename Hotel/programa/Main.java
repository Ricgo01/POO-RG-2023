import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Recibir huésped");
            System.out.println("2. Asignar cliente a habitación");
            System.out.println("3. Mostrar lista de espera");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    hotel.recibirHuesped();
                    break;
                case 2:
                    if (!hotel.listaEspera.isEmpty()) {
                        Huesped huesped = hotel.listaEspera.remove(0);
                        hotel.asignarClienteAHabitacion(huesped);
                    } else {
                        System.out.println("No hay huéspedes en la lista de espera.");
                    }
                    break;
                case 3:
                    hotel.mostrarListaEspera();
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}

