package presentation.component;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import presentation.contenui.PagingTableModel;
import presentation.contenui.TableData;
import presentation.contenui.TableUtility;
import presentation.mainui.MainUI;

public class GTable extends JTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JButton pageUp;
	public JButton pageDown;
	public JTextField page;

	public int sortingCol = 0;  //用于标记被排序的列

	public boolean fit = true;

	public GTable(PagingTableModel dm,JButton up,JButton down,JTextField p){
		this(dm,32,30,up,down,p);
	}

	public GTable(PagingTableModel dm,JButton up,JButton down,JTextField p,boolean sortable){
		this(dm,32,30,up,down,p,sortable);
	}



	public GTable(final PagingTableModel dm,int rowHeight,int headerHeight,JButton up,JButton down,JTextField p){
		super(dm);

		pageUp = up;
		pageDown = down;
		page = p;

		this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		TableUtility.setFont(this);
		TableUtility.setTableColor(this);
		TableUtility.setTableRowHeight(this, rowHeight);
		TableUtility.setTableHeaderHeight(this, headerHeight);


		//		int col = this.getColumnModel().getColumnCount();
		//		for(int i=0;i<col;i++){
		//			this.getColumnModel().getColumn(i).setPreferredWidth(50);
		//			this.getColumnModel().getColumn(i).setMaxWidth(50);
		//			this.getColumnModel().getColumn(i).setMinWidth(50);
		//		}

		fitTableColumns(this);

		this.getTableHeader().addMouseListener(new HeaderListener());

	}

	public GTable(final PagingTableModel dm,int rowHeight,int headerHeight,JButton up,JButton down,JTextField p,boolean sortable){
		super(dm);

		pageUp = up;
		pageDown = down;
		page = p;

		fit = sortable;

		this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		TableUtility.setFont(this);
		TableUtility.setTableColor(this);
		TableUtility.setTableRowHeight(this, rowHeight);
		TableUtility.setTableHeaderHeight(this, headerHeight);

		if(fit){
			fitTableColumns(this);
		}

		//		this.getTableHeader().addMouseListener(new HeaderListener());

	}

	public void fitTableColumns(JTable myTable){
		myTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JTableHeader header = myTable.getTableHeader();
		int rowCount = myTable.getRowCount();
		Enumeration columns = myTable.getColumnModel().getColumns();
		while(columns.hasMoreElements())
		{
			TableColumn column = (TableColumn)columns.nextElement();
			int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
			int width = (int)header.getDefaultRenderer().getTableCellRendererComponent
					(myTable, column.getIdentifier(), false, false, -1, col).getPreferredSize().getWidth();
			for(int row = 0; row < rowCount; row++)
			{
				int preferedWidth = (int)myTable.getCellRenderer(row, col).getTableCellRendererComponent
						(myTable, myTable.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
				width = Math.max(width, preferedWidth);
			}
			header.setResizingColumn(column); // 此行很重要
			column.setWidth(width+myTable.getIntercellSpacing().width);
		}
	}

//	protected JTableHeader createDefaultTableHeader() {   
//		return new JTableHeader(columnModel) {   
//			public String getToolTipText(MouseEvent e) {   
//				String tip = null;   
//				java.awt.Point p = e.getPoint();   
//				int index = columnModel.getColumnIndexAtX(p.x);   
//				int realIndex =  columnModel.getColumn(index).getModelIndex();   
//				return "点击降序/升序";   
//			}   
//		};   
//	}   




class HeaderListener implements MouseListener{

	public void mouseClicked(MouseEvent e) {
		JTableHeader header = GTable.this.getTableHeader();
		PagingTableModel model = (PagingTableModel)GTable.this.getModel();
		int tableColumn = header.columnAtPoint(e.getPoint());//获取点击的列

		if(tableColumn!=0){  //第一列为序号不排序
			if(tableColumn == sortingCol){  //表示第二次点击，升序
				GTable.this.setModel(new PagingTableModel(TableData.ascendingSort(model.data, tableColumn)));
				sortingCol = 0;
			}else{  //第一次点击，降序
				GTable.this.setModel(new PagingTableModel(TableData.descendingSort(model.data, tableColumn)));
				sortingCol = tableColumn;
			}

			//重新设置翻页按钮
			PagingTableModel.setPagingButton(GTable.this, pageUp, pageDown);

			//列宽自适应
			if(fit){
				fitTableColumns(GTable.this);
				GTable.this.repaint();
			}

			//更改页数
			model = (PagingTableModel)GTable.this.getModel();
			page.setText(String.valueOf(model.getPageOffset()+1));

			MainUI.getMainFrame().repaint();
		}
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		GTable.this.getTableHeader().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}


}
