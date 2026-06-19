package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

import etc.KeisanIf;
import function.Amari;
import function.Kakeru;
import function.Mainus;
import function.NumInput;
import function.NumInput2;
import function.Plus;
import function.Select;
import function.Select2;
import function.Waru;

public class Mondai06_R {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			Select s = new Select();
			Select2 s2 = new Select2();
			NumInput n1 = new NumInput();
			NumInput2 n2 = new NumInput2();

			KeisanIf w = new Waru();
			KeisanIf a = new Amari();

			LABEL1: while (true) {
				int Select = s.Select();
				KeisanIf kf = null;
				switch (Select) {
				case 1 -> {
					System.out.println("加算を行います。");
					kf = new Plus();
					break;
				}
				case 2 -> {
					System.out.println("減算を行います。");
					kf = new Mainus();
					break;
				}
				case 3 -> {
					System.out.println("乗算を行います。");
					kf = new Kakeru();
					break;
				}
				case 4 -> {
					System.out.println("除算を行います。");
					kf = new Waru();
					break;
				}
				case 5 -> {
					System.out.println("剰余を行います。");
					kf = new Amari();
					break;
				}
				case 6 -> {
					System.out.println("終了します。");
					break LABEL1;
				}
				}
				double number1 = n1.Input();
				double number2 = n2.Input();
				BigDecimal bd01 = new BigDecimal(kf.keisan(number1, number2));
				BigDecimal bd1 = bd01.setScale(3, RoundingMode.DOWN);
				System.out.println("結果：" + bd1);
				int select2 = s2.Select();
				if (select2 != 1) {
					System.out.println("終了します。");
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}