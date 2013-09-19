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

    public static String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
                                    + "abcdefghijklmnopqrstuvwxyz!?,.'\"    ";

    public static int getStringWidth(String str) {
        return str.length() * 29;
    }

    public static int getStringWidthByHalf(String str) {
        return (str.length() * 8) / 2;
    }

    public static void draw(String message, Screen screen, int x, int y) {
        for (int i = 0; i < message.length(); i++) {
            int index = characters.indexOf(message.charAt(i));
            if (index < 0) continue;
            screen.draw(ImageLoader.font[index % 36][index / 36], x, y);
            x += 14;
        }
    }
}
