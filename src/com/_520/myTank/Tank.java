package com._520.myTank;

import java.awt.*;
import java.util.Random;
import java.util.UUID;

public class Tank {
	// 坦克的速度
	private static final int SPEED = 20;
	// 坦克的宽度
	private static int WIDTH = 50;
	// 坦克的高度
	private static int HEIGHT = 50;
	// 坦克的位置
	private int x, y;
	// 坦克的方向
	private Dir dir;
	// 判断坦克是否在移动
	private boolean moving = false;

	private TankFrame tf = null;

	public Tank(int x, int y, Dir dir, TankFrame tf) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}

	/**
	 * 	坦克的移动
	 */
	private void move() {
		// 没有按键就返回
		if (!moving)
			return;
		// 有按键，判断按键
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

	// 将坦克画出来
	public void paint(Graphics g) {
//		Color c = g.getColor();
//		g.setColor(Color.YELLOW);
		g.fillRect(x,y,WIDTH,HEIGHT);
//		g.setColor(c);
		move();
	}

	public void fire(){
		tf.bullet = new Bullet(this.x,this.y,this.dir);
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
	public boolean isMoving() {
		return moving;
	}
	public void setMoving(boolean moving) {
		this.moving = moving;
	}
}
