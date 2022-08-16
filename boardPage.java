package mini_project_five;
// KH편지원
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
	      
	      JButton button1 = new JButton("메인페이지");
	      JButton button2 = new JButton("게시판");
	      JButton button3 = new JButton("마이페이지");
	      
	      JPanel container4 = new JPanel();
	      JPanel container5 = new JPanel();
	      JPanel container6 = new JPanel();
	      
	      container1.setLayout(new BorderLayout(0,10));
	      
	      container1.add(button1, BorderLayout.NORTH);
	      container1.add(button2, BorderLayout.CENTER);
	      container1.add(button3, BorderLayout.SOUTH);
	      
	      tab.add("공지사항", container4);
	      tab.add("Q&A", container5);
	      tab.add("신청곡 아카이브", container6);	      
	      
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
	      
	      tab.add("공지사항", container1);
	      tab.add("Q&A", container2);
	      tab.add("신청곡 아카이브", container3);
	      
	      add(tab);
	      
	      setBounds(50,50,500,300);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setVisible(true);
	   }
}
