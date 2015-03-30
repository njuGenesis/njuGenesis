package rmiLink;

import java.rmi.Naming;

import data.po.PlayerDataPO;
import dataService.PlayerDataService;

public class PlayerRmi {
	String ip = "rmi://127.0.0.1:3688/player";
	
	public PlayerDataPO[] getSearch(String keys){
		try {

			PlayerDataService t = (PlayerDataService) Naming.lookup(ip);
			return t.getSearch(keys);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean judge(){
		try {

			PlayerDataService t = (PlayerDataService) Naming.lookup(ip);
			return t.judge();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public void addInfo(PlayerDataPO p) {
		try {

			PlayerDataService t = (PlayerDataService) Naming.lookup(ip);
			t.addInfo(p);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public PlayerDataPO getInfo(String name) {
		try {

			PlayerDataService t = (PlayerDataService) Naming.lookup(ip);
			return t.getInfo(name);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public PlayerDataPO[] getAllInfo() {
		try {

			PlayerDataService t = (PlayerDataService) Naming.lookup(ip);
			return t.getAllInfo();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setOrder(String orderName, boolean isASC) {
		try {

			PlayerDataService t = (PlayerDataService) Naming.lookup(ip);
			t.setOrder(orderName, isASC);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public PlayerDataPO[] getFirstFifty(String orderName) {
		try {

			PlayerDataService t = (PlayerDataService) Naming.lookup(ip);
			return t.getFirstFifty(orderName);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public PlayerDataPO[] getSelect(String position, String union) {
		// TODO Auto-generated method stub
		try{
			PlayerDataService t = (PlayerDataService)Naming.lookup(ip);
			return t.getSelect(position, union);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
}
