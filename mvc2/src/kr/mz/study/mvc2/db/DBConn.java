package kr.mz.study.mvc2.db;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConn {
	public static Connection getConnection () {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3307/test?useUnicode=true&characterEncoding=utf8&useSSL=false";
			String id = "root";
			String pw = "1234";
			
			conn = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
