package dataBaseLink;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import data.po.PlayerDataPO;

public class PlayerTableLink {
	public static String ip = "192.168.2.104";
//	public static String ip = "114.212.42.143";
	public static String url = "jdbc:mysql://" + ip
			+ ":3306/my_db?useUnicode=true&characterEncoding=utf-8";
	public static String driver = "com.mysql.jdbc.Driver";

	public PlayerTableLink() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			System.out.println("无法加载驱动");
		}

	}
	public void addInfo(PlayerDataPO p){
		try {
			Connection con = DriverManager.getConnection(url,
					"thometoy", "960105");
			if (!con.isClosed()){
				
			}
			Statement st = con.createStatement();
			int rs = st.executeUpdate("insert into player()values()");
			
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
