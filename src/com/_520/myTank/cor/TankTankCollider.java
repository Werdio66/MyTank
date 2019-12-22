package com._520.myTank.cor;

import com._520.myTank.Dir;
import com._520.myTank.GameObject;
import com._520.myTank.Tank;

import java.util.Random;

public class TankTankCollider implements Collider {

    private Random random = new Random();
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank){
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            // 碰撞检测
            if (t1.rect.intersects(t2.rect)){
//                Dir dir1 = t1.dir;
//                Dir dir2 = t2.dir;
//                t1.setDir(changeDir(dir1));
//                t2.setDir(changeDir(dir2));
                t1.back();
                t2.back();
                return true;
            }
        }
        return false;
    }

    /**
     *  改变方向
     */
    private Dir changeDir(Dir dir) {
        if (dir == Dir.DOWN){
            Dir[] dirs = {Dir.UP, Dir.LEFT, Dir.RIGHT};
            return dirs[random.nextInt(3)];
        }
        else if (dir == Dir.UP){
            Dir[] dirs = {Dir.DOWN, Dir.LEFT, Dir.RIGHT};
            return dirs[random.nextInt(3)];
        }
        else if (dir == Dir.LEFT){
            Dir[] dirs = {Dir.DOWN, Dir.UP, Dir.RIGHT};
            return dirs[random.nextInt(3)];
        }
        else{
            Dir[] dirs = {Dir.UP, Dir.LEFT, Dir.DOWN};
            return dirs[random.nextInt(3)];
        }
    }


}
