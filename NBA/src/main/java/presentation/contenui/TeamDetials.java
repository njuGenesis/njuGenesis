package presentation.contenui;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import assistance.ContentItem;
import data.po.TeamDataPO;
import presentation.component.GButton;
import presentation.component.GLabel;

public class TeamDetials extends ContentPanel{
	
	private GLabel picture;
	private GLabel name;
	private GLabel nickname;
	private GLabel city;
	private GLabel position;
	private GLabel venues;
	private GLabel time;
	private GButton back;
	private GButton[] players;
	
	private static String url = "img/team/teamBasic.png";

	public static void main(String[] args) {

//		JFrame frame = new JFrame();
//		frame. setBounds(0, 0, 1250, 650);
//		frame.setLayout(null);
//
//		TeamDetials p = new TeamDetials("");
//
//		frame.getContentPane().add(p.getContentPanel());
//		frame.setVisible(true);
	}

	public TeamDetials(TeamDataPO po) {
		super(url);

		String[] data = getData(po);
		
		final String[] names = po.getPlayers().split(";");
		
		players = new GButton[names.length];
		
		for(int i = 0; i<names.length; i++){
			final int k = i;
			players[i] = new GButton(i+1+".   "+names[i], new Point(67, 27+i*30), new Point(210, 25), this.getContentPanel(), true, 1, 15);
			players[i].addMouseListener(new MouseListener() {
				
				GLabel label = new GLabel("img/portrait/"+names[k]+".png", new Point(players[k].getLocation().x+170, players[k].getLocation().y-27), new Point(100, 100), TeamDetials.this.getContentPanel(), false);
				
				public void mouseReleased(MouseEvent e) {
				}
				public void mousePressed(MouseEvent e) {
				}
				public void mouseExited(MouseEvent e) {
					players[k].setForeground(Color.black);
					label.setVisible(false);
				}
				public void mouseEntered(MouseEvent e) {
					players[k].setForeground(new Color(0, 110, 185));
					label.setVisible(true);
				}
				public void mouseClicked(MouseEvent e) {
					ContentController con = new ContentController();
					con.changeToPlayerBasic(names[k]);
				}
			});
		}
		
		picture = new GLabel(data[0], new Point(320, 145), new Point(250, 250), this.getContentPanel(), true);
		name = new GLabel(data[1], new Point(688, 131), new Point(210, 25), this.getContentPanel(), true, 1, 15);
		nickname = new GLabel(data[2], new Point(688, 162), new Point(210, 25), this.getContentPanel(), true, 1, 15);
		city = new GLabel(data[3], new Point(688, 193), new Point(210, 25), this.getContentPanel(), true, 1, 15);//差31
		position = new GLabel(data[4], new Point(688, 224), new Point(210, 25), this.getContentPanel(), true, 1, 15);
		venues = new GLabel(data[5], new Point(688, 255), new Point(210, 25), this.getContentPanel(), true, 1, 15);
		time = new GLabel(data[6], new Point(723, 286), new Point(210, 25), this.getContentPanel(), true, 1, 15);
		
		back = new GButton("img/team/back.png", new Point(749, 460), new Point(61, 61), this.getContentPanel(), true);
		
		back.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent arg0) {
				back.setIcon(new ImageIcon("img/team/back.png"));
			}
			public void mouseEntered(MouseEvent arg0) {
				back.setIcon(new ImageIcon("img/team/backAction.png"));
			}
			public void mouseClicked(MouseEvent arg0) {
				ContentController con = new ContentController();
				con.changeContent(ContentItem.TEAMOFALL);
			}
		});
	}

	private String[] getData(TeamDataPO po){
		//
		String[] data = {"img/teampng/"+po.getShortName()+".png", po.getName(), po.getShortName(), po.getCity(),
				po.getEorW()+"-"+po.getArea(), po.getMainposition(), String.valueOf(po.getBuildyear())};
 		return data;
	}
}
