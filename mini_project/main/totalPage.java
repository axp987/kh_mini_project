package main;

import java.awt.BorderLayout;

import javax.swing.*;
import admin.*;
import jdbclass.Select;
import jdbclass.join_jdbc;

public class totalPage extends JFrame {
	public totalPage()
	{
	}// MyFrame Constructor
	
	public totalPage(String title)
	{
		createFrame(title);
		JTabbedPane pane = createTabbedPane();  // 탭에서 메뉴바와 같은 기능
		this.add(pane, BorderLayout.CENTER); 
	}
	
	public JTabbedPane createTabbedPane()
	{
		JTabbedPane pane = new JTabbedPane(JTabbedPane.BOTTOM);
		
		pane.addTab("둘러보기", new boardPage());  // 레이블에 이미지도 가
		pane.addTab("신청하기", new mainPage());
		pane.addTab("주문하기", new orderPage());
		pane.addTab("내 정보", new myPage());
	
		boolean adminC = new Select().adminCheck();
		if(adminC == true) {
			pane.addTab("유저관리", new admin_user());
		}
		pane.setBounds(0, 0, 1000, 700);
		return pane;
	}
	
	void createFrame(String title){
		this.setTitle(title);
		this.setSize(375,667);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
	}// createFrame Constructor
}// MyFrame Class