package com._520.myTank;

import com._520.util.PropertyMgr;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;


public class TankFrame extends Frame {
	// 主窗体
	private static final TankFrame INSTANCE = new TankFrame();

	private GameModel gameModel = GameModel.getInstence();
	// 窗体大小
	static int GAME_WIDTH, GAME_HEIGHT;
	// 初始化
	private TankFrame() {
		// 从配置文件中获取界面大小
		int gameWidth = PropertyMgr.getInt("gameWidth");
		int gameHeight = PropertyMgr.getInt("gameHeight");
		System.out.println(gameWidth + "   " + gameHeight);
		GAME_WIDTH = gameWidth;
		GAME_HEIGHT = gameHeight;
		setSize(GAME_WIDTH, GAME_HEIGHT);
		setResizable(false);
		setTitle("tank war");
		setVisible(true);
		// 加入按键接听
		this.addKeyListener(new MyKeyListener());
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) { // bjmashibing/tank
				System.exit(0);
			}

		});
	}
	public static TankFrame getInstance(){
		return INSTANCE;
	}
	// 处理闪烁
	private Image offScreenImage = null;
	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	// 画
	@Override
	public void paint(Graphics g) {
		gameModel.paint(g);

	}

	/**
	 * 	按键监听
	 */
	class MyKeyListener extends KeyAdapter {
		// 判断按下的是哪个键
		boolean bL = false;
		boolean bU = false;
		boolean bR = false;
		boolean bD = false;

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			// 哪个键被按下就将对应的属性设置为true
			switch (key) {
			case KeyEvent.VK_LEFT:
				bL = true;
				//
				setMainTankDir();
				break;
			case KeyEvent.VK_UP:
				bU = true;
				setMainTankDir();
				break;
			case KeyEvent.VK_RIGHT:
				bR = true;
				setMainTankDir();
				break;
			case KeyEvent.VK_DOWN:
				bD = true;
				setMainTankDir();
				break;
			default:
				break;
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
				case KeyEvent.VK_LEFT:
					bL = false;
					setMainTankDir();
					break;
				case KeyEvent.VK_UP:
					bU = false;
					setMainTankDir();
					break;
				case KeyEvent.VK_RIGHT:
					bR = false;
					setMainTankDir();
					break;
				case KeyEvent.VK_DOWN:
					bD = false;
					setMainTankDir();
					break;
				case KeyEvent.VK_CONTROL:
					// 发射子弹
					gameModel.getMainTank().fire();
					break;
				default:
					break;
			}
		}

		// 将按键传给坦克，控制移动
		private void setMainTankDir() {
			// 从model中获取坦克
			Tank myTank = gameModel.getMainTank();
			if (!bL && !bU && !bR && !bD) {
				myTank.setMoving(false);
			} else {
				myTank.setMoving(true);
				if (bL)
					myTank.setDir(Dir.LEFT);
				if (bU)
					myTank.setDir(Dir.UP);
				if (bR)
					myTank.setDir(Dir.RIGHT);
				if (bD)
					myTank.setDir(Dir.DOWN);
			}
		}
	}

	//
}