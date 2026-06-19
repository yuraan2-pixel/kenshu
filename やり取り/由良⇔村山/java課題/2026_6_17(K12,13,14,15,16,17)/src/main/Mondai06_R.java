package main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

import etc.KeisanIf;
import function.NumInput;
import function.NumInput2;
import function.Select2;
import function.Select_R;

public class Mondai06_R {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scanner = new Scanner(System.in);
		try {
			while (true) {
				KeisanIf kf = Select_R.select();
				if (kf == null) {
					break;
				}
				double number1 = NumInput.input();
				double number2 = NumInput2.input();
				BigDecimal bd01 = new BigDecimal(kf.keisan(number1, number2));
				BigDecimal bd1 = bd01.setScale(3, RoundingMode.DOWN);
				System.out.println("結果：" + bd1);
				int select2 = Select2.select();
				if (select2 != 1) {
					System.out.println("終了します。お疲れさまでした。");
					break;
				}
			}
		} catch (InputMismatchException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}