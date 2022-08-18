package main;

import javax.swing.*;
import javax.swing.text.MaskFormatter;


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

public class myPage extends JPanel {
	private JTextField EmailField;
	private JTextField name_tf;
	private JPasswordField pwField;
	private JPasswordField pwField2;
	private JTextField phone_tf1;
	private JTextField phone_tf2;
	private JTextField adr_tf1;
	private JTextField adr_tf2;
	private JTextField textField;

	public myPage() {
		System.out.println("1");
		//회원가입 안내 멘트 
		JFrame frame = new JFrame();
		JLabel hello = new JLabel("\" myPage. \"");
		hello.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 16));
		hello.setBounds(135, 45, 135, 30);
		add(hello);

		// 아이디 입력
		JLabel Email = new JLabel("Email");
		Email.setFont(new Font("Serif", Font.BOLD, 13));
		Email.setBounds(92, 145, 40, 20);
		add(Email);

		EmailField = new JTextField();
		EmailField.setBounds(92, 170, 206, 25);
		EmailField.setColumns(10);
		add(EmailField);

		// 비밀번호 입력       
		JLabel pw = new JLabel("Password");
		pw.setFont(new Font("Serif", Font.BOLD, 13));
		pw.setBounds(95, 240, 55, 20);
		add(pw);

		//비밀번호 입력창 
		pwField = new JPasswordField(15);
		pwField.setBounds(92, 266, 206, 25);
		add(pwField);

		//비밀번호 확인창 
		pwField2 = new JPasswordField(15);
		pwField2.setBounds(92, 327, 206, 25);
		add(pwField2);

		ButtonGroup gender_group  = new ButtonGroup();
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


		//생년월일 입력창 
		try 
		{
			MaskFormatter format = new MaskFormatter("####-##-##");

			final JFormattedTextField birthDate_Input = new JFormattedTextField("ex)19951011");
			birthDate_Input.setForeground(new Color(192, 192, 192));


			birthDate_Input.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					birthDate_Input.setText("");
				}
			});

			birthDate_Input.setBounds(160, 115, 140, 25);
			add(birthDate_Input);
		} catch (ParseException e) {

			e.printStackTrace();
		}


		//연락처 섹션 
		JLabel phone = new JLabel("* 휴 대 전 화");
		phone.setFont(new Font("Serif", Font.BOLD, 13));
		phone.setBounds(80, 390, 75, 20);
		add(phone);

		//연락처 국번 (ex.010,011,070... ) 선택창 
		JComboBox phone_jcb = new JComboBox();
		phone_jcb.setBounds(153, 388, 52, 27);
		add(phone_jcb);

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
			JTextField adr_tf1 = new JTextField("주소 1 입력");
			adr_tf1.setForeground(new Color(192, 192, 192));


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
			JTextField adr_tf2 = new JTextField("주소 2 입력");
			adr_tf2.setForeground(new Color(192, 192, 192));


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

		JButton button2 = new JButton("돌아가기");
		button2.setForeground(new Color(218, 112, 214));
		button2.setBounds(176, 520, 85, 30);
		add(button2);
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, " 회원가입을 환영합니다.");

			}
		});

		JButton button1 = new JButton("수정하기");
		button1.setForeground(Color.RED);
		button1.setBounds(92, 520, 85, 30);
		add(button1);

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int result = 
						JOptionPane.showConfirmDialog(null, "정말 수정하시겠습니까?", "확인", 
								JOptionPane.YES_NO_OPTION);

				if (result == JOptionPane.YES_OPTION ) {
					JOptionPane.showConfirmDialog(null, "처음페이지로 돌아갑니다.");
					frame.dispose();
				}


			}
		});


		//배경 이미지 
		JLabel   bgImage = new JLabel("");
		bgImage.setBounds(0, 0, 375, 639);
		add(bgImage);


		setBounds(100, 100, 375, 667);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("*I	D");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 13));
		lblNewLabel.setBounds(92, 205, 70, 25);
		add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(160, 208, 140, 25);
		add(textField);
		textField.setColumns(10);

		JLabel pw2 = new JLabel("NewPasssword");
		pw2.setFont(new Font("Serif", Font.BOLD, 13));
		pw2.setBounds(92, 301, 90, 15);
		add(pw2);

		JButton button3 = new JButton("탈퇴하기");
		button3.setBounds(140, 560, 85, 30);
		add(button3);

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

	void delete() {

		try {
			// 1. 데이터베이스로 전송할  SQL문 작성.
			sql = "delete from USERSTABLE where email = ?";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1,EmailField.getText());

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

	} //xx
}//class

