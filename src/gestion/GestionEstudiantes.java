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

public class GestionEstudiantes {

    private final String archivoEstudiantes;
    GestionInscripciones gestion = new GestionInscripciones();
    
    public GestionEstudiantes() {
        this.archivoEstudiantes = "src/archivos/misEstudiantes.txt"; //rutaRelativa
        this.verificaArchivo();
    }

    private void verificaArchivo() {
        try {
            File file = new File(this.archivoEstudiantes);
            if (!file.exists()) {
                file.createNewFile();//lo crea
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Falló la búsqueda de la ruta del archivo ");
        }
    }

    public void crearEstudiante(Estudiante estudiante) {

        try {
            File file = new File(this.archivoEstudiantes);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String linea = null;
            String codigo = estudiante.getCodigo();
            while ((linea = br.readLine()) != null) {
                String busqueda[] = linea.split(",");
                for (String busqueda1 : busqueda) {
                    if (busqueda1.equals(codigo)) {
                        JOptionPane.showMessageDialog(null, "Existe un estudiante con ese código en la base ");
                        return;
                    }
                }
            }
            FileWriter fr = new FileWriter(file, true); //true agrega al final, false borra todo y agrega el nuevo
            PrintWriter ps = new PrintWriter(fr);
            ps.println(estudiante);
            ps.close();
            JOptionPane.showMessageDialog(null, "El estudiante ha sido guardado en la base ");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar el estudiante ");
        }
    }

    public ArrayList<String[]> buscarTodos() throws FileNotFoundException, IOException {

        ArrayList<String[]> estudiantes = new ArrayList<>();
        File archivoOriginal = new File(this.archivoEstudiantes);
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        String linea = null;

        while ((linea = br.readLine()) != null) {
            String busqueda[] = linea.split(",");
            estudiantes.add(busqueda);
        }
        return estudiantes;
    }
    
    public boolean comprobarPassword(String codigo,String password) throws FileNotFoundException, IOException{
        boolean existe=false;
        File archivoOriginal = new File(this.archivoEstudiantes);
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        String linea = null;
        
        while ((linea = br.readLine()) != null) {
            String busqueda[] = linea.split(",");
            //System.err.println(password+","+busqueda[5]);
            if(busqueda[0].contains(codigo)&& busqueda[5].contains(password)){
                //System.err.println(codigo +","+ password);
                existe=true;
            }
        }
        return existe;
    }
    
    public String[] buscarEstudiante(String codigo) throws FileNotFoundException, IOException {

        File archivoOriginal = new File(this.archivoEstudiantes);
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        String linea = null;
        String estudiante[] = null;
        while ((linea = br.readLine()) != null) {
            String busqueda[] = linea.split(",");
            for (int i = 0; i < busqueda.length; i++) {
                if (busqueda[i].equals(codigo)) {
                    estudiante = linea.split(",");
                }
            }
        }
        //comprobacion del estudiante existente
        if (estudiante == null) {
            JOptionPane.showMessageDialog(null, "no existe el estudiante");
            estudiante = new String[9];
            Arrays.fill(estudiante, "no existe el estudiante");
            estudiante[8] = "unknown.jpeg";
        }

        return estudiante;
    }

    public int buscarPosicion(String codigo) throws FileNotFoundException, IOException {

        File archivoOriginal = new File(this.archivoEstudiantes);
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        String linea = null;
        int posicion = 0;
        int j = 0;
        int aux = -1;
        while ((linea = br.readLine()) != null) {
            String busqueda[] = linea.split(",");
            for (int i = 0; i < busqueda.length; i++) {
                if (busqueda[0].equals(codigo)) {
                    posicion = j;
                    aux = 1;
                }
            }
            j++;
        }
        if (aux < 0) {
            JOptionPane.showMessageDialog(null, "No existe el estudiante con ese código");
        }
        return posicion;
    }
    public void modificarPrograma(String codigoPrograma, int opcion) throws FileNotFoundException, IOException{
        // opcion 1= eliminar
        // opcion 2= modificar
        File archivoOriginal = new File(this.archivoEstudiantes);
        File archivoTemporal = new File("src/archivos/auxiliarEstudiantes.txt");
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        PrintWriter pw = new PrintWriter(new FileWriter(archivoTemporal));
        String linea = null;
        while ((linea = br.readLine()) != null) {
            String busqueda[] = linea.split(",");
            if (busqueda[3].equals(codigoPrograma)) {
                if (opcion == 1) {
                    linea = "";
                    gestion.modificarEstudiante(busqueda[0], opcion);

                } else if (opcion == 2) {
                    linea = busqueda[0] + "," + busqueda[1] + "," + busqueda[2] + "," + codigoPrograma + "," + busqueda[4] + "," + busqueda[5] + "," + busqueda[6] + "," + busqueda[7] + "," + busqueda[8];
                    //JOptionPane.showMessageDialog(null, "Estudiantes modificado");
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
    
    public void modificarEstudiante(Estudiante estudiante, int opcion) throws FileNotFoundException, IOException {
        // opcion 1= eliminar
        // opcion 2= modificar
        File archivoOriginal = new File(this.archivoEstudiantes);
        File archivoTemporal = new File("src/archivos/auxiliarEstudiantes.txt");
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        PrintWriter pw = new PrintWriter(new FileWriter(archivoTemporal));
        String linea = null;
        String codigo = estudiante.getCodigo();
        while ((linea = br.readLine()) != null) {
            String busqueda[] = linea.split(",");
            for (int i = 0; i < busqueda.length; i++) {
                if (busqueda[i].equals(codigo)) {
                    if (opcion == 1) {
                        int confir = JOptionPane.showConfirmDialog(null, "Realmente deseas eliminar?", "Eliminar estudiante", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                        if (confir == JOptionPane.YES_OPTION) {
                            linea = "";
                            gestion.modificarEstudiante(codigo,opcion);
                            JOptionPane.showMessageDialog(null, "Estudiante eliminado");
                        }
                    } else if (opcion == 2) {
                        linea = estudiante.toString();
                        gestion.modificarEstudiante(codigo,opcion);
                        JOptionPane.showMessageDialog(null, "Estudiante modificado");
                    }
                }
            }
            if (!linea.equals("")){ // para no escribir lineas en blanco en el archivo
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
