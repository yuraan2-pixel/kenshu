package function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import db.DBManager2;

public class ProductDelete {
	public static void productdelete() {
		Scanner scanner = new Scanner(System.in);
		try (Connection connection = DBManager2.getConnection();) {
			while (true) {
				System.out.println("削除したい商品コードを入力してください。終了する場合は9999を入力してください。");
				String selectcode = scanner.nextLine();

				//				終了コード
				if (selectcode.equals("9999")) {
					break;
				}

				String sql = "SELECT 商品コード FROM PRODUCT WHERE 商品コード=?";
				PreparedStatement st = connection.prepareStatement(sql);
				st.setString(1, selectcode);
				ResultSet rs = st.executeQuery();
				if (rs.next()) {
					//					同じ商品コードが見つかればDeleteメソッド実施
					ProductdeleteCode.productdeletecode(selectcode);
					System.out.println(	"商品コード："+selectcode+"の商品情報を削除しました。");
				} else {
					System.out.println("商品コードが見つかりませんでした。再度入力をお願い致します。");
				}
			}
		} catch (Exception e) {
			System.out.println("接続失敗しました。");
			e.printStackTrace();
		}
	}
}
