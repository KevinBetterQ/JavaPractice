package com.qwk.ch04;

//���㲢���100֮�ڵ��������������㲢�����Щ����֮�ͣ�1��0��������Ҳ�Ǻ�����
//���  http://blog.csdn.net/liukehua123/article/details/5482854

public class PrimeNum {
	
	private static final int NUM = 100;

	public static void main(String[] args) {
		//��һ�ַ�����Ч��ƫ��
		method1();
		//�ڶ��ַ��������Ч�ʡ�
		//ԭ��ܼ򵥣����ǵ�i����(��)����ʱ��i�����еı�����Ȼ�Ǻ��������i�Ѿ����жϲ��������ˣ���ô���ҵ�i���������������������ı���ɸ����
		method2();
	}
	
	public static void method1() {
		int[] primes = new int[100];//����int����Ԫ�ػ��ʼ��Ϊ0
		int numb = 0;
		
		for(int i=2; i<=NUM; i++ ){
			boolean flag = true;
			for(int j=2; j<=Math.sqrt(i); j++){
				if(i%j==0) {flag = false;break;}
			}
			if(flag==true){
				primes[numb++] = i;
			}
		}
		System.out.println("��һ");
		for(int ii=0; ii<primes.length; ii++){
			if(primes[ii]!=0)
			System.out.print(primes[ii]+" ");
		}
		System.out.print("\n");
	}
	
	
	public static void method2() {
		//ʹ����ɸѡ�ķ���
		boolean[] primes = new boolean[NUM+5];//��ʼ��Ϊfalse
		primes[1] = false;
		primes[2] = true;
		for(int i=3;i<=NUM;i++){
			if(i%2==0) primes[i]=false;
			else primes[i]=true;
		}
		for(int i=2;i<=Math.sqrt(NUM);i++){
			if(primes[i]){
				for(int j=i+i;j<=NUM;j=j+i){
					if(j<=NUM)
					primes[j] = false;
				}
			}
		}
		System.out.println("������");
		for(int i=1;i<=NUM;i++){
			if(primes[i]) System.out.print(i+" ");
		}
		System.out.println("\n");
	}
}
