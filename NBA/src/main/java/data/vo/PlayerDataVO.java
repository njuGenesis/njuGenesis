package data.vo;

public class PlayerDataVO {
	String Name;//名字
	String Number;//号码
	String position;//位置
	String Height;//高度
	double Weight;//体重
	String Birth;//生日
	int Age;//年龄
	int Exp;//球龄
	String school;//学校
	String TeamName;//队伍
	int GP;//比赛场数
	int GS;//先发场数
	
	int backboard;//总篮板
	double BPG;//场均篮板
	
	int assist;//助攻数
	double APG;// 场均助攻
	
	double MinutesOnField;//在场时间
	double MPG;//场均时间
	
	double FieldGoalPercentage;//投篮命中率
	
	double ThreePGPercentage;//三分命中率
	
	double FTPercentage;//罚球命中率，Free Throw
	
	int Off;//进攻数
	double OffPG;//场均
	
	int Def;//防守数
	double DefPG;//场均
	
	int Steal;//抢断数
	double StealPG;//场均抢断
	
	int Rejection;//盖帽数
	double RPG;//场均盖帽
	
	int To;//失误
	double ToPG;//场均失误
	
	int foul;//犯规
	double foulPG;//场均犯规
	
	int PTS;//得分
	double PPG;//场均得分
	
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
	
	int Double;//两双
	
	int FieldGoal;//投篮命中数
	int TotalFieldGoal;//总出手数
	
	int ThreeGoal;//三分
	int TotalThreeGoal;
	
	int FT;//罚球
	int TotalFT;
	
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getNumber() {
		return Number;
	}
	public void setNumber(String number) {
		Number = number;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getHeight() {
		return Height;
	}
	public void setHeight(String height) {
		Height = height;
	}
	public double getWeight() {
		return Weight;
	}
	public void setWeight(double weight) {
		Weight = weight;
	}
	public String getBirth() {
		return Birth;
	}
	public void setBirth(String birth) {
		Birth = birth;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public int getExp() {
		return Exp;
	}
	public void setExp(int exp) {
		Exp = exp;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getTeamName() {
		return TeamName;
	}
	public void setTeamName(String teamName) {
		TeamName = teamName;
	}
	public int getGP() {
		return GP;
	}
	public void setGP(int gP) {
		GP = gP;
	}
	public int getGS() {
		return GS;
	}
	public void setGS(int gS) {
		GS = gS;
	}
	public int getBackboard() {
		return backboard;
	}
	public void setBackboard(int backboard) {
		this.backboard = backboard;
	}
	public double getBPG() {
		return BPG;
	}
	public void setBPG(double bPG) {
		BPG = bPG;
	}
	public int getAssist() {
		return assist;
	}
	public void setAssist(int assist) {
		this.assist = assist;
	}
	public double getAPG() {
		return APG;
	}
	public void setAPG(double aPG) {
		APG = aPG;
	}
	public double getMinutesOnField() {
		return MinutesOnField;
	}
	public void setMinutesOnField(double minutesOnField) {
		MinutesOnField = minutesOnField;
	}
	public double getMPG() {
		return MPG;
	}
	public void setMPG(double mPG) {
		MPG = mPG;
	}
	public double getFieldGoalPercentage() {
		return FieldGoalPercentage;
	}
	public void setFieldGoalPercentage(double fieldGoalPercentage) {
		FieldGoalPercentage = fieldGoalPercentage;
	}
	public double getThreePGPercentage() {
		return ThreePGPercentage;
	}
	public void setThreePGPercentage(double threePGPercentage) {
		ThreePGPercentage = threePGPercentage;
	}
	public double getFTPercentage() {
		return FTPercentage;
	}
	public void setFTPercentage(double fTPercentage) {
		FTPercentage = fTPercentage;
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
	public int getSteal() {
		return Steal;
	}
	public void setSteal(int steal) {
		Steal = steal;
	}
	public double getStealPG() {
		return StealPG;
	}
	public void setStealPG(double stealPG) {
		StealPG = stealPG;
	}
	public int getRejection() {
		return Rejection;
	}
	public void setRejection(int rejection) {
		Rejection = rejection;
	}
	public double getRPG() {
		return RPG;
	}
	public void setRPG(double rPG) {
		RPG = rPG;
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
		return foul;
	}
	public void setFoul(int foul) {
		this.foul = foul;
	}
	public double getFoulPG() {
		return foulPG;
	}
	public void setFoulPG(double foulPG) {
		this.foulPG = foulPG;
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
	public double getEff() {
		return Eff;
	}
	public void setEff(double eff) {
		Eff = eff;
	}
	public double getGmsc() {
		return Gmsc;
	}
	public void setGmsc(double gmsc) {
		Gmsc = gmsc;
	}
	public double getTruePercentage() {
		return TruePercentage;
	}
	public void setTruePercentage(double truePercentage) {
		TruePercentage = truePercentage;
	}
	public double getShootEff() {
		return ShootEff;
	}
	public void setShootEff(double shootEff) {
		ShootEff = shootEff;
	}
	public double getBackboardEff() {
		return BackboardEff;
	}
	public void setBackboardEff(double backboardEff) {
		BackboardEff = backboardEff;
	}
	public double getOffBEff() {
		return OffBEff;
	}
	public void setOffBEff(double offBEff) {
		OffBEff = offBEff;
	}
	public double getDefBEff() {
		return DefBEff;
	}
	public void setDefBEff(double defBEff) {
		DefBEff = defBEff;
	}
	public double getAssitEff() {
		return AssitEff;
	}
	public void setAssitEff(double assitEff) {
		AssitEff = assitEff;
	}
	public double getStealEff() {
		return StealEff;
	}
	public void setStealEff(double stealEff) {
		StealEff = stealEff;
	}
	public double getRejectionEff() {
		return RejectionEff;
	}
	public void setRejectionEff(double rejectionEff) {
		RejectionEff = rejectionEff;
	}
	public double getToEff() {
		return ToEff;
	}
	public void setToEff(double toEff) {
		ToEff = toEff;
	}
	public double getUseEff() {
		return UseEff;
	}
	public void setUseEff(double useEff) {
		UseEff = useEff;
	}
	public int getDouble() {
		return Double;
	}
	public void setDouble(int d) {
		Double = d;
	}
	public int getFieldGoal() {
		return FieldGoal;
	}
	public void setFieldGoal(int fieldGoal) {
		FieldGoal = fieldGoal;
	}
	public int getTotalFieldGoal() {
		return TotalFieldGoal;
	}
	public void setTotalFieldGoal(int totalFieldGoal) {
		TotalFieldGoal = totalFieldGoal;
	}
	public int getThreeGoal() {
		return ThreeGoal;
	}
	public void setThreeGoal(int threeGoal) {
		ThreeGoal = threeGoal;
	}
	public int getTotalThreeGoal() {
		return TotalThreeGoal;
	}
	public void setTotalThreeGoal(int totalThreeGoal) {
		TotalThreeGoal = totalThreeGoal;
	}
	public int getFT() {
		return FT;
	}
	public void setFT(int fT) {
		FT = fT;
	}
	public int getTotalFT() {
		return TotalFT;
	}
	public void setTotalFT(int totalFT) {
		TotalFT = totalFT;
	}
	

}
