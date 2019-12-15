package com._520.myTank.fireStrategy;

import com._520.myTank.abstractFactory.BaseTank;
import com._520.myTank.bullets.Bullet;
import com._520.myTank.enums.Group;
import com._520.myTank.tanks.Tank;
import com._520.util.Audio;

/**
 *  默认的策略
 */
public class DefultFireStrategy implements FireStrategy {

    private DefultFireStrategy(){}
    private static DefultFireStrategy INSTENCE = new DefultFireStrategy();
    public static DefultFireStrategy getInstance(){
        return INSTENCE;
    }
    @Override
    public void fire(BaseTank tank) {
        // 计算子弹的位置
        int bX = tank.getX() + Tank.tankWidth / 2 - Bullet.bulletWidth / 2;
        int bY = tank.getY() + Tank.tankHeight / 2 - Bullet.bulletHeight / 2;
        // 将子弹加入子弹集合中
        tank.tf.factory.creatBullet(bX,bY+4,tank.dir,tank.group,tank.tf);
        // 增加子弹发射的声音
        if (tank.group == Group.GOOD)
            new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
    }
}
