package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TeamDataService extends Remote{
	public void getTeamBasicData(String name)throws RemoteException;
	public void getTeamHideData(String name)throws RemoteException;
}
