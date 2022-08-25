package jdbclass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Delete {
	private Connection con = null; // 연결
	private PreparedStatement pstmt = null; // 전송
	private ResultSet rs;
	public void userDelete(long s) {
		con = DBConnection.getConnection();
		try {
			String sql = "delete from USERSTABLE WHERE ucode = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setLong(1, s);
			int res = pstmt.executeUpdate();
			if(res > 0) {
				JOptionPane.showMessageDialog(null, "삭제 완료했습니다.");
			}
			else {
				JOptionPane.showMessageDialog(null, "삭제 실패했습니다.");
			}
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
