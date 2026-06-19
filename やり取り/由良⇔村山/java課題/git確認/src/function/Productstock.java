package function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Productstock {
	public static void productstockinput(Connection con, Scanner scan) {
		try {
			//	現在の全商品データを表示
			System.out.println("-------------------商品データ---------------------");
			String sql1 = "SELECT * FROM STOCK";
			Statement st = con.prepareStatement(sql1);
			ResultSet rs = st.executeQuery(sql1);
			while (rs.next()) {
				String code = rs.getString("商品コード");
				String day = rs.getString("入出庫履歴");
				int num = rs.getInt("入出庫数");
				String dateStr = day; // 日付文字列
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");//フォーマット
				System.out.println("商品コード：" + code + "入出庫履歴" + sdf.format(dateStr) + "入出庫数：" + num);
			}
			System.out.println("------------------------------------------------");

			while (true) {
				System.out.println("入出庫登録を行います。");
				System.out.println("次からお選びください。1：入庫、2：出庫、3：終了");
				String select = scan.nextLine();

				if (select.equals("1")) {
					//	入庫処理
					System.out.println("入庫を行う商品コードを入力してください。");
					String code = scan.nextLine();
					//	入庫数の入力
					int num = Stockkeisan.stockplus(scan);
					//データベースに登録
					String sql = "INSERT INTO PRODUCT(商品コード,入出庫履歴,入出庫履歴) VALUES(?,?,?)";
					PreparedStatement st2 = con.prepareStatement(sql);
					st2.setString(1, code);
					st2.setString(2, date);
					int cost = Integer.parseInt(c);
					st2.setInt(3, cost);
					st2.executeUpdate();

					String sql2 = "SELECT 入出庫履歴,入出庫数 FROM STOCK WHERE 商品コード=?";
					PreparedStatement st2 = con.prepareStatement(sql2);
					st2.setString(1, code);
					ResultSet rs2 = st2.executeQuery();
					while (rs2.next()) {
						String day = rs2.getString("入出庫履歴");
						int num = rs.getInt("入出庫数");
						String dateStr = day; // 日付文字列
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");//フォーマット
						System.out.println("入出庫履歴" + sdf.format(dateStr) + "入出庫数：" + num);
					}
					//	在庫数表示処理
					Productstockkeisan.productstockkeisan(con, code);

				} else if (select.equals("2")) {
					//	出庫処理

				} else if (select.equals("3")) {
					//	終了処理
					System.out.println("終了します。ありがとうございました。");
					break;
				} else {
					System.out.println("1～3を選んで下さい。");
				}
			}
		} catch (Exception e) {
			System.out.println("接続失敗しました。");
			e.printStackTrace();
		}
	}

}
