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

        this.archivoProgramas = "/home/tato/Documentos/misProgramas.txt"; //rutaRelativa
        this.verificaArchivo();//creacion del archivo con validacion

    }

    public void crearPrograma(String codigo, String nombre, boolean acreditado, boolean presencial, boolean online) {
        Programa prog = new Programa(codigo, nombre, acreditado, presencial, online);
        this.guardarPrograma(prog);
    //todo here

    }

    private void verificaArchivo() {
    //todo here
        try {
            File filex = new File(this.archivoProgramas);
            if (!filex.exists()) {
                filex.createNewFile();//lo crea
            }
        } catch (IOException ex) {
            System.out.println("Falló búsqueda de ruta..");

        }
    }

    private void guardarPrograma(Programa prog) {
        File file;
        FileWriter fr;
        PrintWriter ps;
        try {
            file = new File(this.archivoProgramas);
            fr = new FileWriter(file, true); //true agrega al final, false borra todo y agrega el nuevo
            ps = new PrintWriter(fr);
            ps.println(prog);
            ps.close();
            JOptionPane.showMessageDialog(null, "El programa ha sido guardado en la base ");
        } catch (IOException ex) {
            System.out.println("Problemas al guardar el programa");
        }
    }

    public String[] buscarPrograma(String codigo) throws FileNotFoundException, IOException {

        File originalFile = new File("/home/tato/Documentos/misProgramas.txt");
        BufferedReader br = new BufferedReader(new FileReader(originalFile));
        String line = null;
        String prog[] = null;
        
        while ((line = br.readLine()) != null) {
            String search []= line.split(",");
            for(int i=0;i<search.length;i++){
                if (search[i].equals(codigo)) {
                    prog = line.split(",");
                }
        //String estudianteModificado [] = line.split(",");
        //line= estudianteModificado[0]+","+estudianteModificado[1]+","+ estudianteModificado[2]+","+estudianteModificado[3]+","+estudianteModificado[4];
            }

        }
        //comprobacion del programa existente
        
        if (prog==null){
            prog = new String[5];
            System.err.println("El programa no existe");
            prog[0]="El programa no existe";
            prog[1]="El programa no existe";
            prog[2]="false";
            prog[3]="false";
            prog[4]="false";
            }
        //System.out.println(Arrays.toString(prog));
        return prog;
    }
    
    public void eliminarPrograma(String codigo) throws FileNotFoundException, IOException{
        
        File originalFile = new File("/home/tato/Documentos/misProgramas.txt");
        BufferedReader br = new BufferedReader(new FileReader(originalFile));
        File tempFile = new File("/home/tato/Documentos/auxiliar.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

        String line = null;
        while ((line = br.readLine()) != null) {
            
            if (line.contains(codigo)) {
                line = "";
           }
            pw.println(line);
            pw.flush();
        }
        pw.close();
        br.close();
        
        // Delete the original file
        if (!originalFile.delete()) {
            System.out.println("Could not delete file");
            return;
        }

        // Rename the new file to the filename the original file had.
        if (!tempFile.renameTo(originalFile))
            System.out.println("Could not rename file");

    }
    
}
