import java.util.Scanner;

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
    
    private static void verItinerario() {
        String itinerario = volaris.itinerario();
        System.out.println("Itinerario del usuario:");
        System.out.println(itinerario);
    }
    
    private static void cambiarContraseña() {
        System.out.print("Introduzca la nueva contraseña: ");
        String nuevaPassword = scanner.nextLine();
        volaris.cambiarPassword(nuevaPassword);
        System.out.println("Contraseña cambiada exitosamente.");
    }
    
    private static void cambiarTipoUsuario() {
        System.out.print("Introduzca el nuevo tipo de usuario (base/premium): ");
        String nuevoTipo = scanner.nextLine();
        volaris.cambiarTipoUsuario(nuevoTipo);
        System.out.println("Tipo de usuario cambiado exitosamente a " + nuevoTipo + ".");
    }
    
}