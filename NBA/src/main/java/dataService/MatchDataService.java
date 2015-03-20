package dataService;

import java.rmi.Remote;
import java.util.ArrayList;

import data.po.MatchDataPO;


public interface MatchDataService extends Remote{

	public void addInfo(MatchDataPO p);

	public MatchDataPO getInfo(String name);

	public ArrayList<MatchDataPO> getAllInfo();

	
	
}
