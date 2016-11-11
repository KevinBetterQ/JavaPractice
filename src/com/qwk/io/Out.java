package com.qwk.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;


/*题目要求：编写一个程序，要求输入5个学生的成绩，并将这5个数保存到文件“data.txt”中。
然后再编写一个程序，从文件“data.txt”中读取这5个学生的成绩，
计算并输出它们的平均数，然后再按从小到大的顺序输出这5个学生的成绩。*/

public class Out {

	public static void main(String[] args) {
		//method1();
		method2();

	}

	private static void method2() {

		//写入文件
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
			System.err.println("异常");
			e.printStackTrace();
		}
		
		//读取文件
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
			System.out.println("平均数：" + counter/5);
			System.out.println("排序后：");
			Collections.sort(vector);
			System.out.println(vector);
			
		} catch (Exception e) {
			System.err.println("读取异常");
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
			System.err.println("发生异常");
			e.printStackTrace();
		}
		
	}

}
