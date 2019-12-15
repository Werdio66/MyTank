package com._520.myTank.explodes;

import com._520.myTank.abstractFactory.BaseExplode;
import com._520.myTank.main.TankFrame;
import com._520.util.Audio;
import com._520.util.ResourceMgr;

import java.awt.*;

/**
 * 	爆炸效果
 */
public class Explode extends BaseExplode {


	public Explode(int x, int y, TankFrame tf) {
		super(x, y, tf);
	}

	// 将爆炸画出来
	@Override
	public void paint(Graphics g) {
		g.drawImage(ResourceMgr.explodes[speed++],x,y,null);
		if (speed >= ResourceMgr.explodes.length){
			tf.explodes.remove(this);
			speed = 0;
		}
	}
}
