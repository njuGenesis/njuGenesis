package rmiLink;

import java.rmi.Naming;
import data.po.PlayerDataPO;
import dataService.PlayerDataService;


public class PlayerRmi {
	String ip = "rmi://127.0.0.1:3688/test";
	public void addInfo(PlayerDataPO p){
		 try{
			
				PlayerDataService t = (PlayerDataService)Naming.lookup(ip);
				t.addInfo(p);
				
			}catch(Exception e){
				e.printStackTrace();
				
			}
	}
	public PlayerDataPO getInfo(String name){
		try{
		 	
			PlayerDataService t = (PlayerDataService)Naming.lookup(ip);
			return t.getInfo(name);
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public PlayerDataPO[] getAllInfo(){
		try{
		 	
			PlayerDataService t = (PlayerDataService)Naming.lookup(ip);
			return t.getAllInfo();
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public void setOrder(String orderName){
try{
		 	
			PlayerDataService t = (PlayerDataService)Naming.lookup(ip);
			t.setOrder(orderName);
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
	public PlayerDataPO[] getFirstFifty(String orderName){
try{
		 	
			PlayerDataService t = (PlayerDataService)Naming.lookup(ip);
			return t.getFirstFifty(orderName);
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
