package	login;

import javax.swing.*;


import jdbclass.*;
import main.*;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class loginPage extends JFrame{
	private JTextField pw;
	private JTextField userName;
	private JPasswordField passwordField;

	public loginPage() {
		//로고 이미지 
		JLabel	logo = new JLabel("");
		logo.setIcon(new ImageIcon(loginPage.class.getResource("/logo_Image/logo_001.png")));
		logo.setBounds(115, 50, 200, 120);
		getContentPane().add(logo);

		//계정 입력 
		//이메일 입력 표시 
		JLabel	id = new JLabel("Email");

		// id 폰트 위치 설정 
		id.setFont(new Font("Serif", Font.BOLD, 14));
		id.setBounds(80, 185, 40, 20);
		getContentPane().add(id);

		//이메일 아이디 입력창 
		userName = new JTextField();
		userName.setBounds(130, 182, 190, 25);
		getContentPane().add(userName);
		userName.setColumns(20);

		//이메일 도메인 선택 
		//String[] email = {};

		//비밀번호 위치 표시  
		JLabel pw = new JLabel("Password");

		// 비밀번호 위치 저장 : 폰트, 위치 설정 
		pw.setFont(new Font("Serif", Font.BOLD, 14));
		pw.setBounds(70, 215, 60, 20);
		getContentPane().add(pw);

		//비밀번호 입력
		passwordField = new JPasswordField();
		passwordField.setBounds(130, 210, 190, 25);
		getContentPane().add(passwordField);

		// 아이디 저장 
		JRadioButton rememberMe = new JRadioButton("Remember me");

		// 아이디 저장: 폰트, 위치 설정 
		rememberMe.setFont(new Font("Serif", Font.PLAIN, 12));
		rememberMe.setBounds(140, 240, 100, 20);
		getContentPane().add(rememberMe);

		//엔터 버튼
		JButton jb1 = new JButton("Enter");

		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				char []cpw =  passwordField.getPassword();
				String pw = "";
				String ema = userName.getText();
				for(int i=0; i<cpw.length; i++) { //getPassword 값 가져오는 소스
					Character.toString(cpw[i]);
					 pw += (pw.equals("")) ? ""+cpw[i]+"" : ""+cpw[i]+"";
				}
				
				Select c = new Select();
				boolean check = c.loginSelect(ema, pw);
				
				if(userName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디 또는 패스워드를 입력해주세요.");
				}
				else if(check == true) {
					JOptionPane.showMessageDialog(null, "Welcome!");
					setVisible(false);
					totalPage total = new totalPage("Music box");
				}
				else {
					JOptionPane.showMessageDialog(null, "아이디 또는 패스워드가 틀렸습니다.");
					userName.setText("");
					passwordField.setText("");
				}
//				totalPage total = new totalPage("Music box");
//				setVisible(false);
			}
		});


		// 엔터 버튼 폰트 설정 
		jb1.setFont(new Font("Serif", Font.ITALIC, 20));

		// 엔터 버튼 위치 설정 
		jb1.setBounds(135, 275, 180, 40);
		getContentPane().add(jb1);

		//계정 찾기 메시지 
		JLabel find = new JLabel("Find My Account");

		//계정 찾기 클릭 
		find.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new findPage();
			}
		});
		// 계정 찾기 위치 
		find.setForeground(UIManager.getColor("Label.disabledForeground"));

		// 계정 찾기 폰트 설정 
		find.setFont(new Font("Serif", Font.PLAIN, 12));
		find.setBounds(180, 320, 90, 25);
		getContentPane().add(find);

		//회원 가입 메시지 
		JLabel join = new JLabel("I Wanna Join!");

		JLabel join2 = new JLabel("아직 회원이 아니신가요?");
		//회원 가입 클릭 
		join.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new join();
			}
		});

		//회원가입 위치 
		join.setForeground(UIManager.getColor("Label.disabledShadow"));

		// 회원가입 폰트 설정 
		join.setFont(new Font("Serif", Font.PLAIN, 12));
		join.setBounds(185, 520, 70, 15);
		getContentPane().add(join);

		join2.setForeground(UIManager.getColor("Label.disabledForeground"));
		join2.setFont(new Font("Arial", Font.PLAIN, 10));
		join2.setBounds(170, 500, 110, 15);
		getContentPane().add(join2);


		//배경 사진 
		JLabel backGround = new JLabel("");
		backGround.setIcon(new ImageIcon(loginPage.class.getResource("/logo_Image/main_001.png")));
		backGround.setBounds(0, 0, 375, 639);
		getContentPane().add(backGround);
		setBounds(100, 100, 375, 667);
		getContentPane().setLayout(null);


		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
