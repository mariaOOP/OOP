package gestion;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import negocio.Asignatura;


public class GestionAsignaturas 
{
    private ArrayList<Asignatura> misAsignaturas; 
    private String rutaArchivo;
    
    public GestionAsignaturas()
    {
        this.misAsignaturas= new ArrayList(); //inicializacion del contenedor de objetos vacio
        this.rutaArchivo="./archivos/MisAsignaturas.txt"; //rutaRelativa
        this.verificaArchivo();//creacion del archivo con validacion
       
    }   
    
    //crear un metodo que verifique.
    
     public void agregarAsignatura()
     {
         String code, name, cred;
         
         name = JOptionPane.showInputDialog("Digite el nombre de la Asignatura: ");
         cred = JOptionPane.showInputDialog("Digite el numero de créditos: ");
         code= name.substring(0,3)+(int)(Math.random()*900+1);
         
         Asignatura asig = new Asignatura(code, name, cred);
         this.guardaAsignatura(asig);
         System.out.println(asig);
     }
     private void guardaAsignatura (Asignatura asig)
     {
         File file;
         FileWriter fr;
         PrintWriter ps;
         try
         {
             file= new File(this.rutaArchivo);
             fr = new FileWriter(file, true); //true agrega al final, false borra todo y agrega el nuevo
             ps = new PrintWriter(fr);
             ps.println(asig);
             ps.close();
             JOptionPane.showMessageDialog(null, "La asignatura ha sido guardada en la base ");
         }
         catch(IOException ex)
         {
             System.out.println("Problemas al guardar la asignatura");
         }
     }
     
     public void buscarAsignatura()//busca y los muestra
     {
        String code, registro;
        boolean existe=false;
        FileReader file;
        BufferedReader br;
         code = JOptionPane.showInputDialog("Digite el codigo a buscar: ");
         try
         {
             file = new FileReader(this.rutaArchivo);
             br = new BufferedReader(file);
             while((registro=br.readLine())!=null) //mientras haya registros
             {
               String pieces[]= registro.split("s,");
               if(code.equals(pieces[0]))
               {
                   System.out.println(registro);
                   existe=true;
                   break;
               }
             }
              if(!existe)
                JOptionPane.showMessageDialog(null, "ESE CODIGO NO EXISTE...!!!");
        }
         catch(IOException ex)
         {
             System.out.println("problemas buscando la asignatura");
         }
      }
     
     public Asignatura buscarAsignaturaM()//si tenemos que devolver la Asignatura// construye y devuelve la Asignatura
      {
        String code, registro;
        boolean existe=false;
        FileReader file;
        BufferedReader br;
        Asignatura asig=null;
         code = JOptionPane.showInputDialog("Digite el codigo a buscar: ");
         try
         {
             file = new FileReader(this.rutaArchivo);
             br = new BufferedReader(file);
             while((registro=br.readLine())!=null)
             {
               String pieces[]= registro.split(",");
               if(code.equals(pieces[0]))
               {
                   asig= new Asignatura(pieces[0],pieces[1],pieces[2]);
                   existe=true;
                   break;
               }
             }
              if(!existe)
                JOptionPane.showMessageDialog(null, "ESE CODIGO NO EXISTE...!!!");
        }
         catch(IOException ex)
         {
             System.out.println("problemas buscando la asignatura");
         }
         return asig;
     }
     
     
     public void verTodos() //solo para mostrar el listado
     {
        String  registro;
        FileReader file;
        BufferedReader br;
         try
         {
             file = new FileReader(this.rutaArchivo);
             br = new BufferedReader(file);
        
             while((registro=br.readLine())!=null) //mientras haya registros
             {     
                 System.out.print(registro+"\n");
             }
             
         }
         catch(IOException ex)
         {
             System.out.println("problemas buscando la asignatura");
         }
         
         System.out.println("===========================================");
     } 
     
     
     public ArrayList<Asignatura> getTodos() // si se tienen que devolver las Asignaturas
     {
        String registro;
        FileReader file;
        BufferedReader br;
        Asignatura asig;
        ArrayList<Asignatura> terms= new ArrayList();
        
        try
        {    //para encontrar y leer el archivo
             file = new FileReader(this.rutaArchivo);
             br = new BufferedReader(file);
             //validacion que el archivo tenga por los menos una entrada de informacion
              while((registro=br.readLine())!=null)
               {
                String pieces[]= registro.split(",");
                asig= new Asignatura(pieces[0],pieces[1],pieces[2]);
                terms.add(asig);
               } 
        }
         catch(IOException ex)
         {
             System.out.println("problemas buscando la asignatura");
         }
                 return terms;//aqui se debe devolver los objetos que estan dentro de ArrayList
     }
     
      public void eliminarAsignatura()
     {
         String code;
         boolean esta = false;       
         code = JOptionPane.showInputDialog("Digite el codigo a buscar: ");
         ArrayList<Asignatura> misAsignaturas = this.getTodos();
        
         for(Asignatura asig: misAsignaturas)
         {
             if(asig.getCode().equals(code))
             {
                 misAsignaturas.remove(asig);
                 this.reemplazarArchivo(misAsignaturas);
                 JOptionPane.showMessageDialog(null, "OPERACION REALIZADO CON EXITO"); 
                 esta=true;
                 break; 
             }     
         }
         
         if (!esta) 
            JOptionPane.showMessageDialog(null,"Ese codigo no existe");
         
     }
      
      
      
