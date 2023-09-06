import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private List<SedeUniversitaria> sedes;

    public Universidad() {
        this.sedes = new ArrayList<>();
    }

    public void agregarSede(SedeUniversitaria sede) {
        sedes.add(sede);
    }

    public double calcularPromedioGeneralExamen(String nombreExamen) {
        if (sedes.isEmpty()) {
            return 0.0;
        }

        double sumaNotas = 0.0;
        int cantidadEstudiantes = 0;

        for (SedeUniversitaria sede : sedes) {
            for (Estudiante estudiante : sede.getEstudiantes()) {
                for (Examen examen : estudiante.getExamenes()) {
                    if (examen.getNombre().equals(nombreExamen)) {
                        sumaNotas += examen.getNota();
                        cantidadEstudiantes++;
                    }
                }
            }
        }

        if (cantidadEstudiantes == 0) {
            return 0.0;
        }

        return sumaNotas / cantidadEstudiantes;
    }
}
