package test.function;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
//	2026年5月21日
public class Mondai06Function {
	Scanner	sc	= new Scanner(System.in);
	
	public Object input(int mode) {
		Object	res	= 0;
		boolean end = true;
		
		while(end) {
			String	word = "";
			boolean situ = false;
			
			switch (mode) {	
				case 0 -> {	
					word = sc.nextLine();
				}
				case 1 -> {	//	式決定
					System.out.println("1,加算、2,減算、3,乗算、4,除算、5,剰余、6,終了");
					System.out.print("番号を入力してください：");
					word = sc.nextLine();
					situ = word.matches("[1-6]");
				}
				case 2 -> {	//	数値入力
					System.out.print("数値を入力してください：");
					word = sc.nextLine();
					situ = word.matches("[0-9\\-\\.].*");
				}
				case 3 -> {
					System.out.print("入力してください：");
					word = sc.nextLine();
				}
			}
			int in = 0;
			double dob = 0;
			
			if(situ && mode == 1) {
				in = Integer.parseInt(word);
				res = in;
				end = false;
				
			} else if(situ && mode == 2) {
				dob = Double.parseDouble(word);
				
				if (dob > 100 || dob <- 100 || dob == 0) {
					back();
				} else {
					res = dob;
					end = false;
				}
				
			} else {
				back();
			}
		}
		return res;
	}
	
	static void back() {
		System.out.println("入れ直してください\n");
	}
	
	public String calculation(int num, double first, double second) {
		String form		= "";
		String symbol	= "";
		double calc = 0;
		
		switch (num) {
			case 1 -> {form = "加算";	symbol = " + "; calc = (first + second);}
			case 2 -> {form = "減算";	symbol = " - "; calc = (first - second);}
			case 3 -> {form = "乗算";	symbol = " * "; calc = (first * second);}
			case 4 -> {form = "除算";	symbol = " / "; calc = (first / second);}
			case 5 -> {form = "剰余";	symbol = " % "; calc = (first % second);}
		}
		BigDecimal bd = new BigDecimal(calc);
		BigDecimal ans = bd.setScale(3, RoundingMode.DOWN);
		String back = form + "：" + first + symbol + second + " = " + ans;
		return back;
	}
}
