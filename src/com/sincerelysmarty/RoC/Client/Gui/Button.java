/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sincerelysmarty.RoC.Client.Gui;

import com.sincerelysmarty.RoC.Client.Font;
import com.sincerelysmarty.RoC.Client.ImageLoader;
import com.sincerelysmarty.RoC.Client.Input.MouseInput;
import com.sincerelysmarty.RoC.Client.Screen;
import com.sincerelysmarty.RoC.Client.States.MenuComponent;

/**
 *
 * @author 5002394184
 */
public class Button extends MenuComponent {

    public ButtonListener listener;
    public int x, y, width, height;
    public int id;
    public int imageX, imageY;
    public String message;
    public boolean isPressed, preformAction;

    public Button(int id, String message, int imageX, int imageY, int x, int y) {
        this.id = id;
        this.message = message;
        this.imageX = imageX;
        this.imageY = imageY;
        this.x = x;
        this.y = y;
        this.width = 128;
        this.height = 24;
    }

    public void setListener(ButtonListener bl) {
        this.listener = bl;
    }

    public int getID() {
        return id;
    }

    @Override
    public void render(Screen screen) {
        if(isPressed)
            screen.draw(ImageLoader.buttons[imageX == 1 ? imageX - 1 : imageX][imageY], x, y);
        else
            screen.draw(ImageLoader.buttons[imageX == 0 ? imageX + 1 : imageX][imageY], x, y);
        Font.draw(message, screen, x + (128 / 2) - Font.getStringWidthByHalf(message), y + (24 / 2) - 7);
    }

    public void updateButton(MouseInput mouseInput) {
        int mx = mouseInput.getX() / 2;
        int my = mouseInput.getY() / 2;
        isPressed = false;

        if (mx >= x && my >= y && mx < (x + width) && my < (y + height)) {
            if (mouseInput.isButtonReleased(1)) {
                click();
            } else if (mouseInput.isButtonDown(1)) {
                isPressed = true;
            }
        }
        if (preformAction) {
            if (listener != null) {
                listener.buttonPressed(this);
            }
        }
        preformAction = false;
    }

    private void click() {
        preformAction = true;
    }
}
