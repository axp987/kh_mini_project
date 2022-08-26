package admin;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import jdbclass.Delete;
import jdbclass.Select;
import java.awt.Color;
import javax.swing.JLabel;

public class admin_user extends JPanel {
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;	
	public static DefaultTableModel model;
	private JTable table;
	/**
	 * Create the application.
	 */
	public admin_user() {
		
		//화면 패널 설정 
		setBackground(new Color(255, 204, 255));
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 667);
		setLayout(null);
		
		// Member list 이름표 파랑 
		JLabel jl_name01 = new JLabel("Member List");
		jl_name01.setForeground(Color.BLUE);
		jl_name01.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		jl_name01.setBounds(122, 20, 120, 40);
		add(jl_name01);
		
		// Member list 이름표 하양 
		JLabel jl_name02 = new JLabel("Member List");
		jl_name02.setForeground(Color.WHITE);
		jl_name02.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		jl_name02.setBounds(142, 20, 120, 40);
		add(jl_name02);

		
		JButton bt_list = new JButton("회원 목록");
		bt_list.setBounds(10, 65, 85, 23);
		add(bt_list);
		bt_list.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				//초기화작업
				model.setRowCount(0);
				Select se = new Select();
				se.userList();
				//table = new JTable(model);
			}
		});
		//textField_1(검색창) 생성 및 위치
		textField_1 = new JTextField();
		textField_1.setBounds(110, 65, 170, 20);
		add(textField_1);
		textField_1.setColumns(50);


		//button2(검색) 생성 및 위치
		JButton bt_delete = new JButton("삭제");
		bt_delete.setFont(new Font("serif", Font.PLAIN, 12));
		bt_delete.setBounds(290, 65, 55, 20);
		add(bt_delete);
		bt_delete.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				int r = table.getSelectedRow();
				Long code = (long)table.getValueAt(r, 0);
				
				new Delete().userDelete(code);
				model.setRowCount(0);
				Select se = new Select();
				se.userList();
			}
		});

	
		String[] header = {"유저코드" , "이메일", "이름", "생일", "연락처", "주소1", "주소2"};
		model = new DefaultTableModel(header,0);
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane jScrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane.setBounds(12, 100, 335, 400);
		add(jScrollPane);
		
	}

}