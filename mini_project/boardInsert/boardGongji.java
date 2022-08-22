package boardInsert;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;

import jdbclass.*;
public class boardGongji extends JFrame {

	private JPanel contentPane;
	private JTextField title;
	private JTextArea story;
	/*
	 * Create the frame.
	 */
	public boardGongji() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setVisible(true);
		
		JPanel panel1 = new JPanel();
		contentPane.add(panel1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("제 목");
		panel1.add(lblNewLabel);
		
		title = new JTextField();
		panel1.add(title);
		title.setColumns(20);
		
		JPanel panel2 = new JPanel();
		contentPane.add(panel2);
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
		
		story = new JTextArea();
		JScrollPane jsp = new JScrollPane(story, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel2.add(jsp);
		
		JPanel panel3 = new JPanel();
		contentPane.add(panel3, BorderLayout.SOUTH);
		
		JButton returnButton = new JButton("돌아가기");
		panel3.add(returnButton);
		returnButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		// 
		JButton inputButton = new JButton("등 록");
		panel3.add(inputButton);
		inputButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Insert(title.getText(), story.getText());
				setVisible(false);
			}
		});
		
	}

}
