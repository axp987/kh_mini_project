package main;
// 마이페이지, Insert 클래스 >> 등록 소스 주석 처리한부분
import javax.swing.*;
import javax.swing.text.MaskFormatter;

import jdbclass.DBConnection;
import jdbclass.Insert;
import jdbclass.Select;
import jdbclass.overlapCheck;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import login.*;
public class myPage extends JPanel {
	private JLabel EmailField;
	private JTextField birthField;
	private JTextField name_tf;
	private JPasswordField pwField;
	private JPasswordField pwField2;
	private JTextField phone_tf0;
	private JTextField phone_tf1;
	private JTextField phone_tf2;
	private JTextField adr_tf1;
	private JTextField adr_tf2;
	private JTextField textField;
	private JFormattedTextField birthDate_Input;

	Connection con = null;           
	PreparedStatement pstmt = null;  
	ResultSet rs = null;             
	String sql = null; 


	public myPage() {
		JFrame frame = new JFrame();
		JLabel hello = new JLabel("\" myPage. \"");
		hello.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 16));
		hello.setBounds(135, 45, 135, 30);
		add(hello);

		// 이메일 입력
		JLabel Email = new JLabel("* 이 메 일");
		Email.setFont(new Font("Serif", Font.BOLD, 13));
		Email.setBounds(92, 145, 40, 20);
		add(Email);

		EmailField = new JLabel();
		EmailField.setBounds(165, 143, 206, 25);
		EmailField.setFont(new Font("Serif", Font.BOLD, 13));
		add(EmailField);

		// 비밀번호 입력       
		JLabel pw = new JLabel("Now Password");
		pw.setFont(new Font("Serif", Font.BOLD, 13));
		pw.setBounds(95, 240, 206, 20);
		add(pw);

		//비밀번호 입력창 
		pwField = new JPasswordField(15);
		pwField.setBounds(92, 266, 206, 25);
		add(pwField);

		JLabel pw2 = new JLabel("New Passsword");
		pw2.setFont(new Font("Serif", Font.BOLD, 13));
		pw2.setBounds(92, 301, 120, 25);
		add(pw2);
		
		//비밀번호 확인창 
		pwField2 = new JPasswordField(15);
		pwField2.setBounds(92, 327, 206, 25);
		add(pwField2);

		JButton button0 = new JButton("패스워드 변경");
		button0.setBounds(90, 355, 120, 25);
		add(button0);
		button0.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				char []cpw =  pwField.getPassword();
				String pw = "";
				for(int i=0; i<cpw.length; i++) { //getPassword 값 가져오는 소스
					Character.toString(cpw[i]);
					 pw += (pw.equals("")) ? ""+cpw[i]+"" : ""+cpw[i]+"";
				}
				overlapCheck ch = new overlapCheck();
				boolean check = ch.changePassword(EmailField.getText(), pw);
				if(check == true) {
					passwordUpdate();
				}
				else {
					JOptionPane.showMessageDialog(null, "현재 패스워드가 다릅니다.");
				}
			}
		});
		
		//이름 섹션 
		JLabel name = new JLabel(" * 이        름");
		name.setFont(new Font("Serif", Font.BOLD, 13));
		name.setBounds(80, 85, 70, 20);
		add(name);

		// 이름 입력 
		name_tf = new JTextField();
		name_tf.setBounds(160, 85, 140, 25);
		add(name_tf);
		name_tf.setColumns(10);


		//생년월일 섹션 
		JLabel birthDate = new JLabel("* 생 년 월 일");
		birthDate.setFont(new Font("Serif", Font.BOLD, 13));
		birthDate.setBounds(80, 115, 75, 20);
		add(birthDate);

		birthField = new JTextField(10);
		birthField.setBounds(160, 115, 140, 25);
		add(birthField);
		birthField.setColumns(10);


		//연락처 섹션 
		JLabel phone = new JLabel("* 휴 대 전 화");
		phone.setFont(new Font("Serif", Font.BOLD, 13));
		phone.setBounds(80, 390, 75, 20);
		add(phone);


		phone_tf0 = new JTextField();
		phone_tf0.setBounds(153, 388, 52, 27);
		add(phone_tf0);

		// 연락처 중간자리 
		phone_tf1 = new JTextField();
		phone_tf1.setBounds(209, 389, 45, 25);
		add(phone_tf1);
		phone_tf1.setColumns(4);

		// 연락처 끝자리 
		phone_tf2 = new JTextField();
		phone_tf2.setBounds(253, 389, 45, 25);
		add(phone_tf2);
		phone_tf2.setColumns(10);


		// 주소 섹션 
		JLabel adr = new JLabel("주         소");
		adr.setFont(new Font("Serif", Font.BOLD, 12));
		adr.setBounds(95, 420, 55, 20);
		add(adr);


		//주소 1 입력 
		adr_tf1 = new JTextField();
		add(adr_tf1);

		try 
		{
			adr_tf1 = new JTextField("주소 1 입력");
			//adr_tf1.setForeground(new Color(192, 192, 192));


			adr_tf1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					adr_tf1.setText("");
				}
			});

			adr_tf1.setBounds(90, 440, 215, 25);
			add(adr_tf1);
			adr_tf1.setColumns(50);
		} catch (Exception e) {

			e.printStackTrace();
		}


		//주소 2 입력창 
		adr_tf2 = new JTextField();
		add(adr_tf2);

		try 
		{
			adr_tf2 = new JTextField("주소 2 입력");
			//adr_tf2.setForeground(new Color(192, 192, 192));

			adr_tf2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					adr_tf2.setText("");
				}
			});

			adr_tf2.setBounds(90, 470, 215, 25);
			add(adr_tf2);
			adr_tf2.setColumns(50);
		} catch (Exception e) {

			e.printStackTrace();
		}

		JButton button1 = new JButton("수정하기");
		button1.setForeground(Color.RED);
		button1.setBounds(92, 520, 85, 30);
		add(button1);
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});

		JButton button2 = new JButton("새로고침");
		button2.setForeground(new Color(218, 112, 214));
		button2.setBounds(176, 520, 85, 30);
		add(button2);
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rollback();
			}
		});

		//배경 이미지 
		JLabel   bgImage = new JLabel("");
		bgImage.setBounds(0, 0, 375, 639);
		add(bgImage);


		setBounds(100, 100, 375, 667);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("* 회원가입일");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 13));
		lblNewLabel.setBounds(140, 175, 150, 25);
		add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(90, 208, 210, 25);
		add(textField);
		textField.setColumns(30);
		
		JButton button3 = new JButton("탈퇴하기");
		button3.setBounds(140, 560, 85, 30);
		add(button3);

		rollback();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "정말로 삭제하시겠습니까?",
						"확인",JOptionPane.YES_NO_OPTION);

				if(result==JOptionPane.CLOSED_OPTION) {
					JOptionPane.showConfirmDialog(null, "창 닫기를 클릭하셨습니다");
				}else if(result == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, "취소 버튼을 클릭하셨습니다.");
				}else {     
					delete();
					setVisible(false);
					new loginPage();
				}
			}
		});
	}

	public void rollback() {
		con = DBConnection.getConnection();
		try {
			sql= "select EMA, NA, birthd, ph, addr1, addr2, C_TIME  FROM USERSTABLE WHERE EMA =?";
			pstmt=con.prepareStatement(sql);
			Select select = new Select(); 
			System.out.println(select.getEmailPass());
			pstmt.setString(1, select.getEmailPass());
			rs = pstmt.executeQuery();
			
			String ema = "", name = "", birthd = "", phone = "", add1 = "", add2 = "", time = "";
			while(rs.next()) {
				ema = rs.getString("EMA");
				name = rs.getString("NA");
				birthd = rs.getString("birthd");
				phone = rs.getString("ph");
				add1 = rs.getString("addr1");
				add2 = rs.getString("addr2");
				time = rs.getString("C_TIME");
			}
			name_tf.setText(name);
			EmailField.setText(ema);
			birthField.setText(birthd);
			phone_tf0.setText(phone.substring(0, 3));
			phone_tf1.setText(phone.substring(3, 7));
			phone_tf2.setText(phone.substring(7, phone.length()));
			adr_tf1.setText(add1);
			adr_tf2.setText(add2);
			textField.setText(time);
			pstmt.close(); rs.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	
	void update() {
		con = DBConnection.getConnection();
		try {
			sql="update USERSTABLE set NA=?, birthd=?, ph=?, addr1 = ?, addr2 = ? where ucode = ?";

			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name_tf.getText());
			pstmt.setString(2, birthField.getText());
			String phone = phone_tf0.getText() + phone_tf1.getText() + phone_tf2.getText();
			pstmt.setString(3, phone);
			pstmt.setString(4, adr_tf1.getText());
			pstmt.setString(5, adr_tf2.getText());
			Select select = new Select();
			pstmt.setLong(6, select.ucodeSelect());
			int res = pstmt.executeUpdate();


			if (res>0) {
				JOptionPane.showMessageDialog(null, "수정 완료");

			}else {
				JOptionPane.showMessageDialog(null, "수정 실패");
			}
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	void passwordUpdate() {
		con = DBConnection.getConnection();
		try {
			sql="update USERSTABLE SET PW=? where EMA = ?";
			pstmt=con.prepareStatement(sql);
			
			
			char []cpw1 =  pwField2.getPassword();
			String pw1 = "";
			for(int i=0; i<cpw1.length; i++) { //getPassword 값 가져오는 소스
				Character.toString(cpw1[i]);
				 pw1 += (pw1.equals("")) ? ""+cpw1[i]+"" : ""+cpw1[i]+"";
			}
			
			pstmt.setString(1, pw1);
			pstmt.setString(2, EmailField.getText());
			
			int res = pstmt.executeUpdate();
			if(res > 0) {
				JOptionPane.showMessageDialog(null, "패스워드 변경 완료");
			}
			else {
				JOptionPane.showMessageDialog(null, "패스워드 변경 실패");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	void delete() {
		con = DBConnection.getConnection();
		try {
			// 1. 데이터베이스로 전송할  SQL문 작성.
			sql = "delete from USERSTABLE where EMA = ?";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1,EmailField.getText());

			// 2. 데이터베이스로 SQL문 전송 및 SQL문 실행.
			int res = pstmt.executeUpdate();

			if(res>0) {
				JOptionPane.showMessageDialog(null, " 삭제 성공");
			}else {
				JOptionPane.showMessageDialog(null, " 삭제 실패");
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	} //xx
}//class

