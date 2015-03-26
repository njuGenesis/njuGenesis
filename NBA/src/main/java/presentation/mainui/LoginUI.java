package presentation.mainui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import presentation.component.GButton;
import presentation.component.GLabel;
import presentation.component.GPasswordField;
import presentation.component.GTextField;

import com.sun.awt.AWTUtilities;
@SuppressWarnings("restriction")

public class LoginUI extends JFrame implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LoginUI com=this;//自身
	private GLabel label_background,label_background2,label_background3,label_background4,label_background5,label_background6;
	private GLabel label_blue;
	private GLabel label_red;
	private GLabel label_basket;
	private GLabel label_id;
	private GLabel label_password;
	private GLabel label_Genesis;//团队名
	private GLabel label_backgroundS;
	private GLabel framebg[] = new GLabel[31];
	private GTextField id;
	private GPasswordField pw;
	private State state;//判断是否是退出时刻
	private Thread thread;//线程
	private GButton userLogin,visitorLogin,close,login,register,back;
	private Container newCase;
	
	public static void main(String[] args){
		new LoginUI().start();;
	}

	public LoginUI(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭进程
		this.setUndecorated(true);
		this.setSize(1250, 650);//设置大小
		AWTUtilities.setWindowOpaque(this, false);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = (int)(screen.getWidth()-this.getWidth())/2;
		int y = (int)(screen.getHeight()-this.getHeight())/2-32;
		this.setLocation(x, y);//设置居中
		this.setVisible(true);

		newCase = getContentPane();//容器
		newCase.setLayout(null);//取消模式

		componentInit();
		backgroundInit();

		MouseAdapter mouseListener = new MouseAdapter(){

			int xOld = 0;
			int yOld = 0;

			@Override
			public void mousePressed(MouseEvent e) {
				xOld = e.getX();
				yOld = e.getY();
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				int xOnScreen = e.getXOnScreen();
				int yOnScreen = e.getYOnScreen();
				int xx = xOnScreen - xOld;
				int yy = yOnScreen - yOld;
				LoginUI.this.setLocation(xx, yy);
			}
		};

		//		this.addMouseListener(mouseListener);
		//		this.addMouseMotionListener(mouseListener);//添加拖动监听

		this.repaint();
	}
	
	public void start(){
		state = State.START;
		threadRun();
	}
	
	private void threadRun(){
		thread = new Thread(com);
		thread.start();
	}

	private void threadStop(){
		thread = null;
	}
	
	private void componentInit(){

		int ySpace = 19;
		int xSpace = 43;

		Point blueLabelSize = new Point(231 , 650);
		Point redLabelSize = new Point(156, 650);
		Point basketLabelSize = new Point(259, 180);
		Point GenesisLabelSize = new Point(170, 57);
		Point backgroundSSize = new Point(210, 213);
		Point idLabelSize = new Point(209, 40);
		Point pwLabelSize = new Point(209, 40);
		Point idTextSize = new Point(128, 40);
		Point pwTextSize = new Point(128, 40);
		Point userLoginButtonSize = new Point(113, 34);
		Point visitorLoginButtonSize = new Point(113, 34);
		Point loginButtonSize = new Point(34, 34);
		Point registerButtonSize = new Point(34, 34);
		Point backButtonSize = new Point(34, 34);
		Point closeButtonSize = new Point(113, 34);

		Point basketLabelLocation = new Point(487, 60);
		Point blueLabelLocation = new Point(487, 0);
		Point redLabelLocation = new Point(607, 0);
		Point GenesisLabelLocation = new Point(703, 595);
		Point backgroundSLocation = new Point(512, 443);
		Point idLabelLocation = new Point(512, 60);
		Point pwLabelLocation = new Point(idLabelLocation.x, idLabelLocation.y+idLabelSize.y+ySpace);
		Point idTextLocation = new Point(568, idLabelLocation.y);
		Point pwTextLocation = new Point(568, idLabelLocation.y+idLabelSize.y+ySpace);
		Point userLoginButtonLocation = new Point(560, 301);
		Point visitorLoginButtonLocation = new Point(userLoginButtonLocation.x, userLoginButtonLocation.y+userLoginButtonSize.y+ySpace);
		Point loginButtonLocation = new Point(522, 178);
		Point registerButtonLocation = new Point(loginButtonLocation.x+loginButtonSize.x+xSpace, loginButtonLocation.y);
		Point backButtonLocation = new Point(loginButtonLocation.x+2*loginButtonSize.x+2*xSpace, loginButtonLocation.y);
		Point closeButtonLocation = new Point(userLoginButtonLocation.x, userLoginButtonLocation.y+3*userLoginButtonSize.y+3*ySpace);

		label_blue = new GLabel("img/LoginUI/NBAblue.png", blueLabelLocation, blueLabelSize, newCase, false);
		label_red =new GLabel("img/LoginUI/NBAred.png", redLabelLocation, redLabelSize, newCase, false);
		label_basket = new GLabel("img/LoginUI/basket.png", basketLabelLocation, basketLabelSize, newCase, false);
		close = new GButton("img/LoginUI/close.png", closeButtonLocation, closeButtonSize, newCase, false);
		label_backgroundS = new GLabel("img/LoginUI/backgroundS.png", backgroundSLocation, backgroundSSize, newCase, false);
		label_id = new GLabel("img/LoginUI/textID.png", idLabelLocation, idLabelSize, newCase, false);
		label_password = new GLabel("img/LoginUI/textPW.png", pwLabelLocation, pwLabelSize, newCase, false);
		label_Genesis = new GLabel("img/LoginUI/Genesis.png", GenesisLabelLocation, GenesisLabelSize, newCase, false);
		userLogin = new GButton("img/LoginUI/userLogin.png", userLoginButtonLocation, userLoginButtonSize, newCase, false);
		visitorLogin = new GButton("img/LoginUI/visitorLogin.png", visitorLoginButtonLocation, visitorLoginButtonSize, newCase, false);
		login = new GButton("img/LoginUI/login.png", loginButtonLocation, loginButtonSize, newCase, false);
		register = new GButton("img/LoginUI/register.png", registerButtonLocation, registerButtonSize, newCase, false);
		back = new GButton("img/LoginUI/back.png", backButtonLocation, backButtonSize, newCase, false);

		id = new GTextField(idTextLocation, idTextSize, newCase, false);
		pw = new GPasswordField(pwTextLocation, pwTextSize, newCase, false);

		userLogin.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				state = State.USERLOGIN;
				threadRun();
			}
			public void mouseExited(MouseEvent e) {
				userLogin.setIcon(new ImageIcon("img/LoginUI/userLogin.png"));
			}
			public void mouseEntered(MouseEvent e) {
				userLogin.setIcon(new ImageIcon("img/LoginUI/userLoginAct.png"));
			}
		});
		visitorLogin.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				state = State.VISITERLOGIN;
				threadRun();
			}
			public void mouseExited(MouseEvent e) {
				visitorLogin.setIcon(new ImageIcon("img/LoginUI/visitorLogin.png"));
			}
			public void mouseEntered(MouseEvent e) {
				visitorLogin.setIcon(new ImageIcon("img/LoginUI/visitorLoginAct.png"));
			}
		});
		login.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				login.setIcon(new ImageIcon("img/LoginUI/login.png"));
			}
			public void mouseEntered(MouseEvent e) {
				login.setIcon(new ImageIcon("img/LoginUI/loginAct.png"));
			}
		});
		register.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				register.setIcon(new ImageIcon("img/LoginUI/register.png"));
			}
			public void mouseEntered(MouseEvent e) {
				register.setIcon(new ImageIcon("img/LoginUI/registerAct.png"));
			}
		});
		back.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				state = State.BACK;
				threadRun();
			}
			public void mouseExited(MouseEvent e) {
				back.setIcon(new ImageIcon("img/LoginUI/back.png"));
			}
			public void mouseEntered(MouseEvent e) {
				back.setIcon(new ImageIcon("img/LoginUI/backAct.png"));
			}
		});
		close.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				state = State.CLOSE;
				threadRun();
			}
			public void mouseExited(MouseEvent e) {
				close.setIcon(new ImageIcon("img/LoginUI/close.png"));
			}
			public void mouseEntered(MouseEvent e) {
				close.setIcon(new ImageIcon("img/LoginUI/closeAct.png"));
			}
		});
	}

	private void backgroundInit(){
		label_background = new GLabel("img/LoginUI/background.png", new Point(487, 0), new Point(276, 650), newCase, false);
		label_background2 = new GLabel("img/LoginUI/background2.png", new Point(406, 0), new Point(100, 650), newCase, false);
		label_background3 = new GLabel("img/LoginUI/background3.png", new Point(720, 0), new Point(60, 650), newCase, false);
		label_background4 = new GLabel("img/LoginUI/background4.png", new Point(776, 0), new Point(30, 650), newCase, false);
		label_background5 = new GLabel("img/LoginUI/background4.png", new Point(806, 0), new Point(30, 650), newCase, false);
		label_background6 = new GLabel("img/LoginUI/background4.png", new Point(836, 0), new Point(30, 650), newCase, false);

		for(int i = 0;i<31;i++){
			if(i==0){
				framebg[i] = new GLabel("img/Framebg/framebg_"+String.valueOf(i+1)+".png", new Point(0, 0), new Point(121,650), this, false);
			}else{
				if(i>=1&&i<=3){
					framebg[i] = new GLabel("img/Framebg/framebg_"+String.valueOf(i+1)+".png", new Point(121+(i-1)*121, 0), new Point(121,650), this, false);
				}else{
					if(i==4){
						framebg[i] = new GLabel("img/Framebg/framebg_"+String.valueOf(i+1)+".png", new Point(484, 0), new Point(276,650), this, false);
					}else{
						if(i>=5&&i<=29){
							framebg[i] = new GLabel("img/Framebg/framebg_"+String.valueOf(i+1)+".png", new Point(760+(i-5)*18, 0), new Point(18, 650), this, false);
						}else{
							framebg[i] = new GLabel("img/Framebg/framebg_"+String.valueOf(i+1)+".png", new Point(1210, 0), new Point(34, 650), this, false);
						}
					}
				}
			}
		}
	}


	public void run() {

		Point smallButtonLocation1st = new Point(522, 178);
		Point inputLocaton1st = new Point(512, 60);
		Point butonLocation1st = new Point(560, 301);
		Point smallButtonSize = new Point(34, 34);
		Point inputSize = new Point(209, 40);
		Point buttonSize = new Point(113, 34);
		
		int ySpace = 19;
		int xSpace = 43;
		
		int x,y,z,p,q;//图片移动参数
		
		switch(state){
		case START:{
			label_blue.setVisible(true);
			label_red.setVisible(true);
			label_blue.setLocation(x=label_blue.getLocation().x, 0);
			label_red.setLocation(y=label_red.getLocation().x, 0);
			label_background.setVisible(true);
			label_basket.setVisible(true);
			userLogin.setVisible(true);
			visitorLogin.setVisible(true);
			label_backgroundS.setVisible(true);
			close.setVisible(true);
			Loading loading = new Loading(694, 306, this);
			loading.start();
			try {
				thread.sleep(2000);
			} catch (InterruptedException e1) {}
			loading.stop();
			while(x>346){
				x--;
				y++;
				if(x==365){
					label_background2.setVisible(true);
				}
				switch(y){
				case 642:label_background3.setVisible(true);break;
				case 668:label_background4.setVisible(true);break;
				case 698:label_background5.setVisible(true);break;
				case 723:label_background6.setVisible(true);break;
				default:break;
				}
				label_blue.setLocation(x, 0);//让图片移动
				label_red.setLocation(y, 0);//让图片移动
				try {
					thread.sleep(1);//休息2
				}
				catch (InterruptedException e){}
			}
			label_Genesis.setVisible(true);
			threadStop();
			break;
		}
		case CLOSE:{
			label_Genesis.setVisible(false);
			label_blue.setLocation(x=label_blue.getLocation().x, 0);//将图片重新定位到0，100
			label_red.setLocation(y=label_red.getLocation().x, 0);//将图片重新定位到0，100
			while(x<487){//判断条件，x小于窗体的右边值
				x++;//将x--
				y--;
				if(x==365){
					label_background2.setVisible(false);
				}
				switch(y){
				case 642:label_background3.setVisible(false);break;
				case 668:label_background4.setVisible(false);break;
				case 698:label_background5.setVisible(false);break;
				case 723:label_background6.setVisible(false);break;
				default:break;
				}
				label_blue.setLocation(x, 0);//让图片移动
				label_red.setLocation(y, 0);//让图片移动
				try {
					thread.sleep(1);//休息2
				}
				catch (InterruptedException e){}
			}
			try {
				thread.sleep(1000);
			} catch (InterruptedException e1) {}
			this.dispose();
			threadStop();
			break;
		}
		case VISITERLOGIN:{
			label_Genesis.setVisible(false);
			label_blue.setLocation(x=label_blue.getLocation().x, 0);//将图片重新定位到0，100
			label_red.setLocation(y=label_red.getLocation().x, 0);//将图片重新定位到0，100
			this.repaint();
			while(x<487){//判断条件，x小于窗体的右边值
				x++;//将x--
				y--;
				if(x==365){
					label_background2.setVisible(false);
				}
				switch(y){
				case 642:label_background3.setVisible(false);break;
				case 668:label_background4.setVisible(false);break;
				case 698:label_background5.setVisible(false);break;
				case 723:label_background6.setVisible(false);break;
				default:break;
				}
				label_blue.setLocation(x, 0);//让图片移动
				label_red.setLocation(y, 0);//让图片移动
				try {
					thread.sleep(1);//休息2
				}
				catch (InterruptedException e){}
			}
			state = State.LOGIN;
			threadRun();
			break;
		}
		case USERLOGIN:{
			
			label_id.setVisible(true);
			label_password.setVisible(true);
			id.setVisible(true);
			pw.setVisible(true);
			login.setVisible(true);
			register.setVisible(true);
			back.setVisible(true);
			
			label_id.setLocation(inputLocaton1st.x, x=inputLocaton1st.y);
			id.setLocation(568, x);
			
			label_password.setLocation(inputLocaton1st.x, y=inputLocaton1st.y+inputSize.y+ySpace);
			pw.setLocation(568,y);
			
			login.setLocation(smallButtonLocation1st.x, z=smallButtonLocation1st.y);
			register.setLocation(smallButtonLocation1st.x+smallButtonSize.x+xSpace, z);
			back.setLocation(smallButtonLocation1st.x+2*smallButtonSize.x+2*xSpace, z);
			
			userLogin.setLocation(butonLocation1st.x, p=butonLocation1st.y);
			
			visitorLogin.setLocation(butonLocation1st.x, q=butonLocation1st.y+buttonSize.y+ySpace);
			
			while(z<388){
				x++;
				y++;
				z++;
				p++;
				q++;
				label_id.setLocation(inputLocaton1st.x, x);
				id.setLocation(568, x);
				
				label_password.setLocation(inputLocaton1st.x, y);
				pw.setLocation(568,y);
				
				login.setLocation(smallButtonLocation1st.x, z);
				register.setLocation(smallButtonLocation1st.x+smallButtonSize.x+xSpace, z);
				back.setLocation(smallButtonLocation1st.x+2*smallButtonSize.x+2*xSpace, z);
				
				userLogin.setLocation(butonLocation1st.x, p);
				
				visitorLogin.setLocation(butonLocation1st.x, q);
				
				try {
					thread.sleep(1);//休息2
				}
				catch (InterruptedException e){}
			}
			threadStop();
			break;
		}
		case BACK:{

			int move = 388 -smallButtonLocation1st.y;
			
			label_id.setLocation(inputLocaton1st.x, x=inputLocaton1st.y+move);
			id.setLocation(568, x);
			
			label_password.setLocation(inputLocaton1st.x, y=inputLocaton1st.y+inputSize.y+ySpace+move);
			pw.setLocation(568,y);
			
			login.setLocation(smallButtonLocation1st.x, z=smallButtonLocation1st.y+move);
			register.setLocation(smallButtonLocation1st.x+smallButtonSize.x+xSpace, z);
			back.setLocation(smallButtonLocation1st.x+2*smallButtonSize.x+2*xSpace, z);
			
			userLogin.setLocation(butonLocation1st.x, p=butonLocation1st.y+move);
			
			visitorLogin.setLocation(butonLocation1st.x, q=butonLocation1st.y+buttonSize.y+ySpace+move);
			
			while(z>smallButtonLocation1st.y){
				x--;
				y--;
				z--;
				p--;
				q--;
				label_id.setLocation(inputLocaton1st.x, x);
				id.setLocation(568, x);
				
				label_password.setLocation(inputLocaton1st.x, y);
				pw.setLocation(568,y);
				
				login.setLocation(smallButtonLocation1st.x, z);
				register.setLocation(smallButtonLocation1st.x+smallButtonSize.x+xSpace, z);
				back.setLocation(smallButtonLocation1st.x+2*smallButtonSize.x+2*xSpace, z);
				
				userLogin.setLocation(butonLocation1st.x, p);
				
				visitorLogin.setLocation(butonLocation1st.x, q);
				
				try {
					thread.sleep(1);//休息2
				}
				catch (InterruptedException e){}
			}
			label_id.setVisible(false);
			label_password.setVisible(false);
			id.setVisible(false);
			pw.setVisible(false);
			login.setVisible(false);
			register.setVisible(false);
			back.setVisible(false);
			threadStop();
			break;
		}
		case LOGIN:{
			Loading loading = new Loading(694, 306, this);
			loading.start();
			try {
				thread.sleep(2000);
			} catch (InterruptedException e1) {}
			loading.stop();
			
			label_background.setVisible(false);
			label_basket.setVisible(false);
			userLogin.setVisible(false);
			visitorLogin.setVisible(false);
			close.setVisible(false);
			label_backgroundS.setVisible(false);
			label_Genesis.setVisible(false);
			
			framebg[4].setVisible(true);
			
			label_blue.setLocation(x=label_blue.getLocation().x, 0);
			label_red.setLocation(y=label_red.getLocation().x, 0);
			while(x>0){
				x--;
				y++;
				switch(x){
				case 360:framebg[3].setVisible(true);break;
				case 239:framebg[2].setVisible(true);break;
				case 118:framebg[1].setVisible(true);break; 
				default:break;
				}
				switch(y){
				case 641:framebg[5].setVisible(true);break;
				case 641+18:framebg[6].setVisible(true);break;
				case 641+2*18:framebg[7].setVisible(true);break;
				case 641+3*18:framebg[8].setVisible(true);break;
				case 641+4*18:framebg[9].setVisible(true);break;
				case 641+5*18:framebg[10].setVisible(true);break;
				case 641+6*18:framebg[11].setVisible(true);break;
				case 641+7*18:framebg[12].setVisible(true);break;
				case 641+8*18:framebg[13].setVisible(true);break;
				case 641+9*18:framebg[14].setVisible(true);break;
				case 641+10*18:framebg[15].setVisible(true);break;
				case 641+11*18:framebg[16].setVisible(true);break;
				case 641+12*18:framebg[17].setVisible(true);break;
				case 641+13*18:framebg[18].setVisible(true);break;
				case 641+14*18:framebg[19].setVisible(true);break;
				case 641+15*18:framebg[20].setVisible(true);break;
				case 641+16*18:framebg[21].setVisible(true);break;
				case 641+17*18:framebg[22].setVisible(true);break;
				case 641+18*18:framebg[23].setVisible(true);break;
				case 641+19*18:framebg[24].setVisible(true);break;
				case 641+20*18:framebg[25].setVisible(true);break;
				case 641+21*18:framebg[26].setVisible(true);break;
				case 641+22*18:framebg[27].setVisible(true);break;
				case 641+23*18:framebg[28].setVisible(true);break;
				case 641+24*18:framebg[29].setVisible(true);break;
				default:break;
				}
				label_blue.setLocation(x, 0);//让图片移动
				label_red.setLocation(y, 0);//让图片移动
				try {
					thread.sleep(1);//休息2
				}
				catch (InterruptedException e){}
			}
			new MainUI().initMainFrame();;
			this.dispose();
			threadStop();
			break;
		}
		case EXIT:{
			label_blue.setLocation(x=label_blue.getLocation().x, 0);
			label_red.setLocation(y=label_red.getLocation().x, 0);
			while(x<487){
				x++;
				y--;
				switch(x){
				case 119:framebg[1].setVisible(false);break; 
				case 240:framebg[2].setVisible(false);break;
				case 361:framebg[3].setVisible(false);break;
				case 486:framebg[4].setVisible(false);break;
				default:break;
				}
				switch(y){
				case 641+24*18:framebg[29].setVisible(false);break;
				case 641+23*18:framebg[28].setVisible(false);break;
				case 641+22*18:framebg[27].setVisible(false);break;
				case 641+21*18:framebg[26].setVisible(false);break;
				case 641+20*18:framebg[25].setVisible(false);break;
				case 641+19*18:framebg[24].setVisible(false);break;
				case 641+18*18:framebg[23].setVisible(false);break;
				case 641+17*18:framebg[22].setVisible(false);break;
				case 641+16*18:framebg[21].setVisible(false);break;
				case 641+15*18:framebg[20].setVisible(false);break;
				case 641+14*18:framebg[19].setVisible(false);break;
				case 641+13*18:framebg[18].setVisible(false);break;
				case 641+12*18:framebg[17].setVisible(false);break;
				case 641+11*18:framebg[16].setVisible(false);break;
				case 641+10*18:framebg[15].setVisible(false);break;
				case 641+9*18:framebg[14].setVisible(false);break;
				case 641+8*18:framebg[13].setVisible(false);break;
				case 641+7*18:framebg[12].setVisible(false);break;
				case 641+6*18:framebg[11].setVisible(false);break;
				case 641+5*18:framebg[10].setVisible(false);break;
				case 641+4*18:framebg[9].setVisible(false);break;
				case 641+3*18:framebg[8].setVisible(false);break;
				case 641+2*18:framebg[7].setVisible(false);break;
				case 641+1*18:framebg[6].setVisible(false);break;
				case 641:framebg[5].setVisible(false);break;
				default:break;
				}
				label_blue.setLocation(x, 0);//让图片移动
				label_red.setLocation(y, 0);//让图片移动
				try {
					thread.sleep(1);//休息
				}
				catch (InterruptedException e){}
			}
//			try {
//				thread.sleep(500);//休息2
//			}
//			catch (InterruptedException e){}
			threadStop();
			this.dispose();
			break;
		}
		default:break;
		}
	}
	
	public void readyClose(){
		for(int i = 1; i < 30; i++){
			framebg[i].setVisible(true);
		}
		label_blue.setVisible(true);
		label_red.setVisible(true);
		label_blue.setLocation(0, 0);
		label_red.setLocation(1094, 0);
	}
	
	public void close(){
		state = State.EXIT;
		threadRun();
	}
}

enum State{
	START,
	USERLOGIN,
	VISITERLOGIN,
	CLOSE,
	BACK,
	LOGIN,
	EXIT;
}
