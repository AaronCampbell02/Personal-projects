import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements ActionListener{
		JMenuBar menu;
		JMenu fileMenu;
		JMenu editMenu;
		JMenu helpMenu;
		JMenuItem loadItem;
		JMenuItem saveItem;
		JMenuItem exitItem;
	MyFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLayout(new FlowLayout());
		menu = new JMenuBar();
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		helpMenu = new JMenu("Help");
		
		loadItem = new JMenuItem("load");
		saveItem = new JMenuItem("save");
		exitItem = new JMenuItem("exit");
		
		loadItem.addActionListener(this);
		saveItem.addActionListener(this);
		exitItem.addActionListener(this);
		
		loadItem.setMnemonic(KeyEvent.VK_L);
		saveItem.setMnemonic(KeyEvent.VK_S);
		exitItem.setMnemonic(KeyEvent.VK_E);
		
		fileMenu.add(loadItem);
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);
		
		menu.add(fileMenu);
		menu.add(editMenu);
		menu.add(helpMenu);
		
		this.setJMenuBar(menu);
		
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==loadItem) {
			System.out.println("loading item");
		}
		if(e.getSource()==saveItem) {
			System.out.println("save item");
		}
		if(e.getSource()==exitItem) {
			System.out.println("exit");
			System.exit(0);
	}
}
}
