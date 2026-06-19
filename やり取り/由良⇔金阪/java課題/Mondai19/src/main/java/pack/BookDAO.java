package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
//	確認1番目
//	完了！	SQLのメソッド纏め、先に全体読めばよかったわ！
public class BookDAO {
	private String URL = "jdbc:oracle:thin:@localhost:1521/kenshu";
	private String USER = "system";
	private String PASS = "pass";
	private String DRIVER = "oracle.jdbc.driver.OracleDriver";
//	上二つどういう？	代入して更新できるやつ？	privateやけど？	getset無いけど？
	Connection con = null;
	
	public BookDAO() {
		
	}
	
	public BookDAO(String s) {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection con() {
		return con;
	}

	/*
	 * いつもの
	 * DB接続
	 * */
	public void connect() {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Connectが入ってるだけのPreS(INSERT)
	 * 新規投稿機能
	 * */
	public void createFavoriteBook(String name, String favoriteBook, String detail) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASS);
//			Connectと同じ動作！	いやstaticしたらよくない？	わかりやすさ優先？
			
			pstmt = con.prepareStatement("insert into users(name, favorite_book, detail) values(?, ?, ?)");

			pstmt.setString(1, name);
			pstmt.setString(2, favoriteBook);
			pstmt.setString(3, detail);

			pstmt.executeUpdate();
//			いつもの
			
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
//				意地でも閉じようとしてて草	try_Catch の有用性が分かる
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * PreS(SELECT)	Connectどこで使うつもりなんやろ	
	 * DB情報(id, name)取得
	 * */
	public List<User> readUsers() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> bookList = new ArrayList<User>();
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASS);
			pstmt = con.prepareStatement("select id, name from users");

			rs = pstmt.executeQuery();
//			ここまでいつもの
			
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				bookList.add(user);
			}
//			おそらくstreamがなければこうするのがいいのであろう文
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
//				意地でもｒｙ
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bookList;
//		これ中身なしで返そうとしてねぇ？してるわ、まぁしゃぁなし
	}

	/*
	 * id読み取りwhere付きSELECT	上も情報一括で取れよ…	↓
	 * id name だけのと分ける意味が解らん	一括取得して情報入れとけばよくね？
	 * DB情報一件を指定して取得
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
	
	public User showBookDetail(int id, Connection con) {
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

	/**
	 * 投稿情報の更新(UPDATE)
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
	 * 投稿情報削除
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
