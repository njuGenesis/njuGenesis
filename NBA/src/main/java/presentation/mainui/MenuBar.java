package presentation.mainui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import assistance.MenuItem;
import presentation.contenui.ContentController;


public class MenuBar {
	public JPanel menuBar;
	public ContentController con;

	private JButton bt1;  //HOME
	private JButton bt2;  //TEAM
	private JButton bt3;  //PLAYER
	private JButton bt4;  //RANKING
	private JButton bt5;  //STATS
	private JButton[] btArray = {bt1,bt2,bt3,bt4,bt5};

	private ArrayList<ImageIcon> icons = new ArrayList<ImageIcon>();
	private ArrayList<ImageIcon> iconsEnter = new ArrayList<ImageIcon>();

	private MouseListener[] listenerArray = {new HomeListener(),new TeamListener(),new PlayerListener(),new RankingListener(),new StatsListener()};

	private int btWidth = 120;
	private int btHeight = 40;
	private int btBetween = 50;

	
	
	//---------------初始化按钮图片---------------
	private void initImage(){
		String imgAdd = "img/menubt/menuBt";
		String postfix = ".png";
		String postfix2 = "Enter.png";
		String[] menuItem = {"Home","Team","Player","Ranking","Stats"};
		
		for(int i=0;i<5;i++){
			ImageIcon icon = new ImageIcon(imgAdd+menuItem[i]+postfix);
			icons.add(icon);
			
			ImageIcon iconEnter = new ImageIcon(imgAdd+menuItem[i]+postfix2);
			iconsEnter.add(iconEnter);
		}
	}

	//---------------初始化菜单---------------
	private void initMenu(){
		menuBar = new JPanel();
		menuBar.setBounds(0, 0, 220, 650);
		menuBar.setLayout(null);
		menuBar.setOpaque(false);

		//创建菜单按钮
		for(int i=0;i<btArray.length;i++){
			btArray[i] = new JButton();
			btArray[i].setBounds(65, 130+btBetween*i, btWidth, btHeight);
			btArray[i].setIcon(icons.get(i));
			btArray[i].setContentAreaFilled(false);
			btArray[i].addMouseListener(listenerArray[i]);
			btArray[i].setBorder(null);
			menuBar.add(btArray[i]);
		}

	}

	//---------------获取菜单栏---------------
	public static JPanel getMenuBar(ContentController con){
		MenuBar mb = new MenuBar();
		mb.con = con;
		mb.initImage();
		mb.initMenu();
		return mb.menuBar;
	}



	//---------------Listener---------------
	class HomeListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseEntered(MouseEvent e) {
			JButton button = (JButton)e.getSource();
			button.setIcon(iconsEnter.get(0));
		}

		public void mouseExited(MouseEvent e) {
			JButton button = (JButton)e.getSource();
			button.setIcon(icons.get(0));
		}

		public void mousePressed(MouseEvent e) {
			con.changeTitle(MenuItem.Home);
		}

		public void mouseReleased(MouseEvent e) {

		}

	}

	class TeamListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseEntered(MouseEvent e) {
			JButton button = (JButton)e.getSource();
			button.setIcon(iconsEnter.get(1));
		}

		public void mouseExited(MouseEvent e) {
			JButton button = (JButton)e.getSource();
			button.setIcon(icons.get(1));
		}

		public void mousePressed(MouseEvent e) {
			con.changeTitle(MenuItem.Team);
		}

		public void mouseReleased(MouseEvent e) {

		}

	}

	class PlayerListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseEntered(MouseEvent e) {
			JButton button = (JButton)e.getSource();
			button.setIcon(iconsEnter.get(2));
		}

		public void mouseExited(MouseEvent e) {
			JButton button = (JButton)e.getSource();
			button.setIcon(icons.get(2));
		}

		public void mousePressed(MouseEvent e) {
			con.changeTitle(MenuItem.Player);
		}

		public void mouseReleased(MouseEvent e) {

		}

	}

	class RankingListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseEntered(MouseEvent e) {
			JButton button = (JButton)e.getSource();
			button.setIcon(iconsEnter.get(3));
		}

		public void mouseExited(MouseEvent e) {
			JButton button = (JButton)e.getSource();
			button.setIcon(icons.get(3));
		}

		public void mousePressed(MouseEvent e) {
			con.changeTitle(MenuItem.Ranking);
		}

		public void mouseReleased(MouseEvent e) {

		}


	}

	class StatsListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseEntered(MouseEvent e) {
			JButton button = (JButton)e.getSource();
			button.setIcon(iconsEnter.get(4));
		}

		public void mouseExited(MouseEvent e) {
			JButton button = (JButton)e.getSource();
			button.setIcon(icons.get(4));
		}

		public void mousePressed(MouseEvent e) {
			con.changeTitle(MenuItem.Stats);
		}

		public void mouseReleased(MouseEvent e) {

		}

	}
}
