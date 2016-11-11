package com.qwk.ch05;

import com.qwk.interArea.interRectangle;
import com.qwk.interArea.interRound;
import com.qwk.interArea.interTriangle;
import com.qwk.interArea.interface_Shape;

/*��ĿҪ��Ӧ�÷��ͱ�д�������ȶ���һ���ӿڣ�������������ĳ�Ա������
Ȼ�󣬱�дʵ�ָýӿڵ������࣬�����κ�Բ�Ρ����ű�дһ�����з����ص���࣬
��������������ڿ���̨���������ĳ��ͼ�ε�������������������ͱ�������Ӧ��ʵ�����Ϳ�����ǰ���д�����������Բ�ࡣ
���������������ص�����ڿ���̨�����зֱ���������κ�Բ�������*/

class GetArea<T extends interface_Shape>{
	public GetArea(T t) {
		System.out.println("�����"+String.format("%.2f", t.getArea()));
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
		
		System.out.println("û�÷���֮ǰ��");
		System.out.println("4*3���������"+String.format("%.2f", rectangle.getArea()));
		System.out.println("�뾶Ϊ2��Բ�����"+String.format("%.2f", round.getArea()));
		System.out.println("��Ϊ4����Ϊ2�������������"+String.format("%.2f", triangle.getArea()));
		
		System.out.println();
		System.out.println("���÷��ͣ�");
		GetArea rearea = new GetArea(rectangle);
		GetArea roarea = new GetArea(round);
		GetArea trarea = new GetArea(triangle);

	}

}
