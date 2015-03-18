package presentation.mainui;

import presentation.contenui.ContentController;

public class ContentPanel {
	protected BgPanel panel;
	public ContentController con;
	
	public ContentPanel(String url){
		panel = new BgPanel(url);
		panel.setSize(880, 555);
		panel.setLocation(220, 95);
		panel.setLayout(null);
	}
	
	public BgPanel getContentPanel(){
		return panel;
	}

}
