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
import negocio.Estudiante;



public class GestionEstudiantes 
{
   private String rutArchivo;

    public GestionEstudiantes() 
    {
        this.rutArchivo = "./archivos/misEstudiantes.txt";
        this.verificaArchivo();
    }


    public void agregarEstudiante() 
    {
        String code, name, apes, tele;
        char gendre;
        boolean existe = false;
        //capturar información del estudiante
        do {
            code = JOptionPane.showInputDialog("Digite el código:");
            existe = this.verificaExistencia(code);
            if (existe) 
            {
                JOptionPane.showMessageDialog(null, "ESE CODIGO YA EXISTE..!!!");
            }
        } while (existe);
        
        name = JOptionPane.showInputDialog("Digite el nombre:");
        apes = JOptionPane.showInputDialog("Digite los apellidos:");
        gendre = JOptionPane.showInputDialog("Digite el género:").charAt(0);
        tele = JOptionPane.showInputDialog("Digite el teléfono:");
        //Crear al estudiante
        Estudiante stud = new Estudiante(code, name, apes, gendre, tele);
        //Guardar al estudiante en el archivo
        this.guardaEstudiante(stud);
        System.out.println(stud
        
        );
                
    }

    private void guardaEstudiante(Estudiante stud) 
    {
        File file;
        FileWriter fr;
        PrintWriter ps;
        try 
        {
            file = new File(this.rutArchivo);
            fr = new FileWriter(file, true); //true agrega al final, false borra todo y agrega el nuevo
            ps = new PrintWriter(fr);
            ps.println(stud);
            ps.close();
            JOptionPane.showMessageDialog(null, "El Estudiante ha sido guardado en la base..!!");
        } catch (IOException ex) 
        {
            System.out.println("Problemas guardando estudiante...!!");
        }
    }

    public void buscarEstudiante()//Si es solo mostrarlo
    {
        String code, registro;

        boolean existe = false;
        FileReader file;
        BufferedReader br;
        code = JOptionPane.showInputDialog("Digite el código a buscar:");
        try 
        {
            file = new FileReader(this.rutArchivo);
            br = new BufferedReader(file);
            while ((registro = br.readLine()) != null)//mientras haya registros
            {
                String pieces[] = registro.split(",");
                if (code.equals(pieces[0])) 
                {
                    System.out.println(registro);
                    existe = true;
                    break;
                }
            }
            if (!existe) 
            {
                JOptionPane.showMessageDialog(null, "ESE CÓDIGO NO EXISTE...!!!");
            }
        } catch (IOException ex) 
        {
            System.out.println("Problemas buscando estudiante...!!");
        }
    }
   
    public void verTodos()//si es solo mostrar listado
    {
        String code, registro;
        FileReader file;
        BufferedReader br;
        try 
        {
            file = new FileReader(this.rutArchivo);
            br = new BufferedReader(file);
            while ((registro = br.readLine()) != null)//mientras haya registros
            {
                System.out.println(registro);
            }
        } catch (IOException ex) 
        {
            System.out.println("Problemas buscando estudiante...!!");
        }
        System.out.println("===========================================");
    }

    public ArrayList<Estudiante> getTodos()//si tenemos que devolver los estudiantes
    {
        String code, registro;
        FileReader file;
        BufferedReader br;
        Estudiante stud;
        ArrayList<Estudiante> students = new ArrayList();
        try 
        {
            file = new FileReader(this.rutArchivo);
            br = new BufferedReader(file);
            while ((registro = br.readLine()) != null)//mientras haya registros
            {
                String pieces[] = registro.split(",");
                stud = new Estudiante(pieces[0], pieces[1], pieces[2], pieces[3].charAt(0), pieces[4]);
                students.add(stud);
            }
        } catch (IOException ex) {
            System.out.println("Problemas buscando estudiante...!!");
        }
        return students;
    }

    public void eliminarEstudiante() 
    {
        String code, newCode;
        boolean esta = false;
        code = JOptionPane.showInputDialog("Digite el código a buscar:");
        ArrayList<Estudiante> misEstudiantes = this.getTodos();
        for (Estudiante stud : misEstudiantes) 
        {
            if (stud.getCodigo().equals(code)) 
            {
                misEstudiantes.remove(stud);
                this.reemplazaArchivo(misEstudiantes);
                JOptionPane.showMessageDialog(null, "LA OPERACIÓN SE HIZO CON ÉXITO...!!!");
                esta = true;
                break;
            }
        }
        if (!esta) 
        {
            JOptionPane.showMessageDialog(null, "ESE CÓDIGO NO EXISTE...!!!");
        }
    }

