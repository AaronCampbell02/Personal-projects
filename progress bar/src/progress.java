import java.awt.*;
import javax.swing.*;
public class progress {
	
	JFrame frame = new JFrame();
	JProgressBar bar = new JProgressBar();
	
	
	progress(){
		bar.setValue(0);
		bar.setBounds(0,0,420,50);
		bar.setStringPainted(true);
		
		
		
		frame.add(bar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		
		bob();
	}
	public void bob() {
		int counter = 0;
				
		while(counter <= 100) {
			bar.setValue(counter);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			counter += 1;
		}
	bar.setString("done");
	}
}
