package com._520.myTank;

import com._520.myTank.fireStrategy.DefultFireStrategy;
import com._520.myTank.fireStrategy.FireStrategy;
import com._520.myTank.fireStrategy.FourFireStrategy;
import com._520.util.Audio;
import com._520.util.PropertyMgr;
import com._520.util.ResourceMgr;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class Tank extends GameObject {
	// 坦克的速度
	private static int SPEED;
	// 坦克的宽度
	public static final int tankWidth = ResourceMgr.goodTankD.getWidth();
	// 坦克的高度
	public static final int tankHeight = ResourceMgr.goodTankD.getHeight();
	// 坦克的位置
	private int x, y;
	// 坦克的方向
	public Dir dir;
	// 默认坦克是坏的
	public Group group;
	// 坦克的矩形框
	public Rectangle rect = new Rectangle();
	// 判断坦克是否在移动
	private boolean moving = false;
	// 将当前画板传递给坦克
	public GameModel gameModel;
	// 坦克是否存活
	private boolean living = true;
	private Random random = new Random();

	public Tank(int x, int y, Dir dir, Group group, GameModel gameModel) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		this.gameModel = gameModel;
		rect.x = this.x;
		rect.y = this.y;
		rect.width = tankWidth;
		rect.height = tankHeight;
	}

	static {
		// 从配置文件中获取速度
		SPEED = PropertyMgr.getInt("speed");
	}
	/**
	 * 	坦克的移动
	 */
	private void move() {
		// 没有按键就返回
		if (!moving && group == Group.GOOD)
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
		// 坦克移动音效
		if (group == Group.GOOD)
			new Thread(() -> new Audio("audio/tank_move.wav").play()).start();

		// 让坏坦克可以发射子弹
		if (group == Group.BAD && random.nextInt(100) > 95){
			this.fire();
		}
		if (group == Group.BAD && random.nextInt(100) > 95){
			// 改变方向
			chageDir();
		}
		// 边界处理
		boundsCheck();
		// 更新rect
		rect.x = this.x;
		rect.y = this.y;
	}

	private void boundsCheck() {
		if(this.x < 2) x = 2;
		if (this.y < 28) y = 28;
		if (this.x > TankFrame.GAME_WIDTH - Tank.tankWidth - 2) x = TankFrame.GAME_WIDTH - Tank.tankWidth -2;
		if (this.y > TankFrame.GAME_HEIGHT - Tank.tankHeight - 2) y = TankFrame.GAME_HEIGHT -Tank.tankHeight -2;
	}
	// 随机改变方向
	private void chageDir() {
		// 随机在枚举类中选择一个方向
		this.dir = Dir.values()[random.nextInt(4)];
	}

	// 将坦克画出来
	public void paint(Graphics g) {
		// 坦克已经死了，就从集合中删除
		if (!living)
			gameModel.gameObjects.remove(this);
		switch (dir){
			case DOWN:
				g.drawImage(group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD,x,y,null);
				break;
			case UP:
				g.drawImage(group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU,x,y,null);
				break;
			case RIGHT:
				g.drawImage(group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR,x,y,null);
				break;
			case LEFT:
				g.drawImage(group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL,x,y,null);
				break;
		}
		move();
	}

	// 发射子弹
	public void fire(){
		if (this.group == Group.GOOD){
			// 从配置文件中读取策略
			String msgName = PropertyMgr.getString("fireMsd");
			FireStrategy fireStrategy = null;
			try {
				// 得到指定类的方法
				Method method = Class.forName(msgName).getMethod("getInstence");
				// 调用方法得到对象
				fireStrategy = (FireStrategy) method.invoke(method);
			} catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
				e.printStackTrace();
			}
			// 如果配置文件中没有就使用默认的策略
			if (fireStrategy != null)
				fireStrategy.fire(this);
			else
				DefultFireStrategy.getInstance().fire(this);
		}
		else
			DefultFireStrategy.getInstance().fire(this);
	}


	public void die() {
		living = false;
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
	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	public Group getGroup() {
		return group;
	}
}
