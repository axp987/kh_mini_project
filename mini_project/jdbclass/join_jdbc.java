package jdbclass;

import jdbclass.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class join_jdbc {
	private String name;
	private Connection con = null; // 연결
	private PreparedStatement pstmt = null; // 전송
	private ResultSet rs;
	
	public join_jdbc() {
		
	}
	
	public join_jdbc(String name) {
		this.name = name;
	}
	
	public boolean sameTest() {
		try {
			DBConnection DBConnection = new DBConnection();
			con = DBConnection.getConnection();
			String sql = "SELECT count(*) cnt FROM USERSTABLE WHERE EMA=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int cnt = rs.getInt("cnt");
                if (cnt > 0) {
                	return true;
                }
            }
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
