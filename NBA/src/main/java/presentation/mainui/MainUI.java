package presentation.mainui;


import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.component.BgPanel;
import presentation.contenui.ContentController;
import assistance.ContentItem;
import assistance.MenuItem;

import com.sun.awt.AWTUtilities;

@SuppressWarnings("restriction")
public class MainUI {
	
	public static BgPanel bg;
	public static JPanel title;
	private static JFrame mainFrame;
	private static JButton exit;
	private static JButton mini;
	
	private static ImageIcon exitIcon = new ImageIcon("img/frame/exitBt.png");
	private static ImageIcon exitEnIcon = new ImageIcon("img/frame/exitBtEnter.png");
	private static ImageIcon miniIcon = new ImageIcon("img/frame/miniBt.png");
	private static ImageIcon miniEnIcon = new ImageIcon("img/frame/miniBtEnter.png");
	
	public static ContentController controller = new ContentController();
	
	
	public static void main(String[] args){
		MainUI.initMainFrame();
	}
	
	public static void initMainFrame(){
		
		mainFrame = new JFrame("NBA");
		mainFrame.setSize(1250, 650);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setLayout(null);
		mainFrame.setUndecorated(true);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = (int)(screen.getWidth()-mainFrame.getWidth())/2;
		int y = (int)(screen.getHeight()-mainFrame.getHeight())/2-32;
		mainFrame.setLocation(x, y);//设置居中
		AWTUtilities.setWindowOpaque(mainFrame,false);  //设置窗口透明
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//----------背景panel----------
		bg = new BgPanel("img/frame/framebg.png");
		bg.setSize(1250, 650);
		bg.setLayout(null);
		mainFrame.add(bg);
		bg.add(MenuBar.getMenuBar(controller));
		
		//----------标题panel----------
		title = new JPanel();
		title.setBounds(220,0,880,95);
		title.setLayout(null);
		title.setOpaque(false);
		controller.changeTitle(MenuItem.Home);
		bg.add(title);
		
		initExitBt();
		
		
		//表格测试！
//		PlayerStatsPanel sp = new PlayerStatsPanel("img/content/contentTitle.png");
		controller.changeContent(ContentItem.Home);
		
		
		mainFrame.setVisible(true);
	}
	
	//----------初始化最小化&关闭按钮----------
	private static void initExitBt(){
		exit = new JButton();
		exit.setBounds(1210, 10, 20, 20);
		exit.setIcon(exitIcon);
		exit.setBorder(null);
		exit.setContentAreaFilled(false);
		exit.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent arg0) {
				exit.setIcon(exitEnIcon);
			}

			public void mouseExited(MouseEvent arg0) {
				exit.setIcon(exitIcon);
			}

			public void mousePressed(MouseEvent arg0) {
				LoginUI login = new LoginUI();
				login.readyClose();
				mainFrame.dispose();
				login.close();
			}

			public void mouseReleased(MouseEvent arg0) {
			}
			
		});
		bg.add(exit);
		
		
		mini = new JButton();
		mini.setBounds(1180, 10, 20, 20);
		mini.setIcon(miniIcon);
		mini.setBorder(null);
		mini.setContentAreaFilled(false);
		mini.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent arg0) {
				mini.setIcon(miniEnIcon);
			}

			public void mouseExited(MouseEvent arg0) {
				mini.setIcon(miniIcon);
			}

			public void mousePressed(MouseEvent arg0) {
				mainFrame.setExtendedState(JFrame.ICONIFIED);
			}

			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		bg.add(mini);
	}
	
	public static JFrame getMainFrame(){
		if(mainFrame==null){
			initMainFrame();
		}
		return mainFrame;
	}
	
	public static void addCom(JComponent com){
		bg.add(com);
		mainFrame.repaint();
	}
	
	public static JPanel getTitlePanel(){
		return title;
	}
	
	public static BgPanel getBg(){
		return bg;
	}
	
	

}
