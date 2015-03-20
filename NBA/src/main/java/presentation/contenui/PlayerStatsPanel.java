package presentation.contenui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import data.po.PlayerDataPO;
import presentation.component.GComboBox;
import bussinesslogic.player.PlayerLogic;

public class PlayerStatsPanel extends ContentPanel{
	
	private PlayerLogic logic = new PlayerLogic();
	
	public JTable table;
	public JScrollPane jsp;
	
	public JLabel title;
	
	public JComboBox<String> position;
	public JComboBox<String> league;
	public JComboBox<String> stats;
	public JComboBox<String> dataType;
	
	public String[] positionItem = {"全部位置","后卫","前锋","中锋"}; 
	public String[] leagueItem = {"全部联盟","东部","西部"};
	public String[] statsItem = {"得分","篮板","助攻","得分/篮板/助攻","盖帽","抢断","犯规","失误","分钟","效率","投篮","三分","罚球","两双"};
	public String[] dataTypeItem = {"场均","总数"};
	
	public JButton submit;
	
	public JButton left;
	public JButton right;
	public JTextField page;
	
	private static String url = "img/content/contentTitle.png";

	public PlayerStatsPanel() {
		
		super(url);
		
		left = UIUtil.getLeftButton();
        left.setBounds(380, 495, 20, 20);
        panel.add(left);
        right = UIUtil.getRightButton();
        right.setBounds(450, 495, 20, 20);
        panel.add(right);
        
        page = new JTextField("1");
        page.setBounds(413, 494, 25, 25);
        page.setOpaque(false);
//        page.setBorder(null);
        page.setFont(new Font("微软雅黑",1,12));
        panel.add(page);
		
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
        
        stats = new GComboBox(statsItem);
        stats.setBounds(365, 63, 120, 30);
        panel.add(stats);
        
        dataType = new GComboBox(dataTypeItem);
        dataType.setBounds(525, 63, 120, 30);
        panel.add(dataType);
        
        submit = new JButton("提交");
        submit.setBounds(720, 100, 120, 30);
        panel.add(submit);
        
        
	}

	private TableData[] getPlayerData(){
		PlayerDataPO[] po = logic.getAllInfo();
		String[] head = {"序号","名称","球队","参赛","先发","篮板","助攻","","","","","",""};
		
		return null;
	}
}
