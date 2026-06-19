package main;

import java.util.Scanner;

public class Mondai03 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		while(true) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("整数を入力してください（-100超、100未満）:");
		
		try {
		int num = scanner.nextInt();
		
		if(-100 < num && num< 100) {
			System.out.println("入力した値は"+num+"です。");
			break;
		}else if(num<-100 || 100<num) {
			System.out.println("入れ直して下さい。");
			continue;
		}
		}
		catch (Exception ex) {
		       System.out.println("入れ直して下さい。");
		       continue;
		}
	}
  }
}