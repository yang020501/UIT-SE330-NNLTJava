/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Game;

import Model.Player;
import java.awt.Image;
import java.net.URL;
import javax.swing.*;

/**
 *
 * @author Asus
 */
public class Menu extends javax.swing.JPanel {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        Icon bg = new ImageIcon("../Chess_Engine/Resources/bg.jpg");
        jLabel1.setIcon(bg);

    }

    /*public Menu(Player s) {
        initComponents();
        Icon bg = new ImageIcon("../Chess_Engine/Resources/bg.jpg");
        jLabel1.setIcon(bg);

    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        stgBtn = new javax.swing.JButton();
        closeBtn = new javax.swing.JButton();
        playBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stgBtn.setBackground(new java.awt.Color(209, 209, 209));
        stgBtn.setFont(new java.awt.Font("STCaiyun", 1, 18)); // NOI18N
        stgBtn.setForeground(new java.awt.Color(60, 46, 3));
        stgBtn.setText("Setting");
        stgBtn.setFocusPainted(false);
        add(stgBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 130, 30));

        closeBtn.setBackground(new java.awt.Color(209, 209, 209));
        closeBtn.setFont(new java.awt.Font("STCaiyun", 1, 18)); // NOI18N
        closeBtn.setForeground(new java.awt.Color(60, 46, 3));
        closeBtn.setText("Exit");
        closeBtn.setToolTipText("");
        closeBtn.setFocusPainted(false);
        add(closeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 130, 30));

        playBtn.setBackground(new java.awt.Color(209, 209, 209));
        playBtn.setFont(new java.awt.Font("STCaiyun", 1, 18)); // NOI18N
        playBtn.setForeground(new java.awt.Color(60, 46, 3));
        playBtn.setText("Play Game");
        playBtn.setFocusPainted(false);
        add(playBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 130, 30));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 410));
    }// </editor-fold>//GEN-END:initComponents
    // update Menu by player

    public void Update(Player s) {
        String tmp = s.getTheme();
        if (tmp == "fall") {
            Icon bg = new ImageIcon("../Chess_Engine/Resources/bg.jpg");
            jLabel1.setIcon(bg);
        } else if (tmp == "sky") {
            Icon bg = new ImageIcon("../Chess_Engine/Resources/bg2.jpg");
            jLabel1.setIcon(bg);
        } else if (tmp == "hell") {
            Icon bg = new ImageIcon("../Chess_Engine/Resources/bg3.jpg");
            jLabel1.setIcon(bg);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton closeBtn;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JButton playBtn;
    public javax.swing.JButton stgBtn;
    // End of variables declaration//GEN-END:variables
}
