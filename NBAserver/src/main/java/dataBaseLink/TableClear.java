package dataBaseLink;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TableClear {
	public static String ip = "172.26.83.142";
//	public static String ip = "114.212.42.143";
	public static String url = "jdbc:mysql://" + ip
			+ ":3306/nbadata?useUnicode=true&characterEncoding=utf-8";
	public static String driver = "com.mysql.jdbc.Driver";

	public TableClear() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			System.out.println("error");
		}

	}
	public void clear(String tablename){
		try {
			Connection con = DriverManager.getConnection(url, "thometoy",
					"960105");
			if (!con.isClosed()) {

			}
			Statement st = con.createStatement();
			int rs = st.executeUpdate("delete from "+tablename);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
