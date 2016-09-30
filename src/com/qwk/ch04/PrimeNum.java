package com.qwk.ch04;

//计算并输出100之内的所有素数，计算并输出这些素数之和（1和0即非素数也非合数）
//借鉴  http://blog.csdn.net/liukehua123/article/details/5482854

public class PrimeNum {
	
	private static final int NUM = 100;

	public static void main(String[] args) {
		//第一种方法，效率偏低
		method1();
		//第二种方法，提高效率。
		//原理很简单，就是当i是质(素)数的时候，i的所有的倍数必然是合数。如果i已经被判断不是质数了，那么再找到i后面的质数来把这个质数的倍数筛掉。
		method2();
	}
	
	public static void method1() {
		int[] primes = new int[100];//所有int数组元素会初始化为0
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
		System.out.println("法一");
		for(int ii=0; ii<primes.length; ii++){
			if(primes[ii]!=0)
			System.out.print(primes[ii]+" ");
		}
		System.out.print("\n");
	}
	
	
	public static void method2() {
		//使用了筛选的方法
		boolean[] primes = new boolean[NUM+5];//初始化为false
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
		System.out.println("法二：");
		for(int i=1;i<=NUM;i++){
			if(primes[i]) System.out.print(i+" ");
		}
		System.out.println("\n");
	}
}
