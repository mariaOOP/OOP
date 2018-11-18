package vista;

import gestion.GestionAsignaturas;
import gestion.GestionProfesores;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class TablaAsignaturas extends javax.swing.JDialog {

    /**
     * Creates new form TablaAsignaturas
     */
    private final GestionAsignaturas gestor= new GestionAsignaturas();
    private GestionProfesores gestionProfesores= new GestionProfesores();
    
    public TablaAsignaturas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarAsignaturas();
    }
    
    private void cargarAsignaturas() {
        jTableAsignaturas.setAutoCreateRowSorter(true);
        String filePath = "src/archivos/misAsignaturas.txt";
        File file = new File(filePath);
        //new File("/home/tato/Documentos/misProgramas.txt");
       
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            DefaultTableModel model = (DefaultTableModel) jTableAsignaturas.getModel();
            // toma las lineas del txt
            Object[] tableLines = br.lines().toArray();

            // extrae los datos de cada linea
            // inserta los datos en la tabla
            for (int i = 0; i < tableLines.length; i++) {
                String line = tableLines[i].toString().trim();
                if (!line.equals("")) {
                    String[] dataRow = line.split(",");
                    ArrayList<String> nombreProfesores= new ArrayList<>();
                    ArrayList<String[]> materias= gestor.buscarAsignaProfe(dataRow[0]);
                    for(int j=0;j<materias.size();j++){
                        String[] aux = materias.get(j);
                        String[] profesor=  gestionProfesores.buscarProfesor(aux[1]);
                        String nombreProfesor= profesor[1];
                        nombreProfesores.add(nombreProfesor);
                    }
                    if(nombreProfesores.isEmpty()){
                        String tabla[]={dataRow[0],dataRow[1],dataRow[2]};
                        model.addRow(tabla);
                    }else{
                        String aux= nombreProfesores.toString();
                        String tabla[]={dataRow[0],dataRow[1],dataRow[2],aux};
                        model.addRow(tabla);
                    }
                    
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
        jTableAsignaturas = new javax.swing.JTable();
        jButtonRegresar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableAsignaturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Créditos", "Profesores"
            }
        ));
        jScrollPane1.setViewportView(jTableAsignaturas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 180));

        jButtonRegresar.setText("Regresar");
        getContentPane().add(jButtonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        jPanel1.setBackground(new java.awt.Color(218, 174, 29));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TablaAsignaturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TablaAsignaturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TablaAsignaturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablaAsignaturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TablaAsignaturas dialog = new TablaAsignaturas(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable jTableAsignaturas;
    // End of variables declaration//GEN-END:variables
}