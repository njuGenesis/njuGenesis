package dataBaseLink;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import data.impl.MatchDataImpl;
import data.impl.PlayerDataImpl;
import data.impl.TeamDataImpl;
import dataService.MatchDataService;
import dataService.PlayerDataService;
import dataService.TeamDataService;

public class RmiStart {
	public static boolean connect(String address){
		String ip = "rmi://"+address+":3688/";
		try{
			PlayerDataService p = new PlayerDataImpl();
			LocateRegistry.createRegistry(3688);
			Naming.rebind(ip + "player", p);
			
			TeamDataService t = new TeamDataImpl();
			Naming.rebind(ip + "team", t);
			
			
			MatchDataService m = new MatchDataImpl();
			Naming.rebind(ip + "match", m);
			
			return true;
		}catch (MalformedURLException e)
        {
            e.printStackTrace();
            return false;
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
            return false;
        }
	}
	public static void main(String[] arg0){
		connect("127.0.0.1");
	}
}
