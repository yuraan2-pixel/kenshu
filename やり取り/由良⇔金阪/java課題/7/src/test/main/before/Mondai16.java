package test.main.before;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import test.bean.ProductBean;
import test.function.DBManager;
import test.function.Before.SQLManager;
import test.function.Before.UtilManeger;
//	2026年6月1日
public class Mondai16 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO 自動生成されたメソッド・スタブ
		Connection con = null;
		
		try {
			con = DBManager.getConnection();
			ArrayList<ProductBean> al = new ArrayList<>();
			Set<String> set = new TreeSet<>();
			
			SQLManager.	selectALProBe		(con, al);
			UtilManeger.registration	(al);
			SQLManager.	updateProBe	(con, al);
			SQLManager.	selectSProBe		(con, set);
			UtilManeger.indication		(set);
			
		}finally {
			DBManager.	close(con);
		}
	}

}
