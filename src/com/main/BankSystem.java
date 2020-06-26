package com.main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.view.LoginView;

public class BankSystem {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(() -> {
			
			System.out.println("Ä¬ÈÏ×Ö·û¼¯: " + System.getProperty("file.encoding"));
			
			LoginView frame = new LoginView();
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}
