package bussinesslogic.player;

import java.util.ArrayList;

import data.po.PlayerDataPO;
import assistance.GetFileData;
import bslogicService.PlayerInfoService;

public class PlayerLogic implements PlayerInfoService{
	GetFileData g = new GetFileData();
	PlayerDataPO AllInfo = new PlayerDataPO();
	public void analysData(String name) {
		// TODO Auto-generated method stub
		String filepath = "" + name;
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
	public void getTeam(String name){
		
	}
	public void calculateGP(String name){
		
	}
	public void calculateGS(String name){
		
	}
	public void calculateBackboard(String name){
		
	}
	public void calculateBPG(){
		
	}
	public void calculateAssist(String name){
		
	}
	public void calculateAPG(){
		
	}
	public void calculateMinutesOnField(String name){
		
	}
	public void calculateMPG(){
		
	}
	public void calculateFieldGoalPercentage(String name){
		
	}
	public void calculateThreePGPercentage(String name){
		
	}
	public void calculateFTPercentage(String name){
		
	}
	public void  calculateOff(String name){//进攻数
	
	}
	public void  calculateOffPG(){
		//场均
	}
	
	public void  calculateDef(String name){
		//防守数
	}
	public void  calculateDefPG(){
		//场均
	}
	
	public void  calculateSteal(){
		//抢断数
	}
	public void  calculateStealPG(){
		//场均抢断
	}
	
	public void calculateRejection(){
		//盖帽数
	}
	public void  calculateRPG(){
		//场均盖帽
	}
	
	public void calculateTo(){
		//失误
	}
	public void calculateToPG(){
		//场均失误
	}
	
	public void  calculatefoul(){
		//犯规
	}
	public void  calculatefoulPG(){
		//场均犯规
	}
	
	public void calculatePTS(){
		//得分
	}
	public void calculatePPG(){
		//场均得分
	}
	
	public void  calculateEff(){
		//效率
	}
	
	public void calculateGmsc(){
		
	};//GMSC效率
	
	public void  calculateTruePercentage(){
		//真实命中率
	}
	
	public void  calculateShootEff(){
		//投篮效率，
	}
	
	public void calcuateBackboardEff(){
		//篮板率，
	}
	
	public void  calculateOffBEff(){
		//进攻篮板率，
	}
	
	public void calculateDefBEff(){
		//防守篮板率，
	}
	
	public void calculateAssitEff(){
		//助攻率，
	}
	
	public void  calculateStealEff(){
		//抢断率，
	}
	
	public void calculateRejectionEff(){
		//盖帽率，
	}
	
	public void calculateToEff(){
		//失误率，
	}
	
	public void calculateUseEff(){
		
	}
}
