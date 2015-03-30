package presentation.contenui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;

import presentation.component.GComboBox;
import presentation.component.GTable;
import presentation.mainui.MainUI;
import bussinesslogic.player.PlayerLogic;
import data.po.PlayerDataPO;

public class PlayerStatsPanel extends ContentPanel{

	private PlayerLogic logic = new PlayerLogic();

	public JTable table;
	public JScrollPane jsp;

	public JLabel title;

	public JComboBox<String> position;
	public JComboBox<String> league;
	public JComboBox<String> dataType;

	public String[] positionItem = {"全部位置","后卫","前锋","中锋"}; 
	public String[] leagueItem = {"全部联盟","东部","西部"};
//	public String[] statsItem = {"得分","篮板","助攻","得分/篮板/助攻","盖帽","抢断","犯规","失误","分钟","效率","投篮","三分","罚球","两双"};
	public String[] dataTypeItem = {"场均","总数"};

	public JButton submit;

	public JButton left;
	public JButton right;
	public JTextField page;

	private static String url = "img/content/contentTitle.png";

	public PlayerStatsPanel() {

		super(url);

		//-----初始化翻页按钮-----
		left = UIUtil.getLeftButton();
		left.setBounds(380, 515, 20, 20);
		left.addActionListener(new ButtonListener());
		panel.add(left);
		right = UIUtil.getRightButton();
		right.setBounds(450, 515, 20, 20);
		right.addActionListener(new ButtonListener());
		panel.add(right);

		
		//-----初始化页数框-----
		page = new JTextField("1");
		page.setBounds(413, 514, 25, 25);
		page.setBorder(null);
		page.setOpaque(false);
		page.setHorizontalAlignment(JTextField.CENTER);
		page.addActionListener(new PageListener());
		page.setFont(new Font("微软雅黑",1,12));
		panel.add(page);

		
		
		PagingTableModel model = new PagingTableModel(getPlayerDataAvg(logic.getAllInfo()));  
		table = new GTable(model,left,right,page);
//		table = new JTable(model);  
//		TableUtility.setFont(table);
//		TableUtility.setTableColor(table);
//		TableUtility.setTableRowHeight(table, 32);
//		TableUtility.setTableHeaderHeight(table, 30);

		// Use our own custom scrollpane.  
		jsp = PagingTableModel.createPagingScrollPaneForTable(table,left,right);  
		jsp.setBounds(25, 144, 830, 370);
		TableUtility.setTabelPanel(jsp);

		panel.add(jsp);

		title = new JLabel("球员数据");
		title.setBounds(40, 25, 100, 20);
		panel.add(title);

		position = new GComboBox(positionItem);
		position.setBounds(45, 63, 120, 30);
		//        position.setUI(new BasicComboBoxUI() {
		//            public void installUI(JComponent comboBox) {
		//                super.installUI(comboBox);
		//                listBox.setForeground(Color.WHITE);
		//                listBox.setSelectionBackground(new Color(0,0,0,0));
		//                listBox.setSelectionForeground(Color.BLACK);
		//            }
		//             
		//            /**
		//             * 该方法返回右边的按钮
		//             */
		//            protected JButton createArrowButton() {
		//                return super.createArrowButton();
		//            }
		//        });
		panel.add(position);

		league = new GComboBox(leagueItem);
		league.setBounds(205, 63, 120, 30);
		league.setBackground(new Color(250,250,250));
		//        league.setOpaque(false);
		panel.add(league);

		dataType = new GComboBox(dataTypeItem);
		dataType.setBounds(365, 63, 120, 30);
		panel.add(dataType);

		submit = new JButton("筛选");
		submit.setBounds(720, 100, 120, 30);
		submit.addMouseListener(new SubmitListener());
		panel.add(submit);


	}

	//----------总数据----------
	private TableData[] getPlayerDataAll(PlayerDataPO[] po){
		String[] head = {"序号","姓名","球队","参赛","先发","篮板","助攻","在场时间","投篮%","三分%",
				"罚球%","进攻","防守","抢断","盖帽","失误","犯规","得分","效率","GmSc效率",
				"真实命中%","投篮效率","篮板%","进攻篮板%","防守篮板%","助攻%","抢断%","盖帽%","失误%","使用%"};
		TableData[] data = new TableData[po.length];
		for(int i=0;i<po.length;i++){
			String[] row = {String.valueOf(i+1),po[i].getName(),po[i].getTeamName(),String.valueOf(po[i].getGP()),String.valueOf(po[i].getGS()),
					String.valueOf(po[i].getBackboard()),String.valueOf(po[i].getAssist()),String.valueOf(po[i].getMinutesOnField()),String.valueOf(po[i].getFieldGoalPercentage()),String.valueOf(po[i].getThreePGPercentage()),
					String.valueOf(po[i].getFTPercentage()),String.valueOf(po[i].getOff()),String.valueOf(po[i].getDef()),String.valueOf(po[i].getSteal()),String.valueOf(po[i].getRejection()),
					String.valueOf(po[i].getTo()),String.valueOf(po[i].getFoul()),String.valueOf(po[i].getPTS()),String.valueOf(po[i].getEff()),String.valueOf(po[i].getGmsc()),
					String.valueOf(po[i].getTruePercentage()),String.valueOf(po[i].getShootEff()),String.valueOf(po[i].getBackboardEff()),String.valueOf(po[i].getOffBEff()),String.valueOf(po[i].getDefBEff()),
					String.valueOf(po[i].getAssitEff()),String.valueOf(po[i].getStealEff()),String.valueOf(po[i].getRejectionEff()),String.valueOf(po[i].getToEff()),String.valueOf(po[i].getUseEff())
			};
			data[i] = new TableData(head,row);
		}

		return data;
	}

