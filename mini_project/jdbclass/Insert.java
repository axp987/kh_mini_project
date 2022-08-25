package jdbclass;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import login.join;

public class Insert {
	// 1. 오라클 데이터베이스와 연결하는 객체
	Connection con = null;
	// 2. SQL문을 데이터베이스에 전송하는 객체
	PreparedStatement pstmt = null;
	// 3. SQL문을 실행한 후에 결과값을 가지고 있는 객체
	ResultSet rs;
	// 4. 시간값 가져오기
	LocalDate now = LocalDate.now();
	private String ema = "";
	public Insert() {
		
	}
	
	// 회원등록 소스
	public Insert(String E, String pwField, String n, String bir, String p1, String p2, String a1, String a2){
		try {
			// 1단게 + 2단계
			con = DBConnection.getConnection();

			String sql = "insert into USERSTABLE values(?, ?, ?, ?, ?, ?, ?, ?, ?,TO_CHAR(SYSDATE, 'YY\"년\"MM\"월\"DD\"일\" HH24\"시\"MI\"분\"'))";
			//String sql = "insert into USERSTABLE values(?, ?, ?, ?, ?, ?, ?, ?, ?, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'))";
			pstmt = con.prepareStatement(sql);
			
		    long ucode = Long.parseLong(ranCode());
		    int lcode = 1;
		    String EMA = E.toLowerCase();
		    String pw = pwField; // 특수문자 등등 구분 (미완성)
		    String name = n;
		    String birth = bir;
		    String phone1 = p1, phone2 = p2;
		    String phone = "010"+phone1 + phone2;
		    String addr1 = a1;
		    String addr2 = a2;
		    
			pstmt.setLong(1, ucode);
			pstmt.setInt(2, lcode);
			pstmt.setString(3, EMA);
			pstmt.setString(4, pw);
			pstmt.setString(5, name);
			pstmt.setString(6, birth);
			pstmt.setString(7, phone);
			pstmt.setString(8, addr1);
			pstmt.setString(9, addr2);
			int res = pstmt.executeUpdate();
			if(res > 0) {
				System.out.println("반영 성공");
			}
			else
				System.out.println("반영 실패");


			pstmt.close(); con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public Insert(String title, String story) { // 작성 버튼 클릭시 공지사항 제목과 내용 공지 테이블에 저장
//		try {
//			con = DBConnection.getConnection();
//			String usql = "select EMA FROM USERSTABLE WHERE ucode = ?";
//			pstmt = con.prepareStatement(usql);
//			Select uselect = new Select();
//			System.out.println("ucode: " + uselect.ucodeSelect());
//			pstmt.setLong(1, uselect.ucodeSelect());
//			
//			rs = pstmt.executeQuery(); 
//			while(rs.next()) {
//				ema = rs.getString("EMA");
//			}
//			pstmt.close(); rs.close();
//			// 시퀀스번호, 이메일, 제목, 내용, 등록일자, uselect.ucodeSelect())
//			String sql = "insert into GO VALUES (GO_SEQ.NEXTVAL, ?, ?, ?, TO_CHAR(SYSDATE, 'yy.mm.dd HH:MI:SS'), ?)";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, ema);
//			pstmt.setString(2, title);
//			pstmt.setString(3, story);
//			pstmt.setLong(4, uselect.ucodeSelect());
//			int res = pstmt.executeUpdate();
//			if(res > 0) {
//				System.out.println("공지사항 등록 완료");
//			}
//			else {
//				System.out.println("공지사항 등록 실패");
//			}
//			pstmt.close(); rs.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		//pstmt.setString(1, );
//		
//	}
	
	public String ranCode() { // 유저코드 만드는 소스
		Date date = new Date();
		Random rand = new Random();
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yy-MM-dd");
		String a = sdf1.format(date).substring(0, 2) + sdf1.format(date).substring(3, 5) + sdf1.format(date).substring(6, 8);
		String numStr = "";
		while(true) {
			for(int i=0; i<4; i++) {
				String ran = Integer.toString(rand.nextInt(10));
				numStr += ran;
			}
			overlapCheck join  = new overlapCheck(numStr);
			boolean check = join.ucodeCheck();
			if(check == true) {
				continue;
			}
			else if(check == false) {
				break;
			}
		}
		return a + numStr;
	}
}
