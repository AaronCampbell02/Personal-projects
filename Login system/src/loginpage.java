import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class loginpage implements ActionListener {
	
	JFrame frame = new JFrame();
	JButton loginb = new JButton("Login");
	JButton resetb = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("UserID");
	JLabel passLabel = new JLabel("Password");
	JLabel messageLabel = new JLabel();
	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	loginpage(HashMap<String,String> logininfooriginal){
		
		logininfo = logininfooriginal;
		
		userIDLabel.setBounds(50,100,75,25);
		passLabel.setBounds(50,150,75,25);
		
		messageLabel.setBounds(125,250,250,35);
		messageLabel.setFont(new Font(null,Font.BOLD,25));
		
		userIDField.setBounds(125,100,200,25);
		userPasswordField.setBounds(125,150,200,25);
		
		loginb.setBounds(125,200,100,25);
		loginb.addActionListener(this);
		
		resetb.setBounds(225,200,100,25);
		resetb.addActionListener(this);
		
		
		frame.add(loginb);
		frame.add(resetb);
		frame.add(passLabel);
		frame.add(userIDLabel);
		frame.add(messageLabel);
		frame.add(userPasswordField);
		frame.add(userIDField);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==resetb) {
			userIDField.setText("");
			userPasswordField.setText("");
		}
		if(e.getSource()==loginb) {
			String userID = userIDField.getText();
			String pass = String.valueOf(userPasswordField.getPassword());
			
			if(logininfo.containsKey(userID)) {
				
				if(logininfo.get(userID).equals(pass)){
					messageLabel.setForeground(Color.green);
					messageLabel.setText("login successfull");
				}
			}
		}
	}
}
