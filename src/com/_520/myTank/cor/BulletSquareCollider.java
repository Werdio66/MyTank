package com._520.myTank.cor;

import com._520.myTank.Bullet;
import com._520.myTank.GameObject;
import com._520.myTank.Square;

public class BulletSquareCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Square){
            Bullet bullet = (Bullet) o1;
            Square square = (Square) o2;
            // 碰撞检测
            if (bullet.rect.intersects(square.rect)){
                bullet.die();
                return true;
            }
        }else if (o2 instanceof Bullet && o1 instanceof Square){
            return collide(o2,o1);
        }
        return true;
    }
}
