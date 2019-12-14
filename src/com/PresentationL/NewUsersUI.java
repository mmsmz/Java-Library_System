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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Dimension;

public class NewUsersUI  extends JFrame implements KeyListener{
Connection conn;
private NewUserDAL nUD;

	private JFrame frame;
	private JTextField txtusername;
	private JPasswordField txtpassword;
	private JComboBox txtuserType;
	private JTable table;


	/**
	 * Create the application.
	 */
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
			setSize(400,400);
	        setLayout(null);
	        getContentPane().setBackground(Color.cyan);
	        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	        Dimension windowsize = getSize();
	        
	        this.setBounds((screensize.width-windowsize.width)/2,(screensize.height-windowsize.height)/2,windowsize.width,windowsize.height);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtusername = new JTextField();
		txtusername.setBounds(53, 90, 178, 28);
		frame.getContentPane().add(txtusername);
		txtusername.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(53, 154, 178, 28);
		frame.getContentPane().add(txtpassword);
		
		JButton btnSubmit = new JButton("Register");
		btnSubmit.setBounds(53, 197, 178, 41);
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String userType = txtuserType.getName().trim();
                String username = txtusername.getText().trim();
                String pword = txtpassword.getPassword().toString();
            
                Serializable ob = (Serializable) NewUserBAL.userValidation(userType, username, pword);
                
                if(ob!=null)
                {
                	NewUserBAL log = (NewUserBAL)ob;
                	String pwd = log.getPassword();
                
                if(pword.equals(pwd))
                {
                	System.out.println("added");
//                    LoginStatus.status = log.getuStatus();
//                    MainForm mf = new MainForm();
//                    mf.setVisible(true);
//                    this.setVisible(false);
                }
                else
                {
                 JOptionPane.showMessageDialog(null, "Invalid Login");
                }
                }

//				DataAccess obj = new NewUserBAL();
//				obj.add(adding)
//
//                if (obj != null) {
//                    CredantialsDAL cdal = new CredantialsDAL();
//                    cdal.getAuthentication(username, pword);
//				}
//                else {
//                    JOptionPane.showMessageDialog(null, "Please check again", "Error", JOptionPane.ERROR_MESSAGE);
//                }
                
                
			}
		});
		frame.getContentPane().add(btnSubmit);
		
		String[] messageString  = {"administration", "cashier", "students"};
		txtuserType = new JComboBox(messageString);
		txtuserType.setBounds(53, 44, 178, 20);
		frame.getContentPane().add(txtuserType);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(54, 129, 63, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setBounds(53, 75, 64, 14);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblUserType = new JLabel("User Type :");
		lblUserType.setBounds(53, 24, 64, 14);
		frame.getContentPane().add(lblUserType);
		
		table = new JTable();
		table.setBounds(252, 44, 288, 193);
		frame.getContentPane().add(table);
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
}
