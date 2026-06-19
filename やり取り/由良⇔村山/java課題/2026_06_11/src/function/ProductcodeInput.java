package function;

import java.util.Scanner;

public class ProductcodeInput {
	public static String pc(Scanner scanner) {
		while (true) {
			System.out.println("商品コードを入力してください。9999と入力すると終了します。");
			String code = scanner.nextLine();
			if (code.equals("9999")) {
				return code;
			} else if (!(code.matches("[0-9]{3}"))) {
				System.out.println("エラーです。数字3桁で入力して下さい。");
				System.out.println("再度入力して下さい。");
				continue;
			}
			System.out.println("商品コードは" + code + "です。");
			return code;

		}
	}
}