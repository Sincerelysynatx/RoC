/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sincerelysmarty.RoC.Client.Output;

import com.sincerelysmarty.RoC.Client.Font;
import com.sincerelysmarty.RoC.Client.RoC;
import com.sincerelysmarty.RoC.Client.Screen;
import com.sincerelysmarty.RoC.Client.States.MenuComponent;

/**
 *
 * @author Sincerelypwnd
 */
public class ParagraphOutput extends MenuComponent {

    private String text;
    private String[] lines;
    private char nextChar;
    private int index;

    public ParagraphOutput(String text, int number) {
        this.text = text;
        lines = new String[number];
        nextChar = text.charAt(0);
        index = 1;
    }

    public void nextLine() {
        String tempLine = lines[lines.length - 1];
        for (int i = lines.length - 1; i > 0; i--) {
            lines[i - 1] = lines[i];
        }
        lines[0] = tempLine;
        
        populateLine(lines.length - 1);
    }

    public void initialize() {
        for (int i = 0; i < lines.length; i++) {
            populateLine(i);
        }
    }

    private void populateLine(int line) {
        lines[line] = "";
        for (int i = 10; i < RoC.GAME_WIDTH - 10; i += 7) {
            if (index == text.length())
                break;
            lines[line] += nextChar;
            nextChar = text.charAt(index);
            index++;
        }
    }

    @Override
    public void render(Screen screen) {
        super.render(screen); //To change body of generated methods, choose Tools | Templates.
        for (int i = 0; i < lines.length; i++) {
            Font.draw(lines[i], screen, 10, 20 * i + 100);
        }
    }
}
