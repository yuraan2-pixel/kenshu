package main;

import java.math.BigDecimal;
import java.util.Scanner;

import etc.KeisanIf1;
import etc.KeisanIf2;
import function.Amari;
import function.Kakeru;
import function.Mainus;
import function.Plus;
import function.Waru;

public class Mondai06 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		LABEL1: while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("計算したい数字を選んでください。1：加算、2：減算、3：乗算、4：除算、5：剰余、6：終了");
			int num1 = scanner.nextInt();
			switch (num1) {
			case 1:
				System.out.println("加算を行います。");
				System.out.println("1つ目の整数を入力してください。");
				int num2 = scanner.nextInt();
				System.out.println("2つ目の整数を入力してください。");
				int num3 = scanner.nextInt();
				KeisanIf1 k = new Plus();
				System.out.println("結果：" + k.keisan(num2, num3));
				break;

			case 2:
				System.out.println("減算を行います。");
				System.out.println("1つ目の整数を入力してください。");
				int num4 = scanner.nextInt();
				System.out.println("2つ目の整数を入力してください。");
				int num5 = scanner.nextInt();
				KeisanIf1 k2 = new Mainus();
				System.out.println("結果：" + k2.keisan(num4, num5));
				break;

			case 3:
				System.out.println("乗算を行います。");
				System.out.println("1つ目の整数を入力してください。");
				int num6 = scanner.nextInt();
				System.out.println("2つ目の整数を入力してください。");
				int num7 = scanner.nextInt();
				KeisanIf1 k3 = new Kakeru();
				System.out.println("結果：" + k3.keisan(num6, num7));
				break;

			case 4:
				System.out.println("除算を行います。");
				System.out.println("1つ目の整数を入力してください。");
				int num8 = scanner.nextInt();
				System.out.println("2つ目の整数を入力してください。");
				int num9 = scanner.nextInt();
				KeisanIf2 k4 = new Waru();
				double result = k4.keisan(num8, num9);
				BigDecimal bd = new BigDecimal(result);
				BigDecimal bd1 = bd.setScale(3, BigDecimal.ROUND_HALF_UP);
				System.out.println(bd1);
				break;

			case 5:
				System.out.println("剰余を行います。");
				System.out.println("1つ目の整数を入力してください。");
				int num10 = scanner.nextInt();
				System.out.println("2つ目の整数を入力してください。");
				int num11 = scanner.nextInt();
				KeisanIf1 k5 = new Amari();
				System.out.println("結果：" + k5.keisan(num10, num11));
				break;

			case 6:
				System.out.println("終了します。");
				break LABEL1;

			default:
				System.out.println("1～6の整数で入力して下さい。");
				continue;
			}
			System.out.println("もう一度行う場合は、1を入力して下さい。");
			int num12 = scanner.nextInt();
			if (num12 != 1) {
				System.out.println("終了します。");
				break;
			}
		}

	}

}
