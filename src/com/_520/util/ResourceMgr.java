package com._520.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *  加载图片资源
 */
public class ResourceMgr {
    private ResourceMgr(){}

    private static ResourceMgr INSTENCE = new ResourceMgr();

    public static ResourceMgr getInstance(){
        return INSTENCE;
    }
    // 坦克
    public static BufferedImage goodTankL, goodTankU, goodTankR, goodTankD;
    public static BufferedImage badTankL, badTankU, badTankR, badTankD;
    // 子弹
    public static BufferedImage bulletL, bulletD, bulletU, bulletR;
    // 爆炸效果
    public static BufferedImage[] explodes = new BufferedImage[16];
    // 墙
    public static BufferedImage square;

    static {
        try {
            goodTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodTankL = ImageUtil.rotateImage(goodTankU, -90);
            goodTankR = ImageUtil.rotateImage(goodTankU, 90);
            goodTankD = ImageUtil.rotateImage(goodTankU, 180);

            badTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badTankL = ImageUtil.rotateImage(badTankU, -90);
            badTankR = ImageUtil.rotateImage(badTankU, 90);
            badTankD = ImageUtil.rotateImage(badTankU, 180);

            bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));

            square = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/square0.jpg"));

            for (int i = 0; i < 16; i++) {
                explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader()
                        .getResourceAsStream("images/e" + (i + 1) + ".gif"));
            }

            //
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
