package presentation.mainui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import assistance.ContentItem;
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
	
	private JButton playerStats;
	private JButton teamStats;
	private JPanel statsPanel;
	
	private JButton[] btArray = {bt1,bt2,bt3,bt4,bt5};

	private ArrayList<ImageIcon> icons = new ArrayList<ImageIcon>();
	private ArrayList<ImageIcon> iconsEnter = new ArrayList<ImageIcon>();

	private MouseListener[] listenerArray = {new HomeListener(),new TeamListener(),new PlayerListener(),new RankingListener(),new StatsListener()};

	private int btWidth = 120;
	private int btHeight = 40;
	private int btBetween = 50;
	
	private ImageIcon[] subs = {new ImageIcon("img/menubt/subPlayerBt.png"),new ImageIcon("img/menubt/subPlayerBtEnter.png"),new ImageIcon("img/menubt/subTeamBt.png"),new ImageIcon("img/menubt/subTeamBtEnter.png")};

	
	
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
		
		//创建子菜单
		statsPanel = new JPanel();
		statsPanel.setBounds(65, 370, 120, 80);
		statsPanel.setLayout(null);
		statsPanel.setOpaque(false);
		
		playerStats = new JButton();
		playerStats.setBounds(45, 10, 50, 20);
		playerStats.setIcon(subs[0]);
		playerStats.setContentAreaFilled(false);
		playerStats.setBorder(null);
		playerStats.addMouseListener(new SubPlayerListener());
		statsPanel.add(playerStats);
		
		teamStats = new JButton();
		teamStats.setBounds(45, 40, 50, 20);
		teamStats.setIcon(subs[2]);
		teamStats.setContentAreaFilled(false);
		teamStats.setBorder(null);
		teamStats.addMouseListener(new SubTeamListener());
		statsPanel.add(teamStats);
		
		menuBar.add(statsPanel);
		statsPanel.setVisible(false);

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
			con.changeContent(ContentItem.Home);
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
			
//			statsPanel.setVisible(true);
		}

		public void mouseExited(MouseEvent e) {
			JButton button = (JButton)e.getSource();
			button.setIcon(icons.get(4));
			
//			statsPanel.setVisible(false);
		}

		public void mousePressed(MouseEvent e) {
//			con.changeTitle(MenuItem.Stats);
			statsPanel.setVisible(!statsPanel.isVisible());
			
		}

		public void mouseReleased(MouseEvent e) {

		}

	}
	
	class SubPlayerListener implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent e) {
			JButton button = (JButton)e.getSource();
			button.setIcon(subs[1]);
		}

		public void mouseExited(MouseEvent e) {
			JButton button = (JButton)e.getSource();
			button.setIcon(subs[0]);
		}

		public void mousePressed(MouseEvent arg0) {
			con.changeTitle(MenuItem.Stats);
			con.changeContent(ContentItem.PlayerStats);
		}

		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class SubTeamListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent e) {
			JButton button = (JButton)e.getSource();
			button.setIcon(subs[3]);
		}

		public void mouseExited(MouseEvent e) {
			JButton button = (JButton)e.getSource();
			button.setIcon(subs[2]);
		}

		public void mousePressed(MouseEvent e) {
			con.changeTitle(MenuItem.Stats);
			con.changeContent(ContentItem.TeamStats);
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
