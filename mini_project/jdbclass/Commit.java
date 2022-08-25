package jdbclass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Commit {
	private Connection con = null; // 연결
	private PreparedStatement pstmt = null; // 전송
	private ResultSet rs;
	
	public Commit() {
		try {
			String sql = "commit";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			pstmt.close(); rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
