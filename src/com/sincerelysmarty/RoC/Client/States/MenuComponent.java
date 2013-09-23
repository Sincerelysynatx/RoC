/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sincerelysmarty.RoC.Client.States;

import com.sincerelysmarty.RoC.Client.Gui.Button;
import com.sincerelysmarty.RoC.Client.Gui.ButtonListener;
import com.sincerelysmarty.RoC.Client.Output.Image;
import com.sincerelysmarty.RoC.Client.Input.MouseInput;
import com.sincerelysmarty.RoC.Client.RoC;
import com.sincerelysmarty.RoC.Client.Output.Screen;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author 5002394184
 */
public class MenuComponent implements ButtonListener, KeyListener {

    private List<Button> buttons = new ArrayList<>();
    private Image bckgrndImg = new Image("res/tempBackground.png");
    public static String connectIP = "";
    private RoC game;

    public void render(Screen screen) {
        screen.draw(bckgrndImg.image, 0, 0);
        for (Button b : buttons) {
            b.render(screen);
        }
    }

    public void init(RoC game) {
        resetButtons();
        this.game = game;
    }

    public void update(MouseInput mouseInput) {
        for (Button b : buttons) {
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
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
    @Override
    public void buttonPressed(Button button) {
        if (button.getID() == MenuComponent.BUTTON_CONNECT_SCREEN) {
            game.setMenu(new ConnectMenu());
        } else if (button.getID() == MenuComponent.BUTTON_OPTIONS_SCREEN) {
            game.setMenu(new OptionsMenu());
        } else if (button.getID() == MenuComponent.BUTTON_ABOUT_SCREEN) {
            game.setMenu(new AboutMenu());
        } else if (button.getID() == MenuComponent.BUTTON_QUIT_) {
            RoC.setRunning(false);
        } else if (button.getID() == MenuComponent.BUTTON_BACK_) {
            game.setMenu(new MainMenu());
        }

    }
    public static final int BUTTON_CONNECT_SCREEN = 0;
    public static final int BUTTON_OPTIONS_SCREEN = 1;
    public static final int BUTTON_ABOUT_SCREEN = 2;
    public static final int BUTTON_QUIT_ = 3;
    public static final int BUTTON_BACK_ = 4;

    
}
