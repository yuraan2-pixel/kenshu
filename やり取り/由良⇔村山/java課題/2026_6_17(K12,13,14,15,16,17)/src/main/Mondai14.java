package main;

import java.sql.Connection;

import db.DBManager2;
import function.ProductView;

public class Mondai14 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//		DB内の情報全件表示
		try (Connection connection = DBManager2.getConnection();) {
			ProductView.productview(connection);
		} catch (Exception e) {
			System.out.println("接続失敗しました。");
			e.printStackTrace();
		}
	}
}
