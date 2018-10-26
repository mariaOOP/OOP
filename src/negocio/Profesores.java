
package negocio;

public class Profesores 
{
    private String iden;
    private String  name, ape;
    private String [] cursos;
    
    public Profesores()
    {
        this.iden = "";
        this.name = "";
        this.ape = ""; 
    }
    public Profesores(String iden, String name, String ape, String [] cursos) 
    {
        this.iden = iden;
        this.name = name;
        this.ape = ape;
        this.cursos=cursos;
    }

    public String getIden() 
    {
        return iden;
    }

    public void setIden(String iden) 
    {
        this.iden = iden;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getApe() 
    {
        return ape;
    }

    public void setApe(String ape) 
    {
        this.ape = ape;
    }

    public String[] getCursos() 
    {
        return cursos;
    }

    public void setCursos(String[] cursos) 
    {
        this.cursos = cursos;
    }
    
    public String toString() 
    {
        return  iden + "," + name + "," + ape+","+cursos ;
    }
    
}
