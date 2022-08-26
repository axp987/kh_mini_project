package main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import jdbclass.*;
import main.*;


public class orderPage extends JPanel {
	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt2 = null;
	ResultSet rs = null;
	
	
	private JFrame frame;
	private DefaultTableModel model;
	private JTable table;
	int no = 1; //중복
	String []name = { "PINK PINK", "BLUE BLUE", "PINA PINA", "하이볼", "모히또", "슬러시 잭콕",
		"치즈 피자", "페퍼로니 피자", "불고기 피자"};
	int []count = new int[9];
	int []total = new int[9]; // 한 메뉴당 총가격
	
//	Object[][]obj = {{no, "PINK PINK", count, 10000}, {no, "BLUE BLUE", count, 10000},
//							{no, "PINA PINA", count, 14000}, {no, "하이볼", count, 8000},
//							{no, "모히또", count, 12000}, {no, "슬러시 잭콕", count, 10000},
//							{no, "치즈 피자", count, 5000}, {no, "페퍼로니 피자", count, 5500},
//							{no, "불고기 피자", count, 6000}};
	public orderPage() {
		setBackground(new Color(255, 204, 255));
		frame = new JFrame();
		frame.setTitle("주문 ");
		setBounds(100, 100, 375, 667);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 255));
		setBounds(12, 10, 337, 600);
		//frame.getContentPane().add(panel);
		add(panel);
		setLayout(null);
		
		for(int i=0; i<count.length; i++) {
			count[i] = 0;
		}

		String []header = { "No", "주문음식", "가격", "갯수"};
		//		Object[][]obj = {{1, "PINK PINK", count, 10000}, {2, "BLUE BLUE", count, 10000},
		//				{3, "PINA PINA", count, 14000}, {4, "하이볼", count, 8000},
		//				{5, "모히또", count, 12000}, {6, "슬러시 잭콕", count, 10000},
		//				{7, "치즈 피자", count, 5000}, {8, "페퍼로니 피자", count, 5500},
		//				{9, "불고기 피자", count, 6000}};
		Object[][]obj = {{1, name[0], 10000, count[0]}, {2, name[1], 10000, count[1]},
								{3, name[2], 14000, count[2]}, {4, name[3], 8000, count[3]},
								{5, name[4], 12000, count[4]}, {6, name[5], 10000, count[5]},
								{7, name[6], 5000, count[6]}, {8, name[7], 5500, count[7]},
								{9, name[8], 6000, count[8]}};
		
		model = new DefaultTableModel(obj, header);
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane jScrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		table.setBounds(30, 450, 300, 230);
		jScrollPane.setBounds(30, 357, 300, 200);

		// pink pink 칵테일 이름표
		JLabel jl_drink01 = new JLabel("1. PINK  PINK");
		jl_drink01.setFont(new Font("Serif", Font.PLAIN, 13));
		jl_drink01.setForeground(new Color(0, 0, 255));
		jl_drink01.setBounds(20, 100, 80, 20);
		add(jl_drink01);

		JButton jButton = new JButton("");
		jButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
//				model = (DefaultTableModel) table.getModel();
//				
//				
//				count[0]++;
//				total[0] = 10000 * count[0];
//				Object []order = { no, "PINK PINK", count[0], total[0] };
//				model.addRow(order);
//
//				no++;
				
				model.setValueAt(count[0]++, 0, 3);
				total[0] = 10000 * count[0];
			}
		});

		jButton.setBounds(15, 15, 85, 85);
		jButton.setIcon(new ImageIcon(orderPage.class.getResource("/logo_Image/drink_01.png")));
		add(jButton); 
		// pink pink ends 


		// blue blue 칵테일 이름표
		JLabel jl_drink02 = new JLabel("2. BLUE  BLUE");
		jl_drink02.setForeground(Color.BLUE);
		jl_drink02.setFont(new Font("Serif", Font.PLAIN, 13));
		jl_drink02.setBounds(125, 100, 100, 20);
		add(jl_drink02);

		JButton jButton2 = new JButton("");
		jButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				model = (DefaultTableModel) table.getModel();
//				count[1]++;
//				total[1] = 10000 * count[1];
//				Object []order = { no, "BLUE BLUE", count[1], total[1] };
//				model.addRow(order);
//
//				no++;
				model.setValueAt(count[1]++, 1, 3);
				total[1] = 10000 * count[1];
			}
		});

		jButton2.setBounds(125, 15, 85, 85);
		jButton2.setIcon(new ImageIcon(orderPage.class.getResource("/logo_Image/drink_02.png")));
		add(jButton2);

		// pina pina 이름표 
		JLabel jl_drink03 = new JLabel("3. PINA PINA ");
		jl_drink03.setForeground(Color.BLUE);
		jl_drink03.setFont(new Font("Serif", Font.PLAIN, 13));
		jl_drink03.setBounds(235, 100, 80, 20);
		add(jl_drink03);

		JButton jButton3 = new JButton("");
		jButton3.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
