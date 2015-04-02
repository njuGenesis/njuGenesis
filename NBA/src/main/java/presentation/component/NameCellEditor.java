package presentation.component;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import presentation.contenui.ContentController;

public class NameCellEditor extends DefaultCellEditor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panel;  

	private NothingButton button;  
	
	private ContentController con = new ContentController();


	public NameCellEditor() {
		super(new JTextField());

		// 设置点击几次激活编辑。   
		this.setClickCountToStart(1);  

		this.initButton();  
		this.initPanel();  

		// 添加按钮。   
		this.panel.add(this.button);  
	}


	private void initButton(){  
		this.button = new NothingButton();  

		// 设置按钮的大小及位置。   
		this.button.setBounds(0, 0, 150, 32);  

		// 为按钮添加事件。这里只能添加ActionListner事件，Mouse事件无效。   
		this.button.addActionListener(new ActionListener()  
		{  
			public void actionPerformed(ActionEvent e)  
			{  
				// 触发取消编辑的事件，不会调用tableModel的setValue方法。   
				NameCellEditor.this.fireEditingCanceled();  

				con.changeToPlayerBasic(NameCellEditor.this.button.getText());
				// 这里可以做其它操作。   
				// 可以将table传入，通过getSelectedRow,getSelectColumn方法获取到当前选择的行和列及其它操作等。   
			}  
		});  

	}  

	private void initPanel(){  
		this.panel = new JPanel();  

		// panel使用绝对定位，这样button就不会充满整个单元格。   
		this.panel.setLayout(null);  
	}  


	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column){  
		// 只为按钮赋值即可。也可以作其它操作。   
		this.button.setText(value == null ? "" : String.valueOf(value));  

		return this.panel;  
	}  

	/** 
	 * 重写编辑单元格时获取的值。如果不重写，这里可能会为按钮设置错误的值。 
	 */  
	@Override  
	public Object getCellEditorValue(){  
		return this.button.getText();  
	}  

}
