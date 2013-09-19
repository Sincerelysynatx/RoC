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
public class TitleMenu extends MenuComponent {

    private static final String name = "RoC Menu";

    @Override
    public void render(Screen screen) {
        super.render(screen);
        Font.drawL(name, screen, RoC.GAME_WIDTH / 2 - Font.getStringWidthByHalfL(name), 50);
    }

    @Override
    public void init() {
        super.init();

        int xPos = 100;
        addButton(new Button(MenuComponent.BUTTON_CONNECT_SCREEN, "Connect to Game", 0, 0, RoC.GAME_WIDTH / 2 - 64, xPos));
        addButton(new Button(MenuComponent.BUTTON_OPTIONS_SCREEN, "Options", 0, 1, RoC.GAME_WIDTH / 2 - 64, xPos + 30));
        addButton(new Button(MenuComponent.BUTTON_ABOUT_SCREEN, "About", 0, 1, RoC.GAME_WIDTH / 2 - 64, xPos + 60));
        addButton(new Button(MenuComponent.BUTTON_QUIT_SCREEN, "Quit", 0, 1, RoC.GAME_WIDTH / 2 - 64, xPos + 90));

    }
}
