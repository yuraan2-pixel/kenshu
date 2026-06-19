package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import function.Readdbtxt;

public class DBManager2 {
	//　定数宣言
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";     // ドライバクラス名
	private static final String URL= Readdbtxt.read("db.txt");       // 接続するDBのURL
	private static final String USER_NAME = "System";  // DB接続するためのユーザー名
	private static final String PASSWORD = "pass";   // DB接続するためのパスワード
	
	// 接続メソッドを定義
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		// JVMにJDBCドライバクラスを登録
		Class.forName(DRIVER);
		// DBに接続
		Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        System.out.println("DBへ接続成功！");
		//		オートコミットオフ
		conn.setAutoCommit(false);
		// 接続情報を返す
		return conn;
	}
	
	// 切断メソッドの定義
	public static void close(Connection connection) {
		// 接続情報が入っていたら、切断処理を実行
		if(connection != null) {
			try {
				connection.close();
                System.out.println("DBへの接続を切断");
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}