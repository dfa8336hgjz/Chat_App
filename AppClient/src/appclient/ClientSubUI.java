/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package appclient;

import java.io.IOException;

/**
 *
 * @author ASUS
 */
public class ClientSubUI extends javax.swing.JFrame {
        private Client client;

        /**
         * Creates new form ClientSubUI
         */
        public ClientSubUI() {
                initComponents();
                this.setSize(265, 150);
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                chatidField = new javax.swing.JTextField();
                usernameField = new javax.swing.JTextField();
                connectButton = new javax.swing.JButton();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                annouce = new javax.swing.JLabel();
                goToChat = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                chatidField.setText("1");
                chatidField.setVisible(false);
                usernameField.setText("User");

                connectButton.setText("Connect");
                connectButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                connectButtonActionPerformed(evt);
                        }
                });

                jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                jLabel1.setText("Username");

                jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                jLabel2.setText("Chat ID");
                jLabel2.setVisible(false);

                annouce.setForeground(new java.awt.Color(255, 0, 51));
                annouce.setText("Cannot connect to the server!");
                annouce.setVisible(false);

                goToChat.setText("Let's Chat");
                goToChat.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                goToChatActionPerformed(evt);
                        }
                });
                goToChat.setVisible(false);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(24, 24, 24)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel1)
                                                                                .addComponent(jLabel2))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addComponent(chatidField)
                                                                                .addComponent(usernameField,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                131,
                                                                                                Short.MAX_VALUE))
                                                                .addGap(23, 23, 23))
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(52, 52, 52)
                                                                                                .addComponent(annouce))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(78, 78, 78)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(goToChat,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                91,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addGap(8, 8, 8)
                                                                                                                                .addComponent(connectButton)))))
                                                                .addGap(0, 0, 0)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(usernameField,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                34,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel1))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(chatidField,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                34,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel2))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(annouce)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(connectButton)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(goToChat)));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {
                String user = usernameField.getText();
                try {
                        client = new Client();
                } catch (IOException e) {
                        client = null;
                        annouce.setText("Cannot connect to server!");
                        annouce.setVisible(true);
                        return;
                }

                client.setUsername(user);
                ClientUI.thisClient = client;
                client.start();

                goToChat.setVisible(true);
                jLabel1.setVisible(false);
                jLabel2.setVisible(true);
                chatidField.setVisible(true);
                connectButton.setVisible(false);
                usernameField.setVisible(false);
                annouce.setVisible(false);
        }

        private void goToChatActionPerformed(java.awt.event.ActionEvent evt) {
                if (chatidField.getText().isEmpty()) {
                        annouce.setText("Chat ID cannot be empty");
                        annouce.setVisible(true);
                        return;
                }
                Integer chatId = Integer.parseInt(chatidField.getText());
                if (chatId > 10 || chatId < 1) {
                        annouce.setText("Chat ID is only from 1 to 9");
                        annouce.setVisible(true);
                        return;
                }
                client.setPort(chatId);
                client.continueThread();
                ClientUI.instance.setVisible(true);
                ClientUI.instance.updateClientInfo();
                this.setVisible(false);
        }

        private javax.swing.JLabel annouce;
        private javax.swing.JTextField chatidField;
        private javax.swing.JButton connectButton;
        private javax.swing.JButton goToChat;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JTextField usernameField;
        // End of variables declaration//GEN-END:variables
}
