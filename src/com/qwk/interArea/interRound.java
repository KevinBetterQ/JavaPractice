package com.qwk.interArea;

public class interRound implements interface_Shape{
	
	private double m_r;//°ë¾¶
	private double m_x,m_y;//Ô²ÐÄ×ø±ê
	
	public interRound(double rr) {
		m_x = 0;
		m_y = 0;
		m_r = rr;
	}
	public interRound(double x, double y, double rr) {
		m_x = x;
		m_y = y;
		m_r = rr;
	}
	
	public double getR() {
		return m_r;
	}


	public void setR(double r) {
		this.m_r = r;
	}

	@Override
	public double getArea() {
		return PI*m_r*m_r;
	}
	
}
