import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Universidad universidad = new Universidad();

        while (true) {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Agregar una nueva sede universitaria");
            System.out.println("2. Registrar un estudiante");
            System.out.println("3. Ingresar resultados de exámenes");
            System.out.println("4. Calcular promedio general de un examen");
            System.out.println("5. Calcular promedio de un estudiante");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la sede: ");
                    scanner.nextLine();
                    String nombreSede = scanner.nextLine();
                    SedeUniversitaria sede = new SedeUniversitaria(nombreSede);
                    universidad.agregarSede(sede);
                    System.out.println("Sede '" + nombreSede + "' agregada con éxito.");
                    break;
                case 2:
                    // Solicitar datos al usuario y crear un objeto Estudiante
                    // Luego, registrar el estudiante en una sede
                    break;
                case 3:
                    // Solicitar datos al usuario y crear un objeto Examen
                    // Luego, ingresar los resultados del examen para un estudiante
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del examen: ");
                    scanner.nextLine();
                    String nombreExamen = scanner.nextLine();
                    double promedioExamen = universidad.calcularPromedioGeneralExamen(nombreExamen);
                    System.out.println("El promedio general del examen '" + nombreExamen + "' es: " + promedioExamen);
                    break;
                case 5:
                    // Solicitar datos al usuario para identificar un estudiante
                    // Calcular y mostrar el promedio del estudiante
                    break;
                case 6:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }
}
