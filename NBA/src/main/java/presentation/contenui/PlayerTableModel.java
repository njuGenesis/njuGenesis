package presentation.contenui;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import data.po.PlayerDataPO;

public class PlayerTableModel implements TableModel{

	protected ArrayList<PlayerDataPO> playerList;
	protected String[] tableTitle = {"1","1","1","1","1","1","1","1","1","1","1"};

	public PlayerTableModel(ArrayList<PlayerDataPO> list){
		playerList = list;
	}


	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub

	}

	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub

	}

	public Class<?> getColumnClass(int arg0) {
		// TODO Auto-generated method stub
		return String.class;
	}


	//----------列数：第一列显示排名，然后是球员名称等信息----------
	public int getColumnCount() {
		return 30;
	}


	//----------列名----------
	public String getColumnName(int arg0) {
		if(arg0<tableTitle.length){
			return tableTitle[arg0];
		}else{
			return "";
		}
	}

	//----------行数----------
	public int getRowCount() {
		return playerList.size();
	}

	//----------表格的值----------
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	//----------是否可编辑----------
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}

	//----------改变表格值后的的操作----------
	public void setValueAt(Object arg0, int arg1, int arg2) {
	}

}
