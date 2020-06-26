package com.util;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	
	private int width;
	private int height;
	
	Image image;
	
	public ImagePanel() {
		super();
	}
	
	public ImagePanel(int width, int height, Image image) {
		this.width = width;
		this.height = height;
		this.image = image;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, width, height, null);
	}
}
