package mini_project_five;
// KH������
import javax.swing.*;
import java.awt.BorderLayout;
public class boardPage extends JFrame {
		public boardPage() {
	      mainPage();
	      
	   }
	   
	   void mainPage() {
		  JTabbedPane tab = new JTabbedPane();
	      JPanel container1 = new JPanel();
	      JPanel container2 = new JPanel();
	      
	      JButton button1 = new JButton("����������");
	      JButton button2 = new JButton("�Խ���");
	      JButton button3 = new JButton("����������");
	      
	      JPanel container4 = new JPanel();
	      JPanel container5 = new JPanel();
	      JPanel container6 = new JPanel();
	      
	      container1.setLayout(new BorderLayout(0,10));
	      
	      container1.add(button1, BorderLayout.NORTH);
	      container1.add(button2, BorderLayout.CENTER);
	      container1.add(button3, BorderLayout.SOUTH);
	      
	      tab.add("��������", container4);
	      tab.add("Q&A", container5);
	      tab.add("��û�� ��ī�̺�", container6);	      
	      
	      //container2.add(container1, BorderLayout.WEST);
	      container2.add(container1);
	      
	      add(container2, BorderLayout.WEST);
	      add(tab, BorderLayout.EAST);
	      
	      setBounds(50,50,500,300);
	      
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setVisible(true);
	      
	   }
	   
	   void boardPage(){
	      JTabbedPane tab = new JTabbedPane();
	      
	      JPanel container1 = new JPanel();
	      JPanel container2 = new JPanel();
	      JPanel container3 = new JPanel();
	      
	      tab.add("��������", container1);
	      tab.add("Q&A", container2);
	      tab.add("��û�� ��ī�̺�", container3);
	      
	      add(tab);
	      
	      setBounds(50,50,500,300);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setVisible(true);
	   }
}
