package main;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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

import javax.swing.JScrollPane;

public class mainPage extends JPanel {

	private JTextField textField_1;

	public mainPage() {
		JFrame frame = new JFrame();
		//button1(노래목록) 생성 및 위치
		JButton button1 = new JButton("노래 목록");
		button1.setBounds(23, 20, 85, 23);
		add(button1);

		//textField_1(검색창) 생성 및 위치
		textField_1 = new JTextField();
		textField_1.setBounds(158, 21, 116, 21);
		add(textField_1);
		textField_1.setColumns(10);

		//button2(검색) 생성 및 위치
		JButton button2 = new JButton("검색");
		button2.setFont(new Font("Gulim", Font.PLAIN, 12));
		button2.setBounds(282, 20, 65, 23);
		add(button2);

		//Jtable과 Jscrollpane 생성 및 위치
		String[] header = {"No." , "TITLE", "SINGER", "ALBUM"};

		DefaultTableModel model = new DefaultTableModel(header,0);

		JTable table = new JTable(model);

		JScrollPane jScrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane.setBounds(12, 76, 335, 410);
		add(jScrollPane);


		//button4,button3 페이지 넘기기 버튼 생성 및 위치
		JButton button4 = new JButton("▶");
		button4.setBounds(286, 496, 49, 23);
		add(button4);

		JButton button3 = new JButton("◀");
		button3.setBounds(235, 496, 49, 23);
		add(button3);


		//button5(신청하기)버튼 생성 및 위치
		JButton button5 = new JButton("신청하기");
		button5.setBounds(126, 550, 107, 23);
		add(button5);



		setBounds(100, 100, 375, 667);
		setLayout(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setVisible(true);
	}
}