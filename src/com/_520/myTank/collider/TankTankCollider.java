package com._520.myTank.collider;

import com._520.myTank.Dir;
import com._520.myTank.GameObject;
import com._520.myTank.Tank;

public class TankTankCollider implements Collider {
    @Override
    public void collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank){
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            // 碰撞检测
            if (t1.rect.intersects(t2.rect)){
                Dir dir1 = t1.dir;
                Dir dir2 = t2.dir;
                t1.setDir(changeDir(dir1));
            t2.setDir(changeDir(dir2));
            }
        }
    }

    /**
     *  改变方向为当前方向的反方向
     */
    private Dir changeDir(Dir dir) {
        if (dir == Dir.DOWN)
            return Dir.UP;
        else if (dir == Dir.UP)
            return Dir.DOWN;
        else if (dir == Dir.LEFT)
            return Dir.RIGHT;
        else
            return Dir.LEFT;
    }


}
