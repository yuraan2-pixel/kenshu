package function;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.DBManager;

public class ProductUpdate {
	public static void productupdate(String code,String name,String c) {
		try (Connection connection = DBManager.getConnection();) {
			// DB接続が成功したら、接続情報が返ってくる
			String sql = "UPDATE PRODUCT SET 商品名=?,単価=? where 商品コード=?";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, name);
			int cost = Integer.parseInt(c);
			st.setInt(2, cost);
			st.setString(3, code);
			st.executeUpdate();
		} catch (Exception e) {
			System.out.println("接続失敗しました。");
			e.printStackTrace();
		}
	}
}
