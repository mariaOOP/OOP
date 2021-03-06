package negocio;


public class Asignatura {
    private String codigo;
    private String nombre;
    private String creditos;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCreditos() {
        return creditos;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    public Asignatura(String codigo, String nombre, String creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return codigo + "," + nombre + "," + creditos;
    }
    
}
