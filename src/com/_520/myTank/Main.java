package com._520.myTank;

import com._520.util.Audio;
import com._520.util.PropertyMgr;
import com._520.util.ResourceMgr;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// 加载图片
//		new ResourceMgr();
		// 画板
		TankFrame tf = TankFrame.getInstance();



		// 开启游戏背景音乐
		new Thread(() -> new Audio("audio/war1.wav").loop()).start();
		tf.setVisible(true);
		while(true) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tf.repaint();
		}
	}
}
