package presentation.contenui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import presentation.mainui.ContentPanel;
import presentation.mainui.MainUI;
import data.po.PlayerDataPO;

public class TablePanel extends ContentPanel{

	public JTable table;
	
	
	public TablePanel(String url) {
		super(url);
		
	}
	
	public void showTable(){
		table = new JTable();
		table.setPreferredScrollableViewportSize(new Dimension(550,30));
		MainUI.bg.add(table.getTableHeader(),BorderLayout.NORTH);
		MainUI.bg.add(table,BorderLayout.CENTER);
		
		ArrayList<PlayerDataPO> list = new ArrayList<PlayerDataPO>();
		for(int i=0;i<9;i++){
			list.add(new PlayerDataPO());
		}
		
		
		TableModel tm = new PlayerTableModelAll(list);
		
		table.setModel(tm);
		System.out.println("1111111");
		
		panel.setLayout(new FlowLayout());
		panel.add(table);
		
		MainUI.getMainFrame().repaint();
		
	}
	
	
	

}
