package test.main;

import java.util.Scanner;

//	2026年5月21日
public class Mondai04 {

	public static void main(String[] args) {
		try (// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in)) {
			int num[] = new int[2];
			for(int i = 0; i < num.length; i++) {
				while(true) {
					System.out.print((i + 1) + "つ目の整数を入力してください(-100超、100未満)：");
					String word	 = sc.nextLine();
					boolean back = true;
					
					if(word.matches("[0-9\\-].*")) {
						num[i] = Integer.parseInt(word);
						
						if		(num[i] > 100) {back = false;}
						else if	(num[i] <-100) {back = false;}
						else 	{break;}
					} else 		{back = false;}
					
					if(back == false) {
						System.out.println("入れ直してください");
					}
				}
				
			}
			System.out.println(num[0] + " + " + num[1] + " = " + (num[0] + num[1]));
		} catch (NumberFormatException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
