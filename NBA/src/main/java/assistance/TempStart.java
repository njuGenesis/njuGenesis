package assistance;

import bussinesslogic.player.PlayerLogic;
import data.po.MatchDataPO;
import data.po.PlayerDataPO;

public class TempStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlayerLogic p = new PlayerLogic();
		p.analysData("Aaron Brooks");
		p.getAllMatch("D:/学习/软工3/CSEIII data/迭代一数据/matches", "Aaron Brooks");
		PlayerDataPO t = p.getpo();
		System.out.println(t.getMPG());
	}

}
