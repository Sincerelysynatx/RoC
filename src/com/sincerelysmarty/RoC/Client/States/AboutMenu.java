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
class AboutMenu extends MenuComponent {

    public AboutMenu(){
        
    }
    
    private static final String name = "About";
    @Override
    public void render(Screen screen) {
        super.render(screen);
        Font.drawL(name, screen, RoC.GAME_WIDTH / 2 - Font.getStringWidthByHalfL(name), 50);
    }

    @Override
    public void init(RoC game) {
        super.init(game);
        addButton(new Button(BUTTON_BACK_, "Back", 1, 1, RoC.GAME_WIDTH / 2 - 64, 250));
    }
    
    
}
