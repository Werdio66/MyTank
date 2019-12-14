package com._520.myTank.fireStrategy;

import com._520.myTank.Tank;

/**
 * 开火策略
 */
public interface FireStrategy {
    /**
     *  开火
     * @param tank  指定的坦克
     */
    void fire(Tank tank);
}
