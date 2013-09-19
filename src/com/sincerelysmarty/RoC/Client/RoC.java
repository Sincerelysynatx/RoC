/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sincerelysmarty.RoC.Client;

import com.sincerelysmarty.RoC.Client.Input.MouseInput;
import com.sincerelysmarty.RoC.Client.States.MenuComponent;
import com.sincerelysmarty.RoC.Client.States.TitleMenu;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Sincerelypwnd
 */
public class RoC extends Canvas implements Runnable {

    public static final int GAME_WIDTH = 320, GAME_HEIGHT = 280, SCALE = 2;
    public static final String GAME_NAME = "Realm of Corruption";
    private static boolean running = false;
    private Screen screen;
    private static RoC game;
    private int fps = 0, UPDATES = 0;
    private Graphics g;
    private BufferStrategy bs;
    private MenuComponent currentMenu;
    private MouseInput mouseInput = new MouseInput();

    public RoC() {
        this.setPreferredSize(new Dimension(GAME_WIDTH * SCALE, GAME_HEIGHT * SCALE));
        this.setMinimumSize(new Dimension(GAME_WIDTH * SCALE, GAME_HEIGHT * SCALE));
        this.setMaximumSize(new Dimension(GAME_WIDTH * SCALE, GAME_HEIGHT * SCALE));
        this.addMouseListener(mouseInput);
    }

    public static void main(String[] args) {
        game = new RoC();
        game.init();
    }

    private void init() {
        screen = new Screen(GAME_WIDTH, GAME_HEIGHT);
        running = true;
        ImageLoader.init();



        JFrame frame = new JFrame(GAME_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(game, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        setMenu(new TitleMenu());

        new Thread(this).start();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        long lastTime1 = System.currentTimeMillis();
        int frames = 0, updates = 0;
        double unprocessed = 0;
        double nsPerTick = 1000000000.0 / 100;

        while (running) {
            long now = System.nanoTime();
            unprocessed += (now - lastTime) / nsPerTick;

            lastTime = now;

            boolean renderable = false;
            while (unprocessed >= 1) {
                updates++;
                update();
                unprocessed -= 1;
                renderable = true;
            }

            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(RoC.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (renderable) {
                frames++;
                render();
            }
            if (System.currentTimeMillis() - lastTime1 > 1000) {
                lastTime1 += 1000;
                fps = frames;
                UPDATES = updates;
                frames = 0;
                updates = 0;
            }
        }
        System.exit(0);
    }

    public void setMenu(MenuComponent menuComponent) {
        this.currentMenu = menuComponent;
        if (currentMenu != null) {
            currentMenu.init();
        }
    }

    private void update() {
        if (currentMenu != null) {
            currentMenu.update(mouseInput);
        }
        mouseInput.setPosition(getMousePosition());
        mouseInput.update();
    }

    private void render() {
        bs = this.getBufferStrategy();

        if (bs == null) {
            createBufferStrategy(3);
            requestFocus();
            return;
        }

        //BEGIN RENDERING
        screen.fill(0xFFFFFFFF);
        if (currentMenu != null) {
            currentMenu.render(screen);
        }
        Font.draw("FPS: " + fps + ", Updates: " + UPDATES, screen, 5, 5);
        //END RENDERING

        g = bs.getDrawGraphics();
        g.fillRect(0, 0, getWidth(), getHeight());
        int tempWidth = GAME_WIDTH * SCALE;
        int tempHeight = GAME_HEIGHT * SCALE;
        int w1 = (getWidth() - tempWidth) / 2;
        int h1 = (getHeight() - tempHeight) / 2;
        g.drawImage(screen.image, w1, h1, tempWidth, tempHeight, null);
        g.dispose();
        bs.show();
    }

    public static void setRunning(boolean isRun) {
        running = isRun;
    }
}
