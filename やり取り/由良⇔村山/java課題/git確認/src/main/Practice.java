package main;

import java.sql.Connection;
import java.util.Scanner;

import db.DBManager2;
import function.Stockkeisan;

public class Practice {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		try (Scanner scanner = new Scanner(System.in);
				Connection connection = DBManager2.getConnection();) {
			int a=Stockkeisan.stockplus(scanner)*-1;
			System.out.println(a);
			System.out.println(a+10);
		} catch (Exception e) {
			System.out.println("接続失敗しました。");
			e.printStackTrace();
		}
	}
}
