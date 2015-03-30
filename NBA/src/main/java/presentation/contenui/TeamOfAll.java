package presentation.contenui;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import bussinesslogic.team.TeamLogic;
import presentation.component.GButton;
import presentation.mainui.MainUI;

public class TeamOfAll extends ContentPanel{
	
	private GButton[] team = new GButton[30];
	
	private static String url = "img/team/teamcontent.png";
	
	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame. setBounds(0, 0, 1250, 650);
		frame.setLayout(null);
		
		TeamOfAll team = new TeamOfAll();
		
		frame.getContentPane().add(team.getContentPanel());
		frame.setVisible(true);
	}

	public TeamOfAll() {
		super(url);
		
		String[] data = getData();
		
		for(int i = 0; i<30; i++){
			if(i>=0&&i<=4){
				team[i] = new GButton(data[i], new Point(42, 63+i*32), new Point(129, 25), this.getContentPanel(), true, data[i]);
			}else{
				if(i>=5&&i<=9){
					team[i] = new GButton(data[i], new Point(255, 63+(i-5)*32), new Point(129, 25), this.getContentPanel(), true, data[i]);
				}else{
					if(i>=10&&i<=14){
						team[i] = new GButton(data[i], new Point(42, 290+(i-10)*32), new Point(129, 25), this.getContentPanel(), true, data[i]);
					}else{
						if(i>=15&&i<=19){
							team[i] = new GButton(data[i], new Point(716, 63+(i-15)*32), new Point(129, 25), this.getContentPanel(), true, data[i]);
						}else{
							if(i>=20&&i<=24){
								team[i] = new GButton(data[i], new Point(502, 290+(i-20)*32), new Point(129, 25), this.getContentPanel(), true, data[i]);
							}else{
								if(i>=25&&i<=29){
									team[i] = new GButton(data[i], new Point(716, 290+(i-25)*32), new Point(129, 25), this.getContentPanel(), true, data[i]);
								}
							}
						}
					}
				}
			}
		}
		
		MouseAdapter mouseAdapter = new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
				GButton button = (GButton)e.getSource();
				TeamOfAll.this.getContentPanel().setVisible(false);
				if(MainUI.getBg().getComponentAt(220, 95)!=null){
					MainUI.getBg().remove(MainUI.getBg().getComponentAt(220, 95));
				}System.out.println(button.key);
				MainUI.addCom(new TeamDetials(button.key).getContentPanel());
			}
		};
		
		for(int i = 0; i<30; i++){
			team[i].addMouseListener(mouseAdapter);
		}
	}
	/*
	 * data:
	 * 球队的所有简称
	 */
	private String[] getData(){
		
		
		
		String[] data = new String[30];
		for(int i = 0;i<30;i++){
			data[i] = "E:/workplace3/team.png";
		}
		return data;
	}
}
