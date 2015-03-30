package dataBaseLink;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import data.po.TeamDataPO;

public class TeamTableLink {
	// public static String ip = "114.212.42.244";
	public static String ip = "172.26.83.142";
	public static String url = "jdbc:mysql://" + ip
			+ ":3306/nbadata?useUnicode=true&characterEncoding=utf-8";
	public static String driver = "com.mysql.jdbc.Driver";

	public TeamTableLink() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			System.out.println("error");
		}

	}

	public void addInfo(ArrayList<TeamDataPO> list) {
		for (int i = 0; i < list.size(); i++) {
			addInfo(list.get(i));
		}

	}

	public void addInfo(TeamDataPO p) {
		try {
			Connection con = DriverManager.getConnection(url, "thometoy",
					"960105");
			if (!con.isClosed()) {
			}
			Statement st = con.createStatement();
			String value = p.getName() + "','" + p.getShortName() + "','"
					+ p.getCity() + "','" + p.getEorW() + "','" + p.getArea()
					+ "','" + p.getMainposition() + "','" + p.getPlayers()
					+ "','" + p.getBuildyear() + "','" + p.getMatchNumber()
					+ "','" + p.getWinMatch() + "','" + p.getShootNumber()
					+ "','" + p.getShootNumberPG() + "','"
					+ p.getShootEffNumber() + "','" + p.getShootEffNumberPG()
					+ "','" + p.getTPNumber() + "','" + p.getTPNumberPG()
					+ "','" + p.getTPEffNumber() + "','" + p.getTPEffNumberPG()
					+ "','" + p.getFTEffNumber() + "','" + p.getFTEffNumberPG()
					+ "','" + p.getFTNumber() + "','" + p.getFTNumberPG()
					+ "','" + p.getOffBackBoard() + "','"
					+ p.getOffBackBoardPG() + "','" + p.getDefBackBoard()
					+ "','" + p.getDefBackBoard() + "','"
					+ p.getOtherDefBoard() + "','" + p.getOtherOffBoard()
					+ "','" + p.getBackBoard() + "','" + p.getBackBoardPG()
					+ "','" + p.getAssitNumber() + "','" + p.getAssitNumberPG()
					+ "','" + p.getStealNumber() + "','" + p.getStealNumberPG()
					+ "','" + p.getRejection() + "','" + p.getRejectionPG()
					+ "','" + p.getTo() + "','" + p.getToPG() + "','"
					+ p.getFoul() + "','" + p.getFoulPG() + "','" + p.getPTS()
					+ "','" + p.getPPG() + "','" + p.getLPS() + "','"
					+ p.getLPG() + "','" + p.getShootEff() + "','"
					+ p.getTPEff() + "','" + p.getFTEff() + "','" + p.getWR()
					+ "','" + p.getOff() + "','" + p.getOffPG() + "','"
					+ p.getDef() + "','" + p.getDefPG() + "','" + p.getOffEff()
					+ "','" + p.getDefEff() + "','" + p.getOffBackBoardEff()
					+ "','" + p.getBackBoardEff() + "','"
					+ p.getDefBackBoardEff() + "','" + p.getStealEff() + "','"
					+ p.getAssistEff();

			System.out.println(value);
			/*
			 * System.out .println(
			 * "insert into team(Name,ShortName,City,EorW,area,mainposition,players,buildyear,MatchNumber,WinMatch,ShootNumber,ShootNumberPG,ShootEffNumber,ShootEffNumberPG,TPNumber,TPNumberPG,"
			 * +
			 * "TPEffNumber,TPEffNumberPG,FTEffNumber,FTEffNumberPG,FTNumber,FTNumberPG,OffBackBoard,OffBackBoardPG,DefBackBoard,DefBackBoradPG,OtherDefBoard,OtherOffBoard,BackBoard,BackBoardPG,AssitNumber,AssitNumberPG,"
			 * +
			 * "StealNumber,StealNumberPG,Rejection,RejectionPG,ToTime,ToPG,Foul,FoulPG,PTS,PPG,LPS,LPG,ShootEff,TPEff,FTEff,WR,"
			 * +
			 * "Off,OffPG,Def,DefPG,OffEff,DefEff,OffBackBoardEff,BackBoardEff,DefBackBoardEff,StealEff,AssistEff"
			 * + ")values(" + value + ")");
			 */
			st.executeUpdate("insert into team(Name,ShortName,City,EorW,area,mainposition,player,buildyear,MatchNumber,WinMatch,ShootNumber,ShootNumberPG,ShootEffNumber,ShootEffNumberPG,TPNumber,TPNumberPG,"
					+ "TPEffNumber,TPEffNumberPG,FTEffNumber,FTEffNumberPG,FTNumber,FTNumberPG,OffBackBoard,OffBackBoardPG,DefBackBoard,DefBackBoardPG,OtherDefBoard,OtherOffBoard,BackBoard,BackBoardPG,AssistNumber,AssistNumberPG,"
					+ "StealNumber,StealNumberPG,Rejection,RejectionPG,ToTime,ToPG,Foul,FoulPG,PTS,PPG,LPS,LPG,ShootEff,TPEff,FTEff,WR,"
					+ "Off,OffPG,Def,DefPG,OffEff,DefEff,OffBackBoardEff,BackBoardEff,DefBackBoardEff,StealEff,AssistEff"
					+ ")values('" + value + "')");

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public TeamDataPO getInfo(String name) {
		TeamDataPO AllInfo = new TeamDataPO();
		try {
			Connection con = DriverManager.getConnection(url, "thometoy",
					"960105");
			if (!con.isClosed())
				System.out.println("success");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from team");

			while (rs.next()) {
				if (rs.getString("Name").equals(name)) {
					AllInfo.setName(name);
					AllInfo.setShortName(rs.getString("ShortName"));
					AllInfo.setCity(rs.getString("City"));
					AllInfo.setEorW(rs.getString("EorW"));
					AllInfo.setArea(rs.getString("Area"));
					AllInfo.setMainposition(rs.getString("Mainposition"));
					AllInfo.setPlayers(rs.getString("player"));
					AllInfo.setBuildyear(rs.getInt("Buildyear"));
					AllInfo.setMatchNumber(rs.getDouble("MatchNumber"));
					AllInfo.setWinMatch(rs.getDouble("WinMatch"));
					AllInfo.setShootNumber(rs.getInt("ShootNumber"));
					AllInfo.setShootNumberPG(rs.getDouble("ShootNumberPG"));
					AllInfo.setShootEffNumber(rs.getInt("ShootEffNumber"));
					AllInfo.setShootEffNumberPG(rs
							.getDouble("ShootEffNumberPG"));
					AllInfo.setTPNumber(rs.getInt("TPNumber"));
					AllInfo.setTPNumberPG(rs.getDouble("TPNumberPG"));
					AllInfo.setTPEffNumber(rs.getInt("TPEffNumber"));
					AllInfo.setTPEffNumberPG(rs.getDouble("TPEffNumberPG"));
					AllInfo.setFTEffNumber(rs.getInt("FTEffNumber"));
					AllInfo.setFTEffNumberPG(rs.getDouble("FTEffNumberPG"));
					AllInfo.setFTNumber(rs.getInt("FTNumber"));
					AllInfo.setFTNumberPG(rs.getDouble("FTNumberPG"));
					AllInfo.setOffBackBoard(rs.getDouble("OffBackBoard"));// off
					AllInfo.setOffBackBoardPG(rs.getDouble("OffBackBoardPG"));
					AllInfo.setDefBackBoard(rs.getDouble("DefBackBoard"));// def
					AllInfo.setDefBackBoardPG(rs.getDouble("DefBackBoardPG"));// xxxxxxxxxxxxxxxxxxxx
					AllInfo.setOtherDefBoard(rs.getDouble("OtherDefBoard"));
					AllInfo.setOtherOffBoard(rs.getDouble("OtherOffBoard"));
					AllInfo.setBackBoard(rs.getInt("BackBoard"));
					AllInfo.setBackBoardPG(rs.getDouble("BackBoardPG"));
					AllInfo.setAssitNumber(rs.getInt("AssistNumber"));
					AllInfo.setAssitNumberPG(rs.getDouble("AssistNumberPG"));
					AllInfo.setStealNumber(rs.getInt("StealNumber"));
					AllInfo.setStealNumberPG(rs.getDouble("StealNumberPG"));
					AllInfo.setRejection(rs.getInt("Rejection"));
					AllInfo.setRejectionPG(rs.getDouble("RejectionPG"));
					AllInfo.setTo(rs.getInt("ToTime"));
					AllInfo.setToPG(rs.getDouble("ToPG"));
					AllInfo.setFoul(rs.getInt("Foul"));
					AllInfo.setFoulPG(rs.getDouble("FoulPG"));
					AllInfo.setPTS(rs.getInt("PTS"));
					AllInfo.setPPG(rs.getDouble("PPG"));
					AllInfo.setLPS(rs.getDouble("LPS"));
					AllInfo.setLPG(rs.getDouble("LPG"));// steal
					AllInfo.setShootEff(rs.getDouble("ShootEff"));// xxxxxxxxxxxxxxxxxxx
					AllInfo.setTPEff(rs.getDouble("TPEff"));// xxxxxxxxxxxxxxx
					AllInfo.setFTEff(rs.getDouble("FTEff"));// xxxxxxxxxxxxxxxxx
					AllInfo.setWR(rs.getDouble("WR"));
					AllInfo.setOff(rs.getDouble("Off"));
					AllInfo.setOffPG(rs.getDouble("OffPG"));
					AllInfo.setDef(rs.getDouble("Def"));
					AllInfo.setDefPG(rs.getDouble("DefPG"));
					AllInfo.setOffEff(rs.getDouble("OffEff"));
					AllInfo.setDefEff(rs.getDouble("DefEff"));
					AllInfo.setOffBackBoardEff(rs.getDouble("OffBackBoardEff"));
					AllInfo.setBackBoardEff(rs.getDouble("BackBoardEff"));
					AllInfo.setDefBackBoardEff(rs.getDouble("DefBackBoardEff"));
					AllInfo.setStealEff(rs.getDouble("StealEff"));
					AllInfo.setAssistEff(rs.getDouble("AssistEff"));
				}
			}
			return AllInfo;
		} catch (Exception e) {
			e.printStackTrace();
			return AllInfo;
		}
	}

	public ArrayList<TeamDataPO> getAllInfo() {
		// TODO Auto-generated method stub
		ArrayList<TeamDataPO> list = new ArrayList<TeamDataPO>();
		try {
			Connection con = DriverManager.getConnection(url, "thometoy",
					"960105");
			if (!con.isClosed())

				System.out.println("success");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from team");
			while (rs.next()) {
				TeamDataPO AllInfo = new TeamDataPO();
				AllInfo.setName(rs.getString("Name"));
				AllInfo.setShortName(rs.getString("ShortName"));
				AllInfo.setCity(rs.getString("City"));
				AllInfo.setEorW(rs.getString("EorW"));
				AllInfo.setArea(rs.getString("Area"));
				AllInfo.setMainposition(rs.getString("Mainposition"));
				AllInfo.setPlayers(rs.getString("player"));
				AllInfo.setBuildyear(rs.getInt("Buildyear"));
				AllInfo.setMatchNumber(rs.getDouble("MatchNumber"));
				AllInfo.setWinMatch(rs.getDouble("WinMatch"));
				AllInfo.setShootNumber(rs.getInt("ShootNumber"));
				AllInfo.setShootNumberPG(rs.getDouble("ShootNumberPG"));
				AllInfo.setShootEffNumber(rs.getInt("ShootEffNumber"));
				AllInfo.setShootEffNumberPG(rs.getDouble("ShootEffNumberPG"));
				AllInfo.setTPNumber(rs.getInt("TPNumber"));
				AllInfo.setTPNumberPG(rs.getDouble("TPNumberPG"));
				AllInfo.setTPEffNumber(rs.getInt("TPEffNumber"));
				AllInfo.setTPEffNumberPG(rs.getDouble("TPEffNumberPG"));
				AllInfo.setFTEffNumber(rs.getInt("FTEffNumber"));
				AllInfo.setFTEffNumberPG(rs.getDouble("FTEffNumberPG"));
				AllInfo.setFTNumber(rs.getInt("FTNumber"));
				AllInfo.setFTNumberPG(rs.getDouble("FTNumberPG"));
				AllInfo.setOffBackBoard(rs.getDouble("OffBackBoard"));// off
				AllInfo.setOffBackBoardPG(rs.getDouble("OffBackBoardPG"));
				AllInfo.setDefBackBoard(rs.getDouble("DefBackBoard"));// def
				AllInfo.setDefBackBoardPG(rs.getDouble("DefBackBoardPG"));
				AllInfo.setOtherDefBoard(rs.getDouble("OtherDefBoard"));
				AllInfo.setOtherOffBoard(rs.getDouble("OtherOffBoard"));
				AllInfo.setBackBoard(rs.getInt("BackBoard"));
				AllInfo.setBackBoardPG(rs.getDouble("BackBoardPG"));
				AllInfo.setAssitNumber(rs.getInt("AssistNumber"));
				AllInfo.setAssitNumberPG(rs.getDouble("AssistNumberPG"));
				AllInfo.setStealNumber(rs.getInt("StealNumber"));
				AllInfo.setStealNumberPG(rs.getDouble("StealNumberPG"));
				AllInfo.setRejection(rs.getInt("Rejection"));
				AllInfo.setRejectionPG(rs.getDouble("RejectionPG"));
				AllInfo.setTo(rs.getInt("ToTime"));
				AllInfo.setToPG(rs.getDouble("ToPG"));
				AllInfo.setFoul(rs.getInt("Foul"));
				AllInfo.setFoulPG(rs.getDouble("FoulPG"));
				AllInfo.setPTS(rs.getInt("PTS"));
				AllInfo.setPPG(rs.getDouble("PPG"));
				AllInfo.setLPS(rs.getDouble("LPS"));
				AllInfo.setLPG(rs.getDouble("LPG"));// steal
				AllInfo.setShootEff(rs.getDouble("ShootEff"));
				AllInfo.setTPEff(rs.getDouble("TPEff"));
				AllInfo.setFTEff(rs.getDouble("FTEff"));
				AllInfo.setWR(rs.getDouble("WR"));
				AllInfo.setOff(rs.getDouble("Off"));
				AllInfo.setOffPG(rs.getDouble("OffPG"));
				AllInfo.setDef(rs.getDouble("Def"));
				AllInfo.setDefPG(rs.getDouble("DefPG"));
				AllInfo.setOffEff(rs.getDouble("OffEff"));
				AllInfo.setDefEff(rs.getDouble("DefEff"));
				AllInfo.setOffBackBoardEff(rs.getDouble("OffBackBoardEff"));
				AllInfo.setBackBoardEff(rs.getDouble("BackBoardEff"));
				AllInfo.setDefBackBoardEff(rs.getDouble("DefBackBoardEff"));
				AllInfo.setStealEff(rs.getDouble("StealEff"));
				AllInfo.setAssistEff(rs.getDouble("AssistEff"));
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

	public void deleteAll() {
		try {
			Connection con = DriverManager.getConnection(url, "thometoy",
					"960105");
			if (!con.isClosed())
				System.out.println("success");
			Statement st = con.createStatement();
			st.executeQuery("TRUNCATE TABLE team");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean judge() {
		boolean res = false;
		if (getAllInfo().size() == 0) {
			res = true;
		} else {
			res = false;
		}
		return res;
	}

	public void setOrder(String orderName, boolean isUp) {
		try {
			Connection con = DriverManager.getConnection(url, "thometoy",
					"960105");
			if (!con.isClosed())
				System.out.println("success");
			String Order = "";
			if (isUp == true) {
				Order = "select * from team order by '" + orderName + "'asc";
			} else {
				Order = "select * from team order by '" + orderName + "'desc";
			}
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(Order);
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<TeamDataPO> getFirstFifty(String orderName) {
		// TODO Auto-generated method stub
		ArrayList<TeamDataPO> list = new ArrayList<TeamDataPO>();
		try {
			int count = 50;
			Connection con = DriverManager.getConnection(url, "thometoy",
					"960105");
			if (!con.isClosed())

				System.out.println("success");

			String Order = "";

			Order = "select * from team order by '" + orderName + "'desc";

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(Order);
			ResultSet rs2 = st.executeQuery("select * from team");
			while (rs2.next() && (count > 0)) {
				TeamDataPO AllInfo = new TeamDataPO();
				AllInfo.setName(rs.getString("Name"));
				AllInfo.setShortName(rs.getString("ShortName"));
				AllInfo.setCity(rs.getString("City"));
				AllInfo.setEorW(rs.getString("EorW"));
				AllInfo.setArea(rs.getString("Area"));
				AllInfo.setMainposition(rs.getString("Mainposition"));
				AllInfo.setPlayers(rs.getString("player"));
				AllInfo.setBuildyear(rs.getInt("Buildyear"));
				AllInfo.setMatchNumber(rs.getDouble("MatchNumber"));
				AllInfo.setWinMatch(rs.getDouble("WinMatch"));
				AllInfo.setShootNumber(rs.getInt("ShootNumber"));
				AllInfo.setShootNumberPG(rs.getDouble("ShootNumberPG"));
				AllInfo.setShootEffNumber(rs.getInt("ShootEffNumber"));
				AllInfo.setShootEffNumberPG(rs.getDouble("ShootEffNumberPG"));
				AllInfo.setTPNumber(rs.getInt("TPNumber"));
				AllInfo.setTPNumberPG(rs.getDouble("TPNumberPG"));
				AllInfo.setTPEffNumber(rs.getInt("TPEffNumber"));
				AllInfo.setTPEffNumberPG(rs.getDouble("TPEffNumberPG"));
				AllInfo.setFTEffNumber(rs.getInt("FTEffNumber"));
				AllInfo.setFTEffNumberPG(rs.getDouble("FTEffNumberPG"));
				AllInfo.setFTNumber(rs.getInt("FTNumber"));
				AllInfo.setFTNumberPG(rs.getDouble("FTNumberPG"));
				AllInfo.setOffBackBoard(rs.getDouble("OffBackBoard"));// off
				AllInfo.setOffBackBoardPG(rs.getDouble("OffBackBoardPG"));// xxxxxxxxxxxxxxxxxxxxxxxxxxx
				AllInfo.setDefBackBoard(rs.getDouble("DefBackBoard"));// def
				AllInfo.setDefBackBoardPG(rs.getDouble("DefBackBoardPG"));// xxxxxxxxxxxxxxxxxxxxxx
				AllInfo.setOtherDefBoard(rs.getDouble("OtherDefBoard"));
				AllInfo.setOtherOffBoard(rs.getDouble("OtherOffBoard"));
				AllInfo.setBackBoard(rs.getInt("BackBoard"));
				AllInfo.setBackBoardPG(rs.getDouble("BackBoardPG"));
				AllInfo.setAssitNumber(rs.getInt("AssistNumber"));
				AllInfo.setAssitNumberPG(rs.getDouble("AssistNumberPG"));
				AllInfo.setStealNumber(rs.getInt("StealNumber"));
				AllInfo.setStealNumberPG(rs.getDouble("StealNumberPG"));
				AllInfo.setRejection(rs.getInt("Rejection"));
				AllInfo.setRejectionPG(rs.getDouble("RejectionPG"));
				AllInfo.setTo(rs.getInt("ToTime"));
				AllInfo.setToPG(rs.getDouble("ToPG"));
				AllInfo.setFoul(rs.getInt("Foul"));
				AllInfo.setFoulPG(rs.getDouble("FoulPG"));
				AllInfo.setPTS(rs.getInt("PTS"));
				AllInfo.setPPG(rs.getDouble("PPG"));
				AllInfo.setLPS(rs.getDouble("LPS"));
				AllInfo.setLPG(rs.getDouble("LPG"));// steal
				AllInfo.setShootEff(rs.getDouble("ShootEff"));
				AllInfo.setTPEff(rs.getDouble("TPEff"));
				AllInfo.setFTEff(rs.getDouble("FTEff"));
				AllInfo.setWR(rs.getDouble("WR"));
				AllInfo.setOff(rs.getDouble("Off"));
				AllInfo.setOffPG(rs.getDouble("OffPG"));
				AllInfo.setDef(rs.getDouble("Def"));
				AllInfo.setDefPG(rs.getDouble("DefPG"));
				AllInfo.setOffEff(rs.getDouble("OffEff"));
				AllInfo.setDefEff(rs.getDouble("DefEff"));
				AllInfo.setOffBackBoardEff(rs.getDouble("OffBackBoardEff"));
				AllInfo.setBackBoardEff(rs.getDouble("BackBoardEff"));
				AllInfo.setDefBackBoardEff(rs.getDouble("DefBackBoardEff"));
				AllInfo.setStealEff(rs.getDouble("StealEff"));// xxxxxxxxxxxxxxxxxxxx
				AllInfo.setAssistEff(rs.getDouble("AssistEff"));// xxxxxxxxxxxxxxxxxxxxxx
				count--;
				list.add(AllInfo);
			}

			rs2.close();
			rs.close();
			con.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public TeamDataPO getBySN(String shortname) {
		TeamDataPO AllInfo = new TeamDataPO();
		try {
			Connection con = DriverManager.getConnection(url, "thometoy",
					"960105");
			if (!con.isClosed())
				System.out.println("success");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from team");

			while (rs.next()) {
				if (rs.getString("ShortName").equals(shortname)) {
					AllInfo.setName(rs.getString("Name"));
					AllInfo.setShortName(rs.getString("ShortName"));
					AllInfo.setCity(rs.getString("City"));
					AllInfo.setEorW(rs.getString("EorW"));
					AllInfo.setArea(rs.getString("Area"));
					AllInfo.setMainposition(rs.getString("Mainposition"));
					AllInfo.setPlayers(rs.getString("player"));
					AllInfo.setBuildyear(rs.getInt("Buildyear"));
					AllInfo.setMatchNumber(rs.getDouble("MatchNumber"));
					AllInfo.setWinMatch(rs.getDouble("WinMatch"));
					AllInfo.setShootNumber(rs.getInt("ShootNumber"));
					AllInfo.setShootNumberPG(rs.getDouble("ShootNumberPG"));
					AllInfo.setShootEffNumber(rs.getInt("ShootEffNumber"));
					AllInfo.setShootEffNumberPG(rs
							.getDouble("ShootEffNumberPG"));
					AllInfo.setTPNumber(rs.getInt("TPNumber"));
					AllInfo.setTPNumberPG(rs.getDouble("TPNumberPG"));
					AllInfo.setTPEffNumber(rs.getInt("TPEffNumber"));
					AllInfo.setTPEffNumberPG(rs.getDouble("TPEffNumberPG"));
					AllInfo.setFTEffNumber(rs.getInt("FTEffNumber"));
					AllInfo.setFTEffNumberPG(rs.getDouble("FTEffNumberPG"));
					AllInfo.setFTNumber(rs.getInt("FTNumber"));
					AllInfo.setFTNumberPG(rs.getDouble("FTNumberPG"));
					AllInfo.setOffBackBoard(rs.getDouble("OffBackBoard"));// off
					AllInfo.setOffBackBoardPG(rs.getDouble("OffBackBoardPG"));
					AllInfo.setDefBackBoard(rs.getDouble("DefBackBoard"));// def
					AllInfo.setDefBackBoardPG(rs.getDouble("DefBackBoardPG"));// xxxxxxxxxxxxxxxxxxxx
					AllInfo.setOtherDefBoard(rs.getDouble("OtherDefBoard"));
					AllInfo.setOtherOffBoard(rs.getDouble("OtherOffBoard"));
					AllInfo.setBackBoard(rs.getInt("BackBoard"));
					AllInfo.setBackBoardPG(rs.getDouble("BackBoardPG"));
					AllInfo.setAssitNumber(rs.getInt("AssistNumber"));
					AllInfo.setAssitNumberPG(rs.getDouble("AssistNumberPG"));
					AllInfo.setStealNumber(rs.getInt("StealNumber"));
					AllInfo.setStealNumberPG(rs.getDouble("StealNumberPG"));
					AllInfo.setRejection(rs.getInt("Rejection"));
					AllInfo.setRejectionPG(rs.getDouble("RejectionPG"));
					AllInfo.setTo(rs.getInt("ToTime"));
					AllInfo.setToPG(rs.getDouble("ToPG"));
					AllInfo.setFoul(rs.getInt("Foul"));
					AllInfo.setFoulPG(rs.getDouble("FoulPG"));
					AllInfo.setPTS(rs.getInt("PTS"));
					AllInfo.setPPG(rs.getDouble("PPG"));
					AllInfo.setLPS(rs.getDouble("LPS"));
					AllInfo.setLPG(rs.getDouble("LPG"));// steal
					AllInfo.setShootEff(rs.getDouble("ShootEff"));// xxxxxxxxxxxxxxxxxxx
					AllInfo.setTPEff(rs.getDouble("TPEff"));// xxxxxxxxxxxxxxx
					AllInfo.setFTEff(rs.getDouble("FTEff"));// xxxxxxxxxxxxxxxxx
					AllInfo.setWR(rs.getDouble("WR"));
					AllInfo.setOff(rs.getDouble("Off"));
					AllInfo.setOffPG(rs.getDouble("OffPG"));
					AllInfo.setDef(rs.getDouble("Def"));
					AllInfo.setDefPG(rs.getDouble("DefPG"));
					AllInfo.setOffEff(rs.getDouble("OffEff"));
					AllInfo.setDefEff(rs.getDouble("DefEff"));
					AllInfo.setOffBackBoardEff(rs.getDouble("OffBackBoardEff"));
					AllInfo.setBackBoardEff(rs.getDouble("BackBoardEff"));
					AllInfo.setDefBackBoardEff(rs.getDouble("DefBackBoardEff"));
					AllInfo.setStealEff(rs.getDouble("StealEff"));
					AllInfo.setAssistEff(rs.getDouble("AssistEff"));
				}
			}
			return AllInfo;
		} catch (Exception e) {
			e.printStackTrace();
			return AllInfo;
		}
	}
}
