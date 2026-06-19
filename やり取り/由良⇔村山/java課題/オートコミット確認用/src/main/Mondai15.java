package main;

import java.sql.Connection;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import been.ProductBeans;
import db.DBManager2;
import function.ProductFound;
import function.ProductIn;
import function.ProductView;
import function.ProductcodeInput;
import function.ProductcostInput;
import function.ProductnameInput;

public class Mondai15 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Map<String, ProductBeans> list = new TreeMap<String, ProductBeans>();
		//		商品追加数が分かる変数
		int count = 0;

		try (Scanner scanner = new Scanner(System.in);
				Connection connection = DBManager2.getConnection();) {

			LABEL1: while (true) {
				ProductView.productview();

				//				商品追加時に下記のコード実行
				if (count >= 1) {
					System.out.println("---------追加しようとしている分------------");
					for (String key : list.keySet()) {
						ProductBeans pb = list.get(key);
						System.out.println(pb.getCode() + "," + pb.getName() + "," + pb.getCost());
					}
					System.out.println("--------------------------------------");
				}

				System.out.println("商品を登録します。");

				//			商品コードの入力処理
				String code = ProductcodeInput.pc(scanner);

				//				重複エラー+9999へのコード分岐
				if (ProductFound.productfound(code)) {
					System.out.println("商品コードが重複しております。");
					continue;
				} else if (code.equals("9999")) {
					for (String key : list.keySet()) {
						ProductBeans pb = list.get(key);
						//					上記の内容をDBへ追加
						ProductIn.productin(pb.getCode(), pb.getName(), pb.getCost());
					}
					System.out.println("商品が" + count + "件登録されました。");
					ProductView.productview();
					break LABEL1;
				}
				//			商品名の入力処理
				String name = ProductnameInput.pn(scanner);

				//			単価の入力処理
				String cost = ProductcostInput.pco(scanner);

				//			Beans、TreeMapに代入
				ProductBeans pb = new ProductBeans(code, name, cost);
				list.put(code, pb);

				//				count変数に1追加
				count += 1;
			}
		} catch (Exception e) {
			System.out.println("接続失敗しました。");
			e.printStackTrace();
		}
	}
}
