package data.po;


public class TeamDataPO {
	String Name;//队名
	String ShortName; //缩写
	String City;//城市
	String EorW;//东西部
	String Area;//分区
	String Mainposition;//场馆
	String Players;  //球员
	int Buildyear;//年份	
	double MatchNumber;//比赛场数	
	double WinMatch; //胜场数	
	
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
	
	double OffBackBoard;//进攻篮板
	double OffBackBoardPG;//场均
	
	double DefBackBoard;//防守篮板
	double DefBackBoardPG;//场均
	
	double OtherDefBoard;//对手后场篮板
	double OtherOffBoard;//对手前场篮板
	
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
	
	double LPS;//比赛失分
	double LPG;//场均失分
	
	

	double ShootEff;//投篮命中率，
	
	double TPEff;//三分命中率，
	
	double FTEff;//罚球命中率，
	
	double WR;//胜率，
	
	double Off;//进攻回合，
	double OffPG;
	
	double Def;//防守回合，
	double DefPG;
	
	double OffEff;//进攻效率，
	
	double DefEff;//防守效率，
	
	double OffBackBoardEff;//进攻篮板效率，
	
	double BackBoardEff;//篮板效率，
	
	double DefBackBoardEff;//防守篮板效率，
	
	double StealEff;//抢断效率，
	
	double AssistEff;//助攻率

	
	
	public double getLPS() {
		return LPS;
	}

	
	public void setLPS(double lPS) {
		LPS = lPS;
	}

	public double getLPG() {
		return LPG;
	}

	
	public void setLPG(double lPG) {
		LPG = lPG;
	}

	
	
	public double getWinMatch() {
		return WinMatch;
	}

	public void setWinMatch(double d) {
		WinMatch = d;
	}
	
	public String getPlayers() {
		return Players;
	}

	
	public void setPlayers(String players) {
		this.Players = players;
	}
	
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
		return Area;
	}

	public void setArea(String area) {
		this.Area = area;
	}

	public String getMainposition() {
		return Mainposition;
	}

	public void setMainposition(String mainposition) {
		this.Mainposition = mainposition;
	}

	public int getBuildyear() {
		return Buildyear;
	}

	public void setBuildyear(int buildyear) {
		this.Buildyear = buildyear;
	}

	public double getMatchNumber() {
		return MatchNumber;
	}

	public void setMatchNumber(double d) {
		MatchNumber = d;
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

	public double getOffBackBoard() {
		return OffBackBoard;
	}

	public void setOffBackBoard(double d) {
		OffBackBoard = d;
	}

	public double getOffBackBoardPG() {
		return OffBackBoardPG;
	}

	public void setOffBackBoardPG(double offBackBoardPG) {
		OffBackBoardPG = offBackBoardPG;
	}

	public double getDefBackBoard() {
		return DefBackBoard;
	}

	public void setDefBackBoard(double d) {
		DefBackBoard = d;
	}
	
	
	public double getDefBackBoardPG() {
		return DefBackBoardPG;
	}

	public void setDefBackBoardPG(double defBackBoradPG) {
		DefBackBoardPG = defBackBoradPG;
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

	public double getOff() {
		return Off;
	}

	public void setOff(double d) {
		Off = d;
	}

	public double getOffPG() {
		return OffPG;
	}

	public void setOffPG(double offPG) {
		OffPG = offPG;
	}

	public double getDef() {
		return Def;
	}

	public void setDef(double d) {
		Def = d;
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
	
	public double getOffBackBoardEff() {
		return OffBackBoardEff;
	}

	public void setOffBackBoardEff(double offbackBoardEff) {
		OffBackBoardEff = offbackBoardEff;
	}
	
	public double getDefBackBoardEff() {
		return DefBackBoardEff;
	}

	public void setDefBackBoardEff(double defbackBoardEff) {
		DefBackBoardEff = defbackBoardEff;
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


	/**
	 * @return the otherDefBoard
	 */
	public double getOtherDefBoard() {
		return OtherDefBoard;
	}


	/**
	 * @param otherDefBoard the otherDefBoard to set
	 */
	public void setOtherDefBoard(double otherDefBoard) {
		OtherDefBoard = otherDefBoard;
	}


	/**
	 * @return the otherOffBoard
	 */
	public double getOtherOffBoard() {
		return OtherOffBoard;
	}


	/**
	 * @param otherOffBoard the otherOffBoard to set
	 */
	public void setOtherOffBoard(double otherOffBoard) {
		OtherOffBoard = otherOffBoard;
	}
	
}
