package presentation.contenui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import presentation.component.GComboBox;

public class PlayerSearchPanel extends ContentPanel{

	public JTable table;
	public JScrollPane jsp;

	public JLabel title;

	public JButton left;
	public JButton right;

	public JComboBox<String> teamSearch;
	public String[] teamSearchItem = {"全部位置","后卫","前锋","中锋"}; 

	public JTextField nameSearch;

	public JButton[] initials = new JButton[26];

	public PlayerSearchPanel(String url) {
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

		title = new JLabel("球员列表");
		title.setBounds(40, 25, 100, 20);
		panel.add(title);

		teamSearch = new GComboBox(teamSearchItem);
		teamSearch.setBounds(45, 93, 240, 30);
		panel.add(teamSearch);
		
		nameSearch = new JTextField("!!!!");
		nameSearch.setBounds(415, 93, 240, 30);
		panel.add(nameSearch);
		
		for(int i=0;i<26;i++){
			JButton bt = new JButton(String.valueOf('A'+i));
			bt.setBounds(45+30*i, 58, 25, 25);
//			bt.setFont(new Font("微软雅黑",0,8));
			initials[i] = bt;
			panel.add(bt);
		}


	}


}
