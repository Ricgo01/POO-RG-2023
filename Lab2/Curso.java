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
 * Clase Curso
 * 
 * Esta clase se encarga de crear un objeto de tipo Curso
 *  
 * */

public class Curso {
    private String nombre;
    private String codigo;
    private int periodos;
    private String diasSemana;
    private int horario;
    private int cantEstudiantes;
    Profesor profesor;

    public Curso(){
        this.nombre = "";
        this.codigo = "";
        this.periodos = 0;
        this.diasSemana = "";
        this.horario = 0;
        this.cantEstudiantes = 0;
    }

    public Curso(String nombre, String codigo, int periodos, String diasSemana, int horario, int cantEstudiantes) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.periodos = periodos;
        this.diasSemana = diasSemana;
        this.horario = horario;
        this.cantEstudiantes = cantEstudiantes;
    }

    // Getters
    public String getNombre() {
        return this.nombre;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public int getPeriodos() {
        return this.periodos;
    }

    public String getDiasSemana() {
        return this.diasSemana;
    }

    public int getHorario() {
        return this.horario;
    }

    public int getCantEstudiantes() {
        return this.cantEstudiantes;
    }

    public Profesor getProfesor() {
        return this.profesor;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setPeriodos(int periodos) {
        this.periodos = periodos;
    }

    public void setDiasSemana(String diasSemana) {
        this.diasSemana = diasSemana;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public void setCantEstudiantes(int cantEstudiantes) {
        this.cantEstudiantes = cantEstudiantes;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", codigo='" + getCodigo() + "'" +
            ", periodos='" + getPeriodos() + "'" +
            ", diasSemana='" + getDiasSemana() + "'" +
            ", horario='" + getHorario() + "'" +
            ", cantEstudiantes='" + getCantEstudiantes() + "'" +
            ", profesor='" + getProfesor() + "'" +
            "}";
    }
}