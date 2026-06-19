package test.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;
import java.util.TreeSet;

import test.function.DBManager;
import test.function.SQLManager;
import test.function.UtilManeger;

public class Re14 {
//	2026年6月4日
	public static void main(String[] args) {
		try(Connection con = DBManager.getConnection()) {
			Set<String> set = new TreeSet<>();
			SQLManager.selectSRePro(con, set);
			UtilManeger.indication(set);
			
		} catch (ClassNotFoundException e) {
			DBManager.eMessage(e);
			e.printStackTrace();
		} catch (SQLException e) {
			DBManager.eMessage(e);
			e.printStackTrace();
		}
	}
}
