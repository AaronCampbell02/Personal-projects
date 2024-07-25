import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class score extends Rectangle{
	
	static int GAMEW;
	static int GAMEH;
	int player1;
	int player2;
	score(int GAMEW, int GAMEH){
		score.GAMEW = GAMEW;
		score.GAMEH = GAMEH;
		
	}
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("Ink Free", Font.BOLD,60));
		
		g.drawLine(GAMEW/2, 0, GAMEW/2, GAMEH);
		
		g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10), GAMEW/2-85, 50);
		g.drawString(String.valueOf(player2/10)+String.valueOf(player2%10), GAMEW/2+20, 50);
	}
}
