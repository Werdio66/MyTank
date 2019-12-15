package com._520.myTank.abstractFactory;

import java.awt.*;

/**
 *  子弹的父类
 */
public abstract class BaseBullet {

    /**
     *  画子弹
     */
    public abstract void paint(Graphics g);
    // 碰撞检测
    public abstract void collideWith(BaseTank tank);
}
