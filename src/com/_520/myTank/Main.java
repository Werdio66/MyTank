package com._520.myTank;


import com._520.util.ResourceMgr;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		ResourceMgr rs = new ResourceMgr();
		TankFrame tf = TankFrame.getInstance();

		for (int i = 0; i < 5; i++) {
			tf.tanks.add(new Tank(200 * (i + 1), 300, Dir.DOWN,Group.BAD, tf));

		}
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
