/*
 * Universidad.java
 */
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

    public List<SedeUniversitaria> getSedes() {
        return sedes;
    }

    public double calcularPromedioGeneralExamen(String nombreExamen) {
        double suma = 0;
        int contador = 0;
        for (SedeUniversitaria sede : sedes) {
            for (Estudiante estudiante : sede.getEstudiantes()) {
                for (Examen examen : estudiante.getExamenes()) {
                    if (examen.getNombre().equals(nombreExamen)) {
                        suma += examen.getNota();
                        contador++;
                    }
                }
            }
        }
        return contador == 0 ? 0 : suma / contador;
    }

    public double calcularPromedioGeneral() {
        double suma = 0;
        int contador = 0;
        for (SedeUniversitaria sede : sedes) {
            for (Estudiante estudiante : sede.getEstudiantes()) {
                for (Examen examen : estudiante.getExamenes()) {
                    suma += examen.getNota();
                    contador++;
                }
            }
        }
        return contador == 0 ? 0 : suma / contador;
    }
}
