package presentation.contenui;

import javax.swing.JPanel;

import presentation.mainui.MainUI;
import presentation.mainui.TitlePanel;
import assistance.MenuItem;

public class ContentController {
	
	public void changeTitle(MenuItem m){
		JPanel title = MainUI.getTitlePanel();
		if(title.getComponentAt(0, 0)!=null){
			title.remove(title.getComponentAt(0, 0));
		}
		title.add(TitlePanel.getTitle(m));
		MainUI.getMainFrame().repaint();
	}
	
	public void changeContent(){
		
	}

}
