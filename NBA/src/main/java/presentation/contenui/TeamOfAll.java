package presentation.contenui;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

import data.po.TeamDataPO;
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
		
//		TeamOfAll team = new TeamOfAll();
//		
//		frame.getContentPane().add(team.getContentPanel());
		GButton button = new GButton("img/teampng/ATL.png", new Point(42, 63), new Point(25, 25), frame, true);
		//GLabel label = new GLabel("img/teampng/ATL.png", new Point(42, 63), new Point(25, 25), frame, true);
		frame.setVisible(true);
	}

	public TeamOfAll() {
		super(url);
		
		ArrayList<TeamDataPO> poList = getTeamDataPOs();
		ArrayList<ArrayList<TeamDataPO>> teamDataPOArea = setTeamDataPOArea(poList);
		
		for(int i = 0; i<30; i++){
			if(i>=0&&i<=4){
				team[i] = new GButton(getFileAddress(teamDataPOArea.get(0).get(i)), new Point(42, 63+i*32), new Point(128, 25), this.getContentPanel(), true, teamDataPOArea.get(0).get(i));//25, 25
			}else{
				if(i>=5&&i<=9){
					team[i] = new GButton(getFileAddress(teamDataPOArea.get(1).get(i-5)), new Point(255, 63+(i-5)*32), new Point(128, 25), this.getContentPanel(), true, teamDataPOArea.get(1).get(i-5));
				}else{
					if(i>=10&&i<=14){
						team[i] = new GButton(getFileAddress(teamDataPOArea.get(2).get(i-10)), new Point(42, 290+(i-10)*32), new Point(128, 25), this.getContentPanel(), true, teamDataPOArea.get(2).get(i-10));
					}else{
						if(i>=15&&i<=19){
							team[i] = new GButton(getFileAddress(teamDataPOArea.get(3).get(i-15)), new Point(716, 63+(i-15)*32), new Point(128, 25), this.getContentPanel(), true, teamDataPOArea.get(3).get(i-15));
						}else{
							if(i>=20&&i<=24){
								team[i] = new GButton(getFileAddress(teamDataPOArea.get(4).get(i-20)), new Point(502, 290+(i-20)*32), new Point(128, 25), this.getContentPanel(), true, teamDataPOArea.get(4).get(i-20));
							}else{
								if(i>=25&&i<=29){
									team[i] = new GButton(getFileAddress(teamDataPOArea.get(5).get(i-25)), new Point(716, 290+(i-25)*32), new Point(128, 25), this.getContentPanel(), true, teamDataPOArea.get(5).get(i-25));
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
				ContentController con = new ContentController();
				con.changeToTeamDetails(button.po);
			}
		};
		
		for(int i = 0; i<30; i++){
			team[i].addMouseListener(mouseAdapter);
		}
	}
	
	private ArrayList<TeamDataPO> getTeamDataPOs(){
		TeamLogic t = new TeamLogic();
		return t.GetAllInfo();
	}
	
	private ArrayList<ArrayList<TeamDataPO>> setTeamDataPOArea(ArrayList<TeamDataPO> poList){
		ArrayList<TeamDataPO> Southeast = new ArrayList<TeamDataPO>();
		ArrayList<TeamDataPO> Central = new ArrayList<TeamDataPO>();
		ArrayList<TeamDataPO> Atlantic = new ArrayList<TeamDataPO>();
		ArrayList<TeamDataPO> Southwest = new ArrayList<TeamDataPO>();
		ArrayList<TeamDataPO> Northwest = new ArrayList<TeamDataPO>();
		ArrayList<TeamDataPO> Pacific = new ArrayList<TeamDataPO>();
		for(int i = 0; i<30; i++){
			if(poList.get(i).getArea().equals("Southeast")){
				Southeast.add(poList.get(i));
			}else{
				if(poList.get(i).getArea().equals("Central")){
					Central.add(poList.get(i));
				}else{
					if(poList.get(i).getArea().equals("Atlantic")){
						Atlantic.add(poList.get(i));
					}else{
						if(poList.get(i).getArea().equals("Southwest")){
							Southwest.add(poList.get(i));
						}else{
							if(poList.get(i).getArea().equals("Northwest")){
								Northwest.add(poList.get(i));
							}else{
								if(poList.get(i).getArea().equals("Pacific")){
									Pacific.add(poList.get(i));
								}
							}
						}
					}
				}
			}
		}
		ArrayList<ArrayList<TeamDataPO>> setAera = new ArrayList<ArrayList<TeamDataPO>>();
		setAera.add(Southeast);
		setAera.add(Central);
		setAera.add(Atlantic);
		setAera.add(Southwest);
		setAera.add(Northwest);
		setAera.add(Pacific);
		return setAera;
	}
	
	/*
	 * data:
	 * 球队的所有简称
	 */
	private String getFileAddress(TeamDataPO po){
		String fileAddress = "img/teamName/"+po.getShortName()+".png";
		return fileAddress;
	}
}
