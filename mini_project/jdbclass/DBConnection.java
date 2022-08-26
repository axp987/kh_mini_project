package jdbclass;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
	private static Connection con = null; // DB와 연결하는 객체
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";

	private static String user = "system";
	private static String password = "oracle"; 
	
	public DBConnection() {
		
	}
	
	public static Connection getConnection() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("연결실패");
		return null;
	}
	
}
