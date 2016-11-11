package com.qwk.ch04;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Data {
	
		 int weekday;

		 Data(int year, int month) {
		  for (int j = 1; j < month + 1; j++) {
		   System.out.println("2008年" + j + "月");
		   GregorianCalendar d = new GregorianCalendar(year, j - 1, 1);
		   d.set(Calendar.DAY_OF_MONTH, 1);
		   weekday = d.get(Calendar.DAY_OF_WEEK);
		   System.out.println("日\t一\t二\t三\t四\t五\t六");
		   for (int i = Calendar.SUNDAY; i < weekday; i++) {
		    System.out.print("\t");
		   }

		   do {
		    System.out.print(d.get(Calendar.DAY_OF_MONTH) + "\t");
		    if (weekday == Calendar.SATURDAY)
		     System.out.println();
		    d.add(Calendar.DAY_OF_MONTH, 1);
		    weekday = d.get(Calendar.DAY_OF_WEEK);
		   } while ((d.get(Calendar.MONTH) + 1) == j);
		   System.out.println();
		   System.out
		     .println("|--------------------------------------------------|");
		  }
		 }

		 public static void main(String[] args) {
		  int m, y;
		  Scanner reader = new Scanner(System.in);

		  new Data(2008, 12);
		 }
}
