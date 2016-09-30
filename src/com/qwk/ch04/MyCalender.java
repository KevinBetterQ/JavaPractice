package com.qwk.ch04;

import java.util.Calendar;
import java.util.Scanner;

/*
 * 题目：要求编程输出2008年日历。日历中要求含有月份、日期和星期。
 * 然后统计并输出2008日期的个位数与相应的星期恰好相同的总天数（例如2008年9月1日正好是星期一）
 */

public class MyCalender {
	
	private static int dayNumber = 0;

	//获取某月的某天是星期几
	public static int weekDay(Calendar cal) {
		int weekday = cal.get(Calendar.DAY_OF_WEEK);
		if(weekday == 1) weekday = 7;// 西方星期日为第一天，星期一为第二天
		else weekday = weekday-1;
		return weekday;
	}
	
	public static void calender(int year, int month) {
		Calendar firstcal = Calendar.getInstance();
		Calendar lastcal = Calendar.getInstance();
		System.out.println("\t\t" + year + "年" + month + "月");
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		
		firstcal.set(year, month-1, 1);//所求月的第一天
		//获取该月的天数
		int dataofmonth = firstcal.getActualMaximum(Calendar.DATE);
		lastcal.set(year, month-1, dataofmonth);//所求月的最后一天
		
		//获取该月的星期数
		int weekofmonth = firstcal.getActualMaximum(Calendar.WEEK_OF_MONTH);
		String[][] week = new String[weekofmonth][7];
		
		int firstday = MyCalender.weekDay(firstcal);//获取所求月第一天是星期几
		int lastday = MyCalender.weekDay(lastcal);//获取所求月最后一天是星期几
		
		int m = 1;//输出时记录天
		int f = 1;// f的作用主要是判断是否需要将第一个星期归到中间几个星期一起计算  
		
		//第一个星期
		if(firstday == 7){
			f = 0;
		}
		else{
			for(int j=0; j<firstday; j++){
				week[0][j] = " ";
				System.out.print(week[0][j] + "\t");
			}
			for(int j=firstday; j<7; j++){
				week[0][j] = m + "";//m本来为int，+“”会变为String
				m++;
				System.out.print(week[0][j]+"\t");
			}
			System.out.println();
		}
		//中间的几个星期
		for (int i = f; i < weekofmonth - 1; i++) {
			for(int j=0; j<7; j++){
				week[i][j] = m + "";
				m++;
				System.out.print(week[i][j] + "\t");
			}
			System.out.println();
		}
		//最后的一个星期
		if(lastday == 7){
			week[weekofmonth-1][0] = m + "";
			System.out.println(m + "\t");
		}
		else{
			for(int j=0; j<=lastday; j++){
				week[weekofmonth-1][j] = m +"";
				m++;
				System.out.print(week[weekofmonth-1][j] + "\t");
			}
		}
		System.out.println();
		
		if(firstday == 1){dayNumber+=7;}
	}
	
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("————————————————万年历————————————————");
		while(input.next() == "Y"){
			System.out.println("请输入年份：");
			int year = input.nextInt();
			System.out.println("请输入月份：");
			int month = input.nextInt();
			calender(year, month);
		}
		
		dayNum();
	}

	private static void dayNum() {
		int year = 2008;
		int n = 0;
		for(int i=1; i<=12; i++){
			calender(year, i);
		}
		System.out.println("相同天数：" + dayNumber);
		
	}
}












