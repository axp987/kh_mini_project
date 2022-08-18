package main;

import java.awt.BorderLayout;
import javax.swing.*;

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
		pane.addTab("홈", new mainPage());
		pane.addTab("게시판", new boardPage());  // 레이블에 이미지도 가능
		pane.addTab("마이페이지", new myPage());
		pane.setBounds(0, 0, 1000, 700);
		return pane;
	}

	void createFrame(String title){
		this.setTitle(title);
		this.setSize(375,667);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout( new BorderLayout() );
		this.setVisible(true);
	}// createFrame Constructor
}// MyFrame Class
