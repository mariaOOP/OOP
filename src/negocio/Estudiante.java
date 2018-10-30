package negocio;

public class Estudiante {

    private String codigo;
    private String nombre;
    private String apellidos;
    private String programa;
    private String direccion;
    private String password;
    private String celular;
    private String email;
    private String nombreFoto;

    public Estudiante(String codigo, String nombre, String apellidos, String programa, String direccion, String password, String celular, String email, String nombreFoto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.programa = programa;
        this.direccion = direccion;
        this.password = password;
        this.celular = celular;
        this.email = email;
        this.nombreFoto = nombreFoto;
    }

    @Override
    public String toString() {
        return this.codigo + "," + this.nombre + "," + this.apellidos + "," + this.programa + "," + this.direccion + "," + this.password + "," + this.celular + "," + this.email + "," + this.nombreFoto;
    }

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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreFoto() {
        return nombreFoto;
    }

    public void setNombreFoto(String nombreFoto) {
        this.nombreFoto = nombreFoto;
    }

}
