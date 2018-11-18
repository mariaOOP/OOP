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
import negocio.Inscripcion;

public class GestionInscripciones {

    private final String archivoInscripciones;

    public GestionInscripciones() {
        this.archivoInscripciones = "src/archivos/misInscripciones.txt"; //rutaRelativa
        this.verificaArchivo();
    }

    private void verificaArchivo() {
        try {
            File file = new File(this.archivoInscripciones);
            if (!file.exists()) {
                file.createNewFile();//lo crea
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Falló la búsqueda de la ruta del archivo ");
        }
    }
    public boolean comprobarInscripcion(String idEstudiante){
        boolean comprobacion=false;
        try {
            File file = new File(this.archivoInscripciones);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String linea = null;
            while ((linea = br.readLine()) != null) {
                String[]comprobar=linea.split(",");
                if (comprobar[0].equals(idEstudiante)) {
                    //System.err.println("entro aqui");
                    comprobacion=true;
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error");
        }
        return comprobacion;
    }
    public String[] asignaturaCodigo(String codigo) throws FileNotFoundException, IOException{
        File archivoOriginal = new File(this.archivoInscripciones);
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        String linea = null;
        String inscri[] = null;
        while ((linea = br.readLine()) != null) {
            String busqueda[] = linea.split(",");
            for (int i = 0; i < busqueda.length; i++) {
                if (busqueda[0].equals(codigo)) {
                    inscri = linea.split(",");
                }
            }
        }
        //comprobacion del inscripcion existente
        if (inscri == null) {
            inscri = new String[3];
            Arrays.fill(inscri, "no existe la inscripcion");
        }

        return inscri;
    
    }
    
    public void crearInscripcion(Inscripcion inscripcion) {

        try {
            File file = new File(this.archivoInscripciones);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String linea = null;
            String idAsignatura = inscripcion.getIdAsignatura();
            String idEstudiante = inscripcion.getIdEstudiante();
            String idProfesor = inscripcion.getIdProfesor();
            while ((linea = br.readLine()) != null) {
                String confir[]=linea.split(",");
                if (confir[0].equals(idEstudiante) && confir[1].equals(idAsignatura)) {
                    JOptionPane.showMessageDialog(null, "Existe una inscrición previa");
                    return;
                }
            }
            FileWriter fr = new FileWriter(file, true); //true agrega al final, false borra todo y agrega el nuevo
            PrintWriter ps = new PrintWriter(fr);
            ps.println(inscripcion);
            ps.close();
            JOptionPane.showMessageDialog(null, "La inscripcion ha sido guardada en la base ");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar la inscripcion ");
        }
    }

    public ArrayList<String[]> buscarTodas() throws FileNotFoundException, IOException {

        ArrayList<String[]> inscripciones = new ArrayList<>();
        File archivoOriginal = new File(this.archivoInscripciones);
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        String linea = null;

        while ((linea = br.readLine()) != null) {
            String busqueda[] = linea.split(",");
            inscripciones.add(busqueda);
        }
        return inscripciones;
    }

    public int buscarPosicion(Inscripcion inscripcion) throws FileNotFoundException, IOException {

        File archivoOriginal = new File(this.archivoInscripciones);
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        String linea = null;
        String idAsignatura = inscripcion.getIdAsignatura();
        String idEstudiante = inscripcion.getIdEstudiante();
        String idProfesor = inscripcion.getIdProfesor();
        int posicion = 0;
        int j = 0;
        int aux = -1;
        while ((linea = br.readLine()) != null) {
            String busqueda[] = linea.split(",");
            for (int i = 0; i < busqueda.length; i++) {
                if (busqueda[0].equals(idEstudiante) && busqueda[1].equals(idAsignatura) && busqueda[2].equals(idProfesor)) {
                    posicion = j;
                    aux = 1;
                }
            }
            j++;
        }
        if (aux < 0) {
            JOptionPane.showMessageDialog(null, "No existe inscripcion con ese código");
        }
        return posicion;
    }
    
    public int contarAlumnos(String codigoAsignatura,String cedula) throws FileNotFoundException, IOException{
        int total=0;
        File archivoOriginal = new File(this.archivoInscripciones);
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        String linea = null;
        while ((linea = br.readLine()) != null) {
            String busqueda[] = linea.split(",");
            for (int i = 0; i < busqueda.length; i++) {
                if (busqueda[1].equals(codigoAsignatura) && busqueda[2].equals(cedula)) {
                    total ++;
                }
            }
        }
        return total;
    }
    
    public String[] buscarInscripcion(Inscripcion inscripcion) throws FileNotFoundException, IOException {

        File archivoOriginal = new File(this.archivoInscripciones);
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        String linea = null;
        String inscri[] = null;
        String idAsignatura = inscripcion.getIdAsignatura();
        String idEstudiante = inscripcion.getIdEstudiante();
        String idProfesor = inscripcion.getIdProfesor();
        while ((linea = br.readLine()) != null) {
            String busqueda[] = linea.split(",");
            for (int i = 0; i < busqueda.length; i++) {
                if (busqueda[0].equals(idEstudiante) && busqueda[1].equals(idAsignatura) && busqueda[2].equals(idProfesor)) {
                    inscri = linea.split(",");
                }
            }
        }
        //comprobacion del inscripcion existente
        if (inscri == null) {
            inscri = new String[3];
            Arrays.fill(inscri, "no existe la inscripcion");
        }

        return inscri;
    }
    
    public void modificarEstudiante(String idEstudiante, int opcion) throws IOException {
        File archivoOriginal = new File(this.archivoInscripciones);
        File archivoTemporal = new File("src/archivos/auxiliar.txt");
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        PrintWriter pw = new PrintWriter(new FileWriter(archivoTemporal));
        String linea = null;
        while ((linea = br.readLine()) != null) {
            String busqueda[] = linea.split(",");
            if (busqueda[0].equals(idEstudiante)) {
                if (opcion == 1) {
                    linea = "";
                }
            } else if (opcion == 2) {
                linea = idEstudiante + "," + busqueda[1] + "," + busqueda[2];
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

    
    public void modificarAsignatura(String idAsignatura, int opcion) throws IOException {
        File archivoOriginal = new File(this.archivoInscripciones);
        File archivoTemporal = new File("src/archivos/auxiliar.txt");
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        PrintWriter pw = new PrintWriter(new FileWriter(archivoTemporal));
        String linea = null;
        while ((linea = br.readLine()) != null) {
            String busqueda[] = linea.split(",");
            if (busqueda[1].equals(idAsignatura)) {
                if (opcion == 1) {
                    linea = "";
                }
            } else if (opcion == 2) {
                linea = busqueda[0] + "," + idAsignatura + "," + busqueda[2];
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
    public void modificarProfesor(String idProfesor, int opcion) throws IOException {
        File archivoOriginal = new File(this.archivoInscripciones);
        File archivoTemporal = new File("src/archivos/auxiliar.txt");
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        PrintWriter pw = new PrintWriter(new FileWriter(archivoTemporal));
        String linea = null;
        while ((linea = br.readLine()) != null) {
            String busqueda[] = linea.split(",");
            if (busqueda[2].equals(idProfesor)) {
                if (opcion == 1) {
                    linea = "";
                }
            } else if (opcion == 2) {
                linea = busqueda[0] + "," + busqueda[1] + "," + idProfesor;
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
    
    public void modificarInscripcion(Inscripcion inscripcion, int opcion) throws FileNotFoundException, IOException {
        // opcion 1= eliminar
        // opcion 2= modificar
        File archivoOriginal = new File(this.archivoInscripciones);
        File archivoTemporal = new File("src/archivos/auxiliarInscripcion.txt");
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        PrintWriter pw = new PrintWriter(new FileWriter(archivoTemporal));
        String linea = null;
        String idAsignatura = inscripcion.getIdAsignatura();
        String idEstudiante = inscripcion.getIdEstudiante();
        String idProfesor = inscripcion.getIdProfesor();
        while ((linea = br.readLine()) != null) {
            String busqueda[] = linea.split(",");
            if (busqueda[0].equals(idEstudiante) && busqueda[1].equals(idAsignatura) && busqueda[2].equals(idProfesor)) {
                if (opcion == 1) {
                    int confir = JOptionPane.showConfirmDialog(null, "Realmente deseas eliminar?", "Eliminar Inscripcion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (confir == JOptionPane.YES_OPTION) {
                        linea = "";
                        JOptionPane.showMessageDialog(null, "Inscripcion eliminada");
                    }
                } else if (opcion == 2) {
                    linea = inscripcion.toString();
                    JOptionPane.showMessageDialog(null, "Inscripcion modificada");
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
