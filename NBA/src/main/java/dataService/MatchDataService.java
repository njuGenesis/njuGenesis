package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import data.po.MatchDataPO;


public interface MatchDataService extends Remote{

	public void addInfo(MatchDataPO p)throws RemoteException;

	public MatchDataPO getInfo(String name)throws RemoteException;

	public ArrayList<MatchDataPO> getAllInfo()throws RemoteException;

	
	
}
