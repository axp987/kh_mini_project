package main;

import jdbclass.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class boardPage extends JPanel {
	private JTable table;
	int rowCount =20;
	int currentPage =0;
	DefaultTableModel model1;
	DefaultTableModel model2;
	
	public boardPage() {
		JFrame frame = new JFrame();
		


		//메뉴 선택(메인페이지/게시판/마이페이지)
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel();

		JLabel label1 = new JLabel("이용 방법");
		 
		//게시판 → 탭(공지사항/Q&A/신청곡아카이브)
		JTabbedPane tab = new JTabbedPane();

		tab.add("공지사항", container1);
		container1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 255));
		panel.setBounds(0, 0, 355, 600);
		container1.add(panel);
		panel.setLayout(null);
		
		JLabel info_logo = new JLabel("");
		info_logo.setBackground(new Color(255, 153, 255));
		info_logo.setIcon(new ImageIcon(boardPage.class.getResource("/logo_Image/logo_001.png")));
		info_logo.setBounds(75, 5, 200, 120);
		panel.add(info_logo);
		
		JLabel info_01 = new JLabel("");
		info_01.setIcon(new ImageIcon(boardPage.class.getResource("/logo_Image/label_01.png")));
		info_01.setBounds(50, 98, 260, 80);
		panel.add(info_01);
		
		JLabel info_02 = new JLabel("");
		info_02.setIcon(new ImageIcon(boardPage.class.getResource("/logo_Image/label_02.png")));
		info_02.setBounds(50, 190, 260, 60);
		panel.add(info_02);
		
		
		JLabel info_03 = new JLabel("");
		info_03.setIcon(new ImageIcon(boardPage.class.getResource("/logo_Image/label_03.png")));
		info_03.setBounds(50, 260, 290, 60);
		panel.add(info_03);
		
		JLabel info_04 = new JLabel("");
		info_04.setIcon(new ImageIcon(boardPage.class.getResource("/logo_Image/label_04.png")));
		info_04.setBounds(50, 340, 290, 90);
		panel.add(info_04);
		
		
		JLabel info_05 = new JLabel("");
		info_05.setBounds(50, 440, 260, 90);
		info_05.setIcon(new ImageIcon(boardPage.class.getResource("/logo_Image/label_06.png")));
		panel.add(info_05);
		
		
		JLabel icon_01 = new JLabel("");
		icon_01.setBounds(260, 500, 50, 50);
		icon_01.setIcon(new ImageIcon(boardPage.class.getResource("/logo_Image/cursor_icon.png")));
		panel.add(icon_01);
		
		//tab.add("Q&A", container2);
		//tab.add("Q&A", container2);
				tab.add("신청곡 아카이브", container2);
				container2.setLayout(null);
				
				
				// 방명록 생성 
				tab.add("방명록", container3);
				container3.setLayout(null);
				
				String[] reviewheader = {"NO","EMAIL","NAME","DATE"};
				
				model2 = new DefaultTableModel(reviewheader,0);
				
				// 방명록 패널 생성 
				JPanel panel_1_1 = new JPanel();
				panel_1_1.setBounds(10, 80, 330, 480);
				panel_1_1.setLayout(null);
				panel_1_1.setBackground(Color.PINK);
				container3.add(panel_1_1);
				
				JTable table_2 = new JTable(model2);
				
				JScrollPane jScrollPane_1 = new JScrollPane(table_2, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				jScrollPane_1.setBounds(13, 199, 305, 271);
				panel_1_1.add(jScrollPane_1);
				
				//제목입력 textfield
				JTextField review_name =  new JTextField();
				review_name.setBounds(13, 10, 305, 30);
				panel_1_1.add(review_name);
				review_name.setColumns(30);
				
				
				//내용입력 textfield
				JTextField review_tf = new JTextField();
				review_tf.setColumns(50);
				review_tf.setBounds(13, 50, 305, 114);
				panel_1_1.add(review_tf);
				
				
				//등록(btnNewButton_1_1) 버튼
				JButton bt_reviewsubmit = new JButton("등록");
				bt_reviewsubmit.setFont(new Font("serif", Font.PLAIN, 10));
				bt_reviewsubmit.setBounds(196, 169, 55, 25);
				panel_1_1.add(bt_reviewsubmit);
				
				
						
						
				//조회(btnNewButton_1) 버튼
				JButton bt_reviewload = new JButton("조회");
				bt_reviewload.setFont(new Font("serif", Font.PLAIN, 10));
				bt_reviewload.setBounds(263, 169, 55, 25);
				panel_1_1.add(bt_reviewload);

				bt_reviewload.addActionListener(new ActionListener() {
					
					@Override

						public void actionPerformed(ActionEvent e) {
							//드라이버 로딩 및 데이터베이스 연결 메서드 호출
							connect();
							
							//전체 테이블 목록의 화면을 지워주는 메서드
							model2.setRowCount(0);
							
							//DB에서 전체 내역을 조회하는 메서드 호출
							select_review();						
					}
				});
				
				
				//Jtable과 Jscrollpane 생성 및 위치/////////////////////////////////////////
				String[] header = {"NO","TITLE", "SINGER","DATE"};

				model1 = new DefaultTableModel(header,0);
				setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
				
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(255, 153, 255));
				panel_1.setBounds(10, 70, 330, 480);
				container2.add(panel_1);
				panel_1.setLayout(null);
				
				JTable table_1 = new JTable(model1);
				
				JScrollPane jScrollPane = new JScrollPane(table_1, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				jScrollPane.setBounds(10, 10, 305, 460);
				panel_1.add(jScrollPane);
				////////////////////////////////////////////////////////////////////////////
				
				JLabel lblNewLabel_7 = new JLabel("");
				lblNewLabel_7.setIcon(new ImageIcon(boardPage.class.getResource("/logo_Image/select_icon.png")));
				lblNewLabel_7.setFont(new Font("serif", Font.PLAIN, 13));
				lblNewLabel_7.setBounds(105, 10, 140, 45);
				container2.add(lblNewLabel_7);
				
				JButton btnNewButton = new JButton("새로고침");
				btnNewButton.setFont(new Font("Serif", Font.BOLD, 13));
				btnNewButton.setBounds(135, 45, 80, 30);
				container2.add(btnNewButton);
				
				JLabel lblNewLabel_8 = new JLabel("");
				lblNewLabel_8.setIcon(new ImageIcon(boardPage.class.getResource("/logo_Image/noticelogo_001.png")));
				lblNewLabel_8.setBounds(75, -31, 200, 144);
				container2.add(lblNewLabel_8);
				
			
			
				add(tab);
				frame.setBounds(0,0,375,667);
				frame.setResizable(false);
			}
