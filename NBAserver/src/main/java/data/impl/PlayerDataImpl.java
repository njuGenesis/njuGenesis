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
	public void addInfo(PlayerDataPO p) throws RemoteException {
		// TODO Auto-generated method stub
		pl.addInfo(p);
	}

	public PlayerDataPO getInfo(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public PlayerDataPO[] getAllInfo() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setOrder(String orderName) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public PlayerDataPO[] getFirstFifty(String orderName)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
