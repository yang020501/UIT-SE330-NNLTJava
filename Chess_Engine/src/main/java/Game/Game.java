/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import Model.DBconnection;
import Model.Player;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author Asus
 */
public class Game {

    private static Main main;
    private Menu menu;
    private Setting st;
    private PlayContent pl;

    public Game() {
        initComponents();
    }

    private void initComponents() {
        /*
        set up for main
         */
        //add both txt pass press Enter
        main = new Main();
        main.usrTxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                loginKeyPressed(evt);
            }

        });
        main.passTxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                loginKeyPressed(evt);
            }

        });
        // add login event
        main.loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        //add sign event
        main.signSBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                signSBtnActionPerformed(evt);
            }
        });
        // add txt,pass,rpass event press Enter
        main.usrSTxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                signKeyPressed(evt);
            }
        });
        main.passSTxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                signKeyPressed(evt);
            }
        });
        main.rpassSTxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                signKeyPressed(evt);
            }
        });
        /*
        set up for menu
         */
        menu = new Menu();
        menu.closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuClose(e);
            }
        });
        menu.stgBtn.addActionListener((ActionEvent e) -> {
            menuSetting(e);
        });
        menu.playBtn.addActionListener((e) -> {
            menuNew(e);
        });
        /*
        set up for setting
         */
        st = new Setting();
        st.backBtn.addActionListener((ActionEvent e) -> {
            settingBack(e);
        });

        st.soundTBtn.addItemListener((ItemEvent e) -> {
            settingSoundTBtn(e);
        });
        st.soundSlider.addChangeListener((ChangeEvent e) -> {
            settingSoundSlider(e);
        });
        st.saveBtn.addActionListener((e) -> {
            settingSave(e);
        });

    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Game();
            }
        });
    }

    /*
        Dialog Login,Sign all events
     */
    // loginbtn event 
    private void loginBtnActionPerformed(ActionEvent evt) {
        login();
    }

    private void login() {
        // set Connection
        DBconnection cn = new DBconnection();
        // get txt from TxtFiedl
        String usr = main.usrTxt.getText();
        String password = main.passTxt.getText();
        if ("".equals(usr)) {
            JOptionPane.showMessageDialog(null, "Missing Username!");
        } else if ("".equals(password)) {
            JOptionPane.showMessageDialog(null, "Missing PassWord!");
        } else if (!cn.getUserVerify(usr)) {
            JOptionPane.showMessageDialog(null, "No Account!");
        } else {
            if (cn.getUserVerify(usr, password)) {
                main.loginDg.dispose();
                main.getContentPane().add(menu);
                main.setSize(Utility.menuSize.getSize());
                main.setLocationRelativeTo(null);
                Main.pl = cn.getUser(usr);
                menu.Update(main.pl);
                main.UpdateUI();
                main.setVisible(true);

                cn.close();

            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Password");
            }
        }
    }

    // signbtn event 
    private void signSBtnActionPerformed(ActionEvent evt) {
        sign();
    }

    private void sign() {
        // set Connection
        DBconnection cn = new DBconnection();
        // get txt from TxtFiedl
        String usr = main.usrSTxt.getText();
        String password = main.passSTxt.getText();
        String rpassword = main.passSTxt.getText();
        if ("".equals(main.usrSTxt.getText())) {
            JOptionPane.showMessageDialog(null, "Missing Username!");
        } else if ("".equals(main.passSTxt.getText())) {
            JOptionPane.showMessageDialog(null, "Missing PassWord!");
        } else if ("".equals(main.rpassSTxt.getText())) {
            JOptionPane.showMessageDialog(null, "Missing RPassWord!");
        } else if (main.passSTxt.getText().equals(main.rpassSTxt.getText())) {
            if (cn.getUserVerify(usr)) {
                JOptionPane.showMessageDialog(null, "This usernamae exists!");
            } else {
                cn.insertnewUser(usr, password);
                cn.close();
                JOptionPane.showMessageDialog(null, "Sign successfully!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Password differs to RPassword!");
        }
    }
    //key press Enter in dialog

    private void loginKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            login();
        }
    }

    private void signKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            sign();
        }
    }

    /*
        Menu pannel event
     */
    // closebtn
    private void menuClose(ActionEvent e) {
        main.dispose();
    }

    // setting btn
    private void menuSetting(ActionEvent e) {
        st.Update(Main.pl);
        main.setSize(Utility.settingSize.getSize());
        main.remove(menu);
        main.add(st);
        main.setLocationRelativeTo(null);
        main.validate();
    }

    private void menuNew(ActionEvent e) {
        /*
        set up for playcontent
         */
        pl = new PlayContent();
        pl.backbtn.addActionListener((evt) -> {
            playBack(evt);
        });
        // set ccontent for Frame
        main.setSize(Utility.playSize.getSize());
        main.remove(menu);
        main.add(pl);
        main.setLocationRelativeTo(null);
        main.validate();
    }

    /*
    setting pannel event
     */
    // back btn 
    private void settingBack(ActionEvent e) {

        main.setSize(Utility.menuSize.getSize());
        menu.Update(main.pl);
        main.remove(st);
        main.add(menu);
        main.setLocationRelativeTo(null);
        main.validate();
    }

    //sound slider
    private void settingSoundSlider(ChangeEvent e) {
        st.Update();

    }

    //sound tbtn
    private void settingSoundTBtn(ItemEvent e) {
        if (st.soundTBtn.isSelected()) {
            st.soundTBtn.setText("On");
            st.Update();
        } else {
            st.soundTBtn.setText("Off");
            st.Update();

        }
    }

    // save btn
    private void settingSave(ActionEvent e) {
        // get and update main.player
        st.Update();
        Player tmp = st.getPlayerSt();
        tmp.setUsername(main.pl.getUsername());
        main.pl = tmp;
        // update all 
        main.UpdateUI();
        menu.Update(main.pl);
        DBconnection cn = new DBconnection();
        if (cn.updateUser(main.pl.getUsername(), main.pl.getSound(), main.pl.getSoundVl(), main.pl.getTheme())) {
            JOptionPane.showMessageDialog(null, "Save Successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Save Fail!");
        }
        cn.close();

    }

    /*
    play content event
     */
    private void playBack(ActionEvent e) {
        main.remove(pl);
        main.setSize(Utility.menuSize.getSize());
        main.add(menu);
        main.setLocationRelativeTo(null);
        main.validate();
    }
}
