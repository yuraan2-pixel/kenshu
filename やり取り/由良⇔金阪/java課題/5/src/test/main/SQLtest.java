package test.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import test.function.DBManager;

public class SQLtest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = null;
		// 問い合わせ取得結果を null
		Statement sta = null;
		// 実行結果のデータを　null
		ResultSet res = null;
		
		try {
			con = DBManager.getConnection();
			sta = con.createStatement();
			res = sta.executeQuery("SELECT * FROM 口座");
			while (res.next()) {
//			    String code = res.getString("口座番号");
//			    String name = res.getString("名義");
//			    String kind = res.getString("種別");
////			    int kind = res.getInt("種別");
//			    int price = res.getInt("残高");
			    Date upd = res.getDate("更新日");
			    System.out.println(upd);
			}
			
			
		} finally {
			DBManager.close(con);
		}
		
	}

}
