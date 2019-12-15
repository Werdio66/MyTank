package com._520.myTank.explodes;

import com._520.myTank.abstractFactory.BaseExplode;
import com._520.myTank.main.TankFrame;
import com._520.util.ResourceMgr;

import java.awt.*;

public class FirstExplode extends BaseExplode {


    public FirstExplode(int x, int y, TankFrame tf) {
        super(x, y, tf);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes1[speed++],x,y,null);
        if (speed >= ResourceMgr.explodes1.length){
            tf.explodes.remove(this);
            speed = 0;
        }
    }
}
