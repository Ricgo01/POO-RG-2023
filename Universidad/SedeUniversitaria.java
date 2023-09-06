import java.util.ArrayList;
import java.util.List;

public class SedeUniversitaria {
    private String nombre;
    private List<Estudiante> estudiantes;

    public SedeUniversitaria(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
    }

    public void registrarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public double calcularPromedioExamen(String nombreExamen) {
        if (estudiantes.isEmpty()) {
            return 0.0;
        }

        double sumaNotas = 0.0;
        int cantidadEstudiantes = 0;

        for (Estudiante estudiante : estudiantes) {
            for (Examen examen : estudiante.getExamenes()) {
                if (examen.getNombre().equals(nombreExamen)) {
                    sumaNotas += examen.getNota();
                    cantidadEstudiantes++;
                }
            }
        }

        if (cantidadEstudiantes == 0) {
            return 0.0;
        }

        return sumaNotas / cantidadEstudiantes;
    }
}
