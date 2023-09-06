import java.util.ArrayList;
import java.util.List;

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

    public void agregarExamen(Examen examen) {
        examenes.add(examen);
    }

    public List<Examen> getExamenes() {
        return examenes;
    }

    public double calcularPromedio() {
        if (examenes.isEmpty()) {
            return 0.0;
        }

        double sumaNotas = 0.0;
        for (Examen examen : examenes) {
            sumaNotas += examen.getNota();
        }

        return sumaNotas / examenes.size();
    }

    public double calcularMediana() {
        if (examenes.isEmpty()) {
            return 0.0;
        }

        examenes.sort((e1, e2) -> Double.compare(e1.getNota(), e2.getNota()));
        int n = examenes.size();

        if (n % 2 == 0) {
            double nota1 = examenes.get(n / 2 - 1).getNota();
            double nota2 = examenes.get(n / 2).getNota();
            return (nota1 + nota2) / 2.0;
        } else {
            return examenes.get(n / 2).getNota();
        }
    }

    public double calcularModa() {
        if (examenes.isEmpty()) {
            return 0.0;
        }

        int maxFrecuencia = 0;
        double moda = 0.0;

        for (Examen examen : examenes) {
            int frecuencia = 0;
            for (Examen otroExamen : examenes) {
                if (examen.getNota() == otroExamen.getNota()) {
                    frecuencia++;
                }
            }

            if (frecuencia > maxFrecuencia) {
                maxFrecuencia = frecuencia;
                moda = examen.getNota();
            }
        }

        return moda;
    }

    public double calcularDesviacionEstandar() {
        if (examenes.isEmpty()) {
            return 0.0;
        }

        double promedio = calcularPromedio();
        double sumaDiferenciasCuadradas = 0.0;

        for (Examen examen : examenes) {
            double diferencia = examen.getNota() - promedio;
            sumaDiferenciasCuadradas += diferencia * diferencia;
        }

        return Math.sqrt(sumaDiferenciasCuadradas / examenes.size());
    }
}
