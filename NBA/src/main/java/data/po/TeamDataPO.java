package data.po;

public class TeamDataPO {
	String Name;//队名
	String ShortName; //缩写
	String City;//城市
	String EorW;//东西部
	String area;//分区
	String mainposition;//场馆
	int buildyear;//年份
	
	int MatchNumber;//比赛场数
	
	int ShootNumber;//投篮数
	double ShootNumberPG;//场均投篮
	
	int ShootEffNumber;//投篮命中数
	double ShootEffNumberPG;//场均
	
	int TPNumber;//三分出手数
	double TPNumberPG;//场均
	
	int TPEffNumber;//三分命中数
	double TPEffNumberPG;//场均
	
	int FTEffNumber;//罚球命中数
	double FTEffNumberPG;//场均
	
	int FTNumber;//罚球出手数
	double FTNumberPG;//场均
	
	int OffBackBoard;//进攻篮板
	double OffBackBoardPG;//场均
	
	int DefBackBoard;//防守篮板
	double DefBackBoradPG;//场均
	
	int BackBoard;//篮板数
	double BackBoardPG;//场均
	
	int AssitNumber;//助攻数
	double AssitNumberPG;
	
	int StealNumber;//抢断数
	double StealNumberPG;
	
	int Rejection;//盖帽数，
	double RejectionPG;
	
	int To;//失误数
	double ToPG;
	
	int Foul;//犯规数，
	double FoulPG;
	
	int PTS;//比赛得分，
	double PPG;
	
	double ShootEff;//投篮命中率，
	
	double TPEff;//三分命中率，
	
	double FTEff;//罚球命中率，
	
	double WR;//胜率，
	
	int Off;//进攻回合，
	double OffPG;
	
	int Def;//防守回合，
	double DefPG;
	
	double OffEff;//进攻效率，
	
	double DefEff;//防守效率，
	
	double BackBoardEff;//篮板效率，
	
	double StealEff;//抢断效率，
	
	double AssistEff;//助攻率
	
}
