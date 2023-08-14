
/*
 * @(#)ErasTour.java
 * Clase que contiene los metodos para comprar boletos
 */
import java.util.*;

public class ErasTour {
    
    //Atributos
    int opcion2 = 0;
    private Random generador;
    private int num1;

    //metodos
    //getters y setters
    public void setNum1(int num1){
        this.num1 = num1;
    }  
    public int getNum1(){
        return num1;
    }

    public ErasTour(){
        num1 = 0;
    }

    //Metodos
    public void setGenerador(Random generador){
        this.generador = generador;
    }

    public void erasTour(){
        Localidad localidad1 = new Localidad();
        localidad1.setLocalidad("Localidad1");
        localidad1.setPrecio(100);
        localidad1.setDisponibilidad(20);

        Localidad localidad5 = new Localidad();
        localidad5.setLocalidad("Localidad5");
        localidad5.setPrecio(500);
        localidad5.setDisponibilidad(20);

        Localidad localidad10 = new Localidad();
        localidad10.setLocalidad("Localidad10");
        localidad10.setPrecio(1000);
        localidad10.setDisponibilidad(20);

    }

    public int generarNumeroAleatorio()
    {
        generador = new Random();
        num1 = generador.nextInt(3-1+1)+1;
        return num1;
    }

    public void comprar()
    {  
        Localidad localidad1 = new Localidad();
        localidad1.setLocalidad("Localidad1");
        localidad1.setPrecio(100);
        localidad1.setDisponibilidad(20);

        Localidad localidad5 = new Localidad();
        localidad5.setLocalidad("Localidad5");
        localidad5.setPrecio(500);
        localidad5.setDisponibilidad(20);

        Localidad localidad10 = new Localidad();
        localidad10.setLocalidad("Localidad10");
        localidad10.setPrecio(1000);
        localidad10.setDisponibilidad(20);

        Ticket ticket = new Ticket();
        Scanner sc = new Scanner(System.in);
        
        /*
         * Metodo que permite al usuario comprar boletos
         */
         

        while (seguirComprando())
        {

            System.out.println("Binvenido a ErasTour");
            System.out.println("INGRESE SUS DATOS");
            System.out.println("Nombre: ");
            String nombre = sc.nextLine();
            System.out.println("--------------------");
            System.out.println("Email: ");
            String email = sc.nextLine();
            System.out.println("--------------------");
            System.out.println("Cantidad de boletos: ");
            int cantB = sc.nextInt();
            sc.nextLine();
            System.out.println("--------------------");
            System.out.println("Presupuesto: ");
            int presupuesto = sc.nextInt();
            sc.nextLine();
            System.out.println("--------------------");
            Comprador comprador = new Comprador();

            comprador.setNombre(nombre);
            comprador.setEmail(email);
            comprador.setCantB(cantB);
            comprador.setPresupuesto(presupuesto);

            System.out.println("--------------------");
            System.out.println("");
            System.out.println("Bienvenido " + comprador.getNombre() + " a ErasTour");
            System.out.println("");
            System.out.println("--------------------");
            System.out.println("Procederemos a la verificación de los boletos");
            System.out.println("--------------------");
            System.out.println();
            if (ticket.verificacion1() == true )
            {
                System.out.println("Su número de boleto es: " + ticket.getNumticket());
                System.out.println();
                System.out.println("Ahora procederemos a asignarle una localidad");
                System.out.println();
                num1 = generarNumeroAleatorio();

                switch(num1)
                {
                    case 1:
                    {
                        System.out.println("Su localidad es: " + localidad1.getLocalidad());
                        System.out.println();
                        System.out.println("El precio de su localidad es: " + localidad1.getPrecio());
                        System.out.println();
                        System.out.println("La disponibilidad de su localidad es: " + localidad1.getDisponibilidad());
                        System.out.println();
                        System.out.println("¿Desea comprar esta localidad? (1 = si, 2 = no)");
                        int opcion = sc.nextInt();
                        if (opcion == 1)
                        {
                            if (comprador.getPresupuesto() < comprador.getCantB() * localidad1.getPrecio())
                            {
                                System.out.println();
                                System.out.println("No tiene suficiente presupuesto para comprar estos boletos");
                                System.out.println();
                            }

                            else
                            {
                                System.out.println();
                                System.out.println("Su compra ha sido exitosa");
                                System.out.println();
                                System.out.println("Su nuevo presupuesto es: " + (comprador.getPresupuesto() - comprador.getCantB() * localidad1.getPrecio()));
                                System.out.println();
                                System.out.println("La disponibilidad de su localidad es: " + (localidad1.getDisponibilidad() - comprador.getCantB()));
                                localidad1.setDisponibilidad(localidad1.getDisponibilidad() - comprador.getCantB());
                            }
                        }
                        else
                        {
                            System.out.println();
                            System.out.println("Gracias por su visita");
                            System.out.println();
                            opcion2 = 1;
                        }

                        break;
                    }

                    case 2:
                    {
                        System.out.println("Su localidad es: " + localidad5.getLocalidad());
                        System.out.println();
                        System.out.println("El precio de su localidad es: " + localidad5.getPrecio());
                        System.out.println();
                        System.out.println("La disponibilidad de su localidad es: " + localidad5.getDisponibilidad());
                        System.out.println();
                        System.out.println("¿Desea comprar esta localidad? (1 = si, 2 = no)");
                        int opcion = sc.nextInt();
                        if (opcion == 1)
                        {
                            if (comprador.getPresupuesto() < comprador.getCantB() * localidad5.getPrecio())
                            {
                                System.out.println();
                                System.out.println("No tiene suficiente presupuesto para comprar estos boletos");
                                System.out.println();
                            }

                            else
                            {
                                System.out.println();
                                System.out.println("Su compra ha sido exitosa");
                                System.out.println();
                                System.out.println("Su nuevo presupuesto es: " + (comprador.getPresupuesto() - comprador.getCantB() * localidad5.getPrecio()));
                                System.out.println();
                                System.out.println("La disponibilidad de su localidad es: " + (localidad5.getDisponibilidad() - comprador.getCantB()));
                                localidad5.setDisponibilidad(localidad5.getDisponibilidad() - comprador.getCantB());
                            }
                        }
                        else
                        {
                            System.out.println();
                            System.out.println("Gracias por su visita");
                            System.out.println();
                            opcion2 = 1;
                        }

                        break;
                    }

                    case 3: 
                    {
                        System.out.println("Su localidad es: " + localidad10.getLocalidad());
                        System.out.println();
                        System.out.println("El precio de su localidad es: " + localidad10.getPrecio());
                        System.out.println();
                        System.out.println("La disponibilidad de su localidad es: " + localidad10.getDisponibilidad());
                        System.out.println();
                        System.out.println("¿Desea comprar esta localidad? (1 = si, 2 = no)");
                        int opcion = sc.nextInt();
                        if (opcion == 1)
                        {
                            if (comprador.getPresupuesto() < comprador.getCantB() * localidad10.getPrecio())
                            {
                                System.out.println();
                                System.out.println("No tiene suficiente presupuesto para comprar estos boletos");
                                System.out.println();
                            }

                            else
                            {
                                System.out.println();
                                System.out.println("Su compra ha sido exitosa");
                                System.out.println();
                                System.out.println("Su nuevo presupuesto es: " + (comprador.getPresupuesto() - comprador.getCantB() * localidad10.getPrecio()));
                                System.out.println();
                                System.out.println("La disponibilidad de su localidad es: " + (localidad10.getDisponibilidad() - comprador.getCantB()));
                                localidad10.setDisponibilidad(localidad10.getDisponibilidad() - comprador.getCantB());
                            }
                        }
                        else
                        {
                            System.out.println();
                            System.out.println("Gracias por su visita");
                            System.out.println();
                            opcion2 = 1;
                            
                        }

                        break;
                    }
                }
            }
            else
            {
                opcion2 = 1;
            }
        }
    }

    /*
     * Metodo que verifica si el comprador tiene suficiente presupuesto para comprar los boletos
     */


    public boolean seguirComprando(){

        if (opcion2 == 1)
        {
            return false;
        }

        else
        return true;
        
    }
}
