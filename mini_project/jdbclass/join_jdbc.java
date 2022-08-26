package jdbclass;

import jdbclass.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class join_jdbc {
	private String name;
	private Connection conn = null; // 연결
	private PreparedStatement pstmt = null; // 전송
	private ResultSet rs;
	
	public join_jdbc() {
		
	}
	
	public join_jdbc(String name) {
		this.name = name;
	}
	
	public boolean sameTest() { // 아이디 중복 체크
		try {
			conn = DBConnection.getConnection();
			String sql = "SELECT count(*) cnt FROM USERSTABLE WHERE EMA = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            if(rs.next()) {
            	int cnt = rs.getInt("cnt");
                if(cnt > 0) {
                	return true; // 해당 데이터가 있을때 true반환
                }
            }
            pstmt.close(); rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false; // 해당 데이터가 없으면 false 반환
	}
	
	public boolean phCheck() { // 핸드폰 유무 확인
		try {
			conn = DBConnection.getConnection();
			String sql = "SELECT count(*) cnt FROM USERSTABLE WHERE PH = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            if(rs.next()) {
            	int cnt = rs.getInt("cnt");
                if(cnt > 0) {
                	return true;
                }
            }
            pstmt.close(); rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean ucodeCheck() {
		try {
			conn = DBConnection.getConnection();
			String sql = "SELECT count(*) cnt FROM USERSTABLE WHERE ucode = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            if(rs.next()) {
            	int cnt = rs.getInt("cnt");
                if(cnt > 0) {
                	return true;
                }
            }
            pstmt.close(); rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean passwordCheck() { // 해당 유저코드가 존재하는지 체크하는 고드
		try {
			conn = DBConnection.getConnection();
			String sql = "SELECT count(*) cnt FROM USERSTABLE WHERE ucode = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            if(rs.next()) {
            	int cnt = rs.getInt("cnt");
                if(cnt > 0) {
                	return true;
                }
            }
            pstmt.close(); rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean changePassword(String id, String pwd) { // 비밀번호 체크
		try {
			conn = DBConnection.getConnection();
			String sql = "Select PW from USERSTABLE WHERE EMA = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(pwd.equals(rs.getString("PW"))) {
					return true;
				}
			}
		}catch (Exception e) {
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
