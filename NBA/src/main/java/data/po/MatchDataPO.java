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
	String first_pts;
	String second_pts;
	String third_pts;
	String forth_pts;
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
	
}
