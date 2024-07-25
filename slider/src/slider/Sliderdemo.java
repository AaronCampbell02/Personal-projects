package slider;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class Sliderdemo implements ChangeListener{
	JFrame frame;
	JPanel panel;
	JLabel label;
	JSlider slider;
	Sliderdemo(){
		
		frame = new JFrame(" current temperature");
		panel = new JPanel();
		label = new JLabel();
		slider = new JSlider(0,100,50);
		
		slider.setPreferredSize(new Dimension(400,200));
		
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(10);
		slider.setPaintTrack(true);
		slider.setMajorTickSpacing(20);
		slider.setFont(new Font("MV Boli",Font.PLAIN,15));
		slider.setOrientation(SwingConstants.VERTICAL);
		
		label.setFont(new Font("MV Boli",Font.PLAIN,25));
		label.setText("temp in degrees is " + slider.getValue());
		slider.addChangeListener(this);
		
		slider.setPaintLabels(true);
		panel.add(slider);
		panel.add(label);
		frame.add(panel);
		frame.setSize(420,420);
		frame.setVisible(true);
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		label.setText("temp in degrees is " + slider.getValue());
		
		
	}
	
}
