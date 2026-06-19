package test.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import test.bean.ReProduct;
import test.function.DBManager;
import test.function.Before.SQLManager;
//	2026年6月9日
public class Re17 {

	public static void main(String[] args) {
		try(Connection con = DBManager.getConnection()) {
			ArrayList<ReProduct> al = new ArrayList<>();
			SQLManager.selectALRePro(con, al);
			SQLManager.deleteRePro(con, al);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
