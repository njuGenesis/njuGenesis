package rmiLink;

import java.rmi.Naming;
import java.util.ArrayList;

import data.po.MatchDataPO;
import dataService.MatchDataService;

public class MatchRmi {
	String ip = "rmi://127.0.0.1:3688/match";

	public void addInfo(MatchDataPO p) {
		try {

			MatchDataService t = (MatchDataService) Naming.lookup(ip);
			t.addInfo(p);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public MatchDataPO getInfo(String name) {
		try {

			MatchDataService t = (MatchDataService) Naming.lookup(ip);
			return t.getInfo(name);

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
