package com.util;

import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * 
 * @author NaiveKyo
 * ´°¿ÚÎ»ÖÃ
 */ 
public class Location {
	
	public static void setCenter(JFrame jframe) {
		
		int windowHeight = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int windowWidth = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int height = jframe.getHeight();
		int width = jframe.getWidth();
		int x = (windowWidth - width) / 2;
		int y = (windowHeight - height) / 2;
		
		jframe.setLocation(x, y);
	}
	
	public static void setCenter(JDialog dialog) {
		
		int windowHeight = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int windowWidth = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int height = dialog.getHeight();
		int width = dialog.getWidth();
		int x = (windowWidth - width) / 2;
		int y = (windowHeight - height) / 2;
		
		dialog.setLocation(x, y);
	}
}