	//----------场均数据----------
	private TableData[] getPlayerDataAvg(PlayerDataPO[] po){
		String[] head = {"序号","姓名","球队","参赛","先发","篮板","助攻","在场时间","投篮%","三分%",
				"罚球%","进攻","防守","抢断","盖帽","失误","犯规","得分","效率","GmSc效率",
				"真实命中%","投篮效率","篮板%","进攻篮板%","防守篮板%","助攻%","抢断%","盖帽%","失误%","使用%"};
		TableData[] data = new TableData[po.length];
		for(int i=0;i<po.length;i++){
			String[] row = {String.valueOf(i+1),po[i].getName(),po[i].getTeamName(),String.valueOf(po[i].getGP()),String.valueOf(po[i].getGS()),
					String.valueOf(po[i].getBPG()),String.valueOf(po[i].getAPG()),String.valueOf(po[i].getMinutesOnField()),String.valueOf(po[i].getFieldGoalPercentage()),String.valueOf(po[i].getThreePGPercentage()),
					String.valueOf(po[i].getFTPercentage()),String.valueOf(po[i].getOffPG()),String.valueOf(po[i].getDefPG()),String.valueOf(po[i].getStealPG()),String.valueOf(po[i].getRPG()),
					String.valueOf(po[i].getToPG()),String.valueOf(po[i].getFoulPG()),String.valueOf(po[i].getPPG()),String.valueOf(po[i].getEff()),String.valueOf(po[i].getGmsc()),
					String.valueOf(po[i].getTruePercentage()),String.valueOf(po[i].getShootEff()),String.valueOf(po[i].getBackboardEff()),String.valueOf(po[i].getOffBEff()),String.valueOf(po[i].getDefBEff()),
					String.valueOf(po[i].getAssitEff()),String.valueOf(po[i].getStealEff()),String.valueOf(po[i].getRejectionEff()),String.valueOf(po[i].getToEff()),String.valueOf(po[i].getUseEff())
			};
			data[i] = new TableData(head,row);
		}

		return data;
	}
	
	private String changePosStr(String chinese){
		if(chinese=="前锋"){
			return "F";
		}else if(chinese=="中锋"){
			return "C";
		}else if(chinese=="后卫"){
			return "G";
		}else{
			return "null";
		}
	}
	
	private String changeUnStr(String chinese){
		if(chinese=="东部"){
			return "E";
		}else if(chinese=="西部"){
			return "W";
		}else{
			return "null";
		}
	}
	
	private boolean isAverageData(String chinese){
		return chinese=="场均";
	}
	
	
	//----------筛选按钮的监听事件----------
	class SubmitListener implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			String pos = position.getSelectedItem().toString();
			String leag = league.getSelectedItem().toString();
			String type = dataType.getSelectedItem().toString();
			
			PlayerDataPO[] po = logic.getSelect(changePosStr(pos), changeUnStr(leag));
			PagingTableModel tm;
			if(isAverageData(type)){
				tm = new PagingTableModel(getPlayerDataAvg(po));
			}else{
				tm = new PagingTableModel(getPlayerDataAll(po));
			}
			
			table.setModel(tm);
			MainUI.getMainFrame().repaint();
		}

		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			PagingTableModel tm = (PagingTableModel)table.getModel();
			page.setText(String.valueOf(tm.getPageOffset()+1));
		}
		
	} 
	
	
	class PageListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			PagingTableModel tm = (PagingTableModel)table.getModel();
			try{
				int p = Integer.parseInt(page.getText());		
				System.out.println(p);
				int pages = tm.getPageCount();
				int now = tm.getPageOffset()+1;
				if(0<p&&p<=pages){
					if(p<now){
						for(int i=0;i<now-p;i++){
							tm.pageUp();
							checkButton();
						}
					}else if(p>now){
						for(int i=0;i<p-now;i++){
							tm.pageDown();
							checkButton();
						}
					}
				}
				page.setText(String.valueOf(tm.getPageOffset()+1));
			}catch(Exception ex){
				page.setText(String.valueOf(tm.getPageOffset()+1));
			}
		}

		private void checkButton(){
			PagingTableModel tm = (PagingTableModel)table.getModel();
			int now = tm.getPageOffset();
			if(now == 0){
				left.setEnabled(false);
				right.setEnabled(true);
			}else if(now == tm.getPageCount()-1){
				left.setEnabled(true);
				right.setEnabled(false);
			}else{
				left.setEnabled(true);
				right.setEnabled(true);
			}
		}
		

	}
}
