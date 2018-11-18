package vista;

import gestion.GestionAsignaturas;
import gestion.GestionInscripciones;
import gestion.GestionProfesores;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import negocio.Inscripcion;

public class MostrarInscripcion extends javax.swing.JDialog {

    /**
     * Creates new form MostrarInscripcion
     */
    private GestionAsignaturas gestionAsignaturas = new GestionAsignaturas();
    private GestionInscripciones gestionInscripciones = new GestionInscripciones();
    private GestionProfesores gestionProfesores = new GestionProfesores();
    private String idEstudiante;
    private String idAsignatura;
    private String idProfesor;
    private ArrayList<String> asignaProfe = null;

    public MostrarInscripcion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
    }

    public void codEstudiante(String codigo) {
        this.idEstudiante = codigo;
        
    }

    public void cargarValores() {
        String filePath = "src/archivos/misAsignaturas.txt";
        File file = new File(filePath);
        ArrayList<String> alist = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                String search[] = line.split(",");
                alist.add(search[1]);
                //asignaProfe.add(search[0]);
            }
            String[] lineArray = new String[alist.size()];
            lineArray = alist.toArray(lineArray);
            DefaultComboBoxModel mod = new DefaultComboBoxModel(lineArray);
            jComboBoxAsignatura.setModel(mod);
        } catch (Exception ex) {
            System.err.println("error");
            //Logger.getLogger(TextFileDataToJTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cargarInscripcion(Inscripcion inscripcion) throws IOException{
        this.idEstudiante= inscripcion.getIdEstudiante();
        this.idAsignatura= inscripcion.getIdAsignatura();
        this.idProfesor= inscripcion.getIdProfesor();
        jComboBoxAsignatura.setSelectedItem(idAsignatura);
        jComboBoxProfesor.setSelectedItem(idProfesor);
        //System.err.println("id:"+idProfesor);
        String []asignatura=this.gestionAsignaturas.buscarAsignatura(idAsignatura);
        String []profesor =this.gestionProfesores.buscarProfesor(idProfesor);
        String []tabla={asignatura[1],profesor[1]};
        jTableInscripcion.setAutoCreateRowSorter(true);
        
        DefaultTableModel model = (DefaultTableModel) jTableInscripcion.getModel();
        model.addRow(tabla);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxAsignatura = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxProfesor = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableInscripcion = new javax.swing.JTable();
        jButtonAgregar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jButtonEliminarInscripcion = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButtonRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Asignatura");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 31, -1, -1));

        jComboBoxAsignatura.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxAsignaturaItemStateChanged(evt);
            }
        });
        jComboBoxAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAsignaturaActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 130, -1));

        jLabel2.setText("Profesor");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jComboBoxProfesor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        getContentPane().add(jComboBoxProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 130, -1));

        jTableInscripcion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Asignatura", "Profesor"
            }
        ));
        jTableInscripcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableInscripcionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableInscripcion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 620, 90));

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, -1, -1));

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jButtonEliminarInscripcion.setText("Eliminar");
        jButtonEliminarInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarInscripcionActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEliminarInscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jPanel1.setBackground(new java.awt.Color(253, 206, 83));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonRegresar.setText("Regresar");
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAsignaturaActionPerformed
        try {
            int index = this.jComboBoxAsignatura.getSelectedIndex();
            String asignatura = this.gestionAsignaturas.traerAsignatura(index);
            String[] llenar = asignatura.split(",");
            ArrayList<String[]> asignaProfe = this.gestionAsignaturas.buscarTodosAsignaProfe();
            ArrayList<String> profesores = new ArrayList<>();;
            String[] profesor = null;
            for (int i = 0; i < asignaProfe.size(); i++) {
                String[] aux = asignaProfe.get(i);
                if (aux[0].equals(llenar[0])) {
                    profesor = this.gestionProfesores.buscarProfesor(aux[1]);
                    profesores.add(profesor[1]);
                }
            }
            String[] aux = new String[profesores.size()];
            for (int i = 0; i < profesores.size(); i++) {

                aux[i] = (profesores.get(i));

                System.err.println(aux[0]);
            }
            DefaultComboBoxModel mod = new DefaultComboBoxModel(aux);
            jComboBoxProfesor.setModel(mod);
            //System.err.println(llenar[0]);

        } catch (IOException ex) {
            Logger.getLogger(MostrarInscripcion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBoxAsignaturaActionPerformed
    
    
    public void setAtributos(int posicion) {
        this.jComboBoxAsignatura.setSelectedIndex(posicion);

    }
    
    public void setDisableButtons(){
        this.jButtonEliminarInscripcion.setVisible(false);
        this.jButtonModificar.setVisible(false);
        this.jButtonEliminar.setEnabled(false);
        this.jButtonAgregar.setEnabled(false);
        this.jButtonGuardar.setEnabled(false);
        
    }
    public void deleteButtons(){
        this.jButtonGuardar.setVisible(false);
        this.jButtonEliminarInscripcion.setVisible(true);
        this.jButtonModificar.setVisible(false);

    }
    public void modifyButtons(){
        this.jButtonGuardar.setVisible(false);
        this.jButtonModificar.setVisible(true);
        this.jButtonEliminarInscripcion.setVisible(false);
    }
    public void saveButtons(){
        this.jButtonGuardar.setVisible(true);
        this.jButtonModificar.setVisible(false);
        this.jButtonEliminarInscripcion.setVisible(false);
    }

    private String[] cargarProfesor(int posicion) throws IOException {
        ArrayList<String[]> profesores = this.gestionProfesores.buscarTodos();
        String[] profesor = profesores.get(posicion);
        return profesor;

    }

    private String[] cargarAsignatura(int asig) throws IOException {
        ArrayList<String[]> asignaturas = this.gestionAsignaturas.buscarTodas();
        String[] asignatura = asignaturas.get(asig);
        return asignatura;
    }

    private void jComboBoxAsignaturaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxAsignaturaItemStateChanged
    }//GEN-LAST:event_jComboBoxAsignaturaItemStateChanged

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        
        try {
            int posicion = this.jComboBoxProfesor.getSelectedIndex();
            int asig = this.jComboBoxAsignatura.getSelectedIndex();
            String[] profesor = cargarProfesor(posicion);
            String[] asignatura = cargarAsignatura(asig);
            String[] tabla = {asignatura[1], profesor[1]};
            idAsignatura=asignatura[0];
            idProfesor=profesor[0];
            jTableInscripcion.setAutoCreateRowSorter(true);
            DefaultTableModel model = (DefaultTableModel) jTableInscripcion.getModel();
            model.addRow(tabla);
        } catch (IOException ex) {
            Logger.getLogger(MostrarInscripcion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jTableInscripcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableInscripcionMouseClicked
        jTableInscripcion.getSelectedRow();

    }//GEN-LAST:event_jTableInscripcionMouseClicked

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        int[] selectedRows = jTableInscripcion.getSelectedRows();
        DefaultTableModel model = (DefaultTableModel) jTableInscripcion.getModel();
        if (selectedRows.length > 0) {
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                model.removeRow(selectedRows[i]);
            }
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed
    
    private Inscripcion crearInscripcion(){
        String codigoEstudiante = idEstudiante;
        String codigoAsignatura = idAsignatura;
        String cedulaProfesor = idProfesor;
        Inscripcion inscripcion = new Inscripcion(codigoEstudiante,codigoAsignatura,cedulaProfesor);
        return inscripcion;
    }
    
    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        Inscripcion inscripcion= crearInscripcion();
        this.gestionInscripciones.crearInscripcion(inscripcion);
        
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonEliminarInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarInscripcionActionPerformed
        try {
            Inscripcion inscripcion= crearInscripcion();
            this.gestionInscripciones.modificarInscripcion(inscripcion,1);
            
        } catch (IOException ex) {
            Logger.getLogger(MostrarInscripcion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonEliminarInscripcionActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        try {
            Inscripcion inscripcion= crearInscripcion();
            this.gestionInscripciones.modificarInscripcion(inscripcion,2);
        } catch (IOException ex) {
            Logger.getLogger(MostrarInscripcion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        Inscripciones inscripcion= new Inscripciones();
        inscripcion.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonRegresarActionPerformed

    /**
     * @param args the command line arguments
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MostrarInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MostrarInscripcion dialog = new MostrarInscripcion(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonEliminarInscripcion;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JComboBox<String> jComboBoxAsignatura;
    private javax.swing.JComboBox<String> jComboBoxProfesor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableInscripcion;
    // End of variables declaration//GEN-END:variables

}
