package bussinesslogic.team;

import java.util.ArrayList;

import assistance.GetFileData;
import bussinesslogic.match.MatchLogic;
import bussinesslogic.player.PlayerLogic;
import data.po.MatchDataPO;
import data.po.PlayerDataPO;
import data.po.TeamDataPO;

public class TeamLogic {
	ArrayList<TeamDataPO> Teams;
	// 初始化所有队伍所拥有的球员信息
	public void savePlayerData(PlayerDataPO[] players) {
		for (int i = 0; i < players.length; i++) {
			for (int k = 0; k < Teams.size(); k++) {
				if (players[i].getTeamName().equals(Teams.get(k).getName())) {
					Teams.get(k).setPlayers(Teams.get(k).getPlayers()+players[i].getName()+";");
				}
			}
		}
	}

	// players是所有球员信息的集合，循环访问，根据球员的队名更新球队信息
	public void saveTeamData(PlayerDataPO[] players) {
		for (int i = 0; i < players.length; i++) {
			for (int k = 0; players[i].getTeamName() != Teams.get(k)
					.getName(); k++) {
				updateTeamData(k, players[i]);
			}
		}
	}

	public void updateTeamData(int teamNumber, PlayerDataPO player) {
		TeamDataPO upTeam = Teams.get(teamNumber);

		if (!upTeam.getPlayers().contains(player.getName())) {
			upTeam.setPlayers(upTeam.getPlayers()+player.getName()+";");
		}
		upTeam.setShootNumber(upTeam.getShootNumber()
				+ player.getTotalFieldGoal()); // 投篮总数，场均数
		upTeam.setShootNumberPG(upTeam.getShootNumber()
				/ upTeam.getMatchNumber());

		upTeam.setShootEffNumber(upTeam.getShootEffNumber()
				+ player.getFieldGoal()); // 投篮命中总数，场均数
		upTeam.setShootEffNumberPG(upTeam.getShootEffNumber()
				/ upTeam.getMatchNumber());
		upTeam.setShootEff(upTeam.getShootEffNumber() / upTeam.getShootNumber()); // 投篮进球率

		// -------------------------------------------------------------------------------------------------------

		upTeam.setTPNumber(upTeam.getTPNumber() + player.getTotalThreeGoal()); // 总三分投篮书，场均数
		upTeam.setTPNumberPG(upTeam.getTPNumber() / upTeam.getMatchNumber());

		upTeam.setTPEffNumber(upTeam.getTPEffNumber() + player.getThreeGoal());// 总三分命中书，场均数
		upTeam.setTPEffNumberPG(upTeam.getTPEffNumber()
				/ upTeam.getMatchNumber());

		upTeam.setTPEff(upTeam.getTPEffNumber() / upTeam.getTPNumber()); // 三分进球率

		// -------------------------------------------------------------------------------------------------------

		upTeam.setFTNumber(upTeam.getFTNumber() + player.getTotalFT()); // 总罚球投篮书，场均
		upTeam.setFTNumberPG(upTeam.getFTNumber() / upTeam.getMatchNumber());

		upTeam.setFTEffNumber(upTeam.getFTEffNumber() + player.getFT());// 总罚球命中书，场均数
		upTeam.setFTEffNumberPG(upTeam.getFTEffNumber()
				/ upTeam.getMatchNumber());

		upTeam.setFTEff(upTeam.getFTEffNumber() / upTeam.getFTNumber()); // 罚球进球率

		// -------------------------------------------------------------------------------------------------------

		upTeam.setOffBackBoard(upTeam.getOffBackBoard() + player.getOff()); // 总进攻篮板数
		upTeam.setOffBackBoardPG(upTeam.getOffBackBoard()
				/ upTeam.getMatchNumber());

		upTeam.setDefBackBoard(upTeam.getDefBackBoard() + player.getDef()); // 总防守篮板数
		upTeam.setDefBackBoardPG(upTeam.getDefBackBoard()
				/ upTeam.getMatchNumber());

		upTeam.setBackBoard(upTeam.getBackBoard() + player.getBackboard()); // 总篮板数
		upTeam.setBackBoardPG(upTeam.getBackBoard() / upTeam.getMatchNumber());

		upTeam.setBackBoardEff(upTeam.getBackBoardEff()
				+ player.getBackboardEff() * player.getMinutesOnField() * 5); // 总篮板率

		/*upTeam.setOffBackBoardEff(upTeam.getOffBackBoardEff()
				+ player.getOffBEff() * player.getMinutesOnField() * 5); // 进攻总篮板率

		upTeam.setDefBackBoardEff(upTeam.getDefBackBoardEff()
				+ player.getDefBEff() * player.getMinutesOnField() * 5); // 防守篮板率
*/
		upTeam.setAssitNumber(upTeam.getAssitNumber() + player.getAssist()); // 总助攻数
		upTeam.setAssitNumberPG(upTeam.getAssitNumber()
				/ upTeam.getMatchNumber());

		upTeam.setStealNumber(upTeam.getStealNumber() + player.getSteal()); // 总抢断数
		upTeam.setStealNumberPG(upTeam.getStealNumber()
				/ upTeam.getMatchNumber());

		upTeam.setRejection(upTeam.getRejection() + player.getRejection()); // 总盖帽数
		upTeam.setRejectionPG(upTeam.getRejection() / upTeam.getMatchNumber());

		upTeam.setTo(upTeam.getTo() + player.getTo()); // 总失误数
		upTeam.setToPG(upTeam.getTo() / upTeam.getMatchNumber());

		upTeam.setFoul(upTeam.getFoul() + player.getFoul()); // 总犯规数
		upTeam.setFoulPG(upTeam.getFoul() / upTeam.getMatchNumber());

		/*
		 * upTeam.setPTS(upTeam.getPTS() + player.getPTS()); // 总得分数
		 * upTeam.setPPG(upTeam.getPTS() / upTeam.getMatchNumber());
		 */

		Teams.set(teamNumber, upTeam); // 更新原队伍信息

	}

