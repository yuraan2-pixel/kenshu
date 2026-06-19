package main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import been.ProductBeans;

public class Mondai09 {
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Map<String, ProductBeans> list = new TreeMap<String, ProductBeans>();
		LABEL1: while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("商品を登録します。");
			System.out.println("商品コードを入力してください。9999と入力すると終了します。");
			String code = scanner.nextLine();
			if (code.equals("9999")) {
				System.out.println("--------------結果を表示します。-----------------");
				try {
					File file = new File("data.txt");
					PrintWriter filewriter = new PrintWriter(file);

					for (String key : list.keySet()) {

						ProductBeans pb = list.get(key);
						System.out.println(pb.getCode()+ "," + pb.getName() + "," + pb.getCost());
						filewriter.println(pb.getCode()+ "," + pb.getName() + "," + pb.getCost());
					}
					//					for (Map.Entry<String, ProductBeans> listAll : list.entrySet()) {

					//						ProductBeans pb=listAll.getValue();
					//						System.out.println(listAll.getKey() + "," + listAll.getValue().getCode()+ listAll.getValue().getName());
					//						System.out.println(listAll.getKey() + "," + pb.getName());
					//					}
					filewriter.close();
					break LABEL1;
				} catch (IOException e) {
					System.out.println(e);
				}
			}

			//			エラーチェック
			String string = code;
			if (!(string.matches("[0-9]{3}"))) {
				System.out.println("エラーです。数字3桁で入力して下さい。");
				continue;
			}

			System.out.println("商品名を入力してください。");
			String name = scanner.nextLine();

			//			エラーチェック
			String string2 = name;
			try {
				int c = (string2.getBytes("Shift_JIS").length);
				if (c >= 21) {
					System.out.println("エラーです。文字数が多いです。");
					continue;
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}

			System.out.println("単価を入力してください。");
			String cost = scanner.nextLine();

			//			エラーチェック
			String string3 = cost;
			int n = Integer.parseInt(string3);
			System.out.println(n);
			;
			if (n >= 1000000) {
				System.out.println("エラーです。金額が大きすぎます。");
				continue;
			}

			//			Beans、TreeMapに代入
			ProductBeans pb = new ProductBeans(code, name, cost);
			list.put(code, pb);
		}
	}
}