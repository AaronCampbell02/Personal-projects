import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class GamePanel extends JPanel implements Runnable {
	
	static final int GAMEW = 1000;
	static final int GAMEH = 555;
	static final Dimension SCREENS = new Dimension(GAMEW,GAMEH);
	static final int BALLD = 20;
	static final int PADDLEW = 25;
	static final int PADDLEH = 100;
	Thread theThread;
	Image Image;
	Graphics graphics;
	Random random;
	Paddles paddle1; 
	Paddles paddle2; 
	score score;
	ball ball;
	
	
	GamePanel(){
		newPaddles();
		newBall();
		score = new score(GAMEW,GAMEH);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREENS);
		theThread = new Thread(this);
		theThread.start();
		
	}
	public void newBall() {
		random = new Random();
		ball = new ball(GAMEW/2-(BALLD/2),random.nextInt(GAMEH-BALLD), BALLD, BALLD);
	}
	public void newPaddles() {
		paddle1 = new Paddles(0,GAMEH/2-(PADDLEH/2),PADDLEW,PADDLEH,1);
		paddle2 = new Paddles(GAMEW-PADDLEW,GAMEH/2-(PADDLEH/2),PADDLEW,PADDLEH,2);
	}
	public void paint(Graphics g) {
		Image = createImage(getWidth(),getHeight());
		graphics = Image.getGraphics();
		draw(graphics);
		g.drawImage(Image,0,0,this);
	}
		
	public void draw(Graphics g) {
		paddle1.draw(g);
		paddle2.draw(g);
		ball.draw(g);
		score.draw(g);
		
	}
	public void move() {
		paddle1.move();
		paddle2.move();
		ball.move();
		
	}
	public void checkCollision() {
		// bounces ball if hitting paddles
		
		if(ball.intersects(paddle1)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity ++;
			if(ball.yVelocity > 0) {
				ball.yVelocity ++;
			}else {
				ball.yVelocity--;
			}
			ball.setXDirction(ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		if(ball.intersects(paddle2)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity ++;
			if(ball.yVelocity > 0) {
				ball.yVelocity ++;
			}else {
				ball.yVelocity--;
			}
			ball.setXDirction(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		if(ball.x <= 0) {
			score.player2 ++;
			newPaddles();
			newBall();
		}
		if(ball.x >= (GAMEW - BALLD)) {
			score.player1 ++;
			newPaddles();
			newBall();
		}
		
		//rebounds ball at edges
		
		if(ball.y<= 0) {
			ball.setYDirection(-ball.yVelocity);
		}
		if(ball.y>= GAMEH - BALLD) {
			ball.setYDirection(-ball.yVelocity);
		}
		// stops paddles at edges
		if(paddle1.y<= 0) {
			paddle1.y = 0;
		}
		if (paddle1.y >= GAMEH-PADDLEH) {
			paddle1.y = GAMEH-PADDLEH - 1;
		}
		if(paddle2.y<= 0) {
			paddle2.y = 0;
		}
		if (paddle2.y >= GAMEH-PADDLEH) {
			paddle2.y = GAMEH-PADDLEH - 1;
		}
	}
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now-lastTime)/ns;
			lastTime = now;
			if (delta >= 1) {
				move();
				checkCollision();
				repaint();
				delta--;



				
			}
		}
		
	}
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
		}
	
		public void keyReleased(KeyEvent e) {
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);
		}
	}
}
