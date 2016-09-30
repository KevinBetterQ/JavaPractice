package com.qwk.abstractArea;

public class AreaTest {

	public static void main(String[] args) {
		
		double r = 2;
		double e_x1=0,e_x2=4,e_y1=0,e_y2=3;
		double t_x1=0,t_x2=4,t_x3=2,t_y1=0,t_y2=0,t_y3=2;
		
		Rectangle rectangle = new Rectangle(e_x1, e_y1, e_x2, e_y2);
		Round round = new Round(r);
		Triangle triangle = new Triangle(t_x1,t_y1,t_x2,t_y2,t_x3,t_y3);
		
		System.out.println("4*3矩形面积："+String.format("%.2f", rectangle.getArea()));
		System.out.println("半径为2的圆面积："+String.format("%.2f", round.getArea()));
		System.out.println("底为4，高为2的三角形面积："+String.format("%.2f", triangle.getArea()));
		
	}

}


