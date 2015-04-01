package presentation.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import presentation.contenui.MyCellRenderer;

public class TeamRenderer extends MyCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TeamRenderer(){
		this.addMouseListener(new TeamListener());
		this.setFont(new Font("微软雅黑",1,12));
	}
	
	class TeamListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent e) {
			TeamRenderer.this.setForeground(Color.BLUE);
		}

		public void mouseExited(MouseEvent e) {
			TeamRenderer.this.setForeground(Color.black);
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
