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
		Connection con = null;
		try {
			// JVMにJDBCドライバクラスを登録
			Class.forName(DRIVER);
			// DBに接続
			con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("DBへ接続成功！");
		} catch (ClassNotFoundException e) {
			System.out.println("指定された名前のクラスの定義が見つかりませんでした");
		} catch (SQLException e) {
			System.out.println("データベース・アクセス・エラー(etc.)が発生しました");
		}
		// 接続情報を返す
		return con;
	}
	
	// 切断メソッドの定義
	public static void close(Connection con) {
		// 接続情報が入っていたら、切断処理を実行
		if(con != null) {
			try {
				con.close();
//				System.out.println("DBへの接続を切断");
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void eMessage(Exception e) {
		System.out.println("起こったこと：" + e);
//		System.out.println("test送信");
//		System.out.println("000,error,000");
		
		System.out.println("文終了後スタックトレース表示");
	}
}
