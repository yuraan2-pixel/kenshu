package function;

import java.util.Scanner;

public class Select {
	public int Select() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("計算したい数字を選んでください。1：加算、2：減算、3：乗算、4：除算、5：剰余、6：終了");
			String num = scanner.nextLine();
			int n = Integer.parseInt(num);
			if (n >= 1 && n <= 6) {
				return n;
			}
			System.out.println("1～6の範囲で数字を入力してください。");
		}
	}
}