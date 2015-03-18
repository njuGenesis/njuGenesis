package presentation.contenui;

public class TableData {
	public String[] headers;
	public String[] dataRow;

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

