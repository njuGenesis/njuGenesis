package data.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import data.po.PlayerDataPO;
import dataBaseLink.PlayerTableLink;
import dataService.PlayerDataService;

public class PlayerDataImpl extends UnicastRemoteObject implements PlayerDataService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PlayerDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	PlayerTableLink pl = new PlayerTableLink();
	public boolean judge() throws RemoteException{
		return pl.judge();
	}
	
	
	public void addInfo(PlayerDataPO p) throws RemoteException {
		// TODO Auto-generated method stub
		pl.addInfo(p);
	}

	public PlayerDataPO getInfo(String name) throws RemoteException {
		// TODO Auto-generated method stub
		PlayerDataPO res = pl.getInfo(name);
		return res;
	}

	public PlayerDataPO[] getAllInfo() throws RemoteException {
		// TODO Auto-generated method stub
		PlayerDataPO[] res = pl.getAllInfo();
		return res;
	}

	public void setOrder(String orderName,boolean isASC) throws RemoteException {
		// TODO Auto-generated method stub
		//pl.setOrder(orderName, isASC);
	}

	public PlayerDataPO[] getFirstFifty(String orderName)
			throws RemoteException {
		// TODO Auto-generated method stub
		//PlayerDataPO[] res = pl.getFirstFifty(orderName);
		return null;
	}


	public PlayerDataPO[] getSelect(String position, String Union)
			throws RemoteException {
		// TODO Auto-generated method stub
		PlayerDataPO[] res = pl.getSelect(position,Union);
		return res;
	}


	public PlayerDataPO[] getSearch(String keys) throws RemoteException {
		// TODO Auto-generated method stub
		PlayerDataPO[] res = pl.getSearch(keys);
		return res;
	}

}
