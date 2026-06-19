package test.function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLServ {
	static String ProSeL = "SELECT * FROM PRODUCT";
	static String ProCan = "SELECT * FROM PRODUCT WHERE 商品コード = ?";
	static String ProINs = "INSERT INTO PRODUCT VALUES( ?, ?, ?)";	
	static String ProDel = "DELETE FROM PRODUCT WHERE 商品コード = ?";
	static String ProUpD = "UPDATE PRODUCT SET "
			+ "商品名 = ?, 単価 = ? WHERE 商品コード = ?";
	static String infoProduct(ResultSet res) throws SQLException {
		return res.getInt("商品コード") + ","
				+ res.getString("商品名") + "," + res.getInt("単価");
	}
	static void setProduct(PreparedStatement ps, 
			ProductServ psr, int[] order) throws SQLException {
		ps.setString(order[0], psr.getCode(""));
	}
	
	static String StoSeL = "SELECT * FROM STOCK";
	static String StoCan = "SELECT * FROM STOCK WHERE 商品コード = ?";
	static String StoINs = "INSERT INTO STOCK VALUES( ?, ?, ?)";
	static String StoDel = "DELETE FROM STOCK WHERE 商品コード = ?";
	static String StoUpD = "UPDATE STOCK SET 在庫数 = ?, 入出庫履歴 = "
			+ "TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS') WHERE 商品コード = ?";
	static String infoStock(ResultSet res) throws SQLException {
		return res.getInt("商品コード") + "," 
				+ res.getInt("在庫数") + "," + res.getDate("入出庫履歴");
	}
	
	
	static String Where = ".*?";
	static ArrayList<String> selectSet
	(Connection con, String SQL, String code) throws SQLException {
		PreparedStatement PreS = con.prepareStatement(SQL);
		ArrayList<String> sel = new ArrayList<>();
		
		if(SQL.matches(Where)) PreS.setString(1, code);
		ResultSet res = PreS.executeQuery();
		
		if(SQL.matches(".*PRODUCT.*"))
		while(res.next()) sel.add(infoProduct(res));
		
		else if(SQL.matches(".*STOCK.*"))
		while(res.next()) sel.add(infoStock(res));
		
		return sel;
	}
	
	
	static int[] getSize(Object info) throws SQLException {
		String[] word = info.toString().split(",");
		int[] size = new int[word.length];
		
		for(int i = 0; i < word.length; i++) {size[i] = i;}
		return size;
	}
	static void insertSet
	(Connection con, String SQL, Object info) throws SQLException {
		PreparedStatement PreS = con.prepareStatement(SQL);
		int[] order = getSize(info);
		if(SQL.matches("INSERT.*")) {
			
		} else if(SQL.matches("UPDATE.*")) {
			
		}
		
	}
//	static ResultSet SQLResult(String SQL) {}
//	static ResultSet SQLResult(String SQL) {}

}
