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
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 667);
		setLayout(null);

		JButton button1 = new JButton("회원 목록");
		button1.setBounds(23, 20, 85, 23);
		add(button1);
		button1.addActionListener(new ActionListener() {	
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
		textField_1.setBounds(158, 21, 116, 21);
		add(textField_1);
		textField_1.setColumns(10);


		//button2(검색) 생성 및 위치
		JButton button2 = new JButton("삭제");
		button2.setFont(new Font("Gulim", Font.PLAIN, 12));
		button2.setBounds(282, 20, 65, 23);
		add(button2);
		button2.addActionListener(new ActionListener() {	
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
		jScrollPane.setBounds(12, 76, 335, 410);
		add(jScrollPane);
	}

}
