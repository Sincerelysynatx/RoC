/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sincerelysmarty.RoC.Client.Input;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author 5002394184
 */
public class MouseInput implements MouseListener {

    public boolean[] currentStates = new boolean[4];
    public boolean[] nextStates = new boolean[4];
    private int x, y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isButtonDown(int button) {
        return currentStates[button];
    }

    public boolean isButtonPressed(int button) {
        return !currentStates[button] && nextStates[button];
    }

    public boolean isButtonReleased(int button) {
        return currentStates[button] && !nextStates[button];
    }

    public void setPosition(Point p) {
        if (p != null) {
            x = p.x;
            y = p.y;
        }
    }

    public void setStates(int button, boolean value) {
        nextStates[button] = value;
    }

    public void update() {
        System.arraycopy(nextStates, 0, currentStates, 0, currentStates.length);
        /*
         * for(int i = 0; i < currentStates.length; i++){
         currentStates[i] = nextStates[i];
         }
         */
    }

    public void releaseAllButtons() {
        for (int i = 0; i < currentStates.length; i++) {
            currentStates[i] = false;
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        setStates(me.getButton(), true);
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        setStates(me.getButton(), false);
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
        releaseAllButtons();
    }
}
