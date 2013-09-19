/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sincerelysmarty.RoC.Client.States;

import com.sincerelysmarty.RoC.Client.Gui.Button;
import com.sincerelysmarty.RoC.Client.Screen;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author 5002394184
 */
public class MenuComponent {

    private List<Button> buttons = new ArrayList<>();

    public void render(Screen screen) {
        for (Button b : buttons) {
            b.render(screen);
        }
    }

    public void init() {
        resetButtons();
    }

    public void update() {
    }

    private void resetButtons() {
        buttons.clear();
    }

    public void addButton(Button button) {
        buttons.add(button);
    }
}
