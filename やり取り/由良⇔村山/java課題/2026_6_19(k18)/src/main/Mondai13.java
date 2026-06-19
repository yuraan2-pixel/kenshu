package main;

import java.sql.Connection;

import db.DBManager;

public class Mondai13 {
	public static void main(String[] args) {
		// connectionオブジェクトを生成
		Connection connection = null;
		
		try {
			// DB接続が成功したら、接続情報が返ってくる
			connection = DBManager.getConnection();
		}catch(Exception e) {
			System.out.println("接続失敗しました。");
			e.printStackTrace();
		}finally {
			// DB接続を切断するメソッドに、接続情報を渡す
			System.out.println("接続を切断しました。");
			DBManager.close(connection);
		}
	}
}