    public void modificarCodigo() 
    {
        String code, newCode;
        boolean esta = false, existe = false;
        code = JOptionPane.showInputDialog("Digite el código a buscar:");
        ArrayList<Estudiante> misEstudiantes = this.getTodos();
        for (Estudiante stud : misEstudiantes) 
        {
            if (stud.getCodigo().equals(code)) 
            {
//modificarlo,validar que no exista..
                do 
                {
                    newCode = JOptionPane.showInputDialog("Digite el nuevo código:");
                    existe = this.verificaExistencia(newCode);
                    if (existe) 
                    {
                        JOptionPane.showMessageDialog(null, "ESE CODIGO YA EXISTE..!!!");
                    }
                } while (existe);
                stud.setCodigo(newCode);
                this.reemplazaArchivo(misEstudiantes);
                JOptionPane.showMessageDialog(null, "LA OPERACIÓN SE HIZO CON ÉXITO...!!!");
                esta = true;
                break;
            }
        }
        if (!esta) 
        {
            JOptionPane.showMessageDialog(null, "ESE CÓDIGO NO EXISTE...!!!");
        }
    }

    public void modificarNombre() 
    {
        String code, newCode;
        boolean esta = false;
        code = JOptionPane.showInputDialog("Digite el código a buscar:");
        ArrayList<Estudiante> misEstudiantes = this.getTodos();
        for (Estudiante stud : misEstudiantes) 
        {
            if (stud.getCodigo().equals(code)) 
            {
                newCode = JOptionPane.showInputDialog("Digite el nuevo código:");
                stud.setNombre(newCode);
                this.reemplazaArchivo(misEstudiantes);
                JOptionPane.showMessageDialog(null, "LA OPERACIÓN SE HIZO CON ÉXITO...!!!");
                esta = true;

                break;
            }
        }
        if (!esta) 
        {
            JOptionPane.showMessageDialog(null, "ESE CÓDIGO NO EXISTE...!!!");
        }
    }

    public void modificarApellidos() 
    {
        String code, newCode;
        boolean esta = false;
        code = JOptionPane.showInputDialog("Digite el código a buscar:");
        ArrayList<Estudiante> misEstudiantes = this.getTodos();
        for (Estudiante stud : misEstudiantes) 
        {
            if (stud.getCodigo().equals(code)) 
            {
                newCode = JOptionPane.showInputDialog("Digite los nuevos apellidos:");
                stud.setApellidos(newCode);
                this.reemplazaArchivo(misEstudiantes);
                JOptionPane.showMessageDialog(null, "LA OPERACIÓN SE HIZO CON ÉXITO...!!!");
                esta = true;
                break;
            }
        }
        if (!esta) 
        {
            JOptionPane.showMessageDialog(null, "ESE CÓDIGO NO EXISTE...!!!");
        }
    }

    public void modificarGenero() 
    {
        String code, newCode;
        boolean esta = false;
        code = JOptionPane.showInputDialog("Digite el código a buscar:");
        ArrayList<Estudiante> misEstudiantes = this.getTodos();
        for (Estudiante stud : misEstudiantes) 
        {
            if (stud.getCodigo().equals(code)) 
            {
                newCode = JOptionPane.showInputDialog("Digite el nuevo género:");
                stud.setGenero(newCode.charAt(0));
                this.reemplazaArchivo(misEstudiantes);
                JOptionPane.showMessageDialog(null, "LA OPERACIÓN SE HIZO CON ÉXITO...!!!");
                esta = true;
                break;
            }
        }
        if (!esta) 
        {
            JOptionPane.showMessageDialog(null, "ESE CÓDIGO NO EXISTE...!!!");
        }
    }

    public void modificarTelefono() 
    {
        String code, newCode;
        boolean esta = false;
        code = JOptionPane.showInputDialog("Digite el código a buscar:");

        ArrayList<Estudiante> misEstudiantes = this.getTodos();
        for (Estudiante stud : misEstudiantes) 
        {
            if (stud.getCodigo().equals(code)) 
            {
                newCode = JOptionPane.showInputDialog("Digite el nuevo teléfono:");
                stud.setTelefono(newCode);
                this.reemplazaArchivo(misEstudiantes);
                JOptionPane.showMessageDialog(null, "LA OPERACIÓN SE HIZO CON ÉXITO...!!!");
                esta = true;
                break;
            }
        }
        if (!esta) 
        {
            JOptionPane.showMessageDialog(null, "ESE CÓDIGO NO EXISTE...!!!");
        }
    }

    //=================================================================================
    
    public boolean checkExistencias() 
    {
        boolean hay = false;
        FileReader file;
        BufferedReader br;
        try {
            file = new FileReader(this.rutArchivo);
            br = new BufferedReader(file);
            if (br.readLine() != null) 
            {
                hay = true;
            } else {
                BufferedWriter bw = new BufferedWriter(new FileWriter(this.rutArchivo));
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
            leedor = new FileReader(this.rutArchivo);
            br = new BufferedReader(leedor);
            while ((registro = br.readLine()) != null)//mientras haya registros
            {

                String pieces[] = registro.split(",");
                if (code.equals(pieces[0])) 
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

    private void reemplazaArchivo(ArrayList<Estudiante> students) 
    {
        File file;
        FileWriter fr;
        PrintWriter ps;
        try 
        {
            file = new File(this.rutArchivo);
            fr = new FileWriter(file, false);
            ps = new PrintWriter(fr);
            for (Estudiante stud : students) 
            {
                ps.println(stud);
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
            File filex = new File(this.rutArchivo);
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

