package com._520.myTank.cor;

import com._520.myTank.Bullet;
import com._520.myTank.GameObject;
import com._520.myTank.Wall;

public class BulletWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Wall){
            Bullet bullet = (Bullet) o1;
            Wall wall = (Wall) o2;
            // 碰撞检测
            if (bullet.rect.intersects(wall.rect)){
                bullet.die();
            }
        }else if (o2 instanceof Bullet && o1 instanceof Wall){
            collide(o2,o1);
        }
        return true;
    }
}
