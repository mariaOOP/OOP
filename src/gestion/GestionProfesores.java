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
import negocio.Profesor;


public class GestionProfesores {

    private final String archivoProfesores;
    private GestionInscripciones gestion= new GestionInscripciones();
    
    public GestionProfesores() {
        this.archivoProfesores = "src/archivos/misProfesores.txt"; //rutaRelativa
        this.verificaArchivo();
    }

    private void verificaArchivo() {
        try {
            File file = new File(this.archivoProfesores);
            if (!file.exists()) {
                file.createNewFile();//lo crea
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Falló la búsqueda de la ruta del archivo ");
        }
    }

    public void crearProfesor(Profesor profesor) {

        try {
            File file = new File(this.archivoProfesores);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String linea = null;
            String cedula = profesor.getCedula();
            while ((linea = br.readLine()) != null) {
                String busqueda[] = linea.split(",");
                for (String busqueda1 : busqueda) {
                    if (busqueda1.equals(cedula)) {
                        JOptionPane.showMessageDialog(null, "Existe un profesor con ese código en la base ");
                        return;
                    }
                }
            }
            FileWriter fr = new FileWriter(file, true); //true agrega al final, false borra todo y agrega el nuevo
            PrintWriter ps = new PrintWriter(fr);
            ps.println(profesor);
            ps.close();
            JOptionPane.showMessageDialog(null, "El profesor ha sido guardado en la base ");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar el profesor ");
        }
    }

    public ArrayList<String[]> buscarTodos() throws FileNotFoundException, IOException {

        ArrayList<String[]> profesores = new ArrayList<>();
        File archivoOriginal = new File(this.archivoProfesores);
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        String linea = null;

        while ((linea = br.readLine()) != null) {
            String busqueda[] = linea.split(",");
            profesores.add(busqueda);
        }
        return profesores;
    }

    public String[] buscarProfesor(String cedula) throws FileNotFoundException, IOException {

        File archivoOriginal = new File(this.archivoProfesores);
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        String linea = null;
        String profesor[] = null;
        while ((linea = br.readLine()) != null) {
            String busqueda[] = linea.split(",");
            for (int i = 0; i < busqueda.length; i++) {
                if (busqueda[i].equals(cedula)) {
                    profesor = linea.split(",");
                }
            }
        }
        //comprobacion del profesor existente
        if (profesor == null) {
            JOptionPane.showMessageDialog(null, "no existe el profesor");
            profesor = new String[5];
            Arrays.fill(profesor, "no existe el profesor");
            profesor[4] = "unknown.jpeg";
        }

        return profesor;
    }

    public int buscarPosicion(String cedula) throws FileNotFoundException, IOException {

        File archivoOriginal = new File(this.archivoProfesores);
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        String linea = null;
        int posicion = 0;
        int j = 0;
        int aux = -1;
        while ((linea = br.readLine()) != null) {
            String busqueda[] = linea.split(",");
            for (int i = 0; i < busqueda.length; i++) {
                if (busqueda[0].equals(cedula)) {
                    posicion = j;
                    aux = 1;
                }
            }
            j++;
        }
        if (aux < 0) {
            JOptionPane.showMessageDialog(null, "No existe el profesor con ese código");
        }
        return posicion;
    }
    public void modificarPrograma(String codigoPrograma, int opcion) throws FileNotFoundException, IOException{
        // opcion 1= eliminar
        // opcion 2= modificar
        File archivoOriginal = new File(this.archivoProfesores);
        File archivoTemporal = new File("src/archivos/auxiliarProfesores.txt");
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        PrintWriter pw = new PrintWriter(new FileWriter(archivoTemporal));
        String linea = null;
        while ((linea = br.readLine()) != null) {
            String busqueda[] = linea.split(",");

            if (busqueda[3].equals(codigoPrograma)) {
                if (opcion == 1) {
                    linea = "";
                    gestion.modificarEstudiante(busqueda[0], opcion);
                }
            } else if (opcion == 2) {
                linea = busqueda[0] + "," + busqueda[1] + "," + busqueda[2] + "," + codigoPrograma + "," + busqueda[4];
                //JOptionPane.showMessageDialog(null, "Profesores modificado");
            }

            if (!linea.equals("")) { // para no escribir lineas en blanco en el archivo
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
        if (!archivoTemporal.renameTo(archivoOriginal)) {
            JOptionPane.showMessageDialog(null, "Error al renombrar el archivo ");
        }
    }
    
    public void modificarProfesor(Profesor profesor, int opcion) throws FileNotFoundException, IOException {
        // opcion 1= eliminar
        // opcion 2= modificar
        File archivoOriginal = new File(this.archivoProfesores);
        File archivoTemporal = new File("src/archivos/auxiliarProfesores.txt");
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        PrintWriter pw = new PrintWriter(new FileWriter(archivoTemporal));
        String linea = null;
        String cedula = profesor.getCedula();
        while ((linea = br.readLine()) != null) {
            String busqueda[] = linea.split(",");
            for (int i = 0; i < busqueda.length; i++) {
                if (busqueda[0].equals(cedula)) {
                    if (opcion == 1) {
                        int confir = JOptionPane.showConfirmDialog(null, "Realmente deseas eliminar?", "Eliminar profesor", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                        if (confir == JOptionPane.YES_OPTION) {
                            linea = "";
                            gestion.modificarProfesor(cedula,opcion);
                            JOptionPane.showMessageDialog(null, "Profesor eliminado");
                        }
                    } else if (opcion == 2) {
                        linea = profesor.toString();
                        gestion.modificarProfesor(cedula,opcion);
                        JOptionPane.showMessageDialog(null, "Profesor modificado");
                    }
                }
            }
            if (!linea.equals("")) { // para no escribir lineas en blanco en el archivo
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
        if (!archivoTemporal.renameTo(archivoOriginal)) {
            JOptionPane.showMessageDialog(null, "Error al renombrar el archivo ");
        }
    }
}
