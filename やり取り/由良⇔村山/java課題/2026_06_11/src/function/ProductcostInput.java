package function;

import java.util.Scanner;

public class ProductcostInput {
	public static String pco(Scanner scanner) {
		while (true) {
			System.out.println("単価を入力してください。");
			String c = scanner.nextLine();
			int n = Integer.parseInt(c);
			System.out.println(n);
			if (n >= 1000000) {
				System.out.println("エラーです。金額が大きすぎます。");
				continue;
			}
			String cost = String.valueOf(n);
			System.out.println("単価は" + cost + "です。");
			return cost;
		}
	}
}
