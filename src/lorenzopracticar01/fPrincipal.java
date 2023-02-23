package lorenzopracticar01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fPrincipal extends javax.swing.JFrame {
    private JdConectar jd;
    private DefaultTableModel dtm;
    public static Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private int filasafectadas;
    private String ins;

    public fPrincipal() {

        /* Abrimos el JDialog de Conexion */

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        jd = new JdConectar(this, true);
        jd.setVisible(true);
        
        initComponents();
        bJSON.setVisible(false);
        dtm = (DefaultTableModel) jTable1.getModel();
        
        rellenarTabla();
    }
    
    private void rellenarTabla(){
        ins = "Select * from alumnos";
        dtm.setRowCount(0);
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(ins);
            while (rs.next() == true) {   
                dtm.addRow(new Object[] {rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)});
            }
            rs.close();
        } catch (SQLException ex) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btSelecc = new javax.swing.JButton();
        txtFichero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btEjecutar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        taScripts = new javax.swing.JTextArea();
        bJSON = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ejecucion de Script de Oracle");

        jLabel1.setText("Archivo Scripts");

        btSelecc.setText("Seleccionar");
        btSelecc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSeleccActionPerformed(evt);
            }
        });

        txtFichero.setEditable(false);

        jLabel2.setText("Sentencia SQL");

        btEjecutar.setText("Ejecutar");
        btEjecutar.setEnabled(false);
        btEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEjecutarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Asignatura", "Nota Final"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        taScripts.setColumns(20);
        taScripts.setRows(5);
        jScrollPane2.setViewportView(taScripts);

        bJSON.setText("Generar JSON");
        bJSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bJSONActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFichero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSelecc, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btEjecutar, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(bJSON, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btSelecc)
                    .addComponent(txtFichero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(btEjecutar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bJSON))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSeleccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSeleccActionPerformed
        /* Selecciona un fichero de texto:
           En caso de seleccionar un fichero se rellena el JTextField txtFichero,
           se llama al método leerFichero y se activa el boton btEjecutar
        */
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.setDialogTitle("Abrir");
            chooser.showOpenDialog(this);
            File f = chooser.getSelectedFile();
            txtFichero.setText(f.getAbsolutePath());
            leerFichero();
            bJSON.setVisible(false);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Selecciona un fichero", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btSeleccActionPerformed

    private void leerFichero() {
        /* Este metodo rellena el TextArea taScripts con los datos del fichero
           indicado en txtFichero.getText().trim()
        */
        try {
            FileReader fr = new FileReader(new File(txtFichero.getText().trim()));
            BufferedReader br = new BufferedReader(fr);
            String texto = "";
            String linea = br.readLine();
            while (linea != null) {                
                texto += linea + "\n";
                linea = br.readLine();
            }
            fr.close();
            br.close();
            taScripts.setText(texto);
            if (!taScripts.getText().trim().isEmpty()) {
                btEjecutar.setEnabled(true);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Fichero no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al leer", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEjecutarActionPerformed
        /* En este metodo se ejecuta la sentencia SQL contenida en cada linea del
           fichero de texto.
           Despues de ejecutar todas las lineas se actualiza el JTable
        */
        try {
            FileReader fr = new FileReader(new File(txtFichero.getText().trim()));
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null) {                
                ejecutarLinea(linea);
                linea = br.readLine();
            }
            fr.close();
            br.close();
            JOptionPane.showMessageDialog(this, "Archivo ejecutado");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Fichero no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al leer", "Error", JOptionPane.ERROR_MESSAGE);
        }
        rellenarTabla();
    }//GEN-LAST:event_btEjecutarActionPerformed

    private void bJSONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bJSONActionPerformed
        try {
            FileWriter fw = new FileWriter(new File("datosGenerados.json"));
            fw.write("{");
            fw.write("\"alumnos\":[");

            // Recorremos todas las filas de la tabla
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                fw.write("{");
                fw.write("\"codigo\":\"" + jTable1.getValueAt(i, 0) + "\",");
                fw.write("\"nombre\":\"" + jTable1.getValueAt(i, 1) + "\",");
                fw.write("\"asignatura\":\"" + jTable1.getValueAt(i, 2) + "\",");
                fw.write("\"notaFinal\":\"" + jTable1.getValueAt(i, 3) + "\"");
                fw.write("}");

                // Si no es la última fila, agregamos una coma para separar cada objeto JSON
                if (i != jTable1.getRowCount() - 1) {
                    fw.write(",");
                }
            }
            fw.write("]");
            fw.write("}");
            fw.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al leer", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bJSONActionPerformed

    private void ejecutarLinea(String linea) {
        char letra;
        linea = linea.toUpperCase();
        if (!linea.trim().isEmpty()) {
            letra = linea.trim().charAt(0);
            /*
         Este metodo ejecuta la sentencia SQL contenida en el String linea 
         que se pasa como parámetro.
        
            Si la primera letra de este String es una S, se tratará de una sentencia SELECT
         que rellenará el JTable con los registros obtenidos por dicha consulta, 
         sin borrar los anteriores.
        
               Si la primera letra de este String es una I (Insert), D (delete) o U (Update)
        se ejecutará la sentencia y se mostrarán los registros afectados por cada operación.
        
        */  
            if (letra == 'S') {
                try {
                    Statement statement = con.createStatement();
                    rs = statement.executeQuery(linea);
                    while (rs.next() == true) {
                        dtm.addRow(new Object[] {rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)});
                    }
                    rs.close();
                    JOptionPane.showMessageDialog(this, "Select añadido al jTable");
                    bJSON.setVisible(true);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error en " + linea + "\n" + ex.getMessage());
                }
            }else{
                try {
                    Statement statement = con.createStatement();
                    filasafectadas = statement.executeUpdate(linea);
                    JOptionPane.showMessageDialog(this, filasafectadas + " filas afectadas por " + letra);
                    bJSON.setVisible(true);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error en " + linea + ". " + ex.getMessage());
                }
            }
        }
    }
    
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
            java.util.logging.Logger.getLogger(fPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bJSON;
    private javax.swing.JButton btEjecutar;
    private javax.swing.JButton btSelecc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea taScripts;
    private javax.swing.JTextField txtFichero;
    // End of variables declaration//GEN-END:variables
}
