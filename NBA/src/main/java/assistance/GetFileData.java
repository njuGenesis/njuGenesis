package assistance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import data.po.MatchDataPO;


public class GetFileData {
	boolean isjoin = false;
	public String readPlayerfile(String filename) {
		String res = "";
		try {
			File f = new File(filename);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String data = br.readLine();// 一次读入一行，直到读入null为文件结束
			//res = res + data + '\n';
			
			while (data!= null) {
				//System.out.println(data+";");
				
				if(isjoin == false){
					
					isjoin = true;
				}
				else{
				data = data.trim();
				//System.out.println(data+";");
				data = getSubPlayerData(data);
				res = res + data + '\n';
				isjoin = false;
				}
				data = br.readLine(); // 接着读下一行
				//res = res + data + '\n';
			}
			br.close();
			System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	public String getSubPlayerData(String info){
		int i = 0;
		for (int j = 0;j<info.length();j++){
			if(info.substring(j,j+1).equals("│")){
				i = j+1;
				//System.out.println("hi");
				break;
			}
		}
		String res = info.substring(i,info.length()-1).trim();
		return res;
	}
	public MatchDataPO readMatchfile(String filename) {//读取match信息生成matchdatapo
		boolean jud = false;
		MatchDataPO res = new MatchDataPO();
		try{
			File f = new File(filename);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String data = br.readLine();// 一次读入一行，直到读入null为文件结束
			String[] temp = data.split(";");
			res.setDate(temp[0]);
			res.setFirstteam(temp[1].split("-")[0]);
			res.setSecondteam(temp[1].split("-")[1]);
			res.setPoints(temp[2]);
			data = br.readLine();
			res.setFirst_pts(data.split(";")[0]);
			res.setSecond_pts(data.split(";")[1]);
			res.setThird_pts(data.split(";")[2]);
			res.setForth_pts(data.split(";")[3]);
			data = br.readLine();
			while(data!=null){
				if((data.equals(res.getFirstteam()))){
					jud = false;
				}
				if(data.equals(res.getSecondteam())){
					jud = true;
				}
				if(jud==false){
					res.firstTeamInfo.add(data);
				}
				else{
					res.secondTeamInfo.add(data);
				}
				data = br.readLine();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	public void readTeamfile(String filename){
		
	}
}
