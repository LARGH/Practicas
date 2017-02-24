package vistas;

import java.awt.Color;
import javax.swing.JOptionPane;
import modelo.Imprimible;
import modelo.Servidor;

public class VistaServidor extends javax.swing.JFrame implements Imprimible {
    
    private boolean  connected = false;
    private Servidor servidor;
    private Thread   hiloservidor;
    private Imprimible imp;
    private StringBuilder build = null;
    
    public VistaServidor() {
        imp = this;
        build = new StringBuilder("");
        servidor = new Servidor(imp);
        hiloservidor = new Thread(new HiloDeCliente());
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        tituloArea = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        closeWindow = new javax.swing.JButton();
        scrollPanelTextArea = new javax.swing.JScrollPane();
        areaArchivos = new javax.swing.JTextArea();
        etiquetaClientes = new javax.swing.JLabel();
        iniciarCnexion = new javax.swing.JButton();
        closeConexion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Servidor");
        setName("marco"); // NOI18N

        tituloArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tituloArea.setText("Lista de archivos recibidos:");

        closeWindow.setText("Cerrar");
        closeWindow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeWindowMouseClicked(evt);
            }
        });

        areaArchivos.setColumns(20);
        areaArchivos.setRows(5);
        scrollPanelTextArea.setViewportView(areaArchivos);

        etiquetaClientes.setForeground(new java.awt.Color(255, 0, 0));
        etiquetaClientes.setText("There's not client connected");

        iniciarCnexion.setText("Iniciar conexion");
        iniciarCnexion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iniciarCnexionMouseClicked(evt);
            }
        });

        closeConexion.setText("Terminar conexion");
        closeConexion.setEnabled(false);
        closeConexion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeConexionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPrincipalLayout.createSequentialGroup()
                        .addComponent(tituloArea)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etiquetaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollPanelTextArea, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                    .addComponent(separador, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(iniciarCnexion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(closeConexion, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(closeWindow, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloArea)
                    .addComponent(etiquetaClientes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPanelTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeWindow)
                    .addComponent(closeConexion)
                    .addComponent(iniciarCnexion))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeWindowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeWindowMouseClicked
        Object [] opciones ={ "Aceptar", "Cancelar" };
        int eleccion = JOptionPane.showOptionDialog(rootPane,
            "En realidad desea realizar cerrar la aplicacion","Mensaje de Confirmacion",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar"
        );
        if (eleccion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_closeWindowMouseClicked

    private void iniciarCnexionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iniciarCnexionMouseClicked
        connected = true;
        initService();
        closeConexion.setEnabled(true);
        iniciarCnexion.setEnabled(false);
        areaArchivos.setText("");
        int q = JOptionPane.OK_OPTION;
        JOptionPane.showMessageDialog( null, "\"Servidor listo... esperando clientes...", null, q );
    }//GEN-LAST:event_iniciarCnexionMouseClicked

    private void closeConexionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeConexionMouseClicked
        iniciarCnexion.setEnabled(true);
        closeConexion.setEnabled(false);
        etiquetaClientes.setText("There's not client connected");
        etiquetaClientes.setForeground(Color.red);
        areaArchivos.setText("");
        connected = false;
        build = new StringBuilder("");
    }//GEN-LAST:event_closeConexionMouseClicked
    
    private void initService () {
        new Thread(new HiloDeCliente()).start();
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
            java.util.logging.Logger.getLogger(VistaServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaServidor().setVisible(true);
            }
        });
    }
    
    @Override
    public void imprimirInformacion (String arg) {
        if (arg != null) {
            build.append(arg);
        }
        areaArchivos.setText(arg);
    }
    
    @Override
    public void showAdviceToServer (String advice) {
        int q = JOptionPane.OK_OPTION;
        JOptionPane.showMessageDialog( null, advice, null, q );
    }
    
    @Override
    public void isConnectedToServer (boolean conn) {
        if (conn) {
            etiquetaClientes.setText("Client connected");
            etiquetaClientes.setForeground(Color.green);
        } else {
            etiquetaClientes.setText("There's not client connected");
            etiquetaClientes.setForeground(Color.red);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaArchivos;
    private javax.swing.JButton closeConexion;
    private javax.swing.JButton closeWindow;
    private javax.swing.JLabel etiquetaClientes;
    private javax.swing.JButton iniciarCnexion;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JScrollPane scrollPanelTextArea;
    private javax.swing.JSeparator separador;
    private javax.swing.JLabel tituloArea;
    // End of variables declaration//GEN-END:variables

    private class HiloDeCliente implements Runnable {
        @Override
        public void run() {
            while (connected) {
                servidor.aceptaConexion();
                servidor.recibe();
                servidor.terminaConexion();
                etiquetaClientes.setText("Client disconnected...");
                etiquetaClientes.setForeground(Color.red);
            }
        }
    }
}