     public void modificarCodes() 
     {
         String code, newCode;
         boolean existe6=false, existe7=false;
         
         code = JOptionPane.showInputDialog("Digite el codigo a buscar: ");
         ArrayList<Asignatura> misAsignaturas = this.getTodos();
         
         for(Asignatura asig: misAsignaturas)
         {
             if(asig.getCode().equals(code))
             {
                 do
                 {
                    newCode = JOptionPane.showInputDialog("Digite el nuevo codigo: ");
                    existe6=this.verificaExistencia(newCode);
                    if(existe6)
                        JOptionPane.showMessageDialog(null, "el codigo ya existe");
                 }
                 while(existe6);   
                 
                 
                 asig.setCode(newCode);
                 this.reemplazarArchivo(misAsignaturas);
                 JOptionPane.showMessageDialog(null, "LA OPERACION SE HIZO CON EXITO");
                 existe7=true;
                 break; 
             }     
             System.out.println("====================");
         }
         
            if (!existe7) 
            {
                JOptionPane.showMessageDialog(null, "ESE CÓDIGO NO EXISTE...!!!");
            }
           
           
     }
     public void modificarName()
     {
         String code, newName;
         boolean existe9=false;
         
         code = JOptionPane.showInputDialog("Digite el codigo a buscar: ");
         ArrayList<Asignatura> misAsignaturas = this.getTodos();
         
         for(Asignatura asig: misAsignaturas)
         {
             if(asig.getCode().equals(code))
             {
                 
                    newName = JOptionPane.showInputDialog("Digite el nuevo nombre: ");
                    asig.setNombres(newName);
                    this.reemplazarArchivo(misAsignaturas);
//                  existe9=this.verificaExistencia(newName);
                    existe9=true;
                     JOptionPane.showMessageDialog(null, "LA OPERACION SE HIZO CON EXITO");
                    break; 
             }     
             System.out.println("====================");
         }
         
         if(!existe9)
            JOptionPane.showMessageDialog(null, "ESE CODIGO NO EXISTE...!!!");
     }
   
     
     public void modificarCreditos()
     {
         String code, newCredit;
         boolean existe10=false;
         ArrayList<Asignatura> misAsignaturas = this.getTodos();
         code = JOptionPane.showInputDialog("Digite el codigo a buscar: ");
         
         for(Asignatura asig: misAsignaturas)
         {
             if(asig.getCode().equals(code))
             {
                 
                    newCredit = JOptionPane.showInputDialog("Digite el nuevo número de creditos : ");
                    asig.setCreditos(newCredit);
                    this.reemplazarArchivo(misAsignaturas);
//                  existe9=this.verificaExistencia(newName);
                    existe10=true;
                     JOptionPane.showMessageDialog(null, "LA OPERACION SE HIZO CON EXITO");
                    break; 
             }     
             System.out.println("====================");
         }
         
         if(!existe10)
            JOptionPane.showMessageDialog(null, "ESE CODIGO NO EXISTE...!!!");
     }
     
     
     //=======================================================================================================================================
     
     public boolean checkExistencias() 
    {
        boolean hay = false;
        FileReader file;
        BufferedReader br;
        try {
            file = new FileReader(this.rutaArchivo);
            br = new BufferedReader(file);
            if (br.readLine() != null) 
            {
                hay = true;
            } else {
                BufferedWriter bw = new BufferedWriter(new FileWriter(this.rutaArchivo));
                bw.write("");
                bw.close();
            }
        } catch (IOException ex) 
        {
            System.out.println("Problemas buscando estudiante...!!");
        }
        return hay;
    }

    private boolean verificaExistencia(String code) 
    {
        boolean existe = false;
        String registro;
        FileReader leedor;
        BufferedReader br;
        try 
        {
            leedor = new FileReader(this.rutaArchivo);
            br = new BufferedReader(leedor);
            while ((registro = br.readLine()) != null)//mientras haya registros
            {

                String pieces[] = registro.split(",");
                if (code.equals(pieces[1])) 
                {
                    existe = true;
                    break;
                }
            }
        } catch (IOException ex) 
        {
            System.out.println("Problemas buscando estudiante...!!");
        }
        return existe;
    }

    private void reemplazarArchivo(ArrayList<Asignatura> terms) 
    {
        File file;
        FileWriter fr;
        PrintWriter ps;
        try 
        {
            file = new File(this.rutaArchivo);
            fr = new FileWriter(file, false);
            ps = new PrintWriter(fr);
            for (Asignatura asig : terms) 
            {
                ps.println(asig);
            }
            ps.close();
        }
        catch (IOException ioe) 
        {
            JOptionPane.showMessageDialog(null, "Error reemplazando archivo..!!");
        }
    }

    private void verificaArchivo() 
    {
        try 
        {
            File filex = new File(this.rutaArchivo);
            if (!filex.exists()) 
            {
                filex.createNewFile();//lo crea
            }
        } catch (IOException ex) 
        {
            System.out.println("Falló búsqueda de ruta..");

        }
    }
}