/*
 * POO 2 Semestre
 * Facultad de Ingenieria
 * Departamento de Ciencias de la Computacion
 * Fecha inicio: 11/09/2023
 * Fecha final: 12/09/2023
 *
 * @author Ricardo Godinez 
 * 23247
 * 
 * Clase Salon
 * 
 * Esta clase se encarga de crear un objeto de tipo Salon
 *  
 * */

import java.util.ArrayList;
import java.util.List;
public class Salon {
    private Curso[][] horarios = new Curso[7][14];
    private int capacidad;

    public Salon(int capacidad) {
        this.capacidad = capacidad;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 14; j++) {
                horarios[i][j] = null;
            }
        }
    }

    public boolean asignarCurso(int dia, int periodo, Curso curso) {
        if (horarios[dia][periodo] != null) {
            return false;
        }
        if (curso.getCantEstudiantes() > capacidad) {
            System.out.println("La cantidad de estudiantes inscritos es mayor que la capacidad del laboratorio.");
            return false;
        }
        if (curso.getCantEstudiantes() > 2 * capacidad) {
            System.out.println("No se puede asignar el curso, hay más de 2 estudiantes por computadora.");
            return false;
        }
        horarios[dia][periodo] = curso;
        return true;
    }

    public Curso consultarCurso(int dia, int periodo) {
        return horarios[dia][periodo];
    }

    public void eliminarCurso(int dia, int periodo) {
        horarios[dia][periodo] = null;
    }

    public boolean cambiarHorarioCurso(int diaActual, int periodoActual, int nuevoDia, int nuevoPeriodo) {
        if (horarios[nuevoDia][nuevoPeriodo] != null) {
            return false;
        }
        horarios[nuevoDia][nuevoPeriodo] = horarios[diaActual][periodoActual];
        eliminarCurso(diaActual, periodoActual);
        return true;
    }

    public void resetHorarios() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 14; j++) {
                horarios[i][j] = null;
            }
        }
    }

    public Profesor consultarProfesor(int dia, int periodo) {
        if (horarios[dia][periodo] == null) {
            return null;
        }
        return horarios[dia][periodo].getProfesor();
    }
    public List<String> diasProfesor(String nombreProfesor) {
        List<String> dias = new ArrayList<>();
        String[] nombresDias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        for(int i = 0; i < 7; i++) {
            for(int j = 0; j < 14; j++) {
                if (horarios[i][j] != null && horarios[i][j].getProfesor().getNombre().equals(nombreProfesor)) {
                    dias.add(nombresDias[i] + " - " + (j + 7) + ":00");
                }
            }
        }
        return dias;
    }
    
    public int vecesProfesor(String nombreProfesor) {
        int veces = 0;
        for(int i = 0; i < 7; i++) {
            for(int j = 0; j < 14; j++) {
                if (horarios[i][j] != null && horarios[i][j].getProfesor().getNombre().equals(nombreProfesor)) {
                    veces++;
                }
            }
        }
        return veces;
    }
    
    public double porcentajeResponsabilidad(String nombreProfesor) {
        int totalHorarios = 7 * 14;
        int veces = vecesProfesor(nombreProfesor);
        return (double) veces / totalHorarios * 100;
    }
}
