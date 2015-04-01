package dataBaseLink;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import data.po.PlayerDataPO;

public class PlayerTableLink {
	public static String ip = "172.26.83.142";
//	public static String ip = "114.212.42.143";
	public static String url = "jdbc:mysql://" + ip
			+ ":3306/nbadata?useUnicode=true&characterEncoding=utf-8";
	public static String driver = "com.mysql.jdbc.Driver";

	public PlayerTableLink() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			System.out.println("error");
		}

	}

	public boolean judge() {
		boolean res = true;
		try {
			Connection con = DriverManager.getConnection(url, "thometoy",
					"960105");
			if (!con.isClosed()) {

			}
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from player");
			while (rs.next()) {
				if (rs.last()) {
					System.out.println(rs.getRow());
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

	public void addInfo(PlayerDataPO p) {
		try {
			Connection con = DriverManager.getConnection(url, "thometoy",
					"960105");
			if (!con.isClosed()) {

			}
			Statement st = con.createStatement();
			String value = p.getName().replaceAll("'", "‘") + "','"
					+ p.getNumber() + "','" + p.getPosition() + "','"
					+ p.getHeight() + "','" + p.getWeight() + "','"
					+ p.getBirth().replaceAll(",", "") + "','" + p.getAge()
					+ "','" + p.getExp() + "','"
					+ p.getSchool().replaceAll("'", "‘") + "','"
					+ p.getTeamName() + "','" + p.getGP() + "','" + p.getGS()
					+ "','" + p.getBackboard() + "','" + p.getBPG() + "','"
					+ p.getAssist() + "','" + p.getAPG() + "','"
					+ p.getMinutesOnField() + "','" + p.getMPG() + "','"
					+ p.getFieldGoalPercentage() + "','"
					+ p.getThreePGPercentage() + "','" + p.getFTPercentage()
					+ "','" + p.getOff() + "','" + p.getOffPG() + "','"
					+ p.getDef() + "','" + p.getDefPG() + "','" + p.getSteal()
					+ "','" + p.getStealPG() + "','" + p.getRejection() + "','"
					+ p.getRPG() + "','" + p.getTo() + "','" + p.getToPG()
					+ "','" + p.getFoul() + "','" + p.getFoulPG() + "','"
					+ p.getPTS() + "','" + p.getPPG() + "','" + p.getEff()
					+ "','" + p.getGmsc() + "','" + p.getTruePercentage()
					+ "','" + p.getShootEff() + "','" + p.getBackboardEff()
					+ "','" + p.getOffBEff() + "','" + p.getDefBEff() + "','"
					+ p.getAssitEff() + "','" + p.getStealEff() + "','"
					+ p.getRejectionEff() + "','" + p.getToEff() + "','"
					+ p.getUseEff() + "','" + p.getDouble() + "','"
					+ p.getFieldGoal() + "','" + p.getTotalFieldGoal() + "','"
					+ p.getThreeGoal() + "','" + p.getTotalThreeGoal() + "','"
					+ p.getFT() + "','" + p.getTotalFT();



			int rs = st
					.executeUpdate("insert into player(Name,Number,position,Height,Weight,Birth,Age,Exp,School,TeamName,GP,GS,backboard,BPG,assist,APG,"
							+ "MinutesOnField,MPG,FieldGoalPercentage,ThreePGPercentage,FTPercentage,Off,OffPG,Def,DefPG,Steal,StealPG,Rejection,RPG,ToMiss,ToMissPG,foul,"
							+ "foulPG,PTS,PPG,Eff,Gmsc,TruePercentage,ShootEff,BackboardEff,OffBEff,DefBEff,AssitEff,StealEff,RejectionEff,ToEff,UseEff,DoubleTime,"
							+ "FieldGoal,TotalFieldGoal,ThreeGoal,TotalThreeGoal,FT,TotalFT"
							+ ")values('" + value + "')");

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PlayerDataPO getInfo(String name) {
		PlayerDataPO AllInfo = new PlayerDataPO();
		try {
			Connection con = DriverManager.getConnection(url, "thometoy",
					"960105");
			if (!con.isClosed())

				System.out.println("success");

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from player");
			while (rs.next()) {
				if (rs.getString("Name").equals(name)) {
					AllInfo.setName(name);
					AllInfo.setNumber(rs.getString("Number"));
					AllInfo.setPosition(rs.getString("position"));
					AllInfo.setHeight(rs.getString("Height"));
					AllInfo.setWeight(rs.getDouble("Weight"));
					AllInfo.setBirth(rs.getString("Birth"));
					AllInfo.setAge(rs.getInt("Age"));
					AllInfo.setExp(rs.getInt("Exp"));
					AllInfo.setSchool(rs.getString("School"));
					AllInfo.setTeamName(rs.getString("TeamName"));
					AllInfo.setGP(rs.getInt("GP"));
					AllInfo.setGS(rs.getInt("GS"));
					AllInfo.setBackboard(rs.getInt("backboard"));
					AllInfo.setBPG(rs.getDouble("BPG"));
					AllInfo.setAssist(rs.getInt("assist"));
					AllInfo.setAPG(rs.getDouble("APG"));
					AllInfo.setMinutesOnField(rs.getDouble("MinutesOnField"));
					AllInfo.setMPG(rs.getDouble("MPG"));
					AllInfo.setFieldGoalPercentage(rs
							.getDouble("FieldGoalPercentage"));
					AllInfo.setThreePGPercentage(rs
							.getDouble("ThreePGPercentage"));
					AllInfo.setFTPercentage(rs.getDouble("FTPercentage"));
					AllInfo.setOff(rs.getInt("Off"));
					AllInfo.setOffPG(rs.getDouble("OffPG"));// off
					AllInfo.setDef(rs.getInt("Def"));
					AllInfo.setDefPG(rs.getDouble("DefPG"));// def
					AllInfo.setSteal(rs.getInt("Steal"));
					AllInfo.setStealPG(rs.getDouble("StealPG"));
					AllInfo.setRejection(rs.getInt("Rejection"));
					AllInfo.setRPG(rs.getDouble("RPG"));
					AllInfo.setTo(rs.getInt("ToMiss"));
					AllInfo.setToPG(rs.getDouble("ToMissPG"));
					AllInfo.setFoul(rs.getInt("foul"));
					AllInfo.setFoulPG(rs.getDouble("foulPG"));
					AllInfo.setPTS(rs.getInt("PTS"));
					AllInfo.setPPG(rs.getDouble("PPG"));
					AllInfo.setEff(rs.getDouble("Eff"));
					AllInfo.setGmsc(rs.getDouble("Gmsc"));
					AllInfo.setTruePercentage(rs.getDouble("TruePercentage"));
					AllInfo.setShootEff(rs.getDouble("ShootEff"));
					AllInfo.setBackboardEff(rs.getDouble("BackboardEff"));
					AllInfo.setOffBEff(rs.getDouble("OffBEff"));
					AllInfo.setDefBEff(rs.getDouble("DefBEff"));
					AllInfo.setAssitEff(rs.getDouble("AssitEff"));
					AllInfo.setStealEff(rs.getDouble("StealEff"));// steal
					AllInfo.setRejectionEff(rs.getDouble("RejectionEff"));
					AllInfo.setToEff(rs.getDouble("ToEff"));
					AllInfo.setUseEff(rs.getDouble("UseEff"));
					AllInfo.setDouble(rs.getInt("DoubleTime"));
					AllInfo.setFieldGoal(rs.getInt("FieldGoal"));
					AllInfo.setTotalFieldGoal(rs.getInt("TotalFieldGoal"));
					AllInfo.setThreeGoal(rs.getInt("ThreeGoal"));
					AllInfo.setTotalThreeGoal(rs.getInt("TotalThreeGoal"));
					AllInfo.setFT(rs.getInt("FT"));
					AllInfo.setTotalFT(rs.getInt("TotalFT"));
				}
			}
			return AllInfo;
		} catch (Exception e) {
			e.printStackTrace();
			return AllInfo;
		}
	}

	public PlayerDataPO[] getAllInfo() {
		// TODO Auto-generated method stub
		ArrayList<PlayerDataPO> list = new ArrayList<PlayerDataPO>();
		try {
			Connection con = DriverManager.getConnection(url, "thometoy",
					"960105");
			if (!con.isClosed())

				System.out.println("success");

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from player");
			while (rs.next()) {
				PlayerDataPO AllInfo = new PlayerDataPO();
				AllInfo.setName(rs.getString("Name"));
				AllInfo.setNumber(rs.getString("Number"));
				AllInfo.setPosition(rs.getString("position"));
				AllInfo.setHeight(rs.getString("Height"));
				AllInfo.setWeight(rs.getDouble("Weight"));
				AllInfo.setBirth(rs.getString("Birth"));
				AllInfo.setAge(rs.getInt("Age"));
				AllInfo.setExp(rs.getInt("Exp"));
				AllInfo.setSchool(rs.getString("School"));
				AllInfo.setTeamName(rs.getString("TeamName"));
				AllInfo.setGP(rs.getInt("GP"));
				AllInfo.setGS(rs.getInt("GS"));
				AllInfo.setBackboard(rs.getInt("backboard"));
				AllInfo.setBPG(rs.getDouble("BPG"));
				AllInfo.setAssist(rs.getInt("assist"));
				AllInfo.setAPG(rs.getDouble("APG"));
				AllInfo.setMinutesOnField(rs.getDouble("MinutesOnField"));
				AllInfo.setMPG(rs.getDouble("MPG"));
				AllInfo.setFieldGoalPercentage(rs
						.getDouble("FieldGoalPercentage"));
				AllInfo.setThreePGPercentage(rs.getDouble("ThreePGPercentage"));
				AllInfo.setFTPercentage(rs.getDouble("FTPercentage"));
				AllInfo.setOff(rs.getInt("Off"));
				AllInfo.setOffPG(rs.getDouble("OffPG"));// off
				AllInfo.setDef(rs.getInt("Def"));
				AllInfo.setDefPG(rs.getDouble("DefPG"));// def
				AllInfo.setSteal(rs.getInt("Steal"));
				AllInfo.setStealPG(rs.getDouble("StealPG"));
				AllInfo.setRejection(rs.getInt("Rejection"));
				AllInfo.setRPG(rs.getDouble("RPG"));
				AllInfo.setTo(rs.getInt("ToMiss"));
				AllInfo.setToPG(rs.getDouble("ToMissPG"));
				AllInfo.setFoul(rs.getInt("foul"));
				AllInfo.setFoulPG(rs.getDouble("foulPG"));
				AllInfo.setPTS(rs.getInt("PTS"));
				AllInfo.setPPG(rs.getDouble("PPG"));
				AllInfo.setEff(rs.getDouble("Eff"));
				AllInfo.setGmsc(rs.getDouble("Gmsc"));
				AllInfo.setTruePercentage(rs.getDouble("TruePercentage"));
				AllInfo.setShootEff(rs.getDouble("ShootEff"));
				AllInfo.setBackboardEff(rs.getDouble("BackboardEff"));
				AllInfo.setOffBEff(rs.getDouble("OffBEff"));
				AllInfo.setDefBEff(rs.getDouble("DefBEff"));
				AllInfo.setAssitEff(rs.getDouble("AssitEff"));
				AllInfo.setStealEff(rs.getDouble("StealEff"));// steal
				AllInfo.setRejectionEff(rs.getDouble("RejectionEff"));
				AllInfo.setToEff(rs.getDouble("ToEff"));
				AllInfo.setUseEff(rs.getDouble("UseEff"));
				AllInfo.setDouble(rs.getInt("DoubleTime"));
				AllInfo.setFieldGoal(rs.getInt("FieldGoal"));
				AllInfo.setTotalFieldGoal(rs.getInt("TotalFieldGoal"));
				AllInfo.setThreeGoal(rs.getInt("ThreeGoal"));
				AllInfo.setTotalThreeGoal(rs.getInt("TotalThreeGoal"));
				AllInfo.setFT(rs.getInt("FT"));
				AllInfo.setTotalFT(rs.getInt("TotalFT"));
				list.add(AllInfo);
			}
			PlayerDataPO[] res = new PlayerDataPO[list.size()];
			for (int i = 0; i < list.size(); i++) {
				res[i] = list.get(i);
			}
			rs.close();
			con.close();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setOrder(String orderName, boolean isUp) {
		// TODO Auto-generated method stub
		try {
			Connection con = DriverManager.getConnection(url, "thometoy",
					"960105");
			if (!con.isClosed())

				System.out.println("success");

			String Order = "";
			if (isUp == true) {
				Order = "select * from player order by '" + orderName + "'asc";
			} else {
				Order = "select * from player order by '" + orderName + "'desc";
			}
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(Order);
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PlayerDataPO[] getFirstFifty(String orderName) {
		// TODO Auto-generated method stub
		ArrayList<PlayerDataPO> list = new ArrayList<PlayerDataPO>();
		try {
			int count = 50;
			Connection con = DriverManager.getConnection(url, "thometoy",
					"960105");
			if (!con.isClosed())

				System.out.println("success");

			String Order = "";

			Order = "select * from player order by '" + orderName + "'desc";

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(Order);
			ResultSet rs2 = st.executeQuery("select * from player");
			while (rs2.next() && (count > 0)) {
				PlayerDataPO AllInfo = new PlayerDataPO();
				AllInfo.setName(rs.getString("Name"));
				AllInfo.setNumber(rs.getString("Number"));
				AllInfo.setPosition(rs.getString("position"));
				AllInfo.setHeight(rs.getString("Height"));
				AllInfo.setWeight(rs.getDouble("Weight"));
				AllInfo.setBirth(rs.getString("Birth"));
				AllInfo.setAge(rs.getInt("Age"));
				AllInfo.setExp(rs.getInt("Exp"));
				AllInfo.setSchool(rs.getString("School"));
				AllInfo.setTeamName(rs.getString("TeamName"));
				AllInfo.setGP(rs.getInt("GP"));
				AllInfo.setGS(rs.getInt("GS"));
				AllInfo.setBackboard(rs.getInt("backboard"));
				AllInfo.setBPG(rs.getDouble("BPG"));
				AllInfo.setAssist(rs.getInt("assist"));
				AllInfo.setAPG(rs.getDouble("APG"));
				AllInfo.setMinutesOnField(rs.getDouble("MinutesOnField"));
				AllInfo.setMPG(rs.getDouble("MPG"));
				AllInfo.setFieldGoalPercentage(rs
						.getDouble("FieldGoalPercentage"));
				AllInfo.setThreePGPercentage(rs.getDouble("ThreePGPercentage"));
				AllInfo.setFTPercentage(rs.getDouble("FTPercentage"));
				AllInfo.setOff(rs.getInt("Off"));
				AllInfo.setOffPG(rs.getDouble("OffPG"));// off
				AllInfo.setDef(rs.getInt("Def"));
				AllInfo.setDefPG(rs.getDouble("DefPG"));// def
				AllInfo.setSteal(rs.getInt("Steal"));
				AllInfo.setStealPG(rs.getDouble("StealPG"));
				AllInfo.setRejection(rs.getInt("Rejection"));
				AllInfo.setRPG(rs.getDouble("RPG"));
				AllInfo.setTo(rs.getInt("ToMiss"));
				AllInfo.setToPG(rs.getDouble("ToMissPG"));
				AllInfo.setFoul(rs.getInt("foul"));
				AllInfo.setFoulPG(rs.getDouble("foulPG"));
				AllInfo.setPTS(rs.getInt("PTS"));
				AllInfo.setPPG(rs.getDouble("PPG"));
				AllInfo.setEff(rs.getDouble("Eff"));
				AllInfo.setGmsc(rs.getDouble("Gmsc"));
				AllInfo.setTruePercentage(rs.getDouble("TruePercentage"));
				AllInfo.setShootEff(rs.getDouble("ShootEff"));
				AllInfo.setBackboardEff(rs.getDouble("BackboardEff"));
				AllInfo.setOffBEff(rs.getDouble("OffBEff"));
				AllInfo.setDefBEff(rs.getDouble("DefBEff"));
				AllInfo.setAssitEff(rs.getDouble("AssitEff"));
				AllInfo.setStealEff(rs.getDouble("StealEff"));// steal
				AllInfo.setRejectionEff(rs.getDouble("RejectionEff"));
				AllInfo.setToEff(rs.getDouble("ToEff"));
				AllInfo.setUseEff(rs.getDouble("UseEff"));
				AllInfo.setDouble(rs.getInt("DoubleTime"));
				AllInfo.setFieldGoal(rs.getInt("FieldGoal"));
				AllInfo.setTotalFieldGoal(rs.getInt("TotalFieldGoal"));
				AllInfo.setThreeGoal(rs.getInt("ThreeGoal"));
				AllInfo.setTotalThreeGoal(rs.getInt("TotalThreeGoal"));
				AllInfo.setFT(rs.getInt("FT"));
				AllInfo.setTotalFT(rs.getInt("TotalFT"));
				count--;
				list.add(AllInfo);
			}
			PlayerDataPO[] res = new PlayerDataPO[list.size()];
			for (int i = 0; i < list.size(); i++) {
				res[i] = list.get(i);
			}
			rs2.close();
			rs.close();
			con.close();
			return res;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public PlayerDataPO[] getSelect(String position, String union) {
		// TODO Auto-generated method stub
		ArrayList<PlayerDataPO> list = new ArrayList<PlayerDataPO>();
		try {
			Connection con = DriverManager.getConnection(url, "thometoy",
					"960105");
			if (!con.isClosed())

				System.out.println("success");
			// TeamName
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from player");
			if (position.equals("null")) {
				if (union.equals("null")) {
					return getAllInfo();
				} else {
					if (union.equals("E")) {
						while (rs.next()) {
							PlayerDataPO AllInfo = new PlayerDataPO();

							if ((rs.getString("TeamName").equals("ATL"))
									|| (rs.getString("TeamName").equals("BKN"))
									|| (rs.getString("TeamName").equals("CHA"))
									|| (rs.getString("TeamName").equals("CHI"))
									|| (rs.getString("TeamName").equals("CLE"))
									|| (rs.getString("TeamName").equals("DET"))
									|| (rs.getString("TeamName").equals("IND"))
									|| (rs.getString("TeamName").equals("MIA"))
									|| (rs.getString("TeamName").equals("MIL"))
									|| (rs.getString("TeamName").equals("NYK"))
									|| (rs.getString("TeamName").equals("ORL"))
									|| (rs.getString("TeamName").equals("PHI"))
									|| (rs.getString("TeamName").equals("TOR"))
									|| (rs.getString("TeamName").equals("WAS"))) {

								AllInfo.setName(rs.getString("Name"));
								AllInfo.setNumber(rs.getString("Number"));
								AllInfo.setPosition(rs.getString("position"));
								AllInfo.setHeight(rs.getString("Height"));
								AllInfo.setWeight(rs.getDouble("Weight"));
								AllInfo.setBirth(rs.getString("Birth"));
								AllInfo.setAge(rs.getInt("Age"));
								AllInfo.setExp(rs.getInt("Exp"));
								AllInfo.setSchool(rs.getString("School"));
								AllInfo.setTeamName(rs.getString("TeamName"));
								AllInfo.setGP(rs.getInt("GP"));
								AllInfo.setGS(rs.getInt("GS"));
								AllInfo.setBackboard(rs.getInt("backboard"));
								AllInfo.setBPG(rs.getDouble("BPG"));
								AllInfo.setAssist(rs.getInt("assist"));
								AllInfo.setAPG(rs.getDouble("APG"));
								AllInfo.setMinutesOnField(rs
										.getDouble("MinutesOnField"));
								AllInfo.setMPG(rs.getDouble("MPG"));
								AllInfo.setFieldGoalPercentage(rs
										.getDouble("FieldGoalPercentage"));
								AllInfo.setThreePGPercentage(rs
										.getDouble("ThreePGPercentage"));
								AllInfo.setFTPercentage(rs
										.getDouble("FTPercentage"));
								AllInfo.setOff(rs.getInt("Off"));
								AllInfo.setOffPG(rs.getDouble("OffPG"));// off
								AllInfo.setDef(rs.getInt("Def"));
								AllInfo.setDefPG(rs.getDouble("DefPG"));// def
								AllInfo.setSteal(rs.getInt("Steal"));
								AllInfo.setStealPG(rs.getDouble("StealPG"));
								AllInfo.setRejection(rs.getInt("Rejection"));
								AllInfo.setRPG(rs.getDouble("RPG"));
								AllInfo.setTo(rs.getInt("ToMiss"));
								AllInfo.setToPG(rs.getDouble("ToMissPG"));
								AllInfo.setFoul(rs.getInt("foul"));
								AllInfo.setFoulPG(rs.getDouble("foulPG"));
								AllInfo.setPTS(rs.getInt("PTS"));
								AllInfo.setPPG(rs.getDouble("PPG"));
								AllInfo.setEff(rs.getDouble("Eff"));
								AllInfo.setGmsc(rs.getDouble("Gmsc"));
								AllInfo.setTruePercentage(rs
										.getDouble("TruePercentage"));
								AllInfo.setShootEff(rs.getDouble("ShootEff"));
								AllInfo.setBackboardEff(rs
										.getDouble("BackboardEff"));
								AllInfo.setOffBEff(rs.getDouble("OffBEff"));
								AllInfo.setDefBEff(rs.getDouble("DefBEff"));
								AllInfo.setAssitEff(rs.getDouble("AssitEff"));
								AllInfo.setStealEff(rs.getDouble("StealEff"));// steal
								AllInfo.setRejectionEff(rs
										.getDouble("RejectionEff"));
								AllInfo.setToEff(rs.getDouble("ToEff"));
								AllInfo.setUseEff(rs.getDouble("UseEff"));
								AllInfo.setDouble(rs.getInt("DoubleTime"));
								AllInfo.setFieldGoal(rs.getInt("FieldGoal"));
								AllInfo.setTotalFieldGoal(rs
										.getInt("TotalFieldGoal"));
								AllInfo.setThreeGoal(rs.getInt("ThreeGoal"));
								AllInfo.setTotalThreeGoal(rs
										.getInt("TotalThreeGoal"));
								AllInfo.setFT(rs.getInt("FT"));
								AllInfo.setTotalFT(rs.getInt("TotalFT"));
								list.add(AllInfo);
							}
						}
					} else if (union.equals("W")) {
						while (rs.next()) {
							PlayerDataPO AllInfo = new PlayerDataPO();

							if ((!rs.getString("TeamName").equals("ATL"))
									&& (!rs.getString("TeamName").equals("BKN"))
									&& (!rs.getString("TeamName").equals("CHA"))
									&& (!rs.getString("TeamName").equals("CHI"))
									&& (!rs.getString("TeamName").equals("CLE"))
									&& (!rs.getString("TeamName").equals("DET"))
									&& (!rs.getString("TeamName").equals("IND"))
									&& (!rs.getString("TeamName").equals("MIA"))
									&& (!rs.getString("TeamName").equals("MIL"))
									&& (!rs.getString("TeamName").equals("NYK"))
									&& (!rs.getString("TeamName").equals("ORL"))
									&& (!rs.getString("TeamName").equals("PHI"))
									&& (!rs.getString("TeamName").equals("TOR"))
									&& (!rs.getString("TeamName").equals("WAS"))
									&& (!rs.getString("TeamName").equals("null"))) {

								AllInfo.setName(rs.getString("Name"));
								AllInfo.setNumber(rs.getString("Number"));
								AllInfo.setPosition(rs.getString("position"));
								AllInfo.setHeight(rs.getString("Height"));
								AllInfo.setWeight(rs.getDouble("Weight"));
								AllInfo.setBirth(rs.getString("Birth"));
								AllInfo.setAge(rs.getInt("Age"));
								AllInfo.setExp(rs.getInt("Exp"));
								AllInfo.setSchool(rs.getString("School"));
								AllInfo.setTeamName(rs.getString("TeamName"));
								AllInfo.setGP(rs.getInt("GP"));
								AllInfo.setGS(rs.getInt("GS"));
								AllInfo.setBackboard(rs.getInt("backboard"));
								AllInfo.setBPG(rs.getDouble("BPG"));
								AllInfo.setAssist(rs.getInt("assist"));
								AllInfo.setAPG(rs.getDouble("APG"));
								AllInfo.setMinutesOnField(rs
										.getDouble("MinutesOnField"));
								AllInfo.setMPG(rs.getDouble("MPG"));
								AllInfo.setFieldGoalPercentage(rs
										.getDouble("FieldGoalPercentage"));
								AllInfo.setThreePGPercentage(rs
										.getDouble("ThreePGPercentage"));
								AllInfo.setFTPercentage(rs
										.getDouble("FTPercentage"));
								AllInfo.setOff(rs.getInt("Off"));
								AllInfo.setOffPG(rs.getDouble("OffPG"));// off
								AllInfo.setDef(rs.getInt("Def"));
								AllInfo.setDefPG(rs.getDouble("DefPG"));// def
								AllInfo.setSteal(rs.getInt("Steal"));
								AllInfo.setStealPG(rs.getDouble("StealPG"));
								AllInfo.setRejection(rs.getInt("Rejection"));
								AllInfo.setRPG(rs.getDouble("RPG"));
								AllInfo.setTo(rs.getInt("ToMiss"));
								AllInfo.setToPG(rs.getDouble("ToMissPG"));
								AllInfo.setFoul(rs.getInt("foul"));
								AllInfo.setFoulPG(rs.getDouble("foulPG"));
								AllInfo.setPTS(rs.getInt("PTS"));
								AllInfo.setPPG(rs.getDouble("PPG"));
								AllInfo.setEff(rs.getDouble("Eff"));
								AllInfo.setGmsc(rs.getDouble("Gmsc"));
								AllInfo.setTruePercentage(rs
										.getDouble("TruePercentage"));
								AllInfo.setShootEff(rs.getDouble("ShootEff"));
								AllInfo.setBackboardEff(rs
										.getDouble("BackboardEff"));
								AllInfo.setOffBEff(rs.getDouble("OffBEff"));
								AllInfo.setDefBEff(rs.getDouble("DefBEff"));
								AllInfo.setAssitEff(rs.getDouble("AssitEff"));
								AllInfo.setStealEff(rs.getDouble("StealEff"));// steal
								AllInfo.setRejectionEff(rs
										.getDouble("RejectionEff"));
								AllInfo.setToEff(rs.getDouble("ToEff"));
								AllInfo.setUseEff(rs.getDouble("UseEff"));
								AllInfo.setDouble(rs.getInt("DoubleTime"));
								AllInfo.setFieldGoal(rs.getInt("FieldGoal"));
								AllInfo.setTotalFieldGoal(rs
										.getInt("TotalFieldGoal"));
								AllInfo.setThreeGoal(rs.getInt("ThreeGoal"));
								AllInfo.setTotalThreeGoal(rs
										.getInt("TotalThreeGoal"));
								AllInfo.setFT(rs.getInt("FT"));
								AllInfo.setTotalFT(rs.getInt("TotalFT"));
								list.add(AllInfo);
							}
						}
					}
				}
			} else {
				if (union.equals("null")) {
					while (rs.next()) {
						PlayerDataPO AllInfo = new PlayerDataPO();

						if (rs.getString("position").contains(position)) {

							AllInfo.setName(rs.getString("Name"));
							AllInfo.setNumber(rs.getString("Number"));
							AllInfo.setPosition(rs.getString("position"));
							AllInfo.setHeight(rs.getString("Height"));
							AllInfo.setWeight(rs.getDouble("Weight"));
							AllInfo.setBirth(rs.getString("Birth"));
							AllInfo.setAge(rs.getInt("Age"));
							AllInfo.setExp(rs.getInt("Exp"));
							AllInfo.setSchool(rs.getString("School"));
							AllInfo.setTeamName(rs.getString("TeamName"));
							AllInfo.setGP(rs.getInt("GP"));
							AllInfo.setGS(rs.getInt("GS"));
							AllInfo.setBackboard(rs.getInt("backboard"));
							AllInfo.setBPG(rs.getDouble("BPG"));
							AllInfo.setAssist(rs.getInt("assist"));
							AllInfo.setAPG(rs.getDouble("APG"));
							AllInfo.setMinutesOnField(rs
									.getDouble("MinutesOnField"));
							AllInfo.setMPG(rs.getDouble("MPG"));
							AllInfo.setFieldGoalPercentage(rs
									.getDouble("FieldGoalPercentage"));
							AllInfo.setThreePGPercentage(rs
									.getDouble("ThreePGPercentage"));
							AllInfo.setFTPercentage(rs
									.getDouble("FTPercentage"));
							AllInfo.setOff(rs.getInt("Off"));
							AllInfo.setOffPG(rs.getDouble("OffPG"));// off
							AllInfo.setDef(rs.getInt("Def"));
							AllInfo.setDefPG(rs.getDouble("DefPG"));// def
							AllInfo.setSteal(rs.getInt("Steal"));
							AllInfo.setStealPG(rs.getDouble("StealPG"));
							AllInfo.setRejection(rs.getInt("Rejection"));
							AllInfo.setRPG(rs.getDouble("RPG"));
							AllInfo.setTo(rs.getInt("ToMiss"));
							AllInfo.setToPG(rs.getDouble("ToMissPG"));
							AllInfo.setFoul(rs.getInt("foul"));
							AllInfo.setFoulPG(rs.getDouble("foulPG"));
							AllInfo.setPTS(rs.getInt("PTS"));
							AllInfo.setPPG(rs.getDouble("PPG"));
							AllInfo.setEff(rs.getDouble("Eff"));
							AllInfo.setGmsc(rs.getDouble("Gmsc"));
							AllInfo.setTruePercentage(rs
									.getDouble("TruePercentage"));
							AllInfo.setShootEff(rs.getDouble("ShootEff"));
							AllInfo.setBackboardEff(rs
									.getDouble("BackboardEff"));
							AllInfo.setOffBEff(rs.getDouble("OffBEff"));
							AllInfo.setDefBEff(rs.getDouble("DefBEff"));
							AllInfo.setAssitEff(rs.getDouble("AssitEff"));
							AllInfo.setStealEff(rs.getDouble("StealEff"));// steal
							AllInfo.setRejectionEff(rs
									.getDouble("RejectionEff"));
							AllInfo.setToEff(rs.getDouble("ToEff"));
							AllInfo.setUseEff(rs.getDouble("UseEff"));
							AllInfo.setDouble(rs.getInt("DoubleTime"));
							AllInfo.setFieldGoal(rs.getInt("FieldGoal"));
							AllInfo.setTotalFieldGoal(rs
									.getInt("TotalFieldGoal"));
							AllInfo.setThreeGoal(rs.getInt("ThreeGoal"));
							AllInfo.setTotalThreeGoal(rs
									.getInt("TotalThreeGoal"));
							AllInfo.setFT(rs.getInt("FT"));
							AllInfo.setTotalFT(rs.getInt("TotalFT"));
							list.add(AllInfo);
						}
					}
				} else if (union.equals("E")) {
					while (rs.next()) {
						PlayerDataPO AllInfo = new PlayerDataPO();
						
						if (((rs.getString("TeamName").equals("ATL"))
								|| (rs.getString("TeamName").equals("BKN"))
								|| (rs.getString("TeamName").equals("CHA"))
								|| (rs.getString("TeamName").equals("CHI"))
								|| (rs.getString("TeamName").equals("CLE"))
								|| (rs.getString("TeamName").equals("DET"))
								|| (rs.getString("TeamName").equals("IND"))
								|| (rs.getString("TeamName").equals("MIA"))
								|| (rs.getString("TeamName").equals("MIL"))
								|| (rs.getString("TeamName").equals("NYK"))
								|| (rs.getString("TeamName").equals("ORL"))
								|| (rs.getString("TeamName").equals("PHI"))
								|| (rs.getString("TeamName").equals("TOR"))
								|| (rs.getString("TeamName").equals("WAS")))
								&&(rs.getString("position").contains(position))) {

							AllInfo.setName(rs.getString("Name"));
							AllInfo.setNumber(rs.getString("Number"));
							AllInfo.setPosition(rs.getString("position"));
							AllInfo.setHeight(rs.getString("Height"));
							AllInfo.setWeight(rs.getDouble("Weight"));
							AllInfo.setBirth(rs.getString("Birth"));
							AllInfo.setAge(rs.getInt("Age"));
							AllInfo.setExp(rs.getInt("Exp"));
							AllInfo.setSchool(rs.getString("School"));
							AllInfo.setTeamName(rs.getString("TeamName"));
							AllInfo.setGP(rs.getInt("GP"));
							AllInfo.setGS(rs.getInt("GS"));
							AllInfo.setBackboard(rs.getInt("backboard"));
							AllInfo.setBPG(rs.getDouble("BPG"));
							AllInfo.setAssist(rs.getInt("assist"));
							AllInfo.setAPG(rs.getDouble("APG"));
							AllInfo.setMinutesOnField(rs
									.getDouble("MinutesOnField"));
							AllInfo.setMPG(rs.getDouble("MPG"));
							AllInfo.setFieldGoalPercentage(rs
									.getDouble("FieldGoalPercentage"));
							AllInfo.setThreePGPercentage(rs
									.getDouble("ThreePGPercentage"));
							AllInfo.setFTPercentage(rs
									.getDouble("FTPercentage"));
							AllInfo.setOff(rs.getInt("Off"));
							AllInfo.setOffPG(rs.getDouble("OffPG"));// off
							AllInfo.setDef(rs.getInt("Def"));
							AllInfo.setDefPG(rs.getDouble("DefPG"));// def
							AllInfo.setSteal(rs.getInt("Steal"));
							AllInfo.setStealPG(rs.getDouble("StealPG"));
							AllInfo.setRejection(rs.getInt("Rejection"));
							AllInfo.setRPG(rs.getDouble("RPG"));
							AllInfo.setTo(rs.getInt("ToMiss"));
							AllInfo.setToPG(rs.getDouble("ToMissPG"));
							AllInfo.setFoul(rs.getInt("foul"));
							AllInfo.setFoulPG(rs.getDouble("foulPG"));
							AllInfo.setPTS(rs.getInt("PTS"));
							AllInfo.setPPG(rs.getDouble("PPG"));
							AllInfo.setEff(rs.getDouble("Eff"));
							AllInfo.setGmsc(rs.getDouble("Gmsc"));
							AllInfo.setTruePercentage(rs
									.getDouble("TruePercentage"));
							AllInfo.setShootEff(rs.getDouble("ShootEff"));
							AllInfo.setBackboardEff(rs
									.getDouble("BackboardEff"));
							AllInfo.setOffBEff(rs.getDouble("OffBEff"));
							AllInfo.setDefBEff(rs.getDouble("DefBEff"));
							AllInfo.setAssitEff(rs.getDouble("AssitEff"));
							AllInfo.setStealEff(rs.getDouble("StealEff"));// steal
							AllInfo.setRejectionEff(rs
									.getDouble("RejectionEff"));
							AllInfo.setToEff(rs.getDouble("ToEff"));
							AllInfo.setUseEff(rs.getDouble("UseEff"));
							AllInfo.setDouble(rs.getInt("DoubleTime"));
							AllInfo.setFieldGoal(rs.getInt("FieldGoal"));
							AllInfo.setTotalFieldGoal(rs
									.getInt("TotalFieldGoal"));
							AllInfo.setThreeGoal(rs.getInt("ThreeGoal"));
							AllInfo.setTotalThreeGoal(rs
									.getInt("TotalThreeGoal"));
							AllInfo.setFT(rs.getInt("FT"));
							AllInfo.setTotalFT(rs.getInt("TotalFT"));
							list.add(AllInfo);
						}
					}
				} else if (union.equals("W")) {
					while (rs.next()) {
						PlayerDataPO AllInfo = new PlayerDataPO();

						if (((!rs.getString("TeamName").equals("ATL"))
								&& (!rs.getString("TeamName").equals("BKN"))
								&& (!rs.getString("TeamName").equals("CHA"))
								&& (!rs.getString("TeamName").equals("CHI"))
								&& (!rs.getString("TeamName").equals("CLE"))
								&& (!rs.getString("TeamName").equals("DET"))
								&& (!rs.getString("TeamName").equals("IND"))
								&& (!rs.getString("TeamName").equals("MIA"))
								&& (!rs.getString("TeamName").equals("MIL"))
								&& (!rs.getString("TeamName").equals("NYK"))
								&& (!rs.getString("TeamName").equals("ORL"))
								&& (!rs.getString("TeamName").equals("PHI"))
								&& (!rs.getString("TeamName").equals("TOR"))
								&& (!rs.getString("TeamName").equals("WAS"))
								&& (!rs.getString("TeamName").equals("null")))
								&&(rs.getString("position").contains(position))) {

							AllInfo.setName(rs.getString("Name"));
							AllInfo.setNumber(rs.getString("Number"));
							AllInfo.setPosition(rs.getString("position"));
							AllInfo.setHeight(rs.getString("Height"));
							AllInfo.setWeight(rs.getDouble("Weight"));
							AllInfo.setBirth(rs.getString("Birth"));
							AllInfo.setAge(rs.getInt("Age"));
							AllInfo.setExp(rs.getInt("Exp"));
							AllInfo.setSchool(rs.getString("School"));
							AllInfo.setTeamName(rs.getString("TeamName"));
							AllInfo.setGP(rs.getInt("GP"));
							AllInfo.setGS(rs.getInt("GS"));
							AllInfo.setBackboard(rs.getInt("backboard"));
							AllInfo.setBPG(rs.getDouble("BPG"));
							AllInfo.setAssist(rs.getInt("assist"));
							AllInfo.setAPG(rs.getDouble("APG"));
							AllInfo.setMinutesOnField(rs
									.getDouble("MinutesOnField"));
							AllInfo.setMPG(rs.getDouble("MPG"));
							AllInfo.setFieldGoalPercentage(rs
									.getDouble("FieldGoalPercentage"));
							AllInfo.setThreePGPercentage(rs
									.getDouble("ThreePGPercentage"));
							AllInfo.setFTPercentage(rs
									.getDouble("FTPercentage"));
							AllInfo.setOff(rs.getInt("Off"));
							AllInfo.setOffPG(rs.getDouble("OffPG"));// off
							AllInfo.setDef(rs.getInt("Def"));
							AllInfo.setDefPG(rs.getDouble("DefPG"));// def
							AllInfo.setSteal(rs.getInt("Steal"));
							AllInfo.setStealPG(rs.getDouble("StealPG"));
							AllInfo.setRejection(rs.getInt("Rejection"));
							AllInfo.setRPG(rs.getDouble("RPG"));
							AllInfo.setTo(rs.getInt("ToMiss"));
							AllInfo.setToPG(rs.getDouble("ToMissPG"));
							AllInfo.setFoul(rs.getInt("foul"));
							AllInfo.setFoulPG(rs.getDouble("foulPG"));
							AllInfo.setPTS(rs.getInt("PTS"));
							AllInfo.setPPG(rs.getDouble("PPG"));
							AllInfo.setEff(rs.getDouble("Eff"));
							AllInfo.setGmsc(rs.getDouble("Gmsc"));
							AllInfo.setTruePercentage(rs
									.getDouble("TruePercentage"));
							AllInfo.setShootEff(rs.getDouble("ShootEff"));
							AllInfo.setBackboardEff(rs
									.getDouble("BackboardEff"));
							AllInfo.setOffBEff(rs.getDouble("OffBEff"));
							AllInfo.setDefBEff(rs.getDouble("DefBEff"));
							AllInfo.setAssitEff(rs.getDouble("AssitEff"));
							AllInfo.setStealEff(rs.getDouble("StealEff"));// steal
							AllInfo.setRejectionEff(rs
									.getDouble("RejectionEff"));
							AllInfo.setToEff(rs.getDouble("ToEff"));
							AllInfo.setUseEff(rs.getDouble("UseEff"));
							AllInfo.setDouble(rs.getInt("DoubleTime"));
							AllInfo.setFieldGoal(rs.getInt("FieldGoal"));
							AllInfo.setTotalFieldGoal(rs
									.getInt("TotalFieldGoal"));
							AllInfo.setThreeGoal(rs.getInt("ThreeGoal"));
							AllInfo.setTotalThreeGoal(rs
									.getInt("TotalThreeGoal"));
							AllInfo.setFT(rs.getInt("FT"));
							AllInfo.setTotalFT(rs.getInt("TotalFT"));
							list.add(AllInfo);
						}
					}
				}
			}
				
			
			PlayerDataPO[] res = new PlayerDataPO[list.size()];
			for (int i = 0; i < list.size(); i++) {
				res[i] = list.get(i);
			}
			rs.close();
			con.close();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public PlayerDataPO[] getSearch(String keys){
		ArrayList<PlayerDataPO> list = new ArrayList<PlayerDataPO>();
		try {
			Connection con = DriverManager.getConnection(url, "thometoy",
					"960105");
			if (!con.isClosed())

				System.out.println("success");

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from player where Name like'%"+keys+"%'");
			while (rs.next()) {
				PlayerDataPO AllInfo = new PlayerDataPO();
				AllInfo.setName(rs.getString("Name"));
				AllInfo.setNumber(rs.getString("Number"));
				AllInfo.setPosition(rs.getString("position"));
				AllInfo.setHeight(rs.getString("Height"));
				AllInfo.setWeight(rs.getDouble("Weight"));
				AllInfo.setBirth(rs.getString("Birth"));
				AllInfo.setAge(rs.getInt("Age"));
				AllInfo.setExp(rs.getInt("Exp"));
				AllInfo.setSchool(rs.getString("School"));
				AllInfo.setTeamName(rs.getString("TeamName"));
				AllInfo.setGP(rs.getInt("GP"));
				AllInfo.setGS(rs.getInt("GS"));
				AllInfo.setBackboard(rs.getInt("backboard"));
				AllInfo.setBPG(rs.getDouble("BPG"));
				AllInfo.setAssist(rs.getInt("assist"));
				AllInfo.setAPG(rs.getDouble("APG"));
				AllInfo.setMinutesOnField(rs.getDouble("MinutesOnField"));
				AllInfo.setMPG(rs.getDouble("MPG"));
				AllInfo.setFieldGoalPercentage(rs
						.getDouble("FieldGoalPercentage"));
				AllInfo.setThreePGPercentage(rs.getDouble("ThreePGPercentage"));
				AllInfo.setFTPercentage(rs.getDouble("FTPercentage"));
				AllInfo.setOff(rs.getInt("Off"));
				AllInfo.setOffPG(rs.getDouble("OffPG"));// off
				AllInfo.setDef(rs.getInt("Def"));
				AllInfo.setDefPG(rs.getDouble("DefPG"));// def
				AllInfo.setSteal(rs.getInt("Steal"));
				AllInfo.setStealPG(rs.getDouble("StealPG"));
				AllInfo.setRejection(rs.getInt("Rejection"));
				AllInfo.setRPG(rs.getDouble("RPG"));
				AllInfo.setTo(rs.getInt("ToMiss"));
				AllInfo.setToPG(rs.getDouble("ToMissPG"));
				AllInfo.setFoul(rs.getInt("foul"));
				AllInfo.setFoulPG(rs.getDouble("foulPG"));
				AllInfo.setPTS(rs.getInt("PTS"));
				AllInfo.setPPG(rs.getDouble("PPG"));
				AllInfo.setEff(rs.getDouble("Eff"));
				AllInfo.setGmsc(rs.getDouble("Gmsc"));
				AllInfo.setTruePercentage(rs.getDouble("TruePercentage"));
				AllInfo.setShootEff(rs.getDouble("ShootEff"));
				AllInfo.setBackboardEff(rs.getDouble("BackboardEff"));
				AllInfo.setOffBEff(rs.getDouble("OffBEff"));
				AllInfo.setDefBEff(rs.getDouble("DefBEff"));
				AllInfo.setAssitEff(rs.getDouble("AssitEff"));
				AllInfo.setStealEff(rs.getDouble("StealEff"));// steal
				AllInfo.setRejectionEff(rs.getDouble("RejectionEff"));
				AllInfo.setToEff(rs.getDouble("ToEff"));
				AllInfo.setUseEff(rs.getDouble("UseEff"));
				AllInfo.setDouble(rs.getInt("DoubleTime"));
				AllInfo.setFieldGoal(rs.getInt("FieldGoal"));
				AllInfo.setTotalFieldGoal(rs.getInt("TotalFieldGoal"));
				AllInfo.setThreeGoal(rs.getInt("ThreeGoal"));
				AllInfo.setTotalThreeGoal(rs.getInt("TotalThreeGoal"));
				AllInfo.setFT(rs.getInt("FT"));
				AllInfo.setTotalFT(rs.getInt("TotalFT"));
				list.add(AllInfo);
			}
			PlayerDataPO[] res = new PlayerDataPO[list.size()];
			for (int i = 0; i < list.size(); i++) {
				res[i] = list.get(i);
			}
			rs.close();
			con.close();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
