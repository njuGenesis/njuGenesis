package presentation.contenui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableUtility {
	
	public static void setTableRowHeight(JTable table,int h){
		table.setRowHeight(h);
	}
	
	public static void setTableHeaderHeight(JTable table,int h){
		table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(),h));
	}
	
	public static void setTabelPanel(JScrollPane tablePanel){
		tablePanel.setOpaque(false);
		tablePanel.getViewport().setOpaque(false);
		tablePanel.setViewportBorder(BorderFactory.createEmptyBorder());
		tablePanel.setBorder(BorderFactory.createEmptyBorder());
	}
	
	public static void setTableColor(JTable table){
		table.setDefaultRenderer(Object.class,new MyCellRenderer());
		setFont(table);
		table.setShowGrid(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	}
	
	public static void setFont(JTable table){
		table.setFont(new Font("微软雅黑",0,12));
		table.getTableHeader().setBackground(new Color(112,112,112));
		table.getTableHeader().setFont(new Font("微软雅黑",0,12));
		table.getTableHeader().setForeground(Color.white);
	}

	public static String getChPosition(String en){
		if(en.contains("-")){
			String[] pos = en.split("-");
			System.out.println(pos[0]+pos[1]);
			return transPosition(pos[0])+"-"+transPosition(pos[1]);
		}else{
			return transPosition(en);
		}
	}
	
	private static String transPosition(String en){
		if(en=="G"){
			return "后卫";
		}else if(en=="F"){
			return "前锋";
		}else if(en=="C"){
			return "中锋";
		}else{
			return "~~~";
		}
	}
	
	public static String getChTeam(String en){
		String ch;
		if(en=="SAS"){
			ch = "圣安东尼奥马刺";
		}else if(en=="MEM"){
			ch = "孟菲斯灰熊";
		}else if(en=="HOU"){
			ch = "休斯顿火箭";
		}else if(en=="DAL"){
			ch = "达拉斯小牛";
		}else if(en=="NOP"){
			ch = "新奥尔良鹈鹕";
		}else if(en=="SAC"){
			ch = "萨克拉门托国王";
		}else if(en=="PHX"){
			ch = "菲尼克斯太阳";
		}else if(en=="GSW"){
			ch = "金州勇士";
		}else if(en=="LAC"){
			ch = "洛杉矶快船";
		}else if(en=="MIN"){
			ch = "明尼苏达森林狼";
		}else if(en=="DEN"){
			ch = "犹他爵士";
		}else if(en=="POR"){
			ch = "波特兰开拓者";
		}else if(en=="OTC"){
			ch = "俄克拉荷马城雷霆";
		}else if(en=="MIA"){
			ch = "迈阿密热火";
		}else if(en=="ORL"){
			ch = "奥兰多魔术";
		}else if(en=="ATL"){
			ch = "亚特兰大老鹰";
		}else if(en=="WAS"){
			ch = "华盛顿奇才";
		}else if(en=="CHA"){
			ch = "夏洛特黄蜂";
		}else if(en=="DET"){
			ch = "底特律活塞";
		}else if(en=="IND"){
			ch = "印第安纳步行者";
		}else if(en=="CLE"){
			ch = "克利夫兰骑士";
		}else if(en=="CHI"){
			ch = "芝加哥公牛";
		}else if(en=="MIL"){
			ch = "密尔沃基雄鹿";
		}else if(en=="NYN"){
			ch = "纽约尼克斯";
		}else if(en=="PHI"){
			ch = "费城76人";
		}else if(en=="CEL"){
			ch = "波士顿凯尔特人";
		}else if(en=="BKN"){
			ch = "布鲁克林篮网";
		}else if(en=="TOR"){
			ch = "多伦多猛龙";
		}else{
			ch = "!!!";
		}
		System.out.println(ch);
		return en+" "+ch;
	}
	

	
	
}
