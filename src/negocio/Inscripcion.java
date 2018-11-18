package negocio;

public class Inscripcion {
    private String idEstudiante;
    private String idProfesor;
    private String idAsignatura;

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(String idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Inscripcion(String idEstudiante, String idAsignatura,String idProfesor) {
        this.idEstudiante = idEstudiante;
        this.idProfesor = idProfesor;
        this.idAsignatura = idAsignatura;
    }

    @Override
    public String toString() {
        return idEstudiante + "," + idAsignatura + "," + idProfesor;
    }
    
}
