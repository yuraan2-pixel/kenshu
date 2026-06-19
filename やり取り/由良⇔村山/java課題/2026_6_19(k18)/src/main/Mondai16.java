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
import function.ProductdeleteCode;
import function.ProductnameInput;

public class Mondai16 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Map<String, ProductBeans> inlist = new TreeMap<String, ProductBeans>();
		Map<String, ProductBeans> uplist = new TreeMap<String, ProductBeans>();
		Map<String, ProductBeans> alllist = new TreeMap<String, ProductBeans>();

		//		商品の追加、更新数が分かる変数
		int incount = 0;
		int upcount = 0;

		try (Scanner scanner = new Scanner(System.in);
				Connection connection = DBManager2.getConnection();) {

			LABEL1: while (true) {
				ProductView.productview(connection);

				//				商品追加時に下記のコード実行
				if (incount >= 1) {
					System.out.println("---------追加しようとしている分------------");
					for (String key : inlist.keySet()) {
						ProductBeans pb = inlist.get(key);
						System.out.println(pb.getCode() + "," + pb.getName() + "," + pb.getCost());
					}
					System.out.println("--------------------------------------");
				}

				//				商品更新時に下記のコード実行
				if (upcount >= 1) {
					System.out.println("---------更新しようとしている分------------");
					for (String key : uplist.keySet()) {
						ProductBeans pb = uplist.get(key);
						System.out.println(pb.getCode() + "," + pb.getName() + "," + pb.getCost());
					}
					System.out.println("--------------------------------------");
				}

				System.out.println("商品を登録します。");

				//			商品コードの入力処理
				String code = ProductcodeInput.pc(scanner);

				//				商品更新 or 9999へのコード分岐
				if (ProductFound.productfound(connection,code)) {
					System.out.println("商品コードが重複しておりますので、商品内容を更新します。");
					//			商品名の入力処理
					String name = ProductnameInput.pn(scanner);

					//			単価の入力処理
					String cost = ProductcostInput.pco(scanner);

					//			Beans、TreeMapに代入
					ProductBeans pb = new ProductBeans(code, name, cost);
					uplist.put(code, pb);
					alllist.put(code, pb);

					//				upcount変数に1追加
					upcount += 1;

				} else if (code.equals("9999")) {
					for (String key : alllist.keySet()) {
						ProductBeans pb = alllist.get(key);
						//					上記の内容をDBへ追加
						if (ProductFound.productfound(connection,pb.getCode())) {
							ProductdeleteCode.productdeletecode(connection,pb.getCode());
						}
						ProductIn.productin(connection,pb.getCode(), pb.getName(), pb.getCost());
					}
					System.out.println("商品が" + incount + "件追加登録されました。");
					System.out.println("商品が" + upcount + "件更新されました。");
					ProductView.productview(connection);
					break LABEL1;
				} else {
					//			商品名の入力処理
					String name = ProductnameInput.pn(scanner);

					//			単価の入力処理
					String cost = ProductcostInput.pco(scanner);

					//			Beans、TreeMapに代入
					ProductBeans pb = new ProductBeans(code, name, cost);
					inlist.put(code, pb);
					alllist.put(code, pb);

					//				incount変数に1追加
					incount += 1;
				}
			}
		} catch (Exception e) {
			System.out.println("接続失敗しました。");
			e.printStackTrace();
		}
	}
}