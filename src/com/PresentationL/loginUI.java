package com.PresentationL;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.xml.transform.sax.SAXSource;

import com.BusinessAL.CredentialBAL;
import com.BusinessAL.CredentialVal;
import com.DataAL.CredantialsDAL;
import com.DataAL.DBConnection;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class loginUI extends javax.swing.JFrame {
    Connection conn;
    private JFrame frame;
    private JPasswordField txtpassword;
    private JTextField txtusername;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    loginUI window = new loginUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public loginUI() {
        try {
            DBConnection dbObj = new DBConnection();
            conn = dbObj.getConnection();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Can't Open Connection!! " + ex.getMessage());
        }
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 277, 246);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnlogin = new JButton("login");
        btnlogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Optional<String> username = Optional.ofNullable(txtusername.getText().trim());
                Optional<String> pword = Optional.of(new String(txtpassword.getPassword()).trim());

				//CredentialVal obj = CredentialBAL.passwordVal(username,pword);
                
                try {
                	  CredantialsDAL cdal = new CredantialsDAL();
                      cdal.getAuthentication(username, pword);
                      
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
					JOptionPane.showMessageDialog(null, "Please check again", "Error", JOptionPane.ERROR_MESSAGE);
				}
                  
                    
				


            }
        });

        btnlogin.setBounds(49, 145, 170, 34);
        frame.getContentPane().add(btnlogin);

        txtpassword = new JPasswordField();
        txtpassword.setBounds(49, 107, 170, 20);
        frame.getContentPane().add(txtpassword);

        txtusername = new JTextField();
        txtusername.setColumns(10);
        txtusername.setBounds(49, 72, 170, 20);
        frame.getContentPane().add(txtusername);
    }

}
