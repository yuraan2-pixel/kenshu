package function;

import java.util.Scanner;

public class Stockday {
	public static String stockday(Scanner scan) {
		while (true) {
			try {
				System.out.println("登録日を入力してください。例 2026年6月1日 → 20260601");
				String day = scan.nextLine();
				if (!(day.matches("([2][0-1][0-9]{2})(0[1-9]|1[0-2])(0[0-9]|[12][0-9]|3[01])"))) {
					System.out.println("エラーです。例題に従って入力して下さい。");
					continue;
				} else {
					return day;
				}
			} catch (NumberFormatException e) {
				System.out.println("数字を入力して下さい。");
			}
		}
	}
}
