package com._520.myTank.cor;

import com._520.myTank.Dir;
import com._520.myTank.GameObject;
import com._520.myTank.Wall;
import com._520.myTank.Tank;

import java.util.Random;

public class TankWallCollider implements Collider {
    private Random random = new Random();
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Wall){
            Tank t = (Tank) o1;
            Wall s = (Wall) o2;
            // 碰撞检测
            if (t.rect.intersects(s.rect)){
//                Dir dir = t.dir;
//                t.setDir(changeDir(dir));
                t.back();
                return true;
            }
        }else if (o2 instanceof Tank && o1 instanceof Wall){
            return collide(o2,o1);
        }
        return true;
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


