package bussinesslogic.player;

import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import rmiLink.PlayerRmi;
import assistance.GetFileData;
import bslogicService.PlayerInfoService;
import data.po.MatchDataPO;
import data.po.PlayerDataPO;

public class PlayerLogic implements PlayerInfoService{
	GetFileData g = new GetFileData();
	PlayerDataPO AllInfo = new PlayerDataPO();
	PlayerRmi p = new PlayerRmi();
	public void analysData(String name) {
		// TODO Auto-generated method stub
		String filepath = "./迭代一数据/players/info/" + name;
		//System.out.println(filepath);
		String basicInfo = g.readPlayerfile(filepath);
		String[] tempbasic = basicInfo.split("\n");

		AllInfo.setName(tempbasic[0]);
		AllInfo.setNumber(tempbasic[1]);
		AllInfo.setPosition(tempbasic[2]);
		AllInfo.setHeight(tempbasic[3]);
		AllInfo.setWeight(Double.valueOf(tempbasic[4]));
		AllInfo.setBirth(tempbasic[5]);
		AllInfo.setAge(Integer.valueOf(tempbasic[6]));
		if(tempbasic[7].equals("R")){
			AllInfo.setExp(0);
		}
		else{
			AllInfo.setExp(Integer.valueOf(tempbasic[7]));
		}
		
		AllInfo.setSchool(tempbasic[8]);
		getAllMatch("./迭代一数据/matches",name);
	}
	public void getAllMatch(String filepath,String name){
		
		int GP = 0;//姣旇禌鍦烘暟
		int GS = 0;//鍏堝彂鍦烘暟
		
		int totalb = 0;//鐞冮槦鎬荤鏉�
		int totalbother = 0;//瀵规柟鐞冮槦鎬荤鏉�
		int Offb = 0;//杩涙敾绡澘
		int Defb = 0;
		int backboard = 0;//鎬荤鏉�
		double BPG;//鍦哄潎绡澘
		
		int assist = 0;//鍔╂敾鏁�
		double APG;// 鍦哄潎鍔╂敾
		
		double totalminute = 0;//鐞冮槦鎬讳笂鍦烘椂闂�
		double MinutesOnField = 0;//鍦ㄥ満鏃堕棿
		double MPG = 0;//鍦哄潎鏃堕棿
		
		int OtherTotalFieldGoal = 0;//瀵归潰鐞冮槦鍑烘墜娆℃暟
		int TotalGoal = 0;//鐞冮槦鎬诲嚭鎵�
		int FieldGoal = 0;//鎶曠鍛戒腑
		int TotalFieldGoal = 0;//鎶曠鎬绘暟
		double FieldGoalPercentage ;//鎶曠鍛戒腑鐜�
		
		int ThreeGoal = 0;//涓夊垎鍛戒腑涓暟
		int TotalThreeGoal = 0;//涓夊垎鎬诲嚭鎵�
		double ThreePGPercentage ;//涓夊垎鍛戒腑鐜�
		
		int AllFT = 0;//鐞冮槦缃氱悆娆℃暟
		int FT = 0;//缃氱悆鍛戒腑
		int TotalFT = 0;
		double FTPercentage ;//缃氱悆鍛戒腑鐜囷紝Free Throw
		
		int TotalOffb = 0;//瀵规墜杩涙敾娆℃暟
		int Off = 0;//杩涙敾鏁�
		double OffPG = 0;//鍦哄潎
		
		int Def = 0;//闃插畧鏁�
		double DefPG = 0;//鍦哄潎
		
		int Steal = 0;//鎶㈡柇鏁�
		double StealPG = 0;//鍦哄潎鎶㈡柇
		
		int Rejection = 0;//鐩栧附鏁�
		double RPG = 0;//鍦哄潎鐩栧附
		
		int AllTo = 0;//鐞冮槦鎬诲け璇�
		int To = 0;//澶辫
		double ToPG = 0;//鍦哄潎澶辫
		
		int foul = 0;//鐘
		double foulPG = 0;//鍦哄潎鐘
		
		int PTS = 0;//寰楀垎
		double PPG = 0;//鍦哄潎寰楀垎
		
		double Eff;//鏁堢巼
		
		double Gmsc;//GMSC鏁堢巼
		
		double TruePercentage;//鐪熷疄鍛戒腑鐜�
		
		double ShootEff;//鎶曠鏁堢巼锛�
		
		double BackboardEff;//绡澘鐜囷紝
		
		double OffBEff;//杩涙敾绡澘鐜囷紝
		
		double DefBEff;//闃插畧绡澘鐜囷紝
		
		double AssitEff;//鍔╂敾鐜囷紝
		
		double StealEff;//鎶㈡柇鐜囷紝
		
		double RejectionEff;//鐩栧附鐜囷紝
		
		double ToEff;//澶辫鐜囷紝
		
		double UseEff;//浣跨敤鐜�

		int Double = 0;//涓ゅ弻
		
		
		File root = new File(filepath);
		File[] files = root.listFiles();
		for(File file:files){
			MatchDataPO m = g.readMatchfile(file.getAbsolutePath());
			
			int firstb = 0;//鐞冮槦鎬荤鏉�
			double firsttotaltime = 0;//鐞冮槦涓婂満鎬绘椂闂�
			int firstGoal = 0;//鐞冮槦杩涚悆娆℃暟
			int firstFT = 0;//鐞冮槦缃氱悆娆℃暟
			int firstOffb = 0;//鐞冮槦鎬昏繘鏀荤鏉�
			int firstTo = 0;//鐞冮槦鎬诲け璇�
			int secondb = 0;//鐞冮槦鎬荤鏉�
			double secondtotaltime = 0;//鐞冮槦涓婂満鎬绘椂闂�
			int secondGoal = 0;//鐞冮槦杩涚悆娆℃暟
			int secondFT = 0;//鐞冮槦缃氱悆娆℃暟
			int secondOffb = 0;//鐞冮槦鎬昏繘鏀荤鏉�
			int secondTo = 0;//鐞冮槦鎬诲け璇�
			try{
			for(int i = 1;i<m.firstTeamInfo.size();i++){//鏁翠釜鐞冮槦鐨勬暟鎹�
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
			
			for(int i = 1;i<m.secondTeamInfo.size();i++){//鏁翠釜鐞冮槦鐨勬暟鎹�
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
					//System.out.println(file.getAbsolutePath());
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
					try{
						PTS = PTS + Integer.valueOf(temp[17]);
					}
					catch(Exception e){
					
					}
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
					//System.out.println(file.getAbsolutePath());
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
					
					try{
					PTS = PTS + Integer.valueOf(temp[17]);
					}
					catch(Exception e){
						
					}
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
			}catch(Exception e){
				System.out.println(file.getAbsolutePath());
			}
			
		}
		if(GP!=0){
			BPG = backboard/(double)GP;
			APG = assist/(double)GP;
			MPG = MinutesOnField/(double)GP;
			FieldGoalPercentage = FieldGoal/(double)TotalFieldGoal;
			if(TotalThreeGoal!=0){
			ThreePGPercentage = ThreeGoal/(double)TotalThreeGoal;
			}
			else{
				ThreePGPercentage = 0;
			}
			if(TotalFT!=0){
			FTPercentage = FT/(double)TotalFT;
			}
			else{
				FTPercentage = 0;
			}
			Off = Offb;//杩涙敾鏁�
			OffPG = Off/(double)GP;
			Def = Defb;//闃插畧鏁�
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
			ShootEff = (FieldGoal+0.5*ThreeGoal)/(double)TotalFieldGoal;//鎶曠鏁堢巼锛�	
			BackboardEff = backboard*((double)totalminute/5)/(double)MinutesOnField/(totalb+totalbother) ;//绡澘鐜囷紝		
			OffBEff = Offb*((double)totalminute/5)/(double)MinutesOnField/(totalb+totalbother) ;//杩涙敾绡澘鐜囷紝		
			DefBEff = Defb*((double)totalminute/5)/(double)MinutesOnField/(totalb+totalbother) ;//闃插畧绡澘鐜囷紝		
			AssitEff = assist/((double)MinutesOnField/((double)totalminute/5)*TotalGoal-TotalFieldGoal) ;//鍔╂敾鐜囷紝		
			StealEff = Steal*((double)totalminute/5)/(double)MinutesOnField/TotalOffb;//鎶㈡柇鐜囷紝		
			RejectionEff = Rejection*((double)totalminute/5)/(double)MinutesOnField/OtherTotalFieldGoal;//鐩栧附鐜囷紝		
			ToEff = To/(double)(TotalFieldGoal-TotalThreeGoal+0.44*TotalFT+To) ;//澶辫鐜囷紝		
			UseEff =  (TotalFieldGoal+0.44*TotalFT+To)*(totalminute/5)/(double)MinutesOnField/(TotalGoal+0.44*AllFT
						+AllTo) ;//浣跨敤鐜�
		}
		else{
			BPG = 0;
			APG = 0;
			MPG = 0;
			FieldGoalPercentage = 0;
			ThreePGPercentage = 0;
			FTPercentage = 0;
			Off = 0;//杩涙敾鏁�
			OffPG = 0;
			Def = 0;//闃插畧鏁�
			DefPG = 0;
			StealPG =0;
			RPG = 0;
			ToPG = 0;
			foulPG =0;
			PPG = 0;
			Eff =  0; 
			Gmsc = 0; 
			TruePercentage =  0;
			ShootEff = 0;//鎶曠鏁堢巼锛�	
			BackboardEff = 0;//绡澘鐜囷紝		
			OffBEff = 0;//杩涙敾绡澘鐜囷紝		
			DefBEff = 0;//闃插畧绡澘鐜囷紝		
			AssitEff = 0;//鍔╂敾鐜囷紝		
			StealEff = 0;//鎶㈡柇鐜囷紝		
			RejectionEff = 0;//鐩栧附鐜囷紝		
			ToEff =0 ;//澶辫鐜囷紝		
			UseEff = 0;
		}
		
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
		AllInfo.setFieldGoal(FieldGoal);
		AllInfo.setTotalFieldGoal(TotalFieldGoal);
		AllInfo.setThreeGoal(ThreeGoal);
		AllInfo.setTotalThreeGoal(TotalThreeGoal);
		AllInfo.setFT(FT);
		AllInfo.setTotalFT(TotalFT);
		
		//
		p.addInfo(AllInfo);
	}
	public PlayerDataPO getpo(){
		return AllInfo;
	}
	public PlayerDataPO getInfo(String name) {
		// TODO Auto-generated method stub
		PlayerDataPO res = p.getInfo(name);
		return res;
	}
	public void setOrder(String orderName,boolean isASC) {
		// TODO Auto-generated method stub
		//p.setOrder(orderName, isASC);
	}
	public PlayerDataPO[] getAllInfo() {
		// TODO Auto-generated method stub
		
		PlayerDataPO[] res = p.getAllInfo();
		return res ;
	}
	public PlayerDataPO[] getFirstFifty(String orderName) {
		//PlayerDataPO[] res = p.getFirstFifty(orderName);
		// TODO Auto-generated method stub
		return null ;
	}

	public void initialize(String filepath){
		if(p.judge()==true){
		File root = new File(filepath);
		File[] files = root.listFiles();
		for(File file:files){
			System.out.println(file.getName());
			analysData(file.getName());
		}
		}
		else{
			System.out.println("has initialized");
		}
	}
}