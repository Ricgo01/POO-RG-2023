import java.util.Scanner;
import java.util.List;

/**
 * Clase Main que proporciona una interfaz de usuario para gestionar y controlar dispositivos.
 * Ricardo Arturo Godinez Sanchez
 * 23247
 * POO 2023
 * 10/30/2023
 */
public class Main{

     /**
     * Punto de entrada principal para la aplicación.
     * 
     * @param args Argumentos de la línea de comandos. No se utilizan en esta aplicación.
     */

    public static void main(String[] args) {
        boolean op1 = true;
        boolean op2 = true;
        Tienda tienda = new Tienda();
        Scanner sc = new Scanner(System.in);
        while (op1 == true) {
        System.out.println("Bienvenido a la aplicacion de Control de dispostivos de ElectroTech");
        System.out.println("Seleccione 1 para cargar los dispositivos");
        System.out.println("Seleccione 2 para comparar los dispositivos");
        System.out.println("Seleccione 3 para seleccionar un dispositivo y controlarlo");
        System.out.println("Seleccione 4 para salir");

        int opcion = sc.nextInt();
        sc.nextLine();
            switch (opcion){
                case 1:
                // Carga de dispositivos desde un archivo
                System.out.println("Cargando archivo......");
                tienda.cargarDispositivos("dispositivos.csv");
                List<Dispositivo> electronicos = tienda.getElectronicos();

                if (electronicos != null && !electronicos.isEmpty()){
                    System.out.println("Archivo cargado con exito");

                    for (Dispositivo dispositivo : electronicos){
                        System.out.println(dispositivo.toString());
                    }

                } else {
                    System.out.println("No se pudo cargar el archivo");
                }
                break;

                case 2:
                // Comparación de dispositivos
                    System.out.println("Seleccione la clase de dispositivos que quiera comparar PC o Telefono");
                    String tipo = sc.nextLine();
                    switch (tipo) {
                        case "PC":
                            Dispositivo pcMasCaro = tienda.PcMasCara();
                            System.out.println("Comparador de PC");
                            if (pcMasCaro != null) {
                                System.out.println("El PC con el precio más alto es: ");
                                System.out.println(pcMasCaro.toString());
                            } else {
                                System.out.println("No hay PCs en la tienda.");
                            }
                            break;
                        case "Telefono":
                            Dispositivo telefonoMasCaro = tienda.TelefonoMasCaro();
                            System.out.println("Comparador de Telefono");
                            if (telefonoMasCaro != null) {
                                System.out.println("El Telefono con el precio más alto es: ");
                                System.out.println(telefonoMasCaro.toString());
                            } else {
                                System.out.println("No hay Telefonos en la tienda.");
                            }
                            break;    
                    
                        default:
                            System.out.println("No se reconoce el tipo de dispositivo");
                            break;
                        }   
                case 3:
                 // Control de un dispositivo seleccionado
                while (op2 == true) {
                    System.out.println("Seleccione la marca del dispositivo");
                    String marca = sc.nextLine();
                    System.out.println("Seleccione el modelo del dispositivo");
                    int modelo = sc.nextInt();
                    sc.nextLine();
                    tienda.setSeleccionarDispositivo(marca, modelo);
                        System.out.println("Dispositivo seleccionado");
                        System.out.println("El dispositivo seleccionado es: " + tienda.getSeleccionarDispositivo().toString());
                        System.out.println("Seleccione 1 para encender el dispositivo");
                        System.out.println("Seleccione 2 para apagar el dispositivo");
                        System.out.println("Seleccione 3 para subir el volumen del dispositivo");
                        System.out.println("Seleccione 4 para bajar el volumen del dispositivo");
                        System.out.println("Seleccione 5 para subir el brillo del dispositivo");
                        System.out.println("Seleccione 6 para bajar el brillo del dispositivo");
                        System.out.println("Seleccione 7 para dale play al video del dispositivo");
                        System.out.println("Seleccione 8 para pausar el video del dispositivo");
                        System.out.println("Seleccione 9 para detener el video del dispositivo");
                        System.out.println("Seleccione 10 para mostrar la informacion del dispositivo");
                        System.out.println("Seleccione 11 para mostrar el estado del dispositivo");
                        System.out.println("Seleccione 12 para salir del dispositivo");
                        int opcion2 = sc.nextInt();
                        sc.nextLine();
                        Dispositivo dispositivoSeleccionado = tienda.getSeleccionarDispositivo();

                        switch (opcion2) {
                            case 1:
                            if (dispositivoSeleccionado instanceof Telefono) {
                                ((Telefono) dispositivoSeleccionado).encender();
                            } 
                            else if (dispositivoSeleccionado instanceof PC) {
                                ((PC) dispositivoSeleccionado).encender();
                            }
                                break;
                            
                            case 2:
                            if (dispositivoSeleccionado instanceof Telefono) {
                                ((Telefono) dispositivoSeleccionado).apagar();
                            } 
                            else if (dispositivoSeleccionado instanceof PC) {
                                ((PC) dispositivoSeleccionado).apagar();
                            }
                                break;

                            case 3:
                            if (dispositivoSeleccionado instanceof Telefono) {
                                ((Telefono) dispositivoSeleccionado).volumenUp();
                            } 
                            else if (dispositivoSeleccionado instanceof PC) {
                                ((PC) dispositivoSeleccionado).volumenUp();
                            }
                                break;

                            case 4:
                            if (dispositivoSeleccionado instanceof Telefono) {
                                ((Telefono) dispositivoSeleccionado).volumenDown();
                            } 
                            else if (dispositivoSeleccionado instanceof PC) {
                                ((PC) dispositivoSeleccionado).volumenDown();
                            }
                                break;

                            case 5:
                            if (dispositivoSeleccionado instanceof Telefono) {
                                ((Telefono) dispositivoSeleccionado).brilloUp();
                            } 
                            else if (dispositivoSeleccionado instanceof PC) {
                                ((PC) dispositivoSeleccionado).brilloUp();
                            }
                                break;
                            
                            case 6:
                            if (dispositivoSeleccionado instanceof Telefono) {
                                ((Telefono) dispositivoSeleccionado).brilloDown();
                            } 
                            else if (dispositivoSeleccionado instanceof PC) {
                                ((PC) dispositivoSeleccionado).brilloDown();
                            }
                                break;

                            case 7:
                            if (dispositivoSeleccionado instanceof Telefono) {
                                ((Telefono) dispositivoSeleccionado).play();
                            } 
                            else if (dispositivoSeleccionado instanceof PC) {
                                ((PC) dispositivoSeleccionado).play();
                            }
                                break;
                            
                            case 8:
                            if (dispositivoSeleccionado instanceof Telefono) {
                                ((Telefono) dispositivoSeleccionado).pause();
                            } 
                            else if (dispositivoSeleccionado instanceof PC) {
                                ((PC) dispositivoSeleccionado).pause();
                            }
                                break;

                            case 9:
                            if (dispositivoSeleccionado instanceof Telefono) {
                                ((Telefono) dispositivoSeleccionado).stop();
                            } 
                            else if (dispositivoSeleccionado instanceof PC) {
                                ((PC) dispositivoSeleccionado).stop();
                            }
                                break;

                            case 10:
                            if (dispositivoSeleccionado instanceof Telefono) {
                                ((Telefono) dispositivoSeleccionado).mostrarInfo();
                            } 
                            else if (dispositivoSeleccionado instanceof PC) {
                                ((PC) dispositivoSeleccionado).mostrarInfo();
                            }
                                break;

                            case 11:
                            if (dispositivoSeleccionado instanceof Telefono) {
                                ((Telefono) dispositivoSeleccionado).mostrarEstado();
                            } 
                            else if (dispositivoSeleccionado instanceof PC) {
                                ((PC) dispositivoSeleccionado).mostrarEstado();
                            }
                                break;
                        
                            case 12:
                                op2 = false;
                                break;
                        }   
                    }
                case 4:
                // Salir de la aplicación
                    System.out.println("Gracias por usar la aplicacion");
                    System.exit(0);
                    break;
            }
        }
        sc.close();
    }
}
