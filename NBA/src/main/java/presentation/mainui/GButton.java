package presentation.mainui;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GButton extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ImageIcon image;

	public GButton(String file, Point location, Point size, Container container, boolean visible){
		this.setIcon(new ImageIcon(file));
		this.setLocation(location);
		this.setSize(size.x, size.y);
		this.setBorder(null);//去掉边框
		this.setContentAreaFilled(false);//去掉背景色
		container.add(this);
		this.setVisible(visible);
	}
	
}
