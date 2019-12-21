package com._520.myTank;

import java.awt.*;

/**
 *  所有物体的父类，坦克，子弹等
 */
public abstract class GameObject {
    protected int x, y;

    protected abstract void paint(Graphics g);
}
