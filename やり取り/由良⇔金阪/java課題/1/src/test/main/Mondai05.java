package test.main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

//	2026年5月21日
public class Mondai05 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner	sc		= new Scanner(System.in);
		double	num[]	= new double[2];
		
		for(int i = 0; i < num.length; i++) {
			while(true) {
				System.out.print((i + 1) + "つ目の整数を入力してください(-100超、100未満)：");
				String	word = sc.nextLine();
				boolean back = true;
				
				if(word.matches("[0-9\\-].*")) {
					num[i] = Integer.parseInt(word);
					
					if		(num[i] > 100) {back = false;}
					else if	(num[i] <-100) {back = false;}
					else if	(num[i] ==	0 && i == 1) {back = false;}
					else 	{break;}
					
				} else 		{back = false;}
				
				if(back == false) {
					System.out.println("入れ直してください");
				}
			}
			
		}
/*		int first = 0;
		while(true) {
			System.out.print("１つ目の整数を入力してください(-100超、100未満)：");
			String word	 = sc.nextLine();	boolean back = true;
			
			if(word.matches("[0-9\\-].*")) {
				first = Integer.parseInt(word);
				
				if		(first > 100) {back = false;}
				else if	(first <-100) {back = false;}
				else {	
//					System.out.println("入力した数値は｢" + num + "｣です。");
					break;
				}
			} else {back = false;}
			
			if(back == false) {
				System.out.println("入れ直してください");
			}
		}
		double second = 0;
		while(true) {
			System.out.print("２つ目の整数を入力してください(-100超、100未満)：");
			String word = sc.nextLine();
			boolean back = true;
			
			if(word.matches("[0-9\\-].*")) {
				second = Integer.parseInt(word);
				
				if		(second > 100) {back = false;}
				else if	(second <-100) {back = false;}
				else if	(second ==	0) {back = false;}
				else {	
					break;
				}
			} else {back = false;}
			
			if(back == false) {
				System.out.println("入れ直してください");
			}
		}
//	*/
		BigDecimal bd = new BigDecimal(num[0] / num[1]);
		int first	= (int)num[0];
		int second	= (int)num[1];
		
		for(int i = 0; i < 5; i++) {
			String form		= "";
			String symbol	= "";
			Object calc		= 0;
			
			switch (i) {
				case 0 -> {form = "加算";	symbol = " + "; calc = (first + second);}
				case 1 -> {form = "減算";	symbol = " - "; calc = (first - second);}
				case 2 -> {form = "乗算";	symbol = " * "; calc = (first * second);}
				case 3 -> {form = "除算";	symbol = " / "; calc = bd.setScale(3, RoundingMode.DOWN);}
//				int,doubleキャストは不可、Objectこういう時万能かも、->の存在を忘れてた:になってた
				case 4 -> {form = "剰余";	symbol = " % "; calc = (first % second);}
			}
			System.out.println(form + "：" + first + symbol + second + " = " + calc);
		}
//		System.out.println("加算：" + first + " + " + second + " = " + (first + second));
//		System.out.println("減算：" + first + " - " + second + " = " + (first - second));
//		System.out.println("乗算：" + first + " * " + second + " = " + (first * second));
//		System.out.println("徐算：" + first + " / " + second + " = " + bd.setScale(3, RoundingMode.DOWN));
//		System.out.println("剰余：" + first + " % " + second + " = " + (first % second));
	}

}
