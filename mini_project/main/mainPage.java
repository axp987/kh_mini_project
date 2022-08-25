package main;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

import javax.swing.*;
import java.awt.*;
import jdbclass.*;

public class mainPage extends JPanel {

	private JTextField textField_1;
	int rowCount =20;
	int currentPage =0;
	int totalCount = 0;


	//DB연결
	Connection con = null;           
	PreparedStatement pstmt = null;  
	ResultSet rs = null;             
	String sql = null;  
	DefaultTableModel model;
	int rowsc;
	int row=0, col=0;
	String link;


	public mainPage() {
		JFrame frame = new JFrame();
		//button1(노래목록) 생성 및 위치
		JButton button1 = new JButton("노래 목록");
		button1.setBounds(23, 32, 85, 23);
		add(button1);

		//textField_1(검색창) 생성 및 위치
		textField_1 = new JTextField();
		textField_1.setBounds(158, 33, 116, 21);
		add(textField_1);
		textField_1.setColumns(10);


		//button2(검색) 생성 및 위치
		JButton button2 = new JButton("검색");
		button2.setFont(new Font("Gulim", Font.PLAIN, 12));
		button2.setBounds(282, 32, 65, 23);
		add(button2);

		//Jtable과 Jscrollpane 생성 및 위치
		String[] header = {"No." , "TITLE", "SINGER", "ALBUM"};

		model = new DefaultTableModel(header,0);

		JTable table = new JTable(model);

		//테이블 로우를 한개만 선택 할 수 있게 함.
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane jScrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane.setBounds(12, 100, 335, 345);
		add(jScrollPane);

		//각 행의 정보를 받기 위한 이벤트 처리
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// 테이블에서 선택한 셀의 row값을 int로 반환 				 
				row = table.getSelectedRow();
				System.out.println(table.getValueAt(row, 0));				
			}
		});


		//button4,button3 페이지 넘기기 버튼 생성 및 위치
		JButton button4 = new JButton("▶");
		button4.setBounds(286, 496, 49, 23);
		add(button4);

		JButton button3 = new JButton("◀");
		button3.setBounds(235, 496, 49, 23);
		add(button3);


		//button5(신청하기)버튼 생성 및 위치
		JButton button5 = new JButton("신청하기");
		button5.setBounds(126, 550, 107, 23);
		add(button5);



		setBounds(100, 100, 375, 667);
		setLayout(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setVisible(true);





		//button1(노래목록)클릭 시 이벤트 처리
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//DB연결메서드
				connect();

				//초기화처리
				currentPage = 0;
				// 전체 테이블 목록의 화면을 지워주는 메서드
				model.setRowCount(0);
				//DB에서 전체 내역을 조회하는 메서드 호출
				//				select();
				search("");

			}
		});

		//button2(검색) 클릭 시 이벤트 처리
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String searchText = "";
				searchText= textField_1.getText();
				currentPage = 0;

				//DB연결메서드
				connect();

				//초기화작업
				model.setRowCount(0);

				//검색결과를 보여주는 메서드
				search(searchText);


			}
		});

		//button3(◀) 앞으로 페이지 넘기기
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(currentPage > 0)currentPage --;	

				String searchText = "";
				searchText = textField_1.getText();


				//DB연결메서드
				connect();
				//초기화작업
				model.setRowCount(0);
				//search 메서드 호출
				search(searchText);

			}
		});

		//button4(▶) 뒤로 페이지 넘기기
		button4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				//maxRow는 총 카운트 수
				int maxRow = rowCount *(currentPage+1) ;
				// 데이터가 없는 경우 넘어가지 않게 조건 작성
				if(totalCount > maxRow) currentPage++;

				String searchText = "";
				searchText = textField_1.getText().toUpperCase();
				//DB연결메서드
				connect();
				//초기화작업
				model.setRowCount(0);
				//search 메서드 호출
				search(searchText);
			}
		});

		//신청하기 버튼 이벤트처리
		button5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//String urlLink = "https://www.youtube.com/embed/x8RIixqumUc";
				int result = JOptionPane.showConfirmDialog(null, "신청하시겠습니까?" , "확인" , JOptionPane.YES_NO_OPTION);


				//int noSelect = (int)table.getValueAt(row, 0);
				if(result == JOptionPane.CLOSED_OPTION){
					JOptionPane.showMessageDialog(null, " 창이 닫힙니다.");
				}else if(result == JOptionPane.NO_OPTION){
					JOptionPane.showMessageDialog(null, "취소를 클릭하셨습니다. ");
				}else {
					connect();
					int r = table.getSelectedRow();
					String title = table.getValueAt(row, 1).toString();
					String singer = table.getValueAt(row, 2).toString();
					Insert(title, singer);
				}

				//				url을 출력시켜주는 로직				
				//				String urlLink = musicUrl(noSelect); //신청곡 아카이브
				//				if(result == JOptionPane.CLOSED_OPTION){
				//					JOptionPane.showMessageDialog(null, " 창이 닫힙니다.");
				//				}else if(result == JOptionPane.NO_OPTION){
				//					JOptionPane.showMessageDialog(null, "취소를 클릭하셨습니다. ");
				//				
				//				}else{
				//					try {
				//				
				//					Desktop.getDesktop().browse(new URI(urlLink));
				//				} catch (IOException e1) {
				//					// TODO Auto-generated catch block
				//					e1.printStackTrace();
				//				} catch (URISyntaxException e1) {
				//					// TODO Auto-generated catch block
				//					e1.printStackTrace();
				//				}
				//				}
			}
		});
	}//public mainPage() end

	//url 출력 메소드 >> table click 이벤트 안에서 row = table.getSelectedRow(); value = table.getValueAt(row, 0)); musicUrl(value)
	public String musicUrl(int value) {
		try {
			System.out.println(value);
			con = DBConnection.getConnection();
			String sql = "Select url from MUSICTABLE_1 WHERE No = ?";


			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, value);

			rs = pstmt.executeQuery();
			link = "";
			while(rs.next()) {
				link = rs.getString("url");
			}
			pstmt.close(); rs.close();
			return link;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "전송 실패";
	}	

	void connect() {
		String driver =
				"oracle.jdbc.driver.OracleDriver";

		String url = 
				"jdbc:oracle:thin:@khadwdb_medium?TNS_ADMIN=/Users/hihochan/Public/Wallet_KhADWDB";

		String user =  "admin";

		String password = "Oraclepwd1!@";

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


	//	void select() {  
	//		
	//		
	//		try {
	//			//DB에 전송 할 SQL문 작성
	//			sql = "select * from MUSICTABLE_1 ";
	//			
	//			pstmt = con.prepareStatement(sql);
	//			
	//			//DB에 SQL문을 전송 및 SQL문 실행
	//			rs = pstmt.executeQuery();
	//			
	//			//레코드 수 만큼 반복하여 데이터를 추출
	//			while(rs.next()) {
	//				int NO = rs.getInt("NO");
	//				String TITLE = rs.getString("TITLE");
	//				String SINGER = rs.getString("SINGER");
	//				String ALBUM = rs.getString("ALBUM");
	//				
	//				Object[] data = {NO,TITLE,SINGER,ALBUM};
	//				
	//				// 저장한 한 개의 레코드(data)를 model에
	//				// 추가해 주면 됨.
	//				model.addRow(data);
	//				
	//			}
	//			
	//			//DB연결된 자원 종료
	//			rs.close(); pstmt.close();
	//			
	//		} catch (SQLException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		
	//		
	//		
	//	}//select() 메서드 end

	//search 메서드
	void search(String searchText) {


		try {
			//totalCount sql문 작성

			sql = "select count (*) as totalCount from MUSICTABLE_1  t  where TITLE like  '%'||?||'%'  or  SINGER like '%'||?||'%' or  ALBUM like '%'||?||'%' order by no";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, searchText.trim());
			pstmt.setString(2, searchText.trim());
			pstmt.setString(3, searchText.trim());

			rs = pstmt.executeQuery();	
			while(rs.next()) {
				totalCount  = rs.getInt("totalcount");
			}


			//검색관련 sql문 작성
			sql ="select * from (select rownum as num, t. * from MUSICTABLE_1  t  where UPPER(TITLE) like  '%'||UPPER(?)||'%'  or  UPPER(SINGER) like '%'||UPPER(?)||'%'"
					+ "order by no ) where num between ? and ?";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, searchText.trim());
			pstmt.setString(2, searchText.trim());
			pstmt.setInt(3,(currentPage *rowCount) +1 );
			pstmt.setInt(4,rowCount *(currentPage+1));



			rs = pstmt.executeQuery();

			while(rs.next()) {
				int NO = rs.getInt("NO");
				String TITLE =rs.getString("title");
				String SINGER =rs.getString("singer");
				String ALBUM =rs.getString("album");

				Object[] data = {NO,TITLE,SINGER,ALBUM};

				// 저장한 한 개의 레코드(data)를 model에
				// 추가해 주면 됨.
				model.addRow(data);


			}

			//객체종료
			rs.close(); pstmt.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}//search() 메서드 end


	// 해당 음악을 신청곡 아카이브 데이터베이스로 보냄
	//아카이브에서는 ORDER BY로 순서 바꿔도 될듯
	void Insert(String title, String singer) {
		try {
			String sql = "Insert into MUSICTABLE2 VALUES (MUSICTABLE2_SEQ.NEXTVAL, ?, ?, TO_CHAR(SYSDATE, 'YYYY\"년\"MM\"월\"DD\"일\" HH24\"시\"MI\"분\"'), ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, singer);

			int res = pstmt.executeUpdate();
			if(res > 0) {
				System.out.println("테이블 저장 성공");
			}
			else {
				System.out.println("테이블 이동 실패");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}






}//public class mainPage extends JPanel end