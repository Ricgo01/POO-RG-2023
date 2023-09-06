import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Examen {
    private String nombre;
    private double nota;

    public Examen(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public double getNota() {
        return nota;
    }
}
