package main;

import java.util.Scanner;

public class Mondai02 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scanner=new Scanner(System.in);
		System.out.println("名前を入力してください。");
		System.out.println("↓↓↓");
		String name = scanner.nextLine();
		System.out.println("こんにちわ。"+name+"さん");
		scanner.close();
	}

}
