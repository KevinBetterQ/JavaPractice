package com.qwk.ch04;

public class MathRandom {

	public static void main(String[] args) {
		int[] counter = new int[22];
		int num;
		for(int i=0; i<1000 ;i++){
			num = (int) (Math.random()*20+0.5);
			if(num<=20)
			counter[num]++;
		}
		for(int i=0; i<=20 ;i++){
			System.out.println(i+"�ĸ���Ϊ��"+counter[i]);
		}
	}

}
