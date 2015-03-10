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

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getShortName() {
		return ShortName;
	}

	public void setShortName(String shortName) {
		ShortName = shortName;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getEorW() {
		return EorW;
	}

	public void setEorW(String eorW) {
		EorW = eorW;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getMainposition() {
		return mainposition;
	}

	public void setMainposition(String mainposition) {
		this.mainposition = mainposition;
	}

	public int getBuildyear() {
		return buildyear;
	}

	public void setBuildyear(int buildyear) {
		this.buildyear = buildyear;
	}

	public int getMatchNumber() {
		return MatchNumber;
	}

	public void setMatchNumber(int matchNumber) {
		MatchNumber = matchNumber;
	}

	public int getShootNumber() {
		return ShootNumber;
	}

	public void setShootNumber(int shootNumber) {
		ShootNumber = shootNumber;
	}

	public double getShootNumberPG() {
		return ShootNumberPG;
	}

	public void setShootNumberPG(double shootNumberPG) {
		ShootNumberPG = shootNumberPG;
	}

	public int getShootEffNumber() {
		return ShootEffNumber;
	}

	public void setShootEffNumber(int shootEffNumber) {
		ShootEffNumber = shootEffNumber;
	}

	public double getShootEffNumberPG() {
		return ShootEffNumberPG;
	}

	public void setShootEffNumberPG(double shootEffNumberPG) {
		ShootEffNumberPG = shootEffNumberPG;
	}

	public int getTPNumber() {
		return TPNumber;
	}

	public void setTPNumber(int tPNumber) {
		TPNumber = tPNumber;
	}

	public double getTPNumberPG() {
		return TPNumberPG;
	}

	public void setTPNumberPG(double tPNumberPG) {
		TPNumberPG = tPNumberPG;
	}

	public int getTPEffNumber() {
		return TPEffNumber;
	}

	public void setTPEffNumber(int tPEffNumber) {
		TPEffNumber = tPEffNumber;
	}

	public double getTPEffNumberPG() {
		return TPEffNumberPG;
	}

	public void setTPEffNumberPG(double tPEffNumberPG) {
		TPEffNumberPG = tPEffNumberPG;
	}

	public int getFTEffNumber() {
		return FTEffNumber;
	}

	public void setFTEffNumber(int fTEffNumber) {
		FTEffNumber = fTEffNumber;
	}

	public double getFTEffNumberPG() {
		return FTEffNumberPG;
	}

	public void setFTEffNumberPG(double fTEffNumberPG) {
		FTEffNumberPG = fTEffNumberPG;
	}

	public int getFTNumber() {
		return FTNumber;
	}

	public void setFTNumber(int fTNumber) {
		FTNumber = fTNumber;
	}

	public double getFTNumberPG() {
		return FTNumberPG;
	}

	public void setFTNumberPG(double fTNumberPG) {
		FTNumberPG = fTNumberPG;
	}

	public int getOffBackBoard() {
		return OffBackBoard;
	}

	public void setOffBackBoard(int offBackBoard) {
		OffBackBoard = offBackBoard;
	}

	public double getOffBackBoardPG() {
		return OffBackBoardPG;
	}

	public void setOffBackBoardPG(double offBackBoardPG) {
		OffBackBoardPG = offBackBoardPG;
	}

	public int getDefBackBoard() {
		return DefBackBoard;
	}

	public void setDefBackBoard(int defBackBoard) {
		DefBackBoard = defBackBoard;
	}

	public double getDefBackBoradPG() {
		return DefBackBoradPG;
	}

	public void setDefBackBoradPG(double defBackBoradPG) {
		DefBackBoradPG = defBackBoradPG;
	}

	public int getBackBoard() {
		return BackBoard;
	}

	public void setBackBoard(int backBoard) {
		BackBoard = backBoard;
	}

	public double getBackBoardPG() {
		return BackBoardPG;
	}

	public void setBackBoardPG(double backBoardPG) {
		BackBoardPG = backBoardPG;
	}

	public int getAssitNumber() {
		return AssitNumber;
	}

	public void setAssitNumber(int assitNumber) {
		AssitNumber = assitNumber;
	}

	public double getAssitNumberPG() {
		return AssitNumberPG;
	}

	public void setAssitNumberPG(double assitNumberPG) {
		AssitNumberPG = assitNumberPG;
	}

	public int getStealNumber() {
		return StealNumber;
	}

	public void setStealNumber(int stealNumber) {
		StealNumber = stealNumber;
	}

	public double getStealNumberPG() {
		return StealNumberPG;
	}

	public void setStealNumberPG(double stealNumberPG) {
		StealNumberPG = stealNumberPG;
	}

	public int getRejection() {
		return Rejection;
	}

	public void setRejection(int rejection) {
		Rejection = rejection;
	}

	public double getRejectionPG() {
		return RejectionPG;
	}

	public void setRejectionPG(double rejectionPG) {
		RejectionPG = rejectionPG;
	}

	public int getTo() {
		return To;
	}

	public void setTo(int to) {
		To = to;
	}

	public double getToPG() {
		return ToPG;
	}

	public void setToPG(double toPG) {
		ToPG = toPG;
	}

	public int getFoul() {
		return Foul;
	}

	public void setFoul(int foul) {
		Foul = foul;
	}

	public double getFoulPG() {
		return FoulPG;
	}

	public void setFoulPG(double foulPG) {
		FoulPG = foulPG;
	}

	public int getPTS() {
		return PTS;
	}

	public void setPTS(int pTS) {
		PTS = pTS;
	}

	public double getPPG() {
		return PPG;
	}

	public void setPPG(double pPG) {
		PPG = pPG;
	}

	public double getShootEff() {
		return ShootEff;
	}

	public void setShootEff(double shootEff) {
		ShootEff = shootEff;
	}

	public double getTPEff() {
		return TPEff;
	}

	public void setTPEff(double tPEff) {
		TPEff = tPEff;
	}

	public double getFTEff() {
		return FTEff;
	}

	public void setFTEff(double fTEff) {
		FTEff = fTEff;
	}

	public double getWR() {
		return WR;
	}

	public void setWR(double wR) {
		WR = wR;
	}

	public int getOff() {
		return Off;
	}

	public void setOff(int off) {
		Off = off;
	}

	public double getOffPG() {
		return OffPG;
	}

	public void setOffPG(double offPG) {
		OffPG = offPG;
	}

	public int getDef() {
		return Def;
	}

	public void setDef(int def) {
		Def = def;
	}

	public double getDefPG() {
		return DefPG;
	}

	public void setDefPG(double defPG) {
		DefPG = defPG;
	}

	public double getOffEff() {
		return OffEff;
	}

	public void setOffEff(double offEff) {
		OffEff = offEff;
	}

	public double getDefEff() {
		return DefEff;
	}

	public void setDefEff(double defEff) {
		DefEff = defEff;
	}

	public double getBackBoardEff() {
		return BackBoardEff;
	}

	public void setBackBoardEff(double backBoardEff) {
		BackBoardEff = backBoardEff;
	}

	public double getStealEff() {
		return StealEff;
	}

	public void setStealEff(double stealEff) {
		StealEff = stealEff;
	}

	public double getAssistEff() {
		return AssistEff;
	}

	public void setAssistEff(double assistEff) {
		AssistEff = assistEff;
	}
	
}
