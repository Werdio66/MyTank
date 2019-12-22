package com._520.myTank;

import com._520.util.ResourceMgr;
import java.awt.*;
import java.util.HashMap;

/**
 *  墙
 */
public class Wall extends GameObject {
    // 位置
    private int x, y;

    // 墙的宽度和高度
    public static int Width = ResourceMgr.square.getWidth();
    public static int Height = ResourceMgr.square.getHeight();

    public Rectangle rect = new Rectangle();
    public Wall(int x, int y){
        this.x = x;
        this.y = y;
        rect.x = this.x;
        rect.y = this.y;
        rect.width = Width;
        rect.height = Height;
    }
    @Override
    protected void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.cyan);
        g.fillRect(x,y,90,90);
        g.setColor(color);
        //g.drawImage(ResourceMgr.square,x,y,null);
    }
}
