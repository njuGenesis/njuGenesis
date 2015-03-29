package presentation.contenui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import bussinesslogic.team.TeamLogic;
import data.po.PlayerDataPO;
import data.po.TeamDataPO;
import presentation.component.GComboBox;

public class TeamStatsPanel extends ContentPanel{
	
	private TeamLogic logic = new TeamLogic();

	public JTable table;
	public JScrollPane jsp;

	public JLabel title;

	public JComboBox<String> dataType;

	public String[] dataTypeItem = {"场均","总数"};

	public JButton submit;

	public JButton left;
	public JButton right;
	
	private static  String url = "img/content/contentTitle.png";

	public TeamStatsPanel() {
		
		super(url);

		left = UIUtil.getLeftButton();
		left.setBounds(380, 495, 20, 20);
		panel.add(left);
		right = UIUtil.getRightButton();
		right.setBounds(450, 495, 20, 20);
		panel.add(right);

		PagingTableModel model = new PagingTableModel(TableData.getPlayerVO());  
		table = new JTable(model);  
		TableUtility.setFont(table);
		TableUtility.setTableColor(table);
		TableUtility.setTableRowHeight(table, 32);
		TableUtility.setTableHeaderHeight(table, 30);

		// Use our own custom scrollpane.  
		jsp = PagingTableModel.createPagingScrollPaneForTable(table,left,right);  
		jsp.setBounds(25, 144, 830, 350);
		TableUtility.setTabelPanel(jsp);

		panel.add(jsp);

		title = new JLabel("球队数据");
		title.setBounds(40, 25, 100, 20);
		panel.add(title);


		dataType = new GComboBox(dataTypeItem);
		dataType.setBounds(45, 63, 120, 30);
		panel.add(dataType);

		submit = new JButton("提交");
		submit.setBounds(720, 100, 120, 30);
		panel.add(submit);


	}
	
	
//	private TableData[] getPlayerDataAll(){
//		TeamDataPO[] po = logic
//		String[] head = {"序号","名称","球队","参赛","先发","篮板","助攻","在场时间","投篮%","三分%",
//				"罚球%","进攻","防守","抢断","盖帽","失误","犯规","得分","效率","GmSc效率",
//				"真实命中%","投篮效率","篮板%","进攻篮板%","防守篮板%","助攻%","抢断%","盖帽%","失误%","使用%"};
//		TableData[] data = new TableData[po.length];
//		for(int i=0;i<po.length;i++){
//			String[] row = {String.valueOf(i+1),po[i].getName(),po[i].getTeamName(),String.valueOf(po[i].getGP()),String.valueOf(po[i].getGS()),
//					String.valueOf(po[i].getBackboard()),String.valueOf(po[i].getAssist()),String.valueOf(po[i].getMinutesOnField()),String.valueOf(po[i].getFieldGoalPercentage()),String.valueOf(po[i].getThreePGPercentage()),
//					String.valueOf(po[i].getFTPercentage()),String.valueOf(po[i].getOff()),String.valueOf(po[i].getDef()),String.valueOf(po[i].getSteal()),String.valueOf(po[i].getRejection()),
//					String.valueOf(po[i].getTo()),String.valueOf(po[i].getFoul()),String.valueOf(po[i].getPTS()),String.valueOf(po[i].getEff()),String.valueOf(po[i].getGmsc()),
//					String.valueOf(po[i].getTruePercentage()),String.valueOf(po[i].getShootEff()),String.valueOf(po[i].getBackboardEff()),String.valueOf(po[i].getOffBEff()),String.valueOf(po[i].getDefBEff()),
//					String.valueOf(po[i].getAssitEff()),String.valueOf(po[i].getStealEff()),String.valueOf(po[i].getRejectionEff()),String.valueOf(po[i].getToEff()),String.valueOf(po[i].getUseEff())
//			};
//			data[i] = new TableData(head,row);
//		}
//
//		return data;
//	}
	
	private TableData[] getTeamDataAll(){
		String[] head = {"序号","名称","场数","投篮命中","投篮出手","三分命中","三分出手","罚球命中","罚球出手","进攻篮板",
				"防守篮板","篮板","助攻","抢断","盖帽","失误","犯规","得分","投篮命中%","三分命中%",
				"罚球命中%","胜率","进攻回合","进攻效率","防守效率","篮板效率","抢断效率","助攻率"};
		
		
		return null;
	}
	
	private TableData[] getTeamDataAvg(){
		return null;
	}
	
}
