/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sincerelysmarty.RoC.Client;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Sincerelypwnd
 */
public class ImageLoader {

    public static Bitmap tilesPlain;
    public static Bitmap[][] tilesCut;
    public static Bitmap[][] font, fontL;
    public static Bitmap[][] buttons;

    public static void init() {
        tilesPlain = load("res/link.png");
        tilesCut = cut("res/link.png", 42, 42);
        font = cut("res/font.png", 7, 15);
        fontL = cut("res/font_Large.png", 14, 30);
        buttons = cut("res/buttons.png", 128, 24);
        
    }

    private static Bitmap[][] cut(String string, int w, int h) {
        try {
            BufferedImage bi = ImageIO.read(new File(string));
            int xTiles = bi.getWidth() / w;
            int yTiles = bi.getHeight() / h;

            Bitmap[][] b = new Bitmap[xTiles][yTiles];

            for (int x = 0; x < xTiles; x++) {
                for (int y = 0; y < yTiles; y++) {
                    b[x][y] = new Bitmap(w, h);
                    bi.getRGB(x * w, y * h, w, h, b[x][y].pixels, 0, w);
                }
            }
            return b;
        } catch (IOException e) {
        }
        return null;
    }

    private static Bitmap load(String string) {
        try {
            BufferedImage bi = ImageIO.read(new File(string));
            int width = bi.getWidth();
            int height = bi.getHeight();
            
            Bitmap b = new Bitmap(width, height);
            bi.getRGB(0, 0, width, height, b.pixels, 0, width);
            return b;
        } catch (IOException e) {
            
        }
        return null;
    }
}