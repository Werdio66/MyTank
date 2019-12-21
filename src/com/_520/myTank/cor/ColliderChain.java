package com._520.myTank.cor;

import com._520.myTank.GameObject;
import java.util.LinkedList;
import java.util.List;

/**
 * 责任链
 */
public class ColliderChain implements Collider {
    // 存放碰撞策略的链条
    private List<Collider> objects = new LinkedList<>();

    public ColliderChain(){
        add(new BulletTankCollider());
        add(new TankTankCollider());
    }

    private void add(Collider collider){
        objects.add(collider);
    }

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < objects.size(); i++) {
            if (!objects.get(i).collide(o1,o2))
                return false;
        }
        return true;
    }
}
