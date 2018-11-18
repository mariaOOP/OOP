package gestion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import negocio.Programa;


public class GestionProgramas {

    private final String archivoProgramas;
    private GestionEstudiantes gestionEstudiantes = new GestionEstudiantes();
    private GestionProfesores gestionProfesores = new GestionProfesores();
    
    public GestionProgramas() {

        this.archivoProgramas = "src/archivos/misProgramas.txt"; //rutaRelativa
        this.verificaArchivo();//creacion del archivo con validacion
    }
    // comprueba que esté el archivo de la base, sino lo crea
    private void verificaArchivo() {
  
        try {
            File file = new File(this.archivoProgramas);
            if (!file.exists()) {
                file.createNewFile();//lo crea
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Falló la búsqueda de la ruta del archivo ");
        }
    }
    
    public void crearPrograma(Programa prog){
       
        try {
            File file = new File(this.archivoProgramas);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String linea = null;
            String codigo = prog.getCodigo(),nombre =prog.getNombre();
            while ((linea = br.readLine()) != null) {
                String busqueda []= linea.split(",");
                for (String busqueda1 : busqueda) {
                    if (busqueda1.equals(codigo)) {
                        JOptionPane.showMessageDialog(null, "Existe un programa con ese código en la base ");
                        return;
                    }
                }
            }
            FileWriter fr = new FileWriter(file, true); //true agrega al final, false borra todo y agrega el nuevo
            PrintWriter ps = new PrintWriter(fr);
            ps.println(prog);
            ps.close();
            JOptionPane.showMessageDialog(null, "El programa ha sido guardado en la base ");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar el programa ");
        }
    }
    
    
    public String[] buscarPrograma(String codigo) throws FileNotFoundException, IOException {

        File archivoOriginal = new File(this.archivoProgramas);
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        String linea = null;
        String prog[] = null;
        while ((linea = br.readLine()) != null) {
            String busqueda []= linea.split(",");
            for(int i=0;i<busqueda.length;i++){
                if (busqueda[i].equals(codigo)) {
                    prog = linea.split(",");
                }
            }
        }
        if (prog == null) {
            JOptionPane.showMessageDialog(null, "no existe el programa");
        }
        //comprobacion del programa existente
        if (prog==null){
            JOptionPane.showMessageDialog(null, "No existe ese programa");
            prog = new String[5];
            prog[0]="El programa no existe";
            prog[1]="El programa no existe";
            prog[2]="false";
            prog[3]="false";
            prog[4]="false";
            }
        return prog;
    }
    
    public void modificarPrograma(Programa prog, int opcion) throws FileNotFoundException, IOException{
        // opcion 1= eliminar
        // opcion 2= modificar
        File archivoOriginal = new File(this.archivoProgramas);
        File archivoTemporal = new File("src/archivos/auxiliarProgramas.txt");
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        PrintWriter pw = new PrintWriter(new FileWriter(archivoTemporal));
        String linea = null;
        String codigo= prog.getCodigo();
        String nombre=prog.getNombre();
        while ((linea = br.readLine()) != null) {
            String busqueda[] = linea.split(",");
            for (int i = 0; i < busqueda.length; i++) {
                if (busqueda[i].equals(codigo)) {
                    if (opcion == 1) {
                        int confir = JOptionPane.showConfirmDialog(null, "Realmente deseas eliminar?", "Eliminar programa", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                        if (confir == JOptionPane.YES_OPTION) {
                            linea = "";
                            gestionEstudiantes.modificarPrograma(nombre, opcion);
                            gestionProfesores.modificarPrograma(nombre, opcion);
                            JOptionPane.showMessageDialog(null, "Programa eliminado");
                        }
                    } else if (opcion == 2) {
                        linea = prog.toString();
                        gestionEstudiantes.modificarPrograma(codigo, opcion);
                        gestionProfesores.modificarPrograma(codigo, opcion);
                        JOptionPane.showMessageDialog(null, "Programa modificado");
                    }
                }
            }
            if (!linea.equals("")){ // para no escribir lineaas en blanco en el archivo
                pw.println(linea);
            }
            pw.flush();// descarga el buffer que usamos para guardar los datos 
        }
        pw.close();
        br.close();
        
        // elimina el archivo original
        if (!archivoOriginal.delete()) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el archivo ");
            return;
        }
        // renombra el archivo temporal para que tenga el nombre del archivo original.
        if (!archivoTemporal.renameTo(archivoOriginal)){
            JOptionPane.showMessageDialog(null, "Error al renombrar el archivo ");
        }
    }
}
