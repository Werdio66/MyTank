package com._520.abstractFactory;

import com._520.myTank.Dir;
import com._520.myTank.Group;
import com._520.myTank.TankFrame;

/**
 *  使用抽象工厂创建坦克一族
 */
public abstract class GameFactory {
    /**
     *  创建坦克
     */
    public abstract BaseTank creatTank(int x, int y, Dir dir, Group group, TankFrame tf);

    /**
     * 创建子弹
     */
    public abstract BaseBullet creatBullet(int x, int y, Dir dir, Group group, TankFrame tf);

    /**
     *  创建爆炸效果
     */
    public abstract BaseExplode creatExplode(int x, int y,TankFrame tf);
}
