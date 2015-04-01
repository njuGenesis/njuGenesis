package presentation.component;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class NothingButton extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NothingButton(){
		super();
		
		this.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent arg0) {
				
			}

			public void mouseEntered(MouseEvent arg0) {
				
			}

			public void mouseExited(MouseEvent arg0) {
				
			}

			public void mousePressed(MouseEvent arg0) {
				
			}

			public void mouseReleased(MouseEvent arg0) {
				
			}
			
		});
	}

}
