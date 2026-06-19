package function;

import java.util.Scanner;

public class Select2 {
	public int Select() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("再計算を行う場合は、1を入力して下さい。");
			String num = scanner.nextLine();
			int n = Integer.parseInt(num);
			return n;
		}
	}
}
