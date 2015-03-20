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
	public void addInfo(MatchDataPO p) {
		pl.addInfo(p);
	}

	public MatchDataPO getInfo(String name) {
		return pl.getInfo(name);
	}

	public ArrayList<MatchDataPO> getAllInfo() {
		return pl.getAllInfo();
	}
	

}
