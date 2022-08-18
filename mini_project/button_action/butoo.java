package button_action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class butoo {
	JButton1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int result=JOptionPane.showConfirmDialog(null, "정말로 수정하시겠습니까?",
					"확인",JOptionPane.YES_NO_OPTION);
			if(result==JOptionPane.CLOSED_OPTION) {
				JOptionPane.showConfirmDialog(null, "창 닫기를 클릭하셨습니다");
			}else if(result == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "취소 버튼을 클릭하셨습니다.");
			}else {
				connect();

				update();

			}



		}
	});

	//삭제

	JButton3.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int result = JOptionPane.showConfirmDialog(null, "정말로 삭제하시겠습니까?",
					"확인",JOptionPane.YES_NO_OPTION);

			if(result==JOptionPane.CLOSED_OPTION) {
				JOptionPane.showConfirmDialog(null, "창 닫기를 클릭하셨습니다");
			}else if(result == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "취소 버튼을 클릭하셨습니다.");
			}else {
				connect();      
				delete();


			}



		}
	});


}
Connection con = null;           
PreparedStatement pstmt = null;  
ResultSet rs = null;             
String sql = null;               

void connect() {
	String driver =
			"oracle.jdbc.driver.OracleDriver";

	String url = 
			"jdbc:oracle:thin:@localhost:1521:xe";

	String user = "web";

	String password = "1234";

	try {
		// 1단계 : 오라클 드라이버를 로딩
		// ==> 동적으로 로딩 : 프로그램을 실행 시에 오라클
		//                 드라이버를 로딩한다는 의미.
		Class.forName(driver);

		// 2단계 : 오라클 데이터베이스와 연결 시도
		con = DriverManager.getConnection(url, user, password);

	} catch (Exception e) {

		e.printStackTrace();
	}

}  // connection() 메서드 end

void select() {


	try {String sql="select * from USERSTABLE order by desc";

	pstmt=con.prepareStatement(sql);

	rs=pstmt.executeQuery();

	while(rs.next()) {


	}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();}
}







//회원수정
void update() {
	String p = null;
	try {
		sql = "select password from USERSTABLE  where usercode=?";
		pstmt=con.prepareStatement(sql);

		pstmt.setString(1 , "817111");

		rs=pstmt.executeQuery();
		if(rs.next()) {
			p = rs.getString("password");

			if(p==NowPassword.getText()) {
				sql= "update USERSTABLE set password=? where email=? ";


				pstmt.setString(1, NewPassword.getText());

				pstmt.setString(2, "ghi");
				if(NewPassword.equals(Retry)) {

				}
				int res=pstmt.executeUpdate();

				if(res>0) {
					JOptionPane.showMessageDialog(null, "회원 정보 수정 완료");
				}else {
					JOptionPane.showMessageDialog(null, "회원 정보 수정 실패");
				}
			}}}catch (SQLException e) {


				e.printStackTrace();
			}
}

//삭제 메서드
void delete() {

	try {
		// 1. 데이터베이스로 전송할  SQL문 작성.
		sql = "delete from USERSTABLE where email = ?";

		pstmt = con.prepareStatement(sql);

		pstmt.setString(1,Email.getText());

		// 2. 데이터베이스로 SQL문 전송 및 SQL문 실행.
		int res = pstmt.executeUpdate();

		if(res>0) {
			JOptionPane.showMessageDialog(null, " 삭제 성공!!!");
		}else {
			JOptionPane.showMessageDialog(null, " 삭제 실패~~~");
		}


	} catch (SQLException e) {

		e.printStackTrace();
	} 

}  // delete() 메서드 end
}
