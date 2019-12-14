package com._520.abstractFactory;

import com._520.myTank.Group;
import java.awt.*;

/**
 *  所有坦克的父类
 */
public abstract class BaseTank {
    public Rectangle rect = new Rectangle();
    /**
     *  画坦克
     */
    public abstract void paint(Graphics g);

    public abstract void die();
    public abstract Group getGroup();
    public abstract int getX();
    public abstract int getY();
}
