package com.qwk.ch04;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

/*
 * �跨����10��������ͬ�Ĵ�a��z��ĸ��Ȼ�����10����ĸ����С����ķ�ʽ�����������ǰ����ĸ���к���������ĸ����
 */

public class WordProduce {
	
	

	public static void main(String[] args) {
		go();
	}

	
	//vector����
	private static void go() {
		Vector<Character> words = new Vector<Character>();
		while(words.size()!=10){
			int ran = (int) (Math.random()*26+0.5)+97;//random���ɡ�0����1������
			char ranchar = (char) ran;
			if(!words.contains(ranchar))
			words.add(ranchar);
		}
		Iterator<Character> iterator = words.iterator();
		System.out.println("δ����֮ǰ��");
		while(iterator.hasNext()){
			char numchar = iterator.next();
			System.out.print(numchar + " ");
		}
		System.out.println();
		System.out.println("����֮��");
		Collections.sort(words);
		System.out.println(words);
		
	}
	public static void sortmaopao() {
		int[] test = {5,32,7,7,9,3,1,0,45,21,44};
		for(int i=0;i<test.length-1;i++){
			for(int j=0;j<test.length-1-i;j++){
				if(test[j]>test[j+1]){
					int t = test[j];
					test[j] = test[j+1];
					test[j+1] = t;
				}
			}
		}
		for(int i=0;i<test.length;i++)
		System.out.println(test[i]);
	}



}
