package negocio;

public class Asignatura 
{
    private String codigo; 
    private String nombre; 
    private String creditos; 
    
    public Asignatura()
    {
        this.codigo = ""; this.nombre = ""; this.creditos = ""; ;
    }

    public Asignatura(String codigo, String nombre, String creditos) 
    {   
        this.codigo = codigo;
        this.nombre = nombre; 
        this.creditos = creditos;
        
    }

    public String getCode() 
    {
        return codigo;
    }

    public void setCode(String codigo) 
    {
        this.codigo = codigo;
    }

    public String getNombres() 
    {
        return nombre;
    }

    public void setNombres(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getCreditos() 
    {
        return creditos;
    }

    public void setCreditos(String creditos) 
    {
        this.creditos = creditos;
    }

   
    
    
    
    
    public String toString()
    {
        return this.codigo+", "+this.nombre+", "+this.creditos+" creditos";
    }
    
    
    
    
    
 }


