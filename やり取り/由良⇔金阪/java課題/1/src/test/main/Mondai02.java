package test.main;

import java.util.Scanner;

//	2026年5月20日
public class Mondai02 {
	public static void main(String[] args) {
		System.out.print("名前を入力してください：");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println("こんにちは。" + name + "さん");
	}
}
