package data.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.po.TeamDataPO;
import dataBaseLink.TeamTableLink;
import dataService.TeamDataService;

public class TeamDataImpl extends UnicastRemoteObject implements TeamDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TeamDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	TeamTableLink pl = new TeamTableLink();
	public boolean judge() throws RemoteException{
		return pl.judge();
	}

	
	public void addInfo(TeamDataPO p) throws RemoteException{
		pl.addInfo(p);
	}

	public TeamDataPO getInfo(String name) throws RemoteException{
		return pl.getInfo(name);
	}

	public ArrayList<TeamDataPO> getAllInfo() throws RemoteException{
		return pl.getAllInfo();
	}

	public ArrayList<TeamDataPO> getFirstFifty(String orderName) throws RemoteException{
		return null;
	}
	public void addInfo(ArrayList<TeamDataPO> list) throws RemoteException {
		pl.addInfo(list);
		
	}
	public TeamDataPO GetBySN(String shortname) throws RemoteException {
		return pl.getBySN(shortname);
	}
	
	
}
