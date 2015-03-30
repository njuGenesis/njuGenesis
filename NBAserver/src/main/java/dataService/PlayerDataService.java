package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import data.po.PlayerDataPO;

public interface PlayerDataService extends Remote{
	public boolean judge()throws RemoteException;
	public void addInfo(PlayerDataPO p)throws RemoteException;
	public PlayerDataPO getInfo(String name)throws RemoteException;
	public PlayerDataPO[] getAllInfo()throws RemoteException;
	public void setOrder(String orderName,boolean isASC)throws RemoteException;
	public PlayerDataPO[] getFirstFifty(String orderName)throws RemoteException;
	public PlayerDataPO[] getSelect(String position ,String Union)throws RemoteException;
	public PlayerDataPO[] getSearch(String keys)throws RemoteException;
}
