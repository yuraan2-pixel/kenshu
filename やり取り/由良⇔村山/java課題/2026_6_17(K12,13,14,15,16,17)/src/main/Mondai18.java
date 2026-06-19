package main;

import java.sql.Connection;
import java.util.Scanner;

import db.DBManager2;
import function.Select3;

public class Mondai18 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		try (Scanner scanner = new Scanner(System.in);
				Connection connection = DBManager2.getConnection();) {
			while (true) {
				switch (Select3.select3(scanner)) {
				case 1 -> {
					//				商品登録について
					
				}
				case 2 -> {
					//				入出庫登録について
					
				}
				case 3 -> {
					//				在庫一覧について
					
				}
				}
			}
		} catch (Exception e) {
			System.out.println("接続失敗しました。");
			e.printStackTrace();
		}
	}

}
