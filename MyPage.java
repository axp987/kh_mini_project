package mini_project_five;
// KH김동근
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyPage {
	private JFrame frame;
	private JTextField Name;
	private JTextField Email;
	private JTextField Id;
	private JTextField NickName;
	private JTextField NowPassword;
	private JTextField NewPassword;
	private JTextField Retry;
	/**
	 * Launch the application.
	 */
	public MyPage() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		  frame = new JFrame();
	      frame.setBounds(100, 100, 1006, 699);
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.getContentPane().setLayout(null);
	      
	      
	      // 마이페이지
	      JLabel Title = new JLabel("님의 마이페이지");
	      Title.setFont(new Font("한컴 쿨재즈 L", Font.PLAIN, 35));
	      Title.setBounds(394, 32, 358, 67);
	      frame.getContentPane().add(Title);
	      
	      //페널1시작(이름 이메일 아이디 별명)
	      JPanel JPanel1 = new JPanel();
	      JPanel1.setBackground(new Color(255, 255, 255));
	      JPanel1.setBounds(41, 136, 440, 220);
	      frame.getContentPane().add(JPanel1);
	      JPanel1.setLayout(null);
	      
	      //이름
	      JLabel JLabel1 = new JLabel("        이름 ");
	      JLabel1.setFont(new Font("굴림", Font.PLAIN, 16));
	      JLabel1.setBounds(20, 37, 86, 39);
	      JPanel1.add(JLabel1);
	      
	      Name = new JTextField(5);
	      Name.setBounds(123, 47, 72, 21);
	      JPanel1.add(Name);
	      Name.setColumns(4);
	      
	      
	      //이메일
	      JLabel JLabel2 = new JLabel("       이메일");
	      JLabel2.setFont(new Font("굴림", Font.PLAIN, 16));
	      JLabel2.setBounds(20, 94, 96, 19);
	      JPanel1.add(JLabel2);
	      
	      Email = new JTextField();
	      Email.setColumns(30);
	      Email.setBounds(123, 94, 240, 21);
	      JPanel1.add(Email);
	   
	      
	      //아이디
	      JLabel JLabel3 = new JLabel("아이디");
	      JLabel3.setFont(new Font("굴림", Font.PLAIN, 16));
	      JLabel3.setBounds(54, 142, 50, 15);
	      JPanel1.add(JLabel3);
	      
	      Id = new JTextField();
	      Id.setColumns(10);
	      Id.setBounds(123, 140, 135, 21);
	      JPanel1.add(Id);
	      
	      //닉네임
	      JLabel JLabel4 = new JLabel("       별명");
	      JLabel4.setFont(new Font("굴림", Font.PLAIN, 16));
	      JLabel4.setBounds(20, 187, 96, 19);
	      JPanel1.add(JLabel4);
	      
	      
	      NickName = new JTextField();
	      NickName.setColumns(10);
	      NickName.setBounds(123, 187, 135, 21);
	      JPanel1.add(NickName);
	      // 패널1 끝
	      
	      
	      //페널2 시작(현재비밀번호,새비밀번호,비밀번호확인)
	      JPanel JPanel2 = new JPanel();
	      JPanel2.setLayout(null);
	      JPanel2.setBackground(Color.WHITE);
	      JPanel2.setBounds(41, 376, 440, 206);
	      frame.getContentPane().add(JPanel2);
	      
	      
	      //현재 비밀번호
	      JLabel JLabel5 = new JLabel("현재 비밀번호");
	      JLabel5.setFont(new Font("굴림", Font.PLAIN, 16));
	      JLabel5.setBounds(20, 32, 115, 19);
	      JPanel2.add(JLabel5);
	      
	      NowPassword = new JTextField();
	      NowPassword.setColumns(10);
	      NowPassword.setBounds(145, 30, 209, 21);
	      JPanel2.add(NowPassword);
	      
	      //새비밀번호
	      JLabel JLabel6 = new JLabel("새 비밀번호");
	      JLabel6.setFont(new Font("굴림", Font.PLAIN, 16));
	      JLabel6.setBounds(35, 76, 115, 19);
	      JPanel2.add(JLabel6);
	      NewPassword = new JTextField();
	      NewPassword.setColumns(10);
	      NewPassword.setBounds(145, 75, 209, 21);
	      JPanel2.add(NewPassword);
	      
	      JLabel JLabel7 = new JLabel("재입력");
	      JLabel7.setFont(new Font("굴림", Font.PLAIN, 16));
	      JLabel7.setBounds(70, 120, 115, 19);
	      JPanel2.add(JLabel7);
	      Retry = new JTextField();
	      Retry.setColumns(10);
	      Retry.setBounds(145, 115, 209, 21);
	      JPanel2.add(Retry);
	      
	      frame.add(JPanel1);
	      frame.add(JPanel2);
	      
	      frame.setVisible(true);
	      frame.setBounds(250, 250, 1000, 700);
	}
}
