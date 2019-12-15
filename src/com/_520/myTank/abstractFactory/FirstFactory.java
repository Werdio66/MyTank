package com._520.myTank.abstractFactory;

import com._520.myTank.bullets.Bullet;
import com._520.myTank.enums.Dir;
import com._520.myTank.enums.Group;
import com._520.myTank.explodes.Explode;
import com._520.myTank.main.TankFrame;
import com._520.myTank.tanks.Tank;

public class FirstFactory extends GameFactory {
    private FirstFactory(){}
    private static FirstFactory INSTENCE = new FirstFactory();

    public static FirstFactory getInstance(){
        return INSTENCE;
    }
    @Override
    public BaseTank creatTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new Tank(x,y,dir,group,tf);
    }

    @Override
    public BaseBullet creatBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new Bullet(x,y,dir,group,tf);
    }

    @Override
    public BaseExplode creatExplode(int x, int y, TankFrame tf) {
        return new Explode(x,y,tf);
    }
}
