package presentation.contenui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicArrowButton;

public class UIUtil {

	public static ImageIcon defaultComboBoxArrowIcon = new ImageIcon("img/icon/donwBt.png");
	
	public static Color nbaBlue = new Color(0,110,185);
	public static Color nbaRed = new Color(228,42,81);

	public static JButton getComboBoxArrowButton(){
		BasicArrowButton bt = new BasicArrowButton(BasicArrowButton.LEFT,Color.black,Color.black,Color.black,Color.black);
		bt.setSize(30, 30);

		return bt;
	}
	
	public static JButton getLeftButton(){
		JButton left = new JButton(new ImageIcon("img/icon/leftBt.png"));
		left.setBorder(null);
		left.setContentAreaFilled(false);
		return left;
	}
	
	public static JButton getRightButton(){
		JButton right = new JButton(new ImageIcon("img/icon/rightBt.png"));
		right.setBorder(null);
		right.setContentAreaFilled(false);
		return right;
	}
	
}
