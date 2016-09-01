package vistas;

import java.awt.Color;
import modelo.FileDrop;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Connectable;

public class VistaCliente extends javax.swing.JFrame implements Connectable {

    private int approved;
    private Cliente cliente;
    private JFileChooser archivos;
    private Connectable conn;
    private File[] filesArray;
    
    public VistaCliente() {
        try {
            conn = this;
            iniciarCliente();
            archivos = null;
            filesArray = new File[0];
        } catch (Exception e) {
            System.err.println("Mensaje de error: " + e.getMessage());
        }
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedorPrincipal = new javax.swing.JPanel();
        tituloEtiquetaEditorPane = new javax.swing.JLabel();
        seleccionArchivos = new javax.swing.JButton();
        envioArchivos = new javax.swing.JButton();
        separador = new javax.swing.JSeparator();
        scrollPanelTextArea = new javax.swing.JScrollPane();
        areaArchivos = new javax.swing.JTextArea();
        closeWindow = new javax.swing.JButton();
        ifConnected = new javax.swing.JLabel();
        newCargaFiles = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente");

        tituloEtiquetaEditorPane.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tituloEtiquetaEditorPane.setText("Lista de archivos cliente: ");

        seleccionArchivos.setText("Seleccionar archivo");
        seleccionArchivos.setEnabled(false);
        seleccionArchivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleccionArchivosMouseClicked(evt);
            }
        });

        envioArchivos.setText("Enviar");
        envioArchivos.setEnabled(false);
        envioArchivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                envioArchivosMouseClicked(evt);
            }
        });

        areaArchivos.setColumns(20);
        areaArchivos.setRows(5);
        areaArchivos.setDragEnabled(true);
        scrollPanelTextArea.setViewportView(areaArchivos);
        new FileDrop( System.out, areaArchivos, /*dragBorder,*/ new FileDrop.Listener()
            {
                public void filesDropped( java.io.File[] files )
                {
                    for( int i = 0; i < files.length; i++ )
                    {
                        try {
                            areaArchivos.append( files[i].getCanonicalPath() + "\n" );
                        } catch( java.io.IOException e ) {
                            e.printStackTrace();
                        }
                    }
                    envioArchivos.setEnabled(true);
                    File[] tmp = new File[filesArray.length + files.length];
                    System.arraycopy(filesArray, 0, tmp, 0, filesArray.length);
                    System.arraycopy(files, 0, tmp, filesArray.length, files.length);
                    filesArray = tmp;
                }
            });

            closeWindow.setText("Cerrar");
            closeWindow.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    closeWindowMouseClicked(evt);
                }
            });

            ifConnected.setForeground(new java.awt.Color(255, 0, 0));
            ifConnected.setText("Not connected to server");

            newCargaFiles.setText("Nuevo");
            newCargaFiles.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    newCargaFilesMouseClicked(evt);
                }
            });

            javax.swing.GroupLayout contenedorPrincipalLayout = new javax.swing.GroupLayout(contenedorPrincipal);
            contenedorPrincipal.setLayout(contenedorPrincipalLayout);
            contenedorPrincipalLayout.setHorizontalGroup(
                contenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contenedorPrincipalLayout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addGroup(contenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorPrincipalLayout.createSequentialGroup()
                            .addComponent(newCargaFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(24, 24, 24)
                            .addComponent(seleccionArchivos)
                            .addGap(18, 18, 18)
                            .addComponent(envioArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(closeWindow, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(contenedorPrincipalLayout.createSequentialGroup()
                            .addComponent(tituloEtiquetaEditorPane)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ifConnected))
                        .addComponent(separador, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                        .addComponent(scrollPanelTextArea))
                    .addContainerGap(40, Short.MAX_VALUE))
            );
            contenedorPrincipalLayout.setVerticalGroup(
                contenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contenedorPrincipalLayout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addGroup(contenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tituloEtiquetaEditorPane)
                        .addComponent(ifConnected, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(7, 7, 7)
                    .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scrollPanelTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(28, 28, 28)
                    .addGroup(contenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(seleccionArchivos)
                        .addComponent(envioArchivos)
                        .addComponent(closeWindow)
                        .addComponent(newCargaFiles))
                    .addContainerGap(12, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(contenedorPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(contenedorPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void seleccionArchivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionArchivosMouseClicked
        archivos = new JFileChooser();
        archivos.setMultiSelectionEnabled(true);
        approved = archivos.showOpenDialog(null);
        if ( approved == JFileChooser.APPROVE_OPTION ) {
            for (File file : archivos.getSelectedFiles()) {
                try {
                    areaArchivos.append( file.getCanonicalPath() + "\n" );
                } catch (IOException ex) {
                    System.out.println("Ha ocurrido un error de E/S: " + ex.getMessage());
                }
            }
            File[] files=archivos.getSelectedFiles();
            File[] tmp = new File[filesArray.length + files.length];
            System.arraycopy(filesArray, 0, tmp, 0, filesArray.length);
            System.arraycopy(files, 0, tmp, filesArray.length, files.length);
            filesArray = tmp;
            envioArchivos.setEnabled(true);
        } else if ( approved == JFileChooser.CANCEL_OPTION ) {
            envioArchivos.setEnabled(false);
        }
    }//GEN-LAST:event_seleccionArchivosMouseClicked

    private void envioArchivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_envioArchivosMouseClicked
        if (cliente.envia(filesArray)) {
            Object [] opciones = { "Aceptar" };
            int eleccion = JOptionPane.showOptionDialog(rootPane,
                "Archivos enviados!!!","Mensaje de Confirmacion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.OK_OPTION, null, opciones, "Aceptar"
            );
            envioArchivos.setEnabled(false);
            seleccionArchivos.setEnabled(true);
            newCargaFiles.setEnabled(true);
            if (archivos != null) archivos.removeAll();
        }
    }//GEN-LAST:event_envioArchivosMouseClicked

    private void closeWindowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeWindowMouseClicked
        Object [] opciones ={ "Aceptar", "Cancelar" };
        int eleccion = JOptionPane.showOptionDialog(rootPane,
            "En realidad desea realizar cerrar la aplicacion\n Se cerrara la conexion!!!","Mensaje de Confirmacion",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar"
        );
        if (eleccion == JOptionPane.YES_OPTION) {
            cliente.destruir();
            System.exit(0);
        }
    }//GEN-LAST:event_closeWindowMouseClicked

    private void newCargaFilesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newCargaFilesMouseClicked
        areaArchivos.setText("");
        if (archivos != null) archivos.removeAll();
        seleccionArchivos.setEnabled(true);
        newCargaFiles.setEnabled(false);
    }//GEN-LAST:event_newCargaFilesMouseClicked

    @Override
    public void isRunning (boolean connected) {
        if (connected) {
            ifConnected.setText("Connected to the server...");
            ifConnected.setForeground(Color.green);
        } else {
            ifConnected.setText("Not connected to server");
            ifConnected.setForeground(Color.red);
        }
    }

    private void iniciarCliente () {
        cliente = new Cliente(conn);
    }

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
            java.util.logging.Logger.getLogger(VistaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaArchivos;
    private javax.swing.JButton closeWindow;
    private javax.swing.JPanel contenedorPrincipal;
    private javax.swing.JButton envioArchivos;
    private javax.swing.JLabel ifConnected;
    private javax.swing.JButton newCargaFiles;
    private javax.swing.JScrollPane scrollPanelTextArea;
    private javax.swing.JButton seleccionArchivos;
    private javax.swing.JSeparator separador;
    private javax.swing.JLabel tituloEtiquetaEditorPane;
    // End of variables declaration//GEN-END:variables
}
