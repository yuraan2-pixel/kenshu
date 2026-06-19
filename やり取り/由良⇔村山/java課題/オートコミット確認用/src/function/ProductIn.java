package function;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.DBManager;

public class ProductIn {
	public static void productin(String code,String name,String c) {
		try (Connection connection = DBManager.getConnection();) {
			// DB接続が成功したら、接続情報が返ってくる
			String sql = "INSERT INTO PRODUCT(商品コード,商品名,単価) VALUES(?,?,?)";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, code);
			st.setString(2, name);
			int cost=Integer.parseInt(c);
			st.setInt(3, cost);
			st.executeUpdate();
		} catch (Exception e) {
			System.out.println("接続失敗しました。");
			e.printStackTrace();
		}
	}
}
