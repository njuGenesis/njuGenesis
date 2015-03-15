package presentation.mainui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sun.awt.AWTUtilities;
@SuppressWarnings("restriction")

public class LoginUI extends JFrame implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LoginUI com=this;//自身
	private JLabel label_background,label_background2,label_background3,label_background4;
	private JLabel label_blue;
	private JLabel label_red;
	private JLabel label_basket;
	private JLabel label_id;
	private JLabel label_password;//背景图片
	private JLabel label_Genesis;//团队名
	private JTextField id;
	private JPasswordField pw;
	private int x,y;//图片移动参数
	private int isBack;//判断是否是退出时刻
	private Thread thread;//线程
	private JButton login,login2,back;//登陆按钮
	
	public static void main(String[] args){
		new LoginUI();
	}
	
	public LoginUI(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭进程
		this.setUndecorated(true);
		//this.setSize(698, 592);//设置大小
		this.setSize(558, 650);//设置大小
		AWTUtilities.setWindowOpaque(this, false);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = (int)(screen.getWidth()-this.getWidth())/2;
		int y = (int)(screen.getHeight()-this.getHeight())/2-32;
		this.setLocation(x, y);//设置居中
		this.setVisible(true);
		
		Container newCase = getContentPane();//容器
		newCase.setLayout(null);//取消模式
		
		//宽249
		
		label_blue = new JLabel(new ImageIcon("img/LoginUI/NBAblue.png"));
		label_blue.setBounds(140, 0, 231, 650);
		newCase.add(label_blue);
		
		label_red = new JLabel(new ImageIcon("img/LoginUI/NBAred.png"));
		label_red.setBounds(187, 0, 231, 650);
		newCase.add(label_red);
		
		label_basket = new JLabel(new ImageIcon("img/LoginUI/basket.png"));
		label_basket.setBounds(145, 70, 259, 181);
		newCase.add(label_basket);
		
		id = new JTextField();
		id.setBounds(250, 274, 128, 35);
		id.setBorder(null);
		id.setOpaque(false);
		newCase.add(id);
		id.setFont(new java.awt.Font("微软雅黑",0,13));
		id.setForeground(Color.WHITE);
		id.enableInputMethods(false);//禁用输入法
		id.addKeyListener(new KeyAdapter() {
			 public void keyTyped(KeyEvent e) {
				 char k = e.getKeyChar();
				 if((k>='a'&&k<='z')||(k>='A'&&k<='Z')||(k>='0'&&k<='9')){
				 }else{
					 e.consume();
				 }
			 }
		});
		label_id = new JLabel(new ImageIcon("img/LoginUI/textID.png"));
		label_id.setBounds(173, 270, 212, 40);
		newCase.add(label_id);
		
		pw = new JPasswordField();
		pw.setBounds(250, 333, 128, 35);
		pw.setBorder(null);
		pw.setOpaque(false);
		newCase.add(pw);
		pw.setForeground(Color.WHITE);
		pw.enableInputMethods(false);//禁用输入法
		pw.addKeyListener(new KeyAdapter() {
			 public void keyTyped(KeyEvent e) {
				 char k = e.getKeyChar();
				 if((k>='a'&&k<='z')||(k>='A'&&k<='Z')||(k>='0'&&k<='9')){
				 }else{
					 e.consume();
				 }
			 }
		});
		label_password = new JLabel(new ImageIcon("img/LoginUI/textPW.png"));
		label_password.setBounds(173, 328, 212, 43);
		newCase.add(label_password);
		
		label_Genesis = new JLabel(new ImageIcon("img/LoginUI/Genesis.png"));
		label_Genesis.setBounds(357, 595, 170, 57);
		newCase.add(label_Genesis);
		label_Genesis.setVisible(false);
		
		login = new JButton(new ImageIcon("img/LoginUI/login.png"));
		login.setBounds(221, 396, 116, 34);
		login.setBorder(null);//去掉边框
		login.setContentAreaFilled(false);//去掉背景色
		newCase.add(login);
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
		
		login2 = new JButton(new ImageIcon("img/LoginUI/login2.png"));
		login2.setBounds(221, 445, 116, 34);
		login2.setBorder(null);//去掉边框
		login2.setContentAreaFilled(false);//去掉背景色
		newCase.add(login2);
		login2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				login2.setIcon(new ImageIcon("img/LoginUI/login2.png"));
			}
			public void mouseEntered(MouseEvent e) {
				login2.setIcon(new ImageIcon("img/LoginUI/login2Act.png"));
			}
		});
		
		back = new JButton( new ImageIcon("img/LoginUI/back.png"));
		back.setBounds(221, 494, 116, 34);
		back.setBorder(null);//去掉边框
		back.setContentAreaFilled(false);//去掉背景色
		newCase.add(back);
		back.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Mainstart();
			}
			public void mouseExited(MouseEvent e) {
				back.setIcon(new ImageIcon("img/LoginUI/back.png"));
			}
			public void mouseEntered(MouseEvent e) {
				back.setIcon(new ImageIcon("img/LoginUI/backAct.png"));
			}
		});
		
		label_background = new JLabel(new ImageIcon("img/LoginUI/background.png"));
		label_background.setBounds(140, 0, 276, 650);
		newCase.add(label_background);
		
		label_background2 = new JLabel(new ImageIcon("img/LoginUI/background2.png"));
		label_background2.setBounds(60, 0, 82, 650);
		newCase.add(label_background2);
		label_background2.setVisible(false);
		
		label_background3 = new JLabel(new ImageIcon("img/LoginUI/background3.png"));
		label_background3.setBounds(370, 0, 99, 650);
		newCase.add(label_background3);
		label_background3.setVisible(false);
		
		label_background4 = new JLabel(new ImageIcon("img/LoginUI/background4.png"));
		label_background4.setBounds(439, 0, 79, 650);
		newCase.add(label_background4);
		label_background4.setVisible(false);
		
		isBack = 0;
		Mainstart();
		
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

		this.addMouseListener(mouseListener);
		this.addMouseMotionListener(mouseListener);//添加拖动监听
		
		this.repaint();
	}

	public void Mainstart(){
		thread = new Thread(com);
		thread.start();
	}

	public void run() {
		switch(isBack){
		case 0:
			try {
				thread.sleep(1000);
			} catch (InterruptedException e1) {}
			label_blue.setBounds(x=140, 0, 231, 652);//将图片重新定位到0，100
			label_red.setBounds(y=188, 0, 231, 652);//将图片重新定位到0，100
			while(x>0){//判断条件，x小于窗体的右边值
				x--;//将x--
				y++;
				if(y==290){
					label_background4.setVisible(true);
				}
				if(y==240){
					label_background3.setVisible(true);
				}
				if(x==40){
					label_background2.setVisible(true);
				}
				label_blue.setBounds(x, 0, 231, 652);//让图片移动
				label_red.setBounds(y, 0, 231, 652);//让图片移动
				try {
					thread.sleep(1);//休息2
				}
				catch (InterruptedException e){}
			}
			isBack = 1;
			label_Genesis.setVisible(true);
			break;
		case 1:
			label_Genesis.setVisible(false);
			label_blue.setBounds(x=0, 0, 231, 652);//将图片重新定位到0，100
			label_red.setBounds(y=327, 0, 231, 652);//将图片重新定位到0，100
			this.repaint();
			while(x<140){//判断条件，x小于窗体的右边值
				x++;//将x--
				y--;
				if(y==290){
					label_background4.setVisible(false);
				}
				if(y==240){
					label_background3.setVisible(false);
				}
				if(x==40){
					label_background2.setVisible(false);
				}
				label_blue.setBounds(x, 0, 231, 652);//让图片移动
				label_red.setBounds(y, 0, 231, 652);//让图片移动
				try {
					thread.sleep(1);//休息2
				}
				catch (InterruptedException e){}
			}
			try {
				thread.sleep(1000);
			} catch (InterruptedException e1) {}
			this.dispose();
			break;
		case 2:
		}
	}
}