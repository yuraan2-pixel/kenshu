package test.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import test.bean.ProductBean;
import test.function.DBManager;
import test.function.SQLManager;
import test.function.UtilManeger;
//	2026年5月28日
public class Mondai14 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Connection con = null;
		
		try {
			con = DBManager.getConnection();
			ArrayList<ProductBean> al = new ArrayList<>();
			SQLManager.getProduct(con, al);
			UtilManeger.indicationP(al);
			
		}finally {
			DBManager.close(con);
		}
	}
}
