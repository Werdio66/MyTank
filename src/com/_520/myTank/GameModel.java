package com._520.myTank;

import com._520.myTank.collider.BulletTankCollider;
import com._520.myTank.collider.Collider;
import com._520.myTank.collider.TankTankCollider;
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
//    // 创建子弹集合，用来存放多个子弹
//    java.util.List<Bullet> bullets = new ArrayList<>();
//    // 存放敌方坦克
//    java.util.List<Tank> tanks = new ArrayList<>();
//    // 存放每个坦克的爆炸
//    List<Explode> explodes = new ArrayList<>();
    // 存放所有的物体
    List<GameObject> gameObjects = new ArrayList<>();

    // 子弹和坦克的碰撞
    private Collider collider = new BulletTankCollider();
    // 坦克和坦克的碰撞
    private Collider collider1 = new TankTankCollider();

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
                collider.collide(o1,o2);
                collider1.collide(o1,o2);
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
