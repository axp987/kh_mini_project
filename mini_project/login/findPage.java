package login;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.UIManager;

import jdbclass.join_jdbc;

import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.SystemColor;

public class findPage extends JFrame {
	
	Connection con = null;			 // DB 연동 객체 
	PreparedStatement pstmt = null;  // SQL문 DB 전송 객체
	ResultSet rs = null;	 		 //SQL문 실행 결과 객체 
	String sql = null;				 // SQL 저장 문자열 변수
	
	String phone;
	int phoneNum;
	
	private JTextField input_findUser;
	private JTextField input_modiFy;
	private JTextField input_findPw;
	private JTextField input_modiFy2;
	public findPage() {
	
		
		//분실 페이지 안내 
			JLabel find = new JLabel(" \" Find My Account \"");
			find.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 21));
			find.setBounds(105, 60, 200, 35);
			getContentPane().add(find);
		
				
			//분실 페이지 안내 멘트 
				JLabel lblNewLabel_2 = new JLabel("아이디, 비밀번호를 잊으셨나요?");
				lblNewLabel_2.setForeground(new Color(128, 128, 128));
				lblNewLabel_2.setFont(new Font("Serif", Font.BOLD, 10));
				lblNewLabel_2.setBounds(130, 95, 150, 15);
				getContentPane().add(lblNewLabel_2);
				
				
		
		//계정 이메일 찾기 안내 
		JLabel find_userName = new JLabel("내 계정 찾기");
			find_userName.setFont(new Font("Serif", Font.BOLD, 13));
			find_userName.setBounds(105, 180, 80, 20);
			getContentPane().add(find_userName);
							
		// 분실 계정 입력창 
			input_findUser = new JTextField();
				getContentPane().add(input_findUser);	
				
				try 
				{
					JTextField input_findUser = new JTextField("휴대전화 번호를 입력하세요.");
					input_findUser.setForeground(new Color(192, 192, 192));
					
					
					input_findUser.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							input_findUser.setText("");
						}
					});
					
					input_findUser.setBounds(100, 200, 210, 25);
					getContentPane().add(input_findUser);
					input_findUser.setColumns(50);
					} catch (Exception e) {
				
					e.printStackTrace();
				}
				
				// 인증번호 입력창 
					input_modiFy = new JTextField();
					getContentPane().add(input_modiFy);


					try 
					{
						JTextField input_modiFy = new JTextField("인증번호를 입력하세요.");
						input_modiFy.setForeground(new Color(192, 192, 192));
						
						
						input_modiFy.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								input_modiFy.setText("");
							}
						});
						
						input_modiFy.setBounds(100, 230, 210, 25);
						getContentPane().add(input_modiFy);
						input_modiFy.setColumns(50);
						} catch (Exception e) {
					
						e.printStackTrace();
					}
					
					
					//전송 버튼 
						JButton bt_send = new JButton("인증하기");
						bt_send.setBackground(UIManager.getColor("RadioButton.select"));
								
						bt_send.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								join_jdbc a = new join_jdbc();
								a.phCheck();
								
								boolean check = a.phCheck();
								if(check == true) {
									JOptionPane.showMessageDialog(null, "인증이 완료되었습니다.");
								} else {
										JOptionPane.showMessageDialog(null, "인증실패.");
									}
								
							}
						});
						bt_send.setForeground(new Color(218, 112, 214));
						bt_send.setBounds(205, 260, 110, 30);
						getContentPane().add(bt_send);
						
				
						JButton bt_reSend = new JButton("전송하기");
						
						bt_reSend.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								
								join_jdbc b = new join_jdbc();
								b.phCheck();
								
								boolean check = b.phCheck();
								if(check == true) {
									JOptionPane.showMessageDialog(null, "인증번호가 전송되었습니다.");
								} else {
										JOptionPane.showMessageDialog(null, "존재하지 않는 계정입니다.");
									}
									
							}
						});
						bt_reSend.setForeground(new Color(65, 105, 225));
						bt_reSend.setBounds(95, 260, 110, 30);
						getContentPane().add(bt_reSend);
						
					
						
					
					
					//비번 찾기 창 
							JLabel find_userName_1 = new JLabel("내 비밀번호 찾기");
							find_userName_1.setFont(new Font("Serif", Font.BOLD, 13));
							find_userName_1.setBounds(105, 340, 100, 20);
							getContentPane().add(find_userName_1);
							
							JTextPane textPane_1 = new JTextPane();
							textPane_1.setBounds(0, 0, 1, 16);
							getContentPane().add(textPane_1);
						
					
					//비번 분실 
							input_findPw = new JTextField("가입한 Email을 입력하세요.");
							input_findPw.setForeground(Color.LIGHT_GRAY);
							getContentPane().add(input_findPw);
					
					// 이메일 입력창 
							try 
							{
								JTextField input_findPw = new JTextField("가입한 Email을 입력하세요.");
								input_findPw.setForeground(new Color(192, 192, 192));
								
								
								input_findPw.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										input_findPw.setText("");
									}
								});
								
								input_findPw.setBounds(100, 360, 210, 25);
								getContentPane().add(input_findPw);
								input_findPw.setColumns(50);
								} catch (Exception e) {
							
								e.printStackTrace();
							}
		
							// 인증번호입력창 
							input_modiFy2 = new JTextField("인증번호를 입력하세요.");
							input_modiFy2.setForeground(Color.LIGHT_GRAY);
							getContentPane().add(input_modiFy2);
					
										try 
										{
											JTextField input_modiFy2 = new JTextField("인증번호를 입력하세요.");
											input_modiFy2.setForeground(new Color(192, 192, 192));
											
											
											input_modiFy2.addMouseListener(new MouseAdapter() {
												@Override
												public void mouseClicked(MouseEvent e) {
													input_modiFy2.setText("");
												}
											});
											
											input_modiFy2.setBounds(100, 390, 210, 25);
											getContentPane().add(input_modiFy2);
											input_modiFy2.setColumns(50);
											} catch (Exception e) {
										
											e.printStackTrace();
										}
					
								
										JButton bt2_reSend = new JButton("전송하기");
										bt2_reSend.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												
												JOptionPane.showMessageDialog(null, "인증번호가 전송되었습니다." );
											}
										});
										
										
										bt2_reSend.setForeground(new Color(65, 105, 225));
										bt2_reSend.setBounds(95, 420, 110, 30);
										getContentPane().add(bt2_reSend);
									
										JButton bt2_Send = new JButton("인증하기");
										bt2_Send.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												
											
											}
											
										});
										bt2_Send.setForeground(new Color(218, 112, 214));
										bt2_Send.setBounds(205, 420, 110, 30);
										getContentPane().add(bt2_Send);

						
					
						//전송 실패 안내 메시지 
					JTextPane jp_Sorry = new JTextPane();
					jp_Sorry.setForeground(new Color(128, 128, 128));
					jp_Sorry.setFont(new Font("Serif", Font.PLAIN, 11));
					jp_Sorry.setBackground(SystemColor.window);
					jp_Sorry.setText("인증번호를 받지 못하셨나요? \n'전송하기' 버튼을 다시 누르고 기다려주세요.");
					jp_Sorry.setBounds(100, 480, 220, 30);
					getContentPane().add(jp_Sorry);
						
							JButton bt_reTurn = new JButton("돌아가기");
							bt_reTurn.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
									
									new loginPage();
								}
							});
							
							bt_reTurn.setBackground(UIManager.getColor("RadioButtonMenuItem.disabledBackground"));
							bt_reTurn.setIcon(null);
							bt_reTurn.setBounds(150, 550, 110, 30);
							getContentPane().add(bt_reTurn);
							
			
		// 배경 사진 
					JLabel bg_label = new JLabel("");
					bg_label.setIcon(new ImageIcon(findPage.class.getResource("/logo_Image/background_001.png")));
					bg_label.setBounds(0, 0, 375, 639);
					getContentPane().add(bg_label);
					
					
		
					
		setBounds(100, 100, 375, 667);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		
	}

		
}