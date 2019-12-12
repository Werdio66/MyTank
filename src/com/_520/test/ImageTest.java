package com._520.test;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageTest {

    @Test
    void testImage() throws IOException {

        BufferedImage image = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/tankL.gif"));
        System.out.println(image);
    }
}
