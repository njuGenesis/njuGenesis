package presentation.contenui;

import java.awt.Point;

import javax.swing.JFrame;

import presentation.component.GLabel;

public class PlayerBasic extends ContentPanel{
	
	private GLabel team;
	private GLabel palyer;
	private GLabel name;
	private GLabel number;
	private GLabel position;
	private GLabel height;
	private GLabel weight;
	private GLabel birthday;
	private GLabel age;
	private GLabel exp;
	private GLabel school;
	
	protected static String url = "img/Player/playerBasic.png";

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame. setBounds(0, 0, 1250, 650);
		frame.setLayout(null);
		
		PlayerBasic p = new PlayerBasic("");
		
		frame.getContentPane().add(p.getContentPanel());
		frame.setVisible(true);
	}
	
	/*
	 * data:
	 * 0:球队图片地址
	 * 1:球员图片地址
	 * 2:姓名
	 * 3:球衣号码
	 * 4:位置
	 * 5:身高
	 * 6:体重
	 * 7:生日
	 * 8:年龄
	 * 9:球龄
	 * 10:毕业院校
	 */
	public PlayerBasic(String key) {
		super(url);
		
		String[] data = getData(key);

		team = new GLabel(data[0], new Point(106, 103), new Point(122, 122), this.getContentPanel(), true);
		palyer = new GLabel(data[1], new Point(291, 165), new Point(228, 175), this.getContentPanel(), true);
		name = new GLabel(data[2], new Point(646, 131), new Point(110, 25), this.getContentPanel(), true, 1, 15);//差31
		number = new GLabel(data[3], new Point(681, 162), new Point(110, 25), this.getContentPanel(), true, 1, 15);
		position = new GLabel(data[4], new Point(646, 193), new Point(110, 25), this.getContentPanel(), true, 1, 15);
		height = new GLabel(data[5], new Point(646, 224), new Point(110, 25), this.getContentPanel(), true, 1, 15);
		weight = new GLabel(data[6], new Point(646, 255), new Point(110, 25), this.getContentPanel(), true, 1, 15);
		birthday = new GLabel(data[7], new Point(646, 286), new Point(110, 25), this.getContentPanel(), true, 1, 15);
		age = new GLabel(data[8], new Point(646, 317), new Point(110, 25), this.getContentPanel(), true, 1, 15);
		exp = new GLabel(data[9], new Point(646, 348), new Point(110, 25), this.getContentPanel(), true, 1, 15);
		school = new GLabel(data[10], new Point(681, 379), new Point(110, 25), this.getContentPanel(), true, 1, 15);
	}
	
	
	private String[] getData(String palyerName){
		//
		String[] data = {"E:/workplace3/team.png", "E:/workplace3/player.png", "Aaron Brooks", "0", "G", "6-0", "161", "JAN 14, 1985", "29"
				, "5", "Oregon"};
 		return data;
	}

}
