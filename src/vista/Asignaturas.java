package vista;

import gestion.GestionAsignaturas;
import gestion.GestionProfesores;
import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import negocio.Asignatura;

public class Asignaturas extends javax.swing.JDialog {

    private final GestionAsignaturas gestor = new GestionAsignaturas();
    private final GestionProfesores gestionProfesores = new GestionProfesores();

    public Asignaturas() throws IOException {
        initComponents();
        cargarValoresIniciales();
       // cargarAsignaturas(0);
    }
    
    private void cargarAsignaturas(int i) throws IOException {

        ArrayList<String[]> Asignaturas = gestor.buscarTodas();
        String[] aux = Asignaturas.get(i);
        for (int j = 0; j < Asignaturas.size(); j++) {
            this.jTextFieldCodigo.setText(aux[0]);
            this.jTextFieldNombre.setText(aux[1]);
            this.jTextFieldAsignaturaActual.setText(Integer.toString(i + 1));

        }
    }

    private Asignatura crearAsignatura() {
        String cedula = jTextFieldCodigo.getText();
        String nombre = jTextFieldNombre.getText();
        String creditos = (String) jComboBoxCreditos.getSelectedItem();
        Asignatura asignatura = new Asignatura(cedula, nombre, creditos);
        return asignatura;
    }
    

