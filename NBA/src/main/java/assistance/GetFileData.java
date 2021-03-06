package assistance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import data.po.MatchDataPO;
import data.po.TeamDataPO;

public class GetFileData {
	boolean isjoin = false;
	String MatchFileName ="./迭代一数据/matches";
    String Teamfilename ="./迭代一数据/teams/teams";
    
	public String readPlayerfile(String filename) {
		String res = "";
		try {
			//System.out.println("hi"+filename);
			File f = new File(filename);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String data = br.readLine();// 一次读入一行，直到读入null为文件结束
			// res = res + data + '\n';
			isjoin = false;
			while (data != null) {
				// System.out.println(data+";");

				if (isjoin == false) {

					isjoin = true;
				} else {
					data = data.trim();
					 //System.out.println(data+";");
					data = getSubPlayerData(data);
					if(data.equals("")){
						data = "null";
					}
					
					res = res + data + '\n';
					isjoin = false;
				}
				data = br.readLine(); // 接着读下一行
				// res = res + data + '\n';
			}
			br.close();
			//System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public String getSubPlayerData(String info) {
		int i = 0;
		for (int j = 0; j < info.length(); j++) {
			if (info.substring(j, j + 1).equals("│")) {
				i = j + 1;
				// System.out.println("hi");
				break;
			}
		}
		String res = info.substring(i, info.length() - 1).trim();
		return res;
	}

	public MatchDataPO readMatchfile(String filename) {// 读取match信息生成matchdatapo
		boolean jud = false;
		MatchDataPO res = new MatchDataPO();
		try {
			File f = new File(filename);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String data = br.readLine();// 一次读入一行，直到读入null为文件结束
			String[] temp = data.split(";");
			res.setDate(temp[0]);
			res.setFirstteam(temp[1].split("-")[0]);
			res.setSecondteam(temp[1].split("-")[1]);
			res.setPoints(temp[2]);
			if (temp[2].split("-")[0].compareTo(temp[2].split("-")[1]) > 0) {
				res.setWinner(res.getFirstteam());
			} else {
				res.setWinner(res.getSecondteam());
			}
			data = br.readLine();
			res.setFirst_pts(data.split(";")[0]);
			res.setSecond_pts(data.split(";")[1]);
			res.setThird_pts(data.split(";")[2]);
			res.setForth_pts(data.split(";")[3]);
			data = br.readLine();
			while (data != null) {
				if ((data.equals(res.getFirstteam()))) {
					jud = false;
				}
				if (data.equals(res.getSecondteam())) {
					jud = true;
				}
				if (jud == false) {
					res.firstTeamInfo.add(data);
				} else {
					res.secondTeamInfo.add(data);
				}
				data = br.readLine();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public MatchDataPO detailMatch(String filename){
		MatchDataPO res = new MatchDataPO();
		try {
			File f = new File(filename);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String data = br.readLine();// 一次读入一行，直到读入null为文件结束
			String[] temp = data.split(";");
			res.setDate(temp[0]);
			res.setFirstteam(temp[1].split("-")[0]);
			res.setSecondteam(temp[1].split("-")[1]);
			res.setPoints(temp[2]);
			if (temp[2].split("-")[0].compareTo(temp[2].split("-")[1]) > 0) {
				res.setWinner(res.getFirstteam());
			} else {
				res.setWinner(res.getSecondteam());
			}
			data = br.readLine();
			res.setFirst_pts(data.split(";")[0]);
			res.setSecond_pts(data.split(";")[1]);
			res.setThird_pts(data.split(";")[2]);
			res.setForth_pts(data.split(";")[3]);
			if(data.length()>25){                               //判断是否存在加时
				res.setFifth_pts(data.split(";")[4]);
			}
			else{
				res.setFifth_pts("null");
			}
			if(data.length()>31){
				res.setSixth_pts(data.split(";")[5]);
			}
			else{
				res.setSixth_pts("null");
			}
			if(data.length()>37){
				res.setSeventh_pts(data.split(";")[6]);
			}
			else{
				res.setSeventh_pts("null");
			}
			data = br.readLine();  //跳过两行数据
			while((data=br.readLine()).contains(";")){
				String[] detail=data.split(";");
				res.setShootEff1(res.getShootEff1()+Integer.parseInt(detail[3]));
				res.setShoot1(res.getShoot1()+Integer.parseInt(detail[4]));
				res.setLostSH1(res.getLostSH1()+Integer.parseInt(detail[4])-Integer.parseInt(detail[3]));
				res.setTPShootEff1(res.getTPShootEff1()+Integer.parseInt(detail[5]));
				res.setTPShoot1(res.getTPShoot1()+Integer.parseInt(detail[6]));
				res.setFTShootEff1(res.getFTShootEff1()+Integer.parseInt(detail[7]));
			    res.setFT1(res.getFT1()+Integer.parseInt(detail[8]));
			    res.setTeam1Off(res.getTeam1Off()+Integer.parseInt(detail[9]));
			    res.setTeam1Def(res.getTeam1Def()+Integer.parseInt(detail[10]));
			    res.setTeam1bank(res.getTeam1bank()+Integer.parseInt(detail[11]));
			    res.setAss1(res.getAss1()+Integer.parseInt(detail[12]));
			    res.setSteal1(res.getSteal1()+Integer.parseInt(detail[13]));
			    res.setRejection1(res.getRejection1()+Integer.parseInt(detail[14]));
			    res.setTo1(res.getTo1()+Integer.parseInt(detail[15]));
			    res.setFoul1(res.getFoul1()+Integer.parseInt(detail[16]));
			}
			 data=br.readLine();
			while(data!=null){
				
				String[] detail=data.split(";");
				res.setShootEff2(res.getShootEff2()+Integer.parseInt(detail[3]));
				res.setShoot2(res.getShoot2()+Integer.parseInt(detail[4]));
				res.setLostSH2(res.getLostSH2()+Integer.parseInt(detail[4])-Integer.parseInt(detail[3]));
				res.setTPShootEff2(res.getTPShootEff2()+Integer.parseInt(detail[5]));
				res.setTPShoot2(res.getTPShoot2()+Integer.parseInt(detail[6]));
				res.setFTShootEff2(res.getFTShootEff2()+Integer.parseInt(detail[7]));
			    res.setFT2(res.getFT2()+Integer.parseInt(detail[8]));
			    res.setTeam2Off(res.getTeam2Off()+Integer.parseInt(detail[9]));
			    res.setTeam2Def(res.getTeam2Def()+Integer.parseInt(detail[10]));
			    res.setTeam2bank(res.getTeam2bank()+Integer.parseInt(detail[11]));
			    res.setAss2(res.getAss2()+Integer.parseInt(detail[12]));
			    res.setSteal2(res.getSteal2()+Integer.parseInt(detail[13]));
			    res.setRejection2(res.getRejection2()+Integer.parseInt(detail[14]));
			    res.setTo2(res.getTo2()+Integer.parseInt(detail[15]));
			    res.setFoul2(res.getFoul2()+Integer.parseInt(detail[16]));
			    data = br.readLine();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return res;
	}

	public ArrayList<TeamDataPO> readTeamfile() {
		ArrayList<TeamDataPO> teams = new ArrayList<TeamDataPO>();
		TeamDataPO team = new TeamDataPO();

		try {
			File f = new File(Teamfilename);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String data = br.readLine();// 一次读入一行，直到读入null为文件结束

			while (data != null) {
				team = new TeamDataPO();
				while (data.contains("═")) {
					data = br.readLine();
				}
				String[] temp = data.split("║");
				String[] teamData = temp[1].split("│");
				team.setName(teamData[0].trim());
				team.setShortName(teamData[1].trim());
				team.setCity(teamData[2].trim());
				team.setEorW(teamData[3].trim());
				team.setArea(teamData[4].trim());
				team.setMainposition(teamData[5].trim());
				team.setBuildyear(Integer.parseInt(teamData[6].trim()));
				teams.add(team);
				data=br.readLine();
				if(data.contains("═")){
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return teams;
	}
	
	//获得所有比赛文件的完整路径返回String[]
	public String[] getAllMathcFielName(){
		File file=new File(MatchFileName);
		String[] wholeNameList=new String[file.list().length];
		for(int i=0;i<file.list().length;i++){
			wholeNameList[i]=MatchFileName+"/"+file.list()[i];
		}
		return wholeNameList;
	}
}
