package com._520.myTank.abstractFactory;

import com._520.myTank.enums.Dir;
import com._520.myTank.enums.Group;
import com._520.myTank.main.TankFrame;

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
