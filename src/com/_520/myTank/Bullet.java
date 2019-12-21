package com._520.myTank;

import com._520.util.ResourceMgr;

import java.awt.*;

/**
 * 	子弹类
 */
public class Bullet extends GameObject {
	// 子弹的速度
	private static final int SPEED = 10;
	// 子弹的宽度和高度
	public static int bulletWidth = ResourceMgr.bulletD.getWidth();
	public static int bulletHeight = ResourceMgr.bulletD.getHeight();
	 // 子弹的位置
	private int x, y;
    // 子弹的方向
    private Dir dir;
    //
    public Rectangle rect = new Rectangle();
	// 默认子弹是敌方子弹
	public Group group;
	// 子弹是否存活
	private boolean living = true;
	public GameModel gm;
	public Bullet(int x, int y, Dir dir,Group group, GameModel gm) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		this.gm = gm;
        rect.x = this.x;
        rect.y = this.y;
		rect.width = bulletWidth;
		rect.height = bulletHeight;
		// 每次new出来对象就加到集合中
		gm.gameObjects.add(this);
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
        // 更新rect
        rect.x = this.x;
        rect.y = this.y;
		// 子弹飞出边界
		if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT)
			living = false;

	}

	// 将子弹画出来
	public void paint(Graphics g) {
		// 删除子弹
		if (!living && gm.gameObjects.size() > 0)
			gm.gameObjects.remove(this);

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


    public void die() {
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
