package com._520.myTank;


public class Main {

	public static void main(String[] args) throws InterruptedException {
		TankFrame tf = TankFrame.INSTANCE;
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
