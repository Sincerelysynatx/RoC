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
        index = 0;
        nextChar = text.charAt(index);
    }

    public void nextLine() {
        lines[0] = "";
        for (int i = 0; i < lines.length - 1; i++) {
            lines[i] = lines[i + 1];
        }

        populateLine(lines.length - 1);
    }

    public void initialize() {
        for (int i = 0; i < lines.length; i++) {
            populateLine(i);
        }
    }

    private void populateLine(int line) {
        lines[line] = "";
        int lettersInWord = 0;
        for (int i = 10; i < RoC.GAME_WIDTH - 10; i += 7) {
            if (index == text.length() - 1) {
                break;
            }
            if (i + 7 > RoC.GAME_WIDTH - 10 && nextChar != ' ') {
                index -= lettersInWord;
                nextChar = text.charAt(index);
                String tempString = lines[line].substring(0, lines[line].length() - lettersInWord);
                lines[line] = tempString;
                break;
            }
            if (nextChar == ' ') {
                lettersInWord = 0;
            } else {
                lettersInWord++;
            }
            lines[line] += nextChar;
            index++;
            nextChar = text.charAt(index);
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
