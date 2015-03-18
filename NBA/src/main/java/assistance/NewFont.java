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







}
