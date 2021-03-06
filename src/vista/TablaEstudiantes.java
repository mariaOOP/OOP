package vista;

import gestion.GestionEstudiantes;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class TablaEstudiantes extends javax.swing.JDialog {

    
    private final GestionEstudiantes gestor= new GestionEstudiantes();
    
    public TablaEstudiantes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarEstudiantes();
    }
    
    public ImageIcon ResizeImage(String ImagePath)
    {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    private void cargarFoto(String codigo) throws IOException{
        //System.err.println(codigo);
        String [] estudiante = this.gestor.buscarEstudiante(codigo);
        //System.err.println(Arrays.toString(estudiante));
        String rutaFoto= "src/archivos/" +estudiante[8];
        //System.err.println(rutaFoto);
        this.jLabel1.setIcon(ResizeImage(rutaFoto));
    }
    
    private void cargarEstudiantes() {
        jTableEstudiantes.setAutoCreateRowSorter(true);
        String filePath = "src/archivos/misEstudiantes.txt";
        File file = new File(filePath);
        //new File("/home/tato/Documentos/misProgramas.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            DefaultTableModel model = (DefaultTableModel) jTableEstudiantes.getModel();
            // toma las lineas del txt
            Object[] tableLines = br.lines().toArray();

            // extrae los datos de cada linea
            // inserta los datos en la tabla
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                if (!line.equals("")) {
                    String[] dataRow = line.split(",");
                    String tabla[]={dataRow[0],dataRow[1],dataRow[2],dataRow[3],dataRow[4],dataRow[6],dataRow[7]};
                    model.addRow(tabla);
                }
            }
        } catch (Exception ex) {
            System.err.println("error");
            //Logger.getLogger(TextFileDataToJTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEstudiantes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButtonRegresar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombres", "Apellidos", "Programa", "Dirección", "Celular", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEstudiantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEstudiantesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableEstudiantes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 1000, 190));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 30, 170, 190));

        jButtonRegresar.setText("Regresar");
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jPanel1.setBackground(new java.awt.Color(12, 10, 5));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableEstudiantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEstudiantesMouseClicked
        int row=jTableEstudiantes.rowAtPoint(evt.getPoint());
        String codigo=jTableEstudiantes.getValueAt(row,0).toString();
        try {
            cargarFoto(codigo);
            //System.err.println(codigo);
        } catch (IOException ex) {
            Logger.getLogger(TablaEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
        //JOptionPane.showMessageDialog(null, "Value in the cell clicked :"+ " " +jTableEstudiantes.getValueAt(row,0).toString());
    }//GEN-LAST:event_jTableEstudiantesMouseClicked

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        try {
            // TODO add your handling code here:
            this.setVisible(false);
            Estudiantes estudiante= new Estudiantes();
            estudiante.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(TablaEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
            java.util.logging.Logger.getLogger(TablaEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TablaEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TablaEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablaEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TablaEstudiantes dialog = new TablaEstudiantes(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEstudiantes;
    // End of variables declaration//GEN-END:variables
}
