package presentation.component;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public class GRadioButton extends JRadioButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String letter;

	public GRadioButton(String letter){
		this.letter = letter;
		this.setIcon(getIcon(letter));
		this.setContentAreaFilled(false);
		this.addMouseListener(new BtLitsener());
		this.setSelectedIcon(getChosenIcon(letter));
	}

	public static ImageIcon getIcon(String letter){
		ImageIcon icon = new ImageIcon("img/alphabet/"+letter+".png");
		return icon;
	}

	public static ImageIcon getChosenIcon(String letter){
		ImageIcon icon = new ImageIcon("img/alphabet/chosen"+letter+".png");
		return icon;
	}

	
	class BtLitsener implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent e) {
			GRadioButton b = (GRadioButton)e.getSource();
			b.setIcon(GRadioButton.getChosenIcon(b.letter));
		}

		public void mouseExited(MouseEvent e) {
			GRadioButton b = (GRadioButton)e.getSource();
			b.setIcon(GRadioButton.getIcon(b.letter));
		}

		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
}
