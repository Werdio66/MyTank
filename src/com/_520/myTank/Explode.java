package com._520.myTank;

import com._520.util.Audio;
import com._520.util.ResourceMgr;

import java.awt.*;

/**
 * 	爆炸效果
 */
public class Explode extends GameObject {

	// 爆炸效果的宽度和高度
	public static int explodeWidth = ResourceMgr.explodes[0].getWidth();
	public static int explodeHeight = ResourceMgr.explodes[0].getHeight();
	 // 爆炸效果的位置
	private int x, y;
	// 爆炸效果的哪个图片
	private static int speed = 0;
	public Explode(int x, int y) {
		this.x = x;
		this.y = y;
		// 加入声音
		new Thread(()->new Audio("audio/explode.wav").play()).start();
	}


	// 将爆炸画出来
	public void paint(Graphics g) {
		g.drawImage(ResourceMgr.explodes[speed++],x,y,null);
		if (speed >= ResourceMgr.explodes.length){
			GameModel.getInstence().remove(this);
			speed = 0;
		}


	}

}
