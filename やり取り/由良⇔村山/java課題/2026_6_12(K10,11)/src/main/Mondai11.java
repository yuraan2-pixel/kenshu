package main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import been.ProductBeans;
import function.ProductcodeInput;
import function.ProductcostInput;
import function.ProductnameInput;
import function.Readtxt;

public class Mondai11 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		try (Scanner scanner = new Scanner(System.in);) {
			Map<String, ProductBeans> list = new TreeMap<String, ProductBeans>();

			//				今までの登録された商品情報の取得
			//				datatxtの中身を全件取得しｌist（Map）へ
			List<String> text = Readtxt.read();
			for (String line : text) {
				String[] sp = line.split(",");
				ProductBeans pb = new ProductBeans(sp[0], sp[1], sp[2]);
				list.put(sp[0], pb);
			}
			LABEL1: while (true) {
				System.out.println("商品を登録します。");

				//			商品コードの入力処理
				String code = ProductcodeInput.pc(scanner);

				//				9999へのコード分岐
				if (code.equals("9999")) {
					System.out.println("--------------結果を表示します。-----------------");

					//					登録した商品内容をtxtへ書き込み
					try {
						File file = new File("data.txt");
						PrintWriter filewriter = new PrintWriter(file);

						for (String key : list.keySet()) {
							ProductBeans pb = list.get(key);
							System.out.println(pb.getCode() + "," + pb.getName() + "," + pb.getCost());
							filewriter.println(pb.getCode() + "," + pb.getName() + "," + pb.getCost());
						}
						filewriter.close();
						break LABEL1;
					} catch (IOException e) {
						System.out.println(e);
					}
				}

				//			商品名の入力処理
				String name = ProductnameInput.pn(scanner);

				//			単価の入力処理
				String cost = ProductcostInput.pco(scanner);

				//			Beans、TreeMapに代入　　※商品コードが重複している場合は内容を上書きする。
				ProductBeans pb = new ProductBeans(code, name, cost);
				if (list.containsKey(code)) {
					System.out.println(code + "は商品内容を更新しました");
				}
				list.put(code, pb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}