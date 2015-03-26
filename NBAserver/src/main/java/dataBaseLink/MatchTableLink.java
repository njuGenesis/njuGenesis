package dataBaseLink;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import data.po.MatchDataPO;

public class MatchTableLink {
	public static String ip = "172.26.83.142";
	// public static String ip = "114.212.42.143"，172.26.83.142;
	public static String url = "jdbc:mysql://" + ip
			+ ":3306/nbadata?useUnicode=true&characterEncoding=utf-8";
	public static String driver = "com.mysql.jdbc.Driver";

	public boolean judge() {
		boolean res = false;
		try {
			Connection con = DriverManager.getConnection(url, "thometoy",
					"960105");
			if (!con.isClosed()) {
			}
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from matchinfo");
			while (rs.next()) {
				if (rs.last()) {
					if (rs.getRow() == 0) {
						res = true;
					} else {
						res = false;
					}
				}
			}
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public MatchTableLink() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			System.out.println("error");
		}
	}

	public void addInfo(ArrayList<MatchDataPO> list) {
		for (int i = 0; i < list.size(); i++) {
			addInfo(list.get(i));
		}

	}

	public void addInfo(MatchDataPO p) {
		try {
			Connection con = DriverManager.getConnection(url, "thometoy",
					"960105");
			if (!con.isClosed()) {
			}
			Statement st = con.createStatement();
			String value = p.getDate() + "','" + p.getFirstteam() + "','"
					+ p.getSecondteam() + "','" + p.getPoints() + "','"
					+ p.getFirst_pts() + "','" + p.getSecond_pts() + "','"
					+ p.getThird_pts() + "','" + p.getForth_pts() + "','"
					+ p.getWinner() + "','" + p.getTeamround1() + "','"
					+ p.getTeamround2() + "','" + p.getTeam1Off() + "','"
					+ p.getTeam2Off() + "','" + p.getTeam1Def() + "','"
					+ p.getTeam2Def() + "','" + p.getLostSH1() + "','"
					+ p.getLostSH2() + "','" + p.getShoot1() + p.getShoot2()
					+ "','" + p.getFT1() + p.getFT2() + "','" + p.getTo1()
					+ "','" + p.getTo2();

			System.out.println("match value = "+value);
			st.executeUpdate("insert into matchinfo(Date,Firstteam,Secondteam,Points,"
					+ "First_pts,Second_pts,Third_pts,Forth_pts,Winner,"
					+ "teamround1,teamround2,team1Off,team2Off,team1Def,"
					+ "team2Def,lostSH1,lostSH2,shoot1,shoot2,FT1,FT2,To1,To2"
					+ ")values('" + value + "')");

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<MatchDataPO> getInfo(String team1, String team2,
			String data) {
		ArrayList<MatchDataPO> AllInfo = new ArrayList<MatchDataPO>();
		MatchDataPO Info = new MatchDataPO();
		try {
			Connection con = DriverManager.getConnection(url, "thometoy",
					"960105");
			if (!con.isClosed())
				System.out.println("success");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from matchinfo");
			while (rs.next()) {
				if ((rs.getString("data").equals(data) || rs.getString("data")
						.equals(""))
						&& (rs.getString("Firstteam").equals(team1) || rs
								.getString("Firstteam").equals(""))
						&& (rs.getString("Secondteam").equals(team2) || rs
								.getString("Secondteam").equals(""))) {
					Info.setDate(rs.getString("Date"));
					Info.setFirstteam(rs.getString("Firstteam"));
					Info.setSecondteam(rs.getString("Secondteam"));
					Info.setPoints(rs.getString("Points"));
					Info.setFirst_pts(rs.getString("First_pts"));
					Info.setSecond_pts(rs.getString("Second_pts"));
					Info.setThird_pts(rs.getString("Third_pts"));
					Info.setForth_pts(rs.getString("Forth_pts"));
					Info.setWinner(rs.getString("Winner"));
					Info.setTeamround1(rs.getDouble("teamround1"));
					Info.setTeamround2(rs.getDouble("setTeamround2"));
					Info.setTeam1Off(rs.getDouble("Team1Off"));
					Info.setTeam2Off(rs.getDouble("Team2Off"));
					Info.setTeam1Def(rs.getDouble("Team1Def"));
					Info.setTeam2Def(rs.getDouble("Team2Def"));
					Info.setLostSH1(rs.getDouble("LostSH1"));
					Info.setLostSH2(rs.getDouble("LostSH2"));
					Info.setShoot1(rs.getDouble("shoot1"));
					Info.setShoot2(rs.getDouble("shoot2"));
					Info.setFT1(rs.getDouble("FT1"));
					Info.setFT2(rs.getDouble("FT2"));
					Info.setTo1(rs.getDouble("To1"));
					Info.setTo2(rs.getDouble("To2"));
					
				}
				AllInfo.add(Info);
			}
			return AllInfo;
		} catch (Exception e) {
			e.printStackTrace();
			return AllInfo;
		}
	}

	public void deleteAll() {
		try {
			Connection con = DriverManager.getConnection(url, "thometoy",
					"960105");
			if (!con.isClosed())
				System.out.println("success");
			Statement st = con.createStatement();
			st.executeQuery("TRUNCATE TABLE matchinfo");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<MatchDataPO> getAllInfo() {
		// TODO Auto-generated method stub
		ArrayList<MatchDataPO> list = new ArrayList<MatchDataPO>();
		try {
			Connection con = DriverManager.getConnection(url, "thometoy",
					"960105");
			if (!con.isClosed())

				System.out.println("success");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from matchinfo");
			while (rs.next()) {
				MatchDataPO AllInfo = new MatchDataPO();
				AllInfo.setDate(rs.getString("Date"));
				AllInfo.setFirstteam(rs.getString("Firstteam"));
				AllInfo.setSecondteam(rs.getString("Secondteam"));
				AllInfo.setPoints(rs.getString("Points"));
				AllInfo.setFirst_pts(rs.getString("First_pts"));
				AllInfo.setSecond_pts(rs.getString("Second_pts"));
				AllInfo.setThird_pts(rs.getString("Third_pts"));
				AllInfo.setForth_pts(rs.getString("Forth_pts"));
				AllInfo.setWinner(rs.getString("Winner"));
				AllInfo.setTeamround1(rs.getDouble("teamround1"));
				AllInfo.setTeamround2(rs.getDouble("setTeamround2"));
				AllInfo.setTeam1Off(rs.getDouble("Team1Off"));
				AllInfo.setTeam2Off(rs.getDouble("Team2Off"));
				AllInfo.setTeam1Def(rs.getDouble("Team1Def"));
				AllInfo.setTeam2Def(rs.getDouble("Team2Def"));
				AllInfo.setLostSH1(rs.getDouble("LostSH1"));
				AllInfo.setLostSH2(rs.getDouble("LostSH2"));
				AllInfo.setShoot1(rs.getDouble("shoot1"));
				AllInfo.setShoot2(rs.getDouble("shoot2"));
				AllInfo.setFT1(rs.getDouble("FT1"));
				AllInfo.setFT2(rs.getDouble("FT2"));
				AllInfo.setTo1(rs.getDouble("To1"));
				AllInfo.setTo2(rs.getDouble("To2"));
				list.add(AllInfo);
			}
			rs.close();
			con.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
