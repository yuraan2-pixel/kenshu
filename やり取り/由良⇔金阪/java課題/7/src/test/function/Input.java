package test.function;

import java.util.Scanner;

/**
 * 
 * @author issadmin
 *
 */
public class Input {
	static int digLeng = 3;
	static int nameLeng = 20;
	static int lessLeng = 1000000;
	static String digWord = "商品コード";
	static String nameWord = "商品名";
	static String lessWord = "単価";
	
	
	/**
	 * 	word：文字入力受付
	 * @param sc	入力処理呼び出し
	 * @param word	処理内容を書き込む
	 * @return	String	入力内容の返却
	 */
	static String nextLine(Scanner sc, String word) {
		System.out.print(word + "：");
		return sc.nextLine();
	}
	/**
	 * 	word：数値入力受付
	 * @param sc	入力処理呼び出し
	 * @param word	処理内容の入力
	 * @return	int	入力数値の返却
	 */
	static int nextInt(Scanner sc, String word) {
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
	 * @param word	返答文	例*"正しい数値"
	 */
	static void reply(String word) {
		System.out.println(word + "を入力してください。\n");
	}
	
	/** 
	 * word (数値leng桁)：を表示	<p>
	 * leng 桁の数値の入力受付		<p>
	 * 誤入力の場合繰返し
	 * @param sc	入力処理呼び出し
	 * @param word	処理内容の入力
	 * @param leng	要求する桁数
	 * @return int	入力数値の返却
	 */
	public static int digit(Scanner sc, String word, int leng) {
		int number = 0;
		while(true) {
			try {
				String value = nextLine(sc, word + "(数値" + leng + "桁)");
				
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
	 * @param sc	入力処理呼び出し
	 * @param word	処理内容の入力
	 * @param leng	入力上限byte数
	 * @return	String	入力内容の返却
	 */
	public static String name(Scanner sc, String word, int leng) {
		String name = null;
		while(true) {
			try {
				name = nextLine(sc, word + "(" + leng + "byte以内)");
				
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
	 * @param sc	入力処理呼び出し
	 * @param word	処理内容の入力
	 * @param max	入力上限数
	 * @return	int	入力数値の返却
	 */
	public static int less(Scanner sc, String word, int max) {
		int price = 0;
		while(true) {
			try {
				price = nextInt(sc, word + "(" + max + "未満)");
				
				if(price >= 0 && price < max) {
					break;
				}
			} catch (Exception e) {}
			reply(max + "未満の数値");
		}
		return price;
	}
	
	static int codeLoop(Scanner sc) {
		int code;
		while(true) {
			code = digit(sc, digWord, digLeng);
			if(code == 999) {
				break;
			}
		}
		return code;
	}
}
