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

	public MatchTableLink() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			System.out.println("error");
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
					+ p.getThird_pts() + "','" + p.getForth_pts();

			 st
					.executeUpdate("insert into match(Date,Firstteam,Secondteam,Points,First_pts,Second_pts,Third_pts,Forth_pts"
							+ ")values(" + value + ")");

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MatchDataPO getInfo(String name) {
		MatchDataPO AllInfo = new MatchDataPO();
		try {
			Connection con = DriverManager.getConnection(url, "thometoy",
					"960105");
			if (!con.isClosed())
				System.out.println("success");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from team");
			while (rs.next()) {
				if (rs.getString("Name").equals(name)) {
					AllInfo.setDate(rs.getString("Date"));
					AllInfo.setFirstteam(rs.getString("Firstteam"));
					AllInfo.setSecondteam(rs.getString("Secondteam"));
					AllInfo.setPoints(rs.getString("Points"));
					AllInfo.setFirst_pts(rs.getString("First_pts"));
					AllInfo.setSecond_pts(rs.getString("Second_pts"));
					AllInfo.setThird_pts(rs.getString("Third_pts"));
					AllInfo.setForth_pts(rs.getString("Forth_pts"));
				}
			}
			return AllInfo;
		} catch (Exception e) {
			e.printStackTrace();
			return AllInfo;
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
			ResultSet rs = st.executeQuery("select * from player");
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
