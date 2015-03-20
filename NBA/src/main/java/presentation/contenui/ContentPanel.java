package presentation.contenui;

import presentation.mainui.BgPanel;

public class ContentPanel {
	protected BgPanel panel;
	public ContentController con;
	private String url;
	
	public ContentPanel(){
		panel = new BgPanel(url);
		panel.setSize(880, 555);
		panel.setLocation(220, 95);
		panel.setLayout(null);
		panel.setOpaque(false);
	}
	
	public BgPanel getContentPanel(){
		return panel;
	}

}
