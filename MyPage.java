package mini_project_five;
// KH�赿��
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
	      
	      
	      // ����������
	      JLabel Title = new JLabel("���� ����������");
	      Title.setFont(new Font("���� ������ L", Font.PLAIN, 35));
	      Title.setBounds(394, 32, 358, 67);
	      frame.getContentPane().add(Title);
	      
	      //���1����(�̸� �̸��� ���̵� ����)
	      JPanel JPanel1 = new JPanel();
	      JPanel1.setBackground(new Color(255, 255, 255));
	      JPanel1.setBounds(41, 136, 440, 220);
	      frame.getContentPane().add(JPanel1);
	      JPanel1.setLayout(null);
	      
	      //�̸�
	      JLabel JLabel1 = new JLabel("        �̸� ");
	      JLabel1.setFont(new Font("����", Font.PLAIN, 16));
	      JLabel1.setBounds(20, 37, 86, 39);
	      JPanel1.add(JLabel1);
	      
	      Name = new JTextField(5);
	      Name.setBounds(123, 47, 72, 21);
	      JPanel1.add(Name);
	      Name.setColumns(4);
	      
	      
	      //�̸���
	      JLabel JLabel2 = new JLabel("       �̸���");
	      JLabel2.setFont(new Font("����", Font.PLAIN, 16));
	      JLabel2.setBounds(20, 94, 96, 19);
	      JPanel1.add(JLabel2);
	      
	      Email = new JTextField();
	      Email.setColumns(30);
	      Email.setBounds(123, 94, 240, 21);
	      JPanel1.add(Email);
	   
	      
	      //���̵�
	      JLabel JLabel3 = new JLabel("���̵�");
	      JLabel3.setFont(new Font("����", Font.PLAIN, 16));
	      JLabel3.setBounds(54, 142, 50, 15);
	      JPanel1.add(JLabel3);
	      
	      Id = new JTextField();
	      Id.setColumns(10);
	      Id.setBounds(123, 140, 135, 21);
	      JPanel1.add(Id);
	      
	      //�г���
	      JLabel JLabel4 = new JLabel("       ����");
	      JLabel4.setFont(new Font("����", Font.PLAIN, 16));
	      JLabel4.setBounds(20, 187, 96, 19);
	      JPanel1.add(JLabel4);
	      
	      
	      NickName = new JTextField();
	      NickName.setColumns(10);
	      NickName.setBounds(123, 187, 135, 21);
	      JPanel1.add(NickName);
	      // �г�1 ��
	      
	      
	      //���2 ����(�����й�ȣ,����й�ȣ,��й�ȣȮ��)
	      JPanel JPanel2 = new JPanel();
	      JPanel2.setLayout(null);
	      JPanel2.setBackground(Color.WHITE);
	      JPanel2.setBounds(41, 376, 440, 206);
	      frame.getContentPane().add(JPanel2);
	      
	      
	      //���� ��й�ȣ
	      JLabel JLabel5 = new JLabel("���� ��й�ȣ");
	      JLabel5.setFont(new Font("����", Font.PLAIN, 16));
	      JLabel5.setBounds(20, 32, 115, 19);
	      JPanel2.add(JLabel5);
	      
	      NowPassword = new JTextField();
	      NowPassword.setColumns(10);
	      NowPassword.setBounds(145, 30, 209, 21);
	      JPanel2.add(NowPassword);
	      
	      //����й�ȣ
	      JLabel JLabel6 = new JLabel("�� ��й�ȣ");
	      JLabel6.setFont(new Font("����", Font.PLAIN, 16));
	      JLabel6.setBounds(35, 76, 115, 19);
	      JPanel2.add(JLabel6);
	      NewPassword = new JTextField();
	      NewPassword.setColumns(10);
	      NewPassword.setBounds(145, 75, 209, 21);
	      JPanel2.add(NewPassword);
	      
	      JLabel JLabel7 = new JLabel("���Է�");
	      JLabel7.setFont(new Font("����", Font.PLAIN, 16));
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
