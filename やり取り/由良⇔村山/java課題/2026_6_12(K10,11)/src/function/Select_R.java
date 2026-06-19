package function;

import java.util.Scanner;

import etc.KeisanIf;

public class Select_R {
	public static KeisanIf select() {
		Scanner scanner = new Scanner(System.in);
		 while (true) {
			System.out.println("計算したい数字を選んでください。1：加算、2：減算、3：乗算、4：除算、5：剰余、6：終了");
			String num = scanner.nextLine();
			int n = Integer.parseInt(num);
			switch (n) {
			case 1 -> {
				System.out.println("加算を行います。");
				return new Plus();
			}
			case 2 -> {
				System.out.println("減算を行います。");
				return new Mainus();
				
			}
			case 3 -> {
				System.out.println("乗算を行います。");
				return new Kakeru();
			}
			case 4 -> {
				System.out.println("除算を行います。");
				return new Waru();
			}
			case 5 -> {
				System.out.println("剰余を行います。");
				return new Amari();
			}
			case 6 -> {
				System.out.println("終了します。");
				return null;
			}
			default -> {
				System.out.println("1～6の範囲で数字を入力してください。");
			}
			}
		}
	}
}
