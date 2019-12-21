package com._520.myTank;

import com._520.myTank.cor.BulletTankCollider;
import com._520.myTank.cor.Collider;
import com._520.myTank.cor.ColliderChain;
import com._520.myTank.cor.TankTankCollider;
import com._520.util.PropertyMgr;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  用来画坦克，model层
 */
public class GameModel extends Frame {

    // 创建主坦克
    Tank myTank = new Tank(600,800,Dir.UP,Group.GOOD,this);
    // 存放所有的物体
    public List<GameObject> gameObjects = new ArrayList<>();
    // 处理碰撞的链条
    private Collider chain = new ColliderChain();

    public GameModel(){
        int initTanksCount = PropertyMgr.getInt("initTanksCount");
        // 初始化敌方坦克
        for (int i = 0; i < initTanksCount; i++) {
            add(new Tank(100 * (i + 1), 300, Dir.DOWN,Group.BAD, this));
        }
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
//        g.drawString("子弹的数量:" + bullets.size(), 10, 60);
//        g.drawString("敌方坦克的数量:" + tanks.size(), 10, 90);
//        g.drawString("爆炸的数量:" + explodes.size(), 10, 110);
        g.setColor(c);
        // 画出所有的子弹，使用foreach会出现并发修改异常
//		for (Bullet b:bullets
//			 ) {
//			b.paint(g);
//		}

        // 将画笔交给坦克
        myTank.paint(g);
        // 画出子弹
//        for (int i = 0; i < bullets.size(); i++) {
//            bullets.get(i).paint(g);
//        }
//        // 画出敌方坦克
//        for (int i = 0; i < tanks.size(); i++) {
//            tanks.get(i).paint(g);
//        }
//
//        for (int i = 0; i < explodes.size(); i++) {
//            explodes.get(i).paint(g);
//        }
        // 画出所有的物体
        for (int i = 0; i < gameObjects.size(); i++) {
            gameObjects.get(i).paint(g);
        }
        // 碰撞检测
//        for (int i = 0; i < bullets.size(); i++) {
//            for (int j = 0; j < tanks.size(); j++) {
//                bullets.get(i).collideWith(tanks.get(j));
//            }
//        }

        for (int i = 0; i < gameObjects.size() - 1; i++) {
            for (int j = i + 1; j < gameObjects.size(); j++) {
                GameObject o1 = gameObjects.get(i);
                GameObject o2 = gameObjects.get(j);
                // 碰撞器
                chain.collide(o1,o2);
            }
        }

    }



    public Tank getMainTank() {
        return myTank;
    }
    public void add(GameObject go){
        gameObjects.add(go);
    }

    public void remove(GameObject go){
        gameObjects.remove(go);
    }
}
