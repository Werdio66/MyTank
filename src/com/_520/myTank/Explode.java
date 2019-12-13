package com._520.myTank;

import com._520.util.ResourceMgr;

import java.awt.*;

/**
 * 	爆炸效果
 */
public class Explode {

	// 爆炸效果的宽度和高度
	public static int explodeWidth = ResourceMgr.explodes[0].getWidth();
	public static int explodeHeight = ResourceMgr.explodes[0].getHeight();
	 // 爆炸效果的位置
	private int x, y;
	// 爆炸效果的哪个图片
	private static int speed = 0;
	private static TankFrame tf;
	public Explode(int x, int y, TankFrame tf) {
		this.x = x;
		this.y = y;
		this.tf = tf;
	}


	// 将子弹画出来
	public void paint(Graphics g) {
		g.drawImage(ResourceMgr.explodes[speed++],x,y,null);
		if (speed >= ResourceMgr.explodes.length){
			tf.explodes.remove(this);
			speed = 0;
		}


	}



	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
}
