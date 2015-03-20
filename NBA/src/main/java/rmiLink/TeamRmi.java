package rmiLink;

import java.rmi.Naming;
import java.util.ArrayList;

import data.po.TeamDataPO;
import dataService.TeamDataService;

public class TeamRmi {
	String ip = "rmi://127.0.0.1:3688/player";

	public void addInfo(TeamDataPO p) {
		try {
			TeamDataService t = (TeamDataService) Naming.lookup(ip);
			t.addInfo(p);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public TeamDataPO getInfo(String name) {
		try {
			TeamDataService t = (TeamDataService) Naming.lookup(ip);
			return t.getInfo(name);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<TeamDataPO> getAllInfo() {
		try {
			TeamDataService t = (TeamDataService) Naming.lookup(ip);
			return t.getAllInfo();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<TeamDataPO> getFirstFifty(String orderName) {
		try {

			TeamDataService t = (TeamDataService) Naming.lookup(ip);
			return t.getFirstFifty(orderName);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
