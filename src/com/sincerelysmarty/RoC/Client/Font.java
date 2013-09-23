/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sincerelysmarty.RoC.Client;

/**
 *
 * @author Sincerelypwnd
 */
public class Font {
    
    private static Image font = new Image("res/font.png", 7, 15);
    private static Image fontL = new Image("res/font_Large.png", 14, 30);

    public static String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
                                    + "abcdefghijklmnopqrstuvwxyz!?,.'\";:  ";

    public static int getStringWidth(String str) {
        return str.length() * 7;
    }

    public static int getStringWidthByHalf(String str) {
        return (str.length() * 7) / 2;
    }
    
    public static int getStringWidthByHalfL(String str) {
        return (str.length() * 14) / 2;
    }

    public static void draw(String message, Screen screen, int x, int y) {
        for (int i = 0; i < message.length(); i++) {
            int index = characters.indexOf(message.charAt(i));
            if (index < 0) continue;
            screen.draw(font.subImage[index % 36][index / 36], x, y);
            x += 7;
        }
    }
    public static void drawL(String message, Screen screen, int x, int y) {
        for (int i = 0; i < message.length(); i++) {
            int index = characters.indexOf(message.charAt(i));
            if (index < 0) continue;
            screen.draw(fontL.subImage[index % 36][index / 36], x, y);
            x += 14;
        }
    }
}
