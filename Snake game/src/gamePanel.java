import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

import javax.swing.JPanel;

public class gamePanel extends JPanel implements ActionListener{

	static final int SCREENW = 600;
	static final int SCREENH = 600;
	static final int UNIT_SIZE = 25;
	static final int GAME_UNITS = (SCREENW*SCREENH/UNIT_SIZE);
	static final int DELAY = 75;
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];
	int bodyParts = 1;
	int applesEaten;
	int applex;
	int appley;
	char direction = 'R';
	boolean running = false;
	Timer timer;
	Random random;
	
	gamePanel(){
		random = new Random();
		this.setPreferredSize(new Dimension(SCREENW,SCREENH));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();
	}
	public void startGame() {
		newApple();
		running = true;
		timer = new Timer(DELAY,this);
		timer.start();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	public void draw(Graphics g) {		
		if(running) {
			for(int i = 0 ; i < SCREENH/UNIT_SIZE; i++) {
				g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREENH);
				g.drawLine(0, i*UNIT_SIZE, SCREENW, i*UNIT_SIZE);
			}
			g.setColor(Color.red);
			g.fillOval(applex, appley, UNIT_SIZE, UNIT_SIZE);
			for(int i = 0;i <bodyParts;i++) {
				if(i == 0) {
					g.setColor(Color.green);
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				
				}
				else if(i == bodyParts){
					g.setColor(Color.black);
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
				else {
					g.setColor(new Color(45,180,0));
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
			}
			g.setColor(Color.red);
			g.setFont(new Font("Ink Free",Font.BOLD,75));
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("Score:"+applesEaten, (SCREENW - metrics.stringWidth("Score:"+applesEaten))/2, g.getFont().getSize());
		}
		else {
			gameOver(g);
		}
	}
	public void newApple() {
		applex = random.nextInt((int)(SCREENW/UNIT_SIZE))*UNIT_SIZE;
		appley = random.nextInt((int)(SCREENH/UNIT_SIZE))*UNIT_SIZE;
		
		
	}
	public void move() {
		for(int i = bodyParts; i > 0;i--){
			x[i] = x[i-1];
			y[i] = y[i-1];
			
		}
		switch(direction) {
		case 'U':
			y[0] = y[0] - UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0] - UNIT_SIZE;
			break;
		case 'R':
			x[0] = x[0] + UNIT_SIZE;
			break;
			
		}
	}
	public void checkApple() {
		if((x[0]==applex)&&(y[0]==appley)) {
			bodyParts++;
			applesEaten++;
			newApple();
		}
	}
	public void checkCollisions() {
		for(int i = bodyParts; i > 0;i--) {
			if ((x[0] == x[i]) && (y[0]==y[i])) {
				running = false;
				 
			}
		}
		if(x[0]< 0) {
			running = false;
		}
		if(x[0]> SCREENW) {
			running = false;
		}
		if(y[0]< 0) {
			running = false;
		}
		if(y[0]> SCREENH) {
			running = false;
		}
		if(running == false) {
			timer.stop();
		}
	}
	public void gameOver(Graphics g) {
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free",Font.BOLD,75));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("GAME OVER", (SCREENW - metrics.stringWidth("GAME OVER"))/2, SCREENH/2);
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free",Font.BOLD,75));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("Score:"+applesEaten, (SCREENW - metrics1.stringWidth("Score:"+applesEaten))/2, g.getFont().getSize());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(running) {
			move();
			checkApple();
			checkCollisions();			
		}
		repaint();
	}
	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if(direction != 'R'){
					direction = 'L';
					
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(direction != 'L'){
					direction = 'R';
				}
				break;
			case KeyEvent.VK_UP:
				if(direction != 'D'){
					direction = 'U';
				}
				break;
			case KeyEvent.VK_DOWN:
				if(direction != 'U'){
					direction = 'D';
				}
				break;
			}
		}
		
	}
}
