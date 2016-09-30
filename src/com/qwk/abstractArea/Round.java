package com.qwk.abstractArea;

public class Round extends J_Shape{

	private double m_r;//半径
	private double m_x,m_y;//圆心坐标
	
	public Round(double rr) {
		m_x = 0;
		m_y = 0;
		m_r = rr;
	}
	public Round(double x, double y, double rr) {
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
		
		return PI*m_r*m_r;//Math.PI也可以
	}

}
