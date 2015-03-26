package presentation.component;

import java.awt.Color;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPasswordField;

public class GPasswordField extends JPasswordField{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GPasswordField(Point location, Point size, Container container, boolean visible){
		this.setLocation(location);
		this.setSize(size.x, size.y);
		
		this.setBorder(null);
		this.setOpaque(false);
		
		this.setFont(new java.awt.Font("微软雅黑",0,13));
		this.setForeground(Color.BLACK);
		this.enableInputMethods(false);//禁用输入法
		
		container.add(this);
		
		this.setVisible(visible);
		
		KeyAdapter keyAdapter = new KeyAdapter() {
			 public void keyTyped(KeyEvent e) {
				 char k = e.getKeyChar();
				 if((k>='a'&&k<='z')||(k>='A'&&k<='Z')||(k>='0'&&k<='9')){
				 }else{
					 e.consume();
				 }
			 }
		};
		
		this.addKeyListener(keyAdapter);
	}
	
}
