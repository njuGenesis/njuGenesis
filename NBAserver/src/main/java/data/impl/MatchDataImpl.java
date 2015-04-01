package data.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.po.MatchDataPO;
import dataBaseLink.MatchTableLink;
import dataService.MatchDataService;

public class MatchDataImpl extends UnicastRemoteObject implements MatchDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MatchDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	MatchTableLink pl = new MatchTableLink();
	public boolean judge() throws RemoteException{
		return pl.judge();
	}
	public void addInfo(MatchDataPO p) {
		pl.addInfo(p);
	}
	

	public ArrayList<MatchDataPO> getInfo(String team1,String team2,String data) {
		return pl.getInfo(team1, team2, data);
	}

	public ArrayList<MatchDataPO> getAllInfo() {
		return pl.getAllInfo();
	}
	public void addInfo(ArrayList<MatchDataPO> p) throws RemoteException {
		pl.addInfo(p);
		
	}
	

}
