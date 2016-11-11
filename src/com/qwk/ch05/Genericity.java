package com.qwk.ch05;

import com.qwk.interArea.interRectangle;
import com.qwk.interArea.interRound;
import com.qwk.interArea.interTriangle;
import com.qwk.interArea.interface_Shape;

/*题目要求：应用泛型编写程序。首先定义一个接口，包含计算面积的成员方法。
然后，编写实现该接口的两个类，正方形和圆形。接着编写一个具有泛型特点的类，
可以利用这个类在控制台窗口中输出某种图形的面积，而且这个类的类型变量所对应的实际类型可以是前面编写的正方形类和圆类。
最后利用这个泛型特点的类在控制台窗口中分别输出正方形和圆的面积。*/

class GetArea<T extends interface_Shape>{
	public GetArea(T t) {
		System.out.println("面积："+String.format("%.2f", t.getArea()));
	}
}

public class Genericity {

	public static void main(String[] args) {
		double r = 2;
		double e_x1=0,e_x2=4,e_y1=0,e_y2=3;
		double t_x1=0,t_x2=4,t_x3=2,t_y1=0,t_y2=0,t_y3=2;
		
		interRectangle rectangle = new interRectangle(e_x1, e_y1, e_x2, e_y2);
		interRound round = new interRound(r);
		interTriangle triangle = new interTriangle(t_x1,t_y1,t_x2,t_y2,t_x3,t_y3);
		
		System.out.println("没用泛型之前：");
		System.out.println("4*3矩形面积："+String.format("%.2f", rectangle.getArea()));
		System.out.println("半径为2的圆面积："+String.format("%.2f", round.getArea()));
		System.out.println("底为4，高为2的三角形面积："+String.format("%.2f", triangle.getArea()));
		
		System.out.println();
		System.out.println("利用泛型：");
		GetArea rearea = new GetArea(rectangle);
		GetArea roarea = new GetArea(round);
		GetArea trarea = new GetArea(triangle);

	}

}
