package main;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class test_board extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public test_board() {

		JFrame frame = new JFrame();
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel();


		//게시판 → 탭(공지사항/Q&A/신청곡아카이브)
		JTabbedPane tab = new JTabbedPane();
		tab.setSize(375,667);

		tab.add("공지사항", container1);
		tab.add("Q&A", container2);
		container2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(boardPage.class.getResource("/logo_Image/background_001.png")));
		lblNewLabel_1.setBounds(0, 0, 370, 638);
		container2.add(lblNewLabel_1);
		tab.add("신청곡 아카이브", container3);
		container3.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("검색");
		btnNewButton_1.setBounds(282, 73, 57, 25);
		container3.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(75, 75, 195, 20);
		container3.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(boardPage.class.getResource("/logo_Image/background_001.png")));
		lblNewLabel_2.setBounds(0, 0, 370, 638);
		container3.add(lblNewLabel_2);
		container1.setLayout(null);
		
		JButton btnNewButton = new JButton("검색");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("공지사항");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("나눔고딕 Light", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(71, 50, 67, 25);
		container1.add(lblNewLabel_3);
		btnNewButton.setBounds(282, 73, 57, 25);
		container1.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(75, 75, 195, 20);
		container1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(boardPage.class.getResource("/main/background_001.png")));
		lblNewLabel.setBounds(0, 0, 370, 638);
		container1.add(lblNewLabel);
		
		JList list = new JList();
		list.setBounds(75, 125, 264, 440);
		container1.add(list);
		
		frame.setBounds(0,0,375,667);
		frame.setResizable(false);
		add(frame);
	}
}
