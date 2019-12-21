package com._520.myTank.cor;

import com._520.myTank.GameObject;

/**
 *  碰撞策略
 */
public interface Collider {

    /**
     *  碰撞检测
     */
    boolean collide(GameObject o1, GameObject o2);
}
