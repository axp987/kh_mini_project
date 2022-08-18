package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;


public class mainPage extends JPanel{

	public mainPage() {

		JFrame frame = new JFrame();

		JPanel container1 = new JPanel(); // 상단 - 1(검색창,메인을 올릴 컨테이너)
		//container1 위치
		container1.setLayout(null);
		container1.setLocation(12,10);
		container1.setSize(337, 61);

		JPanel container2 = new JPanel(); // 상단 - 2(노래목록을 앞 뒤로 넘기는 버튼을 올릴 컨테이너)
		container2.setLayout(null);
		container2.setLocation(12, 500);
		container2.setSize(337, 118);

		//상단 -1에 올릴 검색창 컴포넌트와 위치
		JButton button4 = new JButton("노래목록");
		button4.setLayout(null);
		button4.setLocation(12, 10);
		button4.setSize(97, 23);

		JTextField jTextField1 = new JTextField(10); // 검색창
		jTextField1.setLayout(null);              
		jTextField1.setLocation(148, 11);        
		jTextField1.setSize(116, 21);                                                      

		JButton button1 = new JButton("검색"); //검색버튼
		button1.setLayout(null);
		button1.setLocation(273, 10);
		button1.setSize(64, 23);

		//중앙에 위치한 컴포넌트(노래 목록)
		String[] header = {"No." , "TITLE", "SINGER", "ALBUM"};

		DefaultTableModel model = new DefaultTableModel(header,0);

		JTable table = new JTable(model);

		//table.setLayout(null);
		table.setLocation(32, 82);
		table.setSize(296, 379);

		JScrollPane jScrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		//jScrollPane.setLayout(null);
		jScrollPane.setLocation(12,97);
		jScrollPane.setSize(325, 385);
		
		//상단 -2에 올릴 노래목록 앞뒤 버튼과 위치
		JButton button2 = new JButton("◀");
		button2.setLayout(null);
		button2.setLocation(235, 488);
		button2.setSize(50, 23);


		JButton button3 = new JButton("▶");
		button3.setLayout(null);                  
		button3.setLocation(288, 488);
		button3.setSize(50, 23);


		JButton button5 = new JButton("신청하기");
		button5.setLayout(null);
		button5.setLocation(125, 535);
		button5.setSize(97, 23);

		//상단 - 1 컨테이너에 컴포넌트 올리기
		add(button4);      
		add(jTextField1);              
		add(button1);

		//상단-2 컨테이너에 컴포넌트 올리기.
		add(button5);
		add(button2);
		add(button3);

		//새로운 컨테이너를 하나 만들어서 기존의 컨테이너들을 올려주자.
		//JPanel group = new JPanel();

		//group.add(jScrollPane);
		//group.add(container2);

		//컨테이너 프레임에 올리기.
		//add(container1);
		add(jScrollPane);
		//add(container2);


		frame.setBounds(100, 100, 375, 667);

		//pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		//frame.setVisible(true);
	}

}
