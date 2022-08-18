package login;

import jdbclass.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.*;
import java.awt.*;
import javax.swing.*;

public class join extends JFrame {
	private JTextField inputUserName;
	private JTextField name_tf;
	private JPasswordField pwField;
	private JPasswordField pwField2;
	private JTextField phone_tf1;
	private JTextField phone_tf2;
	private JTextField adr_tf1;
	private JTextField adr_tf2;

	public join() {
		//회원가입 안내 멘트 
		JLabel hello = new JLabel("\" Hello, Stranger. \"");
		hello.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 16));
		hello.setBounds(135, 45, 135, 30);
		getContentPane().add(hello);

		JLabel lblNewLabel_2 = new JLabel("가입 회원 정보를 입력하세요.");
		lblNewLabel_2.setFont(new Font("Serif", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(135, 75, 150, 15);
		getContentPane().add(lblNewLabel_2);
		
		// 아이디 입력
		JLabel	userName = new JLabel("Email");
		userName.setFont(new Font("Serif", Font.BOLD, 13));
		userName.setBounds(92, 133, 40, 20);
		getContentPane().add(userName);
	//////////////////
		
		inputUserName = new JTextField();
		inputUserName.setBounds(92, 157, 206, 25);
		getContentPane().add(inputUserName);
		inputUserName.setColumns(10);

		JButton userNameCheck = new JButton("중복확인");
		userNameCheck.setFont(new Font("Serif", Font.PLAIN, 7));
		userNameCheck.setBounds(295, 155, 55, 30);
		getContentPane().add(userNameCheck);
//		userNameCheck.addActionListener(new ActionListener() {	
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				join_jdbc same = new join_jdbc(userName.getText());
//				boolean test = same.sameTest();
//				if(test == true) {
//					JOptionPane.showMessageDialog(null, "중복된 이메일입니다.");
//				}
//				else {
//					JOptionPane.showMessageDialog(null, "사용 가능한 이메일입니다.");
//				}
//				
//			}
//		});



		// 비밀번호 입력 		
		JLabel pw = new JLabel("Password");
		pw.setFont(new Font("Serif", Font.BOLD, 13));
		pw.setBounds(92, 181, 55, 20);
		getContentPane().add(pw);

		//비밀번호 입력창 
		pwField = new JPasswordField(15);
		pwField.setBounds(92, 197, 206, 25);
		getContentPane().add(pwField);

		//비밀번호 확인창 
		pwField2 = new JPasswordField(15);
		pwField2.setBounds(92, 220, 206, 25);
		getContentPane().add(pwField2);

		JLabel pwCheck = new JLabel("8~15자 이내의 비밀번호 입력");
		pwCheck.setForeground(new Color(128, 128, 128));
		pwCheck.setFont(new Font("Serif", Font.PLAIN, 9));
		pwCheck.setBounds(178, 246, 120, 15);
		getContentPane().add(pwCheck);


		// 성별 선택 버튼 
		JRadioButton gender_m = new JRadioButton("남");
		gender_m.setFont(new Font("Serif", Font.PLAIN, 12));
		gender_m.setBounds(160, 280, 45, 25);
		getContentPane().add(gender_m);

		JRadioButton gender_f = new JRadioButton("여");
		gender_f.setFont(new Font("Serif", Font.PLAIN, 12));
		gender_f.setBounds(200, 280, 45, 25);
		getContentPane().add(gender_f);

		JRadioButton gender_n = new JRadioButton("해당없음");
		gender_n.setFont(new Font("Serif", Font.PLAIN, 12));
		gender_n.setBounds(241, 280, 80, 25);
		getContentPane().add(gender_n);

		ButtonGroup gender_group  = new ButtonGroup();
		gender_group.add(gender_m);
		gender_group.add(gender_f);
		gender_group.add(gender_n);


		//이름 섹션 
		JLabel name = new JLabel(" * 이        름");
		name.setFont(new Font("Serif", Font.BOLD, 13));
		name.setBounds(80, 315, 70, 20);
		getContentPane().add(name);

		// 이름 입력 
		name_tf = new JTextField();
		name_tf.setBounds(165, 311, 140, 25);
		getContentPane().add(name_tf);
		name_tf.setColumns(10);


		//생년월일 섹션 
		JLabel birthDate = new JLabel("* 생 년 월 일");
		birthDate.setFont(new Font("Serif", Font.BOLD, 13));
		birthDate.setBounds(80, 345, 75, 20);
		getContentPane().add(birthDate);

		System.out.println("5");
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

			birthDate_Input.setBounds(165, 340, 140, 25);
			getContentPane().add(birthDate_Input);
		} catch (ParseException e) {

			e.printStackTrace();
		}


		//연락처 섹션 

		JLabel phone = new JLabel("* 휴 대 전 화");
		phone.setFont(new Font("Serif", Font.BOLD, 13));
		phone.setBounds(80, 375, 75, 20);
		getContentPane().add(phone);

		//연락처 국번 (ex.010,011,070... ) 선택창 
		JComboBox phone_jcb = new JComboBox();
		phone_jcb.setBounds(160, 372, 52, 27);
		getContentPane().add(phone_jcb);

		// 연락처 중간자리 
		phone_tf1 = new JTextField();
		phone_tf1.setBounds(210, 370, 45, 25);
		getContentPane().add(phone_tf1);
		phone_tf1.setColumns(4);

		// 연락처 끝자리 
		phone_tf2 = new JTextField();
		phone_tf2.setBounds(259, 370, 45, 25);
		getContentPane().add(phone_tf2);
		phone_tf2.setColumns(10);


		// 주소 섹션 
		JLabel adr = new JLabel("주         소");
		adr.setFont(new Font("Serif", Font.BOLD, 12));
		adr.setBounds(95, 420, 55, 20);
		getContentPane().add(adr);


		//주소 1 입력 
		adr_tf1 = new JTextField();
		getContentPane().add(adr_tf1);

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
			getContentPane().add(adr_tf1);
			adr_tf1.setColumns(50);
		} catch (Exception e) {

			e.printStackTrace();
		}


		//주소 2 입력창 
		adr_tf2 = new JTextField();
		getContentPane().add(adr_tf2);

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
			getContentPane().add(adr_tf2);
			adr_tf2.setColumns(50);
		} catch (Exception e) {

			e.printStackTrace();
		}



		//가입 확인 / 취소 섹션 

		// 가입완료 섹션 
		JButton bt_submit = new JButton("반가워요");
		bt_submit.setForeground(new Color(218, 112, 214));
		bt_submit.setBounds(200, 520, 90, 30);
		getContentPane().add(bt_submit);

		bt_submit.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, " 회원가입을 환영합니다.");

			}
		});


		// 가입취소 섹션 
		JButton bt_cancel = new JButton("다음번에");
		bt_cancel.setForeground(new Color(192, 192, 192));
		bt_cancel.setBounds(115, 520, 90, 30);
		getContentPane().add(bt_cancel);

		bt_cancel.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {

				int result = 
						JOptionPane.showConfirmDialog(null, "정말 취소하시겠습니까?", "확인", 
								JOptionPane.YES_NO_OPTION);

				if (result == JOptionPane.YES_OPTION ) {
					JOptionPane.showConfirmDialog(null, "가입을 취소합니다.");
					dispose();
				}


			}
		});


		//배경 이미지 
		JLabel	bgImage = new JLabel("");
		bgImage.setIcon(new ImageIcon(join.class.getResource("/logo_Image/background_001.png")));
		bgImage.setBounds(0, 0, 375, 639);
		getContentPane().add(bgImage);

		setBounds(100, 100, 375, 667);
		getContentPane().setLayout(null);


		System.out.println("6");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
}
