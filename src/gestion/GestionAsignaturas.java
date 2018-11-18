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
import negocio.Asignatura;

public class GestionAsignaturas {

    private final String archivoAsignaturas;
    private final String asignaProfe;
    GestionInscripciones gestion = new GestionInscripciones();

    public GestionAsignaturas() {
        this.archivoAsignaturas = "src/archivos/misAsignaturas.txt"; //rutaRelativa
        this.asignaProfe = "src/archivos/asignaProfe.txt";
        this.verificaArchivo();
    }
    public String traerAsignatura(int posicion) throws FileNotFoundException, IOException{
        File archivoOriginal = new File(this.archivoAsignaturas);
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        Object[] lines = br.lines().toArray();
        String line = lines[posicion].toString().trim();

        return line;
    }
    private void verificaArchivo() {
        try {
            File file = new File(this.archivoAsignaturas);
            if (!file.exists()) {
                file.createNewFile();//lo crea
            }
            File file2 = new File(this.asignaProfe);
            if (!file2.exists()) {
                file2.createNewFile();//lo crea
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Falló la búsqueda de la ruta del archivo ");
        }
    }
    
    public void crearAsignaProfe(String codigo, String cedula) throws FileNotFoundException, IOException {

        File archivoOriginal = new File(this.asignaProfe);
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        File archivoTemporal = new File("src/archivos/auxiliarAsignaProfe.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(archivoTemporal));

        String linea = null;
        while ((linea = br.readLine()) != null) {
            if (linea.contains(codigo) && linea.contains(cedula)) {
                JOptionPane.showMessageDialog(null, "Existe una asignatura con ese código y esa cédula en la base ");
                return;
            }
            if (!linea.equals("")) { // para no escribir lineas en blanco en el archivo
                pw.println(linea);
            }
            pw.flush();// descarga el buffer que usamos para guardar los datos 
        }
        pw.println(codigo + "," + cedula);
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
    public ArrayList<String[]> buscarTodosAsignaProfe() throws FileNotFoundException, IOException {

        ArrayList<String[]> asignaProfe = new ArrayList<>();
        File archivoOriginal = new File(this.asignaProfe);
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        String linea = null;

        while ((linea = br.readLine()) != null) {
            String busqueda[] = linea.split(",");
            asignaProfe.add(busqueda);
        }
        return asignaProfe;
    }
    
    public void crearAsignatura(Asignatura asignatura) {

        try {
            File file = new File(this.archivoAsignaturas);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String linea = null;
            String codigo = asignatura.getCodigo();
            while ((linea = br.readLine()) != null) {
                String busqueda[] = linea.split(",");
                for (String busqueda1 : busqueda) {
                    if (busqueda[0].equals(codigo)) {
                        JOptionPane.showMessageDialog(null, "Existe una asignatura con ese código en la base ");
                        return;
                    }
                }
            }
            FileWriter fr = new FileWriter(file, true); //true agrega al final, false borra todo y agrega el nuevo
            PrintWriter ps = new PrintWriter(fr);
            ps.println(asignatura);
            ps.close();
            JOptionPane.showMessageDialog(null, "La asignatura ha sido guardada en la base ");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar la asignatura ");
        }
    }

    public ArrayList<String[]> buscarTodas() throws FileNotFoundException, IOException {

        ArrayList<String[]> asignaturas = new ArrayList<>();
        File archivoOriginal = new File(this.archivoAsignaturas);
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        String linea = null;

        while ((linea = br.readLine()) != null) {
            String busqueda[] = linea.split(",");
            asignaturas.add(busqueda);
        }
        return asignaturas;
    }
    
    public int buscarPosicion(String codigo) throws FileNotFoundException, IOException {

        File archivoOriginal = new File(this.archivoAsignaturas);
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
            JOptionPane.showMessageDialog(null, "No existe asignatura con ese código");
        }
        return posicion;
    }
    
    public ArrayList<String[]> asignaturasPorCedula(String cedula) throws FileNotFoundException, IOException{
    
        ArrayList<String[]> confir= new ArrayList<>();
        File archivoOriginal = new File(this.asignaProfe);
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        String linea = null;
        while ((linea = br.readLine()) != null) {
            String[] split= linea.split(",");
            if (split[1].equals(cedula)){
                confir.add(split);
            }
        }
        return confir;
    }
    
    public ArrayList<String[]> buscarAsignaProfe(String codigo) throws FileNotFoundException, IOException{
    
        ArrayList<String[]> confir= new ArrayList<>();
        File archivoOriginal = new File(this.asignaProfe);
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        String linea = null;
        while ((linea = br.readLine()) != null) {
            String[] split= linea.split(",");
            if (split[0].equals(codigo)){
                confir.add(split);
            }
        }
        return confir;
    }
        
    public String[] buscarAsignatura(String codigo) throws FileNotFoundException, IOException {

        File archivoOriginal = new File(this.archivoAsignaturas);
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        String linea = null;
        String asignatura[] = null;

        while ((linea = br.readLine()) != null) {
            String busqueda[] = linea.split(",");
            for (int i = 0; i < busqueda.length; i++) {
                if (busqueda[i].equals(codigo)) {
                    asignatura = linea.split(",");
                }
            }
        }
        //comprobacion del asignatura existente
        if (asignatura == null) {
            asignatura = new String[3];
            Arrays.fill(asignatura, "no existe la asignatura");
        }

        return asignatura;
    }
    
    public void modificarAsignaprofe(String codigo, String cedula, int opcion) throws FileNotFoundException, IOException {

        File archivoOriginal = new File(this.asignaProfe);
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        File archivoTemporal = new File("src/archivos/auxiliarAsignaProfe.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(archivoTemporal));

        String linea = null;
        while ((linea = br.readLine()) != null) {
            String[] split= linea.split(",");
            if (split[0].equals(codigo) && split[1].equals(cedula)) {
                if (opcion == 1) {
                    linea = "";
                } else if (opcion == 2) {
                    linea = codigo + "," + cedula;
                }
            }
            if (!linea.equals("")) { // para no escribir lineas en blanco en el archivo
                pw.println(linea);
            }
            pw.flush();// descarga el buffer que usamos para guardar los datos 
        }
        //pw.println(codigo+","+cedula);
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

    public void modificarAsignatura(Asignatura asignatura, String cedula, int opcion) throws FileNotFoundException, IOException {
        // opcion 1= eliminar
        // opcion 2= modificar
        File archivoOriginal = new File(this.archivoAsignaturas);
        File archivoTemporal = new File("src/archivos/auxiliarAsignatura.txt");
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        PrintWriter pw = new PrintWriter(new FileWriter(archivoTemporal));
        String linea = null;
        String codigo = asignatura.getCodigo();
        while ((linea = br.readLine()) != null) {
            String busqueda[] = linea.split(",");
            for (int i = 0; i < busqueda.length; i++) {
                if (busqueda[0].equals(codigo)) {
                    if (opcion == 1) {
                        int confir = JOptionPane.showConfirmDialog(null, "Realmente deseas eliminar?", "Eliminar Asignatura", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                        if (confir == JOptionPane.YES_OPTION) {
                            linea = "";
                            gestion.modificarAsignatura(codigo, opcion);
                            modificarAsignaprofe(codigo, cedula, opcion);
                            JOptionPane.showMessageDialog(null, "Asignatura eliminada");
                        }
                    } else if (opcion == 2) {
                        linea = asignatura.toString();
                        gestion.modificarAsignatura(codigo, opcion);
                        modificarAsignaprofe(codigo, cedula, opcion);
                        JOptionPane.showMessageDialog(null, "Asignatura modificada");
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
