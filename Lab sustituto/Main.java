import java.util.Scanner;

/**
 * La clase Main es el punto de entrada del juego de rol. Contiene el método principal
 * y maneja el menú inicial del juego, permitiendo a los jugadores comenzar un nuevo juego o salir.
 * Ricardo Arturo Godinez Sanchez
 * 23247
 * POO 2023
 */
public class Main {
    /**
     * El punto de entrada principal para la aplicación.
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        Juego juego = new Juego();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Bienvenido al juego de rol!");
        
        boolean salir = false;
        while (!salir) {
            System.out.println("Menú Principal:");
            System.out.println("1. Iniciar Juego");
            System.out.println("2. Salir");
            System.out.print("Elige una opción: ");
            
            int eleccion = scanner.nextInt();
            
            switch (eleccion) {
                case 1:
                    juego.jugar();
                    break;
                case 2:
                    salir = true;
                    System.out.println("Gracias por jugar. ¡Hasta la próxima!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
                    break;
            }
        }
        
        scanner.close();
    }
}
