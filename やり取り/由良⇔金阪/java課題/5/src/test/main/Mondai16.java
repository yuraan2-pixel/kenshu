package test.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import test.bean.ProductBean;
import test.function.DBManager;
import test.function.SQLManager;
import test.function.UtilManeger;
//	2026年6月1日
public class Mondai16 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO 自動生成されたメソッド・スタブ
		Connection con = null;
		
		try {
			con = DBManager.getConnection();
			ArrayList<ProductBean> al = new ArrayList<>();
			Set<String> set = new TreeSet<>();
			
			SQLManager.	getProduct		(con, al);
			UtilManeger.registration	(al);
			SQLManager.	updateProduct	(con, al);
			SQLManager.	getProduct		(con, set);
			UtilManeger.indication		(set);
			
		}finally {
			DBManager.	close(con);
		}
	}

}
