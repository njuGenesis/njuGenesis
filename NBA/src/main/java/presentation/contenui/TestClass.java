package presentation.contenui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.border.Border;

import presentation.component.GComboBox;

public class TestClass {
	
	
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setSize(600, 600);
		f.setLayout(null);
		f.setBackground(new Color(250,250,250));
		
		JComboBox<String> position;
		String[] positionItem = {"全部位置","后卫","前锋","中锋"}; 
		
		position = new GComboBox(positionItem);
		position.setBounds(45, 93, 120, 30);
		f.add(position);
		
		JButton submit = new JButton("筛选");
		submit.setBounds(220, 93, 120, 30);
		submit.addMouseListener(new Lis());
		submit.setBorder(BorderFactory.createLineBorder(new Color(0, 110, 185)));
		submit.setContentAreaFilled(false);
		submit.setForeground(new Color(0, 110, 185));
//		submit.addMouseListener(new SubmitListener());
		f.add(submit);
		
		f.setVisible(true);
		
	}
	
	
	

}

class Lis implements MouseListener{

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		JButton bt = (JButton)e.getSource();
		bt.setBorder(BorderFactory.createLineBorder(new Color(0, 110, 185), 2));
	}

	public void mouseExited(MouseEvent e) {
		JButton bt = (JButton)e.getSource();
		bt.setBorder(BorderFactory.createLineBorder(new Color(0, 110, 185)));
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
