import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements Runnable{
	
	static final int GAMEH = 555;
	static final int GAMEW = 1000;
	static final int BALLD = 40;
	static final Dimension SCREENS = new Dimension(GAMEW,GAMEH);
	static final int OBSTACLEH = 30;
	static final int OBSTACLEW = 30;
	static final int BALLX = 100;
	static final int BALLY = 400;
	static final int OBX = 800;
	static final int OBY = 410;
	Thread theThread;
	Image Image;
	Graphics graphics;
	Random random;
	Obstacles obstacle;
	Score score1;
	Jumper jumper;
	
	
	GamePanel(){
		newJumper();
		obstacle = new Obstacles(OBX,OBY,OBSTACLEH,OBSTACLEW);
		score1 = new Score(GAMEW,GAMEH);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREENS);
		theThread = new Thread(this);
		theThread.start();
	}
	
	public void draw(Graphics g) {
		jumper.draw(g);
		obstacle.draw(g);
		score1.draw(g);
	}
	public void CheckCollission() {
		Rectangle betweenrect1 = new Rectangle(obstacle.x,obstacle.y,obstacle.width,obstacle.height);
		Rectangle Betweenrect2 = new Rectangle(jumper.x,jumper.y,BALLD,BALLD);
		if(jumper.y <= 100) {
			jumper.y = 100;
			jumper.speed = 0;
		}
		if(betweenrect1.intersects(Betweenrect2)) {
			newJumper();
			obstacle = new Obstacles(OBX,OBY,OBSTACLEH,OBSTACLEW);
			score1.score=0;
			
		
			
		}
		if(obstacle.x < -30) {
			obstacle = new Obstacles(OBX,OBY,OBSTACLEH,OBSTACLEW);
			score1.score ++;
		}
	}
	public void paint(Graphics g) {
		Image = createImage(getWidth(),getHeight());
		graphics = Image.getGraphics();
		draw(graphics);
		g.drawImage(Image,0,0,this);
	}
	public void move() {
		jumper.move();
		obstacle.move();
		
	}
	public void newJumper() {
		jumper = new Jumper(BALLX,BALLY,BALLD);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
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
				CheckCollission();
				repaint();
				delta--;
				if(jumper.y < 400) {
					jumper.speed ++;
				}
				else if(jumper.y >= 400) {
					jumper.speed = 0;
					jumper.y = 400;
				}

				



				
			}
		}
	}
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			jumper.keyPressed(e);
		}
	
	}

}
