package jdbclass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import khie.DBConnection;

public class Select {
	private Connection conn = null; // 연결
	private PreparedStatement pstmt = null; // 전송
	private ResultSet rs; //
	public Select() {
		try {
			//conn = DBConnection.getConnection();
			
			String sql = "Select * from  ORDER BY bunho";
			pstmt = conn.prepareStatement(sql);
			// 4단계: 데이터베이스에 SQL문 전송 및 SQL문 실행
			rs = pstmt.executeQuery();
			// 5단계: while 반복문을 이용하여 데이터를 가져와서 출력
			while(rs.next()) {
				System.out.print(rs.getString("hakbun") + "\t");
				System.out.print(rs.getString("name") + "\t");
				System.out.print(rs.getString("major") + "\t");
				System.out.print(rs.getString("age") + "\t");
				System.out.print(rs.getString("phone") + "\t");
				System.out.print(rs.getString("addr") + "\t");
				System.out.println(rs.getString("regdate").substring(0, 10) + "\t");
				System.out.println("===========================================");
			}
			
			conn.close();
			pstmt.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
