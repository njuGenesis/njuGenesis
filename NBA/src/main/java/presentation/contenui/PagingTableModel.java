package presentation.contenui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class PagingTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;


	protected int pageSize;  //页数
	protected int pageOffset;  //当前页数

	public TableData[] data;  //表格数据
	
	

	public PagingTableModel(TableData[] data){
		this(10,data);
	}

	public PagingTableModel(int size,TableData[] data){
		pageSize = size;  
		this.data = data;
	}

	public int getColumnCount() {
		if(data.length!=0){
			return data[0].getColumnCount();
		}else{
			return 30;
		}
	}

	public String getColumnName(int col) {  
		if(data.length!=0){
			return data[0].getColumnName(col);
		}else{
			return "";
		}
	}  

	public int getRowCount() {
		int count = data.length;  
		if (pageOffset == getPageCount() - 1) {  
			count = data.length - pageOffset * pageSize;  
		}  
		return Math.min(pageSize, count); 
	}

	//仅显示表格的可见部分
	public Object getValueAt(int row, int col) {
		int realRow = row + (pageOffset * pageSize);  
		return data[realRow].getValueAt(col);

	}

	public int getPageCount() {  
		return (int) Math.ceil((double) data.length / pageSize);  
	} 

	//返回当前所在页数
	public int getPageOffset() {  
		return pageOffset;  
	}

	// Use this method if you want to know how big the real table is . . . we  
	// could also write "getRealValueAt()" if needed.  
	public int getRealRowCount() {  
		return data.length;  
	}  

	public int getPageSize() {  
		return pageSize;  
	}

	public void setPageSize(int s) {  
		if (s == pageSize) {  
			return;  
		}  
		int oldPageSize = pageSize;  
		pageSize = s;  
		pageOffset = (oldPageSize * pageOffset) / pageSize;  
		fireTableDataChanged();  
		/* 
		 * if (pageSize < oldPageSize) { fireTableRowsDeleted(pageSize, oldPageSize - 1); } else { fireTableRowsInserted(oldPageSize, pageSize - 1); } 
		 */  
	} 

	// Update the page offset and fire a data changed (all rows).  
	public void pageDown() {  
		if (pageOffset < getPageCount() - 1) {  
			pageOffset++;  
			fireTableDataChanged();  
		}  
	} 

	// Update the page offset and fire a data changed (all rows).  
	public void pageUp() {  
		if (pageOffset > 0) {  
			pageOffset--;  
			fireTableDataChanged();  
		}  
	} 


	// We provide our own version of a scrollpane that includes  
	// the page up and page down buttons by default.  
	public static JScrollPane createPagingScrollPaneForTable(JTable jt) {  
		JScrollPane jsp = new JScrollPane(jt);  
		TableModel tmodel = jt.getModel();  

		// Don't choke if this is called on a regular table . . .  
		if (!(tmodel instanceof PagingTableModel)) {  
			return jsp;  
		}  

		// Okay, go ahead and build the real scrollpane  
		final PagingTableModel model = (PagingTableModel) tmodel;  
		final JButton upButton = new JButton(new ArrowIcon(ArrowIcon.UP));  
		upButton.setEnabled(false); // starts off at 0, so can't go up  
		final JButton downButton = new JButton(new ArrowIcon(ArrowIcon.DOWN));  
		if (model.getPageCount() <= 1) {  
			downButton.setEnabled(false); // One page...can't scroll down  
		}  

		upButton.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent ae) {  
				model.pageUp();  

				// If we hit the top of the data, disable the up button.  
				if (model.getPageOffset() == 0) {  
					upButton.setEnabled(false);  
				}  
				downButton.setEnabled(true);  
			}  
		});  

		downButton.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent ae) {  
				model.pageDown();  

				// If we hit the bottom of the data, disable the down button.  
				if (model.getPageOffset() == (model.getPageCount() - 1)) {  
					downButton.setEnabled(false);  
				}  
				upButton.setEnabled(true);  
			}  
		});  

		// Turn on the scrollbars; otherwise we won't get our corners.  
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);  
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);  

		// Add in the corners (page up/down).  
		jsp.setCorner(ScrollPaneConstants.UPPER_RIGHT_CORNER, upButton);  
		jsp.setCorner(ScrollPaneConstants.LOWER_RIGHT_CORNER, downButton);  

		return jsp;  
	}  



	public static JScrollPane createPagingScrollPaneForTable(JTable jt,JButton up,JButton down) {  
		JScrollPane jsp = new JScrollPane(jt);  
		TableModel tmodel = jt.getModel();  
		
		// Don't choke if this is called on a regular table . . .  
		if (!(tmodel instanceof PagingTableModel)) {  
			return jsp;  
		}  

		// Okay, go ahead and build the real scrollpane  
		final PagingTableModel model = (PagingTableModel) tmodel;  
		final JButton upButton = up;  
		upButton.setEnabled(false); // starts off at 0, so can't go up  
		final JButton downButton = down;  
		if (model.getPageCount() <= 1) {  
			downButton.setEnabled(false); // One page...can't scroll down  
		}  

		upButton.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent ae) {  
				model.pageUp();  

				// If we hit the top of the data, disable the up button.  
				if (model.getPageOffset() == 0) {  
					upButton.setEnabled(false);  
				}  
				downButton.setEnabled(true);  
			}  
		});  

		downButton.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent ae) {  
				model.pageDown();  

				// If we hit the bottom of the data, disable the down button.  
				if (model.getPageOffset() == (model.getPageCount() - 1)) {  
					downButton.setEnabled(false);  
				}  
				upButton.setEnabled(true);  
			}  
		});  

		// Turn on the scrollbars; otherwise we won't get our corners.  
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);  
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);  

		return jsp;  
	}


	public static void setPagingButton(JTable jt,JButton up,JButton down){
		TableModel tmodel = jt.getModel();  

		final PagingTableModel model = (PagingTableModel) tmodel;  
		final JButton upButton = up;  
		upButton.setEnabled(false); // starts off at 0, so can't go up  
		final JButton downButton = down;  
		if (model.getPageCount() <= 1) {  
			downButton.setEnabled(false); // One page...can't scroll down  
		}  

		upButton.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent ae) {  
				model.pageUp();  

				// If we hit the top of the data, disable the up button.  
				if (model.getPageOffset() == 0) {  
					upButton.setEnabled(false);  
				}  
				downButton.setEnabled(true);  
			}  
		});  

		downButton.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent ae) {  
				model.pageDown();  

				// If we hit the bottom of the data, disable the down button.  
				if (model.getPageOffset() == (model.getPageCount() - 1)) {  
					downButton.setEnabled(false);  
				}  
				upButton.setEnabled(true);  
			}  
		});  
	}
	
	public void setButton(JButton up,JButton down){
		JButton upButton = up;  
		upButton.setEnabled(false); // starts off at 0, so can't go up  
		JButton downButton = down;  
//		System.out.println("总页数"+this.getPageCount());
		if (this.getPageCount() <= 1) {  
			downButton.setEnabled(false); // One page...can't scroll down  
		}  

		for(int i=0;i<upButton.getActionListeners().length;i++){
			upButton.removeActionListener(upButton.getActionListeners()[i]);
		}
		upButton.addActionListener(new UpListener(up,down));  

		for(int i=0;i<downButton.getActionListeners().length;i++){
			downButton.removeActionListener(downButton.getActionListeners()[i]);
		}
		downButton.addActionListener(new DownListener(up,down));  
	}
	
	public void checkButton(JButton up,JButton down){
		if (this.getPageOffset() == (this.getPageCount() - 1)) {  
			down.setEnabled(false);  
		}else{
			down.setEnabled(true);  
		}
		
		if (PagingTableModel.this.getPageOffset() == 0) {  
			up.setEnabled(false);  
		}else{
			up.setEnabled(true);  
		}
	}


	class DownListener implements ActionListener{
		
		JButton up;
		JButton down;
		
		public DownListener(JButton up,JButton down){
			this.up = up;
			this.down = down;
		}

		public void actionPerformed(ActionEvent e) {
			PagingTableModel.this.pageDown();  
			
//			System.out.println("当前"+PagingTableModel.this.getPageOffset()+"总"+PagingTableModel.this.getPageCount());

			// If we hit the bottom of the data, disable the down button.  
			if (PagingTableModel.this.getPageOffset() == (PagingTableModel.this.getPageCount() - 1)) {  
				down.setEnabled(false);  
			}  
			up.setEnabled(true);  
		}
		
	}

	class UpListener implements ActionListener{
		
		JButton up;
		JButton down;
		
		public UpListener(JButton up,JButton down){
			this.up = up;
			this.down = down;
		}

		public void actionPerformed(ActionEvent e) {
			PagingTableModel.this.pageUp();  
			
//			System.out.println("当前"+PagingTableModel.this.getPageOffset());
			
			// If we hit the top of the data, disable the up button.  
			if (PagingTableModel.this.getPageOffset() == 0) {  
				up.setEnabled(false);  
			}  
			down.setEnabled(true); 
		}
		
	}
	
	

}








