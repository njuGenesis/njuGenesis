package presentation.contenui;

import java.util.Arrays;

public class TableData implements Comparable<TableData>{
	public String[] headers;
	public String[] dataRow;
	
	private static int compareColumn = 1; //待排列的列数，默认为1（名称）
	
	public TableData(String[] headers,String[] dataRow){
		this.headers = headers;
		this.dataRow = dataRow;
	}

	public String getValueAt(int i) {
		return dataRow[i];
	}
	public String getColumnName(int i) {
		return headers[i];
	}
	public int getColumnCount() {
		return headers.length;
	}
	
	private static void setCompareCol(int col){
		compareColumn = col;
	}
	
	public int compareTo(TableData o) {
		return dataRow[compareColumn].compareTo(o.dataRow[compareColumn]);
	}
	
	
	public static TableData[] sort(TableData[] data,int column){
		setCompareCol(column);
		
		Arrays.sort(data);
		
		int len = data.length;
		for(int i=0;i<len;i++){
			data[i].dataRow[0] = String.valueOf(i+1);
		}
		
		return data;
	}
	
	
	//player测试用数据
	public static TableData[] getPlayerVO(){
		String[] head = {"11","22","33","44","55","66"};
		TableData[] array = new TableData[11];
		for(int i=0;i<11;i++){
			String[] data = new String[6];
			for(int j=0;j<6;j++){
				data[j] = String.valueOf(i);
			}
			array[i] = new TableData(head,data);
		}
		return array;
	}

	

	
	
}

