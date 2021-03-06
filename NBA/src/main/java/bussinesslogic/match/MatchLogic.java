package bussinesslogic.match;

import java.util.ArrayList;

import rmiLink.MatchRmi;
import assistance.GetFileData;
import bslogicService.MatchInfoService;
import data.po.MatchDataPO;


/*现在因为初始化team时会初始化match信息，所以就不判断match的信息是否存入数据库*/


public class MatchLogic implements MatchInfoService{
	MatchRmi m = new MatchRmi();
	
	private boolean isExit(){
		return m.judge();
	} 
	

	//返回一个包含回合数等信息的match
	private ArrayList<MatchDataPO> getMatchDetail() {
		ArrayList<MatchDataPO> MatchList = new ArrayList<MatchDataPO>();
		GetFileData MatchReader = new GetFileData();
		String[] fileList = MatchReader.getAllMathcFielName();
		for (int i = 0; i < fileList.length; i++) {
			MatchList.add(calcuRound(MatchReader.detailMatch(fileList[i])));
		}
		System.out.println("calcuRound complete");
		MatchRmi add = new MatchRmi();
		add.addInfo(MatchList);
		System.out.println("match信息成功初始化！");
		return MatchList;
	}

	// 计算比赛双方进攻回合数
	private MatchDataPO calcuRound(MatchDataPO match) {
		match.setTeamround1(match.getShoot1() + 0.4 * match.getFT1() - 1.07
				* match.getTeam1Off() * match.getLostSH1()
				/ (match.getTeam1Off() + match.getTeam2Def()) + 1.07
				* match.getTo1());

		match.setTeamround2(match.getShoot2() + 0.4 * match.getFT2() - 1.07
				* match.getTeam2Off() * match.getLostSH2()
				/ (match.getTeam2Off() + match.getTeam1Def()) + 1.07
				* match.getTo2());
		return match;
	}

	public ArrayList<MatchDataPO> GetAllInfo() {
		if(!isExit()){
			return m.getAllInfo();
		}
		return getMatchDetail();
	}

	public ArrayList<MatchDataPO> GetInfo(String team1, String team2, String data) {
		return m.getInfo(team1, team2, data);
	}
	
	/*public static void main(String[] args) {
		MatchLogic match = new MatchLogic();
		System.out.println(match.isExit());
		System.out.println(match.GetAllInfo().size());
	}*/

}
