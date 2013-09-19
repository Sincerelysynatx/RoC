/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sincerelysmarty.RoC.Client;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 *
 * @author Sincerelypwnd
 */
public class Screen extends Bitmap {

    public BufferedImage image;

    public Screen(int width, int height) {
        super(width, height);
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
    }

    public void draw(Bitmap bitmap, int x, int y) {
        int x1 = x + bitmap.width;
        int y1 = y + bitmap.height;
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        if (x1 > width) {
            x1 = width;
        }
        if (y1 > height) {
            y1 = height;
        }

        for (int yPixel = y; yPixel < y1; yPixel++) {
            int tp = yPixel * width + x;
            int sp = (yPixel - y) * bitmap.width;
            tp -= sp;

            for (int currentPixel = sp; currentPixel < sp + bitmap.width; currentPixel++) {
                int color = bitmap.pixels[currentPixel];
                if (color < 0) {
                    pixels[tp + currentPixel] = color;
                }
            }
        }

    }
}
