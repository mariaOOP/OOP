package negocio;

public class Estudiante
{
    private String codigo, nombre, apellidos; private char genero; private String telefono;
    
    
    public Estudiante()
{
    this.codigo = ""; this.nombre = ""; this.apellidos = ""; this.genero = '*'; this.telefono = "";
}
    
public Estudiante(String codigo, String nombre, String apellidos, char genero, String telefono) 
{   
    this.codigo = codigo;
    this.nombre = nombre; this.apellidos = apellidos; this.genero = genero; this.telefono = telefono;
}
public String getCodigo() 
{ 
    return codigo;
}
 
public String getNombre() 
{ 
    return nombre;
}

public String getApellidos() 
{ 
    return apellidos;
}

public char getGenero() { return genero;
}

public String getTelefono() 
{ 
    return telefono;
}

public void setCodigo(String codigo) 
{ 
    this.codigo = codigo;
}

public void setNombre(String nombre) 
{ 
    this.nombre = nombre;
}

public void setApellidos(String apellidos) 
{ 
    this.apellidos = apellidos;
}

public void setGenero(char genero) 
{ 
    this.genero = genero;
}
 
public void setTelefono(String telefono) 
{ 
    this.telefono = telefono;
}

public String toString()
{
    return this.codigo+","+this.nombre+","+this.apellidos+","+this.genero+","+this.telefono;
}

}

