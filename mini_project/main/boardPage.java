package main;

import jdbclass.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.SystemColor;


public class boardPage extends JPanel {
	private JTable table;
	public boardPage() {
		JFrame frame = new JFrame();

		//메뉴 선택(메인페이지/게시판/마이페이지)
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel();

		JLabel label1 = new JLabel("이용 방법");
		 
		//게시판 → 탭(공지사항/Q&A/신청곡아카이브)
		JTabbedPane tab = new JTabbedPane();
		tab.setBounds(0, 0, 375, 667);

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
				
				//Jtable과 Jscrollpane 생성 및 위치/////////////////////////////////////////
				String[] header = {"NO","TITLE", "SINGER","DATE"};

				DefaultTableModel model = new DefaultTableModel(header,0);
				
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.PINK);
				panel_1.setBounds(10, 80, 330, 480);
				container2.add(panel_1);
				panel_1.setLayout(null);
				
				JTable table_1 = new JTable(model);
				
				JScrollPane jScrollPane = new JScrollPane(table_1, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				jScrollPane.setBounds(12, 10, 305, 460);
				panel_1.add(jScrollPane);
				////////////////////////////////////////////////////////////////////////////
				
				JLabel lblNewLabel_7 = new JLabel("");
				lblNewLabel_7.setIcon(new ImageIcon(boardPage.class.getResource("/logo_Image/playlist_icon.png")));
				lblNewLabel_7.setFont(new Font("serif", Font.PLAIN, 13));
				lblNewLabel_7.setBounds(20, 6, 140, 45);
				container2.add(lblNewLabel_7);
				
				JLabel lblNewLabel_8 = new JLabel("");
				lblNewLabel_8.setIcon(new ImageIcon(boardPage.class.getResource("/logo_Image/logo_001.png")));
				lblNewLabel_8.setBounds(163, -18, 207, 120);
				container2.add(lblNewLabel_8);
				
				JButton btnNewButton = new JButton("새로고침");
				btnNewButton.setFont(new Font("Serif", Font.BOLD, 13));
				btnNewButton.setBounds(52, 51, 80, 30);
				container2.add(btnNewButton);
				
				
				
				setLayout(null);
				
			
			
				add(tab);
				frame.setBounds(0,0,375,667);
				frame.setResizable(false);
			}
//DB연결
		Connection con = null;           
		PreparedStatement pstmt = null;  
		ResultSet rs = null;             
		String sql = null;  
		DefaultTableModel model;
	
	
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

	}  
		void insert() {
			
		}
	}// connection() 메서드 end