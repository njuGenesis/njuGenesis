package assistance;

import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class NewFont {
	private static String fontpath = "font/";
	private static File extraLightFile = new File(fontpath + "SourceHanSansCN-ExtraLight.otf");
	private static File lightFile = new File(fontpath + "SourceHanSansCN-Light.otf");
	private static File normalFile = new File(fontpath + "SourceHanSansCN-Normal.otf");
	private static File regularFile = new File(fontpath + "SourceHanSansCN-Regular.otf");
	private static File mediumFile = new File(fontpath + "SourceHanSansCN-Medium.otf");
	private static File boldFile = new File(fontpath + "SourceHanSansCN-Bold.otf");
	private static File heavyFile = new File(fontpath + "SourceHanSansCN-Heavy.otf");
	private static File[] files = {extraLightFile,lightFile,normalFile,regularFile,mediumFile,boldFile,heavyFile};

	public static Font extraLight;
	public static Font light;
	public static Font normal;
	public static Font regular;
	public static Font medium;
	public static Font bold;
	public static Font heavy;
	public static Font[] fonts = {extraLight,light,normal,regular,medium,bold,heavy};


	public static Font menuFont;
	
	public static Font TableTitleFont = new Font("微软雅黑",1,13);
	
	public static Font ComboBoxFont = new Font("微软雅黑",0,12);
	
	public static Font ButtonFont = new Font("微软雅黑",0,14);

	public static void initFont(){
		try {
			for(int i=0;i<7;i++){
				BufferedInputStream fb = new BufferedInputStream(new FileInputStream(files[i]));
				fonts[i] =  Font.createFont(Font.TRUETYPE_FONT, fb);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		initMenuFont();

	}

	private static void initMenuFont(){
		light = light.deriveFont(Font.BOLD, 20);
	}

	public static Font getTableTitleFont(){
		java.io.File file = new java.io.File(fontpath + "hb.ttf");

		if (!file.exists()) {
			System.out.println("file not found");
			return new Font("微软雅黑",1,13);
		}


		Font nf = new Font("微软雅黑",1,13);
		try {
			java.io.FileInputStream fi = new java.io.FileInputStream(file);
			java.io.BufferedInputStream fb = new java.io.BufferedInputStream(fi);
			nf = Font.createFont(Font.TRUETYPE_FONT, fb);
			nf = nf.deriveFont(Font.BOLD, 10);
			System.out.println(nf.getFontName());
			System.out.println(nf.getSize());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return nf;
	}







}
