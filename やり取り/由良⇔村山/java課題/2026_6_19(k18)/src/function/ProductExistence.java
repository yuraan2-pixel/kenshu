package function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ProductExistence {
	public static boolean isproductexistence(Scanner scanner,Connection con) {
		while (true) {
			try  {
				System.out.println("検索したい商品コードを入力してください。");
				String selectcode = scanner.nextLine();

				String sql = "SELECT 商品コード FROM PRODUCT WHERE 商品コード=?";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, selectcode);
				ResultSet rs = st.executeQuery();
				if (rs.next()) {
					System.out.println("商品コード：" + selectcode + "の商品コードが見つかりました");
				} else {
					System.out.println("商品コード：" + selectcode + "の商品コードは見つかりませんでした。再度入力をお願い致します。");
				}
			} catch (Exception e) {
				System.out.println("接続失敗しました。");
				e.printStackTrace();
			}
		}
	}
}