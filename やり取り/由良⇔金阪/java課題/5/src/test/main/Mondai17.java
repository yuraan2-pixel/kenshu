package test.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import test.bean.ProductBean;
import test.function.DBManager;
import test.function.SQLManager;

//	2026年6月1日
public class Mondai17 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList<ProductBean> al = new ArrayList<>();
		Connection con = null;
		
		try {
			con = DBManager.getConnection();
			SQLManager.getProduct(con, al);
			SQLManager.deleteProduct(con, al);
			
		} finally {
			DBManager.close(con);
		}
		
	}

}
