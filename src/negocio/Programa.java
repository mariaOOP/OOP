package negocio;


public class Programa {
    private String codigo;
    private String nombre;
    private boolean acreditado;
    private boolean presencial;
    private boolean online;

    public Programa(String codigo, String nombre, boolean acreditado, boolean presencial, boolean online) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.acreditado = acreditado;
        this.presencial = presencial;
        this.online = online;
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

    public boolean isAcreditado() {
        return acreditado;
    }

    public void setAcreditado(boolean acreditado) {
        this.acreditado = acreditado;
    }

    public boolean isPresencial() {
        return presencial;
    }

    public void setPresencial(boolean presencial) {
        this.presencial = presencial;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    @Override
    public String toString() {
        return this.codigo+","+this.nombre+","+this.acreditado+","+this.presencial+","+this.online;
       
    }
    
    
    
    
}
