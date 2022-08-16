package mini_project_five;
// KH김예지
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class MainPage extends JFrame{
   
   public MainPage() {
      
      //메인,게시판,마이페이지 탭 좌측에 설정하기.
      JTabbedPane tab = new JTabbedPane(JTabbedPane.LEFT);
      
      JPanel contianer1 = new JPanel(); // 상단 - 1(검색창,메인을 올릴 컨테이너)
      JPanel contianer2 = new JPanel(); // 상단 - 2(노래목록을 앞 뒤로 넘기는 버튼을 올릴 컨테이너)
      JPanel contianer3 = new JPanel();  // 하단(노래 목록, 신청하기 버튼을 올릴 컨테이너 )
      JPanel contianer4 = new JPanel();  // 메인탭을 올릴 컨테이너
      JPanel contianer5 = new JPanel(); // 게시판탭을 올릴 컨테이너
      JPanel contianer6 = new JPanel(); // 마이페이지탭을 올릴 컨테이너
      
      
      
      
      //상단 -1에 올릴 검색창 컴포넌트
      JTextField jTextField1 = new JTextField(10); // 검색창
      JButton button1 = new JButton("검색"); //검색버튼
      
      //중앙에 위치한 컴포넌트(노래 목록)
      String[] header = {"순 위" , "제 목", "가수", "앨범명"};
      
      DefaultTableModel model = new DefaultTableModel(header,0);
      
      JTable table = new JTable(model);
      JScrollPane jScrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      
      //상단 -2에 올릴 노래목록 앞뒤 버튼
      JButton button2 = new JButton("◀");
      JButton button3 = new JButton("▶");
      
      //하단에 올릴 노래목록, 신청하기 버튼
      JButton button4 = new JButton("노래목록");
      JButton button5 = new JButton("신청하기");
      
      //상단 - 1 컨테이너에 컴포넌트 올리기.
      contianer1.add(jTextField1);   contianer1.add(button1);
      
      //상단-2 컨테이너에 컴포넌트 올리기.
      contianer2.add(button2);     contianer2.add(button3);
      
      //하단 컨테이너에 컴포넌트 올리기
      contianer3.add(button4);    contianer3.add(button5);
      
      //새로운 컨테이너를 하나 만들어서 기존의 컨테이너들을 올려주자.
      JPanel group = new JPanel(new BorderLayout());
      
      group.add(jScrollPane, BorderLayout.NORTH);
      group.add(contianer2, BorderLayout.CENTER);
      group.add(contianer3, BorderLayout.SOUTH);
      
      //컨테이너 프레임에 올리기.
      add(contianer1,BorderLayout.NORTH);
      add(group,BorderLayout.CENTER);
      
      //탭설정
      tab.add("메인", contianer4);   //빈 컨테이너여서 창이 없어 질수 도 있음,... 일단 보류 
      tab.add("게시판", contianer5);
      tab.add("마이페이지", contianer6); 
      
      
      //add(tab);   //빈 컨테이너여서 창이 없어 질수 도 있음,... 일단 보류 다시 확인해보기
      setBounds(500, 500, 600, 600);
      pack();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }

   public static void main(String[] args) {
      new MainPage();
   }

}