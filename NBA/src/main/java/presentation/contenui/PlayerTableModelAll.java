package presentation.contenui;

import java.util.ArrayList;

import data.po.PlayerDataPO;

public class PlayerTableModelAll extends PlayerTableModel{

	protected String[] tableTitle = {"排名","球员"};


	public PlayerTableModelAll(ArrayList<PlayerDataPO> list) {
		super(list);
	}



	//----------表格的值----------
	public Object getValueAt(int arg0, int arg1) {
		
		PlayerDataPO player = playerList.get(arg0);
		
		switch(arg1){
		case 0:return arg0+1;
		case 1:
		case 2:
		default:

		}


		return null;
	}

}
