package main;

import java.util.Scanner;

public class Mondai04 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("1つ目の整数を入力してください（-100超、100未満）:");

			try {
				int num = scanner.nextInt();

				if (-100 < num && num < 100) {
					System.out.println("入力した値は" + num + "です。");

					System.out.println("2つ目の整数を入力してください（-100超、100未満）:");
					try {
						int num2 = scanner.nextInt();

						if (-100 < num2 && num2 < 100) {
							System.out.println("入力した値は" + num2 + "です。");
							System.out.println(num + "+" + num2 + "=" + (num + num2));
							break;
						} else if (num2 < -100 || 100 < num2) {
							System.out.println("入れ直して下さい。");
							continue;
						}
					} catch (Exception ex) {
						System.out.println("入れ直して下さい。");
						continue;
					}
				} else if (num < -100 || 100 < num) {
					System.out.println("入れ直して下さい。");
					continue;
				}
			} catch (Exception ex) {
				System.out.println("入れ直して下さい。");
				continue;
			}
		}
	}
}
