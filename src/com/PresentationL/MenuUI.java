package com.PresentationL;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class MenuUI extends javax.swing.JFrame{

	private JFrame frame;

	public MenuUI() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
}
