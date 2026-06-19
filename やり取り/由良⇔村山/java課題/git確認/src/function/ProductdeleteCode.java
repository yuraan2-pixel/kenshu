package function;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductdeleteCode {
	public static void productdeletecode(Connection con,String code) {
		try {
			// DB接続が成功したら、接続情報が返ってくる
			String sql = "DELETE FROM PRODUCT WHERE 商品コード=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, code);
			st.executeUpdate();
		} catch (Exception e) {
			System.out.println("接続失敗しました。");
			e.printStackTrace();
		}
	}
}
