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

import khie.DBConnection;

public class Insert {
	// 1. 오라클 데이터베이스와 연결하는 객체
	Connection con = null;
	// 2. SQL문을 데이터베이스에 전송하는 객체
	PreparedStatement pstmt = null;
	// 3. SQL문을 실행한 후에 결과값을 가지고 있는 객체
	ResultSet rs;

	public Insert() {
		LocalDate now = LocalDate.now();
		try {
			// 1단게 + 2단계
			con = DBConnection.getConnection();

			String sql = "insert into USERSTABLE values(?, ?, ?, ?, ?, ?, sysdate)";
			pstmt = con.prepareStatement(sql);
			
//			ucode NUMBER(10) PRIMARY KEY, -- 220816(math.random) 총 10자리
//		    lcode NUMBER(1) UNIQUE, -- 0(관리자), 1(일반)
//		    EMA VARCHAR2(100) NOT NULL, -- 이메일
//		    pw VARCHAR2(45) NOT NULL, --패스워드 
//		    NA VARCHAR(10), -- 이름
//		    birthd VARCHAR2(20) NOT NULL, -- 생년월일
//		    ph VARCHAR2(50) NOT NULL,
//		    addr VARCHAR2(100),
//		    c_TIME DATE, --회원등록일
		    int ucode = Integer.parseInt(ranCode());
		    
		    
			pstmt.setInt(1, ucode);
			pstmt.setString(2, lcode);
			pstmt.setString(3, EMA);
			pstmt.setInt(4, birthd);
			pstmt.setString(5, ph);
			pstmt.setString(6, addr);

			int res = pstmt.executeUpdate();
			if(res > 0) {
				System.out.println("반영 성공");
			}
			else
				System.out.println("반영 실패");

			DBConnection dc = new DBConnection();
			//dc.getConnection();

			pstmt.close(); con.close(); in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String ranCode() { // 유저 코드 출력
		Date date = new Date();
		Random rand = new Random();
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		String a = sdf1.format(date).substring(0, 4) + sdf1.format(date).substring(5, 7) + sdf1.format(date).substring(8, 10);
		
		String numStr = "";
		for(int i=0; i<4; i++) {
			String ran = Integer.toString(rand.nextInt(10));
			numStr += ran;
		}
		
		return a + numStr;
	}
	
	
}
