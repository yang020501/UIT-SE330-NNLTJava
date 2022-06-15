/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Game;

import Model.Player;
import UI.Board;

/**
 *
 * @author Asus
 */
public class PlayContent extends javax.swing.JPanel {

    /**
     * Creates new form PlayContent
     */
    public PlayContent() {
        initComponents();
        // add chesboard gmae for play component
        Board chess_board = new Board();
        chess_board.boardSetup();
        add(chess_board, java.awt.BorderLayout.CENTER);

    }
    public PlayContent(Player s) {
        initComponents();
        // add chesboard gmae for play component
        Board chess_board = new Board();
        chess_board.boardSetup();
        add(chess_board, java.awt.BorderLayout.CENTER);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backbtn = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(100, 100));
        setPreferredSize(new java.awt.Dimension(625, 550));
        setLayout(new java.awt.BorderLayout());

        backbtn.setFont(new java.awt.Font("STCaiyun", 1, 18)); // NOI18N
        backbtn.setText("Back");
        backbtn.setFocusPainted(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(219, Short.MAX_VALUE)
                .addComponent(backbtn)
                .addGap(166, 166, 166))
        );

        add(jPanel1, java.awt.BorderLayout.LINE_START);
    }// </editor-fold>//GEN-END:initComponents
   //get Main Frame
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton backbtn;
    public javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
