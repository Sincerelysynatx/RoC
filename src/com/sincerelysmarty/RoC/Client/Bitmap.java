/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sincerelysmarty.RoC.Client;

import java.util.Arrays;

/**
 *
 * @author Sincerelypwnd
 */
public class Bitmap {

    public int width, height;
    public int[] pixels;

    public Bitmap(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
    }

    public void fill(int col) {
        Arrays.fill(pixels, col);
    }
}
