package assistance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class GetFileData {
	boolean isjoin = false;
	public String readPlayerfile(String filename) {
		String res = "";
		try {
			File f = new File(filename);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String data = br.readLine();// 一次读入一行，直到读入null为文件结束
			//res = res + data + '\n';
			
			while (data!= null) {
				//System.out.println(data+";");
				
				if(isjoin == false){
					
					isjoin = true;
				}
				else{
				data = data.trim();
				//System.out.println(data+";");
				data = getSubPlayerData(data);
				res = res + data + '\n';
				isjoin = false;
				}
				data = br.readLine(); // 接着读下一行
				//res = res + data + '\n';
			}
			br.close();
			System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	public String getSubPlayerData(String info){
		int i = 0;
		for (int j = 0;j<info.length();j++){
			if(info.substring(j,j+1).equals("│")){
				i = j+1;
				//System.out.println("hi");
				break;
			}
		}
		String res = info.substring(i,info.length()-1).trim();
		return res;
	}
}
