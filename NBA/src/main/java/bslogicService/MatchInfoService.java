package bslogicService;

import java.util.ArrayList;

import data.po.MatchDataPO;


public interface MatchInfoService {
	public ArrayList<MatchDataPO> GetAllInfo();
	public ArrayList<MatchDataPO> GetInfo(String team1,String team2,String data);  //team1为主队  team2位客队
}
