package function;

import java.util.Scanner;

public class Select3 {
	public static int select3(Scanner scanner) {
		while (true) {
			System.out.println("下記の項目から選んでください。");
			System.out.println("1：商品登録、2：入出庫登録、3：在庫一覧");
			String num = scanner.nextLine();
			int n = Integer.parseInt(num);
			if (n == 1 || n == 2 || n == 3) {
				return n;
			} else {
				System.out.println("1～3の範囲で入力してください。");
			}
		}
	}
}