package jdbclass;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import main.*;
import admin.admin_user;
public class Select extends boardPage {
	private Connection conn = null; // 연결
	private PreparedStatement pstmt = null; // 전송
	private ResultSet rs;
	private static String emailPass; // 로그인 완료했을때 회원의 이메일을 기록해둠
	private DefaultTableModel model;
	private JTable table;
	
	
	public Select() { }
	
	public Select(String emailPass) {
		this.emailPass = emailPass;
	}
	
	public void userList() {
		try {
			conn = DBConnection.getConnection();
			String sql = "SELECT u.UCODE, u.EMA, u.NA, u.BIRTHD, u.PH, u.ADDR1, u.ADDR2 from USERSTABLE u join USERLEVEL l on u.LCODE = l.LCODE WHERE l.LCODE = 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Long code = rs.getLong("UCODE");
				String ema = rs.getString("EMA");
				String name = rs.getString("NA");
				String b = rs.getString("BIRTHD");
				String phone = rs.getString("PH");
				String a1 = rs.getString("ADDR1");
				String a2 = rs.getString("ADDR2");
				
				Object []data = { code, ema, name, b, phone, a1, a2 };
				admin_user.model.addRow(data);
			}
			pstmt.close(); rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean loginSelect(String ema, String upw) { // 아이디 패스워드 확인 코드
		try {
			conn = DBConnection.getConnection();
			String sql = "Select EMA, PW from USERSTABLE WHERE EMA = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ema);
			rs = pstmt.executeQuery();
			String id = "", pw = "";
			while(rs.next()) {
				id = rs.getString("EMA");
				pw = rs.getString("PW");
			}
			System.out.println(id);
			System.out.println(pw);
			if(id.equals(ema) && pw.equals(upw)) {
				emailPass = ema;
				System.out.println("login email: " + emailPass);
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public long ucodeSelect() { // 유저코드 가져오기
		long code=0;
		
		try {
			conn = DBConnection.getConnection();
			String sql = "Select ucode from USERSTABLE WHERE EMA = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, emailPass);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				code = rs.getLong("ucode");
				return code;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return code;
	}
	
	public void selectGO() { // 공지사항 목록 출력
		try {
			conn = DBConnection.getConnection();
			String sql = "Select GO_SEQ.CURRVAL, EMA, TITLE, STORY, NOWTIME from GO";
			pstmt = conn.prepareStatement(sql);
			// 4단계: 데이터베이스에 SQL문 전송 및 SQL문 실행
			rs = pstmt.executeQuery();
			// 5단계: while 반복문을 이용하여 데이터를 가져와서 출력
			while(rs.next()) {
				int no = rs.getInt("GO_SEQ.CURRVAL");
				String ema = rs.getString("ema");
				String title = rs.getString("title");
				String story = rs.getString("story");
				String time = rs.getString("NOWTIME");
				
				Object []data = { no, ema, title, story, time };
			}
			pstmt.close(); rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String musicUrl(String value) {
		try {
			conn = DBConnection.getConnection();
			String sql = "Select url from MUSICTABLE_1 from where (SELECT NO FROM MUSICTABLE_1 WHERE TITLE = ? OR SINGER = ? OR ALBUM = ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value);
			pstmt.setString(2, value);
			pstmt.setString(3, value);
			rs = pstmt.executeQuery();
			String link = "";
			while(rs.next()) {
				link = rs.getString("url");
			}
			return link;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "전송 실패";
	}
	
	public boolean adminCheck() { // 관리자 유무
		try {
			conn = DBConnection.getConnection();
			String sql= "Select u.EMA from USERSTABLE u join USERLEVEL l on u.lcode = l.lcode WHERE l.lcode = 0";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			String code = "";
			while(rs.next()) {
				code = rs.getString("EMA");
				if(emailPass.equals(code)) {
					return true;
				}
			}
			pstmt.close(); rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	public String getEmailPass() {
		return emailPass;
	}
	public void setEmailPass(String emailPass) {
		this.emailPass = emailPass;
	}
	
	
}
