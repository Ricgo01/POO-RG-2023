/*
 * Clase Localidad que contiene los atributos de las localidades
 */

import java.util.Random;

public class Localidad {
    public Localidad(){
    }

    //Atributos
    private String localidad;
    private int precio;
    private int disponibilidad;
    private int num1;
    private Random generador;

    //Metodos
    public void setLocalidad(String localidad){
        this.localidad = localidad;
    }
    public String getLocalidad(){
        return localidad;
    }
    public void setPrecio(int precio){
        this.precio = precio;
    }
    public int getPrecio(){
        return precio;
    }
    public void setDisponibilidad(int disponibilidad){
        this.disponibilidad = disponibilidad;
    }
    public int getDisponibilidad(){
        return disponibilidad;
    }

    public int generarNum1()
    {
        generador = new Random();
        num1 = generador.nextInt(3-1+1)+1;
        return num1;
    }

    public void localidad()
    {
        this.localidad = "";
        this.precio = 0;
        this.disponibilidad = 0;
    }


}
