package bussinesslogic.match;

import java.util.ArrayList;

import assistance.GetFileData;
import data.po.MatchDataPO;

public class MatchLogic {
	// 返回一个包含所有match的ArrayList
	public ArrayList<MatchDataPO> getAllMatch() {
		ArrayList<MatchDataPO> MatchList = new ArrayList<MatchDataPO>();
		GetFileData MatchReader = new GetFileData();
		String[] fileList = MatchReader.getAllMathcFielName();
		for (int i = 0; i < fileList.length; i++) {
			MatchList.add(MatchReader.readMatchfile(fileList[i]));
		}
		return MatchList;
	}

	//返回一个包含回合数等信息的match
	public ArrayList<MatchDataPO> getMatchDetail() {
		ArrayList<MatchDataPO> MatchList = new ArrayList<MatchDataPO>();
		GetFileData MatchReader = new GetFileData();
		String[] fileList = MatchReader.getAllMathcFielName();
		for (int i = 0; i < fileList.length; i++) {
			MatchList.add(calcuRound(MatchReader.detailMatch(fileList[i])));
		}
		return MatchList;

	}

	// 计算比赛双方进攻回合数
	public MatchDataPO calcuRound(MatchDataPO match) {
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

}
