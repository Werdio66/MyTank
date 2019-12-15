package com._520.myTank.fireStrategy;

import com._520.myTank.abstractFactory.BaseTank;
import com._520.myTank.tanks.Tank;

/**
 * 开火策略
 */
public interface FireStrategy {
    /**
     *  开火
     * @param tank  指定的坦克
     */
    void fire(BaseTank tank);
}
