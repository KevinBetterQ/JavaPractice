package com.qwk.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;


/*��ĿҪ�󣺱�дһ������Ҫ������5��ѧ���ĳɼ���������5�������浽�ļ���data.txt���С�
Ȼ���ٱ�дһ�����򣬴��ļ���data.txt���ж�ȡ��5��ѧ���ĳɼ���
���㲢������ǵ�ƽ������Ȼ���ٰ���С�����˳�������5��ѧ���ĳɼ���*/

public class Out {

	public static void main(String[] args) {
		//method1();
		method2();

	}

	private static void method2() {

		//д���ļ�
		try {
			FileOutputStream fOutputStream = new FileOutputStream("out.txt");
			DataOutputStream dOutputStream = new DataOutputStream(fOutputStream);
			Scanner input = new Scanner(System.in);
			int i;
			for(i=0;i<5;i++){
				int j = input.nextInt();
				dOutputStream.writeInt(j);
			}
			dOutputStream.close();
			} catch (Exception e) {
			System.err.println("�쳣");
			e.printStackTrace();
		}
		
		//��ȡ�ļ�
		try {
			FileInputStream fileInputStream = new FileInputStream("out.txt");
			DataInputStream dataInputStream = new DataInputStream(fileInputStream);
			int counter = 0;
			Vector<Integer> vector = new Vector<Integer>();
			for(int i=0;i<5;i++){
				int nums = dataInputStream.readInt();
				System.out.print(nums+", ");
				counter+=nums;
				vector.add(nums);
			}
			dataInputStream.close();
			System.out.println();
			System.out.println("ƽ������" + counter/5);
			System.out.println("�����");
			Collections.sort(vector);
			System.out.println(vector);
			
		} catch (Exception e) {
			System.err.println("��ȡ�쳣");
			e.printStackTrace();
		}
	}

	private static void method1() {
		try {
			FileOutputStream f = new FileOutputStream("out.txt");
			Scanner input = new Scanner(System.in);
			for(int i=0;i<5;i++){
				String num = input.next();
				byte[] nums = num.getBytes();
				f.write(nums);
				f.flush();
			}
			
			f.close();
		} catch (Exception e) {
			System.err.println("�����쳣");
			e.printStackTrace();
		}
		
	}

}
