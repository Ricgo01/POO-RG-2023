
/*
 * Clase Estudiante
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estudiante {
    private String nombre;
    private String apellido;
    private String codigoUnico;
    private String fechaNacimiento;
    private String correoElectronico;
    private List<Examen> examenes;

    public Estudiante(String nombre, String apellido, String codigoUnico, String fechaNacimiento, String correoElectronico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoUnico = codigoUnico;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        this.examenes = new ArrayList<>();
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void agregarExamen(Examen examen) {
        examenes.add(examen);
    }

    public List<Examen> getExamenes() {
        return examenes;
    }

    public double calcularPromedio() {
        double suma = 0;
        for(Examen examen : examenes) {
            suma += examen.getNota();
        }
        return suma / examenes.size();
    }

    public double calcularMediana() {
        int n = examenes.size();
        List<Double> notas = new ArrayList<>();
        for (Examen examen : examenes) {
            notas.add(examen.getNota());
        }
        Collections.sort(notas);
        if (n % 2 != 0) {
            return notas.get(n / 2);
        }
        return (notas.get((n - 1) / 2) + notas.get(n / 2)) / 2.0;
    }

    public double calcularModa() {
        HashMap<Double, Integer> frecuenciaNotas = new HashMap<>();
        for (Examen examen : examenes) {
            frecuenciaNotas.put(examen.getNota(), frecuenciaNotas.getOrDefault(examen.getNota(), 0) + 1);
        }

        int maxFrecuencia = -1;
        double moda = -1;
        for (Map.Entry<Double, Integer> entry : frecuenciaNotas.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                maxFrecuencia = entry.getValue();
                moda = entry.getKey();
            }
        }
        return moda;
    }

    public double calcularDesviacionEstandar() {
        double promedio = calcularPromedio();
        double sum = 0;
        for (Examen examen : examenes) {
            sum += Math.pow(examen.getNota() - promedio, 2);
        }
        return Math.sqrt(sum / examenes.size());
    }
}

