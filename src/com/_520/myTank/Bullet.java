package com._520.myTank;

import com._520.util.ResourceMgr;

import java.awt.*;
import java.util.UUID;

/**
 * 	子弹类
 */
public class Bullet {
	// 子弹的速度
	private static final int SPEED = 6;
	// 子弹的宽度和高度
	public static int bulletWidth = ResourceMgr.bulletD.getWidth();
	public static int bulletHeight = ResourceMgr.bulletD.getHeight();
	 // 子弹的位置
	private int x, y;
	// 子弹的方向
	private Dir dir;
	// 子弹是否存活
	private boolean live = true;
	private TankFrame tf;
	public Bullet(int x, int y, Dir dir, TankFrame tf) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
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
		// 子弹飞出边界
		if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT)
			live = false;
	}

	// 将子弹画出来
	public void paint(Graphics g) {
		// 删除子弹
		if (!live && tf.bullets.size() > 0)
			tf.bullets.remove(this);
//		Color c = g.getColor();
//		g.setColor(Color.RED);
//		g.fillOval(x,y,WIDTH,HEIGHT);
//		g.setColor(c);
		// 图片版
		switch (dir){
			case DOWN:
				g.drawImage(ResourceMgr.bulletD,x,y,null);
				break;
			case UP:
				g.drawImage(ResourceMgr.bulletU,x,y,null);
				break;
			case RIGHT:
				g.drawImage(ResourceMgr.bulletR,x,y,null);
				break;
			case LEFT:
				g.drawImage(ResourceMgr.bulletL,x,y,null);
				break;
		}
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