//DB연결
		Connection con = null;           
		PreparedStatement pstmt = null;  
		ResultSet rs = null;             
		String sql = null;  
	
	
		void connect() {
			String driver =
				"oracle.jdbc.driver.OracleDriver";

			String url = 
				"jdbc:oracle:thin:@localhost:1521:xe";

			String user = "system";

			String password = "oracle";

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

	}  
		
		
		//MUSICTABLE_2 테이블의 전체 목록을 조회하는 메서드
				void select() {
					
					try {
						//1.데이터베이스에 전송할 SQL문을 작성
						sql = "select * from MUSICTABLE_2";
						pstmt = con.prepareStatement(sql);
						
						//2.데이터베이스에 sql문을 전송 및 실행
						rs = pstmt.executeQuery();
						
						//3.레코드 수만큼 반복하여 데이터를 추출
						while(rs.next()) {
							int no = rs.getInt("NO");
							String title = rs.getString("TITLE");
							String singer = rs.getString("SINGER");
							String rqtime = rs.getString("rqtime");
							
							Object[] data = {no, title, singer, rqtime};
							
							//저장한 한 개의 레코드(data)를 model에 추가해주면 됨
							model1.addRow(data);
						}
						
						//4.데이터베이스에 연결된 자원 종료
						rs.close(); pstmt.close(); 
						con.close();
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				} //select() 메서드 end
				
				
				//REVIEW 테이블의 전체 목록을 조회하는 메서드
				void select_review() {
					
					try {
						//1.데이터베이스에 전송할 SQL문을 작성
						sql = "select * from review";
						pstmt = con.prepareStatement(sql);
						
						//2.데이터베이스에 sql문을 전송 및 실행
						rs = pstmt.executeQuery();
						
						//3.레코드 수만큼 반복하여 데이터를 추출
						while(rs.next()) {
							int no = rs.getInt("NO");
							String ema = rs.getString("ema");
							String na = rs.getString("na");
							String regdate = rs.getString("regdate");
							
							Object[] data = {no, ema, na, regdate};
							
							//저장한 한 개의 레코드(data)를 model에 추가해주면 됨
							model2.addRow(data);
						}
						
						//4.데이터베이스에 연결된 자원 종료
						rs.close(); pstmt.close(); 
						con.close();
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				} //select_review() 메서드 end
				
	}// connection() 메서드 end