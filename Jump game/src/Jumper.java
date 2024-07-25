import java.awt.*;
import java.awt.event.*;

public class Jumper extends Rectangle {
	static int speed = 0;
	int x;
	int y;
	int BALLD;
	
	Jumper(int x, int y, int BALLD){
		this.x = x;
		this.y = y;
		this.BALLD = BALLD;
	}
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			if(y == 400) {
				speed -= 20;
			}
		}
		
	}
	
	
	public void move() {
		y += speed;
	}
	
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, BALLD, BALLD);
	}

	
}
