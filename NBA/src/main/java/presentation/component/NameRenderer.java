package presentation.component;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import presentation.contenui.MyCellRenderer;

public class NameRenderer extends MyCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private NothingButton button;
	private JPanel panel;

	public NameRenderer(){
		initButton();
		this.initPanel();

        // 添加按钮。
        this.panel.add(this.button);
	}
	
	private void initButton()
    {
        this.button = new NothingButton();

        // 设置按钮的大小
        this.button.setBounds(0,0,150,32);
        this.button.setFont(new Font("微软雅黑",0,12));
        this.button.setContentAreaFilled(false);
        this.button.setBorder(null);
        this.button.setOpaque(false);
        this.button.setHorizontalAlignment(JButton.LEFT);

    }
	
	private void initPanel(){
        this.panel = new JPanel();
//        panel.setOpaque(false);

        // panel使用绝对定位，这样button就不会充满整个单元格。
        this.panel.setLayout(null);
        this.panel.setLocation(0, 0);
    }

	public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column){            
		super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
		super.setColor(this.panel, table, isSelected, hasFocus, row, column);
		

		this.button.setAlignmentX(SwingConstants.LEFT);
		this.button.setText(value == null ? "" : String.valueOf(value));
		
        return this.panel;

	}

	





}
