package com.PresentationL;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

import com.BusinessAL.NewUserBAL;
import com.DataAL.DBConnection;
import com.DataAL.NewUserDAL;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Dimension;

public class NewUsersUI  extends JFrame implements KeyListener{
	

	Connection conn;
	private NewUserDAL nUD;
	private JTextField txtusername;
	private JTextField txtpassword;
	private JButton btnregister;
	private JComboBox comboBox;

	public NewUsersUI() {
		 try
	        {
	            DBConnection dbObj = new DBConnection();
	            conn = dbObj.getConnection();
	        }
	        catch (Exception ex)
	        {
	            JOptionPane.showMessageDialog(null, "Can't Open Connection!! " + ex.getMessage());
	        }
		initialize();
		distable();
	}
	

	private void initialize() {
		
		
		setSize(698,275);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.cyan);
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension windowsize = getSize();
        this.setBounds((screensize.width-windowsize.width)/2,(screensize.height-windowsize.height)/2,windowsize.width,windowsize.height);
        
        
        txtusername= new JTextField();
        getContentPane().add(txtusername);
        txtusername.setBounds(61,80,178,30);
        txtusername.addKeyListener(this);
		
        
        txtpassword= new JTextField();
        getContentPane().add(txtpassword);
        txtpassword.setBounds(61,121,178,30);
        txtpassword.addKeyListener(this);
        
        
        btnregister = new JButton("Register");
        btnregister.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
//				String userType = txtuserType.getName().trim();
//              String username = txtusername.getText().trim();
//              String pword = txtpassword.getPassword().toString();
//          
////              Serializable ob = (Serializable) NewUserBAL.userValidation(userType, username, pword);
////              
////              if(ob!=null)
////              {
////              	NewUserBAL log = (NewUserBAL)ob;
////              	String pwd = log.getPassword();
////              
////              if(pword.equals(pwd))
////              {
////
////              }
////              else
////              {
////               JOptionPane.showMessageDialog(null, "Invalid Login");
////              }
////              }
//
////				DataAccess obj = new NewUserBAL();
////				obj.add(adding)
////
////              if (obj != null) {
////                  CredantialsDAL cdal = new CredantialsDAL();
////                  cdal.getAuthentication(username, pword);
////				}
////              else {
////                  JOptionPane.showMessageDialog(null, "Please check again", "Error", JOptionPane.ERROR_MESSAGE);
////              }        		
        	}
        });
        btnregister.setBounds(61, 180, 178, 30);
        getContentPane().add(btnregister);
        
        
        String[] messageString  = {"administration", "cashier", "students"};
        comboBox = new JComboBox(messageString);
        comboBox.setBounds(61, 26, 178, 30);
        getContentPane().add(comboBox);
        
        jTable1 = new JTable();
        jTable1.setBounds(283, 26, 366, 182);
        getContentPane().add(jTable1);
        
        
	}
	


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	PreparedStatement ps;
	ResultSet rs;
	private JTable jTable1;
	private void distable() {
		 try { 
		        String sql ="SELECT * from login_tabl"; 
		        ps=conn.prepareStatement(sql); 
		        System.out.println(sql);
		        rs=ps.executeQuery();
		        jTable1.setModel(DbUtils.resultSetToTableModel(rs)); 
		        //jTable1.removeColumn(jTable1.getColumnModel().getColumn(0));
		        //jTable1.removeColumn(jTable1.getColumnModel().getColumn(2));
		      
		        }
		        catch (Exception e) { 
		        JOptionPane.showMessageDialog(null, e); 
		       } 
		
	}
}
