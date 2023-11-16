import java.util.Scanner;

/**
 * Clase principal para la gestión de reservas de vuelos con Volaris.
 * 
 * Autor: Ricardo Godinez
 * Fecha: 11/15/23
 * Curso: POO 2023
 * Ejercicio: Lab 5
 * 
 * Esta clase maneja la interacción con el usuario para realizar operaciones
 * como iniciar sesión, crear una cuenta, y manejar reservaciones.
 */

public class Main {

    private static Volaris volaris;
    private static Scanner scanner;

    public static void main(String[] args) {
        volaris = new Volaris();
        scanner = new Scanner(System.in);

        boolean salir = false;
        while (!salir) {
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Crear cuenta");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    iniciarSesion();
                    break;
                case 2:
                    crearCuenta();
                    break;
                case 3:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no reconocida, intente de nuevo.");
                    break;
            }
        }

        scanner.close();
    }

    /**
 * Inicia sesión para un usuario con nombre de usuario y contraseña.
 * Si las credenciales son correctas, muestra el menú principal.
 */

    private static void iniciarSesion() {
        System.out.print("Ingrese nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        String password = scanner.nextLine();

        if (volaris.login(username, password) != null) {
            System.out.println("Inicio de sesión exitoso.");
            mostrarMenuPrincipal();
        } else {
            System.out.println("Credenciales incorrectas, intente de nuevo.");
        }
    }

    /**
 * Crea una nueva cuenta de usuario con un nombre de usuario, contraseña y tipo.
 * Captura excepciones en caso de que el nombre de usuario ya exista.
 */

    private static void crearCuenta() {
        System.out.print("Ingrese nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        String password = scanner.nextLine();
        System.out.print("Ingrese tipo de cuenta (base/premium): ");
        String tipo = scanner.nextLine();

        try {
            volaris.registroUsuario(username, password, tipo);
            System.out.println("Cuenta creada exitosamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear la cuenta: " + e.getMessage());
        }
    }

    /**
 * Muestra el menú principal para el usuario que ha iniciado sesión.
 * Permite realizar diferentes acciones como reservar vuelos y cambiar contraseña.
 */

    private static void mostrarMenuPrincipal() {
        Usuario usuarioActual = volaris.getUsuarioActual();
        boolean volverAlMenu = false;
        while (!volverAlMenu) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Hacer una reserva");
            System.out.println("2. Ver itinerario");
            System.out.println("3. Cambiar contraseña");
    
            if (usuarioActual.getTipo().equals("base")) {
                System.out.println("4. Cambiar tipo de usuario");
                System.out.println("5. Confirmar una reserva");
                System.out.println("6. Aplicar un cupon");
            } else {
                System.out.println("4. Confirmar una reserva");
                System.out.println("5. Mensaje para VIP");
                System.out.println("6. Ventajas de ser VIP");
            }
    
            System.out.println("7. Cerrar sesión");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                realizarReserva();
                break;
            case 2:
                verItinerario();
                break;
            case 3:
                cambiarContraseña();
                break;
            case 4:
                if (usuarioActual.getTipo().equals("base")) {
                    cambiarTipoUsuario();
                } else {
                    confirmarReserva();
                }
                break;
            case 5:
                if (usuarioActual.getTipo().equals("premium")) {
                    System.out.println("Mensaje para VIP: ¡Gracias por ser un usuario premium!");
                } else {
                    confirmarReserva();
                }
                break;
            case 6:
                if (usuarioActual.getTipo().equals("premium")) {
                    System.out.println("Ventajas de ser VIP: ¡Puedes llevar más maletas!");
                } else {
                    System.out.println("Aplicar un cupon: ¡Cupon aplicado!");
                }
                break;
            case 7:
                volverAlMenu = true;
                System.out.println("Cerrando sesión...");
                volaris.logout();
                break;
            default:
                System.out.println("Opción no reconocida, intente de nuevo.");
                break;
            }
        }
    }

    /**
 * Permite al usuario realizar una reserva de vuelo introduciendo los detalles necesarios.
 * Registra la reserva en el sistema.
 */
    private static void realizarReserva() {
        System.out.println("Introduzca los detalles de la reserva:");
        System.out.print("Fecha de vuelo (dd/MM/yyyy): ");
        String fechaVuelo = scanner.nextLine();
        System.out.print("Tipo de vuelo (0 para solo ida, 1 para ida y vuelta): ");
        boolean tipoVuelo = scanner.nextInt() == 1;
        System.out.print("Cantidad de boletos: ");
        int cantidadBoletos = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Aerolínea: ");
        String aerolinea = scanner.nextLine();
    
        volaris.reservacion(fechaVuelo, tipoVuelo, cantidadBoletos, aerolinea, volaris.getUsuarioActual().getUser());
        System.out.println("Reserva realizada exitosamente.");
    }

    /**
 * Confirma una reserva existente, permitiendo al usuario ingresar detalles de pago
 * y preferencias adicionales para la reserva.
 */
    
    private static void confirmarReserva() {
        Usuario usuarioActual = volaris.getUsuarioActual();
    
        System.out.println("Introduzca los detalles para confirmar la reserva:");
        System.out.print("Número de tarjeta: ");
        String numeroTarjeta = scanner.nextLine();
    
        int cuotas = 1;
        String claseVuelo = "primeraclase";
        int cantMaletas = 1;
    
        if (usuarioActual.getTipo().equals("base")) {
            System.out.print("Número de cuotas: ");
            cuotas = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Clase de vuelo: ");
            claseVuelo = scanner.nextLine();
        }
    
        System.out.print("Número de asiento: ");
        String numAsiento = scanner.nextLine();
        if (usuarioActual.getTipo().equals("Premium")) {
            System.out.print("Cantidad de maletas: ");
            cantMaletas = scanner.nextInt();
            scanner.nextLine();
        }
        volaris.confirmacion(numeroTarjeta, cuotas, claseVuelo, numAsiento, cantMaletas);
        System.out.println("Reserva confirmada exitosamente.");
    }

    /**
 * Muestra el itinerario de vuelo del usuario actual, detallando todas las reservas hechas.
 */
    
    private static void verItinerario() {
        String itinerario = volaris.itinerario();
        System.out.println("Itinerario del usuario:");
        System.out.println(itinerario);
    }

    /**
 * Permite al usuario cambiar su contraseña.
 */
    
    private static void cambiarContraseña() {
        System.out.print("Introduzca la nueva contraseña: ");
        String nuevaPassword = scanner.nextLine();
        volaris.cambiarPassword(nuevaPassword);
        System.out.println("Contraseña cambiada exitosamente.");
    }

    /**
 * Cambia el tipo de usuario (base/premium) del usuario actual.
 */
    
    private static void cambiarTipoUsuario() {
        System.out.print("Introduzca el nuevo tipo de usuario (base/premium): ");
        String nuevoTipo = scanner.nextLine();
        volaris.cambiarTipoUsuario(nuevoTipo);
        System.out.println("Tipo de usuario cambiado exitosamente a " + nuevoTipo + ".");
    }
    
}