class ArrowIcon implements Icon {  

	public static final int UP = 0;  

	public static final int DOWN = 1;  

	private int direction;  

	private Polygon pagePolygon = new Polygon(new int[] { 2, 4, 4, 10, 10, 2 }, new int[] { 4, 4, 2, 2, 12, 12 }, 6);  

	private int[] arrowX = { 4, 9, 6 };  

	private Polygon arrowUpPolygon = new Polygon(arrowX, new int[] { 10, 10, 4 }, 3);  

	private Polygon arrowDownPolygon = new Polygon(arrowX, new int[] { 6, 6, 11 }, 3);  

	public ArrowIcon(int which) {  
		direction = which;  
	}  

	public int getIconWidth() {  
		return 14;  
	}  

	public int getIconHeight() {  
		return 14;  
	}  

	public void paintIcon(Component c, Graphics g, int x, int y) {  
		g.setColor(Color.black);  
		pagePolygon.translate(x, y);  
		g.drawPolygon(pagePolygon);  
		pagePolygon.translate(-x, -y);  
		if (direction == UP) {  
			arrowUpPolygon.translate(x, y);  
			g.fillPolygon(arrowUpPolygon);  
			arrowUpPolygon.translate(-x, -y);  
		} else {  
			arrowDownPolygon.translate(x, y);  
			g.fillPolygon(arrowDownPolygon);  
			arrowDownPolygon.translate(-x, -y);  
		}  
	}

}
