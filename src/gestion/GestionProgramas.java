/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
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
import negocio.Programa;

/**
 *
 * @author tato
 */
public class GestionProgramas {

    private String archivoProgramas;

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
        
        File file;
        FileWriter fr;
        PrintWriter ps;
        try {
            file = new File(this.archivoProgramas);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            String codigo = prog.getCodigo(),nombre =prog.getNombre();
            while ((line = br.readLine()) != null) {
                String search []= line.split(",");
                for (String search1 : search) {
                    if (search1.equals(codigo)) {
                        JOptionPane.showMessageDialog(null, "Existe un programa con ese código en la base ");
                        return;
                    }
                }
            }
            
            fr = new FileWriter(file, true); //true agrega al final, false borra todo y agrega el nuevo
            ps = new PrintWriter(fr);
            ps.println(prog);
            ps.close();
            JOptionPane.showMessageDialog(null, "El programa ha sido guardado en la base ");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar el programa ");
        }
    }
    
    
    public String[] buscarPrograma(String codigo) throws FileNotFoundException, IOException {

        File originalFile = new File(this.archivoProgramas);
        BufferedReader br = new BufferedReader(new FileReader(originalFile));
        String line = null;
        String prog[] = null;
        
        while ((line = br.readLine()) != null) {
            String search []= line.split(",");
            for(int i=0;i<search.length;i++){
                if (search[i].equals(codigo)) {
                    prog = line.split(",");
                }
            }
        }
        if (prog == null) {
            JOptionPane.showMessageDialog(null, "no existe el programa");

        }
        //comprobacion del programa existente
        if (prog==null){
            
            prog = new String[5];
            //System.err.println("El programa no existe");
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
        File originalFile = new File(this.archivoProgramas);
        File tempFile = new File("/home/tato/Documentos/auxiliar.txt");
        BufferedReader br = new BufferedReader(new FileReader(originalFile));
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
        String line = null;
        String codigo= prog.getCodigo();
        while ((line = br.readLine()) != null) {
            String search[] = line.split(",");
            for (int i = 0; i < search.length; i++) {
                if (search[i].equals(codigo)) {
                    if (opcion == 1) {
                        int confir = JOptionPane.showConfirmDialog(null, "Realmente deseas eliminar?", "Eliminar programa", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                        if (confir == JOptionPane.YES_OPTION) {
                            line = "";
                            JOptionPane.showMessageDialog(null, "Programa eliminado");
                        }
                    }else if(opcion==2){
                        line= prog.toString();
                        JOptionPane.showMessageDialog(null, "Programa modificado");
                    }
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
