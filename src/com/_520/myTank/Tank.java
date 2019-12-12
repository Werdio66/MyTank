package com._520.myTank;

import com._520.util.ResourceMgr;
import java.awt.*;

public class Tank {
	// 坦克的速度
	private static final int SPEED = 20;
	// 坦克的宽度
	public static final int tankWidth = ResourceMgr.tankD.getWidth();
	// 坦克的高度
	public static final int tankHeight = ResourceMgr.tankD.getHeight();
	// 坦克的位置
	private int x, y;
	// 坦克的方向
	private Dir dir;
	// 判断坦克是否在移动
	private boolean moving = false;
	// 将当前画板传递给坦克
	private TankFrame tf;
	private boolean living = true;

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
		// 坦克已经死了，就从集合中删除
		if (!living)
			tf.tanks.remove(this);
		switch (dir){
			case DOWN:
				g.drawImage(ResourceMgr.tankD,x,y,null);
				break;
			case UP:
				g.drawImage(ResourceMgr.tankU,x,y,null);
				break;
			case RIGHT:
				g.drawImage(ResourceMgr.tankR,x,y,null);
				break;
			case LEFT:
				g.drawImage(ResourceMgr.tankL,x,y,null);
				break;
		}
		move();
	}

	// 发射子弹
	public void fire(){
		// 计算子弹的位置
		int bX = this.x + tankWidth / 2 - Bullet.bulletWidth / 2;
		int bY = this.y + tankHeight / 2 - Bullet.bulletHeight / 2;
		// 将子弹加入子弹集合中
		this.tf.bullets.add(new Bullet(bX,bY+4,this.dir,tf));
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

	public void die() {
		living = false;
	}
}
