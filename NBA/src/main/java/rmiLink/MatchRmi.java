package rmiLink;

import java.rmi.Naming;
import java.util.ArrayList;

import data.po.MatchDataPO;
import dataService.MatchDataService;

public class MatchRmi {
	String ip = "rmi://127.0.0.1:3688/match";

	public boolean judge(){
		try {

			MatchDataService t = (MatchDataService) Naming.lookup(ip);
			return t.judge();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void addInfo(MatchDataPO p) {
		try {

			MatchDataService t = (MatchDataService) Naming.lookup(ip);
			t.addInfo(p);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	public void addInfo(ArrayList<MatchDataPO> p) {
		try {

			MatchDataService t = (MatchDataService) Naming.lookup(ip);
			t.addInfo(p);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	

	public ArrayList<MatchDataPO> getInfo(String team1,String team2,String data) {
		try {

			MatchDataService t = (MatchDataService) Naming.lookup(ip);
			return t.getInfo( team1, team2, data);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<MatchDataPO> getAllInfo() {
		try {

			MatchDataService t = (MatchDataService) Naming.lookup(ip);
			return t.getAllInfo();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}



}
