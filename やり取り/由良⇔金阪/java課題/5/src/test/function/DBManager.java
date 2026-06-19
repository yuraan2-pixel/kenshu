package test.function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//	2026年5月27日
//	コピペして最初の定数達以外弄ってない、けどどこをいじる必要があるのか足す必要があるのかわからんかった
public class DBManager {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";     // ドライバクラス名_2⃣
	private static final String URL = "jdbc:oracle:thin:@localhost:1521/kenshu";        // 接続するDBのURL
//	private static final String URL = "jdbc:oracle:thin:system/pass@//localhost:1521/kintai";        // 接続するDBのURL
	private static final String USER_NAME = "system";  // DB接続するためのユーザー名
	private static final String PASSWORD = "pass";   // DB接続するためのパスワード
	
	// 接続メソッドを定義
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		// JVMにJDBCドライバクラスを登録_3⃣
		Class.forName(DRIVER);
		// DBに接続_4⃣
		Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		System.out.println("DBへ接続成功！");
		// 接続情報を返す
		return conn;
	}
	
	// 切断メソッドの定義
	public static void close(Connection connection) {
		// 接続情報が入っていたら、切断処理を実行
		if(connection != null) {
			try {
				connection.close();
//				System.out.println("DBへの接続を切断");
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
