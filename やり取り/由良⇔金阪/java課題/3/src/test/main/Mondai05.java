package test.main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

//	2026年5月21日
public class Mondai05 {

	public static void main(String[] args) {
		try (// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in)) {
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
		} catch (NumberFormatException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
