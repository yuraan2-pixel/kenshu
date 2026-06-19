package function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

public class Productstock {
	public static void productstock(Connection con, Scanner scan) throws DateTimeParseException {
		try {
			while (true) {
				//	現在の全商品データを表示
				System.out.println("-------------------商品データ---------------------");
				String sql1 = "SELECT * FROM STOCK";
				Statement st = con.prepareStatement(sql1);
				ResultSet rs = st.executeQuery(sql1);
				while (rs.next()) {
					String code = rs.getString("商品コード");
					String day = rs.getString("入出庫履歴");
					int num = rs.getInt("入出庫数");
					SimpleDateFormat d1 = new SimpleDateFormat("yyyyMMdd");//フォーマット
					Date d2 = d1.parse(day);//String型をDate型に
					SimpleDateFormat d3 = new SimpleDateFormat("yyyy年MM月dd日");//フォーマット
					System.out.println("商品コード：" + code + " 、 " + "入出庫履歴" + d3.format(d2) + " 、 " + "入出庫数：" + num);
				}
				System.out.println("------------------------------------------------");

				System.out.println("入出庫登録及び在庫確認を行います。");
				System.out.println("次からお選びください。1：入庫、2：出庫、3:在庫確認、4：終了");
				String select = scan.nextLine();

				if (select.equals("1")) {
					//	入庫処理
					//	商品コードの入力
					String code = StockcodeInput.stockcodeinput(scan, select);
					//	入庫数の入力
					int num = Stockkeisan.stockkeisan(scan, select);
					// 登録日の入力
					String day = Stockday.stockday(scan);
					//データベースに登録
					String sql = "INSERT INTO STOCK(商品コード,入出庫履歴,入出庫数) VALUES(?,?,?)";
					PreparedStatement st2 = con.prepareStatement(sql);
					st2.setString(1, code);
					st2.setString(2, day);
					st2.setInt(3, num);
					st2.executeUpdate();

					System.out.println("入庫登録完了しました。");

				} else if (select.equals("2")) {
					//	出庫処理
					//	商品コードの入力
					String code = StockcodeInput.stockcodeinput(scan, select);
					//	出庫数の入力
					int num = Stockkeisan.stockkeisan(scan, select) * -1;
					// 登録日の入力
					String day = Stockday.stockday(scan);
					//データベースに登録
					String sql = "INSERT INTO STOCK(商品コード,入出庫履歴,入出庫数) VALUES(?,?,?)";
					PreparedStatement st2 = con.prepareStatement(sql);
					st2.setString(1, code);
					st2.setString(2, day);
					st2.setInt(3, num);
					st2.executeUpdate();

					System.out.println("出庫登録完了しました。");

				} else if (select.equals("3")) {
					//	在庫確認の処理
					System.out.println("在庫確認を行う商品コードを入力してください。");
					String code = scan.nextLine();
					//	在庫数表示処理
					Productstockkeisan.productstockkeisan(con, code);
				} else if (select.equals("4")) {
					//	終了処理
					System.out.println("終了します。ありがとうございました。");
					break;
				} else {
					System.out.println("1～4を選んで下さい。");
				}
			}
		} catch (Exception e) {
			System.out.println("商品コードが重複しております。再度入力をお願い致します。");
		}
	}
}
