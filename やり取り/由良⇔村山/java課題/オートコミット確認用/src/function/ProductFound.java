package function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBManager;

public class ProductFound {
	public static boolean productfound(String code) {
		try (Connection connection = DBManager.getConnection();) {
			//			SELECT文でDB内の情報を確認
			String sql = "SELECT * FROM PRODUCT where 商品コード=?";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, code);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("接続失敗しました。");
			e.printStackTrace();
			return true;
		}
	}
}
