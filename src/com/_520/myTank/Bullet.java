package com._520.myTank;

import java.awt.*;
import java.util.UUID;

/**
 * 	子弹类
 */
public class Bullet {
	// 子弹的速度
	private static final int SPEED = 6;
	// 子弹的宽度和高度
	public static int WIDTH = 25;
	public static int HEIGHT = 25;
	 // 子弹的位置
	private int x, y;
	// 子弹的方向
	private Dir dir;
	//
	private TankFrame tf = null;

	public Bullet(int x, int y, Dir dir, TankFrame tf) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}

	public Bullet(int x, int y, Dir dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	private void move() {
		switch (dir) {
			case LEFT:
				x -= SPEED;
				break;
			case UP:
				y -= SPEED;
				break;
			case RIGHT:
				x += SPEED;
				break;
			case DOWN:
				y += SPEED;
				break;
		}
	}

	// 将子弹画出来
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.YELLOW);
		g.fillRect(x,y,WIDTH,HEIGHT);
		g.setColor(c);
		move();
	}





	public Dir getDir() {
		return dir;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setDir(Dir dir) {
		this.dir = dir;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
}
