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
 * Clase GestorLaboratorio
 * Class que se encarga de gestionar el laboratorio
 *  
 * */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
public class GestorLaboratorio {
    private static Salon lab = new Salon(30); // Suponiendo que hay 30 computadoras en el laboratorio
    private static Scanner scanner = new Scanner(System.in);
    private static List<Profesor> profesores = new ArrayList<>();

    public static void main(String[] args) {
        int opcion = 0;
        do {
            System.out.println("----- Menú de Gestión del Laboratorio CIT 411 -----");
            System.out.println("1. Crear un profesor");
            System.out.println("2. Asignar curso al horario");
            System.out.println("3. Consultar curso en un horario");
            System.out.println("4. Eliminar curso de un horario");
            System.out.println("5. Cambiar horario de un curso");
            System.out.println("6. Resetear horarios para nuevo semestre");
            System.out.println("7. Consultar profesor en un horario");
            System.out.println("8. Mostrar días y horarios de un profesor");
            System.out.println("9. Mostrar responsabilidad de un profesor");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        crearProfesor();
                        break;
                    case 2:
                        asignarCurso();
                        break;
                    case 3:
                        consultarCurso();
                        break;
                    case 4:
                        eliminarCurso();
                        break;
                    case 5:
                        cambiarHorarioCurso();
                        break;
                    case 6:
                        lab.resetHorarios();
                        System.out.println("Horarios reseteados para el nuevo semestre.");
                        break;
                    case 7:
                        consultarProfesor();
                        break;
                    case 8:
                        mostrarDiasProfesor();
                        break;
                    case 9:
                        mostrarResponsabilidadProfesor();
                        break;
                    case 10:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingrese un número válido.");
                scanner.next();  // Limpia el buffer
            }
        } while (opcion != 10);
    }
    private static void crearProfesor() {
        try {
            scanner.nextLine();  // Consume el newline

            System.out.print("Ingrese el nombre del profesor: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el carné del profesor: ");
            int carne = scanner.nextInt();

            scanner.nextLine(); // Consumir el newline
            System.out.print("Ingrese el correo del profesor: ");
            String correo = scanner.nextLine();

            System.out.print("Ingrese el teléfono del profesor: ");
            int telefono = scanner.nextInt();

            Profesor profesor = new Profesor(nombre, carne, correo, telefono);
            profesores.add(profesor);

            System.out.println("Profesor creado exitosamente.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Por favor, ingrese datos válidos.");
            scanner.next();  // Limpia el buffer
        }
    }

    private static void asignarCurso() {
        try {
            scanner.nextLine();  

            System.out.print("Ingrese el nombre del curso: ");
            String nombreCurso = scanner.nextLine();

            System.out.print("Ingrese el código del curso: ");
            String codigoCurso = scanner.nextLine();

            System.out.print("Ingrese la cantidad de periodos: ");
            int periodos = scanner.nextInt();

            System.out.print("Ingrese los días de la semana (ej. Lunes,Martes): ");
            scanner.nextLine(); 
            String diasSemana = scanner.nextLine();

            System.out.print("Ingrese el horario (ej. 7 para 7am): ");
            int horario = scanner.nextInt();

            System.out.print("Ingrese la cantidad de estudiantes: ");
            int cantEstudiantes = scanner.nextInt();

            // Mostrar lista de profesores y permitir que el usuario seleccione uno
            System.out.println("Seleccione un profesor de la lista:");
            for (int i = 0; i < profesores.size(); i++) {
                Profesor profesorActual = profesores.get(i);
                System.out.println((i+1) + ". " + profesorActual.getNombre() + " - " + profesorActual.getCorreo());
            }
            System.out.print("Ingrese el número del profesor: ");
            int indiceProfesor = scanner.nextInt() - 1;

            if (indiceProfesor < 0 || indiceProfesor >= profesores.size()) {
                System.out.println("Selección inválida.");
                return;
            }

            Profesor profesorSeleccionado = profesores.get(indiceProfesor);

            Curso curso = new Curso(nombreCurso, codigoCurso, periodos, diasSemana, horario, cantEstudiantes);
            curso.setProfesor(profesorSeleccionado);

            System.out.print("Ingrese el día (0-Lunes, 1-Martes, ...): ");
            int dia = scanner.nextInt();

            System.out.print("Ingrese el periodo (0-7am, 1-8am, ...): ");
            int periodo = scanner.nextInt();

            if (lab.asignarCurso(dia, periodo, curso)) {
                System.out.println("Curso asignado con éxito.");
            } else {
                System.out.println("Error al asignar el curso.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Por favor, ingrese datos válidos.");
            scanner.next();  // Limpia el buffer
        }
    }

    
    private static void consultarCurso() {
        System.out.print("Ingrese el día: ");
        int dia = scanner.nextInt();
    
        System.out.print("Ingrese el periodo: ");
        int periodo = scanner.nextInt();
    
        Curso curso = lab.consultarCurso(dia, periodo);
        if (curso != null) {
            System.out.println("Curso en el horario seleccionado:");
            System.out.println(curso);
        } else {
            System.out.println("No hay curso programado para el horario seleccionado.");
        }
    }
    
    private static void eliminarCurso() {
        System.out.print("Ingrese el día: ");
        int dia = scanner.nextInt();
    
        System.out.print("Ingrese el periodo: ");
        int periodo = scanner.nextInt();
    
        lab.eliminarCurso(dia, periodo);
        System.out.println("Curso eliminado con éxito.");
    }
    
    private static void cambiarHorarioCurso() {
        System.out.print("Ingrese el día actual: ");
        int diaActual = scanner.nextInt();
    
        System.out.print("Ingrese el periodo actual: ");
        int periodoActual = scanner.nextInt();
    
        System.out.print("Ingrese el nuevo día: ");
        int nuevoDia = scanner.nextInt();
    
        System.out.print("Ingrese el nuevo periodo: ");
        int nuevoPeriodo = scanner.nextInt();
    
        if (lab.cambiarHorarioCurso(diaActual, periodoActual, nuevoDia, nuevoPeriodo)) {
            System.out.println("Horario del curso cambiado con éxito.");
        } else {
            System.out.println("Error al cambiar el horario del curso.");
        }
    }
    
    private static void consultarProfesor() {
        System.out.print("Ingrese el día: ");
        int dia = scanner.nextInt();
    
        System.out.print("Ingrese el periodo: ");
        int periodo = scanner.nextInt();
    
        Profesor profesor = lab.consultarProfesor(dia, periodo);
        if (profesor != null) {
            System.out.println("Profesor en el horario seleccionado:");
            System.out.println(profesor);
        } else {
            System.out.println("No hay profesor programado para el horario seleccionado.");
        }
    }
    private static void mostrarDiasProfesor() {
        scanner.nextLine(); // Consumir el newline
        System.out.print("Ingrese el nombre del profesor: ");
        String nombreProfesor = scanner.nextLine();

        List<String> dias = lab.diasProfesor(nombreProfesor);

        if (dias.isEmpty()) {
            System.out.println("El profesor no tiene horarios asignados.");
        } else {
            System.out.println("Días y horarios del profesor " + nombreProfesor + ":");
            for (String dia : dias) {
                System.out.println(dia);
            }
        }
    }
    private static void mostrarResponsabilidadProfesor() {
        scanner.nextLine(); // Consumir el newline
        System.out.print("Ingrese el nombre del profesor: ");
        String nombreProfesor = scanner.nextLine();

        int veces = lab.vecesProfesor(nombreProfesor);
        double porcentaje = lab.porcentajeResponsabilidad(nombreProfesor);

        System.out.println("El profesor " + nombreProfesor + " está al frente del laboratorio " + veces + " veces.");
        System.out.printf("El profesor tiene un %.2f%% de responsabilidad con respecto al laboratorio.\n", porcentaje);
    }

}
