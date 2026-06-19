package function;

import java.util.Scanner;

public class NumInput2 {
	public static double input() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("2つ目の数字を入力してください。");
			Double num = scanner.nextDouble();
			if (num == 0) {
				System.out.println("0は入力出来ません。");
			} else if (num >= -100 && num <= 100) {
				return num;
			}
			System.out.println("-100～100の範囲で数字を入力してください。");
		}
	}
}