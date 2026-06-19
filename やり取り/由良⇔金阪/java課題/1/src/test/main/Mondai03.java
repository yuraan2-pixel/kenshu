package test.main;

import java.util.Scanner;

//	2026年5月20日
public class Mondai03 {
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("整数を入力してください(-100超、100未満)：");
			String word = sc.nextLine();
			boolean back = true;
			
			if(word.matches("[0-9\\-].*")) {
				int num = Integer.parseInt(word);
				
				if		(num > 100) {back = false;}
				else if	(num <-100) {back = false;}
				else {	
					System.out.println("入力した数値は｢" + num + "｣です。");
					break;
				}
			} else {back = false;}
			
			if(back == false) {
				System.out.println("入れ直してください");
			}
		}

	}

}
