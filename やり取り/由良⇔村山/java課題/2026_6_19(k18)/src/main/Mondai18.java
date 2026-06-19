package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import been.ProductBeans;
import db.DBManager2;
import function.ProductDelete;
import function.ProductFound;
import function.ProductIn;
import function.ProductUpdate;
import function.ProductView;
import function.ProductcodeInput;
import function.ProductcostInput;
import function.ProductnameInput;
import function.Productstock;
import function.Select3;

public class Mondai18 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Map<String, ProductBeans> inlist = new TreeMap<String, ProductBeans>();
		Map<String, ProductBeans> uplist = new TreeMap<String, ProductBeans>();
		Map<String, ProductBeans> alllist = new TreeMap<String, ProductBeans>();

		//	商品の追加、更新数が分かる変数
		int incount = 0;
		int upcount = 0;

		try (Scanner scanner = new Scanner(System.in);
				Connection connection = DBManager2.getConnection();) {
			try {
				LABEL1: while (true) {
					switch (Select3.select3(scanner)) {
					case 1 -> {
						//	商品登録について
						LABEL2: while (true) {
							System.out.println("実行する内容を選んで下さい。1：商品登録、2：商品削除、3：終了");
							String select = scanner.nextLine();
							if (select.equals("1")) {
								while (true) {
									ProductView.productview(connection);
									//	商品登録コード
									//	商品追加時に下記のコード実行
									if (incount >= 1) {
										System.out.println("---------追加しようとしている分------------");
										for (String key : inlist.keySet()) {
											ProductBeans pb = inlist.get(key);
											System.out.println(pb.getCode() + "" + pb.getName() + "" + pb.getCost());
										}
										System.out.println("--------------------------------------");
									}

									//	商品更新時に下記のコード実行
									if (upcount >= 1) {
										System.out.println("---------更新しようとしている分------------");
										for (String key : uplist.keySet()) {
											ProductBeans pb = uplist.get(key);
											System.out.println(pb.getCode() + "," + pb.getName() + "," + pb.getCost());
										}
										System.out.println("--------------------------------------");
									}

									System.out.println("商品を登録します。");

									//	商品コードの入力処理
									String code = ProductcodeInput.pc(scanner);

									//	商品更新 or 9999へのコード分岐
									if (ProductFound.productfound(connection, code)) {
										System.out.println("商品コードが重複しておりますので、商品内容を更新します。");
										//	商品名の入力処理
										String name = ProductnameInput.pn(scanner);

										//	単価の入力処理
										String cost = ProductcostInput.pco(scanner);

										//	Beans、TreeMapに代入
										ProductBeans pb = new ProductBeans(code, name, cost);
										uplist.put(code, pb);
										alllist.put(code, pb);

										//	upcount変数に1追加
										upcount += 1;

									} else if (code.equals("9999")) {
										for (String key : alllist.keySet()) {
											ProductBeans pb = alllist.get(key);
											//	上記の内容をDBへ追加
											if (ProductFound.productfound(connection, pb.getCode())) {
												//	商品コードが重複していたらUPDATEの処理を行う
												ProductUpdate.productupdate(connection, pb.getCode(), pb.getName(),
														pb.getCost());
											} else {
												//	商品コードが重複していなければINSERT処理を行う
												ProductIn.productin(connection, pb.getCode(), pb.getName(),
														pb.getCost());
											}
										}
										System.out.println("商品が" + incount + "件追加登録されました。");
										System.out.println("商品が" + upcount + "件更新されました。");
										ProductView.productview(connection);
										System.out.println("ご利用ありがとうございました。");

										//	MAP情報、count情報をクリア
										inlist.clear();
										uplist.clear();
										alllist.clear();
										incount = 0;
										upcount = 0;

										//	コミット処理
										connection.commit();
										break LABEL2;
									} else {
										//	商品名の入力処理
										String name = ProductnameInput.pn(scanner);

										//	単価の入力処理
										String cost = ProductcostInput.pco(scanner);

										//	Beans、TreeMapに代入
										ProductBeans pb = new ProductBeans(code, name, cost);
										inlist.put(code, pb);
										alllist.put(code, pb);

										//	incount変数に1追加
										incount += 1;
									}
								}
							} else if (select.equals("2")) {
								//	商品削除コード
								ProductDelete.productdelete(scanner, connection);
								System.out.println("ご利用ありがとうございました。");

								//	コミット処理
								connection.commit();
								break LABEL1;
							} else if (select.equals("3")) {
								//	終了コード
								System.out.println("ご利用ありがとうございました。");
								break LABEL1;
							} else {
								System.out.println("1～3を入力して下さい。");
							}
						}
					}
					case 2 -> {
						//	入出庫登録について
						Productstock.productstock(connection, scanner);
					}
					case 3 -> {
						//	在庫一覧について

					}
					default -> {
						//	終了処理
						System.out.println("ご利用ありがとうございました。");
						break LABEL1;
					}
					}
				}
			} catch (SQLException e) {
				//	エラー時ロールバック
				connection.rollback();
				throw e;
			} catch (Exception e) {
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