	// 球队名称，所在地等从teams文件里直接读取的信息
	public void initTeamData() {
		GetFileData MatchFileReader = new GetFileData();
		Teams = MatchFileReader.readTeamfile(); // 球队基本信息初始化
		MatchLogic matchLogic = new MatchLogic();
		ArrayList<MatchDataPO> Matches = matchLogic.getAllMatch(); // 一个含有全部比赛基本信息的集合
		for (int i = 0; i < Matches.size(); i++) {
			calcuPoints(Matches.get(i).getPoints(), Matches.get(i)
					.getFirstteam(), Matches.get(i).getSecondteam());
		}

		Matches = matchLogic.getMatchDetail();
		for (int i = 0; i < Matches.size(); i++) {
			calcuRate(Matches.get(i), Matches.get(i).getFirstteam(), Matches
					.get(i).getSecondteam());
		}
	}

	// 计算球队的比赛场数，总得分和均分
	public void calcuPoints(String points, String team1, String team2) {
		String[] point = points.split("-");
		for (int i = 0; i < Teams.size(); i++) {
			if (Teams.get(i).getShortName().equals(team1)) {
				Teams.get(i).setMatchNumber(Teams.get(i).getMatchNumber() + 1); // 比赛场数+1
				if (point[0].compareTo(point[1]) >= 0) {
					Teams.get(i).setWinMatch(Teams.get(i).getWinMatch() + 1);
				}
				Teams.get(i).setWR(
						Teams.get(i).getWinMatch()
								/ Teams.get(i).getMatchNumber());// 胜率

				Teams.get(i).setPTS(
						Teams.get(i).getPTS() + Integer.parseInt(point[0])); // 球队1总得分

				Teams.get(i).setPPG(
						Teams.get(i).getPTS() / Teams.get(i).getMatchNumber());// 均分

				Teams.get(i).setLPS(
						Teams.get(i).getLPS() + Integer.parseInt(point[1])); // 球队1总失分

				Teams.get(i).setLPG(
						Teams.get(i).getLPS() / Teams.get(i).getMatchNumber());// 均失分

			} else if (Teams.get(i).getShortName().equals(team2)) {
				Teams.get(i).setMatchNumber(Teams.get(i).getMatchNumber() + 1); // 比赛场数+1
				if (point[0].compareTo(point[1]) <= 0) {
					Teams.get(i).setWinMatch(Teams.get(i).getWinMatch() + 1);
				}
				Teams.get(i).setWR(
						Teams.get(i).getWinMatch()
								/ Teams.get(i).getMatchNumber());
				Teams.get(i).setPTS(
						Teams.get(i).getPTS() + Integer.parseInt(point[1]));// 球队2总得分
				Teams.get(i).setPPG(
						Teams.get(i).getPTS() / Teams.get(i).getMatchNumber());// 均分

				Teams.get(i).setLPS(
						Teams.get(i).getLPS() + Integer.parseInt(point[0])); // 球队2总失分

				Teams.get(i).setLPG(
						Teams.get(i).getLPS() / Teams.get(i).getMatchNumber());// 均失分
			}
		}
	}

