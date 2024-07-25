import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;


public class LoginSystem implements ActionListener{
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton signUpButton = new JButton("Sign up");
	JTextField userNameField = new JTextField();
	JPasswordField userPassField = new JPasswordField();
	JLabel userNameLabel = new JLabel("Username");
	JLabel userPassLabel = new JLabel("Password");
	JLabel appname = new JLabel("Chess game");
	JLabel message = new JLabel();
	String url = "jdbc:mysql://localhost:3306/chessloginsystem";
	String uName = "root";
	String uPass = "pass";
	
	ImageIcon chessBackround;
	JLabel image = new JLabel();
	
	LoginSystem(){
		
		chessBackround = new ImageIcon("/images/chessBackround.png");
		
		userNameLabel.setBounds(325,135,75,30);
		userPassLabel.setBounds(325,210,75,30);
		appname.setBounds(110,125,220,50);
		message.setBounds(390,270,220,50);
		
		image.setIcon(chessBackround);
		image.setBounds(0,0,320,240);
		
		userNameField.setBounds(325,165,270,30);
		userPassField.setBounds(325,240,270,30);
		
		loginButton.setBounds(350,325,90,40);
		loginButton.addActionListener(this);
		loginButton.setFocusable(false);
		signUpButton.setBounds(480,325,90,40);
		signUpButton.addActionListener(this);
		signUpButton.setFocusable(false);
		
		frame.add(appname);
		frame.add(userNameLabel);
		frame.add(userPassLabel);
				
		frame.add(userNameField);
		frame.add(userPassField);
		
		frame.add(loginButton);
		frame.add(signUpButton);		
		
		frame.add(message);
		
		frame.add(image);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(640,480);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void userFound() {
		message.setText("");
		System.out.println("found");
	}
	public void notFound() {
		message.setForeground(Color.RED);
		message.setFont(new Font("Arial", Font.BOLD, 14));
		message.setText("INCORRECT DETAILS");	
	}

	@Override
	public void actionPerformed(ActionEvent g) {
		// TODO Auto-generated method stub
		if(g.getSource()==signUpButton) {
		}
		if(g.getSource()==loginButton) {
			String userName = userNameField.getText();
			String userPass = String.valueOf(userPassField.getPassword());
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				String query = "SELECT * FROM userdetails WHERE UserName = ? AND UserPassword = ?";
				Connection connect = DriverManager.getConnection(url,uName,uPass);
				PreparedStatement preparedStatement = connect.prepareStatement(query);
				preparedStatement.setString(1, userName);
				preparedStatement.setString(2, userPass);
				ResultSet results = preparedStatement.executeQuery();
							
				if (results.next()) {
	                	userFound();
	                } else {
	                    notFound();
	            }
	        }
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		
		}
	}
	
}
