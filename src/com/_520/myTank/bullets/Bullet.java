package com._520.myTank.bullets;

import com._520.myTank.abstractFactory.BaseBullet;
import com._520.myTank.abstractFactory.BaseTank;
import com._520.myTank.enums.Dir;
import com._520.myTank.explodes.Explode;
import com._520.myTank.enums.Group;
import com._520.myTank.main.TankFrame;
import com._520.myTank.tanks.Tank;
import com._520.util.ResourceMgr;

import java.awt.*;

/**
 * 	子弹类
 */
public class Bullet extends BaseBullet {
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
    private Rectangle rect = new Rectangle();
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
        rect.x = this.x;
        rect.y = this.y;
		rect.width = bulletWidth;
		rect.height = bulletHeight;
		// 每次new出来对象就加到集合中
		tf.bullets.add(this);
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
	@Override
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
    public void collideWith(BaseTank tank) {
		if (group == tank.getGroup())
			return;
		// 主坦克
		Rectangle myTank = new Rectangle(tf.myTank.getX(), tf.myTank.getY(), Tank.tankWidth, Tank.tankHeight);

		// 相交，坦克和子弹都死
        if(this.rect.intersects(tank.rect)) {
            tank.die();
            this.die();
			// 计算爆炸的位置
			int bX = tank.getX() + Tank.tankWidth / 2 - Explode.explodeWidth / 2;
			int bY = tank.getY() + Tank.tankHeight / 2 - Explode.explodeHeight / 2;
			// 增加爆炸效果
            tf.explodes.add(tf.factory.creatExplode(bX,bY,tf));
        }
    }


    private void die() {
        living = false;
    }
}