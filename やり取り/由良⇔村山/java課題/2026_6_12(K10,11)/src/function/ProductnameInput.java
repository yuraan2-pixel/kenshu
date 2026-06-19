package function;

import java.util.Scanner;

public class ProductnameInput {
	public static String pn(Scanner scanner) {
		while (true) {
			System.out.println("商品名を入力してください。");
			String name = scanner.nextLine();
			try {
				int c = (name.getBytes("Shift_JIS").length);
				if (c >= 21) {
					System.out.println("エラーです。文字数が多いです。");
					continue;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			System.out.println("商品名は" + name + "です。");
			return name;
		}
	}
}
