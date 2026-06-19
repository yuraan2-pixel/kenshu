package function;

import java.util.Scanner;

public class Stockkeisan {
	public static int stockkeisan(Scanner scan, String select) {

		if (select.equals("1")) {
			while (true) {
				try {
					System.out.println("入庫数を入力してください。");
					String num = scan.nextLine();
					int n = Integer.parseInt(num);
					if (n >= 0) {
						System.out.println("入庫数："+n);
						return n;
					} else {
						System.out.println("0以上を入力してください。");
					}
				} catch (NumberFormatException e) {
					System.out.println("数字を入力して下さい。");
				}
			}
		} else {
			while (true) {
				try {
					System.out.println("出庫数を入力してください。");
					String num = scan.nextLine();
					int n = Integer.parseInt(num);
					if (n >= 0) {
						System.out.println("出庫数："+n);
						return n;
					} else {
						System.out.println("0以上を入力してください。");
					}
				} catch (NumberFormatException e) {
					System.out.println("数字を入力して下さい。");
				}
			}
		}
	}
}