package presentation.contenui;

import java.awt.Point;

import javax.swing.JFrame;

import presentation.mainui.ContentPanel;
import presentation.mainui.GButton;

public class TeamOfAll extends ContentPanel{
	
	private GButton[] team = new GButton[30];
	
	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame. setBounds(0, 0, 1250, 650);
		frame.setLayout(null);
		
		String[] data = new String[30];
		for(int i = 0;i<30;i++){
			data[i] = "E:/workplace3/team.png";
		}
		
		TeamOfAll team = new TeamOfAll(data);
		
		frame.getContentPane().add(team.getContentPanel());
		frame.setVisible(true);
	}

	public TeamOfAll(String url) {
		super(url);
	}

	/*
	 * data:
	 * 球队的所有图片地址
	 */
	public TeamOfAll(String[] data){
		super("img/team/teamcontent.png");
		
		for(int i = 0; i<30; i++){
			if(i>=0&&i<=4){
				team[i] = new GButton(data[i], new Point(42, 63+i*32), new Point(129, 25), this.getContentPanel(), true);
			}else{
				if(i>=5&&i<=9){
					team[i] = new GButton(data[i], new Point(255, 63+(i-5)*32), new Point(129, 25), this.getContentPanel(), true);
				}else{
					if(i>=10&&i<=14){
						team[i] = new GButton(data[i], new Point(42, 290+(i-10)*32), new Point(129, 25), this.getContentPanel(), true);
					}else{
						if(i>=15&&i<=19){
							team[i] = new GButton(data[i], new Point(716, 63+(i-15)*32), new Point(129, 25), this.getContentPanel(), true);
						}else{
							if(i>=20&&i<=24){
								team[i] = new GButton(data[i], new Point(502, 290+(i-20)*32), new Point(129, 25), this.getContentPanel(), true);
							}else{
								if(i>=25&&i<=29){
									team[i] = new GButton(data[i], new Point(716, 290+(i-25)*32), new Point(129, 25), this.getContentPanel(), true);
								}
							}
						}
					}
				}
			}
		}
	}
}
