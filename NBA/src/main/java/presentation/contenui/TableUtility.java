package presentation.contenui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableUtility {
	
	public static void setTableRowHeight(JTable table,int h){
		table.setRowHeight(h);
	}
	
	public static void setTableHeaderHeight(JTable table,int h){
		table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(),h));
	}
	
	public static void setTabelPanel(JScrollPane tablePanel){
		tablePanel.setOpaque(false);
		tablePanel.getViewport().setOpaque(false);
		tablePanel.setViewportBorder(BorderFactory.createEmptyBorder());
		tablePanel.setBorder(BorderFactory.createEmptyBorder());
	}
	
	public static void setTableColor(JTable table){
		table.setDefaultRenderer(Object.class,new MyCellRenderer());
		setFont(table);
		table.setShowGrid(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	}
	
	public static void setFont(JTable table){
		table.setFont(new Font("微软雅黑",0,12));
		table.getTableHeader().setBackground(new Color(112,112,112));
		table.getTableHeader().setFont(new Font("微软雅黑",0,12));
		table.getTableHeader().setForeground(Color.white);
	}

}
