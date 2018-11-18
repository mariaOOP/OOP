package vista;

import gestion.GestionAsignaturas;
import gestion.GestionEstudiantes;
import gestion.GestionProfesores;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class TablaInscripciones extends javax.swing.JDialog {

    private final GestionProfesores gestorProfesores= new GestionProfesores();
    private final GestionEstudiantes gestorEstudiantes= new GestionEstudiantes();
    private final GestionAsignaturas gestorAsiganturas= new GestionAsignaturas();

    public TablaInscripciones(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarInscripciones();
    }

    
    private void cargarInscripciones() {
        jTableInscripciones.setAutoCreateRowSorter(true);
        String filePath = "src/archivos/misInscripciones.txt";
        File file = new File(filePath);
        String[] estudiante = null;
        String[] profesor = null;
        String[] asignatura = null;
        String nombreEstudiante = null;
        String nombreProfesor = null;
        String codigoEstudiante = null;
        String nombrePrograma = null;
        String nombreAsignatura = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            DefaultTableModel model = (DefaultTableModel) jTableInscripciones.getModel();
            // toma las lineas del txt
            Object[] tableLines = br.lines().toArray();

            // extrae los datos de cada linea
            // inserta los datos en la tabla
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                if (!line.equals("")) {
                    String[] traeInfo=line.split(",");
                    estudiante=this.gestorEstudiantes.buscarEstudiante(traeInfo[0]);
                    profesor=this.gestorProfesores.buscarProfesor(traeInfo[2]);
                    asignatura=this.gestorAsiganturas.buscarAsignatura(traeInfo[1]);
                    codigoEstudiante=estudiante[0];
                    nombreEstudiante=estudiante[1];
                    nombrePrograma=estudiante[3];
                    nombreProfesor=profesor[1];
                    nombreAsignatura=asignatura[1];
                    String tabla[]={codigoEstudiante,nombreEstudiante,nombrePrograma,nombreAsignatura,nombreProfesor};
                    model.addRow(tabla);
                }
            }
        } catch (Exception ex) {
            System.err.println("error");
            //Logger.getLogger(TextFileDataToJTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableInscripciones = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButtonRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableInscripciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Estudiante", "Nombre Estudiante", "Nombre Programa", "Nombre Asignatura", "Nombre Profesor"
            }
        ));
        jScrollPane1.setViewportView(jTableInscripciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 660, 240));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 260, -1));

        jPanel1.setBackground(new java.awt.Color(241, 217, 92));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonRegresar.setText("Regresar");
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 323, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) jTableInscripciones.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(jTextField1.getText(), 0));
        jTableInscripciones.setRowSorter(sorter);
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        this.setVisible(false);
        Inscripciones inscripcion = new Inscripciones();
        inscripcion.setVisible(true);
    }//GEN-LAST:event_jButtonRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(TablaInscripciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TablaInscripciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TablaInscripciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablaInscripciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TablaInscripciones dialog = new TablaInscripciones(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableInscripciones;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
