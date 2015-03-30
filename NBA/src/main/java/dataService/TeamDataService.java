package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import data.po.TeamDataPO;

public interface TeamDataService extends Remote {
	public boolean judge()throws RemoteException;
	public void addInfo(TeamDataPO p)throws RemoteException;
	public void addInfo(ArrayList<TeamDataPO> list)throws RemoteException;
	public TeamDataPO getInfo(String name)throws RemoteException;

	public ArrayList<TeamDataPO> getAllInfo()throws RemoteException;
	
	public TeamDataPO GetBySN(String shortname)throws RemoteException;
	
	public ArrayList<TeamDataPO> getFirstFifty(String orderName)throws RemoteException;
}
