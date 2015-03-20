package dataService;

import java.rmi.Remote;
import java.util.ArrayList;

import data.po.TeamDataPO;

public interface TeamDataService extends Remote{
	public void addInfo(TeamDataPO p);
	public TeamDataPO getInfo(String name);
	public ArrayList<TeamDataPO> getAllInfo();
	public ArrayList<TeamDataPO> getFirstFifty(String orderName);
}
