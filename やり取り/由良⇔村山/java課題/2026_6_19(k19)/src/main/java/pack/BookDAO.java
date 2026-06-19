package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	private String URL = "jdbc:oracle:thin:system/pass@//localhost:1521/kenshu";
	private String USER ="System";
	private String PASS =  "pass";
	Connection con = null;

	/*
	 * DBê⁄ë±
	 * */
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * êVãKìäçeã@î\
	 * */
	public void createFavoriteBook(String name, String favoriteBook, String detail) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PASS);
			pstmt = con.prepareStatement("insert into users(name, favorite_book, detail) values(?, ?, ?)");

			pstmt.setString(1, name);
			pstmt.setString(2, favoriteBook);
			pstmt.setString(3, detail);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * DBèÓïÒ(id, name)éÊìæ
	 * */
	public List<User> readUsers() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> bookList = new ArrayList<User>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PASS);
			pstmt = con.prepareStatement("select id, name from users");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				bookList.add(user);
			}
			return bookList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bookList;
	}

	/*
	 * DBèÓïÒàÍåèÇéwíËÇµÇƒéÊìæ
	 * */
	public User showUser(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = new User();
		try {
			pstmt = con.prepareStatement("select * from users where id = ?");
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setFavoriteBook(rs.getString("favorite_book"));
				user.setDetail(rs.getString("detail"));
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	/*
	 * ìäçeèÓïÒÇÃçXêV
	 * */
	public void updateUser(String name, String favoriteBook, String detail, int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("update users set name = ?, favorite_book = ?, detail = ? where id = ?");

			pstmt.setString(1, name);
			pstmt.setString(2, favoriteBook);
			pstmt.setString(3, detail);
			pstmt.setInt(4, id);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * ìäçeèÓïÒçÌèú
	 * */
	public void deleteUser(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("delete from users where id = ?");
			pstmt.setInt(1, id);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
