package com.qwk.interArea;

public class interTriangle implements interface_Shape{

	private double m_x1,m_y1;
	private double m_x2,m_y2;
	private double m_x3,m_y3;
	
	
	public interTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
		m_x1 = x1;
		m_x2 = x2;
		m_x3 = x3;
		m_y1 = y1;
		m_y2 = y2;
		m_y3 = y3;
		
	}

	@Override
	public double getArea() {
		double b1 = Math.sqrt((m_x1-m_x2)*(m_x1-m_x2)+(m_y1-m_y2)*(m_y1-m_y2));
		double b2 = Math.sqrt((m_x1-m_x3)*(m_x1-m_x3)+(m_y1-m_y3)*(m_y1-m_y3));
		double b3 = Math.sqrt((m_x3-m_x2)*(m_x3-m_x2)+(m_y3-m_y2)*(m_y3-m_y2));
		double s = (b1+b2+b3)/2;
		
		return Math.sqrt(s*(s-b1)*(s-b2)*(s-b3));
	}
}
