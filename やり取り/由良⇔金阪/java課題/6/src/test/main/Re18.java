package test.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import test.bean.ReProduct;
import test.function.DBManager;
import test.function.Input;
import test.function.IssueManeger;

//	2026年6月9日	問題確認
public class Re18 {
	public static void main(String[] args) {
		ArrayList<ReProduct> list = new ArrayList<>();
		try(Connection con = DBManager.getConnection()) {
			
			while(true) {
//			商品登録か入出庫登録か在庫一覧：
				IssueManeger.selectALRePro(con, list);
				int sellect = IssueManeger.Sellect();
				
				switch(sellect) {
//				商品登録を選んだ際、
				case 1 -> {
					ArrayList<ReProduct> befo = list;
					Set<Integer> codes = new TreeSet<>();
//					商品登録入力：
					codes = Input.dataLoop(list);
					for(int i : codes) {
//						Listの何番目に入っているか判定
						int num = Input.counter(list, i);
						if( num > befo.size()) {
//							num番のlistをINSERTに代入して更新
							IssueManeger.InsertSQL(con, list.get(num));
						} else {
//							num番のlistをUPDATEに代入して更新
							IssueManeger.UpDateSQL(con, list.get(num));
						}
					}
//					商品登録が終わると最初の選択に戻る。
				}
//				入出庫を選んだ際、
				case 2 -> {
//					商品コードの入力：
					int code = Input.digit("商品コード", 3);
//					入出庫履歴と現在の在庫数を表示後、
					
//					日にち（年月日）、増減する個数を入力して登録
//					在庫チェック（在庫を上回る出庫はできない）
					
//		入出庫の登録の最後も何らかで判断する。（特定キーを入力）とか。
					
				}
//				在庫一覧を選んだ際、
				case 3 -> {
//					商品の一覧と現在の在庫数を一覧表示
					
				}
				case 4 -> {
//				終わり方の記載がない？	終了ボタン作ろか
					
				}
			}
		}
//		入出庫の登録で在庫を管理するテーブルを登録
//		ちなみに、商品テーブルと入出庫管理のテーブルは商品コードを外部キーで設定してみる。
//		商品を削除したら入出庫履歴も消えるように。
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
