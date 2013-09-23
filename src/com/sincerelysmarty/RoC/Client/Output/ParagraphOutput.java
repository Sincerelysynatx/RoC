/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sincerelysmarty.RoC.Client.Output;

import com.sincerelysmarty.RoC.Client.Font;
import com.sincerelysmarty.RoC.Client.Image;
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
    private static Image txtBckgrnd = new Image("res/textBackground.png");
    private boolean doesHaveBackground;

    public ParagraphOutput(String text, int number, boolean doesHaveBackground) {
        this.text = text;
        this.doesHaveBackground = doesHaveBackground;
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
        for (int i = 0; i < lines.length; i++) {
            /*
            if (doesHaveBackground) {
                for (int j = 10; j < RoC.GAME_WIDTH - 10; j += 7) {
                    
                }
            }
            * */
            Font.draw(lines[i], screen, 10, 20 * i + 100);
        }
    }

    private void drawTextBackground(int bckgrndImg, Screen screen) {
        switch (bckgrndImg) {
            case 0:
                break;
            case 1:
                screen.draw(txtBckgrnd.subImage[0][0], index, index);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
        }
    }
}
