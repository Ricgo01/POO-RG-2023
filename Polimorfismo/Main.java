import java.util.Scanner;
/**
 * Clase principal que proporciona una interfaz de usuario para gestionar un torneo de voleibol.
 * Permite agregar jugadores, mostrarlos, filtrarlos y guardar/cargar datos desde un archivo.
 * Ricardo Arturo Godinez Sanchez
 * #23247
 * POO
 */

public class Main {
    /**
     * Método principal que se ejecuta al iniciar el programa.
     *
     * @param args Argumentos de línea de comandos (no se utilizan en este contexto).
     */
    public static void main(String[] args){

        Torneo torneo = new Torneo();
        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        while (opcion <=5)
        {
            try {
                System.out.println("Bienvenido al programa de voleibol");
                System.out.println("1. Agregar jugador");
                System.out.println("2. Mostrar jugadores");
                System.out.println("3. Mostrar 3 mejores liberos");
                System.out.println("4. Mostrar pasadores con más de 80% de efectividad");
                System.out.println("5. Guardar catálogo en un archivo csv.");
                System.out.println("6. Cargar catálogo de un archivo csv.");
                System.out.println("7. Salir");

                opcion = sc.nextInt();
                sc.nextLine();

                switch(opcion){
                    case 1:
                        System.out.println("Ingrese el tipo de jugador a ingresar, 1 para pasador, 2 para auxiliar y 3 para libero");
                        int tipo = 0;
                        tipo = sc.nextInt();
                        sc.nextLine();
                        if (tipo == 1)
                        {
                            int tipoJugador = 1;
                            System.out.println("Ingrese el nombre del jugador");
                            String nombre = sc.nextLine();
                            System.out.println("Ingrese el país del jugador");
                            String pais = sc.nextLine();
                            System.out.println("Ingrese la cantidad de errores del jugador");
                            int errores = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Ingrese la cantidad de aces del jugador");
                            int aces = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Ingrese la cantidad de servicios totales del jugador");
                            int totalServicios = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Ingrese la cantidad de pases efectivos del jugador");
                            int pases = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Ingrese la cantidad de fintas efectivas del jugador");
                            int fintasEfectivas = sc.nextInt();
                            sc.nextLine();
                            torneo.agregarJugador(nombre, pais, errores, aces, totalServicios, pases, fintasEfectivas, 0, tipoJugador);
                        }
                        else if (tipo == 2)
                        {
                            int tipoJugador = 2;
                            System.out.println("Ingrese el nombre del jugador");
                            String nombre = sc.nextLine();
                            System.out.println("Ingrese el país del jugador");
                            String pais = sc.nextLine();
                            System.out.println("Ingrese la cantidad de errores del jugador");
                            int errores = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Ingrese la cantidad de aces del jugador");
                            int aces = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Ingrese la cantidad de servicios totales del jugador");
                            int totalServicios = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Ingrese la cantidad de ataques efectivos del jugador");
                            int ataquesEfectivos = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Ingrese la cantidad de bloqueos efectivos del jugador");
                            int bloqueosEfectivos = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Ingrese la cantidad de bloqueos fallidos del jugador");
                            int bloqueosFallidos = sc.nextInt();
                            sc.nextLine();
                            torneo.agregarJugador(nombre, pais, errores, aces, totalServicios, ataquesEfectivos, bloqueosEfectivos, bloqueosFallidos, tipoJugador);
                        }

                        else if (tipo == 3)
                        {
                            int tipoJugador = 3;
                            System.out.println("Ingrese el nombre del jugador");
                            String nombre = sc.nextLine();
                            System.out.println("Ingrese el país del jugador");
                            String pais = sc.nextLine();
                            System.out.println("Ingrese la cantidad de errores del jugador");
                            int errores = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Ingrese la cantidad de aces del jugador");
                            int aces = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Ingrese la cantidad de servicios totales del jugador");
                            int totalServicios = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Ingrese la cantidad de bloqueos efectivos del jugador");
                            int bloqueosEfectivos = sc.nextInt();
                            sc.nextLine();
                            torneo.agregarJugador(nombre, pais, errores, aces, totalServicios, 0, bloqueosEfectivos, 0, tipoJugador);
                        }
                        break;

                    case 2: 
                        torneo.mostrarJugadores();
                        break;

                    case 3:
                        torneo.mostrarTresMejoresLiberos();
                        break;

                    case 4:
                        torneo.mostrarPasadoresMayorOchentaPorciento();
                        break;

                    case 5:
                    try {
                        torneo.guardarEnArchivo();
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println("Hubo un problema al crear el archivo");
                    }
                        break;

                    case 6: 
                        try {
                            torneo.cargarArchivo();
                        } catch (Exception e) {

                            System.out.println("Hubo un problema al cargar el archivo");
                        }
                        break;
                }
    
            }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            } finally {
            System.out.println("Gracias por usar el sistema del Torneo de Volleyball");
            }
        }
    }
}
