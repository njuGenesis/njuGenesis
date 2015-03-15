package data.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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

}
