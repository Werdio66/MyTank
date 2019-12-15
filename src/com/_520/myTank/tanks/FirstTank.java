package com._520.myTank.tanks;

import com._520.myTank.abstractFactory.BaseTank;
import com._520.myTank.enums.Dir;
import com._520.myTank.enums.Group;
import com._520.myTank.main.TankFrame;
import com._520.util.ResourceMgr;

import java.awt.*;

public class FirstTank extends BaseTank {


    public FirstTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        super(x, y, dir, group, tf);
    }

    @Override
    public void paint(Graphics g) {
        // 坦克已经死了，就从集合中删除
        if (!living)
            tf.tanks.remove(this);
        switch (dir){
            case DOWN:
                g.drawImage(group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.tankD,x,y,null);
                break;
            case UP:
                g.drawImage(group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.tankU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.tankR,x,y,null);
                break;
            case LEFT:
                g.drawImage(group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.tankL,x,y,null);
                break;
        }
        // 移动
        move();
    }

}
