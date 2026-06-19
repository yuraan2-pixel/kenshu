package function;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import db.DBManager;

public class ProductView {
	public static void productview() {
		try (Connection connection = DBManager.getConnection();) {
			System.out.println("-------------------商品一覧----------------------");
			String sql = "SELECT * FROM PRODUCT ORDER BY 商品コード";
			Statement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String code = rs.getString("商品コード");
				String name = rs.getString("商品名");
				int cost = rs.getInt("単価");
				System.out.println(code + "," + name + "," + cost);
			}
			System.out.println("------------------------------------------------");
		} catch (Exception e) {
			System.out.println("接続失敗しました。");
			e.printStackTrace();
		}
	}
}