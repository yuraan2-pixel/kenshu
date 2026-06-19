package test.main;

import test.function.Before.Mondai06Function;

public class Mondai06 {
//	2026年5月21日
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Mondai06Function m06 = new Mondai06Function();
		while(true) {
			int		form 	= (int)		m06.input(1);
			
			if(form == 6) {
				System.out.println("終了します。");
				break;
			}
			double 	first 	= (double)	m06.input(2);
			double 	second	= (double)	m06.input(2);
			System.out.println(m06.calculation(form, first, second) + "\n");
		}
	}

}
