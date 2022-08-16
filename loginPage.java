package mini_project_five;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
// KH최지혜
public class loginPage extends JFrame {
	private JTextField textField;
	
	public loginPage () {
		getContentPane().setLayout(null);
		
		JLabel WELCOME = new JLabel("WELCOME TO TAKE FIVE");
		WELCOME.setBounds(175, 6, 150, 16);
		getContentPane().add(WELCOME);
		
		ImageIcon cassette = new ImageIcon("images/cassette.jpeg");
		
		JLabel lblNewLabel = new JLabel("Email ID");
		lblNewLabel.setBounds(130, 160, 61, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(130, 190, 61, 16);
		getContentPane().add(lblNewLabel_1);
		
		JTextField emailid = new JTextField();
		emailid.setBounds(210, 155, 72, 26);
		getContentPane().add(textField);
		emailid.setColumns(10);
		
		JComboBox<String> domain;

		//컨테이너 생성 
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel();
		
		//컴포넌트 생성 
	
		
		// 계정입력 
		JLabel emailinfo = 
				new JLabel("Email");
		JTextField emailid =
				new JTextField(20);
		
		JLabel emailat =	
				new JLabel ("@");
		
		domain = new JComboBox<>();
		}
}
