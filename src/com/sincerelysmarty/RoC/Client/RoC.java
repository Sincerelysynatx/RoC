/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sincerelysmarty.RoC.Client;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.sincerelysmarty.RoC.Client.Packet.*;
import com.sincerelysmarty.RoC.Client.States.MainMenu;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Sean & David
 */
public class RoC extends StateBasedGame {

    private static final String gameName = "Realm of Corruption";
    public static final int menu = 0;//Main menu when launching game
    public static final int settings = 1;//Options for graphics
    public static final int play = 2;//Actual play state
    public static final int hero = 3;//Menu for viewing player stats
    public static final int abilities = 4;//Menu for selecting abilities
    public static final int skills = 5;
//    public static final int play = 1;
//    public static final int play = 1;
    private Client client;
    private Kryo kryo;

    public RoC(String gameName) {
        super(gameName);
        this.addState(new MainMenu(menu));
//        this.addState(new Settings(settings));
//        this.addState(new Play(play));
//        this.addState(new Hero(hero));
//        this.addState(new Play(play));
//        this.addState(new Play(play));
//        this.addState(new Play(play));
//        this.addState(new Play(play));
//        this.addState(new Play(play));
//        this.addState(new Play(play));
        
    }

    public static void main(String[] args) {
        AppGameContainer appgc;
        try {
            appgc = new AppGameContainer(new RoC(gameName));
            appgc.setDisplayMode(appgc.getScreenWidth(), appgc.getScreenHeight(), false);
            appgc.setFullscreen(true);
            appgc.start();
        } catch (SlickException e) {
        }
    }

    private void register() {
        kryo = client.getKryo();
        kryo.register(Packet0LoginRequest.class);
        kryo.register(Packet1LoginAnswer.class);
        kryo.register(Packet2Message.class);
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.getState(menu).init(gc, this);
        this.enterState(menu);
    }
}
