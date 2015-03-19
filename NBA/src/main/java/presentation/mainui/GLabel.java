package presentation.mainui;

import java.awt.Container;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GLabel extends JLabel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GLabel(String file, Point location, Point size, Container container, boolean visible){
		ImageIcon image = new ImageIcon(file);
		this.setIcon(image);
		this.setBounds(location.x, location.y, size.x, size.y);
		this.setVisible(visible);
		container.add(this);
	}

	public GLabel(String message, Point location, Point size, Container container, boolean visible, int bord, int wordSize){
		this.setText(message);
		this.setBounds(location.x, location.y, size.x, size.y);
		this.setVisible(visible);
		this.setFont(new java.awt.Font("微软雅黑", bord, wordSize));
		container.add(this);
	}
}
