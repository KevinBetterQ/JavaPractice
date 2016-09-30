package com.qwk.interArea;

public class interRectangle implements interface_Shape{

	//首先要判断一个矩形的元素，在一个画面中，想要确定一个矩形，两个点就够了。用坐标，长和宽是不能确定位置的。

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
