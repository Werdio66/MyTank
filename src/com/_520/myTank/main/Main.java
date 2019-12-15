package com._520.myTank.main;

import com._520.myTank.enums.Dir;
import com._520.myTank.enums.Group;
import com._520.util.Audio;
import com._520.util.PropertyMgr;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// 加载图片
//		new ResourceMgr();
		// 画板
		TankFrame tf = TankFrame.getInstance();

		int initTanksCount = PropertyMgr.getInt("initTanksCount");
		// 初始化敌方坦克
		for (int i = 0; i < initTanksCount; i++) {
			tf.tanks.add(tf.factory.creatTank(100 * (i + 1), 300, Dir.DOWN, Group.BAD, tf));
		}

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
