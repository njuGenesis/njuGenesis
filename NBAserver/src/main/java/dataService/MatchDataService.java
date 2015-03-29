package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import data.po.MatchDataPO;

public interface MatchDataService extends Remote{
	public boolean judge()throws RemoteException;
	
	public void addInfo(MatchDataPO p)throws RemoteException;
	
	public void addInfo(ArrayList<MatchDataPO> p)throws RemoteException;

	public ArrayList<MatchDataPO> getInfo(String team1,String team2,String data)throws RemoteException;

	public ArrayList<MatchDataPO> getAllInfo()throws RemoteException;
}
