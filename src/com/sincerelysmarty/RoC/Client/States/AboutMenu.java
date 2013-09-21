/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sincerelysmarty.RoC.Client.States;

import com.sincerelysmarty.RoC.Client.Font;
import com.sincerelysmarty.RoC.Client.Gui.Button;
import com.sincerelysmarty.RoC.Client.Output.ParagraphOutput;
import com.sincerelysmarty.RoC.Client.RoC;
import com.sincerelysmarty.RoC.Client.Screen;
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
        pOut = new ParagraphOutput("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum non lectus nibh. Pellentesque gravida id purus id placerat. Integer id neque vehicula, accumsan erat id, fermentum leo. Morbi venenatis quam urna, sit amet mollis metus adipiscing nec. Curabitur suscipit tincidunt lacus. Etiam lacus tortor, venenatis ac sem dapibus, vestibulum mattis est. Etiam vel congue mi. Vivamus a aliquet mi. Sed eu ullamcorper quam. Maecenas in lectus nec magna luctus molestie. Fusce sagittis mollis erat. Proin dapibus nunc tincidunt lacus vehicula, nec interdum magna tincidunt.", 5);
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
