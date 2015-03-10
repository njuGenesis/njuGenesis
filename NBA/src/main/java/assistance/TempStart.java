package assistance;

import data.po.MatchDataPO;

public class TempStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetFileData g = new GetFileData();
		MatchDataPO m = g.readMatchfile("D:/学习/软工3/CSEIII data/迭代一数据/matches/13-14_01-01_CHA-LAC");
		for(int i = 0;i<m.firstTeamInfo.size();i++){
			System.out.println(m.firstTeamInfo.get(i));
		}
		for(int i = 0;i<m.secondTeamInfo.size();i++){
			System.out.println(m.secondTeamInfo.get(i));
		}
		System.out.println(m.getFirst_pts());
		System.out.println(m.getFirstteam());
		System.out.println(m.getSecondteam());
	}

}
