package main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Mondai05_R {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("1つ目の整数を入力してください（-100超、100未満）:");

			try {
				int num = scanner.nextInt();

				if (-100 < num && num < 100) {
					System.out.println("2つ目の整数を入力してください（-100超、100未満）:");
					try {
						int num2 = scanner.nextInt();

						if (num2 == 0) {
							System.out.println("入れ直して下さい。");
							continue;
						} else if (-100 < num2 && num2 < 100) {
							System.out.print("加算：");
							System.out.println(num + "+" + num2 + "=" + (num + num2));
							System.out.print("減算：");
							System.out.println(num + "-" + num2 + "=" + (num - num2));
							System.out.print("乗算：");
							System.out.println(num + "*" + num2 + "=" + (num * num2));
							System.out.print("除算：" + (num + "/" + num2 + "="));
							BigDecimal a1 = new BigDecimal(String.valueOf(num));
							BigDecimal b1 = new BigDecimal(String.valueOf(num2));
							System.out.println(a1.divide(b1, 3, RoundingMode.DOWN));
							System.out.print("剰余：");
							System.out.println(num + "%" + num2 + "=" + (num % num2));
							break;
						} else {
							System.out.println("入れ直して下さい。");
							continue;
						}
					} catch (Exception ex) {
						System.out.println("入れ直して下さい。");
						continue;
					}
				} else {
					System.out.println("入れ直して下さい。");
				}
			} catch (Exception ex) {
				System.out.println("入れ直して下さい。");
			}
		}
	}
}