    private void cargarValoresIniciales() {

        String filePath = "src/archivos/misProfesores.txt";
        File file = new File(filePath);
        ArrayList<String> alist = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                String search[] = line.split(",");
                alist.add(search[1]);
            }
            String[] lineArray = new String[alist.size()];
            lineArray = alist.toArray(lineArray);
            DefaultComboBoxModel mod = new DefaultComboBoxModel(lineArray);
            jComboBoxProfesor.setModel(mod);
        } catch (Exception ex) {
            System.err.println("error");
            //Logger.getLogger(TextFileDataToJTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String[] cargarProfesor(int posicion) throws IOException {
        ArrayList<String[]> profesores = this.gestionProfesores.buscarTodos();
        String[] profesor = profesores.get(posicion);
        return profesor;

    }
    
    private void cargarTablaAsignaProfe(String codigo) throws FileNotFoundException, IOException{
        
        jTableProfesores.setAutoCreateRowSorter(true);
        DefaultTableModel model = (DefaultTableModel) jTableProfesores.getModel();
        ArrayList<String[]> asignaProfe = this.gestor.buscarTodosAsignaProfe();
        for(int i=0;i<asignaProfe.size();i++){
            String[] aux = asignaProfe.get(i);
            
            if(aux[0].equals(codigo)){
                String[] profesor= this.gestionProfesores.buscarProfesor(aux[1]);
                model.addRow(profesor);
                //System.out.println("posicion :"+profesor[0]+","+profesor[1]);
            }
        }
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxCreditos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProfesores = new javax.swing.JTable();
        jComboBoxProfesor = new javax.swing.JComboBox<>();
        jButtonAgregarProfesor = new javax.swing.JButton();
        jButtonEliminarProfesor = new javax.swing.JButton();
        jButtonAnterior = new javax.swing.JButton();
        jTextFieldAsignaturaActual = new javax.swing.JTextField();
        jButtonSiguiente = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jButtonVerTodas = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jButtonRegresar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButtontest = new javax.swing.JButton();
        jTextFieldtest = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Código");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 27, -1, -1));
        getContentPane().add(jTextFieldCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 160, -1));

        jLabel2.setText("Nombre");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, -1));
        getContentPane().add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 180, -1));

        jLabel3.setText("Créditos");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, -1, -1));

        jComboBoxCreditos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        getContentPane().add(jComboBoxCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 90, -1));

        jLabel4.setText("                            PROFESORES     QUE    LA   DICTAN");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 490, 20));

        jTableProfesores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cédula", "Nombres", "Apellidos", "Programa"
            }
        ));
        jTableProfesores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProfesoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProfesores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 890, 100));

        getContentPane().add(jComboBoxProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 230, -1));

        jButtonAgregarProfesor.setText("Agregar");
        jButtonAgregarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarProfesorActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAgregarProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 140, -1));

        jButtonEliminarProfesor.setText("Desagregar");
        jButtonEliminarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarProfesorActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEliminarProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 140, -1));

        jButtonAnterior.setText("-");
        getContentPane().add(jButtonAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 50, 30));
        getContentPane().add(jTextFieldAsignaturaActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 50, -1));

        jButtonSiguiente.setText("+");
        getContentPane().add(jButtonSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 50, 30));

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 150, 30));

        jButtonVerTodas.setText("Ver Todas");
        getContentPane().add(jButtonVerTodas, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 120, -1));

        jButtonModificar.setText("Modificar");
        getContentPane().add(jButtonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 290, 120, -1));

        jButtonEliminar.setText("Eliminar");
        getContentPane().add(jButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 290, 140, -1));

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, 100, -1));

        jButtonRegresar.setText("Regresar");
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        jPanel1.setBackground(new java.awt.Color(184, 133, 70));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtontest.setText("test");
        jButtontest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtontestActionPerformed(evt);
            }
        });
        jPanel1.add(jButtontest, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 61, -1, -1));
        jPanel1.add(jTextFieldtest, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 120, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 940, 100));

        jPanel2.setBackground(new java.awt.Color(4, 3, 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Profesor");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarProfesorActionPerformed
        try {
            int posicion = this.jComboBoxProfesor.getSelectedIndex();
            String[] profesor = cargarProfesor(posicion);
            jTableProfesores.setAutoCreateRowSorter(true);
            DefaultTableModel model = (DefaultTableModel) jTableProfesores.getModel();
            model.addRow(profesor);
        } catch (IOException ex) {
            Logger.getLogger(Asignaturas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAgregarProfesorActionPerformed
    
    private void jTableProfesoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProfesoresMouseClicked
        jTableProfesores.getSelectedRow();
    }//GEN-LAST:event_jTableProfesoresMouseClicked

    private void jButtonEliminarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarProfesorActionPerformed
        int[] selectedRows = jTableProfesores.getSelectedRows();
        DefaultTableModel model = (DefaultTableModel) jTableProfesores.getModel();
        if (selectedRows.length > 0) {
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                model.removeRow(selectedRows[i]);
            }
        }
    }//GEN-LAST:event_jButtonEliminarProfesorActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        String codigo = jTextFieldCodigo.getText();
        Asignatura asignatura = crearAsignatura();
        
        DefaultTableModel model = (DefaultTableModel) jTableProfesores.getModel();
        ArrayList<String> cedulasProfesores = new ArrayList<>();
        for (int count = 0; count < model.getRowCount(); count++) {
            cedulasProfesores.add(model.getValueAt(count, 0).toString());
        }
        for(int i =0; i< cedulasProfesores.size(); i++){
            String cedula= cedulasProfesores.get(i);
            try {
                this.gestor.crearAsignaProfe(codigo, cedula);
                this.gestor.crearAsignatura(asignatura);
            } catch (IOException ex) {
                Logger.getLogger(Asignaturas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
       
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        String codigo = JOptionPane.showInputDialog(this, "Inserte el codigo");
        try {
            int posicion= this.gestor.buscarPosicion(codigo);
            cargarAsignaturas(posicion);
        } catch (IOException ex) {
            Logger.getLogger(Profesores.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        VistaPrincipal vp= new VistaPrincipal();
        vp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonRegresarActionPerformed

    private void jButtontestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtontestActionPerformed
        try {
            // TODO add your handling code here:
            String test= jTextFieldtest.getText();
            cargarTablaAsignaProfe(test);
        } catch (IOException ex) {
            Logger.getLogger(Asignaturas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtontestActionPerformed

    
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
            java.util.logging.Logger.getLogger(Asignaturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Asignaturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Asignaturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Asignaturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Asignaturas dialog = new Asignaturas();
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Asignaturas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarProfesor;
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonEliminarProfesor;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JButton jButtonSiguiente;
    private javax.swing.JButton jButtonVerTodas;
    private javax.swing.JButton jButtontest;
    private javax.swing.JComboBox<String> jComboBoxCreditos;
    private javax.swing.JComboBox<String> jComboBoxProfesor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProfesores;
    private javax.swing.JTextField jTextFieldAsignaturaActual;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldtest;
    // End of variables declaration//GEN-END:variables
}
