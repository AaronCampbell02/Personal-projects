import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class Paddles extends Rectangle{
	int id;
	int yVelocity;
	int speed = 10;
	
	Paddles(int x, int y, int PADDLEW, int PADDLEH, int id){
		super(x,y,PADDLEW,PADDLEH);
		this.id = id;
	}
	public void keyPressed(KeyEvent e) {
		switch(id) {
		case 1:
			if(e.getKeyCode()==KeyEvent.VK_W) {
				setYDircetion(-speed);
				move();
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				setYDircetion(speed);
				move();
			}
			break;
		case 2:
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				setYDircetion(-speed);
				move();
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				setYDircetion(speed);
				move();
			}
			break;
		}
	}
	public void keyReleased(KeyEvent e) {
		switch(id) {
		case 1:
			if(e.getKeyCode()==KeyEvent.VK_W) {
				setYDircetion(0);
				move();
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				setYDircetion(0);
				move();
			}
			break;
		case 2:
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				setYDircetion(0);
				move();
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				setYDircetion(0);
				move();
			}
			break;
		}
	}
	public void setYDircetion(int yDirection) {
		yVelocity = yDirection;
	}
	public void move() {
		y += yVelocity;
	}
	public void draw(Graphics g ) {
		if(id == 1) {
			g.setColor(Color.blue);
		
		}else {
			g.setColor(Color.red);
			
		}
		g.fillRect(x, y, width, height);
	}

}
