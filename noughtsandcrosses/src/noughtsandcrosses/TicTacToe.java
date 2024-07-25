package noughtsandcrosses;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
public class TicTacToe implements ActionListener{

	Random rand = new Random();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JLabel text = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1_turn;
	
	TicTacToe(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		text.setBackground(new Color(25,25,25));
		text.setForeground(new Color(25,255,0));
		text.setFont(new Font("Ink Free",Font.BOLD,75));
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setText("Noughts and crosses");
		text.setOpaque(true);
		
		panel.setLayout(new BorderLayout());
		panel.setBounds(0,0,800,100);
		
		buttonPanel.setLayout(new GridLayout(3,3));
		buttonPanel.setBackground(new Color(150,150,150));
		
		for(int i =0;i<9;i++) {
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.ITALIC,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}	
		
		
		panel.add(text);
		frame.add(panel,BorderLayout.NORTH);
		frame.add(buttonPanel);
		
		firstTurn();
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i =0; i<9;i++) {
			if(e.getSource()==buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						player1_turn=false;
						text.setText("O turn");
						check();
					}
				}else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						player1_turn=true;
						text.setText("X turn");
						check();
					}
				}
			}
			
		}
		
		
	}
	
	public void firstTurn() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rand.nextInt(2)==0) {
			player1_turn = true;
			text.setText("X turn");
		}else {
			player1_turn = false;
			text.setText("O turn");
		}
	}
	public void check() {
		if(
			(buttons[0].getText()=="X") && 
			(buttons[1].getText()=="X")&&
			(buttons[2].getText()=="X")
			) {
			xWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="X") && 
				(buttons[4].getText()=="X")&&
				(buttons[5].getText()=="X")
				) {
				xWins(4,5,6);
			}
		if(
				(buttons[6].getText()=="X") && 
				(buttons[7].getText()=="X")&&
				(buttons[8].getText()=="X")
				) {
				xWins(0,3,6);
			}
		if(
				(buttons[0].getText()=="X") && 
				(buttons[3].getText()=="X")&&
				(buttons[6].getText()=="X")
				) {
				xWins(0,3,6);
			}
		if(
				(buttons[1].getText()=="X") && 
				(buttons[4].getText()=="X")&&
				(buttons[7].getText()=="X")
				) {
				xWins(1,4,7);
			}
		if(
				(buttons[2].getText()=="X") && 
				(buttons[5].getText()=="X")&&
				(buttons[8].getText()=="X")
				) {
				xWins(2,5,8);
			}
		if(
				(buttons[0].getText()=="X") && 
				(buttons[1].getText()=="X")&&
				(buttons[2].getText()=="X")
				) {
				xWins(0,4,8);
			}
		if(
				(buttons[2].getText()=="X") && 
				(buttons[4].getText()=="X")&&
				(buttons[6].getText()=="X")
				) {
				xWins(2,4,6);
			}
		if(
				(buttons[0].getText()=="O") && 
				(buttons[1].getText()=="O")&&
				(buttons[2].getText()=="O")
				) {
				oWins(0,1,2);
		}
		if(
					(buttons[3].getText()=="O") && 
					(buttons[4].getText()=="O")&&
					(buttons[5].getText()=="O")
					) {
					oWins(4,5,6);
				}
		if(
					(buttons[6].getText()=="O") && 
					(buttons[7].getText()=="O")&&
					(buttons[8].getText()=="O")
					) {
					oWins(0,3,6);
				}
		if(
					(buttons[0].getText()=="O") && 
					(buttons[3].getText()=="O")&&
					(buttons[6].getText()=="O")
					) {
					oWins(0,3,6);
				}
		if(
					(buttons[1].getText()=="O") && 
					(buttons[4].getText()=="O")&&
					(buttons[7].getText()=="O")
					) {
					oWins(1,4,7);
				}
		if(
					(buttons[2].getText()=="O") && 
					(buttons[5].getText()=="O")&&
					(buttons[8].getText()=="O")
					) {
					oWins(2,5,8);
				}
		if(
					(buttons[0].getText()=="O") && 
					(buttons[1].getText()=="O")&&
					(buttons[2].getText()=="O")
					) {
					oWins(0,4,8);
				}
		if(
					(buttons[2].getText()=="O") && 
					(buttons[4].getText()=="O")&&
					(buttons[6].getText()=="O")
					) {
					oWins(2,4,6);
		}
		int counter = 0;
		for(int i = 0;i<9;i++) {
			if(buttons[i].getText()=="") {
				counter += 1;
			}
		}
		System.out.println(counter);
		if(counter==0) {
			draw();
		}
	}
	public void xWins(int a, int b, int c) {
		buttons[a].setBackground(Color.PINK);
		buttons[b].setBackground(Color.PINK);
		buttons[c].setBackground(Color.PINK);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
			
		}
		text.setText("X wins");
	}
	public void oWins(int a, int b, int c) { 
		buttons[a].setBackground(Color.PINK);
		buttons[b].setBackground(Color.PINK);
		buttons[c].setBackground(Color.PINK);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
			
		}
		text.setText("O wins");
	}
	public void draw() {
		for(int i = 0;i<9;i++) {
			buttons[i].setBackground(Color.BLACK);
		text.setText("draw");
		}
	}
}
