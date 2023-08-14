/**
 * @author Ricardo Godinez
 * @description Main que contiene el menu principal del programa
 * @date 13/08/2023
 */

import java.util.Scanner;

/*
 * @description Clase Main que contiene el menu principal del programa
 */
public class Main {

    public static void main(String [] args)
    {
        ErasTour erasTour = new ErasTour();
        int opcion = menu();

        if (opcion == 1)
        {
            erasTour.comprar();
            System.out.println("Gracias por usar ErasTour");
            System.out.println("Desea comprar nuevamente? (S/N)");
            Scanner teclado = new Scanner(System.in);
            String opString = teclado.nextLine();
            if (opString.equals("S") || opString.equals("s"))
            {
                main(args);
            }
            else
            {
                System.out.println("Gracias por usar ErasTour");
            }
        }
        else
        {
            System.out.println("Gracias por usar ErasTour");
        }
    }
    /*
     * @description Menu principal del programa
     */
    public static int menu(){

        Scanner teclado = new Scanner(System.in);
        String opString = "";
        boolean bueno = false;
        int opcion = 0;

        while (!bueno)
        {
            System.out.println("Bienvenido a ErasTour");
            System.out.println("1. Comprar boleto");
            System.out.println("2. Salir");
            System.out.println("Ingrese una opción: ");
            opString = teclado.nextLine();

            if (opString.matches("[0-9]*"))
            {
                opcion = Integer.parseInt(opString);
                if (opcion > 0 && opcion < 3)
                {
                    bueno = true;
                }
                else
                {
                    System.out.println("Ingrese una opción válida");
                }
            }
            else
            {
                System.out.println("Ingrese una opción válida");
            }
        }
        return opcion;
    }

}