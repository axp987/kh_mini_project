package main;

import jdbclass.*;
import boardInsert.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.ByteOrder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

//합칠때는 extends JPanel  수정
//frame.setBounds(0,0,375,667);
//frame.setResizable(false);
//으로 변경
//setVisible(true); 삭제
//main 메소드
public class boardPage extends JPanel {
	private DefaultTableModel model1;
	private DefaultTableModel model2;
	private DefaultTableModel model3;
	private JTable table1;
	private JTable table2;
	private JTable table3;
	private DefaultTableModel model;
	
	public boardPage() {
		JFrame frame = new JFrame();
		Container c = frame.getContentPane();

		//메뉴 선택(메인페이지/게시판/마이페이지)
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel();
		
		JPanel container4 = new JPanel();
		JPanel container5 = new JPanel();
		JPanel container6 = new JPanel();
		
		JButton button1 = new JButton("검색");
		JButton button2 = new JButton("검색");
		JButton button3 = new JButton("검색");
		
		JButton button4 = new JButton("작성"); // 공지
		JButton button5 = new JButton("작성"); // Q/A
		JButton button6 = new JButton("작성"); // 노래
		
		JTextField textBox1 = new JTextField(20);
		JTextField textBox2 = new JTextField(20);
		JTextField textBox3 = new JTextField(20);
		
		//게시판 → 탭(공지사항/Q&A/신청곡아카이브)
		JTabbedPane tab = new JTabbedPane();
//		while(rs.next()){            // 각각 값을 가져와서 테이블값들을 추가
//            model.addRow(new Object[]{rs.getString("id"),rs.getString("name"),
//                                      rs.getString("gender"),rs.getString("sutdascore"),
//                                      rs.getString("latest")});
//        }
		tab.add("공지사항", container4);
		String []header1 = { "No.", "제목", "작성자", "작성일"};
		model1 = new DefaultTableModel(header1, 0);
		table1 = new JTable(model1);
		JScrollPane jsp1 = new JScrollPane(table1, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp1.setPreferredSize(new Dimension(350, 470));
		container4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.setRowCount(0);
				Select select = new Select();
				select.selectGO();
			}
		});
		
		
		tab.add("Q&A", container5);
		String []header2 = { "No.", "제목", "작성자", "작성일"};
		model2 = new DefaultTableModel(header2, 0);
		table2 = new JTable(model2);
		JScrollPane jsp2 = new JScrollPane(table2, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp2.setPreferredSize(new Dimension(350, 470));
		button5.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		tab.add("신청곡 아카이브", container6);
		String []header3 = { "No.", "제목", "작성자", "작성일"};
		model3 = new DefaultTableModel(header3, 0);
		table3 = new JTable(model2);
		JScrollPane jsp3 = new JScrollPane(table3, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp3.setPreferredSize(new Dimension(350, 470));
		
		
		
		container1.add(button1);
		container1.add(textBox1);
		container1.add(button4);
		container4.add(container1, BorderLayout.NORTH);
		container4.add(jsp1, BorderLayout.SOUTH);
		
		container2.add(button2);
		container2.add(textBox2);
		container2.add(button5);
		container5.add(container2, BorderLayout.NORTH);
		container5.add(jsp2, BorderLayout.CENTER);
		
		
		container3.add(button3);
		container3.add(textBox3);
		container3.add(button6);
		container6.add(container3, BorderLayout.NORTH);
		container6.add(jsp3);
		
		
	
		add(tab);
		frame.setBounds(0,0,375,667);
		frame.setResizable(true);
//		setBounds(0,0,375,667);
//		setResizable(false);
//		setVisible(true);
		
		
	}
	
	
	public DefaultTableModel getModel1() {
		return model1;
	}

	public void setModel1(DefaultTableModel model1) {
		this.model1 = model1;
	}

	public DefaultTableModel getModel2() {
		return model2;
	}

	public void setModel2(DefaultTableModel model2) {
		this.model2 = model2;
	}

	public DefaultTableModel getModel3() {
		return model3;
	}

	public void setModel3(DefaultTableModel model3) {
		this.model3 = model3;
	}
}