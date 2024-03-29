/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package appserver;

import java.io.IOException;
import java.util.Map;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class ServerUI extends javax.swing.JFrame {
    private static Server sv;
    private static ServerUI instance;
    private DefaultTableModel table;

    /**
     * Creates new form ServerUI
     */
    public ServerUI() {
        initComponents();
        this.setSize(400, 110);
        clientScrollTable.setVisible(false);
        table = new DefaultTableModel();
        clientTable.setModel(table);
        table.addColumn("Chat server ID");
        table.addColumn("Number of client");

        instance = this;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        clientScrollTable = new javax.swing.JScrollPane();
        clientTable = new javax.swing.JTable();
        status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("SERVER");

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Port: 12345");

        clientTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null }
                },
                new String[] {
                        "Chat server ID", "Client Number"
                }) {
            Class[] types = new Class[] {
                    java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        clientScrollTable.setViewportView(clientTable);

        status.setText("Status: Disconnected");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(43, 43, 43)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(clientScrollTable,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 375,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(151, 151, 151)
                                                                .addComponent(startButton)))
                                                .addGap(0, 7, Short.MAX_VALUE)))
                                .addContainerGap(12, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(status))
                                .addGap(5, 5, 5)
                                .addComponent(startButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clientScrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 179,
                                        Short.MAX_VALUE)
                                .addContainerGap()));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
        sv.start();
        status.setText("Status: Connected");
        startButton.setVisible(false);
        this.setSize(400, 250);
        clientScrollTable.setVisible(true);
    }// GEN-LAST:event_startButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        sv = new Server();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerUI().setVisible(true);
            }
        });
    }

    public void updateTable() {
        for (int i = 0; table.getRowCount() > 0;) {
            table.removeRow(i);
        }
        Map<Integer, Chat> chatMap = Server.chatMap;
        for (Map.Entry<Integer, Chat> entry : chatMap.entrySet()) {
            Integer id = entry.getKey();
            Chat chatserver = entry.getValue();
            table.addRow(new Object[] { id, chatserver.getClientCount() });
        }
    }

    public static ServerUI getInstance() {
        return instance;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane clientScrollTable;
    private javax.swing.JTable clientTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
