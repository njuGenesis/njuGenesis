package presentation.contenui;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import presentation.mainui.ContentPanel;
import presentation.mainui.MainUI;

public class PlayerStatsPanel extends ContentPanel{
	
	public JTable table;
	public JScrollPane jsp;
	

	public PlayerStatsPanel(String url) {
		super(url);
		
		PagingTableModel model = new PagingTableModel(TableData.getPlayerVO());  
        table = new JTable(model);  
        TableUtility.setFont(table);
        TableUtility.setTableColor(table);
        TableUtility.setTableRowHeight(table, 40);
        TableUtility.setTableHeaderHeight(table, 25);
        
        // Use our own custom scrollpane.  
        jsp = PagingTableModel.createPagingScrollPaneForTable(table);  
        jsp.setBounds(25, 144, 830, 350);
        TableUtility.setTabelPanel(jsp);
        
        panel.add(jsp);
        
        
        MainUI.getBg().add(panel);
        MainUI.getMainFrame().repaint();
	}

}
