/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sincerelysmarty.RoC.Client.Gui;

import com.sincerelysmarty.RoC.Client.Font;
import com.sincerelysmarty.RoC.Client.ImageLoader;
import com.sincerelysmarty.RoC.Client.Screen;
import com.sincerelysmarty.RoC.Client.States.MenuComponent;

/**
 *
 * @author 5002394184
 */
public class Button extends MenuComponent{
    public int x, y, width, height;
    public int id;
    public int imageX, imageY;
    public String message;
    
    public Button(int id, String message, int imageX, int imageY, int x, int y){
        this.id = id;
        this.message = message;
        this.imageX = imageX;
        this.imageY = imageY;
        this.x = x;
        this.y = y;
        this.width = 128;
        this.height = 24;
    }
    
    @Override
    public void render(Screen screen){
        screen.draw(ImageLoader.buttons[imageX][imageY], x, y);
        Font.draw(message, screen, x + (128 / 2) - Font.getStringWidthByHalf(message), y + (24 / 2) - 7);
    }
    
    @Override
    public void update(){
        
    }
}
