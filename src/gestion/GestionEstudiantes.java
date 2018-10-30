package gestion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import negocio.Estudiante;



public class GestionEstudiantes 
{
   private final String archivoEstudiantes;

    public GestionEstudiantes() 
    {
        this.archivoEstudiantes = "src/archivos/misEstudiantes.txt"; //rutaRelativa
        this.verificaArchivo();
    }

    private void verificaArchivo() {
        try {
            File filex = new File(this.archivoEstudiantes);
            if (!filex.exists()) {
                filex.createNewFile();//lo crea
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Falló la búsqueda de la ruta del archivo ");        
        }
    }
    

    public void crearEstudiante(String codigo, String nombre, String apellidos, String programa, String direccion, String password, String celular, String email, String nombreFoto) {
        Estudiante estudiante = new Estudiante(codigo,nombre,apellidos,programa,direccion,password,celular,email,nombreFoto);
        this.guardarEstudiante(estudiante);
    }

    private void guardarEstudiante(Estudiante estudiante) {
        File file;
        FileWriter fr;
        PrintWriter ps;
        try {
            file = new File(this.archivoEstudiantes);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            String codigo = estudiante.getCodigo();while ((line = br.readLine()) != null) {
                String search []= line.split(",");
                for (String search1 : search) {
                    if (search1.equals(codigo)) {
                        JOptionPane.showMessageDialog(null, "Existe un estudiante con ese código en la base ");
                        return;
                    }
                }
            }
            fr = new FileWriter(file, true); //true agrega al final, false borra todo y agrega el nuevo
            ps = new PrintWriter(fr);
            ps.println(estudiante);
            ps.close();
            JOptionPane.showMessageDialog(null, "El estudiante ha sido guardado en la base ");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar el estudiante ");
        }
    }
    public ArrayList<String[]> buscarTodos() throws FileNotFoundException, IOException{
        
        ArrayList<String[]> estudiantes = new ArrayList<>();
        File originalFile = new File(this.archivoEstudiantes);
        BufferedReader br = new BufferedReader(new FileReader(originalFile));
        String line = null;
        
        while ((line = br.readLine()) != null) {
            String search []= line.split(",");
            estudiantes.add(search);
        }
        return estudiantes;
    }
    
    public String[] buscarEstudiante(String codigo) throws FileNotFoundException, IOException {

        File originalFile = new File(this.archivoEstudiantes);
        BufferedReader br = new BufferedReader(new FileReader(originalFile));
        String line = null;
        String estudiante[] = null;
        
        while ((line = br.readLine()) != null) {
            String search []= line.split(",");
            for(int i=0;i<search.length;i++){
                if (search[i].equals(codigo)) {
                    estudiante = line.split(",");
                }
            }
        }
        
        //comprobacion del estudiante existente
        if (estudiante==null){
            estudiante = new String[9];
            Arrays.fill(estudiante, "no existe el estudiante");
            }
            estudiante[8]="uknown.jpg";
        return estudiante;
    }
    public void eliminarEstudiante(String codigo) throws FileNotFoundException, IOException{
        
        File originalFile = new File(this.archivoEstudiantes);
        BufferedReader br = new BufferedReader(new FileReader(originalFile));
        File tempFile = new File("/home/tato/Documentos/auxiliar.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
        
        String line = null;
        while ((line = br.readLine()) != null) {
            if (line.contains(codigo)) {
                int confir = JOptionPane.showConfirmDialog(null, "Realmente deseas eliminar?", "Eliminar estudiante", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (confir==2){
                    line = "";
                    JOptionPane.showMessageDialog(null, "Estudiante eliminado");
                }
            }
            if (!line.equals("")){ // para no escribir lineas en blanco en el archivo
                pw.println(line);
            }
            pw.flush();// descarga el buffer que usamos para guardar los datos 
        }
        pw.close();
        br.close();
        
        // elimina el archivo original
        if (!originalFile.delete()) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el archivo ");
            return;
        }
        // renombra el archivo temporal para que tenga el nombre del archivo original.
        if (!tempFile.renameTo(originalFile)){
            JOptionPane.showMessageDialog(null, "Error al renombrar el archivo ");
        }
    }
}