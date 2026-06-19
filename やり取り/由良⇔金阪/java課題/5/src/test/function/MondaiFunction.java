package test.function;

import java.util.Scanner;

public class MondaiFunction {
	static Scanner sc = new Scanner(System.in);
	
	public static int input(String word) {
		MondaiFunction mf = new MondaiFunction();
		int num = 0;
		while(true) {
			mf.sysout(word);
			String fore = sc.nextLine();
			
			if(fore.matches("[0-9]{3}")) {
				num = Integer.parseInt(fore);
				break;
			}
			rep("整数3桁");
		}
		return num;
	}
	
	/**
	 * 1.与えられたwordとlengを使用して文章を表示<p>
	 * 2.入力を受け付け<p>
	 * 3.数字かどうか	と	指定した桁数になっているか	を判別<p>
	 * 4.違った場合はエラーを表示して繰返す<p>
	 * 5.問題無かった場合	その値を返して終了<p>
	 * @param word
	 * @param leng
	 * @return	int
	 */
	public int input(String word, int leng) {
		int num = 0;
		
		while(true) {
			sysout(digits(word, leng));
			String fore = sc.nextLine();
			
			if(fore.length() == leng && fore.matches("[0-9].*")) {
				try {
					num = Integer.parseInt(fore);
					break;
				} catch (Exception e) {	}
			}
			rep("整数" + leng + "桁");
		}
		return num;
	}
	
	/**
	 * 1.与えられたwordとmin,maxを使用して文章を表示<p>
	 * 2.入力を受け付け<p>
	 * 3.指定された範囲になっているか	を判別<p>
	 * 4.違った場合はエラーを表示して繰返す<p>
	 * 5.問題無かった場合	その値を返して終了<p>
	 * @param word
	 * @param min
	 * @param max
	 * @return	int
	 */
	public int input(String word, int min, int max) {
		int num = 0;
		while(true) {
			sysout(range(word, min, max));
			String fore = sc.nextLine();
			try {
				num = Integer.parseInt(fore);
				
				if(min < num && max > num) {
					break;
				} else rep("規定値内の値");
				
			} catch (Exception e) {
				rep();
			}
		}
		return num;
	}
	
	/**
	 * 1.与えられたwordとlengを使用して文章を表示<p>
	 * 2.入力を受け付け<p>
	 * 3.指定した文字数内に収まっているか	を判別<p>
	 * 4.違った場合はエラーを表示して繰返す<p>
	 * 5.問題無かった場合	その値を返して終了<p>
	 * @param word
	 * @param leng
	 * @return	String
	 */
	public String input(String word, String leng) {
		String name = "";
		int num = Integer.parseInt(leng);
		
		while(true) {
			sysout(within(word, leng));
			name = sc.nextLine();
			
			if(name.length() <= num) {
				break;
			} else rep(leng + "文字以内で名称");
			
		}
		return name;
	}
	
	
	
	//	入力省略用	スッキリ見せるのに使いたいと思って作成
	
	static void rep() {
		System.out.print("正しい値");
		rep(1);
	}
	
	static void rep(int i) {
		System.out.println("を入力してください\n");
	}
	
	static void rep(String word) {
		System.out.print(word);
		rep(1);
	}
	
	/**
	 * word	を出力する
	 * @param word
	 */
	public void sysout(String word) {
		System.out.print(word + "：");
	}
	
	/**
	 * 整数を入力してください	を表示
	 * @return 
	 */
	static String inter() {
		return pleasEnter("整数");
	}
	
	/**
	 * leng	桁の整数を入力してください	を表示
	 * @param leng	
	 * @return 
	 */
	static String digits(int leng) {
		return (leng + "桁の" + inter());
		
	}
	
	/**
	 * word	を入力してください	を表示
	 * @param word
	 * @return 
	 */
	static String pleasEnter(String word) {
		return (word + "を入力してください");
	}
	
	/**
	 * word	(num 文字以内)：	を表示
	 * @param word
	 * @param leng
	 * @return 
	 */
	static String within(String word, String leng) {
		return (word + "(" + leng + "文字以内)");
	}
	
	/**
	 * word	(数値 leng 桁)：	を表示
	 * @param word
	 * @param leng
	 * @return 
	 */
	static String digits(String word, int leng) {
		return (word + "(数値" + leng + "桁)");
	}
	
	/**
	 * word	(min 超、max 未満)	を表示
	 * @param word
	 * @param min
	 * @param max
	 * @return 
	 */
	static String range(String word, int min, int max) {
		if(min == 0) {
			String f = "%s(%,d未満)";
			return String.format(f, word, max);
		} else {
			String f = "%s(%,d超、%,d未満)";
			return String.format(f, word, min, max);
		}
	}
}
