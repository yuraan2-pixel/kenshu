package test.function;

import java.util.Scanner;

public class Input {
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * 	word：文字入力受付
	 * @param word
	 * @return	String
	 */
	static String nextLine(String word) {
		System.out.print(word + "：");
		return sc.nextLine();
	}
	
	/**
	 * 	word：数値入力受付
	 * @param word
	 * @return	int
	 */
	static int nextInt(String word) {
		int number = 0;
		while(true) {
			try {
				System.out.print(word + "：");
				number = Integer.parseInt(sc.nextLine());
				break;
			} catch (Exception e) {
				reply("数値");
			}
		}
		return number;
	}
	
	/**
	 * wordを入力してください	を表示
	 * @param word
	 */
	static void reply(String word) {
		System.out.println(word + "を入力してください。\n");
	}
	
	/** 
	 * word (数値leng桁)：を表示	<p>
	 * leng 桁の数値の入力受付		<p>
	 * 誤入力の場合繰返し
	 * @param word
	 * @param leng
	 * @return int
	 */
	public static int digit(String word, int leng) {
		int number = 0;
		while(true) {
			try {
				String value = nextLine(word + "(数値" + leng + "桁)");
				if(value.matches("[0-9]{" + leng + "}")) {
					number = Integer.parseInt(value);
					break;
				}
			} catch (Exception e) {}
			reply(leng + "桁の数値");
		}
		return number;
	}
	
	/** 
	 * word (leng byte以内)：を表示	<p>
	 * leng byte以内の数値の入力受付<p>
	 * 誤入力の場合繰返し
	 * @param word
	 * @param leng
	 * @return
	 */
	public static String name(String word, int leng) {
		String name = null;
		while(true) {
			try {
				name = nextLine(word + "(" + leng + "byte以内)");
				if(leng >= name.getBytes().length) {
					break;
				} 
			} catch (Exception e) {}
			reply(leng + "byte以内の文字");
		}
		return name;
	}
	
	/**
	 * word (max未満)：を表示		<p>
	 * max 未満の数値の入力受付		<p>
	 * 誤入力の場合繰返し
	 * @param word
	 * @param max
	 * @return
	 */
	public static int less(String word, int max) {
		int price = 0;
		while(true) {
			try {
				price = nextInt(word + "(" + max + "未満)");
				if(price != 0 && price < max) {
					break;
				}
			} catch (Exception e) {}
			reply(max + "未満の数値");
		}
		return price;
	}
	
	/**
	public static void() {
		
	}
//	*/
}
