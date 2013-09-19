/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sincerelysmarty.RoC.Client.States;

import com.sincerelysmarty.RoC.Client.Gui.Button;
import com.sincerelysmarty.RoC.Client.Gui.ButtonListener;
import com.sincerelysmarty.RoC.Client.Input.MouseInput;
import com.sincerelysmarty.RoC.Client.RoC;
import com.sincerelysmarty.RoC.Client.Screen;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author 5002394184
 */
public class MenuComponent implements ButtonListener{

    private List<Button> buttons = new ArrayList<>();
    

    public void render(Screen screen) {
        for (Button b : buttons) {
            b.render(screen);
        }
    }

    public void init() {
        resetButtons();
    }

    public void update(MouseInput mouseInput) {
        for(Button b : buttons){
            b.updateButton(mouseInput);
        }
    }

    private void resetButtons() {
        buttons.clear();
    }

    public void addButton(Button button) {
        buttons.add(button);
        button.setListener(this);
    }

    @Override
    public void buttonPressed(Button button) {
        if(button.getID() == MenuComponent.BUTTON_QUIT_SCREEN)
            RoC.setRunning(false);
    }
    
    public static final int BUTTON_CONNECT_SCREEN = 0;
    public static final int BUTTON_OPTIONS_SCREEN = 1;
    public static final int BUTTON_ABOUT_SCREEN = 2;
    public static final int BUTTON_QUIT_SCREEN = 3;
}
