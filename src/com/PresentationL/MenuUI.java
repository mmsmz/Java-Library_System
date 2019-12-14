package com.PresentationL;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuUI extends JFrame implements KeyListener{

	private JFrame frame;

	public MenuUI() {
		initialize();
	}

	private void initialize() {
		setSize(351,400);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.cyan);
        
        JButton btnNewButton = new JButton("Create New User");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		NewUsersUI nUI = new NewUsersUI();
				nUI.setVisible(true);
        	}
        });
        btnNewButton.setBounds(100, 46, 139, 42);
        getContentPane().add(btnNewButton);
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension windowsize = getSize();
        
        this.setBounds((screensize.width-windowsize.width)/2,(screensize.height-windowsize.height)/2,windowsize.width,windowsize.height);
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
