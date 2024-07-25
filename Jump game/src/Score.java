import java.awt.*;

public class Score extends Rectangle{
	static int GAMEW;
	static int GAMEH;
	static int score = 0;
	
	Score(int GAMEW, int GAMEH){
		Score.GAMEW = GAMEW;
		Score.GAMEH = GAMEH;
	}
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("Ink Free", Font.BOLD,60));
		
		g.drawLine(0, 440, 1000, 440);
		
		g.drawString(String.valueOf("Score: "+score), GAMEW/2-85, 50);
	}
}
