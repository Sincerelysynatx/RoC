/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sincerelysmarty.RoC.Client;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 *
 * @author Sincerelypwnd
 */
public class RoC extends Canvas implements Runnable {

    public static final int GAME_WIDTH = 310, GAME_HEIGHT = 240, SCALE = 2;
    public static final String GAME_NAME = "Realm of Corruption";
    public static boolean running = false;
    public Screen screen;
    private static RoC game;
    private long lastLoopTime;
    private int delta;

    public static void main(String[] args) {
        game = new RoC();
        game.init();
    }

    private void init() {
        screen = new Screen(GAME_WIDTH, GAME_HEIGHT);
        running = true;
        ImageLoader.init();

        lastLoopTime = System.currentTimeMillis();

        game.setPreferredSize(new Dimension(GAME_WIDTH * SCALE, GAME_HEIGHT * SCALE));
        game.setMinimumSize(new Dimension(GAME_WIDTH * SCALE, GAME_HEIGHT * SCALE));
        game.setMaximumSize(new Dimension(GAME_WIDTH * SCALE, GAME_HEIGHT * SCALE));

        JFrame frame = new JFrame(GAME_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(game, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        new Thread(this).start();
    }

    @Override
    public void run() {
        while (running) {
            update();
            render();
        }
        System.exit(0);
    }

    private void update() {
        delta = (int) (System.currentTimeMillis() - lastLoopTime);
        lastLoopTime = System.currentTimeMillis();
        System.out.println(delta);
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null) {
            createBufferStrategy(3);
            requestFocus();
            return;
        }

        //BEGIN RENDERING
        screen.fill(0xffff00ff);
        screen.draw(ImageLoader.tilesCut[0][0], 0, 0);
        
        Font.draw("Hello World!", screen, 100, 100);
        //END RENDERING

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        int tempWidth = GAME_WIDTH * SCALE;
        int tempHeight = GAME_HEIGHT * SCALE;
        int w1 = (getWidth() - tempWidth) / 2;
        int h1 = (getHeight() - tempHeight) / 2;
        g.drawImage(screen.image, w1, h1, tempWidth, tempHeight, null);
        g.dispose();
        bs.show();
    }
}
