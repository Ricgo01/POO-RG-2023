/*
 * SedeUniversitaria.java
 */
import java.util.ArrayList;
import java.util.List;

public class SedeUniversitaria {
    private String nombre;
    private List<Estudiante> estudiantes;

    public SedeUniversitaria(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void registrarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public double calcularPromedioExamen(String nombreExamen) {
        double suma = 0;
        int contador = 0;
        for (Estudiante estudiante : estudiantes) {
            for (Examen examen : estudiante.getExamenes()) {
                if (examen.getNombre().equals(nombreExamen)) {
                    suma += examen.getNota();
                    contador++;
                }
            }
        }
        return contador == 0 ? 0 : suma / contador;
    }

    public double calcularPromedioGeneral() {
        double suma = 0;
        int contador = 0;
        for (Estudiante estudiante : estudiantes) {
            for (Examen examen : estudiante.getExamenes()) {
                suma += examen.getNota();
                contador++;
            }
        }
        return contador == 0 ? 0 : suma / contador;
    }
}
