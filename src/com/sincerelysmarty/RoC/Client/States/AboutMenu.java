/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sincerelysmarty.RoC.Client.States;

import com.sincerelysmarty.RoC.Client.Output.Font;
import com.sincerelysmarty.RoC.Client.Gui.Button;
import com.sincerelysmarty.RoC.Client.Output.ParagraphOutput;
import com.sincerelysmarty.RoC.Client.RoC;
import com.sincerelysmarty.RoC.Client.Output.Screen;
import java.awt.event.KeyEvent;

/**
 *
 * @author 5002394184
 */
class AboutMenu extends MenuComponent {

    private ParagraphOutput pOut;
    private static final String name = "About";

    @Override
    public void render(Screen screen) {
        super.render(screen);
        Font.drawL(name, screen, RoC.GAME_WIDTH / 2 - Font.getStringWidthByHalfL(name), 50);
        pOut.render(screen);
    }

    @Override
    public void init(RoC game) {
        super.init(game);
        addButton(new Button(BUTTON_BACK_, "Back", 1, 1, RoC.GAME_WIDTH / 2 - 64, 250));
        pOut = new ParagraphOutput("An apocalypse has left the world ravaged. In the wake of the destruction a corruption has begun to spread. The Corrupted are those that have been taken over by the corruption in both mind and body. They wish to spread the corruption throughout the world and unite it under the terrible and powerful influence of the filth. The Allegiance(Justicars) are those that are left of a former proud alliance of races determined to maintain the former order of the world and eradicate the corruption in its entirety and purge all affected by it to maintain a more pure world. The Ravagers seek to use the conflict to disguise their attempts to take over control of the world, and they fight to keep chaos in reign until they can achieve dominion. Soon after the Corruption appeared, a floating mechanical island disguised as a cloud materialized on the horizon. On the island lived the androids, some fell under the corruption while others decided to help the ravagers achieve their own ambitions, while most stayed under the Allegiance to maintain the balance of a perfect world.E", 5, false);
        pOut.initialize();
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        super.keyTyped(ke); //To change body of generated methods, choose Tools | Templates.
        if (ke.getKeyChar() == KeyEvent.VK_SPACE) {
            pOut.nextLine();
        }
    }
}