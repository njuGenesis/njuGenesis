package data.po;

import java.io.Serializable;
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
		this.teamround1 = teamround1;
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
		this.teamround2 = teamround2;
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
