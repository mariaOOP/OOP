package vista;

import gestion.GestionAsignaturas;
import gestion.GestionEstudiantes;
import gestion.GestionInscripciones;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import negocio.Inscripcion;

public class BuscarInscripcion extends javax.swing.JDialog {

    GestionEstudiantes gestionEstudiantes = new GestionEstudiantes();
    /**
     * Creates new form BuscarInscripcion
     */
    GestionAsignaturas gestionAsignaturas = new GestionAsignaturas();
    GestionInscripciones gestionInscripciones = new GestionInscripciones();

    public BuscarInscripcion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void botonesGuardar() {
        this.jButtonBuscar.setVisible(false);
        this.jButtonEliminar.setVisible(false);
        this.jButtonGuardar.setVisible(true);
        this.jButtonModificar.setVisible(false);
    }

    public void botonesEliminar() {
        this.jButtonBuscar.setVisible(false);
        this.jButtonEliminar.setVisible(true);
        this.jButtonGuardar.setVisible(false);
        this.jButtonModificar.setVisible(false);
    }

    public void botonesModificar() {
        this.jButtonBuscar.setVisible(false);
        this.jButtonEliminar.setVisible(false);
        this.jButtonGuardar.setVisible(false);
        this.jButtonModificar.setVisible(true);
    }

    public void botonesBuscar() {
        this.jButtonBuscar.setVisible(true);
        this.jButtonEliminar.setVisible(false);
        this.jButtonGuardar.setVisible(false);
        this.jButtonModificar.setVisible(false);
    }

    private void cargarValores() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonBuscar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jPasswordFieldPassword = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jButtonRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jTextFieldCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 290, -1));

        jLabel1.setText("codigo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jButtonGuardar.setText("Crear");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));
        getContentPane().add(jPasswordFieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 290, -1));

        jPanel1.setBackground(new java.awt.Color(235, 204, 65));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonRegresar.setText("Regresar");
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        Inscripciones inscripciones = new Inscripciones();
        inscripciones.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonRegresarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        try {
            char[] pass=jPasswordFieldPassword.getPassword();
            
            String codigo = this.jTextFieldCodigo.getText();
            String[] inscripcion = this.gestionInscripciones.asignaturaCodigo(codigo);
            Inscripcion inscri = new Inscripcion(inscripcion[0], inscripcion[1], inscripcion[2]);
            String password = String.copyValueOf(pass);
            boolean test=gestionEstudiantes.comprobarPassword(codigo, password);
            if (test) {
                MostrarInscripcion buscar = new MostrarInscripcion(null, rootPaneCheckingEnabled);
                buscar.codEstudiante(codigo);
                buscar.setDisableButtons();
                buscar.cargarInscripcion(inscri);
                buscar.setVisible(true);
                this.setVisible(false);
            }else {
                JOptionPane.showMessageDialog(null, "Password incorrecto");
            }
        } catch (IOException ex) {
            Logger.getLogger(BuscarInscripcion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        try {
            char[] pass=jPasswordFieldPassword.getPassword();
            String codigo = this.jTextFieldCodigo.getText();
            String[] inscripcion = this.gestionInscripciones.asignaturaCodigo(codigo);
            Inscripcion inscri = new Inscripcion(inscripcion[0], inscripcion[1], inscripcion[2]);
            String password = String.copyValueOf(pass);
            boolean probarPassword=gestionEstudiantes.comprobarPassword(codigo, password);
            boolean probarInscripcion= gestionInscripciones.comprobarInscripcion(codigo);
            if (probarPassword) {
                if(!probarInscripcion){
                    MostrarInscripcion guardar = new MostrarInscripcion(null, rootPaneCheckingEnabled);
                    guardar.codEstudiante(codigo);
                    guardar.cargarValores();
                    guardar.saveButtons();
                    //guardar.cargarInscripcion(inscri);
                    guardar.setVisible(true);
                    this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Ya realizaste una inscripcion");
                }
            }else {
                JOptionPane.showMessageDialog(null, "Password incorrecto");
            }
        } catch (IOException ex) {
            Logger.getLogger(BuscarInscripcion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        try {
            char[] pass=jPasswordFieldPassword.getPassword();
            String codigo = this.jTextFieldCodigo.getText();
            String[] inscripcion = this.gestionInscripciones.asignaturaCodigo(codigo);
            Inscripcion inscri = new Inscripcion(inscripcion[0], inscripcion[1], inscripcion[2]);
            String password = String.copyValueOf(pass);
            boolean probarPassword=gestionEstudiantes.comprobarPassword(codigo, password);
            boolean probarInscripcion= gestionInscripciones.comprobarInscripcion(codigo);
            if (probarPassword) {
                if(probarInscripcion){
                    MostrarInscripcion eliminar = new MostrarInscripcion(null, rootPaneCheckingEnabled);
                    eliminar.codEstudiante(codigo);
                    eliminar.deleteButtons();
                    eliminar.cargarInscripcion(inscri);
                    eliminar.setVisible(true);
                    this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Aun no realizas una inscripción");
                }
            }else {
                JOptionPane.showMessageDialog(null, "Password incorrecto");
            }
        } catch (IOException ex) {
            Logger.getLogger(BuscarInscripcion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        try {
            char[] pass=jPasswordFieldPassword.getPassword();
            String codigo = this.jTextFieldCodigo.getText();
            String[] inscripcion = this.gestionInscripciones.asignaturaCodigo(codigo);
            Inscripcion inscri = new Inscripcion(inscripcion[0], inscripcion[1], inscripcion[2]);
            String password = String.copyValueOf(pass);
            boolean probarPassword=gestionEstudiantes.comprobarPassword(codigo, password);
            boolean probarInscripcion= gestionInscripciones.comprobarInscripcion(codigo);
            if (probarPassword) {
                if(probarInscripcion){
                    MostrarInscripcion modificar = new MostrarInscripcion(null, rootPaneCheckingEnabled);
                    modificar.codEstudiante(codigo);
                    modificar.modifyButtons();
                    modificar.cargarInscripcion(inscri);
                    modificar.setVisible(true);
                    this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Aun no realizas una inscripción");
                }
            }else {
                JOptionPane.showMessageDialog(null, "Password incorrecto");
            }
        } catch (IOException ex) {
            Logger.getLogger(BuscarInscripcion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuscarInscripcion dialog = new BuscarInscripcion(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JTextField jTextFieldCodigo;
    // End of variables declaration//GEN-END:variables
}