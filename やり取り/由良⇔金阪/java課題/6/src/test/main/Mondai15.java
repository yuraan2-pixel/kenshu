package test.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import test.bean.ProductBean;
import test.function.DBManager;
import test.function.SQLManager;
import test.function.UtilManeger;
//	2026年5月28日
public class Mondai15 {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		// TODO 自動生成されたメソッド・スタブ
		Connection con = null;
		
		try {
			con = DBManager.getConnection();
			Set<String> set = new TreeSet<>();
			ArrayList<ProductBean> al = new ArrayList<>();
			
			SQLManager.getProduct(con, al);
			for(ProductBean pb : al) {
				set.add(pb.getInformation());
			}
			UtilManeger.registration(set);
			SQLManager.setProduct(con, set, al);
			
		}finally {
			DBManager.close(con);
		}
	}

}
