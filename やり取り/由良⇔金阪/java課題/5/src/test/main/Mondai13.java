package test.main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;

import test.function.DBManager;
//	2026年5月27日
public class Mondai13 {
	public static void main(String[] args) throws IOException {
		Connection connection = null;
		Path path = Paths.get("connect.txt");
		
		try {
			// DB接続が成功したら、接続情報が返ってくる
			connection = DBManager.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// DB接続を切断するメソッドに、接続情報を渡す
			DBManager.close(connection);
		}
		try (BufferedWriter bw = Files.newBufferedWriter(path);) {
			bw.write(connection.toString());
		}
		
	}
}
