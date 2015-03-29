package presentation.component;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JTable;
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

	public GTable(PagingTableModel dm,JButton up,JButton down){
		this(dm,32,30,up,down);
	}

	public GTable(final PagingTableModel dm,int rowHeight,int headerHeight,JButton up,JButton down){
		super(dm);
		
		pageUp = up;
		pageDown = down;
		
		this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		TableUtility.setFont(this);
		TableUtility.setTableColor(this);
		TableUtility.setTableRowHeight(this, rowHeight);
		TableUtility.setTableHeaderHeight(this, headerHeight);
		
		fitTableColumns(this);

		this.getTableHeader().addMouseListener(new HeaderListener());

	}
	
	public void fitTableColumns(JTable myTable)
    {
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
	
	
	
	class HeaderListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			JTableHeader header = GTable.this.getTableHeader();
			PagingTableModel model = (PagingTableModel)GTable.this.getModel();
			int tableColumn = header.columnAtPoint(e.getPoint());//获取点击的列
			GTable.this.setModel(new PagingTableModel(TableData.sort(model.data, tableColumn)));
			PagingTableModel.setPagingButton(GTable.this, pageUp, pageDown);
			MainUI.getMainFrame().repaint();
		}

		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
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
