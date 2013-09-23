/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sincerelysmarty.RoC.Client.States;

import com.sincerelysmarty.RoC.Client.Font;
import com.sincerelysmarty.RoC.Client.Gui.Button;
import com.sincerelysmarty.RoC.Client.RoC;
import com.sincerelysmarty.RoC.Client.Screen;
import static com.sincerelysmarty.RoC.Client.States.MenuComponent.BUTTON_BACK_;
import java.awt.event.KeyEvent;

/**
 *
 * @author 5002394184
 */
class ConnectMenu extends MenuComponent {

    private static final String name = "Connect";

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

    @Override
    public void keyTyped(KeyEvent ke) {
        //To change body of generated methods, choose Tools | Templates.
    }
}
