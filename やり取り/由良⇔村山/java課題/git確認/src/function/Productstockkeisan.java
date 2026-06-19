package function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Productstockkeisan {
public static void productstockkeisan(Connection con,String code) {
	String sql = "SELECT 入出庫数 FROM STOCK WHERE 商品コード=?";
	try(PreparedStatement st = con.prepareStatement(sql);) {
		st.setString(1, code);
		ResultSet rs = st.executeQuery();
		int result=0;
		while (rs.next()) {
			result = rs.getInt("入出庫数")+result;
		}
		System.out.println("在庫数："+result);
	} catch (Exception e) {
		System.out.println("接続失敗しました。");
		e.printStackTrace();
	}
}
}
