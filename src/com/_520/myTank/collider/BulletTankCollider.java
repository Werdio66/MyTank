package com._520.myTank.collider;

import com._520.myTank.Bullet;
import com._520.myTank.GameObject;
import com._520.myTank.Tank;

/**
 *  子弹和坦克的碰撞检测
 */
public class BulletTankCollider implements Collider {
    @Override
    public void collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank){
            Bullet bullet = (Bullet) o1;
            Tank tank = (Tank) o2;
            // 碰撞检测
            bullet.collideWith(tank);
        }else if (o2 instanceof Bullet && o1 instanceof Tank){
            collide(o2,o1);
        }

    }
}
