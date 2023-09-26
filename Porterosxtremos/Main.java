//* Authors: Ricardo Godinez
//* Description: Clase principal para ejecutar el programa.
//* Date: 25-sep-2023
//*
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        System.out.println("Bienvenido al sistema del Torneo de Handball");
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        Torneo torneo = new Torneo();
        /**
        * Método principal para ejecutar el programa.
        * @param args Argumentos de la línea de comandos (no se utilizan).
        */
        while (opcion <= 5)
        {
            try {
                System.out.println("Seleccione la opcion en el menú");
                System.out.println("");
                System.out.println("Seleccione 1 para agregar a un Portero");
                System.out.println("");
                System.out.println("Seleccione 2 para agregar a un Extremo");
                System.out.println("");
                System.out.println("Seleccione 3 para mostrar la lista de los jugadores");
                System.out.println("");
                System.out.println("Seleccione 4 para mostrar los top3 mejores Porteros del torneo");
                System.out.println("");
                System.out.println("Seleccione 5 para mostrar los Extremos que sobrepasen un 85% de efectividad");
                System.out.println("");

                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion){
                    case 1:
                        System.out.println("Porfavor ingrese el nombre del jugador");
                        String nombre = sc.nextLine();
                        System.out.println("");
                        System.out.println("Porfavor ingrese el pais del jugador");
                        String pais = sc.nextLine();
                        System.out.println("");
                        System.out.println("Porfavor ingrese el numero de faltas del jugador");
                        int faltas = sc.nextInt();
                        System.out.println("");
                        System.out.println("Porfavor ingrese el numero de goles directos del jugador");
                        int golesDirectos = sc.nextInt();
                        System.out.println("");
                        System.out.println("Porfavor ingrese el numero de total de lanzamientos del jugador");
                        int totalLanzamientos = sc.nextInt();
                        System.out.println("");
                        System.out.println("Porfavor ingrese el numero de paradas efectivas del jugador");
                        int paradasEfectivas = sc.nextInt();
                        System.out.println("");
                        System.out.println("Porfavor ingrese el numero de goles recibidos del jugador");
                        int golesRecibidos = sc.nextInt();
                        System.out.println("");
                        torneo.agregarPortero(nombre, pais, faltas, golesDirectos, totalLanzamientos, paradasEfectivas, golesRecibidos);
                        System.out.println("Portero agregado correctamente :)");
                        break;
                    
                    case 2:
                        System.out.println("Porfavor ingrese el nombre del jugador");
                        nombre = sc.nextLine();
                        System.out.println("");
                        System.out.println("Porfavor ingrese el pais del jugador");
                        pais = sc.nextLine();
                        System.out.println("");
                        System.out.println("Porfavor ingrese el numero de faltas del jugador");
                        faltas = sc.nextInt();
                        System.out.println("");
                        System.out.println("Porfavor ingrese el numero de goles directos del jugador");
                        golesDirectos = sc.nextInt();
                        System.out.println("");
                        System.out.println("Porfavor ingrese el numero de total de lanzamientos del jugador");
                        totalLanzamientos = sc.nextInt();
                        System.out.println("");
                        System.out.println("Porfavor ingrese el numero de pases efectivos del jugador");
                        int pasesEfectivos = sc.nextInt();
                        System.out.println("");
                        System.out.println("Porfavor ingrese el numero de asistencias efectivas del jugador");
                        int asistenciasEfectivas = sc.nextInt();
                        System.out.println("");
                        torneo.agregarExtremo(nombre, pais, faltas, golesDirectos, totalLanzamientos, pasesEfectivos, asistenciasEfectivas);
                        System.out.println("Extremo agregado correctamente :)");
                        break;

                    case 3:
                        torneo.mostrarJugadores();
                        break;

                    case 4:
                        //torneo.mejoresPorteros();
                        break;
                    
                    case 5:
                        torneo.extemosSobre85();
                        break;
                
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Gracias por usar el sistema del Torneo de Handball");
            }
        }
    }
}