//				model = (DefaultTableModel) table.getModel();
//				count[2]++;
//				total[2] = 14000 * count[2];
//				Object []order = { no, "PINA PINA", count[2], total[2] };
//				model.addRow(order);
//
//				no++;
				
				model.setValueAt(count[2]++, 2, 3);
				total[2] = 14000 * count[2];
			}
		});

		jButton3.setBounds(235, 15, 85, 85);
		jButton3.setIcon(new ImageIcon(orderPage.class.getResource("/logo_Image/drink_03.png")));
		add(jButton3);

		JLabel jl_highball01 = new JLabel("4. 하이볼");
		jl_highball01.setForeground(Color.BLUE);
		jl_highball01.setFont(new Font("Serif", Font.PLAIN, 13));
		jl_highball01.setBounds(30, 215, 70, 20);
		add(jl_highball01);

		JButton jButton4  = new JButton("");
		jButton4.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
//				model = (DefaultTableModel) table.getModel();
//				count[3]++;
//				total[3] = 8000 * count[3];
//				Object []order = { no, "하이볼", count[3], total[3] };
//				model.addRow(order);
//
//				no++;
				
				model.setValueAt(count[3]++, 3, 3);
				total[3] = 8000 * count[3];
			}
		});

		jButton4.setBounds(15, 130, 85, 85);
		jButton4.setIcon(new ImageIcon(orderPage.class.getResource("/logo_Image/highball_01.png")));
		add(jButton4);

		JLabel jl_highball02 = new JLabel("5. 모히또");
		jl_highball02.setForeground(Color.BLUE);
		jl_highball02.setFont(new Font("Serif", Font.PLAIN, 13));
		jl_highball02.setBounds(140, 215, 60, 20);
		add(jl_highball02);	 

		JButton jButton5 = new JButton("");
		jButton5.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
//				model = (DefaultTableModel) table.getModel();
//				count[4]++;
//				total[4] = 12000 * count[4];
//				Object []order = { no, "모히또", count[4], total[4] };
//				model.addRow(order);
//
//				no++;
				
				model.setValueAt(count[4]++, 4, 3);
				total[4] = 12000 * count[4];
			}
		});
		jButton5.setBounds(125, 130, 85, 85);
		jButton5.setIcon(new ImageIcon(orderPage.class.getResource("/logo_Image/highball_02.png")));
		add(jButton5);


		JLabel jl_highball03 = new JLabel("6. 슬러시 잭콕");
		jl_highball03.setForeground(Color.BLUE);
		jl_highball03.setFont(new Font("Serif", Font.PLAIN, 13));
		jl_highball03.setBounds(230, 215, 90, 20);
		add(jl_highball03);

		JButton jButton6 = new JButton("");
		jButton6.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
//				model = (DefaultTableModel) table.getModel();
//				count[5]++;
//				total[5] = 10000 * count[5];
//				Object []order = { no, "슬러시 잭콕", count[5], total[5] };
//				model.addRow(order);
//
//				no++;
				
				model.setValueAt(count[5]++, 5, 3);
				total[5] = 10000 * count[5];
			}
		});

		jButton6.setBounds(235, 130, 85, 85);
		jButton6.setIcon(new ImageIcon(orderPage.class.getResource("/logo_Image/highball_03.png")));
		add(jButton6);

		JLabel jl_pizza01 = new JLabel("7. 치즈  피자");
		jl_pizza01.setForeground(Color.BLUE);
		jl_pizza01.setFont(new Font("Serif", Font.PLAIN, 13));
		jl_pizza01.setBounds(25, 330, 80, 20);
		add(jl_pizza01);

		JButton jButton7 = new JButton("");
		jButton7.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
//				model = (DefaultTableModel) table.getModel();
//				count[6]++;
//				total[6] = 5000 * count[6];
//				Object []order = { no, "치즈 피자", count[6], total[6] };
//				model.addRow(order);
//
//				no++;

				model.setValueAt(count[6]++, 6, 3);
				total[6] = 5000 * count[6];
			}
		});
		jButton7.setBounds(15, 245, 85, 90);
		jButton7.setIcon(new ImageIcon(orderPage.class.getResource("/logo_Image/pizza_01.png")));
		add(jButton7);

		JLabel jl_pizza02 = new JLabel("8. 페퍼로니 피자");
		jl_pizza02.setForeground(Color.BLUE);
		jl_pizza02.setFont(new Font("Serif", Font.PLAIN, 13));
		jl_pizza02.setBounds(120, 330, 100, 20);
		add(jl_pizza02);

		JButton jButton8 = new JButton("");
		jButton8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				model = (DefaultTableModel) table.getModel();
