package vista;

import gestion.GestionProfesores;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import negocio.Profesor;

public class Profesores extends javax.swing.JFrame {

    private GestionProfesores gestor = new GestionProfesores();
    private String pathImage = null;

    public Profesores() throws IOException {
        initComponents();
        cargarValoresIniciales();
        cargarProfesores(0);
    }

    // Methode to resize imageIcon with the same size of a Jlabel
    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(jLabelNombreFoto.getWidth(), jLabelNombreFoto.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    private void cargarProfesores(int i) throws IOException {

        ArrayList<String[]> Profesores = gestor.buscarTodos();
        String[] aux = Profesores.get(i);
        for (int j = 0; j < Profesores.size(); j++) {
            this.jTextFieldCedula.setText(aux[0]);
            this.jTextFieldNombre.setText(aux[1]);
            this.jTextFieldApellidos.setText(aux[2]);
            this.jComboBoxPrograma.setSelectedItem(aux[3]);
            this.jLabelNombreFoto.setIcon(ResizeImage("src/archivos/" + aux[4]));
            this.jTextFieldProfesorActual.setText(Integer.toString(i + 1));
            pathImage = "src/archivos/" + aux[4];
        }
    }
    
    private Profesor crearProfesor() {
        String cedula = jTextFieldCedula.getText();
        String nombre = jTextFieldNombre.getText();
        String apellidos = jTextFieldApellidos.getText();
        String programa = (String) jComboBoxPrograma.getSelectedItem();
        String[] iconPath = pathImage.split("/");
        String nombreFoto = iconPath[iconPath.length - 1];
        Profesor profesor = new Profesor(cedula, nombre, apellidos, programa, nombreFoto);
        return profesor;
    }

    private void cargarValoresIniciales() {

        String filePath = "src/archivos/misProgramas.txt";
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
            jComboBoxPrograma.setModel(mod);
        } catch (Exception ex) {
            System.err.println("error");
            //Logger.getLogger(TextFileDataToJTable.class.getName()).log(Level.SEVERE, null, ex);
        }

        jLabelNombreFoto.setIcon(ResizeImage("src/archivos/unknown.jpeg"));
        pathImage = "src/archivos/unknown.jpeg";

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldCedula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldApellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxPrograma = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldProfesorActual = new javax.swing.JTextField();
        jButtonAnterior = new javax.swing.JButton();
        jButtonSiguiente = new javax.swing.JButton();
        jButtonNuevo = new javax.swing.JButton();
        jButtonVerTodos = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonRegresar = new javax.swing.JButton();
        jLabelNombreFoto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1140, 420));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Cédula");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jTextFieldCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCedulaActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 270, -1));

        jLabel2.setText("Nombre");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
        getContentPane().add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 270, -1));

        jLabel3.setText("Apellidos");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));
        getContentPane().add(jTextFieldApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 270, -1));

        jLabel4.setText("Programa");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        getContentPane().add(jComboBoxPrograma, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 270, -1));

        jPanel1.setBackground(new java.awt.Color(1, 1, 1));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jTextFieldProfesorActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 60, -1));

        jButtonAnterior.setText("-");
        jButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

        jButtonSiguiente.setText("+");
        jButtonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguienteActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 40, 30));

        jButtonNuevo.setText("Nuevo");
        jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 130, -1));

        jButtonVerTodos.setText("Ver Todos");
        jPanel1.add(jButtonVerTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 180, -1));

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 140, -1));

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 150, -1));

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 150, -1));

        jButtonRegresar.setText("Regresar");
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 1150, 120));

        jLabelNombreFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNombreFotoMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelNombreFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 170, 160));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 520, 170));

        jPanel2.setBackground(new java.awt.Color(6, 6, 6));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1150, 200));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCedulaActionPerformed

    private void jButtonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoActionPerformed
        Profesor profesor= crearProfesor();
        this.gestor.crearProfesor(profesor);
    }//GEN-LAST:event_jButtonNuevoActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        String cedula = JOptionPane.showInputDialog(this, "Inserte la cédula");
        try {
            int posicion= this.gestor.buscarPosicion(cedula);
            cargarProfesores(posicion);
        } catch (IOException ex) {
            Logger.getLogger(Profesores.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        Profesor profesor = crearProfesor();
        try {
            this.gestor.modificarProfesor(profesor,2);
        } catch (IOException ex) {
            Logger.getLogger(Profesores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        Profesor profesor = crearProfesor();
        try {
            this.gestor.modificarProfesor(profesor,1);
            cargarProfesores(0);
        } catch (IOException ex) {
            Logger.getLogger(Profesores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jLabelNombreFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNombreFotoMouseClicked
        // TODO add your handling code here:
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.dir")));
        
        //filter the files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        //if the user click on save in Jfilechooser
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            jLabelNombreFoto.setIcon(ResizeImage(path));
            pathImage = path;
           // System.err.println(path);
        } //if the user click on save in Jfilechooser
        
        else if (result == JFileChooser.CANCEL_OPTION) {

            System.out.println("No File Select");
        }
    }//GEN-LAST:event_jLabelNombreFotoMouseClicked

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        VistaPrincipal vp= new VistaPrincipal();
        vp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonRegresarActionPerformed

    private void jButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorActionPerformed
        int cargar= Integer.parseInt(this.jTextFieldProfesorActual.getText());
        try {
            if (cargar<2){
                cargar=2;
            }
            this.cargarProfesores(cargar-2);
        } catch (IOException ex) {
            Logger.getLogger(Profesores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAnteriorActionPerformed

    private void jButtonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguienteActionPerformed
        int cargar= Integer.parseInt(this.jTextFieldProfesorActual.getText());
        try {
            int secure = this.gestor.buscarTodos().size();
            if (cargar>=secure){
                cargar= cargar-1;
                }
            this.cargarProfesores(cargar);
        } catch (IOException ex) {
            Logger.getLogger(Profesores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonSiguienteActionPerformed

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
            java.util.logging.Logger.getLogger(Profesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Profesores dialog = new Profesores();
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Profesores.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonNuevo;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JButton jButtonSiguiente;
    private javax.swing.JButton jButtonVerTodos;
    private javax.swing.JComboBox<String> jComboBoxPrograma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelNombreFoto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldApellidos;
    private javax.swing.JTextField jTextFieldCedula;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldProfesorActual;
    // End of variables declaration//GEN-END:variables
}
