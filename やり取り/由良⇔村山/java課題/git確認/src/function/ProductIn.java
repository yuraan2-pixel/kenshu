package function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductIn {
	public static void productin(Connection con, String code, String name, String c) throws SQLException {
		String sql = "INSERT INTO PRODUCT(商品コード,商品名,単価) VALUES(?,?,?)";
		try (PreparedStatement st = con.prepareStatement(sql);) {
			// DB接続が成功したら、接続情報が返ってくる
			st.setString(1, code);
			st.setString(2, name);
			int cost = Integer.parseInt(c);
			st.setInt(3, cost);
			st.executeUpdate();

			//			st.setString(1, "666");
			//			st.setString(2, "テスト用");
			//			st.setInt(3, 9999);
			//			st.executeUpdate();

			//			throw new SQLException("なんかエラー");

		} catch (SQLException e) {
			System.out.println("接続失敗しました。");
			con.rollback();
			throw e;
		}
	}
}