//				count[7]++;
//				total[7] = 5500 * count[7];
//				Object []order = { no, "페퍼로니 피자", count[7], total[7] };
//				model.addRow(order);
//
//				no++;
				
				model.setValueAt(count[7]++, 7, 3);
				total[7] = 5500 * count[7];
			}
		});

		jButton8.setBounds(125, 245, 85, 90);
		jButton8.setIcon(new ImageIcon(orderPage.class.getResource("/logo_Image/pizza_02.png")));
		add(jButton8);


		JLabel jl_pizza03 = new JLabel("9. 불고기 피자");
		jl_pizza03.setForeground(Color.BLUE);
		jl_pizza03.setFont(new Font("Serif", Font.PLAIN, 13));
		jl_pizza03.setBounds(235, 330, 90, 20);
		add(jl_pizza03);

		JButton jButton9 = new JButton("");
		jButton9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				model = (DefaultTableModel) table.getModel();
//				count[8]++;
//				total[8] = 6000 * count[8];
//				Object []order = { no, "불고기 피자", count[8], total[8] };
//				model.addRow(order);
//
//				no++;	
				
				model.setValueAt(count[8]++, 8, 3);
				//obj[i][j]
				total[8] = 6000 * count[8];
			}
		});
		jButton9.setBounds(235, 245, 85, 90);
		jButton9.setIcon(new ImageIcon(orderPage.class.getResource("/logo_Image/pizza_03.png")));
		add(jButton9);

		JButton btnNewButton = new JButton("주문하기");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Serif", Font.BOLD, 14));
		btnNewButton.setBounds(70, 560, 200, 40);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int totalPrice = 0;
				String test ="";
				int oCount = 0;
				String []result = new String[9];
				ArrayList<Object> arr = new ArrayList<Object>();
				
				
				for(int i=0; i<count.length; i++) {
					if(count[i] > 0) {
						oCount++;
						totalPrice += total[i];
						
						test += "메뉴: " + name[i] + " 갯수: " + count[i] + " 가격: " + total[i] + "\n";
					}
				}
				arr.add(test);
				String sArr = arr.toString();
		        
				orderInsert(sArr);
				for(int i=0; i<9; i++) {
					model.setValueAt(0, i, 3);
				}
				for(int i=0; i<count.length; i++) {
					count[i] = 0;
				}
			}
		});
		
		JButton cancelButton = new JButton("취소하기");
		cancelButton.setForeground(Color.GRAY);
		cancelButton.setFont(new Font("Serif", Font.PLAIN, 10));
		cancelButton.setBounds(70, 535, 100, 25);
		add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				model.setValueAt(count[row]--, row, 3);
			}
		});
		
		JButton resetButton = new JButton("전체취소");
		resetButton.setForeground(Color.MAGENTA);
		resetButton.setFont(new Font("Serif", Font.PLAIN, 10));
		resetButton.setBounds(170, 535, 100, 25);
		add(resetButton);
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				model = (DefaultTableModel) table.getModel();
//				no = 1;
//				for(int i=0; i<9; i++) {
//					total[i] = 0;
//					count[i] = 0;
//				}
//				for(int i=0; i<9; i++) {
//					
//				}
				for(int i=0; i<9; i++) {
					model.setValueAt(0, i, 3);
				}
				for(int i=0; i<count.length; i++) {
					count[i] = 0;
				}
			}
		});

		jScrollPane.setBounds(30, 370, 280, 160);
		add(jScrollPane);
	} // orderPage
	
	
//	NO NUMBER(3) PRIMARY KEY,
//    FOOD VARCHAR2(30),
//    CO NUMBER(2),
//    NA VARCHAR2(45), 
//    C_TIME VARCHAR2(30),
//    EMA VARCHAR2(45)
	
//	CREATE TABLE ORDERTABLE (
//		    NO NUMBER(3) PRIMARY KEY,
//		    FOOD VARCHAR2(1000) NOT NULL,
//		    NA VARCHAR2(50),
//		    C_TIME VARCHAR2(3),
//		    EMA VARCHAR2(45)
//		    --CONSTRAINT OR_TOPICS FOREIGN KEY(EMA)
//		    --REFERENCES USERSTABLE(EMA)
//		);
	public void orderInsert(String sArr) {	
		try {
			con = DBConnection.getConnection();
			String name_sql = "Select NA FROM USERSTABLE WHERE ucode = ?";
			pstmt2 = con.prepareStatement(name_sql);
			Select se = new Select();
			long code = se.ucodeSelect();
			pstmt2.setLong(1, code);
			String uName = "";
			rs = pstmt2.executeQuery();
			while(rs.next()) {
				uName = rs.getString("NA");
			}
			pstmt2.close();
			
			String sql = "INSERT INTO ORDERTABLE VALUES (ORDERTABLE_SEQ.NEXTVAL, ?, ?, TO_CHAR(SYSDATE, 'YY\"년\"MM\"월\"DD\"일\" HH24\"시\"MI\"분\"'), ?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, sArr);
			myPage my = new myPage();
			pstmt.setString(2, uName);
			pstmt.setLong(3, code);
			
			int res = pstmt.executeUpdate();
			if(res > 0) {
				JOptionPane.showMessageDialog(null, "주문을 완료했습니다.");
			}
			else {
				JOptionPane.showMessageDialog(null, "직원에게 문의해주세요.");
			}
			pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}