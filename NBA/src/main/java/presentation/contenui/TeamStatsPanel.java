package presentation.contenui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TeamStatsPanel extends ContentPanel{


	public JTable table;
	public JScrollPane jsp;

	public JLabel title;

	public JComboBox<String> dataType;

	public String[] dataTypeItem = {"场均","总数"};

	public JButton submit;

	public JButton left;
	public JButton right;

	public TeamStatsPanel(String url) {
		super(url);

		left = UIUtil.getLeftButton();
		left.setBounds(380, 495, 20, 20);
		panel.add(left);
		right = UIUtil.getRightButton();
		right.setBounds(450, 495, 20, 20);
		panel.add(right);

		PagingTableModel model = new PagingTableModel(TableData.getPlayerVO());  
		table = new JTable(model);  
		TableUtility.setFont(table);
		TableUtility.setTableColor(table);
		TableUtility.setTableRowHeight(table, 32);
		TableUtility.setTableHeaderHeight(table, 30);

		// Use our own custom scrollpane.  
		jsp = PagingTableModel.createPagingScrollPaneForTable(table,left,right);  
		jsp.setBounds(25, 144, 830, 350);
		TableUtility.setTabelPanel(jsp);

		panel.add(jsp);

		title = new JLabel("球队数据");
		title.setBounds(40, 25, 100, 20);
		panel.add(title);


		dataType = new GComboBox(dataTypeItem);
		dataType.setBounds(45, 63, 120, 30);
		panel.add(dataType);

		submit = new JButton("提交");
		submit.setBounds(720, 100, 120, 30);
		panel.add(submit);


	}
}
