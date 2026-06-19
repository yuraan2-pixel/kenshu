package test.function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;

import test.bean.ProductBean;

//	2026年5月28日
public class SQLManager {
	public static ResultSet getConection(Connection con, String SQL) throws SQLException {
		Statement sta = con.createStatement();
		ResultSet res = sta.executeQuery(SQL);
		return res;
	}
	
	public static ArrayList<ProductBean> getProduct(Connection con, ArrayList<ProductBean> al) throws SQLException {
		String SQL = "SELECT * FROM PRODUCT";
		ResultSet res = SQLManager.getConection(con, SQL);
		
		while(res.next()) {
			al.add(new ProductBean(res.getInt("商品コード"), 
					res.getString("商品名"), res.getInt("単価")));
		}
		return al;
	}
	
	public static void getProduct(Connection con, Set<String> set) throws SQLException {
		String SQL = "SELECT * FROM PRODUCT";
		ResultSet res = SQLManager.getConection(con, SQL);
		
		while(res.next()) {
			set.add(new ProductBean(res.getInt("商品コード"), 
					res.getString("商品名"), res.getInt("単価")).getInformation());
		}
	}
	
	public static void setProduct(Connection con, Set<String> set, ArrayList<ProductBean> al) throws SQLException {
		String SQL = "INSERT INTO PRODUCT VALUES( ?, ?, ?)";
		for(String word : set) {
			ProductBean pb = new ProductBean(word);
			PreparedStatement ps = con.prepareStatement(SQL);
			boolean done = true;
			
			for(ProductBean alpb : al) {
				if(pb.getCode() == alpb.getCode()) {
					done = false;
					break;
				}
			}
			if(done) {
				for (int i = 0; i < 4; i++) {
					ps.setString(1, pb.getCode(""));
					ps.setString(2, pb.getName());
					ps.setInt(3, pb.getPrice());
				}
				ps.executeQuery();
			}
		}
	}
	
	public static void updateProduct(Connection con, ArrayList<ProductBean> al) throws SQLException {
		String ins = "INSERT INTO PRODUCT VALUES( ?, ?, ?)";
		String upd = "UPDATE PRODUCT SET 商品名 = ?, 単価 = ? WHERE 商品コード = ?";
		ArrayList<ProductBean> former = new ArrayList<>();
		SQLManager.getProduct(con, former);
		
		for(ProductBean pb : al) {
			PreparedStatement inps = con.prepareStatement(ins);
			PreparedStatement udps = con.prepareStatement(upd);
			boolean done = true;
			
			for(ProductBean alpb : former) {
				if(pb.getCode() == alpb.getCode()) {
					done = false;
					break;
				}
			}
			if(done) {
				for (int i = 0; i < 3; i++) {
					inps.setString(1, pb.getCode(""));
					inps.setString(2, pb.getName());
					inps.setInt(3, pb.getPrice());
				}
				inps.executeQuery();
			} else {
				for (int i = 0; i < 3; i++) {
					udps.setString(1, pb.getName());
					udps.setInt(2, pb.getPrice());
					udps.setString(3, pb.getCode(""));
				}
				udps.executeQuery();
			}
		}
	}
	
	public static void deleteProduct(Connection con, ArrayList<ProductBean> al) throws SQLException {
		String SQL = "DELETE FROM PRODUCT WHERE 商品コード = ?";
		ArrayList<ProductBean> del = new ArrayList<>();
		boolean beg = false;
		int code = 0;
		
		while(true) {
			code = MondaiFunction.input("削除する商品コード");
			if(code == 999) {
				System.out.println("入力終了\n");
				break;
			}
			for(ProductBean pb : al) {
				if(code == pb.getCode()) {
					del.add(pb);
					beg = true;
					break;
				}
			}
			if(!beg) {
				System.out.println("指定された商品コードは存在しません。");
			}
		}
		PreparedStatement ps = con.prepareStatement(SQL);
		for(int i = 0; i < del.size(); i++) {
			ps.setInt(1, del.get(i).getCode());
			ps.executeUpdate();
		}
		
	}
}
