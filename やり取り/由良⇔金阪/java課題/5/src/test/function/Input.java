package test.function;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import test.bean.ReProduct;

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
	 * code,name,priceの順に入力を受け付けてset
	 * その際codeが999の場合入力を終了
	 * @param list
	 */
	public static void listLoop(ArrayList<ReProduct> list) {
		while(true) {
			int code = ReProduct.SetCode();
			if(code == 999) {
				break;
			} else list.add(new ReProduct(code));
		}
	}
	
//	/**
	public static void setLoop(Set<String> set) {
		while(true) {
			int code = ReProduct.SetCode();
			if(code == 999) {
				System.out.println("入力終了\n");
				break;
			} else if(distinction(set, code)) {
				reply("未登録の商品コード");
			} else set.add(new ReProduct(code).getInformation());
		}
	}
	
//	/**
	public static void dateLoop(ArrayList<ReProduct> list) {
		while(true) {
			int code = ReProduct.SetCode();
			int count = counter(list, code);
			if(code == 999) {
				System.out.println("入力終了\n");
				break;
			} else if(code == list.get(count).getCode()) {
				list.set(count, new ReProduct(code));
			} else list.add(new ReProduct(code));
		}
	}
	
//	/**
	static boolean distinction(Set<String> set, int code) {
		for(String info : set) {
			String[] word = info.split(",");
			int sCode = Integer.parseInt(word[0]);
			if(code == sCode)	return true;
		}
		return false;
	}
	
//	/**
	static int counter(ArrayList<ReProduct> list, int code) {
		int count = 0;
		for(ReProduct info : list) {
			if(code == info.getCode())	break;
			count++;
		}
		return count;
	}
}
