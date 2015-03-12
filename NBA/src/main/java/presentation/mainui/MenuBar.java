package presentation.mainui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuBar {
	private static JPanel menuBar;
	public static JButton bt1;  //SCHEDULE
	public static JButton bt2;  //
	
	public static void initMenu(){
		menuBar = new JPanel();
		menuBar.setBounds(0, 0, 100, 650);
		menuBar.setBackground(Color.blue);
		menuBar.setLayout(null);
		
		bt1 = new JButton("SCHEDULE");
		bt1.setBounds(0, 190, 100, 50);
		menuBar.add(bt1);
		
	}
	
	public static JPanel getMenuBar(){
		if(menuBar == null){
			initMenu();
		}
		return menuBar;
	}

}
