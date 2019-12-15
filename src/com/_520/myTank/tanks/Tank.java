package com._520.myTank.tanks;

import com._520.myTank.abstractFactory.BaseTank;
import com._520.myTank.enums.Dir;
import com._520.myTank.enums.Group;
import com._520.myTank.main.TankFrame;
import com._520.myTank.fireStrategy.DefultFireStrategy;
import com._520.myTank.fireStrategy.FireStrategy;
import com._520.util.Audio;
import com._520.util.PropertyMgr;
import com._520.util.ResourceMgr;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class Tank extends BaseTank {

	public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
		// 调用父类的构造器
		super(x, y, dir, group, tf);
	}

	// 将坦克画出来
	@Override
	public void paint(Graphics g) {
		// 坦克已经死了，就从集合中删除
		if (!living)
			tf.tanks.remove(this);
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
		// 移动
		move();
	}

}
