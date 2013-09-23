/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sincerelysmarty.RoC.Client.States;

import com.sincerelysmarty.RoC.Client.Output.Font;
import com.sincerelysmarty.RoC.Client.Gui.Button;
import com.sincerelysmarty.RoC.Client.Output.Image;
import com.sincerelysmarty.RoC.Client.RoC;
import com.sincerelysmarty.RoC.Client.Output.Screen;

/**
 *
 * @author 5002394184
 */
public class MainMenu extends MenuComponent {
    
    private static final String name = "Realm of Corruption";
    private Image bckgrndImg = new Image("res/tempBackground.png");

    @Override
    public void render(Screen screen) {
        screen.draw(bckgrndImg.image, 0, 0);
        super.render(screen);
        Font.drawL(name, screen, RoC.GAME_WIDTH / 2 - Font.getStringWidthByHalfL(name), 50);
    }

    @Override
    public void init(RoC game) {
        super.init(game);
        int xPos = 100;
        addButton(new Button(MenuComponent.BUTTON_CONNECT_SCREEN, "Connect to Game", 0, 0, RoC.GAME_WIDTH / 2 - 64, xPos));
        addButton(new Button(MenuComponent.BUTTON_OPTIONS_SCREEN, "Options", 0, 1, RoC.GAME_WIDTH / 2 - 64, xPos + 30));
        addButton(new Button(MenuComponent.BUTTON_ABOUT_SCREEN, "About", 0, 1, RoC.GAME_WIDTH / 2 - 64, xPos + 60));
        addButton(new Button(MenuComponent.BUTTON_QUIT_, "Quit", 0, 1, RoC.GAME_WIDTH / 2 - 64, xPos + 90));
    }
}
