package com._520.myTank;

import com._520.util.ResourceMgr;

import java.awt.*;

/**
 * 	子弹类
 */
public class Bullet {
	// 子弹的速度
	private static final int SPEED = 10;
	// 子弹的宽度和高度
	public static int bulletWidth = ResourceMgr.bulletD.getWidth();
	public static int bulletHeight = ResourceMgr.bulletD.getHeight();
	 // 子弹的位置
	private int x, y;
	// 子弹的方向
	private Dir dir;
	// 默认子弹是敌方子弹
	private Group group;
	// 子弹是否存活
	private boolean living = true;
	private TankFrame tf;
	public Bullet(int x, int y, Dir dir,Group group, TankFrame tf) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
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
			living = false;
	}

	// 将子弹画出来
	public void paint(Graphics g) {
		// 删除子弹
		if (!living && tf.bullets.size() > 0)
			tf.bullets.remove(this);

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

	// 碰撞检测
    public void collideWith(Tank tank) {
		if (group == tank.getGroup())
			return;
		// 子弹的矩形框
		Rectangle bulletRect = new Rectangle(this.x, this.y, bulletWidth, bulletHeight);
		// 坦克的矩形框
		Rectangle tankRect = new Rectangle(tank.getX(), tank.getY(), Tank.tankWidth, Tank.tankHeight);
		// 主坦克
		Rectangle myTank = new Rectangle(tf.myTank.getX(), tf.myTank.getY(), Tank.tankWidth, Tank.tankHeight);

		// 相交，坦克和子弹都死
        if(bulletRect.intersects(tankRect)) {
            tank.die();
            this.die();
			// 计算爆炸的位置
			int bX = tank.getX() + Tank.tankWidth / 2 - Explode.explodeWidth / 2;
			int bY = tank.getY() + Tank.tankHeight / 2 - Explode.explodeHeight / 2;
            tf.explodes.add(new Explode(bX,bY,tf));
        }
    }


    private void die() {
        living = false;
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
