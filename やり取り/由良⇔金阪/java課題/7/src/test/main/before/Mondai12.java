package test.main.before;

import java.sql.Connection;

import test.function.DBManager;
//	2026年5月27日
public class Mondai12 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Connection connection = null;
		
		try {
			// DB接続が成功したら、接続情報が返ってくる
			connection = DBManager.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// DB接続を切断するメソッドに、接続情報を渡す
			DBManager.close(connection);
		}
//		System.out.println(connection.toString());
	}

}
