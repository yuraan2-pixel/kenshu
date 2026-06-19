package test.function.Before;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import test.bean.ProductBean;

//	2026年6月9日	作成
public class IssueManeger extends SQLManager{	//	出庫
	static String STOSEL = "SELECT * FROM STOCK WHERE 商品コード = ?";
	static String STOUPD = "UPDATE STOCK SET 在庫数 = ?, "
			+ "入出庫履歴 = TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS') WHERE 商品コード = ?";
	
	public static boolean scanProduct() {
		
		
		return done;
	}
	
	public static void insertProBe
	(Connection con, ArrayList<ProductBean> list) throws SQLException {
		
		
	}
	
	public static String seLectStock
	(Connection con, String code) throws SQLException, ParseException {
		PreparedStatement prst = con.prepareStatement(STOSEL);
		prst.setString(1, code);
		ResultSet rest = prst.executeQuery();
		return information(rest);
	}
	/** 
	 * SELECT文の値を代入して返却
	 * @param res	SQL文入りの動作データ
	 * @return	String	,区切りの商品情報
	 * @throws SQLException	Conが違う、接続先が見つからない、関係ないSQL文の場合エラー
	 */
	static String information(ResultSet res) throws SQLException {
		return res.getInt("商品コード") + "," 
	+ res.getString("在庫数") + "," + res.getInt("入出庫履歴");
	}
	
	public static void inSertStock(Connection con, ProductBean pb) throws SQLException{
		PreparedStatement ps = con.prepareStatement(INSERT);
		ps.setString(1, pb.getCode(""));
		ps.setString(2, pb.getName());
		ps.setInt	(3, pb.getPrice());
		ps.executeUpdate();
	}
	
	public static void upDateStock(Connection con, ProductBean pb) throws SQLException{
		PreparedStatement ps = con.prepareStatement(UPDATE);
		ps.setString(1, pb.getName());
		ps.setInt	(2, pb.getPrice());
		ps.setString(3, pb.getCode(""));
		ps.executeUpdate();
	}
	
	
}
