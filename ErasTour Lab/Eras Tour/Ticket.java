/*
 *Clase ticket que genera los numeros de boleto y verifica si el usuario califica para comprar un boleto
 */
import java.util.*;
public class Ticket {
    
    //Atributos
    private int numticket;
    private int num2;
    private int num3;
    private Random generador;


    public Ticket(){
    }

    //Metodos
    public void setNum1(int numticket){
        this.numticket = numticket;
    }
    public int getNumticket(){
        return numticket;
    }
    public void setNum2(int num2){
        this.num2 = num2;
    }
    public int getNum2(){
        return num2;
    }
    public void setNum3(int num3){
        this.num3 = num3;
    }
    public int getNum3(){
        return num3;
    }

    public int generarNum2()
    {
        generador = new Random();
        num2 = generador.nextInt(15000-1+1)+1;
        return num2;
    }

    public int generarNum3()
    {
        generador = new Random();
        num3 = generador.nextInt(15000-1+1)+1;
        return num3;
    }

    public int generarNumticket()
    {
        generador = new Random();
        numticket = generador.nextInt(15000-1+1)+1;
        return numticket;
    }

    public void ticket()
    {
        this.numticket = 0;
        this.num2 = 0;
        this.num3 = 0;
    }

    /*
     * Metodo que verifica si el usuario califica para comprar un boleto
     */

    public boolean verificacion1(){
        this.numticket = generarNumticket();
        System.out.println("Su número de boleto es: " + numticket);

        num2 = generarNum2();
        num3 = generarNum3();

        if (num2 > num3)
        {
            if (numticket <= num2 && numticket >= num3)
            {
                System.out.println(num2 + " " + num3);
                System.out.println("---FELICIDADES, usted ha calificado para comprar un boleto---");
                return true;
            }
            else
            {
                System.out.println(num2 + " " + num3);
                System.out.println("Lo sentimos, usted no ha ha calificado para comprar un boleto");
                return false;
            }
        }
        if (num3 > num2)
        {
            if (numticket <= num3 && numticket >= num2)
            {
                System.out.println(num3 + " " + num2);
                System.out.println("---FELICIDADES, usted ha calificado para comprar un boleto---");
                return true;
            }
            else
            {
                System.out.println(num3 + " " + num2);
                System.out.println("Lo sentimos, usted no ha calificado para comprar un boleto");
                return false;
            }
        }
        return false;
    }
}
