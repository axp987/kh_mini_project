package main;

import jdbclass.*;
import javax.swing.*;


public class boardPage extends JPanel {
	public boardPage() {
		JFrame frame = new JFrame();

		//메뉴 선택(메인페이지/게시판/마이페이지)
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel();
		
		JButton button1 = new JButton("검색");
		JTextField textBox1 = new JTextField(20);


		//게시판 → 탭(공지사항/Q&A/신청곡아카이브)
		JTabbedPane tab = new JTabbedPane();

		tab.add("공지사항", container1);
		tab.add("Q&A", container2);
		tab.add("신청곡 아카이브", container3);
		
		container1.add(button1);
		container1.add(textBox1);
		
	
		add(tab);
		frame.setBounds(0,0,375,667);
		frame.setResizable(false);
	}

}