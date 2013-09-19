/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sincerelysmarty.RoC.Client.States;

import com.sincerelysmarty.RoC.Client.Font;
import com.sincerelysmarty.RoC.Client.Gui.Button;
import com.sincerelysmarty.RoC.Client.RoC;
import com.sincerelysmarty.RoC.Client.Screen;

/**
 *
 * @author 5002394184
 */
public class TitleMenu extends MenuComponent{
    private static final String name = "RoC Menu";
    
    @Override
    public void render(Screen screen){
        super.render(screen);
        Font.drawL(name, screen, RoC.GAME_WIDTH / 2 - Font.getStringWidthByHalfL(name), 50);
    }
    
    @Override
    public void init(){
        super.init();
        
        addButton(new Button(0, "Connect to Game", 0, 0, RoC.GAME_WIDTH / 2 - 64, 100));
        addButton(new Button(0, "Options", 0, 1, RoC.GAME_WIDTH / 2 - 64, 150));
        addButton(new Button(0, "Quit", 1, 1, RoC.GAME_WIDTH / 2 - 64, 200));
    }
}
