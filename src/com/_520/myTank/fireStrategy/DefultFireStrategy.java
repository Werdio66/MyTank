package com._520.myTank.fireStrategy;

import com._520.myTank.Bullet;
import com._520.myTank.Group;
import com._520.myTank.Tank;
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
    public void fire(Tank tank) {
        // 计算子弹的位置
        int bX = tank.getX() + Tank.tankWidth / 2 - Bullet.bulletWidth / 2;
        int bY = tank.getY() + Tank.tankHeight / 2 - Bullet.bulletHeight / 2;
        // 将子弹加入子弹集合中
        new Bullet(bX,bY+4,tank.dir,tank.group,tank.gameModel);
        // 增加子弹发射的声音
        if (tank.group == Group.GOOD)
            new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
    }
}
