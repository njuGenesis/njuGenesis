package presentation.mainui;

import javax.swing.JFrame;

public class MainUI {
	
	public static void main(String[] args){
//		MainUI.initLoginFrame();
		MainUI.initMainFrame();
		
	}
	
	private static JFrame loginFrame;
	private static JFrame mainFrame;
	
	public static void initMainFrame(){
		mainFrame = new JFrame("NBA");
		mainFrame.setSize(1200, 650);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setLayout(null);
		
		mainFrame.add(MenuBar.getMenuBar());
		
		mainFrame.setVisible(true);
		
	}
	
	public static JFrame getMainFrame(){
		if(mainFrame==null){
			initMainFrame();
		}
		return mainFrame;
	}
	
	public static void initLoginFrame(){
		loginFrame = new JFrame("Login");
		loginFrame.setSize(500, 500);
		loginFrame.setLocationRelativeTo(null);
		
		loginFrame.setVisible(true);
	}
	
	public static JFrame getLoginFrame(){
		if(loginFrame==null){
			initLoginFrame();
		}
		return loginFrame;
	}
	
	

}
