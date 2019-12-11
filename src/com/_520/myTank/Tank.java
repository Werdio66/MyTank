package com._520.myTank;

import java.awt.*;
import java.util.Random;
import java.util.UUID;

public class Tank {
	private static final int SPEED = 20;
	private static int WIDTH = 30;
	private static int HEIGHT = 30;
	private int x, y;
	private Dir dir = Dir.DOWN;
	private boolean moving = false;
	private TankFrame tf = null;

	public Tank(int x, int y, Dir dir, TankFrame tf) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}

	private void move() {
		if (!moving)
			return;
		switch (dir) {
		case LEFT:
			x -= SPEED;
			break;
		case UP:
			y -= SPEED;
			break;
		case RIGHT:
			x += SPEED;
			break;
		case DOWN:
			y += SPEED;
			break;
		}
	}

	public void paint(Graphics g) {
		g.fillRect(30,30,WIDTH,HEIGHT);
//		Color c = g.getColor();
//		g.setColor(Color.YELLOW);
//		g.setColor(c);
		move();
	}


	public Dir getDir() {
		return dir;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setDir(Dir dir) {
		this.dir = dir;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isMoving() {
		return moving;
	}
	public void setMoving(boolean moving) {
		this.moving = moving;
	}
}
