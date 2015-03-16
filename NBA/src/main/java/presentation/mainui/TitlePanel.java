package presentation.mainui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import assistance.MenuItem;

public class TitlePanel {
	
	public static JLabel homeLabel;
	public static JLabel teamLabel;
	public static JLabel playerLabel;
	public static JLabel rankingLabel;
	public static JLabel statsLabel;
	
	
	public static ImageIcon homeIcon = new ImageIcon("img/title/titleHome.png");
	public static ImageIcon teamIcon = new ImageIcon("img/title/titleTeam.png");
	public static ImageIcon playerIcon = new ImageIcon("img/title/titlePlayer.png");
	public static ImageIcon rankingIcon = new ImageIcon("img/title/titleRanking.png");
	public static ImageIcon statsIcon = new ImageIcon("img/title/titleStats.png");
	
	public static BgPanel getTitlePanel(MenuItem m){
		
		String addr = "img\title\title"+m.getStr()+".png";
		BgPanel title = new BgPanel(addr);
		title.setBounds(220, 0, 880, 95);
		title.setLayout(null);
		return title;
	}
	
	private static void init(){
		homeLabel = new JLabel(new ImageIcon("img/title/titleHome.png"));
		homeLabel.setSize(880, 95);
		homeLabel.setOpaque(false);
		
		teamLabel = new JLabel(new ImageIcon("img/title/titleTeam.png"));
		teamLabel.setSize(880, 95);
		
		playerLabel = new JLabel(new ImageIcon("img/title/titlePlayer.png"));
		playerLabel.setSize(880, 95);
		
		rankingLabel = new JLabel(new ImageIcon("img/title/titleRanking.png"));
		rankingLabel.setSize(880, 95);
		
		statsLabel = new JLabel(new ImageIcon("img/title/titleStats.png"));
		statsLabel.setSize(880, 95);
	}
	
	public static JLabel getTitle(MenuItem m){
		if(homeLabel==null){
			init();
		}
		JLabel label = new JLabel();
		switch(m){
		case Home:label = homeLabel;break;
		case Team:label = teamLabel;break;
		case Player:label = playerLabel;break;
		case Ranking:label = rankingLabel;break;
		case Stats:label = statsLabel;break;
		}
		return label;
	}

}
