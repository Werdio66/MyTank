package com._520.myTank;

import com._520.util.ResourceMgr;
import java.awt.*;
import java.util.HashMap;

/**
 *  墙
 */
public class Square extends GameObject {
    // 位置
    private int x, y;

    // 墙的宽度和高度
    public static int Width = ResourceMgr.square.getWidth();
    public static int Height = ResourceMgr.square.getHeight();

    public Rectangle rect = new Rectangle();
    private GameModel gameModel;
    public Square(int x, int y, GameModel gameModel){
        this.x = x;
        this.y = y;
        this.gameModel = gameModel;
        rect.x = this.x;
        rect.y = this.y;
        rect.width = Width;
        rect.height = Height;
    }
    @Override
    protected void paint(Graphics g) {
        g.drawImage(ResourceMgr.square,x,y,null);
    }
}
