/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sincerelysmarty.RoC.Client.Output;

import com.sincerelysmarty.RoC.Client.RoC;
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
    private static Image txtBckgrnd = new Image("res/textBackground.png", 7, 15);
    private boolean doesHaveBackground;
    private char[][] characters;

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
        assignCharacters();
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
        if (doesHaveBackground) {
            for (int y = 0; y < characters.length; y++) {
                for (int x = 0; x < characters[y].length; x++) {
                    int tempX = (x * 7) + 10;
                    int tempY = (y * 15) + 100;
                    if (x == 0 && y == 0) {//corner
                        drawTextBackground(1, screen, tempX,tempY);
                    } else if (x == characters[y].length - 1 && y == 0) {//corner
                        drawTextBackground(3, screen, tempX,tempY);
                    } else if (x == 0 && y == characters.length - 1) {//corner
                        drawTextBackground(7, screen, tempX,tempY);
                    } else if (x == characters[y].length - 1 && y == characters.length - 1) {//corner
                        drawTextBackground(9, screen, tempX,tempY);
                    } else if (x > 0 && y == 0) {
                        drawTextBackground(2, screen, tempX,tempY);
                    } else if (x == 0 && y > 0) {
                        drawTextBackground(4, screen, tempX,tempY);
                    } else if (x == characters[y].length - 1 && y > 0) {
                        drawTextBackground(6, screen, tempX,tempY);
                    } else if (x > 0 && y == characters.length - 1) {
                        drawTextBackground(8, screen, tempX,tempY);
                    } else {
                        drawTextBackground(5, screen, tempX,tempY);
                    }
                }
            }
        }
        for (int i = 0; i < lines.length; i++) {
            Font.draw(lines[i], screen, 10, i * 15 + 100);
        }
    }

    private void assignCharacters() {
        characters = new char[lines.length][43];
        for (int y = 0; y < lines.length; y++) {
            for (int x = 0; x < lines[y].length(); x++) {
                characters[y][x] = lines[y].charAt(x);
            }
        }
    }

    private void drawTextBackground(int bckgrndImg, Screen screen, int x, int y) {
        switch (bckgrndImg) {
            case 0:
                break;
            case 1:
                screen.draw(txtBckgrnd.subImage[0][0], x, y);
                break;
            case 2:
                screen.draw(txtBckgrnd.subImage[1][0], x, y);
                break;
            case 3:
                screen.draw(txtBckgrnd.subImage[2][0], x, y);
                break;
            case 4:
                screen.draw(txtBckgrnd.subImage[0][1], x, y);
                break;
            case 5:
                screen.draw(txtBckgrnd.subImage[1][1], x, y);
                break;
            case 6:
                screen.draw(txtBckgrnd.subImage[2][1], x, y);
                break;
            case 7:
                screen.draw(txtBckgrnd.subImage[0][2], x, y);
                break;
            case 8:
                screen.draw(txtBckgrnd.subImage[1][2], x, y);
                break;
            case 9:
                screen.draw(txtBckgrnd.subImage[2][2], x, y);
                break;
        }
    }
}
