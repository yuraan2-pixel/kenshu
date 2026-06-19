package function;

import java.util.Scanner;

public class StockcodeInput {
	public static String stockcodeinput(Scanner scan, String select) {
		if (select.equals("1")) {
			while (true) {
				System.out.println("入庫を行う商品コードを入力してください。");
				String code = scan.nextLine();
				if (!(code.matches("[0-9]{3}"))) {
					System.out.println("エラーです。数字3桁で入力して下さい。");
					System.out.println("再度入力して下さい。");
					continue;
				} else {
					//	なし
				}
				System.out.println("商品コードは" + code + "です。");
				return code;
			}
		} else {
			while (true) {
				System.out.println("出庫を行う商品コードを入力してください。");
				String code = scan.nextLine();
				if (!(code.matches("[0-9]{3}"))) {
					System.out.println("エラーです。数字3桁で入力して下さい。");
					System.out.println("再度入力して下さい。");
					continue;
				} else {
					//	なし
				}
				System.out.println("商品コードは" + code + "です。");
				return code;
			}
		}
	}
}