package jdbclass;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
	private static Connection con = null; // DB와 연결하는 객체
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@ADW_miniProject_medium?TNS_ADMIN=/Users/hihochan/Public/Wallet_KhADWDB";
	private static String user = "admin";
	private static String password = "Oraclepwd1!@";
	
	public DBConnection() {
		
	}
	
	public static Connection getConnection() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
}
