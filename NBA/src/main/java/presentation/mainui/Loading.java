package presentation.mainui;

import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import presentation.component.GLabel;

import com.sun.awt.AWTUtilities;

@SuppressWarnings("restriction")
public class Loading extends JFrame implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Container newCase;
	private GLabel loading;
	private GLabel moving;
	private Thread thread;
	private Loading com = this;
	
	public static void main(String[] args) {
		Loading loading = new Loading(0, 0, null);
		loading.start();
	}
	
	public Loading(int x, int y, Container container){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭进程
		this.setUndecorated(true);
		this.setSize(50, 50);//设置大小
		AWTUtilities.setWindowOpaque(this, false);
//		Toolkit toolkit = Toolkit.getDefaultToolkit();
//		Dimension screen = toolkit.getScreenSize();
//		int x = (int)(screen.getWidth()-this.getWidth())/2;
//		int y = (int)(screen.getHeight()-this.getHeight())/2-32;
		if(container == null){
			this.setLocation(x, y);
		}else{
			Point location = container.getLocation();
			this.setLocation(location.x+x, location.y+y);
		}
		this.setVisible(true);
		
		newCase = getContentPane();//容器
		newCase.setLayout(null);//取消模式
		
		thread = new Thread(com);
		
		Point loadingSize = new Point(50, 50);
		Point movingSize = new Point(6, 6);
		
		Point loadingLocation = new Point(0, 0);
		Point movingLocation = new Point(22, 0);
		
		moving = new GLabel("img/Loading/Moving.png", movingLocation, movingSize, newCase, true);
		loading = new GLabel("img/Loading/Loading2.png", loadingLocation, loadingSize, newCase, true);
		
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
				Loading.this.setLocation(xx, yy);
			}
		};

//		this.addMouseListener(mouseListener);
//		this.addMouseMotionListener(mouseListener);//添加拖动监听
		
		this.repaint();
	}
	
	
	public void run(){
		int x, y;
		double a=0;
		while(true){
			x=(int)(22*Math.cos(a)+22);
			y=(int)(22*Math.sin(a)+22);
			moving.setLocation(x, y);
			a+=0.00001;
			try {
				thread.sleep(1/2);
			} catch (InterruptedException e) {}
		}
	}
	
	public void start(){
		thread.start();
	}
	
	public void stop(){
		thread.stop();
		this.dispose();
	}
}
