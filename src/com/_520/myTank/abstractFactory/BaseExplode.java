package com._520.myTank.abstractFactory;

import com._520.myTank.main.TankFrame;
import com._520.util.Audio;
import com._520.util.ResourceMgr;

import java.awt.*;

/**
 *  爆炸的父类
 */
public abstract class BaseExplode {
    // 爆炸效果的宽度和高度
    public static int explodeWidth = ResourceMgr.explodes[0].getWidth();
    public static int explodeHeight = ResourceMgr.explodes[0].getHeight();
    // 爆炸效果的位置
    protected int x, y;
    // 爆炸效果的哪个图片
    protected static int speed = 0;
    protected TankFrame tf;
    public BaseExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
        // 加入声音
        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }
    /**
     *  画爆炸效果
     */
    public abstract void paint(Graphics g);
}
