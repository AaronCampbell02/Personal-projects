import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Obstacles extends Rectangle{
	Random random;
	static int OBSTACLEW;
	static int OBSTACLEH;
	Boolean Obstaclethere = false;
	int xVelocity;
	int speed = 10;
	int val;
	
	Obstacles(int x , int y, int width, int height){
		super(x,y,width,height);
		random = new Random();
		val = height * random.nextInt(1,4);
		this.height = val;
		if(this.height == 60) {
			val = -30;
		}else if(this.height == 90) {
			val = -60;
		}else if(this.height == 30) {
			val = 0;
		}
		val = y+val;
		this.y = val;
	
		
		
	}
	public void move() {
		x -= 8;
	}
	public void draw(Graphics g) {
		g.setColor(Color.red);		
		g.fillRect(x, y, width, height);
		
		
		
		
	}
}
