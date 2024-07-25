import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class ball extends Rectangle{
	Random random;
	int xVelocity;
	int yVelocity;
	int initalSpeed = 2;
	
	ball(int x , int y, int width, int height){
		super(x,y,width,height);
		random = new Random();
		int randomXDirection = random.nextInt(2);
		int randomYDirection = random.nextInt(2);
		if(randomXDirection == 0) {
			randomXDirection--;
		}
		setXDirction(randomXDirection * initalSpeed);
		if(randomYDirection == 0) {
			randomYDirection--;
		}
		setYDirection(randomYDirection* initalSpeed);
		
		
	}
	
	public void setXDirction(int randomXDirection) {
		xVelocity = randomXDirection;
		
	}
	public void setYDirection(int randomYDirection) {
		yVelocity = randomYDirection;
	}
	public void move() {
		x += xVelocity;
		y += yVelocity;
	}
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, height, height);
	}
}
