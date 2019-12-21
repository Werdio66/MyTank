package com._520.myTank.cor;

import com._520.myTank.Bullet;
import com._520.myTank.Explode;
import com._520.myTank.GameObject;
import com._520.myTank.Tank;

import java.awt.*;

/**
 *  子弹和坦克的碰撞检测
 */
public class BulletTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank){
            Bullet bullet = (Bullet) o1;
            Tank tank = (Tank) o2;
            // 相撞返回就结束
            if (collideWith(tank, bullet))
                return false;
        }else if (o2 instanceof Bullet && o1 instanceof Tank){
            return collide(o2,o1);
        }
        // 没有相撞就继续做其他的检测
        return true;
    }

    // 碰撞检测
    private boolean collideWith(Tank tank, Bullet bullet) {
        if (bullet.group == tank.getGroup())
            return false;

        // 相交，坦克和子弹都死
        if(bullet.rect.intersects(tank.rect)) {
            tank.die();
            bullet.die();
            // 计算爆炸的位置
            int bX = tank.getX() + Tank.tankWidth / 2 - Explode.explodeWidth / 2;
            int bY = tank.getY() + Tank.tankHeight / 2 - Explode.explodeHeight / 2;
            // 增加爆炸效果
            bullet.gm.gameObjects.add(new Explode(bX,bY,bullet.gm));
            return true;
        }
        return false;
    }
}
