package com._520.myTank;

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
	// 创建主坦克
	Tank myTank = new Tank(600,800,Dir.UP,Group.GOOD,this);
	// 创建子弹集合，用来存放多个子弹
	List<Bullet> bullets = new ArrayList<>();
	// 存放敌方坦克
	List<Tank> tanks = new ArrayList<>();
	// 存放每个坦克的爆炸
	List<Explode> explodes = new ArrayList<>();
	// 窗体大小
	static final int GAME_WIDTH = 1280, GAME_HEIGHT = 960;
	// 初始化
	private TankFrame() {
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
	Image offScreenImage = null;
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
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("子弹的数量:" + bullets.size(), 10, 60);
		g.drawString("敌方坦克的数量:" + tanks.size(), 10, 90);
		g.drawString("爆炸的数量:" + explodes.size(), 10, 110);
		g.setColor(c);
		// 画出所有的子弹，使用foreach会出现并发修改异常
//		for (Bullet b:bullets
//			 ) {
//			b.paint(g);
//		}

		// 将画笔交给坦克
		myTank.paint(g);
		// 画出子弹
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).paint(g);
		}
		// 画出敌方坦克
		for (int i = 0; i < tanks.size(); i++) {
			tanks.get(i).paint(g);
		}

		for (int i = 0; i < explodes.size(); i++) {
			explodes.get(i).paint(g);
		}
		// 碰撞检测
		for (int i = 0; i < bullets.size(); i++) {
			for (int j = 0; j < tanks.size(); j++) {
				bullets.get(i).collideWith(tanks.get(j));
			}
		}


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
					myTank.fire();
					break;
				default:
					break;
			}
		}

		// 将按键传给坦克，控制移动
		private void setMainTankDir() {
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