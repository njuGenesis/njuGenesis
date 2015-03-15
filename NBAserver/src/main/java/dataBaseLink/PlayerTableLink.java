package dataBaseLink;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
	public void addInfo(PlayerDataPO p){
		try {
			Connection con = DriverManager.getConnection(url,"thometoy", "960105");
			if (!con.isClosed()){
				
			}
			Statement st = con.createStatement();
			String value = p.getName()+"','"+p.getNumber()+"','"+p.getPosition()+"','"+p.getHeight()+"','"+p.getWeight()+"','"+p.getBirth().replaceAll(",", "")+"','"+
			p.getAge()+"','"+p.getExp()+"','"+p.getSchool()+"','"+p.getTeamName()+"','"+p.getGP()+"','"+p.getGS()+"','"+p.getBackboard()+"','"+p.getBPG()
			+"','"+p.getAssist()+"','"+p.getAPG()+"','"+p.getMinutesOnField()+"','"+p.getMPG()+"','"+p.getFieldGoalPercentage()+"','"+p.getThreePGPercentage()
			+"','"+p.getFTPercentage()+"','"+p.getOff()+"','"+p.getOffPG()+"','"+p.getDef()+"','"+p.getDefPG()+"','"+p.getSteal()+"','"+p.getStealPG()+"','"+
			p.getRejection()+"','"+p.getRPG()+"','"+p.getTo()+"','"+p.getToPG()+"','"+p.getFoul()+"','"+p.getFoulPG()+"','"+p.getPTS()+"','"+p.getPPG()+"','"+
			p.getEff()+"','"+p.getGmsc()+"','"+p.getTruePercentage()+"','"+p.getShootEff()+"','"+p.getBackboardEff()+"','"+p.getOffBEff()+"','"+p.getDefBEff()
			+"','"+p.getAssitEff()+"','"+p.getStealEff()+"','"+p.getRejectionEff()+"','"+p.getToEff()+"','"+p.getUseEff()+"','"+p.getDouble()+"','"+p.getFieldGoal()
			+"','"+p.getTotalFieldGoal()+"','"+p.getThreeGoal()+"','"+p.getTotalThreeGoal()+"','"+p.getFT()+"','"+p.getTotalFT();
			
			System.out.println("insert into player(Name,Number,position,Height,Weight,Birth,Age,Exp,School,TeamName,GP,GS,backboard,BPG,assist,APG,"
					+ "MinutesOnField,MPG,FieldGoalPercentage,ThreePGPercentage,FTPercentage,Off,OffPG,Def,DefPG,Steal,StealPG,Rejection,RPG,To,ToPG,foul,"
					+ "foulPG,PTS,PPG,Eff,Gmsc,TruePercentage,ShootEff,BackboardEff,OffBEff,DefBEff,AssitEff,StealEff,RejectionEff,ToEff,UseEff,Double,"
					+ "FieldGoal,TotalFieldGoal,ThreeGoal,TotalThreeGoal,FT,TotalFT"
					+ ")values("+value+")");
			
			int rs = st.executeUpdate("insert into player(Name,Number,position,Height,Weight,Birth,Age,Exp,School,TeamName,GP,GS,backboard,BPG,assist,APG,"
					+ "MinutesOnField,MPG,FieldGoalPercentage,ThreePGPercentage,FTPercentage,Off,OffPG,Def,DefPG,Steal,StealPG,Rejection,RPG,ToMiss,ToMissPG,foul,"
					+ "foulPG,PTS,PPG,Eff,Gmsc,TruePercentage,ShootEff,BackboardEff,OffBEff,DefBEff,AssitEff,StealEff,RejectionEff,ToEff,UseEff,DoubleTime,"
					+ "FieldGoal,TotalFieldGoal,ThreeGoal,TotalThreeGoal,FT,TotalFT"
					+ ")values('"+value+"')");
			
			
			
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public PlayerDataPO getInfo(String name){
		try {
			Connection con = DriverManager.getConnection(url,
					"thometoy", "960105");
			if (!con.isClosed())

				System.out.println("success");

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from player");
				return null;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
	}
	public PlayerDataPO[] getAllInfo(){
		// TODO Auto-generated method stub
		return null;
	}
	public void setOrder(String orderName) {
		// TODO Auto-generated method stub
		
	}

	public PlayerDataPO[] getFirstFifty(String orderName){
		// TODO Auto-generated method stub
		return null;
	}
}
