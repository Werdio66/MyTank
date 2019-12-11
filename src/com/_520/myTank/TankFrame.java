package com._520.myTank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.*;

public class TankFrame extends Frame {
	// 主窗体
	public static final TankFrame INSTANCE = new TankFrame();
	// 方向默认向下
	private Dir dir = Dir.DOWN;
	// 创建主坦克
	Tank myTank = new Tank(200,300,dir,INSTANCE);
	// 窗体大小
	static final int GAME_WIDTH = 1080, GAME_HEIGHT = 960;
	private TankFrame() {
		setSize(GAME_WIDTH, GAME_HEIGHT);
		setResizable(false);
		setTitle("tank war");
		setVisible(true);
		this.addKeyListener(new MyKeyListener());
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) { // bjmashibing/tank
				System.exit(0);
			}

		});
	}
//	// 处理闪烁
//	Image offScreenImage = null;
//	@Override
//	public void update(Graphics g) {
//		if (offScreenImage == null) {
//			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
//		}
//		Graphics gOffScreen = offScreenImage.getGraphics();
//		Color c = gOffScreen.getColor();
//		gOffScreen.setColor(Color.BLACK);
//		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
//		gOffScreen.setColor(c);
//		paint(gOffScreen);
//		g.drawImage(offScreenImage, 0, 0, null);
//	}
	@Override
	public void paint(Graphics g) {
//		Color c = g.getColor();
//		g.setColor(Color.WHITE);
//		g.setColor(c);
		myTank.paint(g);
		}


	class MyKeyListener extends KeyAdapter {

		boolean bL = false;
		boolean bU = false;
		boolean bR = false;
		boolean bD = false;

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bL = true;
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
			// 处理发射子弹
			case KeyEvent.VK_CONTROL:

				break;

			default:
				break;
			}
		}

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