package presentation.contenui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MyCellRenderer extends DefaultTableCellRenderer{
	private static final long serialVersionUID = 1L;

	private Color selectionColor = new Color(255,192,154);//行选择颜色
	private Color evenRowColor = new Color(238,238,238);//奇数行颜色
	private Color oddRowColor = new Color(250,250,250);//偶数行颜色
	//    private Color gridColor = new Color(236,233,216);//网格颜色
	
	
	public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column){
		Component cell = super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);  
		this.setColor(cell, table, isSelected, hasFocus, row, column);
		return cell;
	}
	/*
	 * 设置颜色
	 */
	protected void setColor(Component component,JTable table,boolean isSelected,boolean hasFocus,int row,int column){

		//		if(row%2 == 0){
		//			component.setBackground(evenRowColor);  
		//		}else{
		//			component.setBackground(oddRowColor);
		//		}

		if(isSelected){
			component.setBackground(selectionColor);
			setBorder(null);//去掉边
		}else{
			if(row%2 == 0){
				component.setBackground(evenRowColor);  
			}else{
				component.setBackground(oddRowColor);
			}
		}
	}
	
	
	
}
