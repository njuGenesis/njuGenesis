package presentation.contenui;

import java.awt.Point;

import javax.swing.JFrame;

import presentation.component.GLabel;

public class TeamDetials extends ContentPanel{
	
	private GLabel picture;
	private GLabel name;
	private GLabel nickname;
	private GLabel city;
	private GLabel position;
	private GLabel venues;
	private GLabel time;

	private static String url = "img/team/teamBasic.png";

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame. setBounds(0, 0, 1250, 650);
		frame.setLayout(null);

		TeamDetials p = new TeamDetials("");

		frame.getContentPane().add(p.getContentPanel());
		frame.setVisible(true);
	}

	public TeamDetials(String key) {
		super(url);

		String[] data = getData(key);
		
		name = new GLabel(data[0], new Point(293, 195), new Point(231, 146), this.getContentPanel(), true);
		name = new GLabel(data[1], new Point(646, 131), new Point(110, 25), this.getContentPanel(), true, 1, 15);
		nickname = new GLabel(data[2], new Point(646, 162), new Point(110, 25), this.getContentPanel(), true, 1, 15);
		city = new GLabel(data[3], new Point(646, 193), new Point(110, 25), this.getContentPanel(), true, 1, 15);//差31
		position = new GLabel(data[4], new Point(646, 224), new Point(110, 25), this.getContentPanel(), true, 1, 15);
		venues = new GLabel(data[5], new Point(646, 255), new Point(110, 25), this.getContentPanel(), true, 1, 15);
		time = new GLabel(data[6], new Point(681, 286), new Point(110, 25), this.getContentPanel(), true, 1, 15);
	}

	private String[] getData(String palyerName){
		//
		String[] data = {"E:/workplace3/teamPic.png", "Hawks", "ATL", "Atlanta", "E-Southeast", "Philips Arena", "1949"
				, "5", "Oregon"};
 		return data;
	}
}
