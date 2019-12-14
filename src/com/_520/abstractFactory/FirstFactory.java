package com._520.abstractFactory;

import com._520.myTank.*;

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
