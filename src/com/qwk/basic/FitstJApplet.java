package com.qwk.basic;
import java.awt.Graphics;
import javax.swing.JApplet;

public class FitstJApplet extends JApplet{
	public void paint(Graphics g){
		g.clearRect(0, 0, getWidth(), getHeight());
		g.drawString("Hello,JApplet", 10, 20);
	}
}
