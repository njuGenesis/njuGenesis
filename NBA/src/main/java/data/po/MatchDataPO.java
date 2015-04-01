package data.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

public class MatchDataPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String date;
	String firstteam;
	String secondteam;
	String points;
	String winner;
	String first_pts;
	String second_pts;
	String third_pts;
	String forth_pts;
	
	String fifth_pts;
	String sixth_pts;
	String seventh_pts;
	
	
	
	
	/**
	 * @return the fifth_pts
	 */
	public String getFifth_pts() {
		return fifth_pts;
	}
	/**
	 * @param fifth_pts the fifth_pts to set
	 */
	public void setFifth_pts(String fifth_pts) {
		this.fifth_pts = fifth_pts;
	}
	/**
	 * @return the sixth_pts
	 */
	public String getSixth_pts() {
		return sixth_pts;
	}
	/**
	 * @param sixth_pts the sixth_pts to set
	 */
	public void setSixth_pts(String sixth_pts) {
		this.sixth_pts = sixth_pts;
	}
	/**
	 * @return the seventh_pts
	 */
	public String getSeventh_pts() {
		return seventh_pts;
	}
	/**
	 * @param seventh_pts the seventh_pts to set
	 */
	public void setSeventh_pts(String seventh_pts) {
		this.seventh_pts = seventh_pts;
	}

	double teamround1;  //1队进攻回合
	double teamround2;
	
	
	double team1Off;   //1队进攻篮板
	double team1Def;
	
	double team2Off;    //1队防守篮板
	double team2Def;
	
	
	
	double lostSH1;    //1队投失球数
	double lostSH2;
	
	double shoot1;   //1队投球数
	double shoot2;
	
	double FT1;   //1队罚球数
	double FT2;
	
	double To1;   //1队失误
	double To2;

	double team1bank;    //1队篮板
	double team2bank;
	
	double ShootEff1; //1队偷懒命中数
	double ShootEff2;
	
	double TPShoot1; //1队三分投篮数
	double TPShoot2; 
	
	double TPShootEff1; //1队三分命中
	double TPShootEff2; 

	
	double FTShootEff1; //1队罚篮命中数
	double FTShootEff2; 
	
	double Ass1; //1队助攻数
	double Ass2; 
	
	double Steal1;//1队抢断数
	double Steal2;
	
	double Rejection1;//1队盖帽数
	double Rejection2;
	
	
	double Foul1;//1队犯规数
	double Foul2;
	
	
	
	/**
	 * @return the team1bank
	 */
	public double getTeam1bank() {
		return team1bank;
	}
	/**
	 * @param team1bank the team1bank to set
	 */
	public void setTeam1bank(double team1bank) {
		this.team1bank = team1bank;
	}
	/**
	 * @return the team2bank
	 */
	public double getTeam2bank() {
		return team2bank;
	}
	/**
	 * @param team2bank the team2bank to set
	 */
	public void setTeam2bank(double team2bank) {
		this.team2bank = team2bank;
	}
	/**
	 * @return the shootEff1
	 */
	public double getShootEff1() {
		return ShootEff1;
	}
	/**
	 * @param shootEff1 the shootEff1 to set
	 */
	public void setShootEff1(double shootEff1) {
		ShootEff1 = shootEff1;
	}
	/**
	 * @return the shootEff2
	 */
	public double getShootEff2() {
		return ShootEff2;
	}
	/**
	 * @param shootEff2 the shootEff2 to set
	 */
	public void setShootEff2(double shootEff2) {
		ShootEff2 = shootEff2;
	}
	/**
	 * @return the tPShoot1
	 */
	public double getTPShoot1() {
		return TPShoot1;
	}
	/**
	 * @param tPShoot1 the tPShoot1 to set
	 */
	public void setTPShoot1(double tPShoot1) {
		TPShoot1 = tPShoot1;
	}
	/**
	 * @return the tPShoot2
	 */
	public double getTPShoot2() {
		return TPShoot2;
	}
	/**
	 * @param tPShoot2 the tPShoot2 to set
	 */
	public void setTPShoot2(double tPShoot2) {
		TPShoot2 = tPShoot2;
	}
	/**
	 * @return the tPShootEff1
	 */
	public double getTPShootEff1() {
		return TPShootEff1;
	}
	/**
	 * @param tPShootEff1 the tPShootEff1 to set
	 */
	public void setTPShootEff1(double tPShootEff1) {
		TPShootEff1 = tPShootEff1;
	}
	/**
	 * @return the tPShootEff2
	 */
	public double getTPShootEff2() {
		return TPShootEff2;
	}
	/**
	 * @param tPShootEff2 the tPShootEff2 to set
	 */
	public void setTPShootEff2(double tPShootEff2) {
		TPShootEff2 = tPShootEff2;
	}
	/**
	 * @return the fTShootEff1
	 */
	public double getFTShootEff1() {
		return FTShootEff1;
	}
	/**
	 * @param fTShootEff1 the fTShootEff1 to set
	 */
	public void setFTShootEff1(double fTShootEff1) {
		FTShootEff1 = fTShootEff1;
	}
	/**
	 * @return the fTShootEff2
	 */
	public double getFTShootEff2() {
		return FTShootEff2;
	}
	/**
	 * @param fTShootEff2 the fTShootEff2 to set
	 */
	public void setFTShootEff2(double fTShootEff2) {
		FTShootEff2 = fTShootEff2;
	}
	/**
	 * @return the ass1
	 */
	public double getAss1() {
		return Ass1;
	}
	/**
	 * @param ass1 the ass1 to set
	 */
	public void setAss1(double ass1) {
		Ass1 = ass1;
	}
	/**
	 * @return the ass2
	 */
	public double getAss2() {
		return Ass2;
	}
	/**
	 * @param ass2 the ass2 to set
	 */
	public void setAss2(double ass2) {
		Ass2 = ass2;
	}
	/**
	 * @return the steal1
	 */
	public double getSteal1() {
		return Steal1;
	}
	/**
	 * @param steal1 the steal1 to set
	 */
	public void setSteal1(double steal1) {
		Steal1 = steal1;
	}
	/**
	 * @return the steal2
	 */
	public double getSteal2() {
		return Steal2;
	}
	/**
	 * @param steal2 the steal2 to set
	 */
	public void setSteal2(double steal2) {
		Steal2 = steal2;
	}
	/**
	 * @return the rejection1
	 */
	public double getRejection1() {
		return Rejection1;
	}
	/**
	 * @param rejection1 the rejection1 to set
	 */
	public void setRejection1(double rejection1) {
		Rejection1 = rejection1;
	}
	/**
	 * @return the rejection2
	 */
	public double getRejection2() {
		return Rejection2;
	}
	/**
	 * @param rejection2 the rejection2 to set
	 */
	public void setRejection2(double rejection2) {
		Rejection2 = rejection2;
	}
	/**
	 * @return the foul1
	 */
	public double getFoul1() {
		return Foul1;
	}
	/**
	 * @param foul1 the foul1 to set
	 */
	public void setFoul1(double foul1) {
		Foul1 = foul1;
	}
	/**
	 * @return the foul2
	 */
	public double getFoul2() {
		return Foul2;
	}
	/**
	 * @param foul2 the foul2 to set
	 */
	public void setFoul2(double foul2) {
		Foul2 = foul2;
	}
	
	public String getWinner(){
		return winner;
	}
	public void setWinner(String winner){
		this.winner=winner;
	}
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFirstteam() {
		return firstteam;
	}
	public void setFirstteam(String firstteam) {
		this.firstteam = firstteam;
	}
	public String getSecondteam() {
		return secondteam;
	}
	public void setSecondteam(String secondteam) {
		this.secondteam = secondteam;
	}
	public String getPoints() {
		return points;
	}
	public void setPoints(String points) {
		this.points = points;
	}
	public String getFirst_pts() {
		return first_pts;
	}
	public void setFirst_pts(String first_pts) {
		this.first_pts = first_pts;
	}
	public String getSecond_pts() {
		return second_pts;
	}
	public void setSecond_pts(String second_pts) {
		this.second_pts = second_pts;
	}
	public String getThird_pts() {
		return third_pts;
	}
	public void setThird_pts(String third_pts) {
		this.third_pts = third_pts;
	}
	public String getForth_pts() {
		return forth_pts;
	}
	public void setForth_pts(String forth_pts) {
		this.forth_pts = forth_pts;
	}
	
	public ArrayList<String> firstTeamInfo = new ArrayList<String>();
	public ArrayList<String> secondTeamInfo = new ArrayList<String>();





	/**
	 * @return the teamround1
	 */
	public double getTeamround1() {
		return teamround1;
	}
	/**
	 * @param teamround1 the teamround1 to set
	 */
	public void setTeamround1(double teamround1) {
		BigDecimal bg = new BigDecimal(teamround1);
		this.teamround1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	/**
	 * @return the teamround2
	 */
	public double getTeamround2() {
		return teamround2;
	}
	/**
	 * @param teamround2 the teamround2 to set
	 */
	public void setTeamround2(double teamround2) {
		BigDecimal bg = new BigDecimal(teamround2);
		this.teamround2 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	/**
	 * @return the team1Off
	 */
	public double getTeam1Off() {
		return team1Off;
	}
	/**
	 * @param team1Off the team1Off to set
	 */
	public void setTeam1Off(double team1Off) {
		this.team1Off = team1Off;
	}
	/**
	 * @return the team1Def
	 */
	public double getTeam1Def() {
		return team1Def;
	}
	/**
	 * @param team1Def the team1Def to set
	 */
	public void setTeam1Def(double team1Def) {
		this.team1Def = team1Def;
	}
	/**
	 * @return the team2Off
	 */
	public double getTeam2Off() {
		return team2Off;
	}
	/**
	 * @param team2Off the team2Off to set
	 */
	public void setTeam2Off(double team2Off) {
		this.team2Off = team2Off;
	}
	/**
	 * @return the team2Def
	 */
	public double getTeam2Def() {
		return team2Def;
	}
	/**
	 * @param team2Def the team2Def to set
	 */
	public void setTeam2Def(double team2Def) {
		this.team2Def = team2Def;
	}
	/**
	 * @return the lostSH1
	 */
	public double getLostSH1() {
		return lostSH1;
	}
	/**
	 * @param lostSH1 the lostSH1 to set
	 */
	public void setLostSH1(double lostSH1) {
		this.lostSH1 = lostSH1;
	}
	/**
	 * @return the lostSH2
	 */
	public double getLostSH2() {
		return lostSH2;
	}
	/**
	 * @param lostSH2 the lostSH2 to set
	 */
	public void setLostSH2(double lostSH2) {
		this.lostSH2 = lostSH2;
	}
	/**
	 * @return the shoot1
	 */
	public double getShoot1() {
		return shoot1;
	}
	/**
	 * @param shoot1 the shoot1 to set
	 */
	public void setShoot1(double shoot1) {
		this.shoot1 = shoot1;
	}
	/**
	 * @return the shoot2
	 */
	public double getShoot2() {
		return shoot2;
	}
	/**
	 * @param shoot2 the shoot2 to set
	 */
	public void setShoot2(double shoot2) {
		this.shoot2 = shoot2;
	}
	/**
	 * @return the fT1
	 */
	public double getFT1() {
		return FT1;
	}
	/**
	 * @param fT1 the fT1 to set
	 */
	public void setFT1(double fT1) {
		FT1 = fT1;
	}
	/**
	 * @return the fT2
	 */
	public double getFT2() {
		return FT2;
	}
	/**
	 * @param fT2 the fT2 to set
	 */
	public void setFT2(double fT2) {
		FT2 = fT2;
	}
	/**
	 * @return the to1
	 */
	public double getTo1() {
		return To1;
	}
	/**
	 * @param to1 the to1 to set
	 */
	public void setTo1(double to1) {
		To1 = to1;
	}
	/**
	 * @return the to2
	 */
	public double getTo2() {
		return To2;
	}
	/**
	 * @param to2 the to2 to set
	 */
	public void setTo2(double to2) {
		To2 = to2;
	}
	/**
	 * @return the firstTeamInfo
	 */
	public ArrayList<String> getFirstTeamInfo() {
		return firstTeamInfo;
	}
	/**
	 * @param firstTeamInfo the firstTeamInfo to set
	 */
	public void setFirstTeamInfo(ArrayList<String> firstTeamInfo) {
		this.firstTeamInfo = firstTeamInfo;
	}
	/**
	 * @return the secondTeamInfo
	 */
	public ArrayList<String> getSecondTeamInfo() {
		return secondTeamInfo;
	}
	/**
	 * @param secondTeamInfo the secondTeamInfo to set
	 */
	public void setSecondTeamInfo(ArrayList<String> secondTeamInfo) {
		this.secondTeamInfo = secondTeamInfo;
	}
	
	
}