	// 计算和回合数相关的rate
	public void calcuRate(MatchDataPO match, String team1, String team2) {
		for (int i = 0; i < Teams.size(); i++) {
			if (Teams.get(i).getShortName().equals(team1)) {
				Teams.get(i).setOff(
						Teams.get(i).getOff() + match.getTeamround1()); // 进攻，防守回合总数
				Teams.get(i).setDef(
						Teams.get(i).getDef() + match.getTeamround2());

				Teams.get(i).setOffBackBoard(
						Teams.get(i).getOffBackBoard() + match.getTeam1Off()); // 总前场篮板和对手前场篮板
				Teams.get(i).setOtherOffBoard(
						Teams.get(i).getOtherOffBoard() + match.getTeam2Off());

				Teams.get(i).setDefBackBoard(
						Teams.get(i).getDefBackBoard() + match.getTeam1Def()); // 总后场篮板和对手后场篮板
				Teams.get(i).setOtherDefBoard(
						Teams.get(i).getOtherDefBoard() + match.getTeam2Def());

			} else if (Teams.get(i).getShortName().equals(team2)) {
				Teams.get(i).setOff(
						Teams.get(i).getOff() + match.getTeamround2());    // 进攻，防守回合总数
				Teams.get(i).setDef(
						Teams.get(i).getDef() + match.getTeamround1());
				Teams.get(i).setOffPG(
						Teams.get(i).getOff() / Teams.get(i).getMatchNumber());

				Teams.get(i).setOffBackBoard(
						Teams.get(i).getOffBackBoard() + match.getTeam2Off()); // 总前场篮板和对手前场篮板
				Teams.get(i).setOtherOffBoard(
						Teams.get(i).getOtherOffBoard() + match.getTeam1Off());

				Teams.get(i).setDefBackBoard(
						Teams.get(i).getDefBackBoard() + match.getTeam2Def()); // 总后场篮板和对手后场篮板
				Teams.get(i).setOtherDefBoard(
						Teams.get(i).getOtherDefBoard() + match.getTeam1Def());

			}

			Teams.get(i).setOffPG(
					Teams.get(i).getOff() / Teams.get(i).getMatchNumber());// 进攻场均回合数

			Teams.get(i).setOffEff(
					Teams.get(i).getPTS() * 100 / Teams.get(i).getOff()); // 进攻、防守效率
			Teams.get(i).setDefEff(
					Teams.get(i).getLPS() * 100 / Teams.get(i).getDef());

			Teams.get(i)
					.setStealEff(
							Teams.get(i).getStealNumber() * 100
									/ Teams.get(i).getDef()); // 抢断效率
			Teams.get(i)
					.setAssistEff(
							Teams.get(i).getAssitNumber() * 100
									/ Teams.get(i).getOff()); // 助攻效率

			Teams.get(i).setOffBackBoardEff(
					Teams.get(i).getOffBackBoard()
							/ (Teams.get(i).getOffBackBoard() + Teams.get(i)
									.getOtherDefBoard()));
			Teams.get(i).setDefBackBoardEff(
					Teams.get(i).getDefBackBoard()
							/ (Teams.get(i).getDefBackBoard() + Teams.get(i)
									.getOtherOffBoard()));
			
			System.out.println(Teams.get(i).getName()+"  "+Teams.get(i).getOffBackBoardEff());
		}
	}

	public static void main(String[] args) {
		TeamLogic team = new TeamLogic();
		team.initTeamData();
		PlayerLogic getPlayers = new PlayerLogic();
		team.savePlayerData(getPlayers.getAllInfo());
		team.saveTeamData(getPlayers.getAllInfo());
	}

}
