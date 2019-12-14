package com.PresentationL;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuUI extends JFrame implements KeyListener{

	private JFrame frame;

	public MenuUI() {
		initialize();
	}

	private void initialize() {
		setSize(400,400);
        setLayout(null);
        getContentPane().setBackground(Color.cyan);
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension windowsize = getSize();
        
        this.setBounds((screensize.width-windowsize.width)/2,(screensize.height-windowsize.height)/2,windowsize.width,windowsize.height);
//		frame = new JFrame();
//		frame.setBounds(100, 100, 450, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
        JButton btnNewUser = new JButton("Create New User");
        btnNewUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
						try {
							NewUsersUI nUI = new NewUsersUI();
							nUI.setVisible(true);
						} catch (Exception e2) {
							// TODO: handle exception
						}
				
			}
        });
        	
        
        btnNewUser.setBounds(49, 145, 170, 34);
        frame.getContentPane().add(btnNewUser);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
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
