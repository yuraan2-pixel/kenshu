package test.function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import test.bean.ReProduct;

//	2026年6月9日	作成
public class IssueManeger extends SQLManager{	//	出庫
	static String STOCK = "SELECT * FROM STOCK";
	public static int Sellect() {
		String sentence = "";
		int sell = Input.less(sentence, 4);
		return sell;
	}
	
	public static void InsertSQL(Connection con, ReProduct rp) throws SQLException{
		PreparedStatement ps = con.prepareStatement(INSERT);
		ps.setString(1, rp.getCode(""));
		ps.setString(2, rp.getName());
		ps.setInt	(3, rp.getPrice());
		ps.executeUpdate();
	}
	
	public static void UpDateSQL(Connection con, ReProduct rp) throws SQLException{
		PreparedStatement ps = con.prepareStatement(UPDATE);
		ps.setString(1, rp.getName());
		ps.setInt	(2, rp.getPrice());
		ps.setString(3, rp.getCode(""));
		ps.executeUpdate();
	}
	
	public static void History(Connection con, ArrayList<ReProduct> list) throws SQLException {
		ResultSet res = SQLManager.getConection(con, STOCK);
		while(res.next()) list.add(new ReProduct(information(res)));
	}
	
	
}
