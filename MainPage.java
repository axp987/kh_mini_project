package mini_project_five;
// KH�迹��
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
      
      //����,�Խ���,���������� �� ������ �����ϱ�.
      JTabbedPane tab = new JTabbedPane(JTabbedPane.LEFT);
      
      JPanel contianer1 = new JPanel(); // ��� - 1(�˻�â,������ �ø� �����̳�)
      JPanel contianer2 = new JPanel(); // ��� - 2(�뷡����� �� �ڷ� �ѱ�� ��ư�� �ø� �����̳�)
      JPanel contianer3 = new JPanel();  // �ϴ�(�뷡 ���, ��û�ϱ� ��ư�� �ø� �����̳� )
      JPanel contianer4 = new JPanel();  // �������� �ø� �����̳�
      JPanel contianer5 = new JPanel(); // �Խ������� �ø� �����̳�
      JPanel contianer6 = new JPanel(); // �������������� �ø� �����̳�
      
      
      
      
      //��� -1�� �ø� �˻�â ������Ʈ
      JTextField jTextField1 = new JTextField(10); // �˻�â
      JButton button1 = new JButton("�˻�"); //�˻���ư
      
      //�߾ӿ� ��ġ�� ������Ʈ(�뷡 ���)
      String[] header = {"�� ��" , "�� ��", "����", "�ٹ���"};
      
      DefaultTableModel model = new DefaultTableModel(header,0);
      
      JTable table = new JTable(model);
      JScrollPane jScrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      
      //��� -2�� �ø� �뷡��� �յ� ��ư
      JButton button2 = new JButton("��");
      JButton button3 = new JButton("��");
      
      //�ϴܿ� �ø� �뷡���, ��û�ϱ� ��ư
      JButton button4 = new JButton("�뷡���");
      JButton button5 = new JButton("��û�ϱ�");
      
      //��� - 1 �����̳ʿ� ������Ʈ �ø���.
      contianer1.add(jTextField1);   contianer1.add(button1);
      
      //���-2 �����̳ʿ� ������Ʈ �ø���.
      contianer2.add(button2);     contianer2.add(button3);
      
      //�ϴ� �����̳ʿ� ������Ʈ �ø���
      contianer3.add(button4);    contianer3.add(button5);
      
      //���ο� �����̳ʸ� �ϳ� ���� ������ �����̳ʵ��� �÷�����.
      JPanel group = new JPanel(new BorderLayout());
      
      group.add(jScrollPane, BorderLayout.NORTH);
      group.add(contianer2, BorderLayout.CENTER);
      group.add(contianer3, BorderLayout.SOUTH);
      
      //�����̳� �����ӿ� �ø���.
      add(contianer1,BorderLayout.NORTH);
      add(group,BorderLayout.CENTER);
      
      //�Ǽ���
      tab.add("����", contianer4);   //�� �����̳ʿ��� â�� ���� ���� �� ����,... �ϴ� ���� 
      tab.add("�Խ���", contianer5);
      tab.add("����������", contianer6); 
      
      
      //add(tab);   //�� �����̳ʿ��� â�� ���� ���� �� ����,... �ϴ� ���� �ٽ� Ȯ���غ���
      setBounds(500, 500, 600, 600);
      pack();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }

   public static void main(String[] args) {
      new MainPage();
   }

}