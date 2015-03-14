package bussinesslogic.player;

import java.io.File;

import assistance.GetFileData;
import bslogicService.PlayerInfoService;
import data.po.MatchDataPO;
import data.po.PlayerDataPO;

public class PlayerLogic implements PlayerInfoService{
	GetFileData g = new GetFileData();
	PlayerDataPO AllInfo = new PlayerDataPO();
	public void analysData(String name) {
		// TODO Auto-generated method stub
		String filepath = "D:/学习/软工3/CSEIII data/迭代一数据/players/info/" + name;
		String basicInfo = g.readPlayerfile(filepath);
		String[] tempbasic = basicInfo.split("\n");
		AllInfo.setName(tempbasic[0]);
		AllInfo.setNumber(tempbasic[1]);
		AllInfo.setPosition(tempbasic[2]);
		AllInfo.setHeight(tempbasic[3]);
		AllInfo.setWeight(Double.valueOf(tempbasic[4]));
		AllInfo.setBirth(tempbasic[5]);
		AllInfo.setAge(Integer.valueOf(tempbasic[6]));
		AllInfo.setExp(Integer.valueOf(tempbasic[7]));
		AllInfo.setSchool(tempbasic[8]);
	}
	public void getAllMatch(String filepath,String name){
		
		
		int GP = 0;//比赛场数
		int GS = 0;//先发场数
		
		int totalb = 0;//球队总篮板
		int totalbother = 0;//对方球队总篮板
		int Offb = 0;//进攻篮板
		int Defb = 0;
		int backboard = 0;//总篮板
		double BPG;//场均篮板
		
		int assist = 0;//助攻数
		double APG;// 场均助攻
		
		double totalminute = 0;//球队总上场时间
		double MinutesOnField = 0;//在场时间
		double MPG = 0;//场均时间
		
		int OtherTotalFieldGoal = 0;//对面球队出手次数
		int TotalGoal = 0;//球队总出手
		int FieldGoal = 0;//投篮命中
		int TotalFieldGoal = 0;//投篮总数
		double FieldGoalPercentage ;//投篮命中率
		
		int ThreeGoal = 0;//三分命中个数
		int TotalThreeGoal = 0;//三分总出手
		double ThreePGPercentage ;//三分命中率
		
		int AllFT = 0;//球队罚球次数
		int FT = 0;//罚球命中
		int TotalFT = 0;
		double FTPercentage ;//罚球命中率，Free Throw
		
		int TotalOffb = 0;//对手进攻次数
		int Off = 0;//进攻数
		double OffPG = 0;//场均
		
		int Def = 0;//防守数
		double DefPG = 0;//场均
		
		int Steal = 0;//抢断数
		double StealPG = 0;//场均抢断
		
		int Rejection = 0;//盖帽数
		double RPG = 0;//场均盖帽
		
		int AllTo = 0;//球队总失误
		int To = 0;//失误
		double ToPG = 0;//场均失误
		
		int foul = 0;//犯规
		double foulPG = 0;//场均犯规
		
		int PTS = 0;//得分
		double PPG = 0;//场均得分
		
		double Eff;//效率
		
		double Gmsc;//GMSC效率
		
		double TruePercentage;//真实命中率
		
		double ShootEff;//投篮效率，
		
		double BackboardEff;//篮板率，
		
		double OffBEff;//进攻篮板率，
		
		double DefBEff;//防守篮板率，
		
		double AssitEff;//助攻率，
		
		double StealEff;//抢断率，
		
		double RejectionEff;//盖帽率，
		
		double ToEff;//失误率，
		
		double UseEff;//使用率

		int Double = 0;//两双
		
		
		File root = new File(filepath);
		File[] files = root.listFiles();
		for(File file:files){
			MatchDataPO m = g.readMatchfile(file.getAbsolutePath());
			int firstb = 0;//球队总篮板
			double firsttotaltime = 0;//球队上场总时间
			int firstGoal = 0;//球队进球次数
			int firstFT = 0;//球队罚球次数
			int firstOffb = 0;//球队总进攻篮板
			int firstTo = 0;//球队总失误
			int secondb = 0;//球队总篮板
			double secondtotaltime = 0;//球队上场总时间
			int secondGoal = 0;//球队进球次数
			int secondFT = 0;//球队罚球次数
			int secondOffb = 0;//球队总进攻篮板
			int secondTo = 0;//球队总失误
			for(int i = 1;i<m.firstTeamInfo.size();i++){//整个球队的数据
				int fminute = 0;
				int fseconds = 0;
				String[] temp = m.firstTeamInfo.get(i).split(";");
				firstb = firstb + Integer.valueOf(temp[11]);
				
				try{
				String[] ftime = temp[2].split(":");
				if(temp[2].equals(null)){
					
				}
				else{
				fminute = Integer.valueOf(ftime[0]);//time
				fseconds = Integer.valueOf(ftime[1]);
				}
				firsttotaltime = firsttotaltime + fminute*60+fseconds;
				}
				catch(Exception e){
					
				}
				
				firstGoal = firstGoal + Integer.valueOf(temp[3]);
				firstFT = firstFT + Integer.valueOf(temp[8]);
				firstOffb = firstOffb + Integer.valueOf(temp[9]);
				firstTo = firstTo + Integer.valueOf(temp[15]);
			}
			
			for(int i = 1;i<m.secondTeamInfo.size();i++){//整个球队的数据
				int fminute = 0;
				int fseconds = 0;
				
				String[] temp = m.secondTeamInfo.get(i).split(";");
				secondb = secondb + Integer.valueOf(temp[11]);
				
				try{
				String[] ftime = temp[2].split(":");
				if(temp[2].equals(null)){
					
				}
				else{
				 fminute = Integer.valueOf(ftime[0]);//time
				fseconds = Integer.valueOf(ftime[1]);
				}
				secondtotaltime = secondtotaltime + fminute*60+fseconds;
			
				}
				catch(Exception e){
					
				}
				
				secondGoal = secondGoal + Integer.valueOf(temp[3]);
				secondFT = secondFT + Integer.valueOf(temp[8]);
				secondOffb = secondOffb + Integer.valueOf(temp[9]);
				secondTo = secondTo + Integer.valueOf(temp[15]);
			}
			
			for(int i = 1;i<m.firstTeamInfo.size();i++){				
				
				String[] temp = m.firstTeamInfo.get(i).split(";");
				
				if(temp[0].equals(name)){
					AllInfo.setTeamName(m.firstTeamInfo.get(0));
					
					totalb = totalb + firstb;
					totalbother = totalbother + secondb;
					totalminute = totalminute + firsttotaltime;
					TotalGoal = TotalGoal + firstGoal;
					OtherTotalFieldGoal = OtherTotalFieldGoal + secondGoal;
					AllFT = AllFT + firstFT;
					TotalOffb = TotalOffb + secondOffb;
					AllTo = AllTo + firstTo;
					
					GP++;
					if(!temp[1].equals("")){
						GS++;
					}
					
					try{
					String[] time = temp[2].split(":");
					int minute = 0;
					int seconds = 0;
					if(temp[2].equals(null)){
						
					}
					else{
					minute = Integer.valueOf(time[0]);//time
					seconds = Integer.valueOf(time[1]);
					}
					MinutesOnField = MinutesOnField + minute*60+seconds;
					}catch(Exception e){
						
					}
					
					FieldGoal = FieldGoal + Integer.valueOf(temp[3]);
					TotalFieldGoal = TotalFieldGoal + Integer.valueOf(temp[4]);
					
					ThreeGoal = ThreeGoal + Integer.valueOf(temp[5]);
					TotalThreeGoal = TotalThreeGoal + Integer.valueOf(temp[6]);
					
					FT = FT + Integer.valueOf(temp[7]);
					TotalFT = TotalFT + Integer.valueOf(temp[8]);
					
					Offb = Offb + Integer.valueOf(temp[9]);
					
					Defb = Defb + Integer.valueOf(temp[10]);
					
					backboard = backboard + Integer.valueOf(temp[11]);
					
					assist = assist + Integer.valueOf(temp[12]);
					
					Rejection = Rejection + Integer.valueOf(temp[14]);
					
					Steal = Steal + Integer.valueOf(temp[13]);
					
					To = To + Integer.valueOf(temp[15]);
					
					foul = foul + Integer.valueOf(temp[16]);
					
					PTS = PTS + Integer.valueOf(temp[17]);
					
					int tempd = 0;
					if(PTS>=10){
						tempd++;
					}
					if(backboard>=10){
						tempd++;
					}
					if(assist>=10){
						tempd++;
					}
					if(Rejection>=10){
						tempd++;
					}
					if(Steal>=10){
						tempd++;
					}
					if(tempd>=2){
						Double++;
					}
					
					break;
				}
			}
			for(int i = 1;i<m.secondTeamInfo.size();i++){
				String[] temp = m.secondTeamInfo.get(i).split(";");
				if(temp[0].equals(name)){
					AllInfo.setTeamName(m.secondTeamInfo.get(0));
					
					totalb = totalb + secondb;
					totalbother = totalbother + firstb;
					totalminute = totalminute + secondtotaltime;
					TotalGoal = TotalGoal + secondGoal;
					OtherTotalFieldGoal = OtherTotalFieldGoal + firstGoal;
					AllFT = AllFT + secondFT;
					TotalOffb = TotalOffb + firstOffb;
					AllTo = AllTo + secondTo;
					
					GP++;
					if(!temp[1].equals(null)){
						GS++;
					}
					
					try{
					String[] time = temp[2].split(":");
					int minute = 0;
					int seconds = 0;
					if(temp[2].equals("")){
						
					}
					else{
					minute = Integer.valueOf(time[0]);//time
					seconds = Integer.valueOf(time[1]);
					}
					MinutesOnField = MinutesOnField + minute*60+seconds;
					}catch(Exception e){
						
					}
					
					FieldGoal = FieldGoal + Integer.valueOf(temp[3]);
					TotalFieldGoal = TotalFieldGoal + Integer.valueOf(temp[4]);
					
					ThreeGoal = ThreeGoal + Integer.valueOf(temp[5]);
					TotalThreeGoal = TotalThreeGoal + Integer.valueOf(temp[6]);
					
					FT = FT + Integer.valueOf(temp[7]);
					TotalFT = TotalFT + Integer.valueOf(temp[8]);
					
					Offb = Offb + Integer.valueOf(temp[9]);
					
					Defb = Defb + Integer.valueOf(temp[10]);
					
					backboard = backboard + Integer.valueOf(temp[11]);
					
					assist = assist + Integer.valueOf(temp[12]);
					
					Rejection = Rejection + Integer.valueOf(temp[14]);
					
					Steal = Steal + Integer.valueOf(temp[13]);
					
					To = To + Integer.valueOf(temp[15]);
					
					foul = foul + Integer.valueOf(temp[16]);
					
					PTS = PTS + Integer.valueOf(temp[17]);
					
					int tempd = 0;
					if(PTS>=10){
						tempd++;
					}
					if(backboard>=10){
						tempd++;
					}
					if(assist>=10){
						tempd++;
					}
					if(Rejection>=10){
						tempd++;
					}
					if(Steal>=10){
						tempd++;
					}
					if(tempd>=2){
						Double++;
					}
					break;
				}
			}
			
		}
		
		BPG = backboard/(double)GP;
		APG = assist/(double)GP;
		MPG = MinutesOnField/(double)GP;
		FieldGoalPercentage = FieldGoal/(double)TotalFieldGoal;
		ThreePGPercentage = ThreeGoal/(double)TotalThreeGoal;
		FTPercentage = FT/(double)TotalFT;
		Off = Offb;//进攻数
		OffPG = Off/(double)GP;
		Def = Defb;//防守数
		DefPG = Def/(double)GP;
		StealPG = Steal/(double)GP;
		RPG = Rejection/(double)GP;
		ToPG = To/(double)GP;
		foulPG = foul/(double)GP;
		PPG = PTS/(double)GP;
		Eff =  (PTS+backboard+assist+Steal+Rejection)-(TotalFieldGoal-FieldGoal)-(TotalFT-FT)-To; 
		Gmsc = PTS+0.4*FieldGoal-0.7*TotalFieldGoal-0.4*(TotalFT-FT)+0.7*Offb+0.3*Defb+Steal+0.7*assist+0.7*Rejection
				-0.4*foul-To; 
		TruePercentage =  PTS/(double)(2*(TotalFieldGoal+0.44*TotalFT));
		ShootEff = (FieldGoal+0.5*ThreeGoal)/(double)TotalFieldGoal;//投篮效率，	
		BackboardEff = backboard*((double)totalminute/5)/(double)MinutesOnField/(totalb+totalbother) ;//篮板率，		
		OffBEff = Offb*((double)totalminute/5)/(double)MinutesOnField/(totalb+totalbother) ;//进攻篮板率，		
		DefBEff = Defb*((double)totalminute/5)/(double)MinutesOnField/(totalb+totalbother) ;//防守篮板率，		
		AssitEff = assist/((double)MinutesOnField/((double)totalminute/5)*TotalGoal-TotalFieldGoal) ;//助攻率，		
		StealEff = Steal*((double)totalminute/5)/(double)MinutesOnField/TotalOffb;//抢断率，		
		RejectionEff = Rejection*((double)totalminute/5)/(double)MinutesOnField/OtherTotalFieldGoal;//盖帽率，		
		ToEff = To/(double)(TotalFieldGoal-TotalThreeGoal+0.44*TotalFT+To) ;//失误率，		
		UseEff =  (TotalFieldGoal+0.44*TotalFT+To)*(totalminute/5)/(double)MinutesOnField/(TotalGoal+0.44*AllFT
						+AllTo) ;//使用率
		
		AllInfo.setGP(GP);
		AllInfo.setGS(GS);
		AllInfo.setBackboard(backboard);
		AllInfo.setBPG(BPG);
		AllInfo.setAssist(assist);
		AllInfo.setAPG(APG);
		AllInfo.setMinutesOnField(MinutesOnField);
		AllInfo.setMPG(MPG);
		AllInfo.setFieldGoalPercentage(FieldGoalPercentage);
		AllInfo.setThreePGPercentage(ThreePGPercentage);
		AllInfo.setFTPercentage(FTPercentage);
		AllInfo.setOff(Off);
		AllInfo.setOffPG(OffPG);//off
		AllInfo.setDef(Def);
		AllInfo.setDefPG(DefPG);//def
		AllInfo.setSteal(Steal);
		AllInfo.setStealPG(StealPG);
		AllInfo.setRejection(Rejection);
		AllInfo.setRPG(RPG);
		AllInfo.setTo(To);
		AllInfo.setToPG(ToPG);
		AllInfo.setFoul(foul);
		AllInfo.setFoulPG(foulPG);
		AllInfo.setPTS(PTS);
		AllInfo.setPPG(PPG);
		AllInfo.setEff(Eff);
		AllInfo.setGmsc(Gmsc);
		AllInfo.setTruePercentage(TruePercentage);
		AllInfo.setShootEff(ShootEff);
		AllInfo.setBackboardEff(BackboardEff);
		AllInfo.setOffBEff(OffBEff);
		AllInfo.setDefBEff(DefBEff);
		AllInfo.setAssitEff(AssitEff);
		AllInfo.setStealEff(StealEff);//steal
		AllInfo.setRejectionEff(RejectionEff);
		AllInfo.setToEff(ToEff);
		AllInfo.setUseEff(UseEff);
		AllInfo.setDouble(Double);
	}
	public PlayerDataPO getpo(){
		return AllInfo;
	}
}