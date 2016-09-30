package com.qwk.interArea;

public class interRectangle implements interface_Shape{

	//����Ҫ�ж�һ�����ε�Ԫ�أ���һ�������У���Ҫȷ��һ�����Σ�������͹��ˡ������꣬���Ϳ��ǲ���ȷ��λ�õġ�

	private double m_minX, m_minY;
	private double m_maxX, m_maxY;
	
	public interRectangle(double x1, double y1, double x2, double y2) {
		m_minX = x1<x2 ? x1:x2;
		m_maxX = x1>x2 ? x1:x2;
		m_minY = y1<y2 ? y1:y2;
		m_maxY = y1>y2 ? y1:y2;
	}
	
	
	@Override
	public double getArea() {
		return (m_maxX-m_minX)*(m_maxY-m_minY);
	}


}
