package test.function;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import test.bean.ReProduct;

//	2026年6月9日	コメント入力249まで完了	追加未定
public class Input {
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * 	word：文字入力受付
	 * @param word	処理内容を書き込む
	 * @return	String	入力内容の返却
	 */
	static String nextLine(String word) {
		System.out.print(word + "：");
		return sc.nextLine();
	}
	/**
	 * 	word：数値入力受付
	 * @param word	処理内容の入力
	 * @return	int	入力数値の返却
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
	 * @param word	返答文	例*"正しい数値"
	 */
	static void reply(String word) {
		System.out.println(word + "を入力してください。\n");
	}
	
	/** 
	 * word (数値leng桁)：を表示	<p>
	 * leng 桁の数値の入力受付		<p>
	 * 誤入力の場合繰返し
	 * @param word	処理内容の入力
	 * @param leng	要求する桁数
	 * @return int	入力数値の返却
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
	 * @param word	処理内容の入力
	 * @param leng	入力上限byte数
	 * @return	String	入力内容の返却
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
	 * @param word	処理内容の入力
	 * @param max	入力上限数
	 * @return	int	入力数値の返却
	 */
	public static int less(String word, int max) {
		int price = 0;
		while(true) {
			try {
				price = nextInt(word + "(" + max + "未満)");
				
				if(price >= 0 && price < max) {
					break;
				}
			} catch (Exception e) {}
			reply(max + "未満の数値");
		}
		return price;
	}
	
	
	/**
	 * すること：List入力の受付をループ(重複登録可)	<P>
	 * 1、code,name,priceの順に入力を受け付けてset	<P>
	 * 2、その際codeが999の場合入力を終了
	 * @param list	入力内容を保管する
	 */
	public static void listLoop(ArrayList<ReProduct> list) {
		while(true) {
			int code = Input.digit("商品コード", 3);
			
			if(code == 999) {
				break;
			} else list.add(new ReProduct(code));
		}
	}
	
	/**
	 * Set.codeとcodeが一致しているか判定
	 * @param set	比較する元データ
	 * @param code	入力されたコード
	 * @return	boolean	成否判定(一致していればtrue)
	 */
	static boolean distinction(Set<String> set, int code) {
		for(String info : set) {
			String[] word = info.split(",");
			int sCode = Integer.parseInt(word[0]);
			
			if(code == sCode)	return true;
		}
		return false;
	}
	/**
	 * すること：Set入力の受付をループ(更新不可)	<P>
	 * 1、code,name,priceの順に入力を受け付けてset	<P>
	 * 2、その際codeが999の場合入力を終了			<P>
	 * 3、入力済みのコードがあった場合再入力
	 * @param set	既存の判定 + 新規格納
	 */
	public static void setLoop(Set<String> set) {
		while(true) {
			int code = Input.digit("商品コード", 3);
			
			if(code == 999) {
				System.out.println("入力終了\n");
				break;
			} else if(distinction(set, code)) {
				reply("未登録の商品コード");
			} else set.add(new ReProduct(code).getInformation());
		}
	}
	
	/** List.codeとcodeが一致しているか判定
	 * @param list	比較する元データ
	 * @param code	入力されたコード
	 * @return	boolean	成否判定(一致していればtrue)
	 */
	public static boolean distinction(ArrayList<ReProduct> list, int code) {
		for(ReProduct info : list) {
			int sCode = info.getCode();
			
			if(code == sCode)	return true;
		}
		return false;
	}
	/**
	 * すること：List入力の受付をループ(更新不可)	<P>
	 * 1、code,name,priceの順に入力を受け付けてset	<P>
	 * 2、その際codeが999の場合入力を終了			<P>
	 * 3、入力済みのコードがあった場合再入力
	 * @param list	既存の判定
	 * @return ArrayList<ReProduct> 新規格納
	 */
	public static ArrayList<ReProduct> setUpLoop(ArrayList<ReProduct> list) {
		ArrayList<ReProduct> upal = new ArrayList<>();
		while(true) {
			int code = Input.digit("商品コード", 3);
			
			if(code == 999) {
				System.out.println("入力終了\n");
				break;
			} else if(distinction(list, code)) {
				reply("未登録の商品コード");
			} else upal.add(new ReProduct(code));
		} return upal;
	}
	
	/**
	 * すること：List入力の受付をループ(更新不可)	<P>
	 * 1、code,name,priceの順に入力を受け付けてset	<P>
	 * 2、その際codeが999の場合入力を終了			<P>
	 * 3、入力済みのコードがあった場合再入力
	 * @param list	既存の判定 + 新規格納
	 */
	public static void setLoop(ArrayList<ReProduct> list) {
		while(true) {
			int code = Input.digit("商品コード", 3);
			
			if(code == 999) {
				System.out.println("入力終了\n");
				break;
			} else if(distinction(list, code)) {
				reply("未登録の商品コード");
			} else list.add(new ReProduct(code));
		}
	}
	
	/**
	 * Listがcodeと合致した部分を返す
	 * @param list	元々入力されていた情報
	 * @param code	現在入力されている値
	 * @return	int	listの何番目のcodeが一致したかを返す
	 */
	public static int counter(ArrayList<ReProduct> list, int code) {
		int count = 0;
		
		for(ReProduct info : list) {
			if(code == info.getCode())	break;
			count++;
		}
		return count;
	}
	/**
	 * すること：List入力の受付をループ(更新可)		<P>
	 * 1、code,name,priceの順に入力を受け付けてset	<P>
	 * 2、その際codeが999の場合入力を終了			<P>
	 * 3、入力済みのコードがあった場合更新
	 * @param list	比較する元データ
	 * @return Set<Integer>	 どのcodeが更新されたか
	 */
	public static Set<Integer> dataLoop(ArrayList<ReProduct> list) {
		Set<Integer> codes = new TreeSet<>();
		while(true) {
			int code = Input.digit("商品コード", 3);
			int count = counter(list, code);
			
			if(code == 999) {
				System.out.println("入力終了\n");
				break;
			} else if(count == list.size()) {
				list.add(new ReProduct(code));
				codes.add(code);
			} else if(code == list.get(count).getCode()) {
				list.set(count, new ReProduct(code));
				codes.add(code);
			}
		}
		return codes;
	}
	
	
}
