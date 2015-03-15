package data.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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

}
