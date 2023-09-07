/*
 * Autor: Ricardo Godinez
 * Carne: 23247
 * Fecha: 06/09/2023
 * Universidad del Valle de Guatemala
 * Programacion Orientada a Objetos
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Universidad universidad = new Universidad();

        while (true) {
            System.out.println("=== Menú ===");
            System.out.println("1. Agregar sede");
            System.out.println("2. Registrar estudiante");
            System.out.println("3. Ingresar resultados de exámenes");
            System.out.println("4. Calcular estadísticas");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre de la sede: ");
                    String nombreSede = scanner.nextLine();
                    universidad.agregarSede(new SedeUniversitaria(nombreSede));
                    System.out.println("Sede agregada exitosamente.");
                    break;

                case 2:
                    System.out.print("Nombre de la sede en la que se registrará el estudiante: ");
                    nombreSede = scanner.nextLine();
                    SedeUniversitaria sede = null;
                    for (SedeUniversitaria s : universidad.getSedes()) {
                        if (s.getNombre().equals(nombreSede)) {
                            sede = s;
                            break;
                        }
                    }
                    if (sede == null) {
                        System.out.println("Sede no encontrada.");
                        break;
                    }
                    System.out.print("Nombre del estudiante: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido del estudiante: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Código único del estudiante: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Fecha de nacimiento (dd/mm/aaaa): ");
                    String fecha = scanner.nextLine();
                    System.out.print("Correo electrónico: ");
                    String correo = scanner.nextLine();
                    Estudiante estudiante = new Estudiante(nombre, apellido, codigo, fecha, correo);
                    sede.registrarEstudiante(estudiante);
                    System.out.println("Estudiante registrado exitosamente.");
                    break;

                case 3:
                    System.out.print("Nombre de la sede del estudiante: ");
                    nombreSede = scanner.nextLine();
                    sede = null;
                    for (SedeUniversitaria s : universidad.getSedes()) {
                        if (s.getNombre().equals(nombreSede)) {
                            sede = s;
                            break;
                        }
                    }
                    if (sede == null) {
                        System.out.println("Sede no encontrada.");
                        break;
                    }
                    System.out.print("Código único del estudiante: ");
                    codigo = scanner.nextLine();
                    Estudiante estudianteSeleccionado = null;
                    for (Estudiante e : sede.getEstudiantes()) {
                        if (e.getCodigoUnico().equals(codigo)) {
                            estudianteSeleccionado = e;
                            break;
                        }
                    }
                    if (estudianteSeleccionado == null) {
                        System.out.println("Estudiante no encontrado.");
                        break;
                    }
                    System.out.print("Nombre del examen: ");
                    String nombreExamen = scanner.nextLine();
                    System.out.print("Nota obtenida: ");
                    double nota = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar buffer
                    estudianteSeleccionado.agregarExamen(new Examen(nombreExamen, nota));
                    System.out.println("Examen registrado exitosamente.");
                    break;

                case 4:
                    System.out.println("=== Estadísticas ===");
                    System.out.println("1. Promedio general de la universidad");
                    System.out.println("2. Promedio por examen en la universidad");
                    System.out.println("3. Promedio por sede");
                    System.out.print("Elija una opción: ");
                    int opcionEstadisticas = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer

                    switch (opcionEstadisticas) {
                        case 1:
                            System.out.println("Promedio general: " + universidad.calcularPromedioGeneral());
                            break;
                        case 2:
                            System.out.print("Nombre del examen: ");
                            nombreExamen = scanner.nextLine();
                            System.out.println("Promedio para el examen " + nombreExamen + ": " + universidad.calcularPromedioGeneralExamen(nombreExamen));
                            break;
                        case 3:
                            System.out.print("Nombre de la sede: ");
                            nombreSede = scanner.nextLine();
                            sede = null;
                            for (SedeUniversitaria s : universidad.getSedes()) {
                                if (s.getNombre().equals(nombreSede)) {
                                    sede = s;
                                    break;
                                }
                            }
                            if (sede == null) {
                                System.out.println("Sede no encontrada.");
                                break;
                            }
                            System.out.println("Promedio general de la sede " + nombreSede + ": " + sede.calcularPromedioGeneral());
                            break;
                        default:
                            System.out.println("Opción no válida. Intente nuevamente.");
                    }
                    break;

                case 5:
                System.out.println("Saliendo...");
                    return;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}
